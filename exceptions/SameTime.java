package exceptions;

public class SameTime extends FailedReserve {
    private String message;
    public SameTime() {
        this.message="Wrong time!";
    }
    public SameTime(String message){
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
