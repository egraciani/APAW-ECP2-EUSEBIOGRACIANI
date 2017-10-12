package es.upm.miw.api.entities;

import java.util.Calendar;

public class Reservation {
    private long id;
    
    private String client;
    
    private Calendar date;

    public long getId() {
        return id;
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
    
}
