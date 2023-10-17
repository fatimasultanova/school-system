package menuEnums;

public enum StudentMenu {
    SEE_OWN_INFO(1,"See own info"),RESET_PASSWORD(2,"Reset password"),
    BACK_TOLOGIN(3,"Back to Login"),EXAM(4,"Exam"),EXIT(0,"Exit");

    private int id;
    private String option;


    StudentMenu(int id,String option){
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
