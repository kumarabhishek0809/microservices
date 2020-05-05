package com.kumar.registrationService.model;

import java.io.Serializable;


public class Person implements Serializable {

    private static final long serialVersionUID = 4L;

    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
