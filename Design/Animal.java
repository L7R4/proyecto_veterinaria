package Design;


import java.io.*;
import java.util.*;

//Abstract class deisgned to serve as a template for 'Pet' classes

public abstract class Animal implements Serializable {
    
    
    // Attributes
    private static final long serialVersionUID = 1L;
    
    private String pet_ID;
    private String name;
    private int age;
    private char sex;
    private String specie;
    private String breed;
    private double weight;
    private String size;
    private String prev_Vetrecord;
    private boolean has_Allergy;
    private String add_Info;
    private String consult_Motive;
    protected String advice;
    
    
    //Empty Constructor
    public Animal(){
        
    }
    
    
    //Constructor
    public Animal(String pet_ID, String name, int age, char sex, String specie, String breed, double weight, String size, 
    String prev_Vetrecord, boolean has_Allergy, String add_Info, String consult_Motive){
        this.pet_ID = pet_ID;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.specie = specie;
        this.breed = breed;
        this.weight = weight;
        this.size = size;
        this.prev_Vetrecord = prev_Vetrecord;
        this.has_Allergy = has_Allergy;
        this.add_Info = add_Info;
        this.consult_Motive = consult_Motive;
    }
    
    
     //Getters and Setters
     public String getPet_ID(){
        return pet_ID;
    }
    
    public void setPet_ID(String pet_ID){
        this.pet_ID = pet_ID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
   
    public int getAge(){
        return age;
    }
    
    public void setAge(int Age){
        this.age = age;
    }
    
    public char getSex(){
        return sex;
    }
    
    public void setSex(char sex){
        this.sex = sex;
    }
    
    public String getSpecie(){
        return specie;
    }
    
    public void setSpecie(String specie){
        this.specie = specie;
    }
    
    public String getBreed(){
        return breed;
    }
    
    public void setBreed(String breed){
        this.breed = breed;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public void setWeight(Double weight){
        this.weight = weight;
    }
    
    public String getSize(){
        return size;
    }
    
    public void setSize(String size){
        this.size = size;
    }
    
    public String getPrev_Vetrecord(){
        return prev_Vetrecord;
    }
    
    public void setPrev_Vetrecord(String prev_Vetrecord){
        this.prev_Vetrecord = prev_Vetrecord;
    }
    
    public boolean isHas_Allergy() {
        return has_Allergy;
    }
    
    public void setHas_Allergy(boolean has_Allergy) {
        this.has_Allergy = has_Allergy;
    }
    
    public String getAdd_Info() {
        return add_Info;
    }
    
    public void setAdd_Info(String add_Info) {
        this.add_Info = add_Info;
    }
    
    public String getConsult_Motive() {
        return consult_Motive;
    }
    
    public void setConsult_Motive(String consult_Motive) {
        this.consult_Motive = consult_Motive;
    }
    
    public String getAdvice(){
        return advice;
    }
    
    public void setAdvice(String advice){
        this.advice = advice;
    }

}
    
   
    
    