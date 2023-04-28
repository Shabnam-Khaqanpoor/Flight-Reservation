package exceptions;

public class NoBalance extends FailedReserve {
    private String message;
    public NoBalance() {
        this.message="No balance!";
    }
    public NoBalance(String message){
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
