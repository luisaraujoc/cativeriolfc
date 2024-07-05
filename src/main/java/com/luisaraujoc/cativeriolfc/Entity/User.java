package com.luisaraujoc.cativeriolfc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;

    public User(Integer id, String name, String email, String password, Person person) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.person = person;
    }
}
