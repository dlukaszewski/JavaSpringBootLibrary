package pl.sda.library.exception;

public class BookAlreadyExistException extends RuntimeException {
    public BookAlreadyExistException(String message){
        super(message);
    }
}