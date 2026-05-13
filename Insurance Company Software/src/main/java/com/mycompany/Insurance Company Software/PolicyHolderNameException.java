package com.mycompany.assignment3;

import java.io.Serializable;
import java.util.Scanner;

public class PolicyHolderNameException extends Exception implements Serializable {
    
    private String policyHolderName;
    
    public PolicyHolderNameException(String PolicyHolderName){
        
        this.policyHolderName = PolicyHolderName;
//        this.policyHolderName = getNewPolicyHolderName();
        
    }
    
    public String toString(){
        
        return "\nThe Policy Holder Name (" + policyHolderName + ") was not valid. The policy is not created.\n---PLEASE ENTER A VALID POLICY HOLDER NAME (FOR EXAMPLE: John Wick)\n";
       
    }
    
//    public String getNewPolicyHolderName(){
//        
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Enter a new policy holder name: ");
//        String newPolicyHoldName = scan.nextLine();
////        setPolicyHolderName(newPolHoldName);
//        return newPolicyHoldName;
//        
//    }
    
    public String getPolicyHolderName(){return policyHolderName;}
    
    public void setPolicyHolderName(String policyHolderName){this.policyHolderName = policyHolderName;}
     
}