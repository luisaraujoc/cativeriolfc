package com.luisaraujoc.cativeriolfc.DTO;

import com.luisaraujoc.cativeriolfc.Entity.User;
import com.luisaraujoc.cativeriolfc.Entity.Person;

import java.io.Serializable;

public class UserRequest implements Serializable {
    private User user;
    private Person Person;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person person) {
        Person = person;
    }
}
