package com.gmail.miv;


abstract public class Human {

    private String name;
    private String secondName;

    public String getName() {
        return name;
    }

    public Human() {
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
