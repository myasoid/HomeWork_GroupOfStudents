package com.gmail.miv;


import java.io.Serializable;

public class Student extends Human implements Comparable, Serializable {

    private String specialization;

    public Student(String name, String secondName, String specialization) {
        super(name, secondName);

        this.specialization = specialization;
    }

    @Override
    public String getInfo() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                "secondName='" + super.getSecondName() + '\'' +
                "specialization='" + specialization + '\'' +
                '}';
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public int compareTo(Object o) {

        if (o == null){
            return -1;
        }

        Student s = (Student) o;
        int result = 0;
        result = this.getSecondName().compareTo(s.getSecondName());
        if (result == 0){
            result = this.getName().compareTo(s.getName());
        }
        return result;
    }
}
