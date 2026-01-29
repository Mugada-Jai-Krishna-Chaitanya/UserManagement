package com.example.usermanagement.model;

public class User {
    private final Long Id;
    private final String Name;
    private final String Email;

    public User(Long id, String name, String email) {
        Id = id;
        Name = name;
        Email = email;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

}
