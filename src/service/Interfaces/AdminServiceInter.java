package service.Interfaces;

public interface AdminServiceInter {
    void addStudent();
    void addTeacher();
    void deleteUserById(int id);
    void updateUserById(int id);
    void blockUserById(int id);
    void unBlockUserById(int id);
    void searchUserByName(String name);
    void changePaswordForAnyUser(int id);
    void searchUserById(int id);
    boolean backToLogin();
    void exit();



}

/*
ADD_STUDENT(1,"Add student"),ADD_TEACHER(2,"Add teacher"),DELETE_USER_BYID(3,"Delete User(by id)"),
    UPDATE_USER_BYID(4,"Update User(by id)"), BLOCK_USER_BYID(5,"Block User(by id)"),
    OPEN_BLOCK_USER_BYID(6,"Open block User(by id)"), SEARCH_USER_BYNAME(7,"Search User(by name)"),
    CHANGE_PASSWORD_FOR_ANYUSER(8,"Change passwod for any user"), SEARCH_USER_BYID(9,"Search User(by id)"),
    BACK_TOLOGIN(10,"Back to Login"),EXIT(0,"Exit");
 */
