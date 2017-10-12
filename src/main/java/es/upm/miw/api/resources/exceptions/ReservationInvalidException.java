package es.upm.miw.api.resources.exceptions;

public class ReservationInvalidException extends Exception {
    private static final long serialVersionUID = -5173361541880534566L;

    public static final String DESCRIPTION = "El valor de la reserva debe estar entre 0 y 10";

    public ReservationInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public ReservationInvalidException() {
        this("");
    }

}
