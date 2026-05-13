package com.mycompany.assignment3;

import java.io.Serializable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Comparator;

public class User implements Cloneable, Comparable<User>, Serializable {
    
    private String name;
    private int userID;
    private Address address;
    //ArrayList<InsurancePolicy> policies;
    HashMap<Integer, InsurancePolicy> allThePoliciesForTheUser;
    private String userPassword;
    // count that increases each time a new user is created
    private static int count = 1;
    
    // constructor User that saves its fields
    public User(String name, Address address, String password){
        
        this.address = address;
        this.userPassword = password;
        this.name = name;
        this.userID = count;
        count++;
        allThePoliciesForTheUser = new HashMap<Integer, InsurancePolicy>();
        
    }
    
    // copy constructor
    public User(User aUser){
        
        this.name = aUser.name;
        this.userID = aUser.userID; 
        this.address = new Address(aUser.address);
        allThePoliciesForTheUser = new HashMap<Integer, InsurancePolicy>();
        
    }
    
    boolean userValidate(String username, String password){
        
        if(name.equals(username) && userPassword.equals(password)){
            
            return true;
            
        }
        
        return false;
        
    }
    
//    // findPolicy loops through a list of policies and checks if the id of that policie exists and returns it (if it doesn't it returns null)
//    InsurancePolicy findPolicy(int policyID){
//        
//        for(InsurancePolicy ip: policies){
//            
//            if(ip.id == policyID)
//                return ip;
//        }
//  
//        return null;
//        
//    }
    
    // findPolicy loops through a list of policies and checks if the id of that policie exists and returns it (if it doesn't it returns null)
    InsurancePolicy findPolicy(int policyID, String username, String password){
        
        if(userValidate(username, password)){
            
            return allThePoliciesForTheUser.get(policyID);
            
        }
        
        return null;
        
    }
    
//    // addPolicy adds a policy to the list of policies if the id of the policie is not found in the list otherwise (if the id of the policy is found in the policy list) it returns false
//    boolean addPolicy(InsurancePolicy policy){
//        
//        if(findPolicy(policy.id) == null){
//            
//            policies.add(policy);
//            return true;
//            
//        }
//        else
//            return false;
//        
//    }
    
    // addPolicy adds a policy to the list of policies if the id of the policie is not found in the list otherwise (if the id of the policy is found in the policy list) it returns false
    boolean addPolicy(InsurancePolicy policy, String username, String password){
        
        if(userValidate(username, password)){
            
            if(findPolicy(policy.id, username, password) == null){
            
                allThePoliciesForTheUser.put(policy.id, policy);
                return true;

            }
            else
                return false;
            
        }
        
        return false;
        
    }
    
    // prints all the policies this user owns as well as the premium payment for each policy 
//    public void printPolicies(int flatRate){
//        
//        for(InsurancePolicy ip: policies){
//            
//            ip.print();
//            System.out.print("The premium payment for this policy is: $" + ip.calcPay(flatRate) + "\n");
//            System.out.println();
//            
//        }
//        
//    }
    
    public void printPolicies(int flatRate){
        
        allThePoliciesForTheUser.values().forEach(x-> {
            
            System.out.println(x);
            System.out.println("The premium payment for this policy is: $" + x.calcPay(flatRate) + "\n");
            
        });
        
    }
    
    
    public void printPolicies(int flatRate, String username, String password){
        
        if(userValidate(username, password)){
            
            for(InsurancePolicy ip: allThePoliciesForTheUser.values()){
            
                ip.print();
                System.out.print("The premium payment for this policy is: $" + ip.calcPay(flatRate) + "\n");
                System.out.println();

            }
            
        }
        
    }
    
    //  returns the total premium payments for this user
//    double calcTotalPremiums(int flatRate){
//        
//        return InsurancePolicy.calcTotalPayments(policies, flatRate);
//        
//    }
    
    double calcTotalPremiums(int flatRate, String username, String password){
        
        if(userValidate(username, password)){
            
            return InsurancePolicy.calcTotalPayments(allThePoliciesForTheUser, flatRate);
            
        }
        
        return 0;
        
    }
    
