package es.upm.miw.api.resources;

import java.util.List;

import es.upm.miw.api.controllers.ReservationController;
import es.upm.miw.api.dtos.ReservationDto;
import es.upm.miw.api.resources.exceptions.HotelIdNotFoundException;
import es.upm.miw.api.resources.exceptions.ReservationInvalidException;

public class ReservationResource {

    public static final String VOTES = "votes";

    public void createVote(int themeId, int vote) throws ReservationInvalidException, HotelIdNotFoundException {
        if (vote < 0 || vote > 10) {
            throw new ReservationInvalidException(Integer.toString(vote));
        }
        if (!new ReservationController().createReservation(hotelId, reservation)) {
            throw new HotelIdNotFoundException(Integer.toString(hotelId));
        }
    }

    public List<ReservationDto> reservationList() {
        return new ReservationController().reservationList();
    }

}
