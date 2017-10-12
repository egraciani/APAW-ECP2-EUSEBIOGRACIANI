package es.upm.miw.api.dtos;

import java.util.List;

import es.upm.miw.api.entities.Hotel;

public class HotelReservationListDto {

    private HotelDto hotelDto;

    private List<Integer> reservationList;

    public HotelReservationListDto() {
    }

    public HotelReservationListDto(Hotel hotel, List<Integer> reservationList) {
        hotelDto = new HotelDto(hotel);
        this.reservationList = reservationList;
    }

    public HotelDto getThemeDto() {
        return hotelDto;
    }

    public List<Integer> getVoteList() {
        return reservationList;
    }

    @Override
    public String toString() {
        return "{" + hotelDto + "," + reservationList + "}";
    }

}
