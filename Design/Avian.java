package Design;

//This class is designed for all the avians registered in the Veterinary's system.

public class Avian extends Animal
{
    
    //Atributes
    private double wings_Span;
    private boolean can_Fly;
    private String diet_Type;
    
    
    //Empty Constructor
    public Avian(){
    }
    
    
    //Constructor
    public Avian(String pet_ID, String name, int age, char sex, String specie, String breed, double weight, 
    String size, String prev_Vetrecord, boolean has_Allergy, String add_Info, 
    String consult_Motive, double wings_Span, boolean can_Fly, String diet_Type){
        super(pet_ID, name, age, sex, specie, breed, weight, size, prev_Vetrecord, has_Allergy, add_Info, consult_Motive);
        this.wings_Span = wings_Span;
        this.can_Fly = can_Fly;
        this.diet_Type = diet_Type;
    }
    
    
    //Getters and Setters
  
    public double getWings_Span(){
        return this.wings_Span;
    }


    public void setWings_Span(double wings_Span){
        this.wings_Span = wings_Span;
    }

   
    public boolean getCan_Fly(){
        return this.can_Fly;
    }


    public void setCan_Fly(boolean can_Fly){
        this.can_Fly = can_Fly;
    }


    public String getDiet_Type(){
        return this.diet_Type;
    }

  
    public void setDiet_Type(String diet_Type){
        this.diet_Type = diet_Type;
    }

    
    //Methods
    
    public String recommendCageSpace(String advice, Avian avian){
        return advice;
    }
   
    public String adviseDiet(String advice, Avian avian){
        return advice;
    }
    
    
}
