package com.gmail.miv;


import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Group")
public class Group {


    @XmlAttribute
    private String description;
    @XmlAttribute
    private int lenth = 0;
    @XmlElement(name = "Student", nillable = true)
    @XmlElementWrapper(name = "Students")
    private Student[] students = new Student[10];

    public Group() {

    }

    public Group(String description) {

        this.description = description;
    }

    public String findStudentBySecondName(String secondName) {

        String result = null;
        try {

            for (Student student : students) {

                // here can be exception if students[i] == null, cover by finally :)
                if (student.getSecondName().equals(secondName)) {

                    result = student.getInfo() + " was found by second name " + secondName + " in group " +
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

    public void addStudent(Student student) throws GroupIndexOutOfBoundsException {

        try {

            students[lenth] = student;
            lenth++;

        } catch (ArrayIndexOutOfBoundsException e) {

            throw new GroupIndexOutOfBoundsException("Exception <GroupIndexOutOfBoundsException> Group.addStudent: " +
                    student.getInfo() + " wasn't added.");

        } catch (Exception e) {

            throw new GroupIndexOutOfBoundsException("Exception <Some other exception> Group.addStudent: " +
                    student.getInfo() + " wasn't added.");

        }

    }

    public void deleteStudent(int index) throws GroupIndexOutOfBoundsException {

        if (index >= 0 && index < students.length) {
            Student[] copy = new Student[students.length];
            System.arraycopy(students, 0, copy, 0, index);
            System.arraycopy(students, index + 1, copy, index, students.length - index - 1);
            students = copy;
        }
        lenth--;
    }

    public void sortGroup() {
        Arrays.sort(students, 0, lenth);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLenth() {
        return lenth;
    }

    public void setLenth(int lenth) {
        this.lenth = lenth;
    }

    public String getInfo() {

        String result = "Group " + description + ":\n";

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                result += " " + i + " : " + students[i].getInfo() + "\n";
            }
        }
        return result;
    }
}
