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

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (name != null ? !name.equals(human.name) : human.name != null) return false;
        return !(secondName != null ? !secondName.equals(human.secondName) : human.secondName != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        return result;
    }
}
