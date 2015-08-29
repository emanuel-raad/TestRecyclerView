package com.example.emanuel.testrecyclerview;

import java.util.UUID;

/**
 * Created by Emanuel on 28/08/2015.
 */
public class Model {

    private UUID uuid;
    private String name;
    private int number;

    public Model(String name, int number) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public UUID getUUID() {
        return uuid;
    }
}
