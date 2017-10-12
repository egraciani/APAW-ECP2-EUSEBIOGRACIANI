package es.upm.miw.api.resources;

import java.util.List;
import java.util.Optional;

import es.upm.miw.api.controllers.HotelController;
import es.upm.miw.api.dtos.HotelDto;
import es.upm.miw.api.dtos.HotelReservationListDto;
import es.upm.miw.api.resources.exceptions.HotelFieldInvalidException;
import es.upm.miw.api.resources.exceptions.HotelIdNotFoundException;

public class HotelResource {

    public static final String HOTELS = "hotels";

    public static final String ID = "/{id}";

    public static final String ID_OVERAGE = ID + "/overage";

    public static final String ID_RESERVATIONS = ID + "/reservations";

    public List<HotelDto> hotelList() {
        return new HotelController().hotelList();
    }

    public HotelDto readHotel(int hotelId) throws HotelIdNotFoundException {
        Optional<HotelDto> optional = new HotelController().readHotel(hotelId);
        return optional.orElseThrow(() -> new HotelIdNotFoundException(Integer.toString(hotelId)));
    }

    public void createHotel(String hotelName) throws HotelFieldInvalidException {
        this.validateField(hotelName);
        new HotelController().createHotel(hotelName);
    }

    public Double themeOverage(int hotelId) throws HotelIdNotFoundException {
        Optional<Double> optional = new HotelController().hotelOverage(hotelId);
        return optional.orElseThrow(() -> new HotelIdNotFoundException(Integer.toString(hotelId)));
    }

    public HotelReservationListDto hotelReservationList(int hotelId) throws HotelIdNotFoundException {
        Optional<HotelReservationListDto> optional = new HotelController().hotelReservations(hotelId);
        return optional.orElseThrow(() -> new HotelIdNotFoundException(Integer.toString(hotelId)));
    }

    private void validateField(String field) throws HotelFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new HotelFieldInvalidException(field);
        }
    }

}
