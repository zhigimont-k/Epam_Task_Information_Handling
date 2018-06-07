package by.epam.task3.exception;

public class IllegalFileInputException extends Exception{
    public IllegalFileInputException() {
    }

    public IllegalFileInputException(String message) {
        super(message);
    }

    public IllegalFileInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFileInputException(Throwable cause) {
        super(cause);
    }
}
