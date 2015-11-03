package br.jrrombaldo.nmap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import br.jrrombaldo.nmap.entity.Address;
import br.jrrombaldo.nmap.entity.Host;
import br.jrrombaldo.nmap.entity.Nmaprun;
import br.jrrombaldo.nmap.entity.Os;
import br.jrrombaldo.nmap.entity.Osclass;
import br.jrrombaldo.nmap.entity.Osmatch;
import br.jrrombaldo.nmap.entity.Port;
import br.jrrombaldo.nmap.exception.PortScannerException;
import br.jrrombaldo.nmap.result.entity.HostEntity;
import br.jrrombaldo.nmap.result.entity.ServiceEntity;
import br.jrrombaldo.nmap.util.IpUtils;
import br.jrrombaldo.nmap.xml.XMLParser;

public class PortScannerWrapper
{
    
    /*
     * Choose your own
     */
    public static final String PATH = "/tmp/namp/";
    
	protected Process process;

	protected String getIp (final Host host) throws PortScannerException
	{
		try
		{
			if (host != null && host.getAddress() != null)
			{
				for (final Address addr : host.getAddress())
				{
					if ("ipv4".equalsIgnoreCase(addr.getAddrtype()))
					{
						return addr.getAddr();
					}
				}
	    }
	    return "";
	} catch (final Exception e)
		{
			throw new PortScannerException(e);
		}
	}

	protected String getOs (final Host host) throws PortScannerException
	{
		try
		{
			if (host != null && host.getOs() != null)
			{
				final Os os = host.getOs();

				if (os.getOsmatch() != null && os.getOsmatch().size() > 0)
				{
					if (os.getOsmatch().size() == 1)
					{
						return os.getOsmatch().get(0).getName();
					}
					else
					{
						Collections.sort(os.getOsmatch(), new OsMatchComparator());
						Collections.reverse(os.getOsmatch());
						int i = 0;
						final int acc = Integer.valueOf(os.getOsmatch().get(0).getAccuracy());

						final StringBuilder sb = new StringBuilder();

						while (i < os.getOsmatch().size() && acc == Integer.valueOf(os.getOsmatch().get(i).getAccuracy()))
						{
							if (sb.length() > 0)
							{
								sb.append(os.getOsmatch().get(i).getName());
								sb.append("; ");
							}
							else
							{
								sb.append(os.getOsmatch().get(i).getName());
							}

							i++;
						}
						return sb.toString();
					}
				}
			}
			return "";
		}
		catch (final Exception e)
		{
			throw new PortScannerException(e);
		}
	}

	protected String getFileName () throws PortScannerException
	{
		try
		{
			

			final Path path = Paths.get(PATH);
			if (!Files.exists(path))
			{
				Files.createDirectory(path);
			}

			return PATH + new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss-SSS").format(new Date()) + "--portsacnner.xml";
		}
		catch (Exception e)
		{
			throw new PortScannerException("erro on mount the path and file name", e);
		}
	}

	protected String makeCommand (final String target, final String parameters, final String fileOut) throws PortScannerException
	{
		final StringBuilder sb = new StringBuilder();
		sb.append(PATH);
		sb.append(" ");
		sb.append(target);
		sb.append(" -oX ");
		sb.append(fileOut);
		sb.append(" ");
		sb.append(parameters);
		return sb.toString();
	}

	protected void removeFileOut (final String fileOut)
	{
		try
		{
			final Path path = Paths.get(fileOut);
			if (Files.exists(path))
			{
				final boolean del = Files.deleteIfExists(path);
				if (del)
				{
					System.out.println("file removed ->" + fileOut);
				}
				else
				{
				    System.err.println("file not removed->" + fileOut);
				}
			}
		}
		catch (final Exception e)
		{
		    e.printStackTrace();
		}
	}

