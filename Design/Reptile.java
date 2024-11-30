package Design;

//This class is designed for all the reptiles registered in the Veterinary's system.

public class Reptile extends Animal
{
 
    //Atributes
    private boolean venomous;
    private String temperature_Range;
    private double humidity_Level;
    

    //Empty Constructor
    public Reptile(){
    }
    
    
    //Constructor
    public Reptile(String pet_ID, String name, int age, char sex, String specie, String breed, double weight, 
    String size, String prev_Vetrecord, boolean has_Allergy, String add_Info, 
    String consult_Motive, boolean venomous, String temperature_Range, double humidity_Level){
    super(pet_ID, name, age, sex, specie, breed, weight, size, prev_Vetrecord, has_Allergy, add_Info, consult_Motive);
    this.venomous = venomous;
    this.temperature_Range = temperature_Range;
    this.humidity_Level = humidity_Level;
    }
    
    
    //Getters and Setters
    
    
    public boolean getVenomous(){
        return this.venomous;
    }


    public void isVenomous(boolean venomous){
        this.venomous = venomous;
    }


    public String getTemperature_Range(){
        return this.temperature_Range;
    }

   
    public void setTemperature_Range(String temperature_Range){
        this.temperature_Range = temperature_Range;
    }

    
    public double getHumidity_Level(){
        return this.humidity_Level;
    }


    public void setHumidity_Level(double humidity_Level){
        this.humidity_Level = humidity_Level;
    }

   
    
    //Methods
    
    //Method "adviseTemperatureCare" returns an advice according to the reptile characteristics.
    public String adviseTemperatureCare(String advice, Reptile reptile){
       return advice;
    } 
   
    
    public String manageHumidity(String advice, Reptile reptile){
        return advice;
    }
    
    
}
