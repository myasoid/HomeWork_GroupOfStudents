package com.gmail.miv;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Scanner;

public class Main {

    final static String PACKAGE = Main.class.getPackage().getName();

    public static void main(String[] args) {

        Group group = null;

        String fileName = "./tmp/group.xml";

        File file = new File(fileName);

        if (file.exists()) {
            try {

                JAXBContext jc = JAXBContext.newInstance(Main.PACKAGE);

                Unmarshaller um = jc.createUnmarshaller();

                group = (Group) um.unmarshal(file);

            } catch (JAXBException e) {
                e.printStackTrace();
                return;
            }
        } else {
            group = new Group("Some group");
        }


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Group info; 2 - add student; 3 - sort student; 4 - delete student; " +
                    "5 - find by second name; 6 - quit");
            int option = sc.nextInt();
            switch (option) {
                case 1:

                    System.out.println(group.getInfo());

                    break;
                case 2:

                    try {
                        sc.nextLine();
                        System.out.print(" Name: ");
                        String name = sc.nextLine();
                        System.out.print(" Second name: ");
                        String secondName = sc.nextLine();
                        System.out.print(" Specialization: ");
                        String specialization = sc.nextLine();

                        Student s = new Student(name, secondName, specialization);
                        group.addStudent(s);
                    } catch (GroupIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    try {
                        group.sortGroup();
                    } catch (GroupIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }

                    System.out.println(group.getInfo());

                    break;
                case 4:

                    try {
                        System.out.print(" Index: ");
                        int index = sc.nextInt();

                        group.deleteStudent(index);

                    } catch (GroupIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }

                    break;

                case 5:

                    System.out.print(" Second name: ");
                    String secondName = sc.nextLine();
                    System.out.println(group.findStudentBySecondName(secondName));

                    break;

                default:
                    break;
            }

            if (option == 6) {
                break;
            }

        }

        try {

            JAXBContext jc = JAXBContext.newInstance(Main.PACKAGE);

            Marshaller m = jc.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(group, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
