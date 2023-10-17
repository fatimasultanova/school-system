package schoolService;

import baseSystem.GlobalStrings;
import classes.Classes;
import exceptions.AppException;
import static exceptions.EnumException.*;
import static globalData.GlobalData.dynamicArrayPerson;

import globalData.GlobalData;
import inputUtils.FileUtils;
import inputUtils.InputUtil;
import schoolService.Interfaces.AdminServiceInter;
import schoolService.Interfaces.AdminServiceInter;
import schoolService.Interfaces.ClassesServiceInter;
import users.Person;
import users.Student;
import users.Teacher;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;


public class AdminService implements AdminServiceInter, Serializable {
    @Override
    public void addStudent() {
        String email= InputUtil.inputString("Enter email: ");
        String pasword= InputUtil.inputString("Enter pasword: ");
        String name= InputUtil.inputString("Enter name: ");
        String surname= InputUtil.inputString("Enter surname: ");
        String username= getUsername(name,surname);
        LocalDate birtday  = LocalDate.of(InputUtil.inputInt("Year: "),InputUtil.inputInt("Month: "),InputUtil.inputInt("Day: "));
        int id = GlobalData.id++;
        Student student = new Student(id,email,username,pasword,name,surname,birtday);
        String log = "Student with id: "+id+" added with name: "+name+" "+surname+" "+ "Time: "+ LocalDateTime.now()+ " By admin: " + GlobalData.loginPerson.getName();
        FileUtils.applicationLogs(GlobalStrings.FILE_NAME,log);
        dynamicArrayPerson.add(student);
        FileUtils.saveAll(GlobalStrings.SAVE_FILE_NAME);
        System.out.println("Student " + name +" added successfully!" + "(Username:) "+ username);
    }

    @Override
    public void addTeacher() {

       try {
           String email = InputUtil.inputString("Enter email: ");

           String pasword = InputUtil.inputString("Enter pasword: ");
           String name = InputUtil.inputString("Enter name: ");
           String surname = InputUtil.inputString("Enter surname: ");
           String username = getUsername(name, surname);
           double salary = InputUtil.inputDouble("Enter salary: ");

           int id = GlobalData.id++;
           LocalDate birtday = LocalDate.of(InputUtil.inputInt("Year: "), InputUtil.inputInt("Month: "), InputUtil.inputInt("Day: "));
          // InputUtil.printClasses();
           Classes class1 = getClasses();
           if (class1 == null) {
               throw new AppException(CLASS_NOT_FOUND);
           }
           Teacher teacher = new Teacher(id, email, username, pasword, class1, salary, name, surname, birtday);
           String log = "Teacher with id: " + id + " added with name: " + name + " " + surname + " " + "Time: " + LocalDateTime.now() + " By admin: " + GlobalData.loginPerson.getName();
           FileUtils.applicationLogs(GlobalStrings.FILE_NAME, log);
           dynamicArrayPerson.add(teacher);
           FileUtils.saveAll(GlobalStrings.SAVE_FILE_NAME);
           System.out.println("Teacher " + teacher.getUsername() + " added successfully!");

       }catch (Exception ex){
           ex.printStackTrace();
       }

    }



