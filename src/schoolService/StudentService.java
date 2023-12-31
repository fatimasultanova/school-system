package schoolService;

import baseSystem.GlobalStrings;
import inputUtil.MenuUtil;
import inputUtils.FileUtils;
import inputUtils.InputUtil;
import schoolService.Interfaces.StudentServiceInter;
import service.Management;
import users.Person;
import users.Student;

public class StudentService implements StudentServiceInter {
    @Override
    public void seeOwnInfo(Person person) {
        Student student = (Student) person;
        System.out.println(student);
    }

    @Override
    public void resetPasword(Person person) {
        Student student = (Student) person;
        String paswordTest = InputUtil.inputString("Enter password: ");
        if (paswordTest.equals(student.getPassword())) {
            String newPasword = InputUtil.inputString("Enter new password: ");
            student.setPassword(newPasword);
            System.out.println("Password has been updated!");
        }else{
            System.out.println("Wrong password!");
            return;
        }
    }

    @Override
    public boolean backToLogin() {
        return true;
    }

    public void exam(){
        Management.management();
    }

    @Override
    public void exit() {
        FileUtils.saveAll(GlobalStrings.SAVE_FILE_NAME);
        FileUtils.saveAllClasses(GlobalStrings.SAVE_CLASS_NAME);
        System.exit(0);

    }
}
