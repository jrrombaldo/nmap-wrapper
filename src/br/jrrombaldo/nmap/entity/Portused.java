//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.06.08 at 07:08:15 PM BRT 
//

package br.jrrombaldo.nmap.entity;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "portused")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
public class Portused
{

	@XmlAttribute(name = "state", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected String state;
	@XmlAttribute(name = "proto", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected String proto;
	@XmlAttribute(name = "portid", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected String portid;

	/**
	 * Gets the value of the state property.
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public String getState ()
	{
		return state;
	}

	/**
	 * Sets the value of the state property.
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public void setState (String value)
	{
		this.state = value;
	}

	/**
	 * Gets the value of the proto property.
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public String getProto ()
	{
		return proto;
	}

	/**
	 * Sets the value of the proto property.
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public void setProto (String value)
	{
		this.proto = value;
	}

	/**
	 * Gets the value of the portid property.
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public String getPortid ()
	{
		return portid;
	}

	/**
	 * Sets the value of the portid property.
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public void setPortid (String value)
	{
		this.portid = value;
	}

}
