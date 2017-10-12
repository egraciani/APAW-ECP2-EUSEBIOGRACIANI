package es.upm.miw.api.resources.exceptions;

public class HotelIdNotFoundException extends Exception {
    private static final long serialVersionUID = -3893110892899234744L;

    public static final String DESCRIPTION = "El id del hotel no existe";

    public HotelIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public HotelIdNotFoundException() {
        this("");
    }
}
