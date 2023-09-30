package users;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Employee extends Person implements Serializable {
    private double salary;

    public Employee(double salary,String name, String surname, LocalDate birthday) {
        super(name,surname,birthday);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
