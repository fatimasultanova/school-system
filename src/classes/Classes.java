package classes;
import users.Person;
import users.Student;


import java.io.Serializable;
import java.util.ArrayList;

public class Classes implements Serializable {
  //  private static final long serialVersionUID = 2384521069861473841L;
    private String name;
    public static ArrayList<Student> studentsDynamicArray;

    public Classes() {

    }

    public Classes(String name, ArrayList<Student> studentsDynamicArray) {
        this.name = name;
        this.studentsDynamicArray = studentsDynamicArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudentsDynamicArray() {
        return studentsDynamicArray;
    }

    public void setStudentsDynamicArray(ArrayList<Student> studentsDynamicArray) {
        this.studentsDynamicArray = studentsDynamicArray;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "name='" + name + '\'' +
                ", studentsDynamicArray=" + studentsDynamicArray +
                '}';
    }
}
