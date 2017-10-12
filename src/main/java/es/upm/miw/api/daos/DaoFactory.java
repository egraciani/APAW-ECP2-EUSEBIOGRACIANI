package es.upm.miw.api.daos;

import es.upm.miw.api.entities.Hotel;

public abstract class DaoFactory {

    private static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }

    public abstract HotelDao getThemeDao();

    public abstract ReservationDao getVoteDao();

    public GenericDao<Hotel, Integer> getHotelDao() {
        // TODO Auto-generated method stub
        return null;
    }

}
