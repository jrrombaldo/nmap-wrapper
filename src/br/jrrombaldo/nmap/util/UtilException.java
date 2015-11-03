package br.jrrombaldo.nmap.util;

public class UtilException extends Exception {

    private static final long serialVersionUID = 7170157206681158524L;

    public UtilException(final Throwable e) {
	super(e);
    }

    public UtilException(final String s, final Throwable e) {
	super(s, e);
    }

    public UtilException(final String s) {
	super(s);
    }
}
