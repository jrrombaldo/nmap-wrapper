package br.jrrombaldo.nmap.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.transform.JDOMSource;
import org.xml.sax.SAXException;

public class XMLParser<T> {

    private boolean _includeHeader;
    private JAXBContext _ctx;

    private Namespace nameSpace;

    /*
     * validate the XML against the XSD
     */
    private static boolean _validate = false;

    public XMLParser(final Class<?> objCLass) throws XMLParseException {
	try {
	    _ctx = JAXBContext.newInstance(objCLass);
	    _includeHeader = true;
	    nameSpace = null;
	} catch (final JAXBException e) {
	    throw new XMLParseException("impossible to create XML content", e);
	}

    }

    public String beanToXML(final T obj) throws XMLParseException {
	try {
	    final Marshaller marsh = _ctx.createMarshaller();
	    marsh.setProperty("com.sun.xml.bind.xmlDeclaration", _includeHeader);

	    final OutputStream outStream = new ByteArrayOutputStream();
	    marsh.marshal(obj, outStream);

	    return outStream.toString();

	} catch (final JAXBException e) {
	    throw new XMLParseException("impossible to parse XML", e);
	}
    }

    public T XMLToBean(final String xml) throws XMLParseException {
	return XMLToBean(xml);
    }

    @SuppressWarnings("unchecked")
    public T XMLToBean(final String xml, final String charsetName)
	    throws XMLParseException {
	try {
	    final Unmarshaller unmarsh = _ctx.createUnmarshaller();
	    byte[] bytes;
	    if (charsetName != null) {
		bytes = Charset.forName(charsetName).encode(xml).array();
	    } else {
		bytes = xml.getBytes();
	    }

	    final InputStream inStream = new ByteArrayInputStream(bytes);

	    final SAXBuilder sb = new SAXBuilder(false);
	    final Document doc = sb.build(inStream);
	    if (nameSpace != null) {
		setNamespace(doc.getRootElement(), nameSpace, true);
	    }

	    final Source src = new JDOMSource(doc);

	    if (_validate) {

		unmarsh.setSchema(SchemaFactory.newInstance(
			XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(
			new StreamSource(getClass().getResourceAsStream(
				"nessus.xsd"))));
	    }
	    return (T) unmarsh.unmarshal(src);

	} catch (final JAXBException e) {
	    throw new XMLParseException("error on parse XML to BEAN", e);
	} catch (final IOException e) {
	    throw new XMLParseException("error on parse XML to BEAN", e);
	} catch (final JDOMException e) {
	    throw new XMLParseException("error on parse XML to BEAN", e);
	} catch (final SAXException e) {
	    throw new XMLParseException("unexpected XML format", e);
	} catch (final Exception e) {
	    throw new XMLParseException("XML validaton failed", e);
	}
    }

    private static void setNamespace(final Element elem, final Namespace ns,
	    final boolean recurse) {
	elem.setNamespace(ns);
	if (recurse) {
	    for (final Object o : elem.getChildren()) {
		setNamespace((Element) o, ns, recurse);
	    }
	}
    }

    public boolean is_includeHeader() {
	return _includeHeader;
    }

    public void set_includeHeader(final boolean _includeHeader) {
	this._includeHeader = _includeHeader;
    }

    public Namespace getNameSpace() {
	return nameSpace;
    }

    public void setNameSpace(final String ns) {
	this.nameSpace = Namespace.getNamespace(ns);
    }

}
