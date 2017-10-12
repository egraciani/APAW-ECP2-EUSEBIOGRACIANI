package es.upm.miw.api.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.api.daos.ReservationDao;
import es.upm.miw.api.entities.Reservation;

public class ReservationDaoMemory extends GenericDaoMemory<Reservation> implements ReservationDao {

    public ReservationDaoMemory() {
        this.setMap(new HashMap<Integer, Reservation>());
    }

    @Override
    protected Integer getId(Reservation entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Reservation entity, Integer id) {
        entity.setId(id);
    }

    @Override
    public List<Integer> findValueByThemeId(int hotelId) {
        List<Reservation> reservations = this.findAll();
        List<Integer> reservationsValue = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getHotel().getId() == hotelId) {
                reservationsValue.add(reservation.getValue());
            }
        }
        return reservationsValue;
    }

}
