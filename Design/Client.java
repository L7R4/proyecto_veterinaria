package Design;

import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class Client extends Person implements Comparable<Client> {

    // Attributes
    private String email;
    private boolean hasCurrTreat;
    private boolean hasDebt;
    private String add_Info;
    private List<Animal> petIDs;
    
    // Empty Constructor
    public Client() {
        this.petIDs = new ArrayList<>();  
    }

    
    // Constructor
    public Client(String ID, String name, String last_Name, LocalDate birth, String address, String cel_Number,
                 String email, boolean hasCurrTreat, boolean hasDebt, String add_Info) {
        super(ID, name, last_Name, birth, address, cel_Number);
        this.email = email;
        this.hasCurrTreat = hasCurrTreat;
        this.add_Info = add_Info;
        this.petIDs = new ArrayList<>();
    }

    
    // Getters and Setters
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHasCurrTreat() {
        return this.hasCurrTreat;
    }

    public void setHasCurrTreat(boolean hasCurrTreat) {
        this.hasCurrTreat = hasCurrTreat;
    }

    public boolean isHasDebt() {
        return this.hasDebt;
    }

    public void setHasDebt(boolean hasDebt) {
        this.hasDebt = hasDebt;
    }

    public String getAdd_Info() {
        return this.add_Info;
    }

    public void setAdd_Info(String add_Info) {
        this.add_Info = add_Info;
    }

   
    //OVERWRITE METHODS
    
    @Override
   public String toString() {
       return String.format("Client[ID=%s, Name=%s %s, Email=%s, CurrentTreatment=%s, Debt=%s, AdditionalInfo=%s]",
            getID(), getName(), getLast_Name(), email, 
            hasCurrTreat ? "Yes" : "No", hasDebt ? "Yes" : "No", add_Info);
        }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Client)) return false;
        Client other = (Client) obj;
        return getID() != null && getID().equals(other.getID());
    }

    @Override
    public int compareTo(Client other) {
        if (getID() == null || other.getID() == null) {
            throw new NullPointerException("Client ID cannot be null");
        }
        return getID().compareTo(other.getID());
    }

    @Override
    public int hashCode() {
        return (getID() == null) ? 0 : getID().hashCode();
    }
    
    
    
    //METHODS
    
    
    //The method 'getBasicInfo()
    public String getBasicInfo() {
        return String.format(
            "Client:\nFull Name: %s %s\nID: %s\nEmail: %s\nHas Current Treatment: %s\nHas Debt: %s",
            getName(),
            getLast_Name(),
            getID(),
            email,
            hasCurrTreat ? "Yes" : "No",
            hasDebt ? "Yes" : "No"
        );
    }

    
   
    public void showDetails() {
        StringBuilder details = new StringBuilder();
        
        details.append(String.format(
            "Client Details:\nFull Name: %s %s\nID: %s\nDate of Birth: %s\nAddress: %s\nPhone: %s\n",
            getName(),
            getLast_Name(),
            getID(),
            getBirth(),
            getAddress(),
            getCel_Number()
        ));

        details.append(String.format("Email: %s\nCurrent Treatment: %s\nDebt: %s\nAdditional Info: %s\n",
            email,
            hasCurrTreat ? "Yes" : "No",
            hasDebt ? "Yes" : "No",
            add_Info
        ));

        details.append("Pets:\n");
        if (petIDs != null && !petIDs.isEmpty()) {
            for (Animal pet : petIDs) {
                details.append(String.format("  - %s (ID: %s)\n", pet.getName(), pet.getPet_ID())); 
            }
        } else {
            details.append("No pets registered.\n");
        }

        System.out.println(details.toString());
    }

}