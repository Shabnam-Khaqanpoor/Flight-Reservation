package exceptions;

public class WrongEmail extends WrongInfo {
    private String message;
    public WrongEmail() {
        this.message="Wrong email!";
    }
    public WrongEmail(String message){
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
