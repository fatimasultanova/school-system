package inputUtils;


import classes.Classes;
import globalData.GlobalData;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;

import java.util.Scanner;

public class InputUtil {
    public static String inputString(String title) {
        Scanner input = new Scanner(System.in);
        System.out.println(title);
        return input.nextLine();
    }

    public static int inputInt(String title) {
        Scanner input = new Scanner(System.in);
        System.out.println(title);
        return input.nextInt();
    }

    public static double inputDouble(String title) {
        Scanner input = new Scanner(System.in);
        System.out.println(title);
        return input.nextDouble();
    }

    public static boolean printUsers() {
        boolean isFounded = false;
        for (int i = 0; i < GlobalData.dynamicArrayPerson.getSize(); i++) {
            Person person = GlobalData.dynamicArrayPerson.get(i);
            if (person instanceof Student) {
                isFounded = true;
                Student student = (Student) person;
                System.out.println(student);
            }

            if (person instanceof Teacher) {
                isFounded = true;
                Teacher teacher = (Teacher) person;
                System.out.println(teacher);
            }
        }
        return isFounded;
    }

    public static boolean printUnblocks() {
        boolean isFounded = false;
        for (int i = 0; i < GlobalData.dynamicArrayPerson.getSize(); i++) {
            Person person = GlobalData.dynamicArrayPerson.get(i);
            if (person instanceof Student) {
                isFounded = true;
                Student student = (Student) person;
                if (!student.isBlocked()) {
                    System.out.println(student);
                }
            }

            if (person instanceof Teacher) {
                isFounded = true;
                Teacher teacher = (Teacher) person;
                if (!teacher.isBlocked())
                    System.out.println(teacher);
            }
        }
        return isFounded;
    }


    public static boolean printBlocks() {
        boolean isFounded = false;
        for (int i = 0; i < GlobalData.dynamicArrayPerson.getSize(); i++) {
            Person person = GlobalData.dynamicArrayPerson.get(i);
            if (person instanceof Student) {
                isFounded = true;
                Student student = (Student) person;
                if (student.isBlocked()) {
                    System.out.println(student);
                }
            }

            if (person instanceof Teacher) {
                isFounded = true;
                Teacher teacher = (Teacher) person;
                if (teacher.isBlocked())
                    System.out.println(teacher);
            }
        }
        return isFounded;
    }

    public static boolean printStudents() {
        boolean isFounded = false;
        for (int i = 0; i < GlobalData.dynamicArrayPerson.getSize(); i++) {
            Person person = GlobalData.dynamicArrayPerson.get(i);
            if (person instanceof Student) {
                isFounded = true;
                Student student = (Student) person;
                System.out.println(student);
            }
        }
        return isFounded;
    }

    public static void printClasses() {
        for (int i = 0; i < GlobalData.dynamicArrayClass.getSize(); i++) {
            Classes classes = GlobalData.dynamicArrayClass.get(i);
            System.out.println(classes.getName());
        }

    }
}


