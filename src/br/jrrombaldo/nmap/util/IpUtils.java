package br.jrrombaldo.nmap.util;

import java.math.BigInteger;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.net.util.SubnetUtils;

public class IpUtils {

    protected long ipMax;
    protected long ipMin;

    protected String iprgx = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
    private final Pattern regexIp = Pattern.compile("^" + iprgx + "$");
    private final Pattern regexIpRange = Pattern.compile("^" + iprgx
	    + "/\\d{1,2}$");
    private final Pattern regexIpFromTo = Pattern.compile("^" + iprgx
	    + "\\-{1}" + iprgx + "$");

    /**
     * Parse IP/CDDIR/Network to Number format
     * 
     * @param ipStr
     * @return
     * @throws UtilException
     */
    public IpUtils(final String ipStr) throws UtilException {
	try {

	    if (!validateIp(ipStr)) {
		throw new UtilException("ip  inválido -> " + ipStr);
	    }

	    if (ipStr.contains("/")) {
		final SubnetUtils sbutil = new SubnetUtils(ipStr);
		sbutil.setInclusiveHostCount(true);

		ipMax = ipToInt(sbutil.getInfo().getHighAddress());
		ipMin = ipToInt(sbutil.getInfo().getLowAddress());
	    } else if (ipStr.contains("-")) {
		final String[] atoms = ipStr.split("-");
		ipMax = ipToInt(atoms[1]);
		ipMin = ipToInt(atoms[0]);
	    } else {
		ipMax = ipToInt(ipStr);
		ipMin = ipToInt(ipStr);
	    }

	} catch (final Exception ex) {
	    throw new UtilException("unexpected error", ex);
	}
    }

    public IpUtils() {
    }

    public static IpUtils getInstance(final String ipStr) throws UtilException {
	return new IpUtils(ipStr);
    }

    public static IpUtils getInstance() {
	return new IpUtils();
    }

    public long ipToInt(final String ipAddress) {
	try {

	    final String[] ips = ipAddress.split("\\.");

	    final BigInteger ip1 = new BigInteger(ips[0]).multiply(BigInteger
		    .valueOf(16777216));
	    final long ip2 = Integer.valueOf(ips[1]) * 65536;
	    final long ip3 = Integer.valueOf(ips[2]) * 256;
	    final long ip4 = Integer.valueOf(ips[3]);

	    return ip1.longValue() + ip2 + ip3 + ip4;

	} catch (final Exception e) {
	    e.printStackTrace();

	    return 0;
	}
    }

    public String intToIp(final BigInteger ipAddress) {
	return intToIp(ipAddress.longValue());
    }

    public String intToIp(final long ipAddress) {
	final long octet1 = (ipAddress & 0xFF000000) >>> 24;
	final long octet2 = (ipAddress & 0xFF0000) >>> 16;
	final long octet3 = (ipAddress & 0xFF00) >>> 8;
	final long octet4 = ipAddress & 0xFF;

	// octet1 = octet1 > 254 ? 254 : octet1;
	// octet2 = octet2 > 254 ? 254 : octet2;
	// octet3 = octet3 > 254 ? 254 : octet3;
	// octet4 = octet4 > 254 ? 254 : octet4;

	return new StringBuffer().append(octet1).append('.').append(octet2)
		.append('.').append(octet3).append('.').append(octet4)
		.toString();
    }

    public List<String> testIpInRange() throws UtilException {
	try {
	    final List<String> ipsAtivos = new ArrayList<String>();
	    for (long i = ipMin; i <= ipMax; i++) {

		final String address = intToIp(i);
		final InetAddress ip = InetAddress.getByName(address);

		if (ip.isReachable(100)) {
		    ipsAtivos.add(address);
		}
	    }
	    return ipsAtivos;
	} catch (final Exception ex) {
	    throw new UtilException(ex);
	}
    }

    public boolean validateIp(final String ipStr) throws UtilException {

	try {
	    if (ipStr == null) {
		return false;
	    }

	    String tmp = ipStr.replace("-", ".");
	    final String[] tmp2 = tmp.split("/");

	    if (tmp2.length == 2 && Integer.valueOf(tmp2[1]).intValue() > 32) {
		return false;
	    } else {
		tmp = tmp.replace("/", ".");
		final String[] atoms = tmp.split("\\.");
		for (int i = 0; i < atoms.length; i++) {
		    if (Integer.valueOf(atoms[i]).intValue() > 255) {
			return false;
		    }
		}
	    }

	    if (regexIp.matcher(ipStr).matches()) {
		return true;
	    } else if (regexIpRange.matcher(ipStr).matches()) {
		return true;
	    } else if (regexIpFromTo.matcher(ipStr).matches()) {
		return true;
	    }

	} catch (final Exception ex) {
	    throw new UtilException(ex);
	}
	return false;
    }

    public long getIpMax() {
	return ipMax;
    }

    public void setIpMax(final int ipMax) {
	this.ipMax = ipMax;
    }

    public long getIpMin() {
	return ipMin;
    }

    public void setIpMin(final int ipMin) {
	this.ipMin = ipMin;
    }

    public static void main(final String[] args) {

	try {

	    final IpUtils ip = new IpUtils("10.225.84.0/22");
	    System.out.println((ip.getIpMin()));
	    System.out.println(IpUtils.getInstance().intToIp(ip.getIpMin())
		    + "\n");
	    System.out.println((ip.getIpMax()));
	    System.out.println((IpUtils.getInstance().intToIp(ip.getIpMax()))
		    + "\n");

	} catch (final Exception ex) {
	    ex.printStackTrace();
	}

    }

}
