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
@XmlRootElement(name = "tcpsequence")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
public class Tcpsequence
{

	@XmlAttribute(name = "index", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected String index;
	@XmlAttribute(name = "difficulty", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected String difficulty;
	@XmlAttribute(name = "values", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected String values;

	/**
	 * Gets the value of the index property.
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public String getIndex ()
	{
		return index;
	}

	/**
	 * Sets the value of the index property.
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public void setIndex (String value)
	{
		this.index = value;
	}

	/**
	 * Gets the value of the difficulty property.
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public String getDifficulty ()
	{
		return difficulty;
	}

	/**
	 * Sets the value of the difficulty property.
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public void setDifficulty (String value)
	{
		this.difficulty = value;
	}

	/**
	 * Gets the value of the values property.
	 * @return possible object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public String getValues ()
	{
		return values;
	}

	/**
	 * Sets the value of the values property.
	 * @param value allowed object is {@link String }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public void setValues (String value)
	{
		this.values = value;
	}

}