    // this method increases the car  price for all the policies the user owns
//    void carPriceRiseAll(double risePercent){
//        
//        InsurancePolicy.carPriceRiseAll(policies, risePercent);
//    }
    
    void carPriceRiseAll(double risePercent, String username, String password){
        
        if(userValidate(username, password)){
            
            InsurancePolicy.carPriceRiseAll(allThePoliciesForTheUser, risePercent);
            
        }
        
    }
    
    // filters the policies and returns a list of policies with the car model containing the given carModel by the user 
    ArrayList<InsurancePolicy> filterByCarModel(String carModel){
        
        Collection<InsurancePolicy> collectedCars = allThePoliciesForTheUser.values();
        
        ArrayList<InsurancePolicy> filteredCars = new ArrayList<>(collectedCars);
        
        return InsurancePolicy.filterByCarModel(filteredCars, carModel);
        
    }
    
    HashMap<Integer, InsurancePolicy> filterByCarModel(String carModel, String username, String password){
        
        if(userValidate(username, password)){
            
            return InsurancePolicy.filterByCarModel(allThePoliciesForTheUser, carModel);
            
        }
        
        return null;
        
    }
    
    boolean createThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments, String username, String password) throws PolicyException, PolicyHolderNameException{
        
        if(userValidate(username, password)){
            
            ThirdPartyPolicy ttp = new ThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
            return addPolicy(ttp, username, password);
            
        }
        
        return false;
        
    }
    
    boolean createComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level, String username, String password) throws PolicyException, PolicyHolderNameException{
        
        if(userValidate(username, password)){
            
            ComprehensivePolicy cp = new ComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
            return addPolicy(cp, username, password);
            
        }
        
        return false;
        
    }
    
//    ArrayList<InsurancePolicy> filterByExpiryDate(MyDate date){
//        
//        return InsurancePolicy.filterByExpiryDate(policies, date);
//    }
    
    HashMap<Integer, InsurancePolicy> filterByExpiryDate(MyDate date, String username, String password){
        
        if(userValidate(username, password)){
            
            return InsurancePolicy.filterByExpiryDate(allThePoliciesForTheUser, date);
            
        }
        
        return null;
        
    }
    
    // prints all the information of this user including all the policies information
//    public void print(){
//        
//        System.out.print("Name of the user: " + name + ", User ID: " + userID + ", Address: " + address + "\n");
//        InsurancePolicy.printPolicies(policies);
//         
//    }
    
    public void print(String username, String password){
        
        if(userValidate(username, password)){
            
            System.out.print("Name of the user: " + name + ", User ID: " + userID + ", Address: " + address + "\n");
            InsurancePolicy.printPolicies(allThePoliciesForTheUser);
            
        }
         
    }
    
    public static void printUsers(HashMap<Integer, User> printAllUsersOnlyWP){
        
        for(User printUser: printAllUsersOnlyWP.values()){
            
            System.out.print("Name of the user: " + printUser.getName() + ", User ID: " + printUser.getUserID() + ", Address: " + printUser.getAddress() + "\n");
            
            
        }
        
    }
    
    // converts all the user information into a string and then loops through the policies of the user and prints them out 
//    @Override
//    public String toString(){
//        
//        String information = "Name of the user: " + name + ", User ID: " + userID + ", Address is: " + address + " and the user policy/ies is/are: \n";
//        
//        System.out.println();
//        
//        for(InsurancePolicy ip: policies){
//            
//            information += ip + "\n";
//            
//        }
//        
//        return information;
//        
//    }
    
    @Override
    public String toString(){
        
        String information = "Name of the user: " + name + ", User ID: " + userID + ", Address is: " + address + " and the user policy/ies is/are: \n";
        
        System.out.println();
        
        for(InsurancePolicy ip: allThePoliciesForTheUser.values()){
            
            information += ip + "\n";
            
        }
        
        return information;
        
    }
    
    // Goes through all the policies for a user and populates a list of distinct car model names 
