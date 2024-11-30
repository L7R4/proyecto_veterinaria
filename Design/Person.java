package Design;

import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;

// Abstract class designed to serve as template for human classes like 'Employee' or 'Owner'

public abstract class Person implements Serializable {
    
    
    // Attributes
    private static final long serialVersionUID = 1L;

    private String ID;
    private String name;
    private String last_Name;
    private LocalDate birth;
    private String address;
    private String cel_Number;

    
    // Empty Constructor
    public Person() {
    }

    
    // Constructor
    public Person(String ID, String name, String last_Name, LocalDate birth, String address, String cel_Number) {
        this.ID = ID;
        this.name = name;
        this.last_Name = last_Name;
        this.birth = birth;
        this.address = address;
        this.cel_Number = cel_Number;
    }

    
    // Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCel_Number() {
        return cel_Number;
    }

    public void setCel_Number(String cel_Number) {
        this.cel_Number = cel_Number;
    }

    
    // Methods
    
    @Override
    public String toString() {
        return String.format("Person[ID=%s, Name=%s %s, BirthDate=%s, Address=%s, Phone=%s]",
                ID, name, last_Name, birth, address, cel_Number);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return Objects.equals(this.ID, other.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
    

    // Abstract method to be implemented by subclasses to return a person's basic information
    public abstract String getBasicInfo();
    
    // Abstract method to be implemented by subclasses to show details of the person
    public abstract void showDetails();
    
}

