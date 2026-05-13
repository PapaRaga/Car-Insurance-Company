package com.mycompany.assignment3;

import java.io.Serializable;

//enum that contains the type of cars
enum CarType {SUV,SED,LUX,HATCH}

public class Car implements Cloneable, Serializable {
    
    protected String model;
    protected int ManufacturingYear;
    protected double price;
    protected CarType type;
    
    //construcotr Car that has its fields
    public Car(String model, int ManufacturingYear, double price, CarType type){
        
        this.ManufacturingYear = ManufacturingYear;
        this.model = model;
        this.price = price;
        this.type = type;
        
    }
    
    // copy constructor
    public Car(Car aCar){
        
        this.model = aCar.model;
        this.ManufacturingYear = aCar.ManufacturingYear;
        this.price = aCar.price;
        this.type = aCar.type;
        
    }
    
    //print out the values using a print method
    public void print(){
       
        System.out.print(" Model: " + model + "," + " ManufacturingYear: " + ManufacturingYear + ", Type: " + type + ", Price: ($" + price + ")");
        
    }
     
    //do the same thing as the print method above, but with a toString
    @Override     
    public String toString(){
        
        return " Model: " + model + "," + " ManufacturingYear: " + ManufacturingYear + ", Type: " + type + ", Price: ($" + price + ")";
        
    }
    
    // priceRise method that calculates the price of the car after it gets an rise
    public void priceRise(double rise){
        
        price = price*(1 + rise);
        
    }
    
    @Override
    public Car clone() throws CloneNotSupportedException{
        
        return (Car)super.clone();       
        
    }
    
    public String toDelimitedString(){
        
        return model+ "," +ManufacturingYear+ "," +price+ "," +type;
//        "C" + "," 
        
    }
    
    // getters and setters for the values
    public String getModel(){return model;}
    public void setModel(String model){this.model = model;}
    
    public int getManufacturingYear(){return ManufacturingYear;}
    public void setManufacturingYear(int ManufacturingYear){this.ManufacturingYear = ManufacturingYear;}
        
    public double getPrice(){return price;}
    public void setPrice(double price){this.price = price;}
        
    public CarType getType(){return type;}
    public void setType(CarType type){this.type = type;}
    
}
