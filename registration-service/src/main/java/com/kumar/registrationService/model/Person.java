package com.kumar.registrationService.model;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;


public class Person implements Serializable {

    private static final long serialVersionUID = 4L;

    private int id;
    private String name;

    @Value("${some.key:true}")
    private boolean booleanWithDefaultValue;

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
