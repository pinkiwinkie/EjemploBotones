package com.example.ejemplobotones;

public class User {
    private String name, surnames;

    public User(String name, String surnames) {
        this.name = name;
        this.surnames = surnames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    @Override
    public String toString() {
        return name + " " + surnames;
    }
}
