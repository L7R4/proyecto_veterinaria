package Design;

import Design.Exceptions.FileNotFoundException;
import Design.Exceptions.FileOperationException;
import java.util.List;

//This interface is designed to build basic CRUD operations  

public interface CRUD<T> {
    
    // Basic CRUD operations with custom exceptions
    void add(T objeto) throws FileOperationException;
    
    void delete(String ID) throws FileNotFoundException, FileOperationException;
    
    void modify(T objeto) throws FileNotFoundException, FileOperationException;
    
    List<T> list();
    
    T consult(String ID) throws FileNotFoundException, FileOperationException;
}



