package br.jrrombaldo.nmap.result.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import br.jrrombaldo.nmap.util.IpUtils;

public class HostEntity implements Serializable, Comparable<HostEntity> {

    private static final long serialVersionUID = -4139584317609851868L;

    private Long ip;

    private List<ServiceEntity> services;

    private String OS;

    private String type;

    private String fqdn;

    private String netbios;

    private String name;

    private Set<String> addresses;

    @Override
    public int hashCode() {
	return ip.intValue();
    }

//    @Override
    public int compareTo(final HostEntity o) {
	return (ip).compareTo(o.getIp() == null ? null : o.getIp());
    }

    @Override
    public String toString() {
	return IpUtils.getInstance().intToIp(ip.longValue());
    }

    public Long getIp() {
	return ip;
    }

    public String getIpStr() {
	return ip == null ? "" : IpUtils.getInstance().intToIp(ip);
    }

    public void setIp(final Long ip) {
	this.ip = ip;
    }

    public List<ServiceEntity> getServices() {
	return services;
    }

    public void setServices(final List<ServiceEntity> services) {
	this.services = services;
    }

    public String getOS() {
	return OS;
    }

    public void setOS(final String oS) {
	OS = oS;
    }

    public String getFqdn() {
	return fqdn;
    }

    public void setFqdn(final String fqdn) {
	this.fqdn = fqdn;
    }

    public String getNetbios() {
	return netbios;
    }

    public void setNetbios(final String netbios) {
	this.netbios = netbios;
    }

    public String getType() {
	return type;
    }

    public void setType(final String type) {
	this.type = type;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }


    public Set<String> getAddresses() {
	return addresses;
    }

    public void setAddresses(final Set<String> addresses) {
	this.addresses = addresses;
    }

}