//    ArrayList<String> populateDistinctCarModels(){
//        
//        ArrayList<String> carModel = new ArrayList<>();
//        //System.out.println(policies.size());
//        for(InsurancePolicy ip: policies){
//            //System.out.println(ip.getCar().getModel());
//            boolean found = false;
//            for(String cm: carModel){
//                
//                if(ip.getCar().getModel().contains(cm)){
//                    
//                    found = true;
//                    
//                    break;
//                    
//                    
//                }
//                
//            }
//            if(!found){
//                
//                carModel.add(ip.getCar().getModel());
//                
//            }
//                    
//        }
//        
//        return carModel;
//               
//    }
    
//    ArrayList<String> populateDistinctCarModels(String username, String password){
//        
//        if(userValidate(username, password)){
//            
//            ArrayList<String> carModel = new ArrayList<>();
//            //System.out.println(policies.size());
//            for(InsurancePolicy ip: allThePoliciesForTheUser.values()){
//                //System.out.println(ip.getCar().getModel());
//                boolean found = false;
//                for(String cm: carModel){
//
//                    if(ip.getCar().getModel().contains(cm)){
//
//                        found = true;
//
//                        break;
//
//                    }
//
//                }
//
//                if(!found){
//
//                    carModel.add(ip.getCar().getModel());
//
//                }
//
//            }
//
//            return carModel;
//            
//        }
//        
//        return null;
//               
//    }
    
    ArrayList<String> populateDistinctCarModels(String username, String password){
        
        if(userValidate(username, password)){
            
            return allThePoliciesForTheUser.values().stream()
                    .map(x->x.getCar().getModel())
                    .distinct()
                    .collect(Collectors.toCollection(ArrayList::new));
            
        }
        
        return null;
               
    }
    
    // returns the number of policies this user owns for the given carModel  
//    int getTotalCountForCarModel(String carModel){
//        
//        int count = 0;
//        for(InsurancePolicy ip: policies){
//            
//            if(ip.getCar().getModel().equals(carModel)){
//                //System.out.println(ip.getCar().getModel());
//                count++;
//                //System.out.println(count);
//                
//            }
//                 
//        }
//        
//        return count;
//        
//    }
    
    int getTotalCountForCarModel(String carModel, String username, String password){
        
        if(userValidate(username, password)){
            
            int count = 0;
            for(InsurancePolicy ip: allThePoliciesForTheUser.values()){

                if(ip.getCar().getModel().equals(carModel)){
                    //System.out.println(ip.getCar().getModel());
                    count++;
                    //System.out.println(count);

                }

            }

            return count;
            
        }
        
        return 0;
        
    }
    
    // returns the total payments for the given carModel across all the policies this user owns 
//    double getTotalPaymentForCarModel(String carModel){
//        
//        double total = 0;
//        for(InsurancePolicy ip: policies){
//            
//            if(ip.getCar().getModel().equals(carModel)){
//                
//                total += ip.calcPay(500);
//                
//            }
//            
//        }
//        return total;
//        
//        
//    }
    
    double getTotalPaymentForCarModel(String carModel, String username, String password){
        
        if(userValidate(username, password)){
            
            double total = 0;
            for(InsurancePolicy ip: allThePoliciesForTheUser.values()){

                if(ip.getCar().getModel().equals(carModel)){

                    total += ip.calcPay(500);

                }

            }

            return total;
            
        }
        
        return 0;
 
    }
    
    // returns the count for each model in the carModels as a list of integers
    ArrayList<Integer> getTotalCountPerCarModel(ArrayList<String> carModels, String username, String password){
        
        if(userValidate(username, password)){
        
            return carModels.stream()
                    .map(x->getTotalCountForCarModel(x, username, password))
                    .collect(Collectors.toCollection(ArrayList::new));
            
        }
        
        return null;
        
    }
    
