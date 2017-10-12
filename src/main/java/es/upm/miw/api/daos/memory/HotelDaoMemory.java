package es.upm.miw.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.api.daos.HotelDao;
import es.upm.miw.api.entities.Hotel;

public class HotelDaoMemory extends GenericDaoMemory<Hotel> implements HotelDao {

    public HotelDaoMemory() {
        this.setMap(new HashMap<Integer, Hotel>());
    }

    @Override
    protected Integer getId(Hotel entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Hotel entity, Integer id) {
        entity.setId(id);

    }

}
