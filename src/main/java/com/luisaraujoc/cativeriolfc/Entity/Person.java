package com.luisaraujoc.cativeriolfc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

//    private Date birthDate;

    private String surname;

    public Person(Integer id, String fullName, String surname) {
        this.id = id;
        this.fullName = fullName;
//        this.birthDate = birthDate;
        this.surname = surname;
    }
}
