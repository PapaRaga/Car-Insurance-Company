package com.mycompany.assignment3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.Comparator;

public abstract class InsurancePolicy implements Cloneable, Comparable<InsurancePolicy>, Serializable {
    
    protected String policyHolderName;  
    protected int id;
    protected Car car; 
    protected int numberOfClaims; 
    protected MyDate expiryDate;
    
    // constructor InsurancePolicy that saves its fields
    public InsurancePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate) throws PolicyException, PolicyHolderNameException{
        
        this.car = car;
        
        if(id < 3000000 || id > 3999999){
            
            throw new PolicyException(id);
            
        }
        
        // David Wick
        
        String nameRegex = "[A-Z][a-zA-Z]+\\s[A-Z][a-zA-Z]+";
        Pattern myPattern = Pattern.compile(nameRegex);
        Matcher myMatch = myPattern.matcher(policyHolderName);
        
        if(!myMatch.matches()){
            
            throw new PolicyHolderNameException(policyHolderName);
            
        }
        
        this.id = id;
        this.numberOfClaims = numberOfClaims;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        
    }
    
    // copy constructor
    public InsurancePolicy(InsurancePolicy ip){
        
        this.policyHolderName = ip.policyHolderName;
        this.id = ip.id;
        this.car = new Car(ip.car);
        this.numberOfClaims = ip.numberOfClaims;
        this.expiryDate = new MyDate(ip.expiryDate);
        
    }
    
    //print out the values using a print method
    public void print(){
    
        System.out.print("Car Info: " + car + ", id: " + id + ", numberOfClaims: " + numberOfClaims + ", policyHolderName: " + policyHolderName + ", Expiry Date: " + expiryDate);
        
    }
    
    //do the same thing as the print method above, but with a toString
    @Override
    public String toString(){
        
        return "Car Info: " + car + ", id: " + id + ", numberOfClaims: " + numberOfClaims + ", policyHolderName: " + policyHolderName + ", Expiry Date: " + expiryDate;
        
    }
    
    // the calcPay method that is meant to be overridden in any concrete subclasses
    public abstract double calcPay(int flatRate);
    
    // printPolicies method that goes through the arraylist that has the policies and prints them
//    static void printPolicies(ArrayList<InsurancePolicy> policies){
//        
//        for(InsurancePolicy ip: policies){
//            
//            ip.print();
//            
//        }
//        
//    }
    
    static void printPolicies(ArrayList<InsurancePolicy> policies){
        
        policies.forEach(System.out::println);
        // or policies.forEach(x->x.print());
        // or policies.forEach(x->xSystem.out.println(x));
        
        
    }
    
    static void printPolicies(HashMap<Integer, InsurancePolicy> printThemPolicies){
        
        for(InsurancePolicy ip: printThemPolicies.values()){
            
            ip.print();
            
        }
        
    }
    
    // calculates the total premium payments for a list of policies
//    static double calcTotalPayments(ArrayList<InsurancePolicy> policies, int flatRate){
//        
//        double total = 0;
//        
//        for(InsurancePolicy ip: policies){
//            
//            total += ip.calcPay(flatRate);
//            
//        }
//        
//        return total;
//    }
    
    static double calcTotalPayments(ArrayList<InsurancePolicy> policies, int flatRate){
        
        return policies.stream()
                .map(x->x.calcPay(flatRate))
                .reduce(0.0, (x,y)->x+y);
        
        //or
        
//        return policies.stream()
//                .mapToDouble(x->x.calcPay(flatRate))
//                .sum();
                
    }
    
    static double calcTotalPayments(HashMap<Integer, InsurancePolicy> calcTheTotalPayments, int flatRate){
        
        double total = 0;
        
        for(InsurancePolicy ip: calcTheTotalPayments.values()){
            
            total += ip.calcPay(flatRate);
            
        }
        
        return total;
          
    }
    
    // The method increases the policy’s car price by rise percent and it calls the priceRise method from the Car class to do so
    void carPriceRise(double risePercent){
        
        car.priceRise(risePercent);
        
    }
    
     //carPriceRiseAll method calls the carPriceRise method (the one above) to increase the price of cars for all policies in a list
//    static void carPriceRiseAll(ArrayList<InsurancePolicy> policies, double risePercent){
//        
//        for(InsurancePolicy ip: policies){
//            
//            ip.carPriceRise(risePercent);
//            
//        }
//        
//    }
    
    static void carPriceRiseAll(ArrayList<InsurancePolicy> policies, double risePercent){
        
        policies.stream()
                .forEach(x->x.carPriceRise(risePercent));
                
        
    }
    
    static void carPriceRiseAll(HashMap<Integer, InsurancePolicy> raiseThePriceForAllCars, double risePercent){
        
        for(InsurancePolicy ip: raiseThePriceForAllCars.values()){
            
            ip.carPriceRise(risePercent);
            
        }
        
    }
    
    // filterByCarModel filters a list of policies and creates a filtered list of policies, which all have the car model that is given (inputed)
