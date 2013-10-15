/*
 * %W% %E%
 *
 * Copyrith (c) 2013, iBLISS Segurança & Inteligência
 * Todos os direitos reservados.
 *
 */
package br.jrrombaldo.nmap.xml;

public class XMLParseException
    extends Exception
{

	private static final long serialVersionUID = -1194750798673016993L;

	public XMLParseException (final Throwable t)
	{
		super(t);
	}

	public XMLParseException (final String m, final Throwable t)
	{
		super(m, t);
	}

}
