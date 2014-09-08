package ar.com.candoit.vga.business.exception;

public class BusinessException extends Exception {

    public BusinessException(Exception e) {
	super(e);
    }

    private static final long serialVersionUID = 1L;
}
