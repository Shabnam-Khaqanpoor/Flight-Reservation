package exceptions;

public class SameOrginAndDestination extends FailedReserve {
    private String message;
    public SameOrginAndDestination() {
        this.message="Same origin and destination!";
    }
    public SameOrginAndDestination(String message){
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