//    static ArrayList<InsurancePolicy> filterByCarModel(ArrayList<InsurancePolicy> policies, String carModel){
//        
//        ArrayList<InsurancePolicy> filterCarModel = new ArrayList<>();
//        
//        for(InsurancePolicy ip: policies){
//            
//            if(ip.car.model.contains(carModel)){
//                
//                filterCarModel.add(ip);
//                
//            }
//            
//        }
//        return filterCarModel;
//        
//    }
    
    static ArrayList<InsurancePolicy> filterByCarModel(ArrayList<InsurancePolicy> policies, String carModel){
        
        return(ArrayList<InsurancePolicy>)(policies.stream()
                .filter(x->x.getCar().getModel().contains(carModel))
                .collect(Collectors.toList()));
        
    }
    
    static HashMap<Integer, InsurancePolicy> filterByCarModel(HashMap<Integer, InsurancePolicy> filterCarModelHash, String carModel){
        
        HashMap<Integer, InsurancePolicy> filteredPoliciesByCarModel = new HashMap<Integer, InsurancePolicy>();
        
        for(InsurancePolicy ip: filterCarModelHash.values()){
            
            if(ip.car.model.contains(carModel)){
                
                filteredPoliciesByCarModel.put(ip.id, ip);
                
            }
            
        }
        
        return filteredPoliciesByCarModel;
        
    }
    
    // this method checks whether every policy has expired or not and returns a list of policies that have expired 
//    static ArrayList<InsurancePolicy> filterByExpiryDate(ArrayList<InsurancePolicy> policies, MyDate date){
//        
//        ArrayList<InsurancePolicy> filteredDates = new ArrayList<>();
//        
//        for(InsurancePolicy ip: policies){
//            
//            if(ip.expiryDate.isExpired(date)){
//                filteredDates.add(ip);
//            }
//            
//        }
//        return filteredDates;
//        
//    }
    
    static ArrayList<InsurancePolicy> filterByExpiryDate(ArrayList<InsurancePolicy> policies, MyDate date){
        
        //ArrayList<InsurancePolicy> filteredDates = new ArrayList<>();
        
        return (ArrayList<InsurancePolicy>)(policies.stream()
                .filter(x->x.expiryDate.isExpired(date))
                .collect(Collectors.toList()));
        
    }
    
    static HashMap<Integer, InsurancePolicy> filterByExpiryDate(HashMap<Integer, InsurancePolicy> filteredExpDateHash, MyDate date){
        
        HashMap<Integer, InsurancePolicy> filteredPoliciesByExpDate = new HashMap<Integer, InsurancePolicy>();
        
        for(InsurancePolicy ip: filteredExpDateHash.values()){
            
            if(ip.expiryDate.isExpired(date)){
                
                filteredPoliciesByExpDate.put(ip.id, ip);
                
            }
            
        }
        
        return filteredPoliciesByExpDate;
        
        
    }
    
    @Override
    public InsurancePolicy clone() throws CloneNotSupportedException{
        
        InsurancePolicy output = (InsurancePolicy) super.clone();
        output.car = car.clone();
        output.expiryDate = expiryDate.clone();
        return output;
        
    }
    
//    static ArrayList<InsurancePolicy> shallowCopy(ArrayList<InsurancePolicy> policies) throws CloneNotSupportedException{
//        
//        ArrayList<InsurancePolicy> shallowCopy = new ArrayList<InsurancePolicy>();
//        
//        for(InsurancePolicy ip: policies){
//            
//            shallowCopy.add(ip);
//            
//        }
//        
//        return shallowCopy;
//        
//    }
    
    static HashMap<Integer, InsurancePolicy> shallowCopy(HashMap<Integer, InsurancePolicy> policies) throws CloneNotSupportedException{
        
        return (HashMap<Integer, InsurancePolicy>) policies.values().stream()
                .map(x->x)
                .collect(Collectors.toMap(InsurancePolicy::getID, x->x));
        
    }
    
