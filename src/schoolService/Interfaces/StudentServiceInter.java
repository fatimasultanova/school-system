package schoolService.Interfaces;

import users.Person;

public interface StudentServiceInter {
    void seeOwnInfo(Person person);
    void resetPasword(Person person);
    void exam();
    boolean backToLogin();
    void exit();


}
