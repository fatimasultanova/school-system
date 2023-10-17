package schoolService.Interfaces;

import users.Person;

public interface LoginServiceInter {
    Person login(String username);
    void exit();
}
