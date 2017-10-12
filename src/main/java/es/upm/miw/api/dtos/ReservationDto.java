package es.upm.miw.api.dtos;

import es.upm.miw.api.entities.Reservation;

public class ReservationDto {

    private String hotelName;

    private int reservationValue;

    public ReservationDto() {
    }

    public ReservationDto(Reservation reservation) {
        this.hotelName = reservation.getHotel().getName();
        this.reservationValue = reservation.getValue();
    }

    public String getThemeName() {
        return hotelName;
    }

    public void setThemeName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getReservationValue() {
        return reservationValue;
    }

    public void setReservationValue(int reservationValue) {
        this.reservationValue = reservationValue;
    }

    @Override
    public String toString() {
        return "{\"hotelName\":\"" + hotelName + ",\"reservationValue\":" + reservationValue + "}";
    }

}
