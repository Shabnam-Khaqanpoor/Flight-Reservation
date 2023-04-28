package exceptions;

public class WrongBalance extends WrongInfo {
    private String message;
    public WrongBalance() {
        this.message="Wrong balance!";
    }
    public WrongBalance(String message){
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
