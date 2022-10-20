package exceptions;

public class NotEnoughAvailableQuantity extends RuntimeException{
    public NotEnoughAvailableQuantity(String message) {
        super(message);
    }
}
