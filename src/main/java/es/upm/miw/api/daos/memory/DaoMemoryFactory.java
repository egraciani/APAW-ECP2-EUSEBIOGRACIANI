package es.upm.miw.api.daos.memory;

import es.upm.miw.api.daos.DaoFactory;
import es.upm.miw.api.daos.HotelDao;
import es.upm.miw.api.daos.ReservationDao;

public class DaoMemoryFactory extends DaoFactory {

    private HotelDao hotelDao;

    private ReservationDao reservationDao;

    @Override
    public HotelDao getThemeDao() {
        if (hotelDao == null) {
            hotelDao = new HotelDaoMemory();
        }
        return hotelDao;
    }

    @Override
    public ReservationDao getVoteDao() {
        if (reservationDao == null) {
            reservationDao = new ReservationDaoMemory();
        }
        return reservationDao;
    }

}
