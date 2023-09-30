package users;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Student extends Person implements Serializable {
    private int id;
    private String email;
    private String username;
    private String password;
    private boolean isBlocked=false;

    public Student(int id, String email, String username,String password,String name, String surname, LocalDate birthday) {
        super(name, surname, birthday);
        this.id = id;
        this.email = email;
        this.username = username;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void blockStudent(){
        this.isBlocked=true;
        System.out.println("Student: "+this.id+"<->"+this.username+" has been blocked!");
    }

    public void unBlockStudent(){
        this.isBlocked=false;
        System.out.println("Student: "+this.id+"<->"+this.username+" has been unblocked!");
    }

    @Override
    public String toString() {
        return "Student{" +
                "[id]=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}'+"\n";
    }

    public String getDetailForTeacher() {
        LocalDate localDate = LocalDate.now();
        int age = Period.between(birthday,localDate).getYears();
        return "Student{" +
                "[id]=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +'\'' +", age="+ age +
                '}'+"\n";
    }
}
