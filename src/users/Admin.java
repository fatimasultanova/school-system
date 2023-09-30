package users;

import java.io.Serializable;
import java.time.LocalDate;

public class Admin extends Employee implements Serializable {
    private int id;
    private String email;
    private String username;
    private String password;


    public Admin(int id, String email, String username, String password, double salary, String name, String surname, LocalDate birthday) {
        super(salary,name,surname,birthday);
        this.id = id;
        this.email = email;
        this.username = username;
        this.password=password;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
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
}
