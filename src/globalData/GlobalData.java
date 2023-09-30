package globalData;
import baseSystem.GlobalStrings;
import classes.Classes;
import dynamicArrays.DynamicArray;
import inputUtils.FileUtils;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;

import java.io.Serializable;
import java.time.LocalDate;

public class GlobalData implements Serializable {
    public static DynamicArray<Person> dynamicArrayPerson = new DynamicArray<>();
    public static DynamicArray<Classes> dynamicArrayClass = new DynamicArray<>();

    public static int id;
    //public static Object personDynamicArray;
    public static Person loginPerson = null;

    //public static ClassesDynamic classesDynamic ;

    static {


//
//        dynamicArrayPerson.add(new Student(0,"email","student0","1234","student","ss", LocalDate.of(2007,1,1)));
//        dynamicArrayPerson.add(new Student(1,"email","student1","1234","student","ss", LocalDate.of(2008,1,1)));
//        dynamicArrayPerson.add(new Student(2,"email","student2","1234","student","ss", LocalDate.now()));
//        dynamicArrayPerson.add(new Student(3,"email","student3","1234","student","ss", LocalDate.now()));
//
//        dynamicArrayPerson.add(new Admin(4,"email","admin","123",7000,"admin","admin", LocalDate.now()));
//       dynamicArrayPerson.add(new Teacher(5,"email","teacher","123",new Classes(),7000,"studentTtt","admin", LocalDate.now()));
//        dynamicArrayPerson.add(new Teacher(6,"email","teacher","123",new Classes(),7000,"admin","admin", LocalDate.now()));
//       dynamicArrayPerson.add(new Teacher(3,"email","admin","123", new Classes(),7000,"admin","admin", LocalDate.now()));
//
//        Classes classes = new Classes();
//        classes.setName("11A");
//        classes.setStudentsDynamicArray(new DynamicArray<Person>());
//        dynamicArrayClass.add(classes);
//                Classes classes = new Classes();
//        classes.setName("11A");
//        classes.setStudentsDynamicArray(new DynamicArray<Person>());
//        dynamicArrayClass.add(classes);
        dynamicArrayClass = FileUtils.readAllClasses(GlobalStrings.SAVE_CLASS_NAME);

        dynamicArrayPerson =  FileUtils.readAll(GlobalStrings.SAVE_FILE_NAME);
        id=dynamicArrayPerson.getSize();



    }

}
