package com.gmail.miv;


import java.io.Serializable;

abstract public class Human implements Serializable{

    private String name;
    private String secondName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Human(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    abstract public String getInfo();
}
