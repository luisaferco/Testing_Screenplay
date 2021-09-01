package co.com.webapps.screenplay.exceptions;

import net.serenitybdd.core.exceptions.CausesCompromisedTestFailure;
import net.serenitybdd.core.exceptions.SerenityManagedException;

public class DriverFailException extends SerenityManagedException implements CausesCompromisedTestFailure {

    public static final String FAILED_CONNECTION_DRIVER = "Failed the driver's connection";

    public DriverFailException(String message, Throwable cause) {
        super(message, cause);
    }

}
