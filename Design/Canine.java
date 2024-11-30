package Design;

//This class is designed for all the canines registered in the Veterinary's system.

import java.io.*;
import java.util.*;

public class Canine extends Animal {

    // Attributes
    private boolean spayed;
    private String obedience_Level;

    
    // Empty Constructor
    public Canine() {
    }

    
    // Constructor
    public Canine(String petID, String name, int age, char sex, String specie, String breed, double weight,
                  String size, String prev_Vetrecord, boolean has_Allergy, String add_Info, String consult_Motive,
                  boolean spayed, String obedience_Level) {
        super(petID, name, age, sex, specie, breed, weight, size, prev_Vetrecord, has_Allergy, add_Info, consult_Motive);
        this.spayed = spayed;
        this.obedience_Level = obedience_Level;
    }

    
    // Getters and Setters
    public boolean isSpayed() {
        return spayed;
    }

    public void setSpayed(boolean spayed) {
        this.spayed = spayed;
    }

    public String getObedience_Level() {
        return obedience_Level;
    }

    public void setObedience_Level(String obedience_Level) {
        this.obedience_Level = obedience_Level;
    }

    
    // Methods
    public void updateSpayed(Canine canine) {
    }

    public String trainingTips(String advice, Canine canine) {
        return advice;
    }

}


