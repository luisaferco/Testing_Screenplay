package co.com.webapps.screenplay.exceptions;

public class NotFoundFileException extends AssertionError {

    public NotFoundFileException(String message) {
        super(message);
    }

    public NotFoundFileException(Throwable cause) {
        super(cause);
    }

    public NotFoundFileException(String s, Throwable e) {
        super(s,e);
    }
}
