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
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "taskbegin")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
public class Taskbegin
{

	@XmlAttribute(name = "task", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected String task;
	@XmlAttribute(name = "time", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected String time;
	@XmlAttribute(name = "extrainfo")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected String extrainfo;

	/**
	 * Gets the value of the task property.
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public String getTask ()
	{
		return task;
	}

	/**
	 * Sets the value of the task property.
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public void setTask (String value)
	{
		this.task = value;
	}

	/**
	 * Gets the value of the time property.
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public String getTime ()
	{
		return time;
	}

	/**
	 * Sets the value of the time property.
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public void setTime (String value)
	{
		this.time = value;
	}

	/**
	 * Gets the value of the extrainfo property.
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public String getExtrainfo ()
	{
		return extrainfo;
	}

	/**
	 * Sets the value of the extrainfo property.
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public void setExtrainfo (String value)
	{
		this.extrainfo = value;
	}

}
