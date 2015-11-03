package br.jrrombaldo.nmap.exception;

public class PortScannerException
    extends Exception
{

	private static final long serialVersionUID = 3625712131852234051L;

	public PortScannerException (final Throwable e)
	{
		super(e);
	}

	public PortScannerException (final String s, final Throwable e)
	{
		super(s, e);
	}

	public PortScannerException (final String s)
	{
		super(s);
	}
}
