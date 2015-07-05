package com.gmail.miv;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.*;

public class Main {

    final static String PACKAGE = Main.class.getPackage().getName();

    final static String FILE_PATH = "./tmp/groups.xml";

    private static Scanner sc = new Scanner(System.in);

    private static ListOfGroups groups = new ListOfGroups();

    private static Group currentGroup;

    public static void main(String[] args) {


        getDataFromFile();

        while (true) {
            int option = getOption();
            switch (option) {
                case 1:

                    System.out.println(groups);

                    break;

                case 2:

                    sc.nextLine();
                    System.out.print(" ID: ");
                    int id = Integer.valueOf(sc.nextLine());
                    System.out.print(" Description: ");
                    String desc = sc.nextLine();

                    groups.addGroup(desc, id);

                    break;

                case 3:

                    sc.nextLine();
                    System.out.print(" id: ");
                    id = Integer.valueOf(sc.nextLine());

                    groups.removeByID(id);

                    saveDataToFile();

                    break;

                case 4:

                    sc.nextLine();
                    System.out.print(" id: ");
                    id = Integer.valueOf(sc.nextLine());
                    currentGroup = groups.getGroupByID(id);

                    break;

                case 5:

                    System.out.println(currentGroup);

                    break;
                case 6:

                    try {
                        sc.nextLine();
                        System.out.print(" Name: ");
                        String name = sc.nextLine();
                        System.out.print(" Second name: ");
                        String secondName = sc.nextLine();
                        System.out.print(" Specialization: ");
                        String specialization = sc.nextLine();

                        Student s = new Student(name, secondName, specialization);
                        currentGroup.addStudent(s);
                    } catch (GroupIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }

                    break;
                case 7:
                    try {
                        currentGroup.sortGroup();
                    } catch (GroupIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }

                    break;
                case 8:

                    try {
                        System.out.print(" Index: ");
                        int index = sc.nextInt();

                        currentGroup.deleteStudent(index);

                    } catch (GroupIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }

                    break;

                case 9:

                    System.out.print(" Second name: ");
                    String secondName = sc.nextLine();
                    System.out.println(currentGroup.findStudentBySecondName(secondName));

                    break;

                case 10:

                    groups.addGroup(currentGroup);
                    saveDataToFile();

                    currentGroup = null;

                    break;

                default:
                    break;
            }

            if (option == 11) {
                break;
            }

        }

        saveDataToFile();

    }

    private static int getOption() {

        if (currentGroup == null) {
            System.out.println("1 - list of groups; 2 - add group; 3 - delete group; 4 - select group; 11 - quit");
        } else {
            System.out.println(currentGroup);
            System.out.println("5 - Group info; 6 - add student; 7 - sort student; 8 - delete student; " +
                    "9 - find by second name; 10 - save & quit group; 11 - quit");
        }

        int option = sc.nextInt();

        return option;

    }

    private static void getDataFromFile() {

        File file = new File(FILE_PATH);

        if (file.exists()) {
            try {

                JAXBContext jc = JAXBContext.newInstance(Main.PACKAGE);

                Unmarshaller um = jc.createUnmarshaller();

                groups = (ListOfGroups) um.unmarshal(file);

            } catch (JAXBException e) {
                // e.printStackTrace();
                groups = new ListOfGroups();
            }
        }

    }

    private static void saveDataToFile() {

        try {

            JAXBContext jc = JAXBContext.newInstance(Main.PACKAGE);

            Marshaller m = jc.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(groups, new File(FILE_PATH));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
