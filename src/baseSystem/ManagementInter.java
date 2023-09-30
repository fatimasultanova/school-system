package baseSystem;

import users.Person;

public interface ManagementInter {
    boolean adminSpecification();
    boolean teacherSpecification();
    boolean studentSpecification(Person person);
}
