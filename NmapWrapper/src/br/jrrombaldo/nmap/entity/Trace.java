//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.06.08 at 07:08:15 PM BRT 
//

package br.jrrombaldo.nmap.entity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"hop"})
@XmlRootElement(name = "trace")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
public class Trace
{

	@XmlAttribute(name = "proto")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected String proto;
	@XmlAttribute(name = "port")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected String port;
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected List<Hop> hop;

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
	 * Gets the value of the port property.
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public String getPort ()
	{
		return port;
	}

	/**
	 * Sets the value of the port property.
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public void setPort (String value)
	{
		this.port = value;
	}

	/**
	 * Gets the value of the hop property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present inside the
	 * JAXB object. This is why there is not a <CODE>set</CODE> method for the hop
	 * property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getHop().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link br.jrrombaldo.nmap.entity.Hop }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public List<Hop> getHop ()
	{
		if (hop == null)
		{
			hop = new ArrayList<Hop>();
		}
		return this.hop;
	}

}
