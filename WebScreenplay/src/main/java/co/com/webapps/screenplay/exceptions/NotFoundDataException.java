package co.com.webapps.screenplay.exceptions;

public class NotFoundDataException  extends NullPointerException {

    public static final String NOT_FOUND_OBJECT_CONSULT = "No se encontró el objeto en el archivo";

    public NotFoundDataException(String s) {
        super(s);
    }
}
