package exceptions;

public class WrongPhoneNumber extends WrongInfo {
    private String message;
    public WrongPhoneNumber() {
        this.message="Wrong phone number!";
    }
    public WrongPhoneNumber(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString(){
        return super.toString(this.getMessage());
    }
}
