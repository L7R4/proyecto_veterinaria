package Design;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

//This class is designed to create Items (like medicines, accessories, supplies, etc) for the system's Inventory list.

public class InventoryItem implements Serializable
{
    //Atributes
    private String name_Item;
    private String brand_Item;
    private int quantity_Item;
    private LocalDate expDate_Item;
    private boolean expired_Item;
    
    //file to store items
    private static final String ITEMS_FILE = "ITEMS_FILE.txt";
    
    
    //Empty Constructor
    public InventoryItem(){
    }
    
    
    //Constructor
    public InventoryItem(String name_Item, String brand_Item, int quantity_Item, LocalDate expDate_Item, boolean expired_Item){
        this.name_Item = name_Item;
        this.brand_Item = brand_Item;
        this.quantity_Item = quantity_Item;
        this.expDate_Item = expDate_Item;
        this.expired_Item = expired_Item;
    }
    
    
    //Getters and Setters

    public String getName_Item(){
        return this.name_Item;
    }

    public void setName_Item(String name_Item){
        this.name_Item = name_Item;
    }

    public String getBrand_Item(){
        return this.brand_Item;
    }

    public void setBrand_Item(String brand_Item){
        this.brand_Item = brand_Item;
    }

    public int getQuantity_Item(){
        return this.quantity_Item;
    }

    public void setQuantity_Item(int quantity_Item){
        this.quantity_Item = quantity_Item;
    }
    
    public LocalDate getExpDate_Item(){
        return this.expDate_Item;
    }

    public void setExpDate_Item(LocalDate expDate_Item){
        this.expDate_Item = expDate_Item;
    }
    
    public boolean isExpired_Item(){
        return expired_Item;
    }
    
    public void setExpired_Item(boolean expired_Item){
        this.expired_Item = expired_Item;
    }
    
    

    //Methods
    
    //'checkExpiration' is a method that checks item's expiration date 
    public void checkExpiration() {
        if (LocalDate.now().isAfter(expDate_Item)) {
            this.expired_Item = true;
        } else {
            this.expired_Item = false;
        }
    }
    
    
    
}
