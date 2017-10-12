package es.upm.miw.api.resources.exceptions;

public class HotelFieldInvalidException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Nombre del hotel no encontrado";

    public HotelFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public HotelFieldInvalidException() {
        this("");
    }

}
