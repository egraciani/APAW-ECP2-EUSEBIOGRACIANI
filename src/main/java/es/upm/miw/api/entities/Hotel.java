package es.upm.miw.api.entities;

import java.util.ArrayList;

public class Hotel {
    private long id;

    private String name;

    private Category category;

    private ArrayList<Reservation> reservations;

    public Hotel() {
        this.id = 0;
        this.name = "";
        this.reservations = new ArrayList<Reservation>();
    }

    public Hotel(long id) {
        this.id = id;
        this.reservations = new ArrayList<Reservation>();
    }

    public Hotel(long id, String name) {
        this.id = id;
        this.name = name;
        this.reservations = new ArrayList<Reservation>();
    }

    public Integer getId() {
        return (int) id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Reservation getReservation(Integer index) {
        return reservations.get(index);
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

}
