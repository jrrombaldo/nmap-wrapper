package br.jrrombaldo.nmap.result.entity;

import java.io.Serializable;

public class ServiceEntity implements Serializable, Comparable<ServiceEntity> {

    private static final long serialVersionUID = 1554180592247531357L;

    private Integer serviceId;

    private Integer port;

    private String protocol;

    private HostEntity host;

    private String service;

    private String version;

    public boolean equals(final Object obj) {
	final ServiceEntity se = (ServiceEntity) obj;
	return (this.port.equals(se.getPort()) && this.protocol.equals(se
		.getProtocol()));
    }

    public int compareTo(final ServiceEntity o) {
	final int i = this.port.compareTo(Integer.valueOf(o.getPort()));
	if (i != 0) {
	    return i;
	}
	return this.protocol.compareTo(o.getProtocol());
    }

    public Integer getServiceId() {
	return serviceId;
    }

    public void setServiceId(final Integer serviceId) {
	this.serviceId = serviceId;
    }

    public Integer getPort() {
	return port;
    }

    public void setPort(final Integer port) {
	this.port = port;
    }

    public String getProtocol() {
	return protocol;
    }

    public void setProtocol(final String protocol) {
	this.protocol = protocol;
    }

    public HostEntity getHost() {
	return host;
    }

    public void setHost(final HostEntity host) {
	this.host = host;
    }

    public String getService() {
	return service;
    }

    public void setService(final String service) {
	this.service = service;
    }

    public String getVersion() {
	return version;
    }

    public void setVersion(final String version) {
	this.version = version;
    }

}
