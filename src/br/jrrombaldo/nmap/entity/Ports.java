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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"extraports", "port"})
@XmlRootElement(name = "ports")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
public class Ports
{

	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected List<Extraports> extraports;
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	protected List<Port> port;

	/**
	 * Gets the value of the extraports property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present inside the
	 * JAXB object. This is why there is not a <CODE>set</CODE> method for the extraports
	 * property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getExtraports().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link br.jrrombaldo.nmap.entity.Extraports }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public List<Extraports> getExtraports ()
	{
		if (extraports == null)
		{
			extraports = new ArrayList<Extraports>();
		}
		return this.extraports;
	}

	/**
	 * Gets the value of the port property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present inside the
	 * JAXB object. This is why there is not a <CODE>set</CODE> method for the port
	 * property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPort().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link br.jrrombaldo.nmap.entity.Port }
	 */
	@Generated(value = "com.sun.tools.xjc.Driver", date = "2011-06-08T07:08:15-03:00")
	public List<Port> getPort ()
	{
		if (port == null)
		{
			port = new ArrayList<Port>();
		}
		return this.port;
	}

}
