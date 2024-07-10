package com.luisaraujoc.cativeriolfc.DTO;

import com.luisaraujoc.cativeriolfc.Entity.User;

public class UserRequest {
    private User user;
    private Long personId;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
