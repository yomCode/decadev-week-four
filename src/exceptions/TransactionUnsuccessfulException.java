package exceptions;

public class TransactionUnsuccessfulException extends RuntimeException{

    public TransactionUnsuccessfulException(String message){
        super(message);
    }
}
