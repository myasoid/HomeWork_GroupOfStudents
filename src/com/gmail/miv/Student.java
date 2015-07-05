package com.gmail.miv;


public class Student extends Human implements Comparable {

    private String specialization;

    public Student() {
        super();
    }

    public Student(String name, String secondName, String specialization) {
        super(name, secondName);

        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return !(specialization != null ? !specialization.equals(student.specialization) : student.specialization != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (specialization != null ? specialization.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {

        if (o == null) {
            return -1;
        }

        Student s = (Student) o;
        int result = 0;
        result = this.getSecondName().compareTo(s.getSecondName());
        if (result == 0) {
            result = this.getName().compareTo(s.getName());
        }
        return result;
    }

}
