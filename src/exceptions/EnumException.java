package exceptions;

public enum EnumException {
    USER_NOT_FOUND_EX("User not found!"), CLASS_NOT_FOUND("Class not found!");

    String message ;

    EnumException (String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
