package es.upm.miw.api.daos;

import java.util.List;

import es.upm.miw.api.entities.Reservation;

public interface ReservationDao extends GenericDao<Reservation, Integer> {

    List<Integer> findValueByHotelId(int hotelId);
    
}
