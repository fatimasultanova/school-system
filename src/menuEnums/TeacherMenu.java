package menuEnums;

public enum TeacherMenu {
    SEE_ALL_STUDENTS(1,"See all students"),SEE_ALL_CLASSES(2,"See all classes"),
    ADD_STUDENT_TOCLASS(3,"Add student to class"),
    BACK_TOLOGIN(4,"Back to Login"),EXIT(0,"Exit");

    private int id;
    private String option;


    TeacherMenu(int id,String option){
        this.id =id;
        this.option=option;
    }

    public int getId(){
        return id;
    }
    public String getOption(){
        return option;
    }

}
