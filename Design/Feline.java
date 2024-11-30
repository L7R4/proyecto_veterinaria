package Design;

//This class is designed for all the felines registered in the Veterinary's system.

public class Feline extends Animal{
    
    //Atributes
    private boolean spayed;
    private boolean lives_Indoor;
    private String grooming_Needs;
  
    
     
     //Empty Constructor
    public Feline(){
    }
    
    
    //Constructor
    public Feline(String pet_ID, String name, int age, char sex, String specie, String breed, double weight, 
    String size, String prev_Vetrecord, boolean has_Allergy, String add_Info, 
    String consult_Motive, boolean spayed, boolean lives_Indoor, String grooming_Needs){
        super(pet_ID, name, age, sex, specie, breed, weight, size, prev_Vetrecord, has_Allergy, add_Info, consult_Motive);
        this.spayed = spayed;
        this.lives_Indoor = lives_Indoor;
        this.grooming_Needs = grooming_Needs;
    }
    
   
    //Getters and Setters
    
    public boolean isSpayed(){
        return this.spayed;
    }

   
    public void setSpayed(boolean spayed){
        this.spayed = spayed;
    }

 
    public boolean isLives_Indoor(){
        return this.lives_Indoor;
    }


    public void setLives_Indoor(boolean lives_Indoor){
        this.lives_Indoor = lives_Indoor;
    }


    public String getGrooming_Needs(){
        return this.grooming_Needs;
    }


    public void setGrooming_Needs(String grooming_Needs){
        this.grooming_Needs = grooming_Needs;
    }

    
    //Methods
    
    public void update_Spayed(Feline feline){
    }
    
    public String adviseGroomingRoutine(String advice, Feline feline){
        return advice;
    }
    
   
}