//    HashMap<String, Integer> getTotalCountPerCarModel(String username, String password){
//        
//        if(userValidate(username, password)){
//            
//            //Toyota, Honda, Toyata, Benz, Benz
//            //[Toyota, 2], [Honda, 1], [Benz, 2]
//
//            HashMap<String, Integer> getTotCounPerCM = new HashMap<String, Integer>();
//
//            for(InsurancePolicy ip: allThePoliciesForTheUser.values()){
//
//                String carModel = ip.getCar().getModel();
//                Integer count = getTotCounPerCM.get(carModel); 
//
//                if(count == null){
//
//                    getTotCounPerCM.put(carModel, 1);
//
//                }else{
//
//                    getTotCounPerCM.put(carModel, count + 1);
//                }
//
//            }
//
//            return getTotCounPerCM;
//            
//        }
//        
//        return null;
//       
//    }
    
    HashMap<String, Integer> getTotalCountPerCarModel(String username, String password){
        
        if(userValidate(username, password)){
            
            //Toyota, Honda, Toyata, Benz, Benz
            //[Toyota, 2], [Honda, 1], [Benz, 2]

            HashMap<String, Integer> getTotCounPerCM = new HashMap<>();

            allThePoliciesForTheUser.values().forEach(x->
            
                    getTotCounPerCM.compute(x.getCar().getModel(), (key, count) -> (count == null) ? 1 : count + 1)
                    
            );

            return getTotCounPerCM;
            
        }
        
        return null;
       
    }
    
//    HashMap<String, Double> getTotalPremiumPerCarModel(String username, String password){
//        
//        if(userValidate(username, password)){
//            
//            HashMap<String, Double> getTotPremPerCM = new HashMap<String, Double>();
//        
//            for(InsurancePolicy ip: allThePoliciesForTheUser.values()){
//
//                String carModel = ip.getCar().getModel();
//
//                double premium = ip.calcPay(500);
//
//                if(getTotPremPerCM.containsKey(carModel)){
//
//                    double totalPremium = getTotPremPerCM.get(carModel) + premium;
//
//                    getTotPremPerCM.put(carModel, totalPremium);
//
//                }else{
//
//                    getTotPremPerCM.put(carModel, premium);
//
//                }
//
//            }
//
//            return getTotPremPerCM;
//            
//        }
//        
//        return null;
//        
//    }
    
    HashMap<String, Double> getTotalPremiumPerCarModel(String username, String password){
        
        if(userValidate(username, password)){
            
//            HashMap<String, Double> getTotPremPerCM = new HashMap<>();
        
            return (HashMap<String, Double>)allThePoliciesForTheUser.values().stream()
                    .collect(Collectors.groupingBy(x->x.getCar().getModel(), Collectors.summingDouble(x->x.calcPay(500)))
                    );
            
        }
        
        return null;
        
    }
    
//    void reportPaymentsPerCarModelWithHashMap(HashMap<String, Integer> counts, HashMap<String, Double> premiumPayments, String username, String password){
//        
//        if(userValidate(username, password)){
//            
//            System.out.printf("\n%-15s     %-25s     %-30s\n", ">Car Model<", ">Total Premium Payment<", ">Average Premium Payment<");
//        
//            for(String carModel: counts.keySet()){
//
//                System.out.printf("%-20s     %9.1f     %27.1f\n",carModel, premiumPayments.get(carModel), premiumPayments.get(carModel)/counts.get(carModel));
//
//            }
//            
//        }
//        
//    }
    
    void reportPaymentsPerCarModelWithHashMap(HashMap<String, Integer> counts, HashMap<String, Double> premiumPayments, String username, String password){
        
        if(userValidate(username, password)){
            
            System.out.printf("\n%-15s     %-25s     %-30s\n", ">Car Model<", ">Total Premium Payment<", ">Average Premium Payment<");
        
            counts.keySet().forEach(x-> {
                
                double totalPremium = premiumPayments.get(x);
                double averagePremium = totalPremium / counts.get(x);
                
                System.out.printf("%-20s     %9.1f     %27.1f\n",x, totalPremium, averagePremium);
                
            });
            
        }
        
    }
    
    // returns the Total Payment for each model in the carModels as a list of doubles
