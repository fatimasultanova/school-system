package service.Interfaces;

import users.Person;

public interface StudentServiceInter {
    void seeOwnInfo(Person person);
    void resetPasword(Person person);
    boolean backToLogin();
    void exit();


}