//    static ArrayList<InsurancePolicy> deepCopy(ArrayList<InsurancePolicy> policies) throws CloneNotSupportedException{
//        
//        ArrayList<InsurancePolicy> deepCopy = new ArrayList<InsurancePolicy>();
//        
//        for(InsurancePolicy ip: policies){
//            
//            deepCopy.add(ip.clone());
//            
//        }
//        
//        return deepCopy;
//    }
    
    static HashMap<Integer, InsurancePolicy> deepCopy(HashMap<Integer, InsurancePolicy> policies) throws CloneNotSupportedException{
        
//        ArrayList<InsurancePolicy> deepCopy1 = new ArrayList<>();
//        
//        try{
//            
//            deepCopy1 = (ArrayList<InsurancePolicy>)(policies.stream()
//                    .map(x-> )
//                    .collect(Collectors.toList()));
//
//            
//            
//        }catch(CloneNotSupportedException e){
//            
//            System.out.print(e);
//            
//        }
//        
//        return deepCopy1;

//        ArrayList<InsurancePolicy> deepCopy = new ArrayList<>(); 
        
        return (HashMap<Integer, InsurancePolicy>)policies.values().stream()
                .map(x -> x instanceof ThirdPartyPolicy ? new ThirdPartyPolicy((ThirdPartyPolicy)x) : new ComprehensivePolicy((ComprehensivePolicy)x))
                .collect(Collectors.toMap(InsurancePolicy::getID, x->x));
    }
    
//    static ArrayList<InsurancePolicy> shallowCopy(HashMap<Integer, InsurancePolicy> policies) throws CloneNotSupportedException{
//        
//        ArrayList<InsurancePolicy> shallowCopy = new ArrayList<InsurancePolicy>();
//        
//        for(InsurancePolicy ip: policies.values()){
//            
//            shallowCopy.add(ip);
//            
//        }
//        
//        return shallowCopy;
//        
//    }
    
