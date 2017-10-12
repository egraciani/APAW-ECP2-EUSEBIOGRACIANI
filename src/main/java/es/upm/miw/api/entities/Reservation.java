package es.upm.miw.api.entities;

import java.util.Calendar;

public class Reservation {
    private long id;
    
    private String client;
    
    private Calendar date;

    public Integer getId() {
        return (int) id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Reservation getHotel() {
        // TODO Auto-generated method stub
        return null;
    }

    public Integer getValue() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

}
