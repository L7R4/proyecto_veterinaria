package Design;

//This class is designed for all the rodents registered in the Veterinary's system.

public class Rodent extends Animal
{
    
    //Atributes
   private String cage_Type;
   private double tooth_Length;
   
   
   //Empty Constructor
   public Rodent(){
    }
    
    
    //Constructor
    public Rodent(String pet_ID, String name, int age, char sex, String specie, String breed, double weight, 
    String size, String prev_Vetrecord, boolean has_Allergy, String add_Info, 
    String consult_Motive, String cage_Type, double tooth_Length){
        super(pet_ID, name, age, sex, specie, breed, weight, size, prev_Vetrecord, has_Allergy, add_Info, consult_Motive);
        this.cage_Type = cage_Type;
        this.tooth_Length = tooth_Length;
    }
    

    //Getters and Setters
  
    public String getCage_Type(){
        return this.cage_Type;
    }

  
    public void setCage_Type(String cage_Type){
        this.cage_Type = cage_Type;
    }

    
    public double getTooth_Length(){
        return this.tooth_Length;
    }

  
    public void setTooth_Length(double tooth_Length){
        this.tooth_Length = tooth_Length;
    }

    
    //Methods
    public String recommendCageType(String advice, Rodent rodent){
        return advice;
    }
    
    public double monitorToothGrowth(double tooth_Length){
        double normal_Length = 0;
        return normal_Length;
    }
    
}