//    static ArrayList<InsurancePolicy> deepCopy(HashMap<Integer, InsurancePolicy> policies) throws CloneNotSupportedException{
//        
//        ArrayList<InsurancePolicy> deepCopy = new ArrayList<InsurancePolicy>();
//        
//        for(InsurancePolicy ip: policies.values()){
//            
//            deepCopy.add(ip.clone());
//            
//        }
//        
//        return deepCopy;
//        
//    }
    
    static HashMap<Integer, InsurancePolicy> shallowCopyHashMap(HashMap<Integer, InsurancePolicy> policies) throws CloneNotSupportedException{
        
        HashMap<Integer, InsurancePolicy> shallowCopyHM = new HashMap<Integer, InsurancePolicy>();
        
        for(InsurancePolicy ip: policies.values()){
            
            shallowCopyHM.put(ip.id, ip);
            
        }
        
        return shallowCopyHM;
        
    }
    
    static HashMap<Integer, InsurancePolicy> deepCopyHashMap(HashMap<Integer, InsurancePolicy> policies) throws CloneNotSupportedException{
        
        HashMap<Integer, InsurancePolicy> deepCopyHM = new HashMap<Integer, InsurancePolicy>();
        
        for(InsurancePolicy ip: policies.values()){
            
            deepCopyHM.put(ip.id, ip.clone());
            
        }
        
        return deepCopyHM;
        
    }
    
    @Override
    public int compareTo(InsurancePolicy otherInsurancePolicy){
        
        return expiryDate.compareTo(otherInsurancePolicy.expiryDate);
        
    }
    
    public int compareTo2(InsurancePolicy otherInsurancePolicy){
        
        return this.getPolicyHolderName().compareTo(otherInsurancePolicy.policyHolderName);
        
    }
    
    static HashMap<Integer, InsurancePolicy> load(String fileName){
        
        HashMap<Integer, InsurancePolicy> loadingTheDataBack = new HashMap<>();
        
        ObjectInputStream loadingData = null;
        
        try{
            
            loadingData = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
            
        }catch(IOException ex){
            
            System.err.println("error in create/open the file");
            System.exit(1);
            
        }
        
        try{
            
            while(true){
                
                InsurancePolicy ip = (InsurancePolicy) loadingData.readObject();
                loadingTheDataBack.put(ip.id, ip);
                
            }
            
        }catch(EOFException ex){
            
            System.out.println("no more record!");
            
        }
        
        catch(ClassNotFoundException ex){
            
            System.err.println("error in wrong class in the file");
            
        }
        
        catch(IOException ex){
            
            System.err.println("error in add object to the file");
            System.exit(1);
            
        }
        
        try{
            
            if(loadingData != null){
                
                loadingData.close();
                
            }
            
        }
        catch(IOException ex){
            
            System.err.println("error in close the file");
            System.exit(1);
            
        }
        
        return loadingTheDataBack;
        
    }
    
    static Boolean save(HashMap<Integer, InsurancePolicy> read, String fileName){
        
        ObjectOutputStream savingToBinaryFile = null;
        
        boolean saving = true;
        
        try{
            
            savingToBinaryFile = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
            
        }catch(IOException e){
            
            System.err.println("error in create/open the file");
            saving = false;
            System.exit(1);
            
        }
        
        try{
            
            for(InsurancePolicy ip: read.values()){
                
                savingToBinaryFile.writeObject(ip);
                
            }
            
        }catch(IOException ex){
            
            System.err.println("error in adding the objects to the file");
            saving = false;
            System.exit(1);
            
        }
        
        try{
            
            if(savingToBinaryFile != null){
                
                savingToBinaryFile.close();
                
            }
            
        }catch(IOException ex){
            
            System.err.println("error in closing the file");
            saving = false;
            System.exit(1);
            
        }
        
        return saving;
        
    }
    
    public String toDelimitedString(){
        
        return policyHolderName + "," + id + "," + car.toDelimitedString() + "," + numberOfClaims + "," + expiryDate.toDelimitedString();
        
    }
    
    static HashMap<Integer, InsurancePolicy> loadTextFile(String fileName) throws IOException, PolicyException, PolicyHolderNameException{
        
        HashMap<Integer, InsurancePolicy> files = new HashMap<>();
        
        BufferedReader loadTF = new BufferedReader(new FileReader(fileName));
        
        String line = loadTF.readLine();
        
        while(line != null){
            
            line = line.trim();
            String[] field = line.split(",");
            
            switch(field[0]){
                
                case "TPP":
                    
                    String policyHolderName = field[1];
                    int id = Integer.parseInt(field[2]);
                    String model = field[3];
                    int ManufacturingYear = Integer.parseInt(field[4]);
                    double price = Double.parseDouble(field[5]);
                    CarType type = CarType.valueOf(field[6]);
                    int numberOfClaims = Integer.parseInt(field[7]);
                    int day = Integer.parseInt(field[8]);
                    int month = Integer.parseInt(field[9]);
                    int year = Integer.parseInt(field[10]);
                    String comments = field[11];
                    
                    Car carForText = new Car(model, ManufacturingYear, price, type);
                    MyDate dateForText = new MyDate(year, month, day);
                    
                    ThirdPartyPolicy tppForTextFile = new ThirdPartyPolicy(policyHolderName, id, carForText, numberOfClaims, dateForText, comments);
                    
                    files.put(tppForTextFile.id, tppForTextFile);
                    break;
                
                case "CP":
                    
                    policyHolderName = field[1];
                    id = Integer.parseInt(field[2]);
                    model = field[3];
                    ManufacturingYear = Integer.parseInt(field[4]);
                    price = Double.parseDouble(field[5]);
                    type = CarType.valueOf(field[6]);
                    numberOfClaims = Integer.parseInt(field[7]);
                    day = Integer.parseInt(field[8]);
                    month = Integer.parseInt(field[9]);
                    year = Integer.parseInt(field[10]);
                    int driverAge = Integer.parseInt(field[11]);
                    int level = Integer.parseInt(field[12]);
                    
                    Car carForText2 = new Car(model, ManufacturingYear, price, type);
                    MyDate dateForText2 = new MyDate(year, month, day);
                    
                    ComprehensivePolicy cpForTextFile = new ComprehensivePolicy(policyHolderName, id, carForText2, numberOfClaims, dateForText2, driverAge, level);
                    
                    files.put(cpForTextFile.id, cpForTextFile);
                    
                    break;
                
            }
            
            line = loadTF.readLine();
            
        }
        
        loadTF.close();
        return files;
        
    }
    
    static Boolean saveTextFile(HashMap<Integer, InsurancePolicy> textFile, String fileName) throws IOException{
        
        BufferedWriter saveTF = new BufferedWriter(new FileWriter(fileName));
        
        try{
            
            for(InsurancePolicy ip: textFile.values()){
            
                saveTF.write(ip.toDelimitedString() + "\n");
            
            
            }
            
            return true;
            
        }finally{
            
            saveTF.close();
            
        }
         
    }
    
    // getters and setters for the values
    public String getPolicyHolderName(){return policyHolderName;}
    public void setPolicyHolderName(String policyHolderName){this.policyHolderName = policyHolderName;}
        
    public int getID(){return id;}
    public void setID(int id){this.id = id;}
        
    public Car getCar(){return car;}
    public void setCar(Car car){this.car = car;}
        
    public int getNumberOfClaims(){return numberOfClaims;}
    public void setNumberOfClaims(int numberOfClaims){this.numberOfClaims = numberOfClaims;}
        
    public MyDate getExpiryDate(){return expiryDate;}
    public void setExpiryDate(MyDate expiryDate){this.expiryDate = expiryDate;}
    
}
