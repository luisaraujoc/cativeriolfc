package com.luisaraujoc.cativeriolfc.Entity;

import java.io.Serializable;
import java.util.Objects;

import com.luisaraujoc.cativeriolfc.Enum.Role;

public class Person implements Serializable {

    private Long id;
    private String name;
    private String cpf;
    private String tel;
    private Role kindUser;

    public Person() {}

    public Person(String name, String cpf, String tel, Role kindUser) {
        this.name = name;
        this.cpf = cpf;
        this.tel = tel;
        this.kindUser = kindUser;
    }

    public Person(Long id, String name, String cpf, String tel, Role kindUser) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.tel = tel;
        this.kindUser = kindUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Role getKindUser() {
        return kindUser;
    }

    public void setKindUser(Role kindUser) {
        this.kindUser = kindUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", tel='" + tel + '\'' +
                ", kindUser='" + kindUser + '\'' +
                '}';
    }
}
