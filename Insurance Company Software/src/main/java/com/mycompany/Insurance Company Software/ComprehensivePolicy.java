package com.mycompany.assignment3;

import java.io.Serializable;

// inheritance (this subclass extends to its parent class or superclass InsurancePolicy)
public class ComprehensivePolicy extends InsurancePolicy implements Serializable {
    
    protected int driverAge;
    protected int level;
    
    // constructor ComprehensivePolicy that saves its fields and its superclass fields
    public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) throws PolicyException, PolicyHolderNameException{
        
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.driverAge = driverAge;
        this.level = level;
        
    }
    
    // copy constructor
    public ComprehensivePolicy(ComprehensivePolicy cp){
        
        super(cp);
        this.driverAge = cp.driverAge;
        this.level = cp.level;
        
    }
    
    //print out the values of the superclass first and then the values that this class possesses using a print method
    @Override
    public void print(){
        
        super.print();
        System.out.print(" Drivers Age: " + driverAge + ", Level: " + level);
        System.out.println();
        
    }
    
    //do the same thing as the print method above, but with a toString
    @Override
    public String toString(){
        
        return super.toString() + " Drivers Age: " + driverAge + ", Level: " + level;
        
    }
    
    // calcPay method that takes a flatRate as a parameter and does the calculation for the comprehensivepolicy premium depending on the drivers age
    @Override
    public double calcPay(int flatRate){
        
        if(driverAge<30){
            
            return (car.price/50 + numberOfClaims * 200 + flatRate) + (30-driverAge)*50;
            
        }
        else
        
            return car.price/50 + numberOfClaims * 200 + flatRate;
        
    }
    
    @Override
    public String toDelimitedString(){
        
        return "CP" + "," + super.toDelimitedString() + "," + driverAge + "," + level;
        
    }
    
}
