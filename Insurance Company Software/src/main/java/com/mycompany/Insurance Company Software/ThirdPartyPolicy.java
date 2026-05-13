package com.mycompany.assignment3;

import java.io.Serializable;

// inheritance (this subclass extends to its parent class or superclass InsurancePolicy)
public class ThirdPartyPolicy extends InsurancePolicy implements Serializable{
    
    protected String comments;
    
    // constructor ThirdPartyPolicy that saves its fields and its superclass fields
    public ThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) throws PolicyException, PolicyHolderNameException{
        
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.comments = comments;
        
    }
    
    // copy constructor
    public ThirdPartyPolicy(ThirdPartyPolicy tpp){
        
        super(tpp);
        this.comments = tpp.comments;
        
    }
    
    //print out the values of the superclass first and then the values that this class possesses using a print method
    @Override
    public void print(){
        
        super.print();
        System.out.print(" Comments: " + comments);
        System.out.println();
        
        
    }
    
    //do the same thing as the print method above, but with a toString
    @Override
    public String toString(){
        
        return super.toString() + " Comments: " + comments;
        
    }
    
    // calcPay method that takes a flatRate as a parameter and does the calculation for the thirdpartypolicy premium
    @Override
    public double calcPay(int flatRate){
        
        return car.price/100 + numberOfClaims * 200 + flatRate;
        
    }
    
    @Override
    public String toDelimitedString(){
        
        return "TPP" + "," + super.toDelimitedString() + "," + comments;
        
    }
    
    
    
}
