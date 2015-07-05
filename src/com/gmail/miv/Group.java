package com.gmail.miv;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Group")
public class Group {

    @XmlAttribute
    private int id;

    @XmlAttribute
    private String description;

    public Group(String description, int id) {
        this.description = description;
        this.id = id;
    }

    public Group() {
    }

    @XmlElement(name = "Student", nillable = true)
    @XmlElementWrapper(name = "Students")
    private List<Student> students = new ArrayList<>();

    public String findStudentBySecondName(String secondName) {

        String result = null;
        try {

            for (Student student : students) {

                // here can be exception if students[i] == null, cover by finally :)
                if (student.getSecondName().equals(secondName)) {

                    result = student + " was found by second name " + secondName + " in group " +
                            description;
                }
            }
        } catch (Exception e) {
            result = "Nobody was found by second name " + secondName + " in group " + description;
        } finally {

            if (result == null) {
                result = "Nobody was found by second name " + secondName + " in group " + description;
            }
        }

        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addStudent(Student student) throws GroupIndexOutOfBoundsException {

        try {
            students.add(student);
        } catch (ArrayIndexOutOfBoundsException e) {

            throw new GroupIndexOutOfBoundsException("Exception <GroupIndexOutOfBoundsException> Group.addStudent: " +
                    student + " wasn't added.");

        } catch (Exception e) {

            throw new GroupIndexOutOfBoundsException("Exception <Some other exception> Group.addStudent: " +
                    student + " wasn't added.");

        }

    }

    public void deleteStudent(int index) throws GroupIndexOutOfBoundsException {
        students.remove(index);
    }

    public void sortGroup() {
        Collections.sort(students);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        return id == group.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", students=" + students +
                '}';
    }

}