    @Override
    public void deleteUserById(int id) {
        for (int i = 0; i < dynamicArrayPerson.size(); i++) {
            Person person = (Person) dynamicArrayPerson.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == id) {
                    String log = "Student deleted with id: "+id+ " "+"Name: "+person.getName()+" "+person.getSurname()+" "+ "Time: "+ LocalDateTime.now()+ " By admin: " + GlobalData.loginPerson.getName();
                    FileUtils.applicationLogs(GlobalStrings.FILE_NAME,log);
                    dynamicArrayPerson.remove(i);
                    System.out.println("Student " + student.getId() + " has been deleted successfully!");

                    return;
                }
            }
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getId() == id) {
                    String log = "Teacher deleted with id: "+id+ " "+"Name: "+person.getName()+" "+person.getSurname()+" "+ "Time: "+ LocalDateTime.now()+ " By admin: " + GlobalData.loginPerson.getName();
                    FileUtils.applicationLogs(GlobalStrings.FILE_NAME,log);
                    dynamicArrayPerson.remove(i);
                    System.out.println("Teacher " + teacher.getId() + " has been deleted successfully!");
                    return;
                }
            }

        }
    }


    @Override
    public void updateUserById(int id) {
        boolean username = true;
        for (int i = 0; i< dynamicArrayPerson.size(); i++){
            Person person = (Person) dynamicArrayPerson.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                String oldName = student.getName();
                String oldSurname = student.getSurname();
                if (student.getId() == id) {
                    try {
                        student.setEmail(InputUtil.inputString("Enter email: "));
                        student.setPassword(InputUtil.inputString("Enter pasword: "));
                        while (username) {
                            student.setName(InputUtil.inputString("Enter name: "));
                            student.setSurname(InputUtil.inputString("Enter surname: "));
                            if (student.getName().length() > 3 && student.getSurname().length() > 3) {
                                username = false;
                                student.setUsername(getUsername(student.getName(), student.getSurname()));
                                break;
                            }
                            else
                                System.out.println("Minimum 3 letter!");
                            }
                        student.setBirthday(LocalDate.of(InputUtil.inputInt("Year: "), InputUtil.inputInt("Month: "), InputUtil.inputInt("Day: ")));
                        student=new Student(student.getId(),student.getEmail(),student.getUsername(),student.getPassword(),student.getName(),student.getSurname(),student.getBirthday());
                        String log = "Student with id: " + id + " updated with name: " + oldName + " " + oldSurname + " " + "Time: " + LocalDateTime.now()+ " By admin: " + GlobalData.loginPerson.getName();
                        FileUtils.applicationLogs(GlobalStrings.FILE_NAME, log);
                        System.out.println("Student id: " + id  + " updated successfully!" + "(Username:) " + student.getUsername());
                        FileUtils.saveAll("dynamic.txt");
                        return;
                    } catch (StringIndexOutOfBoundsException ex) {
                        ex.printStackTrace();

                    }
                }

            }
        }
    }

    @Override
    public void blockUserById(int id) {
        for (int i = 0; i< dynamicArrayPerson.size(); i++){
            Person person = (Person) dynamicArrayPerson.get(i);
            if (person instanceof Student){
                Student student = (Student) person;
                if (student.getId()==id) {
                    String log = "Student blocked with id: "+id+ " "+"Name: "+person.getName()+" "+person.getSurname()+" "+ "Time: "+ LocalDateTime.now() + " By admin: " + GlobalData.loginPerson.getName();
                    FileUtils.applicationLogs(GlobalStrings.FILE_NAME,log);
                    student.blockStudent();
                    return;
                }
            }
            if (person instanceof Teacher){
                Teacher teacher = (Teacher) person;
                if (teacher.getId()==id) {
                    String log = "Teacher blocked with id: "+id+ " "+"Name: "+person.getName()+" "+person.getSurname()+" "+ "Time: "+ LocalDateTime.now() + " By admin: " + GlobalData.loginPerson.getName();
                    FileUtils.applicationLogs(GlobalStrings.FILE_NAME,log);
                    teacher.blockTeacher();
                    return;
                }
            }
        }


    }

    @Override
    public void unBlockUserById(int id) {
        for (int i = 0; i< dynamicArrayPerson.size(); i++){
            Person person = (Person) dynamicArrayPerson.get(i);
            if (person instanceof Student){
                Student student = (Student) person;
                if (student.getId()==id) {
                    String log = "Student unblocked with id: "+id+ " "+"Name: "+person.getName()+" "+person.getSurname()+" "+ "Time: "+ LocalDateTime.now()+ " By admin: " + GlobalData.loginPerson.getName();
                    FileUtils.applicationLogs(GlobalStrings.FILE_NAME,log);
                    student.unBlockStudent();
                    return;
                }
            }
            if (person instanceof Teacher){
                Teacher teacher = (Teacher) person;
                if (teacher.getId()==id) {
                    String log = "Teacher unblocked with id: "+id+ " "+"Name: "+person.getName()+" "+person.getSurname()+" "+ "Time: "+ LocalDateTime.now()+ " By admin: " + GlobalData.loginPerson.getName();
                    FileUtils.applicationLogs(GlobalStrings.FILE_NAME,log);
                    teacher.unBlockTeacher();
                    return;
                }
            }
        }


    }

    @Override
    public void searchUserByName(String name) {
        for (int i = 0; i < dynamicArrayPerson.size(); i++) {
            String getName = dynamicArrayPerson.get(i).getName().toLowerCase();
            name = name.toLowerCase();
            if (getName.contains(name)) {
                System.out.println(dynamicArrayPerson.get(i));
            }
        }
    }


    @Override
    public void changePaswordForAnyUser(int id) {
        for (int i = 0; i< dynamicArrayPerson.size(); i++){
            Person person = (Person) dynamicArrayPerson.get(i);
            if (person instanceof Student){
                Student student = (Student) person;
                if (student.getId()==id){
                    String newPassword = InputUtil.inputString("Enter new passvord: ");
                    student.setPassword(newPassword);
                    String log = "Password of student changed with id: "+id+ " "+"Name: "+person.getName()+" "+person.getSurname()+" "+ "Time: "+ LocalDateTime.now()+ " By admin: " + GlobalData.loginPerson.getName();
                    FileUtils.applicationLogs(GlobalStrings.FILE_NAME,log);
                    System.out.println("Password has been updated!");
                    return;
                }
            }
            if (person instanceof Teacher){
                Teacher teacher = (Teacher) person;
                if (teacher.getId()==id){
                    String newPassword = InputUtil.inputString("Enter new passvord: ");
                    teacher.setPassword(newPassword);
                    String log = "Password of teacher changed with id: "+id+ " "+"Name: "+person.getName()+" "+person.getSurname()+" "+ "Time: "+ LocalDateTime.now()+ " By admin: " + GlobalData.loginPerson.getName();
                    FileUtils.applicationLogs(GlobalStrings.FILE_NAME,log);
                    System.out.println("Password has been updated!");
                    return;
                }
            }
        }
    }

    @Override
    public void searchUserById(int id) {
        for (int i = 0; i< dynamicArrayPerson.size(); i++){
            Person person = (Person) dynamicArrayPerson.get(i);
            if (person instanceof Student){
                Student student = (Student) person;
                if (student.getId()==id){
                    System.out.println(student);
                    return;
                }
            }
            if (person instanceof Teacher){
                Teacher teacher = (Teacher) person;
                if (teacher.getId()==id){
                    System.out.println(teacher);
                    return;
                }
            }
        }

    }

    @Override
    public boolean backToLogin() {
        return true;
    }

    @Override
    public void exit() {
        FileUtils.saveAll(GlobalStrings.SAVE_FILE_NAME);
        System.exit(0);

    }

    private String getUsername(String name , String surname){
        Random random = new Random();
           String username= name.substring(0,3)+surname.substring(0,3)+random.nextInt(10000);
        return username;
    }

    public Classes getClasses(){
        InputUtil.printClasses();
        String className = InputUtil.inputString("Choose class: ");
        for (int i = 0; i < GlobalData.dynamicArrayClass.size(); i++) {
            Classes classes = (Classes) GlobalData.dynamicArrayClass.get(i);
            if (classes.getName().equalsIgnoreCase(className)){
                return classes;
            }
        }
        return null;
    }

}
