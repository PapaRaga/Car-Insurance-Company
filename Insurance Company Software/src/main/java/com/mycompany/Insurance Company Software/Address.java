package com.mycompany.assignment3;

import java.io.Serializable;

public class Address implements Cloneable, Comparable<Address>, Serializable{
    
    protected int streetNum;
    protected String street;
    protected String suburb;
    protected String city;
    
    // constructor Address that saves its fields
    public Address(int streetNum, String street, String suburb, String city){
        
        this.city = city;
        this.street = street;
        this.streetNum = streetNum;
        this.suburb = suburb;
        
    }
    
    // copy constructor
    public Address(Address location){
        
        this.streetNum = location.streetNum;
        this.street = location.street;
        this.suburb = location.suburb;
        this.city = location.city;
        
    }
    
    //print out the values using a print method
    public void print(){
        
        System.out.println(streetNum + " " + street + ", " + suburb + ", " + city);
        
    }
    
    //do the same thing as the print method above, but with a toString
    @Override
    public String toString(){
        
        return streetNum + " " + street + ", " + suburb + ", " + city;
        
    }
    
    @Override
    public Address clone() throws CloneNotSupportedException{
        
        return (Address)super.clone();
        
    }
    
    @Override
    public int compareTo(Address otherAddress){
        
        return city.compareTo(otherAddress.city);
        
    }
    
    public String toDelimitedString(){
        
        return streetNum + "," + street + "," + suburb + "," + city;
        
    } 
    
    // getters and setters for the values
    public int getStreetNum(){return streetNum;} 
    public void setStreetNum(int streetNum){this.streetNum = streetNum;}
        
    public String getCity(){return city;}
    public void setCity(String city){this.city = city;}
        
    public String getStreet(){return street;}
    public void setStreet(String street){this.street = street;}
        
    public String getSuburb(){return suburb;}
    public void setSuburb(String suburb){this.suburb = suburb;}
        
}
