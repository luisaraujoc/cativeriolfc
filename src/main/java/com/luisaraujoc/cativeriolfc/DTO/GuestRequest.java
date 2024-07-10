package com.luisaraujoc.cativeriolfc.DTO;

import com.luisaraujoc.cativeriolfc.Entity.Person;

public class GuestRequest {
    private String guestName;
    private Person host;

    // Getters and Setters
    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Person getHost() {
        return host;
    }

    public void setHost(Person host) {
        this.host = host;
    }
}