//    ArrayList<Double> getTotalPaymentPerCarModel(ArrayList<String> carModels, String username, String password){
//        
//        if(userValidate(username, password)){
//            
//            ArrayList<Double> totalPayment = new ArrayList<>();
//        
//            for(String cm: carModels){
//
//                totalPayment.add(getTotalPaymentForCarModel(cm, username, password));
//
//            }
//
//            return totalPayment;
//            
//        }
//        
//        return null;
//           
//    }
    
    ArrayList<Double> getTotalPaymentPerCarModel(ArrayList<String> carModels, String username, String password){
        
        if(userValidate(username, password)){
        
            return carModels.stream()
                    .map(x->getTotalPaymentForCarModel(x, username, password))
                    .collect(Collectors.toCollection(ArrayList::new));
            
        }
        
        return null;
           
    }
    
    // generates(creates) the report 
//    void reportPaymentsPerCarModel(ArrayList<String> carModels, ArrayList<Integer>counts, ArrayList<Double> premiumPayments, String username, String password){
//        
//        if(userValidate(username, password)){
//            
//            System.out.printf("\n%-15s     %-25s     %-30s\n", ">Car Model<", ">Total Premium Payment<", ">Average Premium Payment<");
//
//            for(int i=0; i < carModels.size(); i++){
//
//                System.out.printf("%-20s     %9.1f     %27.1f\n",carModels.get(i), premiumPayments.get(i), premiumPayments.get(i)/counts.get(i));
//
//            }
//            
//        }
//          
//    }
    
    void reportPaymentsPerCarModel(ArrayList<String> carModels, ArrayList<Integer>counts, ArrayList<Double> premiumPayments, String username, String password){
        
        if(userValidate(username, password)){
            
            System.out.printf("\n%-15s     %-25s     %-30s\n", ">Car Model<", ">Total Premium Payment<", ">Average Premium Payment<");

            for(int i=0; i < carModels.size(); i++){

                System.out.printf("%-20s     %9.1f     %27.1f\n",carModels.get(i), premiumPayments.get(i), premiumPayments.get(i)/counts.get(i));

            }
            
        }
          
    }
    
//    @Override
//    public User clone() throws CloneNotSupportedException{
//        
//        User output = (User) super.clone();
//        output.address = address.clone();
//        output.policies = new ArrayList<InsurancePolicy>();
//        for(InsurancePolicy ip: policies){
//            
//            output.policies.add(ip.clone());
//            
//        }
//        
//        return output;
//        
//    }
    
    @Override
    public User clone() throws CloneNotSupportedException{
        
        User output = (User) super.clone();
        output.address = address.clone();
        output.allThePoliciesForTheUser = new HashMap<Integer, InsurancePolicy>();
        for(InsurancePolicy ip: allThePoliciesForTheUser.values()){
            
            output.allThePoliciesForTheUser.put(ip.id, ip.clone());
            
        }
        
        return output;
        
    }
    
//    static ArrayList<User> shallowCopy(ArrayList<User> users) throws CloneNotSupportedException{
//        
//        ArrayList<User> shallowCopy = new ArrayList<User>();
//        
//        for(User user: users){
//            
//            shallowCopy.add(user.clone());
//            
//        }
//        
//        return shallowCopy;
//        
//    }
    
    static HashMap<Integer, User> shallowCopy(HashMap<Integer, User> users) throws CloneNotSupportedException{
        
        return (HashMap<Integer, User>)(users.values().stream()
                .map(x->x)
                .collect(Collectors.toMap(User::getUserID, x->x)));
        
    }
    
//    static HashMap<Integer, User> shallowCopy(HashMap<Integer, User> users) throws CloneNotSupportedException{
//        
//        HashMap<Integer, User> shallowCopy = new HashMap<Integer, User>();
//        
//        for(User user: users.values()){
//            
//            shallowCopy.put(user.getUserID(), user);
//            
//        }
//        
//        return shallowCopy;
//        
//    }
    
//    static ArrayList<User> shallowCopy(HashMap<Integer, User> users){
//        
//        ArrayList<User> newArrayList = new ArrayList<>();
//        
//        for(User addingUser: users.values()){
//            
//            newArrayList.add(addingUser);
//            
//        }
//        
//        return newArrayList;
//    }
    
