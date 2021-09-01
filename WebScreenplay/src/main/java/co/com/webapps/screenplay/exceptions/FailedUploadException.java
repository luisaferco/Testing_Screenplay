package co.com.webapps.screenplay.exceptions;

public class FailedUploadException extends AssertionError {

    public FailedUploadException(String detailMessage) {
        super(detailMessage);
    }
}
