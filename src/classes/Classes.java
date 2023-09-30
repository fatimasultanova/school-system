package classes;

import dynamicArrays.DynamicArray;
import users.Person;


import java.io.Serializable;

public class Classes implements Serializable {
    private static final long serialVersionUID = 2384521069861473841L;
    private String name;
    private DynamicArray<Person> studentsDynamicArray;

    public Classes() {

    }

    public Classes(String name, DynamicArray<Person> studentsDynamicArray) {
        this.name = name;
        this.studentsDynamicArray = studentsDynamicArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DynamicArray<Person> getStudentsDynamicArray() {
        return studentsDynamicArray;
    }

    public void setStudentsDynamicArray(DynamicArray<Person> studentsDynamicArray) {
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
