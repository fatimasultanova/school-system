package menuEnums;

public enum FirstMenu {
    LOGIN(1,"Login") , EXIT(0,"Exit");
    private int id;
    private String option;


    FirstMenu(int id,String option){
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
