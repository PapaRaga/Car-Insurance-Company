package com.mycompany.assignment3;

import java.io.Serializable;

public class MyDate implements Cloneable, Comparable<MyDate>, Serializable {
    
    protected int year;
    protected int month;
    protected int day;
    
    // constructor MyDate that saves its fields
    public MyDate(int year, int month, int day){
        
        this.day = day;
        this.month = month;
        this.year = year;
        
    }
    
    // copy constructor
    public MyDate(MyDate md){
        
        this.year = md.year;
        this.month = md.month;
        this.day = md.day;
        
    }
    
    // this method checks whether an policy is expired or not
    boolean isExpired(MyDate expiryDate){
        
        if(expiryDate.year < year){
            
            return false;
            
        }else if(expiryDate.year == year && expiryDate.month < month){
            
            return false;
            
        }else if (expiryDate.year == year && expiryDate.month == month && day >= expiryDate.day){
            
            return false;
        }else
            return true;
                    
    }
    
    
    //print out the values using a print method
    public void print(){
        
        System.out.println(day + "/" + month + "/" + year + ",");
        
    }
    
    //do the same thing as the print method above, but with a toString
    @Override
    public String toString(){
        
       return day + "/" + month + "/" + year; 
        
    }
    
    @Override
    public MyDate clone() throws CloneNotSupportedException{
        
        return (MyDate)super.clone();
        
    }
    
    @Override
    public int compareTo(MyDate otherMyDate){
        
        if(otherMyDate.year < year){
            
            return -1;
            
        }else if(otherMyDate.year == year && otherMyDate.month < month){
            
            return -1;
            
        }else if (otherMyDate.year == year && otherMyDate.month == month && day >= otherMyDate.day){
            
            return -1;
            
        }else
            
            return 1;
        
    }
    
    public String toDelimitedString(){
        
        return day + "," + month + "," + year;
        // "MD" + "," + 
        
    }
    
    // getters and setters for the values
    public int getYear(){return year;}
    public void setYear(int year){this.year = year;}
    
    public int getMonth(){return month;}
    public void setMonth(int month){this.month = month;}
        
    public int getDay(){return day;}
    public void setDay(int day){this.day = day;}
    
}
