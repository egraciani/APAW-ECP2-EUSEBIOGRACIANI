package es.upm.miw.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.dtos.HotelDto;
import es.upm.miw.api.entities.Hotel;
import es.upm.miw.api.dtos.HotelReservationListDto;

public class HotelController {

    public List<HotelDto> themeList() {
        List<Hotel> hotelList = DaoFactory.getFactory().getHotelDao().findAll();
        List<HotelDto> hotelDtoList = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            hotelDtoList.add(new HotelDto(hotel));
        }
        return hotelDtoList;
    }

    public void createHotel(String hotelName) {
        DaoFactory.getFactory().getHotelDao().create(new Hotel(hotelName));
    }

    private boolean existHotelId(int hotelId) {
        return DaoFactory.getFactory().getHotelDao().read(hotelId) != null;
    }

    // java 8: con Optional se expresa que podría no encontrarse el valor, mejor que provocar null y mejor que provocar exception
    public Optional<Double> hotelOverage(int hotelId) {
        if (existHotelId(hotelId)) {
            List<Integer> reservationList = DaoFactory.getFactory().getReservationDao().findValueByHotelId(hotelId);
            if (reservationList.isEmpty()) {
                return Optional.of(Double.NaN);
            } else {
                double total = 0;
                for (Integer value : reservationList) {
                    total += value;
                }
                return Optional.of(total / reservationList.size());
            }
        } else {
            return Optional.empty();
        }
    }

    public Optional<HotelReservationListDto> hotelVotes(int hotelId) {
        if (existHotelId(hotelId)) {
            List<Integer> reservationList = DaoFactory.getFactory().getReservationDao().findValueByHotelId(hotelId);
            return Optional.of(new HotelReservationListDto(DaoFactory.getFactory().getHotelDao().read(hotelId), reservationList));
        } else {
            return Optional.empty();
        }
    }

    public Optional<HotelDto> readHotel(int hotelId) {
       if (existHotelId(hotelId)) {
            return Optional.of(new HotelDto(DaoFactory.getFactory().getHotelDao().read(hotelId)));
        } else {
            return Optional.empty();
        }
    }

}
