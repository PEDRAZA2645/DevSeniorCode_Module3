package com.devsenior.amoreno.model;

import java.time.LocalDate;

public class User {
    private String id;
    private String name;
    private String email;
    private LocalDate registeredDate;

    public User(String id, String name, String email) {
        this(id, name, email, LocalDate.now());
    }

    public User(String id, String name, String email, LocalDate registeredDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registeredDate = registeredDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
