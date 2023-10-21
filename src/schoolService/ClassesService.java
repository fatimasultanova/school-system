package schoolService;

import baseSystem.GlobalStrings;
import classes.Classes;
import globalData.GlobalData;
import inputUtils.FileUtils;
import inputUtils.InputUtil;
import schoolService.Interfaces.ClassesServiceInter;
import schoolService.Interfaces.ClassesServiceInter;
import users.Person;
import users.Student;

import java.time.LocalDateTime;

public class ClassesService implements ClassesServiceInter {
    @Override
    public void addStudentToClass() {
        InputUtil.printStudents();
        int studentId = InputUtil.inputInt("Enter id: ");
        Student selectedStudent1 = getStudentById(studentId);
        System.out.println(selectedStudent1);
        InputUtil.printClasses();
        Classes selectedClass = null;
        String selectedClassName = InputUtil.inputString("Choose class: ");
        for (int i = 0; i < GlobalData.dynamicArrayClass.size(); i++) {
            Classes classes = (Classes) GlobalData.dynamicArrayClass.get(i);
            if (classes.getName().equalsIgnoreCase(selectedClassName)) {
                selectedClass = classes;
            }
        }
        System.out.println(selectedClass);
        Classes.studentsDynamicArray.add(selectedStudent1);
        //GlobalData.dynamicArrayStudents.add(selectedStudent1);
       // selectedClass.getStudentsDynamicArray().add(selectedStudent1);
        FileUtils.saveAllClasses(GlobalStrings.SAVE_CLASS_NAME);
        System.out.println("Student: " + selectedStudent1.getName() + " " + selectedStudent1.getSurname() + " added to class: " + selectedClass.getName());
        String log = "Student with id: " + selectedStudent1.getId() + " added to class: " + selectedClass.getName() + " with name: " + selectedStudent1.getName() + " " + selectedStudent1.getSurname() + " Time: " + LocalDateTime.now() + " By : " + GlobalData.loginPerson.getName();
        FileUtils.applicationLogs(GlobalStrings.FILE_NAME, log);
    }

    private Student getStudentById(int id) {
        Student student = null;
        for (int i = 0; i < GlobalData.dynamicArrayPerson.size(); i++) {
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
