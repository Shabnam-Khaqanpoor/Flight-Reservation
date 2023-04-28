package exceptions;

abstract public class WrongInfo extends Exception {

    public String toString(String message){
        return"Wrong information-"+message;
    }
}


