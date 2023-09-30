package baseSystem;

import exceptions.AppException;
import static exceptions.EnumException.*;
import inputUtils.FileUtils;
import inputUtils.InputUtil;
import menuEnums.*;
import service.AdminService;
import service.Interfaces.AdminServiceInter;
import service.Interfaces.StudentServiceInter;
import service.Interfaces.TeacherServiceInter;
import service.StudentService;
import service.TeacherService;
import users.Person;

import java.time.LocalDateTime;
import java.util.InputMismatchException;



public class Management implements ManagementInter {
    AdminServiceInter adminService = new AdminService();
    StudentServiceInter studentService = new StudentService();
    TeacherServiceInter teacherService = new TeacherService();

    @Override
    public boolean adminSpecification() {
        boolean backToLogin = false;
        boolean isTeacherOrStudent;
        printAdminMenu();
        try {
            int option = InputUtil.inputInt("Enter option: ");
            switch (option) {
                case 1:
                    adminService.addStudent();
                    break;
                case 2:
                    adminService.addTeacher();
                    break;
                case 3:
                    isTeacherOrStudent = InputUtil.printUsers();
                    try {
                        if (!isTeacherOrStudent) {
                            throw new AppException(USER_NOT_FOUND_EX);
                        }
                        adminService.deleteUserById(InputUtil.inputInt("Enter Id: "));
                    }catch (AppException ex){
                        ex.printStackTrace();
                    }
                    break;
                case 4:
                    isTeacherOrStudent = InputUtil.printUsers();
                    try {
                        if (!isTeacherOrStudent) {
                            throw new AppException(USER_NOT_FOUND_EX);
                        }
                        adminService.updateUserById(InputUtil.inputInt("Enter Id: "));
                    }catch (AppException ex){
                        ex.printStackTrace();
                    }
                    break;
                case 5:
                    isTeacherOrStudent = InputUtil.printUnblocks();
                    if (isTeacherOrStudent == true) {
                        adminService.blockUserById(InputUtil.inputInt("Enter Id: "));
                    } else
                        System.out.println("User not found!");
                    break;
                case 6:
                    isTeacherOrStudent = InputUtil.printBlocks();
                    if (isTeacherOrStudent == true) {
                        adminService.unBlockUserById(InputUtil.inputInt("Enter Id: "));
                    } else
                        System.out.println("User not found!");
                    break;
                case 7:
                    adminService.searchUserByName(InputUtil.inputString("Enter name: "));
                    break;
                case 8:
                    isTeacherOrStudent = InputUtil.printUsers();
                    if (isTeacherOrStudent == true) {
                        adminService.changePaswordForAnyUser(InputUtil.inputInt("Enter Id: "));
                    } else
                        System.out.println("User not found!");
                    break;
                case 9:
                    adminService.searchUserById(InputUtil.inputInt("Enter Id: "));
                    break;
                case 10:
                    backToLogin = adminService.backToLogin();
                    return backToLogin;
                case 0:
                    adminService.exit();
                    break;
                default:
                    System.out.println("Wrong option!");
                    break;

            }

        } catch (InputMismatchException ex) {
            System.out.println("You can enter only numbers!");
        }
        return backToLogin;
    }

    @Override
    public boolean teacherSpecification() {
        printTeacherMenu();
        try {
            int option = InputUtil.inputInt("Enter option: ");
            switch (option) {
                case 1:
                    teacherService.seeAllStudents();
                    break;
                case 2:
                    teacherService.seeAllClasses();
                    break;
                case 3:
                    teacherService.addStudentToClass();
                    break;
                case 4:
                    return teacherService.backToLogin();
                case 0:
                    teacherService.exit();
            }

        } catch (InputMismatchException ex) {
            System.out.println("You can enter only numbers!");
        }


        return false;
    }

    @Override
    public boolean studentSpecification(Person loggedIn) {
        printStudentMenu();
        try {
            int option = InputUtil.inputInt("Enter option: ");
            switch (option) {
                case 1:
                    studentService.seeOwnInfo(loggedIn);
                    break;
                case 2:
                    studentService.resetPasword(loggedIn);
                    break;
                case 3:
                    return studentService.backToLogin();
                case 0:
                    studentService.exit();
                    break;
                default:
                    System.out.println("Wrong option!");
            }
        } catch (InputMismatchException ex) {
            System.out.println("You can enter only numbers!");
        }

        return false;
    }

    private void printAdminMenu() {
        for (AdminMenu adminMenu : AdminMenu.values()) {
            System.out.println("[" + adminMenu.getId() + "]" + "--->" + adminMenu.getOption());
        }
    }

    private void printTeacherMenu() {
        for (TeacherMenu teacherMenu : TeacherMenu.values()) {
            System.out.println("[" + teacherMenu.getId() + "]" + "--->" + teacherMenu.getOption());
        }
    }

    private void printStudentMenu() {
        for (StudentMenu studentMenu : StudentMenu.values()) {
            System.out.println("[" + studentMenu.getId() + "]" + "--->" + studentMenu.getOption());
        }
    }
}
