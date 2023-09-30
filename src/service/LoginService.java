package service;

import baseSystem.GlobalStrings;
import globalData.GlobalData;
import inputUtils.FileUtils;
import inputUtils.InputUtil;
import service.Interfaces.LoginServiceInter;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;

public class LoginService implements LoginServiceInter {
    @Override
    public Person login(String username) {
        boolean isFound=false;
        boolean adminSing = true;
        for (int i = 0; i < GlobalData.dynamicArrayPerson.getSize(); i++) {
            Person person = GlobalData.dynamicArrayPerson.get(i);
            if (person instanceof Admin) {
                Admin admin = (Admin) person;
                if (admin.getUsername().equals(username)) {
                    isFound=true;
                    while (adminSing) {
                        String password = InputUtil.inputString("Enter password: ");
                        if (password.equals(admin.getPassword())) {
                            adminSing=false;
                            return admin;
                        }
                    }
                }
            } else if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getUsername().equals(username)) {
                    isFound=true;

                    if (student.isBlocked()){
                        System.out.println("You have been blocked!");
                        return null;
                    }
                    for (int j=2;j>=0;j--){
                    String password = InputUtil.inputString("Enter password: ");
                    if (password.equals(student.getPassword())) {
                        return student;
                    }else {
                        System.out.println("Wrong password! <->"+(j)+" attemps left");
                    }
                    if (j==0){
                        student.blockStudent();
                        System.out.println("You have been blocked(contact with admin)");
                        return null;
                    }
                    }

                }

            }else if (person instanceof Teacher) {
                Teacher teacher= (Teacher) person;
                if (teacher.getUsername().equals(username)) {
                    isFound=true;
                    if (teacher.isBlocked()){
                        System.out.println("You have been blocked!");
                        return null;
                    }
                    for (int j = 2; j >= 0; j--) {
                        String password = InputUtil.inputString("Enter password: ");
                        if (password.equals(teacher.getPassword())) {
                            return teacher;
                        } else {
                            System.out.println("Wrong password! <->" + (j) + " attemps left");
                        }
                        if (j == 0) {
                            teacher.blockTeacher();
                            System.out.println("You have been blocked(contact with admin)");
                            return null;
                        }
                    }

                }
            }
        }
        if (isFound==false){
           // throw new AppException(USER_NOT_FOUND_EX);


            System.out.println("User not found!!!");
        }
        return null;
        }

        @Override
        public void exit () {
            FileUtils.saveAll(GlobalStrings.SAVE_FILE_NAME);
            System.out.println("Program is stopped!");
            System.exit(0);

        }
    }

