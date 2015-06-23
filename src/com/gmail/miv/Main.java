package com.gmail.miv;


import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Group group = null;

        try {
            FileInputStream fileIn = new FileInputStream("./tmp/group.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            group = (Group) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }

        if (group == null) {
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

        try (FileOutputStream fileOut = new FileOutputStream("./tmp/group.ser")) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(group);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/group.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }


    }
}
