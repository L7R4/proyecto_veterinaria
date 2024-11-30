package Design.Exceptions;

public class FileNotFoundException extends FileOperationException {
    
    public FileNotFoundException (String message, Throwable cause) {
        
        super(message, cause);
        
    }
}