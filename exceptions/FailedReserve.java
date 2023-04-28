package exceptions;

public abstract class FailedReserve extends Exception {

    public String toString(String message){
        return "Failed reserve-"+message;
    }
}