//    static ArrayList<User> deepCopy(ArrayList<User> users) throws CloneNotSupportedException{
//        
//        ArrayList<User> deepCopy = new ArrayList<User>();
//        
//        for(User user: users){
//            
//            deepCopy.add(user.clone());
//            
//        }
//        
//        return deepCopy;
//    }
    
    static HashMap<Integer, User> deepCopy(HashMap<Integer, User> users) throws CloneNotSupportedException{
        
        return (HashMap<Integer, User>)(users.values().stream()
                .map(x-> new User(x))
                .collect(Collectors.toMap(User::getUserID, x->x)));
        
    }
    
//    static HashMap<Integer, User> deepCopy(HashMap<Integer, User> users) throws CloneNotSupportedException{
//        
//        HashMap<Integer, User> deepCopy = new HashMap<Integer, User>();
//        
//        for(User user: users.values()){
//            
//            deepCopy.put(user.getUserID(), user.clone());
//            
//        }
//        
//        return deepCopy;
//    }
    
//    static ArrayList<User> deepCopy(HashMap<Integer, User> users){
//        
//        ArrayList<User> aCopiedList = new ArrayList<>();
//        
//        for(User copyingUsers: users.values()){
//            
//            aCopiedList.add(copyingUsers);
//            
//        }
//        
//        return aCopiedList;
//    }
    
