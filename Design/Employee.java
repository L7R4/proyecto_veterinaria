package Design;



import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class Employee extends Person implements Comparable<Employee> {

    
    // Attributes
    private String employee_ID;
    private double salary;
    private String work_Area;
    private String position;
    private LocalDate hire_Date;
    
    // Empty Constructor
    public Employee() {
    }

    
    //Constructor
    public Employee(String ID, String name, String last_Name, LocalDate birth, String address, String cel_Number,
                    String employee_ID, double salary, String work_Area, String position, LocalDate hire_Date) {
        super(ID, name, last_Name, birth, address, cel_Number);
        this.employee_ID = employee_ID;
        this.salary = salary;
        this.work_Area = work_Area;
        this.position = position;
        this.hire_Date = hire_Date;
    }

    
    // Getters and Setters
    public String getEmployee_ID() {
        return this.employee_ID;
    }

    public void setEmployee_ID(String employee_ID) {
        this.employee_ID = employee_ID;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWork_Area() {
        return this.work_Area;
    }

    public void setWork_Area(String work_Area) {
        this.work_Area = work_Area;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getHire_Date() {
        return this.hire_Date;
    }

    public void setHire_Date(LocalDate hire_Date) {
        this.hire_Date = hire_Date;
    }

 
    
    //OVERWRITE METHODS
    
    @Override
    public String toString() {
        return String.format("Employee[ID=%s, Name=%s %s, EmployeeID=%s, Position=%s, HireDate=%s, Salary=%.2f]",
                getID(), getName(), getLast_Name(), employee_ID, position, hire_Date, salary);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return this.employee_ID.equals(other.employee_ID);
    }

    @Override
    public int compareTo(Employee other) {
        return this.employee_ID.compareTo(other.employee_ID);
    }

    @Override
    public int hashCode() {
        return employee_ID.hashCode();
    }

    //METHODS

   public String getBasicInfo() {
        return String.format("Employee ID: %s | Name: %s %s | Position: %s",
                employee_ID, getName(), getLast_Name(), position);
    }

    public void showDetails() {
        System.out.println(String.format("Employee Details:\nEmployee ID: %s\nFull Name: %s %s\nID: %s\nBirth Date: %s\nAddress: %s\nPhone: %s\nSalary: %.2f\nWork Area: %s\nPosition: %s\nHire Date: %s",
                getEmployee_ID(), getName(), getLast_Name(), getID(), getBirth(), getAddress(), getCel_Number(),
                getSalary(), getWork_Area(), getPosition(), getHire_Date()));
    }

}
