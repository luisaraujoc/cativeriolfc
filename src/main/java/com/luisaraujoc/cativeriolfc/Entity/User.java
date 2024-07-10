package com.luisaraujoc.cativeriolfc.Entity;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;

import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable {


    private Long id;

    private String username;

    private String password;

    private Boolean status;

    private Person person;

    public User() {}

    public User(Long id, String username, String password, Boolean status, Long person_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        if (person_id != null) {
            this.person = DaoFactory.createPersonDao().findById(person_id);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", person=" + person +
                '}';
    }
}