//    ArrayList<InsurancePolicy> deepCopyPolicies() throws CloneNotSupportedException{
//        
//        ArrayList<InsurancePolicy> deepCopyPolicies = new ArrayList<InsurancePolicy>();
//        
//        for(InsurancePolicy ip: policies){
//            
//            deepCopyPolicies.add(ip.clone());
//            
//        }
//        
//        return deepCopyPolicies;
//        
//    }
    
    HashMap<Integer, InsurancePolicy> deepCopyPolicies(String username, String password) throws CloneNotSupportedException{
        
        if(userValidate(username, password)){
            
            HashMap<Integer, InsurancePolicy> deepCopyPolicies = new HashMap<Integer, InsurancePolicy>();
        
            for(InsurancePolicy ip: allThePoliciesForTheUser.values()){

                deepCopyPolicies.put(ip.id, ip.clone());

            }

            return deepCopyPolicies;
            
        }
        
        return null;
        
    }
    
    ArrayList<InsurancePolicy> shallowCopyPolicies1(String username, String password){
        
        if(userValidate(username, password)){
            
            ArrayList<InsurancePolicy> shallowCopyPolicies = new ArrayList<InsurancePolicy>();
        
            for(InsurancePolicy ip: allThePoliciesForTheUser.values()){

                shallowCopyPolicies.add(ip);

            }

            return shallowCopyPolicies;
            
        }
        
        return null;
        
    }
    
    HashMap<Integer, InsurancePolicy> shallowCopyPolicies(String username, String password){
        
        if(userValidate(username, password)){
            
            HashMap<Integer, InsurancePolicy> shallowCopyPolicies = new HashMap<Integer, InsurancePolicy>();
        
            for(InsurancePolicy ip: allThePoliciesForTheUser.values()){

                shallowCopyPolicies.put(ip.id, ip);

            }

            return shallowCopyPolicies;
            
        }
        
        return null;
        
    }
    
    ArrayList<InsurancePolicy> sortPoliciesByDate(String username, String password){
        
        if(userValidate(username, password)){
            
            ArrayList<InsurancePolicy> sortedPolicies = new ArrayList<InsurancePolicy>();
        
    //        for(InsurancePolicy ip: allThePoliciesForTheUser.values()){
    //            
    //            sortedPolicies.add(ip);
    //            
    //        }

            sortedPolicies = this.shallowCopyPolicies1(username, password);
            Collections.sort(sortedPolicies);

            return sortedPolicies;
            
        }
        
        return null;
        
    }
    
    static HashMap<Integer, User> load(String fileName){
        
        HashMap<Integer, User> loadTheData = new HashMap<Integer, User>();
        
        ObjectInputStream loadingData = null;
        
        try{
            
            loadingData = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
            
        }
        catch(IOException ex){
            
            System.err.println("error in create/open the file");
            System.exit(1);
            
        }
        
        try{
            
            while(true){
                
                User aUser = (User) loadingData.readObject();
                loadTheData.put(aUser.getUserID(), aUser);
                
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
            
        }catch(IOException ex){
            
            System.err.println("error in close the file");
            System.exit(1);
            
        }
        
        return loadTheData;
        
    }
    
    static Boolean save(HashMap<Integer, User> write, String fileName){
        
        ObjectOutputStream savingToBinaryFile2 = null;
        
        boolean saving2 = true;
        
        try{
            
            savingToBinaryFile2 = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
            
        }catch(IOException e){
            
            System.err.println("error in create/open the file");
            saving2 = false;
            System.exit(1);
            
        }
        
        try{
            
            for(User aUser: write.values()){
                
                savingToBinaryFile2.writeObject(aUser);
                
            }
            
        }catch(IOException ex){
            
            System.err.println("error in adding the objects to the file");
            saving2 = false;
            System.exit(1);
            
        }
        
        try{
            
            if(savingToBinaryFile2 != null){
                
                savingToBinaryFile2.close();
                
            }
            
        }catch(IOException ex){
            
            System.err.println("error in closing the file");
            saving2 = false;
            System.exit(1);
            
        }
        
        return saving2;
        
    }
    
    @Override
    public int compareTo(User otherUser){
        
        return address.compareTo(otherUser.address);
        
    }
    
//    public int compareTo1(User otherUser){
//        
//        int total = 0;
//        
//        for(InsurancePolicy ip: allThePoliciesForTheUser.values()){
//            
//            total += ip.calcPay(500);
//            
//        }
//        
//        return total;
//        
//    }
  
    public String toDelimitedString(){
        
        String output = "U" + "," + name + "," + userID + "," + address.toDelimitedString() + "," + getPolicies().size() + "\n";
        for(InsurancePolicy ip: allThePoliciesForTheUser.values()){
            
            output += ip.toDelimitedString() + "\n";
            
        }

        return output;
        
    }
    
    static HashMap<Integer, User> loadTextFile(String fileName) throws IOException, PolicyException, PolicyHolderNameException{
        
        HashMap<Integer, User> filestoLoad = new HashMap<>();
        
        User saveTheUser = null;
        
        BufferedReader loadTF = new BufferedReader(new FileReader(fileName));
        
        String line = loadTF.readLine();
        
        while(line != null){
            
            line = line.trim();
            String[] field = line.split(",");
            
            switch(field[0]){
                
                case "U":
                    
                    String name = field[1];
                    int userID = Integer.parseInt(field[2]);
                    int streetNum = Integer.parseInt(field[3]);
                    String street = field[4];
                    String suburb = field[5];
                    String city = field[6];
                    String userPassword = field[7];
                    
                    Address anAddress = new Address(streetNum, street, suburb, city);
                    
                    saveTheUser = new User(name, anAddress, userPassword);
                    saveTheUser.setUserID(userID);
                    
                    filestoLoad.put(saveTheUser.userID, saveTheUser);
                    break;
                    
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
                    
//                    filestoLoad.get(saveTheUser.getUserID());
//                    saveTheUser.addPolicy(tppForTextFile);
                    saveTheUser.setPolicies1(tppForTextFile);
                    
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
                    
                    saveTheUser.setPolicies1(cpForTextFile);
                    break;
                    
            }        
            
            line = loadTF.readLine();
        }
        
        loadTF.close();
        return filestoLoad;
        
    }
    
    static Boolean saveTextFile(HashMap<Integer, User> textFile, String fileName) throws IOException{
        
        BufferedWriter saveTF = new BufferedWriter(new FileWriter(fileName));
        
        try{
            
            for(User user: textFile.values()){
            
                saveTF.write(user.toDelimitedString());
            
            }
            
            return true;
            
        }finally{
            
            saveTF.close();
            
        }
        
    }
    
//    int[] policyCount(String username, String password, int[] ranges){
//        
//        if(userValidate(username, password)){
//           
//           int[] countingThePolicies = new int[ranges.length];
//           
//            for(InsurancePolicy policy: allThePoliciesForTheUser.values()){
//                   
//                double usersPremiumPayment = policy.calcPay(0);
//                   
//                for(int i=0; i < ranges.length; i++){
//                    
//                    if(usersPremiumPayment <= ranges[i]){
//                       
//                        countingThePolicies[i]++;
//                        break;
//
//                    }
//                    
//                }
//                   
//            }
//           
//            return countingThePolicies;
//            
//        }
//        
//        return null;
//        
//    }
    
    int[] policyCount(String username, String password, int[] ranges){
        
        if(userValidate(username, password)){
           
           int[] countingThePolicies = new int[ranges.length];
           
            allThePoliciesForTheUser.values().forEach(x-> {
                
                double usersPremiumPayment = x.calcPay(0);
                
                IntStream.range(0, ranges.length)
                        .filter(i -> usersPremiumPayment <= ranges[i])
                        .findFirst()
                        .ifPresent(i -> countingThePolicies[i]++);
               
            });
           
            return countingThePolicies;
            
        }
        
        return null;
        
    }
    
//    int[] policyCount(String username, String password, int[] ranges){
//        
//        if(userValidate(username, password)){
//           
//            return Arrays.stream(allThePoliciesForTheUser.get(username))
//                    .collect(Collectors.groupingBy(
//                            policy -> username,
//                            Collectors.mapping(
//                                    policy -> (int) IntStream.range(0, ranges.length)
//                                            .filter(i -> policy.calcPay(0) <= ranges[i])
//                                            .count(),
//                                    Collectors.toList()
//                            )
//                    ));
//            }
//        
//        return null;
//        
//    }
    
    
    HashMap<String, Integer[]> policyCarModelCount(String username, String password, int []ranges){
        
        if(userValidate(username, password)){
            
//            int[] policyCountCarModel = new int[ranges.length];
            HashMap<String, Integer[]> returningThePoliciesCarModelCount = new HashMap<>();
            
            for(InsurancePolicy ip: allThePoliciesForTheUser.values()){
                
                String carModel = ip.getCar().getModel();
                double usersPremiumPayment = ip.calcPay(0);
                
                if(returningThePoliciesCarModelCount.containsKey(carModel)){
                    
                    Integer[] counts = returningThePoliciesCarModelCount.get(carModel);
                    
                    
//                    System.out.println("Before incremetning occurs: " + Arrays.toString(counts));
                    
                    for(int i=0; i < ranges.length; i++){
                        
                        if(usersPremiumPayment <= ranges[i]){
                            
                            counts[i]++;
                            break;
                            
                        }
                        
                    }
                    
//                    System.out.println("After incremetning occurs: " + Arrays.toString(counts));
                    
                }else {
                    
                    Integer[] counts = new Integer[ranges.length];
                    
                    for(int i=0; i < ranges.length; i++){
                        
                        counts[i] = 0;
                        
                    }
                    
//                    System.out.println("New counts: " + Arrays.toString(counts));
                    
                    for(int i=0; i < ranges.length; i++){
                        
                        if(usersPremiumPayment <= ranges[i]){
                            
                            counts[i]++;
                            break;
                            
                        }
                        
                    }
                    
//                    System.out.println("After incremetning occurs: " + Arrays.toString(counts));
                    
                    returningThePoliciesCarModelCount.put(carModel, counts);
                    
                }
                
                
            }
            
            return returningThePoliciesCarModelCount;
            
        }
        
        return null;
        
    }
    
    // getters and setters for the values
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    public int getUserID(){return userID;}
    public void setUserID(int userID){this.userID = userID;}
    
    public Address getAddress(){return address;}
    public void setAddress(Address address){this.address = address;}
    
    public HashMap<Integer, InsurancePolicy> getPolicies(){return allThePoliciesForTheUser;}
    public void setPolicies(HashMap<Integer, InsurancePolicy> aPolicy){this.allThePoliciesForTheUser = aPolicy;}
    public void setPolicies1(InsurancePolicy aPolicy){this.allThePoliciesForTheUser.put(aPolicy.getID(),aPolicy);}
    
    public String getPassword(){return userPassword;}
    public void setPassword(String userPassword){this.userPassword = userPassword;}
    
}
