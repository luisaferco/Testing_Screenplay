package co.com.webapps.screenplay.exceptions;

public class IncorrectPriceException extends AssertionError {

    public IncorrectPriceException(String detailMessage) {
        super(detailMessage);
    }
}