	protected String getFileContent (final String fileOut) throws PortScannerException
	{
		try
		{

			final StringBuilder fileData = new StringBuilder();
			final BufferedReader readerFile = new BufferedReader(new FileReader(fileOut));
			char[] buf = new char[1024];
			int numRead = 0;
			while ((numRead = readerFile.read(buf)) != -1)
			{
				final String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
			readerFile.close();
			return fileData.toString();
		}
		catch (final Exception e)
		{
			throw new PortScannerException("erro ao ler arquivo de resultados do portscanner", e);
		}
	}

	protected Nmaprun run2 (final String target, final String parameters) throws PortScannerException
	{
		final String fileOut = getFileName();
		try
		{
			final String cmd = makeCommand(target, parameters, fileOut);

			System.out.println("executando portscanner -> " + cmd);

			process = Runtime.getRuntime().exec(cmd);
			new StreamGobbler(process.getInputStream(), false).start();
			new StreamGobbler(process.getErrorStream(), true).start();

			final int procResult = process.waitFor();

			if (procResult == 0)
			{
				System.out.println("portscanner executado com sucesso");
			}
			else
			{
				System.err.println("portscanner terminou retornando" + procResult);
			}

			if (Files.exists(Paths.get(fileOut)))
			{
				final XMLParser<Nmaprun> parser = new XMLParser<Nmaprun>(Nmaprun.class);
				return parser.XMLToBean(getFileContent(fileOut));
			}
			else
			{
				return null;
			}

		}
		catch (final Exception e)
		{
			throw new PortScannerException("erro ao executar o scanner", e);
		}
		finally
		{
			removeFileOut(fileOut);
		}
	}

	public List<HostEntity> run (final String target, final String parameters) throws PortScannerException
	{
		final Nmaprun nmap = run2(target, parameters);

		if (nmap == null || nmap.getHost() == null)
		{
			return new ArrayList<HostEntity>(0);// Rever
		}

		final List<HostEntity> hosts = new ArrayList<HostEntity>(nmap.getHost().size());

		for (final Host hostn : nmap.getHost())
		{

			final HostEntity host = new HostEntity();
			host.setIp(IpUtils.getInstance().ipToInt(getIp(hostn)));
			host.setOS(getOs(hostn));
			hosts.add(host);

			host.setServices(new ArrayList<ServiceEntity>());

			for (final Port port : hostn.getPorts().getPort())
			{
				final ServiceEntity service = new ServiceEntity();
				service.setHost(host);
				service.setPort(Integer.valueOf(port.getPortid()));
				service.setProtocol(port.getProtocol());
				service.setService(port.getService().getName() + port.getService().getProduct() != null ? " (" + port.getService().getProduct() +
				    ") " : "");
				service.setVersion(port.getService().getVersion());
				host.getServices().add(service);
			}

			if (hostn.getHostnames() != null && hostn.getHostnames().getHostname() != null)
			{

				final StringBuilder sb = new StringBuilder();
				for (int i = 0; i < hostn.getHostnames().getHostname().size(); i++)
				{
					sb.append(hostn.getHostnames().getHostname().get(i));
					if (i != hostn.getHostnames().getHostname().size() - 1)
					{
						sb.append(", ");
					}

				}
			}
		}

		return hosts;
	}

	public static void main (final String[] args)
	{
		final PortScannerWrapper p = new PortScannerWrapper();
		try
		{
			// LogManager.configLogs("");

			final List<HostEntity> n = p.run("200.221.2.45/30", "-O -sV -F -R");

			for (final HostEntity host : n)
			{
				System.out.println(host.getIp() + "\t" + host.getOS() + "\t" + host.getName());

				for (final ServiceEntity port : host.getServices())
				{
					System.out.println(port.getPort() + "\t" + port.getProtocol() + "\t" + port.getService() + "\t" + port.getVersion());
				}
				System.out.println();
			}

		}
		catch (final Exception e)
		{
			e.printStackTrace(); // To change body of catch statement use File |
			                     // Settings | File Templates.
		}
	}
}

class OsMatchComparator
    implements Comparator<Osmatch>
{
//	@Override
	public int compare (final Osmatch o1, final Osmatch o2)
	{
		return o1.getAccuracy().compareTo(o2.getAccuracy());
	}
}

class OsClassComparator
    implements Comparator<Osclass>
{
//	@Override
	public int compare (final Osclass o1, final Osclass o2)
	{
		return o1.getAccuracy().compareTo(o2.getAccuracy());
	}
}

class StreamGobbler
    extends Thread
{
	InputStream is;
	boolean error;

	StreamGobbler (final InputStream is, final boolean error)
	{
		this.is = is;
		this.error = error;
	}

	@Override
	public void run ()
	{
		try
		{
			final InputStreamReader isr = new InputStreamReader(is);
			final BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
			{
				if (error)
				{
					System.err.println(line);
				}
				else
				{
					System.out.println(line);
				}
			}
		}
		catch (final Exception ioe)
		{
			
		}
	}
}
