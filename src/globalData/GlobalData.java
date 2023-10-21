package globalData;

import baseSystem.GlobalStrings;
import classes.Classes;
import inputUtils.FileUtils;
import schoolService.ClassesService;
import schoolService.Interfaces.ClassesServiceInter;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class GlobalData implements Serializable {
    public static ArrayList<Person> dynamicArrayPerson = new ArrayList<>();
    public static ArrayList<Classes> dynamicArrayClass = new ArrayList<>();
   // public static ArrayList<Student> dynamicArrayStudents = new ArrayList<>();

    public static int id;
    //public static Object personDynamicArray;
    public static Person loginPerson = null;

    //public static ClassesDynamic classesDynamic ;

    static {


        dynamicArrayPerson.add(new Student(0, "email", "student0", "1234", "student", "ss", LocalDate.of(2007, 1, 1)));
        dynamicArrayPerson.add(new Student(1, "email", "student1", "1234", "student", "ss", LocalDate.of(2008, 1, 1)));
        dynamicArrayPerson.add(new Student(2, "email", "student2", "1234", "student", "ss", LocalDate.now()));
        dynamicArrayPerson.add(new Student(3, "email", "student3", "1234", "student", "ss", LocalDate.now()));


        dynamicArrayPerson.add(new Teacher(4, "email", "teacher4", "123", new Classes(), 7000, "studentTtt", "admin", LocalDate.now()));
        dynamicArrayPerson.add(new Teacher(5, "email", "teacher5", "123", new Classes(), 7000, "admin", "admin", LocalDate.now()));
        dynamicArrayPerson.add(new Teacher(4, "email", "teacher6", "123", new Classes(), 7000, "admin", "admin", LocalDate.now()));

        dynamicArrayPerson.add(new Admin(7, "email", "admin", "123", 7000, "admin", "admin", LocalDate.now()));

       // Classes classes = new Classes();
        // ClassesServiceInter classesService = new ClassesService();
     //   classes.setName("11A");
        // classesService.addStudentToClass();
     //   dynamicArrayClass.add(classes);


   //  dynamicArrayStudents.add(new Student(0, "email", "student0", "1234", "student", "ss", LocalDate.of(2007, 1, 1)));
//        Classes.studentsDynamicArray.add((Student) dynamicArrayPerson.get(0));
//        Classes classes = new Classes();
//        classes.setName("11A");
//        classes.setStudentsDynamicArray(Classes.studentsDynamicArray);
//
//       dynamicArrayClass.add(classes);


        FileUtils.saveAll(GlobalStrings.SAVE_FILE_NAME);
        FileUtils.saveAllClasses(GlobalStrings.SAVE_CLASS_NAME);
//

//


//        dynamicArrayClass = FileUtils.readAllClasses(GlobalStrings.SAVE_CLASS_NAME);
//        dynamicArrayPerson = FileUtils.readAll(GlobalStrings.SAVE_FILE_NAME);
//        id = GlobalData.dynamicArrayPerson.size();
//

    }

}
