package service;

import baseSystem.GlobalStrings;
import classes.Classes;
import globalData.GlobalData;
import inputUtils.FileUtils;
import service.Interfaces.ClassesServiceInter;
import service.Interfaces.TeacherServiceInter;
import users.Person;
import users.Student;

public class TeacherService implements TeacherServiceInter {
    ClassesServiceInter classesService = new ClassesService();

    @Override
    public void seeAllStudents() {
        for (int i = 0; i < GlobalData.dynamicArrayPerson.getSize(); i++) {
            Person person = GlobalData.dynamicArrayPerson.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println(student.getDetailForTeacher());
            }
        }
    }

    @Override
    public void seeAllClasses() {
        for (int i = 0; i < GlobalData.dynamicArrayClass.getSize(); i++) {
            Classes classes = GlobalData.dynamicArrayClass.get(i);
            System.out.println(classes.getName());
            for (int j = 0; j < classes.getStudentsDynamicArray().getSize(); j++) {
                Student student = (Student) classes.getStudentsDynamicArray().get(j);
                System.out.println(student);
            }

        }
    }

        @Override
        public void addStudentToClass() {
            classesService.addStudentToClass();
        }

        @Override
        public boolean backToLogin () {
            return true;

        }

        @Override
        public void exit () {
            FileUtils.saveAll(GlobalStrings.SAVE_FILE_NAME);
            System.exit(0);
        }
    }

