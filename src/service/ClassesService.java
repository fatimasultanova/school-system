package service;

import baseSystem.GlobalStrings;
import classes.Classes;
import globalData.GlobalData;
import inputUtils.FileUtils;
import inputUtils.InputUtil;
import service.Interfaces.ClassesServiceInter;
import users.Person;
import users.Student;

import java.time.LocalDateTime;

public class ClassesService implements ClassesServiceInter {
    @Override
    public void addStudentToClass() {
        InputUtil.printStudents();
        int studentId = InputUtil.inputInt("Enter id: ");
        Student selectedStudent1 = getStudentById(studentId);
        InputUtil.printClasses();
        Classes selectedClass = null;
        String selectedClassName = InputUtil.inputString("Choose class: ");
        for (int i = 0; i < GlobalData.dynamicArrayClass.getSize(); i++) {
            Classes classes = (Classes) GlobalData.dynamicArrayClass.get(i);
            if (classes.getName().equalsIgnoreCase(selectedClassName)){
                selectedClass=classes;
            }
        }
        selectedClass.getStudentsDynamicArray().add(selectedStudent1);
        System.out.println("Student: "+ selectedStudent1.getName() +" " + selectedStudent1.getSurname() + " added to class: "+selectedClass.getName());
        String log = "Student with id: "+selectedStudent1.getId()+" added to class: "  +selectedClass.getName() + " with name: "+selectedStudent1.getName() +" " + selectedStudent1.getSurname() + " Time: "+ LocalDateTime.now()+ " By : " + GlobalData.loginPerson.getName();
        FileUtils.applicationLogs(GlobalStrings.FILE_NAME,log);
    }
    private Student getStudentById(int id) {
        Student student = null;
        for (int i = 0; i < GlobalData.dynamicArrayPerson.getSize(); i++) {
            Person person = (Person) GlobalData.dynamicArrayPerson.get(i);
            if (person instanceof Student) {
                Student selectedStudent = (Student) person;
                if (selectedStudent.getId() == id) {
                    student = selectedStudent;
                    return student;
                }
            }
        }
        return student;
    }
}
