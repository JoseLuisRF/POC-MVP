package com.hector.pocmvp.model;

/**
 * Created by hetorres on 2/12/16.
 */
public class User {
    private String firstName;
    private String lastName;
    private int edad;

    public User(String firstName, String lastName, int edad) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.edad = edad;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEdad() {
        return edad;
    }
}
