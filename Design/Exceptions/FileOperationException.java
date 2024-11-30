package Design.Exceptions;

public class FileOperationException extends Exception {

    
    public FileOperationException(String message) {
        super(message);
    }

    
    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    
    public FileOperationException(Throwable cause) {
        super(cause);
    }
}
