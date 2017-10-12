package es.upm.miw.api.dtos;

import es.upm.miw.api.entities.Hotel;

public class HotelDto {
    
    private int id;

    private String name;

    public HotelDto() {
    }

    public HotelDto(Hotel hotel) {
        id = hotel.getId();
        name = hotel.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\"}";
    }

}
