package com.luisaraujoc.cativeriolfc.Entity;

public class Guest {

    private Long id;
    private String name;
    private Person host;

    // Constructors
    public Guest() {
    }

    public Guest(String name, Person host) {
        this.name = name;
        this.host = host;
    }

    // Getters and Setters
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

    public Person getHost() {
        return host;
    }

    public void setHost(Person host) {
        this.host = host;
    }

    // toString method
    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", host=" + host.toString() +
                '}';
    }
}
