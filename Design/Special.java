package Design;


public class Special extends Animal
{
    //Atributes
    private String care_Difficulty;
    private boolean venomous;
    
    
    //Empty Constructor
    public Special(){
    }
    
    
    //Constructor
    public Special(String pet_ID, String name, int age, char sex, String specie, String breed, double weight, 
    String size, String prev_Vetrecord, boolean has_Allergy, String add_Info, 
    String consult_Motive, String care_Difficulty, boolean venomous){
        super(pet_ID, name, age, sex, specie, breed, weight, size, prev_Vetrecord, has_Allergy, add_Info, consult_Motive);
        this.care_Difficulty = care_Difficulty;
        this.venomous = venomous;
    }
    

    //Getters and Setters
 
    public String getCare_Difficulty(){
        return this.care_Difficulty;
    }

    
    public void setCare_Difficulty(String care_Difficulty){
        this.care_Difficulty = care_Difficulty;
    }

   
    public boolean isVenomous(){
        return this.venomous;
    }

    
    public void setVenomous(boolean venomous){
        this.venomous = venomous;
    }

    
    //Methods
    
    public String provideCareInstructions(String advice, Special special){
        return advice;
    }
    
    public String manageSafetyPrecautions(String advice, Special special){
    return advice;
    }
   
    
}
