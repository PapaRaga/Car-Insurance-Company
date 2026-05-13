package com.mycompany.assignment3;

import java.io.Serializable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.Comparator;

public class InsuranceCompany implements Cloneable, Serializable {
    
    protected String name;
    //private ArrayList<User> users;
    private String adminUsername;
    private String adminPassword;
    private int flatRate;
    private HashMap<Integer, User> allTheUsersInTheCompany;
    
    public InsuranceCompany(String name, String adminUsername, String adminPassword, int flatRate){
        
        this.adminPassword = adminPassword;
        this.adminUsername = adminUsername;
        this.flatRate = flatRate;
        this.name = name;
        //users = new ArrayList<>();
        allTheUsersInTheCompany = new HashMap<Integer, User>();
        
    }
    
    // copy constructor
    public InsuranceCompany(InsuranceCompany inscomp){
        
        this.adminPassword = inscomp.adminPassword;
        this.adminUsername = inscomp.adminUsername;
        this.name = inscomp.name;
        this.flatRate = inscomp.flatRate;
        //users = new ArrayList<>();
        allTheUsersInTheCompany = new HashMap<Integer, User>();
        
    }
    
    // Default constructor
    public InsuranceCompany(){
        
//        this.adminPassword = "";
//        this.adminUsername = "";
//        this.name = "";
//        this.flatRate = 0;
        this.allTheUsersInTheCompany = new HashMap<>();
        
    }
    
    // this method validates the admins inputs and decides whether to let them in or not
    boolean validateAdmin(String username, String password){
        
        if(adminUsername.equals(username) && adminPassword.equals(password)){
            
            return true;
            
        }
        return false;
        
    }
    
    // this method takes an user ID and it goes through the users and returns the users if their ID is the same as the parameter ID
//    User findUser(int userID){
//        
//        for(User user: users){
//            
//            if(user.getUserID() == userID){
//                return user;
//                
//            }
//            
//        }
//        return null;
//        
//    }
    
    User findUser(String adminUsername, String adminPassword, int userID){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            for(User user: allTheUsersInTheCompany.values()){
            
                if(user.getUserID() == userID){
                    return user;
                
                }
            
            }
            
        }
        
        return null;
        
    }
    
    User findingTheUserToValidate(String userName, String password){
        
        for(User matchingUser: allTheUsersInTheCompany.values()){
            
//            matchingUser.userValidate(matchingUser.getName(), matchingUser.getPassword());
//            return true;

            if(matchingUser.userValidate(userName, password)){
                
                return matchingUser;
                
            }
            
        }
        
        return null;
        
    }
    
    // this method adds users if the users don't already exist
//    boolean addUser(User user){
//        
//        if(findUser(user.getUserID()) == null){
//            
//            users.add(user);
//            return true;
//            
//        }
//        return false;
//        
//    }
    
    // The hashmap version of addUser
    boolean addUser(String adminUsername, String adminPassword, User user){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            if(findUser(getAdminUsername(), getAdminPassword(), user.getUserID()) == null){
            
                allTheUsersInTheCompany.put(user.getUserID(), user);
                return true;
            
            }
            
            return false;
            
        }
        
        return false;
        
    }
    
    // this method does the same thing as the addUser above
    boolean addUser(String adminUsername, String adminPassword, String name, Address address, String userPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            User user = new User(name, address, userPassword);
            return addUser(adminUsername, adminPassword, user);
              
        }
        
        return false;
        
    }
    
    // this method adds a policy to an entered user ID
    boolean addPolicy(String adminUsername, String adminPassword, int userID, InsurancePolicy policy){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            User user = findUser(adminUsername, adminPassword, userID);
            if(user != null){
            
                user.addPolicy(policy, user.getName(), user.getPassword());
                return true;
            
            }
            
            return false;
            
        }
        
        return false;
             
    }
    
    // this method finds a policy from a user by entering the users ID and the policies ID
    InsurancePolicy findPolicy (String adminUsername, String adminPassword, int userID ,int policyID){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            if(findUser(adminUsername, adminPassword, userID) != null){
            
                User user = findUser(adminUsername, adminPassword, userID);
                return user.findPolicy(policyID, user.getName(), user.getPassword());
                 
            }
            
            return null; 
                     
        }
        
        return null;
        
    } 
    
    // this method prints all the policies of a user by entering their ID
    void printPolicies(String adminUsername, String adminPassword, int userID){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            if(findUser(adminUsername, adminPassword, userID) != null){
            
                User user = findUser(adminUsername, adminPassword, userID);
            
                user.print(user.getName(), user.getPassword());
            
            }
             
        }
        
    }
    
    // this method prints all the users and their policies
//    void print(){
//        
//        for(User user: users){
//            
//            user.print();
//            System.out.println();
//            
//        }
//        
//    }
    
    void print(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            for(User user: allTheUsersInTheCompany.values()){
            
                user.print(user.getName(), user.getPassword());
                System.out.println();
            
            }
            
        }
        
    }
    
    // converting the constructors paramteres as a String and assigning them the users information and policies
//    @Override
//    public String toString(){
//        
//        String information = "Name: " + name + ", admin username: " + adminUsername + ", admin password: " + adminPassword;
//        
//        for(User user: users){
//            
//            information += user.toString() + "\n";
//        }
//        
//        return information;
//              
//    }
    
    @Override
    public String toString(){
        
        String information = "Name: " + name + ", admin username: " + adminUsername + ", admin password: " + adminPassword + ", flat rate: " + flatRate + "\n";
            
        for(User user: allTheUsersInTheCompany.values()){
            
            information += user.toString() + "\n";
        }
        
//        System.out.print(allTheUsersInTheCompany.size());
           
        return information;
    }
    
    // this method creates third party policy for the user if they exist
    boolean createThirdPartyPolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments, String adminUsername, String adminPassword) throws PolicyException, PolicyHolderNameException{
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            User user = findUser(adminUsername, adminPassword, userID);
        
            if(user != null){
            
                return user.createThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments, user.getName(), user.getPassword());
            
            }
        
            return false;
            
        }
        
        return false;
        
    }
    // this method creates comprehensive policy for the user if they exist
    boolean createComprehensivePolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level, String adminUsername, String adminPassword) throws PolicyException, PolicyHolderNameException{
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            User user = findUser(adminUsername, adminPassword, userID);
        
            if(user != null){
            
                return user.createComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level, user.getName(), user.getPassword());
            
            }
        
            return false;
            
        }
        
        return false;
        
    }
    
    // this method calculates the premium payment for a user by entering their ID
    double calcTotalPayments(String adminUsername, String adminPassword, int userID){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            double total = 0;
            if(findUser(adminUsername, adminPassword, userID) != null){
            
                User user = findUser(adminUsername, adminPassword, userID);
                total += user.calcTotalPremiums(flatRate, user.getName(), user.getPassword());
            
            }
        
            return total;
             
        }
        
        return 0;
          
    }
    
    // this method does the same thing but it calculates the total premium payment for all users
//    double calcTotalPayments(){
//        
//        double total = 0;
//        for(User user: users){
//            
//            total += user.calcTotalPremiums(flatRate);
//            
//        }
//        
//        return total;
//          
//    }
    
//    double calcTotalPayments(String adminUsername, String adminPassword){
//        
//        if(validateAdmin(adminUsername, adminPassword)){
//            
//            double total = 0;
//            for(User user: allTheUsersInTheCompany.values()){
//
//                total += user.calcTotalPremiums(flatRate, user.getName(), user.getPassword());
//
//            }
//
//            return total;
//            
//        }
//        
//        return 0;
//          
//    }
    
    double calcTotalPayments(String adminUsername, String adminPassword){
        
        return allTheUsersInTheCompany.values().stream()
                .mapToDouble(x->x.calcTotalPremiums(flatRate, x.getName(), x.getPassword()))
                .sum();
          
    }
    
    // this method increases the price of the car to a user by entering the ID
    boolean carPriceRise(String adminUsername, String adminPassword, int userID, double risePercent){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            if(findUser(adminUsername, adminPassword, userID) != null){
            
                User user = findUser(adminUsername, adminPassword, userID);
                user.carPriceRiseAll(risePercent, user.getName(), user.getPassword());

            }
            
            return false;
            
        }
        
        return false;
        
    }
    
    // this method does the same thing as the carPriceRise above, but it increases the prices of all cars
//    void carPriceRise(double risePercent){
//        
//        for(User user: users){
//            
//           user.carPriceRiseAll(risePercent);
//            
//        }
//         
//    }
    
//    void carPriceRise(String adminUsername, String adminPassword, double risePercent){
//        
//        if(validateAdmin(adminUsername, adminPassword)){
//            
//            for(User user: allTheUsersInTheCompany.values()){
//            
//                user.carPriceRiseAll(risePercent, user.getName(), user.getPassword());
//
//            }
//            
//        }
//         
//    }
    
    void carPriceRise(String adminUsername, String adminPassword, double risePercent){
        
        allTheUsersInTheCompany.values().forEach(x-> {
            
            x.carPriceRiseAll(risePercent, x.getName(), x.getPassword());
        
        });
         
    }
    
    // this method adds every policy across all the users into a new array and returns the new array with every policy that exists
//    ArrayList<InsurancePolicy> allPolicies(){
//        
//        ArrayList<InsurancePolicy> allPolicies = new ArrayList<>();
//        for(User user: users){
//            
//            allPolicies.addAll(user.getPolicies());
//            
//        }
//        
//        return allPolicies;
//        
//    }
    
    HashMap<Integer, InsurancePolicy> allPolicies(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            HashMap<Integer, InsurancePolicy> allPolicies = new HashMap<Integer, InsurancePolicy>();
        
            for(User user: allTheUsersInTheCompany.values()){

                //Collection<InsurancePolicy> aUsersPolicies = user.getPolicies();
                //allPolicies.put(user.getUserID(), user.getPolicies());
                HashMap<Integer, InsurancePolicy> aUsersPolicies = user.getPolicies();

                //allPolicies.put(user.getUserID(), aUsersPolicies);
                allPolicies.putAll(aUsersPolicies);

            }

            return allPolicies;
            
        }
        
        return null;
        
    }
    
    // this method returns policies that contain the carModel that is asked as a parameter for a specific user (by entering their user ID)
//    ArrayList<InsurancePolicy> filterByCarModel(int userID, String carModel){
//        
//        if(findUser(userID) != null){
//            
//            User user = findUser(userID);
//            return user.filterByCarModel(carModel);
//        }
//        return null;
//        
//    }
    
    HashMap<Integer, InsurancePolicy> filterByCarModel(String adminUsername, String adminPassword, int userID, String carModel){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            if(findUser(adminUsername, adminPassword, userID) != null){
            
                User user = findUser(adminUsername, adminPassword, userID);
                return user.filterByCarModel(carModel, user.getName(), user.getPassword());
            }

            return null;
            
        }
        
        return null;
        
    }
    
    // this method returns the policies that have expired for a specific user
//    ArrayList<InsurancePolicy> filterByExpiryDate(int userID, MyDate date){
//        
//        if(findUser(userID) != null){
//            
//            User user = findUser(userID);
//            return user.filterByExpiryDate(date);
//        }
//        
//        return null;
//           
//    } 
    
    HashMap<Integer, InsurancePolicy> filterByExpiryDate(String adminUsername, String adminPassword, int userID, MyDate date){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            if(findUser(adminUsername, adminPassword, userID) != null){
            
                User user = findUser(adminUsername, adminPassword, userID);
                return user.filterByExpiryDate(date, user.getName(), user.getPassword());
            }

            return null;
            
        }
        
        return null;
           
    }
    
    // this method returns a list of policies that contain the carModel asked as a parameter
//    ArrayList<InsurancePolicy> filterByCarModel(String carModel){
//        
//        ArrayList<InsurancePolicy> filteredPoliciesByCarModel = new ArrayList<>();
//        for(User user: users){
//            
//            filteredPoliciesByCarModel.addAll(user.filterByCarModel(carModel));
//            
//        }
//    
//        return filteredPoliciesByCarModel;
//        
//    }
    
    ArrayList<InsurancePolicy> filterByCarModel(String carModel){
        
        ArrayList<InsurancePolicy> filteredPoliciesByCarModel = new ArrayList<>();
        
        allTheUsersInTheCompany.values().stream()
                .map(x->x.filterByCarModel(carModel))
                .forEach(filteredPoliciesByCarModel::addAll);
                
        return filteredPoliciesByCarModel;
        
    }
    
    HashMap<Integer, InsurancePolicy> filterByCarModel(String adminUsername, String adminPassword, String carModel){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            HashMap<Integer, InsurancePolicy> filteredPoliciesByCarModel = new HashMap<Integer, InsurancePolicy>();
        
            for(User user: allTheUsersInTheCompany.values()){
            
                //filteredPoliciesByCarModel.put(user.getUserID(), user.filterByCarModel(carModel));
                HashMap<Integer, InsurancePolicy> someFilteredPoliciesByCarModel = user.filterByCarModel(carModel, user.getName(), user.getPassword());
            
                filteredPoliciesByCarModel.putAll(someFilteredPoliciesByCarModel);
            
            }
        
            return filteredPoliciesByCarModel;
            
        }
        
        return null;
        
    }
    
    // this method returns a list of policies with all the policies accros all the users that have expired
//    ArrayList<InsurancePolicy> filterByExpiryDate(MyDate date){
//        
//        ArrayList<InsurancePolicy> filteredPoliciesByDate = new ArrayList<>();
//        
//        for(User user: users){
//            
//            filteredPoliciesByDate.addAll(user.filterByExpiryDate(date));
//            
//        }
//        
//        return filteredPoliciesByDate;
//          
//    }
    
    HashMap<Integer, InsurancePolicy> filterByExpiryDate(String adminUsername, String adminPassword, MyDate date){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            HashMap<Integer, InsurancePolicy> filteredPoliciesByDate = new HashMap<Integer, InsurancePolicy>();
        
            for(User user: allTheUsersInTheCompany.values()){

                HashMap<Integer, InsurancePolicy> someFilteredPoliciesByExpDate = user.filterByExpiryDate(date, user.getName(), user.getPassword());

                filteredPoliciesByDate.putAll(someFilteredPoliciesByExpDate);

            }

            return filteredPoliciesByDate;
            
        }
        
        return null;
          
    }
    
    // Goes through all the users and populate a list of distinct city names for all users and returns it as a list. 
//    ArrayList<String> populateDistinctCityNames(){
//        
//        ArrayList<String> cities = new ArrayList<>();
//        
//        for(User user: users){
//            
//            boolean found = false;
//            for(String city: cities){
//                
//                if(user.getAddress().getCity().equals(city)){
//                    
//                    found = true;
//                    break;
//                    
//                }
//                
//            }
//            
//            if(!found)
//                cities.add(user.getAddress().getCity());
//            
//        }
//        
//        return cities;
//        
//    }
    
    ArrayList<String> populateDistinctCityNames(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            ArrayList<String> cities = new ArrayList<>();
        
            for(User user: allTheUsersInTheCompany.values()){

                boolean found = false;
                for(String city: cities){

                    if(user.getAddress().getCity().equals(city)){

                        found = true;
                        break;

                    }

                }

                if(!found)
                    cities.add(user.getAddress().getCity());

            }

            return cities;
            
        }
        
        return null;
        
    }
    
    ArrayList<Integer> populateUserIDs(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            ArrayList<Integer> IDs = new ArrayList<>();
        
            for(User user: allTheUsersInTheCompany.values()){
                
                IDs.add(user.getUserID());
            }
            
            return IDs;
            
        }
        
        return null;
        
    }
    
    // returns the total premium payment for the given city across all users.   
//    double getTotalPaymentForCity(String city){
//        
//        double total = 0;
//        for(User user: users){
//            
//            if(user.getAddress().getCity().equals(city)){
//                
//                total += user.calcTotalPremiums(flatRate);
//                        
//            }       
//            
//        }
//        
//        return total;
//        
//    }
    
    double getTotalPaymentForCity(String adminUsername, String adminPassword, String city){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            double total = 0;
            for(User user: allTheUsersInTheCompany.values()){

                if(user.getAddress().getCity().equals(city)){

                    total += user.calcTotalPremiums(flatRate, user.getName(), user.getPassword());

                }       

            }

            return total;
            
        }
        
        return 0;
        
    }
    
    // Aggregates the total premium payments for each city in the list and returns it as a double list with the same order as city names. 
    ArrayList<Double> getTotalPaymentPerCity(String adminUsername, String adminPassword, ArrayList<String> cities){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            ArrayList<Double> totalBalance = new ArrayList<>();
            for(String city: cities){

                totalBalance.add(getTotalPaymentForCity(adminUsername, adminPassword, city));

            }

            return totalBalance;
            
        }
        
        return null;
          
    }
    
    // Generates(Creates) the report 
    void reportPaymentPerCity(String adminUsername, String adminPassword, ArrayList<String> cities, ArrayList<Double> payments){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            System.out.printf("%-20s     %-20s\n",">City Name<", ">Total Premium Payment<");
            for(int i=0; i<cities.size(); i++){

                System.out.printf("%-20s     %14.1f\n",cities.get(i), payments.get(i));

            }
            
        }
        
    }
    
    // goes through all the users within the InsuranceCompany and populates a list of distinct car models
//    ArrayList<String> populateDistinctCarModels(){
//        
//        ArrayList<String> carModel = new ArrayList<>();
//        
//        for(User user: users){
//            
//            ArrayList<String> temp = user.populateDistinctCarModels();
//            
//            if(temp != null){
//                
//                for(String model: temp){
//                    
//                    if(!carModel.contains(model)){
//                        
//                        carModel.add(model);
//                        
//                    }
//                    
//                }
//                
//            }
//            
//        }
//        
//        return carModel;
//        
//    }
    
    ArrayList<String> populateDistinctCarModels(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            ArrayList<String> carModel = new ArrayList<>();
        
            for(User user: allTheUsersInTheCompany.values()){

                ArrayList<String> temp = user.populateDistinctCarModels(user.getName(), user.getPassword());

                if(temp != null){

                    for(String model: temp){

                        if(!carModel.contains(model)){

                            carModel.add(model);

                        }

                    }

                }

            }

            return carModel;
            
        }
        
        return null;
        
    }
    
    // returns the count for each model across all the users
//    ArrayList<Integer> getTotalCountPerCarModel(ArrayList<String> carModels){
//        
//        ArrayList<Integer> totalCounts = new ArrayList<>();
//        
//        for(String s : carModels){
//            totalCounts.add(0);
//        }
//        
//        for(User user: users){
//
//            ArrayList<Integer> xp = user.getTotalCountPerCarModel(carModels);
//            
//            for(int i = 0; i < xp.size(); i++){
//                
//                int temp = totalCounts.get(i) + xp.get(i);
//                totalCounts.set(i, temp);
//                
//            }
//            //System.out.print(totalCounts);
//        }
//            
//        return totalCounts;
//        
//    }
    
    ArrayList<Integer> getTotalCountPerCarModel(String adminUsername, String adminPassword, ArrayList<String> carModels){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            ArrayList<Integer> totalCounts = new ArrayList<>();
        
            for(String s : carModels){
                totalCounts.add(0);
            }

            for(User user: allTheUsersInTheCompany.values()){

                ArrayList<Integer> xp = user.getTotalCountPerCarModel(carModels, user.getName(), user.getPassword());

                for(int i = 0; i < xp.size(); i++){

                    int temp = totalCounts.get(i) + xp.get(i);
                    totalCounts.set(i, temp);

                }
                //System.out.print(totalCounts);
            }

            return totalCounts;
            
        }
        
        return null;
        
    }
    
    // the same as the previous one but across all users in the company 
//    ArrayList<Double> getTotalPaymentPerCarModel(ArrayList<String> carModels){
//        
//        ArrayList<Double> totalPayment = new ArrayList<>();
//        
//        for(String m: carModels){
//            
//            totalPayment.add(0.0);
//            
//        }
//        
//        for(User user: users){
//            
//            ArrayList<Double> newCalculation = user.getTotalPaymentPerCarModel(carModels);
//            
//            for(int i=0; i< newCalculation.size(); i++){
//                
//                double total = totalPayment.get(i) + newCalculation.get(i);
//                totalPayment.set(i, total);
//                
//            }
//             
//        }
//        
//        return totalPayment;
//    }
    
    ArrayList<Double> getTotalPaymentPerCarModel(String adminUsername, String adminPassword, ArrayList<String> carModels){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            ArrayList<Double> totalPayment = new ArrayList<>();
        
            for(String m: carModels){

                totalPayment.add(0.0);

            }

            for(User user: allTheUsersInTheCompany.values()){

                ArrayList<Double> newCalculation = user.getTotalPaymentPerCarModel(carModels, user.getName(), user.getPassword());

                for(int i=0; i< newCalculation.size(); i++){

                    double total = totalPayment.get(i) + newCalculation.get(i);
                    totalPayment.set(i, total);

                }

            }

            return totalPayment;
            
        }
        
        return null;
       
    }
    
    // to generate the same report as before but across all users in the system  
    void reportPaymentsPerCarModel(String adminUsername, String adminPassword, ArrayList<String> carModels, ArrayList<Integer>counts, ArrayList<Double> premiumPayments){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            System.out.printf("%-15s     %-25s     %-30s\n", ">Car Model<",     ">Total Premium Payment<",     ">Average Premium Payment<");
            for(int i=0; i < carModels.size(); i++){

                System.out.printf("%-20s     %9.1f     %27.1f\n", carModels.get(i), premiumPayments.get(i), premiumPayments.get(i)/counts.get(i));

            }
            
        }
         
    }
    
//    HashMap<String, Double> getTotalPremiumPerCity(String adminUsername, String adminPassword){
//        
//        if(validateAdmin(adminUsername, adminPassword)){
//            
//            HashMap<String, Double> getTotPremPerCityWithHashMap = new HashMap<String, Double>();
//        
//            for(User user: allTheUsersInTheCompany.values()){
//
//                Double total = getTotPremPerCityWithHashMap.get(user.getAddress().getCity());
//
//                //double totalPremiumForCity = getTotalPaymentForCity(user.getAddress().getCity());
//                double totalPremiumForUser = user.calcTotalPremiums(flatRate, user.getName(), user.getPassword());
//
//                if(total != null){
//
//                    getTotPremPerCityWithHashMap.put(user.getAddress().getCity(), total + totalPremiumForUser);
//
//                }else{
//
//                    getTotPremPerCityWithHashMap.put(user.getAddress().getCity(), totalPremiumForUser);
//
//                }
//
//            }
//
//            return getTotPremPerCityWithHashMap;
//            
//        }
//        
//        return null;
//        
//    }
    
    HashMap<String, Double> getTotalPremiumPerCity(String adminUsername, String adminPassword){
            
        return (HashMap<String, Double>) allTheUsersInTheCompany.values().stream()
                .collect(Collectors.groupingBy(x->x.getAddress().getCity(), 
       Collectors.summingDouble(x->x.calcTotalPremiums(flatRate, x.getName(), x.getPassword()))
       
       ));
            
    }
    
//    HashMap<String, Integer> getTotalCountPerCarModel(String adminUsername, String adminPassword){
//        
//        if(validateAdmin(adminUsername, adminPassword)){
//            
//            HashMap<String, Integer> getTotCounPerCMHashMap = new HashMap<String, Integer>();
//        
//            for(User user: allTheUsersInTheCompany.values()){
//
//                HashMap<String, Integer> collectingTheCount = user.getTotalCountPerCarModel(user.getName(), user.getPassword());
//
//                for(String carModel: collectingTheCount.keySet()){
//
//                    int count = collectingTheCount.get(carModel);
//
//                    if(getTotCounPerCMHashMap.containsKey(carModel)){
//
//                        getTotCounPerCMHashMap.put(carModel, getTotCounPerCMHashMap.get(carModel) + count);                  
//
//                    }else{
//
//                        getTotCounPerCMHashMap.put(carModel, count);
//
//                    }
//                    //getTotCounPerCMHashMap.put(carModel, collectingTheCount.values());
//
//                }
//
//            }
//
//            return getTotCounPerCMHashMap;
//            
//        }
//        
//        return null;
//        
//    }
    
    HashMap<String, Integer> getTotalCountPerCarModel(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            HashMap<String, Integer> getTotCounPerCMHashMap = new HashMap<String, Integer>();
            
            allTheUsersInTheCompany.values().forEach(x-> {
                
                x.getTotalCountPerCarModel(x.getName(), x.getPassword())
                        .forEach((carModel, count) -> getTotCounPerCMHashMap.compute(carModel, (key, existingCount) -> existingCount == null ? count : existingCount + count)
                        
                        );
                
                
            });
               
            return getTotCounPerCMHashMap;
            
        }
        
        return null;
        
    }
    
//    HashMap<String,Double> getTotalPremiumPerCarModel(String adminUsername, String adminPassword){
//        
//        if(validateAdmin(adminUsername, adminPassword)){
//            
//            HashMap<String, Double> getTotPremPerCMHashMap = new HashMap<String, Double>();
//        
//            for(User user: allTheUsersInTheCompany.values()){
//
//                HashMap<String, Double> total = user.getTotalPremiumPerCarModel(user.getName(), user.getPassword());
//
//                for(String carModel: total.keySet()){
//
//                    double premium = total.get(carModel);
//
//                    if(getTotPremPerCMHashMap.containsKey(carModel)){
//
//                        getTotPremPerCMHashMap.put(carModel, getTotPremPerCMHashMap.get(carModel) + premium);
//
//                    }else{
//
//                        getTotPremPerCMHashMap.put(carModel, premium);
//
//                    }
//
//                }
//
//            }
//
//            return getTotPremPerCMHashMap;
//            
//        }
//        
//        return null;
//        
//    }
    
    HashMap<String,Double> getTotalPremiumPerCarModel(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            HashMap<String, Double> getTotPremPerCMHashMap = new HashMap<>();
        
            allTheUsersInTheCompany.values().forEach(x-> {
                
                x.getTotalPremiumPerCarModel(x.getName(), x.getPassword())
                        .forEach((carModel, premium) -> getTotPremPerCMHashMap.compute(carModel, (key, existingPremium) -> existingPremium == null ? premium : existingPremium + premium)
                        
                        );
                
            });

            return getTotPremPerCMHashMap;
            
        }
        
        return null;
        
    }
    
//    void reportForPriceAcrossAllCities(String adminUsername, String adminPassword, HashMap<String, Double> getPriceAcrossAllCities){
//        
//        if(validateAdmin(adminUsername, adminPassword)){
//            
//            System.out.printf("%-15s     %-25s\n", ">City Name<",     ">Total Premium Payment<");
//        
//            for(String cityName: getPriceAcrossAllCities.keySet()){
//
//                System.out.printf("%-20s     %9.1f\n", cityName, getPriceAcrossAllCities.get(cityName));
//
//            }
//            
//        }
//        
//    }
    
    void reportForPriceAcrossAllCities(String adminUsername, String adminPassword, HashMap<String, Double> getPriceAcrossAllCities){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            System.out.printf("%-15s     %-25s\n", ">City Name<",     ">Total Premium Payment<");
        
            getPriceAcrossAllCities.forEach((cityName, totalPremium) -> System.out.printf("%-20s     %9.1f\n", cityName, totalPremium));
            
        }
        
    }
    
    void reportForPremiumPayPerCarModel(String adminUsername, String adminPassword, HashMap<String, Integer> countForCM, HashMap<String, Double> calculation){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            System.out.printf("\n%-15s     %-25s     %-30s\n", ">Car Model<", ">Total Premium Payment<", ">Average Premium Payment<");
        
            countForCM.forEach((carModel, count)-> {
                
                double totalPremium = calculation.get(carModel);
                double averagePremium = totalPremium / count;
                
                System.out.printf("%-20s     %9.1f     %27.1f\n",carModel, totalPremium, averagePremium);
                
            });
            
        }  
        
    }
    
//    @Override
//    public InsuranceCompany clone() throws CloneNotSupportedException{
//        
//        InsuranceCompany output = (InsuranceCompany) super.clone();
//        output.users = new ArrayList<User>();
//        for(User user: users){
//            
//            output.users.add(user.clone());
//            
//        }
//        
//        return output;
//        
//    }
    
    @Override
    public InsuranceCompany clone() throws CloneNotSupportedException{
        
        InsuranceCompany output = (InsuranceCompany) super.clone();
        output.allTheUsersInTheCompany = new HashMap<Integer, User>();
        for(User user: allTheUsersInTheCompany.values()){
            
            output.allTheUsersInTheCompany.put(user.getUserID(), user.clone());
            
        }
        
        return output;
        
    }
    
//    ArrayList<User> deepCopyUsers() throws CloneNotSupportedException{
//        
//        ArrayList<User> deepCopyUsers = new ArrayList<User>();
//        
//        for(User user: users){
//            
//            deepCopyUsers.add(user.clone());
//            
//        }
//        
//        return deepCopyUsers;
//        
//    }
    
    HashMap<Integer, User> deepCopyUsers(String adminUsername, String adminPassword) throws CloneNotSupportedException{
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            HashMap<Integer, User> deepCopyUsers = new HashMap<Integer, User>();
        
            for(User user: allTheUsersInTheCompany.values()){

                deepCopyUsers.put(user.getUserID(), user.clone());

            }

            return deepCopyUsers;
             
        }
        
        return null;
        
    }
    
    ArrayList<User> shallowCopyUsers1(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            ArrayList<User> shallowCopyUsers = new ArrayList<User>();
        
            for(User user: allTheUsersInTheCompany.values()){

                shallowCopyUsers.add(user);

            }

            return shallowCopyUsers;
            
        }
        
        return null;
        
    }
    
    HashMap<Integer, User> shallowCopyUsers(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            HashMap<Integer, User> shallowCopyUsers = new HashMap<Integer, User>();
        
            for(User user: allTheUsersInTheCompany.values()){

                shallowCopyUsers.put(user.getUserID(), user);

            }

            return shallowCopyUsers;
            
        }
        
        return null;
        
    }
    
//    ArrayList<User> sortUsers(){
//        
//        ArrayList<User> sortedUsers = new ArrayList<User>();
//        
//        for(User user: users){
//            
//            sortedUsers.add(user);
//            
//        }
//        
//        Collections.sort(sortedUsers);
//        
//        return sortedUsers;
//        
//    }
    
    ArrayList<User> sortUsers(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            ArrayList<User> sortedUsers = new ArrayList<User>();
        
    //        for(User user: allTheUsersInTheCompany.values()){
    //            
    //            sortedUsers.add(user);
    //            
    //        }

            sortedUsers = this.shallowCopyUsers1(adminUsername, adminPassword);

            Collections.sort(sortedUsers);

            return sortedUsers;
            
        }
        
        return null;
        
    }
    
    Boolean load(String fileName, String adminUsername, String adminPassword) throws IOException{
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            ObjectInputStream loadingData = null;
//          InsuranceCompany inscomp = null;
//          InsuranceCompany inscomp = new InsuranceCompany();
            boolean loading = true;

            try{

                loadingData = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));

            }catch(IOException ex){

                System.err.println("error in create/open the file");
                loading = false;
                System.exit(1);

            }

            try{

                InsuranceCompany inscomp = (InsuranceCompany) loadingData.readObject();
                this.adminPassword = inscomp.getAdminPassword();
                this.adminUsername = inscomp.getAdminUsername();
                this.flatRate = inscomp.getFlatRate();
                this.name = inscomp.getName();
                this.allTheUsersInTheCompany = inscomp.getUsers();

            }catch(EOFException ex){

                System.out.println("no more record!");
                loading = false;

            }

            catch(ClassNotFoundException ex){

                System.err.println("error in wrong class in the file");
                loading = false;

            }

            catch(IOException ex){

                System.err.println("error in add object to the file");
                loading = false;
                System.exit(1);

            }

            try{

                if(loadingData != null){

                    loadingData.close();

                }

            }
            catch(IOException ex){

                System.err.println("error in close the file");
                loading = false;
                System.exit(1);

            }

            return loading;
            
        }
        
        return false;
        
    }
    
    Boolean save(String fileName, String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            ObjectOutputStream saveTheData = null;
        
            boolean saving = true;

            try{

                saveTheData = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));

            }catch(IOException e){

                System.err.println("error in create/open the file");
                saving = false;
                System.exit(1);

            }

            try{

                saveTheData.writeObject(this);

            }catch(IOException ex){

                System.err.println("error in adding the objects to the file");
                saving = false;
                System.exit(1);

            }

            try{

                if(saveTheData != null){

                    saveTheData.close();

                }

            }catch(IOException ex){

                System.err.println("error in closing the file");
                saving = false;
                System.exit(1);

            }

            return saving;
            
        }
        
        return false;
        
    }
    
    public void save2() throws IOException{
        
        ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("lab7.ser")));
        output.writeObject(this);
        output.close();
        
    }
    
    public static InsuranceCompany load2() throws IOException, ClassNotFoundException{
        
        ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("lab7.ser")));
        InsuranceCompany inscomp = (InsuranceCompany) input.readObject();
        input.close();
        return inscomp;
        
    }
    
    public void save3() throws IOException{
        
        ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("Assignment3.ser")));
        output.writeObject(this);
        output.close();
        
    }
    
    public static InsuranceCompany load3() throws IOException, ClassNotFoundException{
        
        ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("Assignment3.ser")));
        InsuranceCompany inscomp = (InsuranceCompany) input.readObject();
        input.close();
        return inscomp;
        
    }
    
    public String toDelimitedString(){
        
        String output = "IC" + "," + name + "," + adminUsername + "," + adminPassword + "," + flatRate + "\n";
        //return "IC" + "," + name + "," + adminUsername + "," + adminPassword + "," + flatRate + "\n";
        
        for(User aUser: allTheUsersInTheCompany.values()){
            
            output += aUser.toDelimitedString();
            
        }
        
        return output;
        
    }
    
    
    Boolean loadTextFile(String fileName, String adminUsername, String adminPassword) throws IOException, PolicyException, PolicyHolderNameException{
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            BufferedReader loadTF = new BufferedReader(new FileReader(fileName));
        
            User saveTheUser = null;

            boolean flag = true;

            String line = loadTF.readLine();

            while(line != null){

                line = line.trim();
                String[] field = line.split(",");

                //read all the information from InsuranceCompany
                //read all the info from users
                //for each user - info all the user's policies
                switch(field[0]){

                    case "IC": 

                        this.setName(field[1]);
                        this.setAdminUsername(field[2]);
                        this.setAdminPassword(field[3]);
                        this.setFlatRate(Integer.parseInt(field[4]));

                        break;

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
    //                    System.out.print("---------" + saveTheUser);
    //                    System.out.print("---------" + saveTheUser.getUserID());
                        allTheUsersInTheCompany.put(saveTheUser.getUserID(), saveTheUser);
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
            return flag;
            
        }
        
        return false;
            
    }
    
    Boolean saveTextFile(String fileName, String adminUsername, String adminPassword) throws IOException{
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            BufferedWriter saveTF = new BufferedWriter(new FileWriter(fileName));
        
            try{

                saveTF.write(toDelimitedString() + "\n");
                return true;

            }finally{

                saveTF.close();

            }
            
        }
        
        return false;
         
    }
    
    ArrayList<User> sortUsersByPremium(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            ArrayList<User> usersSortedByPremium = new ArrayList<>(allTheUsersInTheCompany.values());
        
            Collections.sort(usersSortedByPremium, new CompareTotalPremiumPayments());

            return usersSortedByPremium;
            
        }
        
        return null;
        
    }
    
    HashMap<String, ArrayList<User>> getUsersPerCity(String adminUsername, String adminPassword){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            HashMap<String, ArrayList<User>> usersInACity = new HashMap<>();
        
            for(User aUser: allTheUsersInTheCompany.values()){

                String city = aUser.getAddress().getCity();

                if(!usersInACity.containsKey(city)){

                    usersInACity.put(city, new ArrayList<>());

                }

                usersInACity.get(city).add(aUser);
            }

            return usersInACity;
            
        }
        
        return null;
        
    }
    
    HashMap<String, ArrayList<InsurancePolicy>> filterPoliciesByExpiryDate(String adminUsername, String adminPassword, MyDate expiryDate){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            HashMap<String, ArrayList<InsurancePolicy>> polciesOfUsers = new HashMap<>();
        
            for(User user: allTheUsersInTheCompany.values()){

                String fullName = user.getName();

                if(!polciesOfUsers.containsKey(fullName)){

                    polciesOfUsers.put(fullName, new ArrayList<>());

                }

                for(InsurancePolicy policy: user.getPolicies().values()){

                    if(policy.getExpiryDate().isExpired(expiryDate)){

                        polciesOfUsers.get(fullName).add(policy);

                    }

                }

            }

            return polciesOfUsers;
            
        }
        
        return null;
        
    }
    
//    int[] policyCount(String adminUsername, String adminPassword, int[] ranges){
//        
//        if(validateAdmin(adminUsername, adminPassword)){
//            
//            int[] countingThePoliciesAcrossAllUsers = new int[ranges.length];
//            
//            for(User allUsers: allTheUsersInTheCompany.values()){
//                
//                int[] usersPoliciesCount = allUsers.policyCount(allUsers.getName(), allUsers.getPassword(), ranges);
//                
//                for(int i=0; i < ranges.length; i++){
//                    
//                    countingThePoliciesAcrossAllUsers[i] += usersPoliciesCount[i];
//                    
//                }
//                   
//            }
//            
//            return countingThePoliciesAcrossAllUsers;
//            
//        }
//        
//        return null;
//        
//    }
    
    int[] policyCount(String adminUsername, String adminPassword, int[] ranges){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            int[] countingThePoliciesAcrossAllUsers = new int[ranges.length];
            
            allTheUsersInTheCompany.values().forEach(x -> {
                
                int[] usersPoliciesCount = x.policyCount(x.getName(), x.getPassword(), ranges);
                
                IntStream.range(0, ranges.length)
                        .forEach(i -> countingThePoliciesAcrossAllUsers[i] += usersPoliciesCount[i]);
                
            });
                
            return countingThePoliciesAcrossAllUsers;
            
        }
        
        return null;
        
    }
    
//    int[] policyCount(String adminUsername, String adminPassword, int[] ranges){
//        
//        if(validateAdmin(adminUsername, adminPassword)){
//            
////            int[] countingThePoliciesAcrossAllUsers = new int[ranges.length];
//            
//            return allTheUsersInTheCompany.values().stream()
//                    .map(x->x.policyCount(x.getName(), x.getPassword(), ranges))
//                    .reduce(new int[ranges.length], (countingThePoliciesAcrossAllUsers, usersPoliciesCount)-> {
//                        
//                        for(int i=0; i < ranges.length; i++){
//                    
//                            countingThePoliciesAcrossAllUsers[i] += usersPoliciesCount[i];
//                    
//                        }
//                        
//                        return countingThePoliciesAcrossAllUsers;
//                        
//                    });
//            
////            return countingThePoliciesAcrossAllUsers;
//            
//        }
//        
//        return null;
//        
//    }
    
    HashMap<String, Integer[]> policyCityCount(String adminUsername, String adminPassword, int[] ranges){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            int[] policyCountPerCity = new int[ranges.length];
            HashMap<String, Integer[]> returningThePoliciesCount = new HashMap<>();
            
            for(User allUsers: allTheUsersInTheCompany.values()){
                
                String getCityOfUser = allUsers.getAddress().getCity();
                policyCountPerCity = allUsers.policyCount(allUsers.getName(), allUsers.getPassword(), ranges);
                
                if(returningThePoliciesCount.containsKey(getCityOfUser)){
                    
                    Integer[] existingCityPolicies = returningThePoliciesCount.get(getCityOfUser);
                    
                    Integer[] saveTheCountOfPoliciesPerUser = new Integer[policyCountPerCity.length];
                    
                    for(int i=0; i < policyCountPerCity.length; i++){
                        
                        saveTheCountOfPoliciesPerUser[i] = policyCountPerCity[i];
                        
                    }
                    
                    for(int i=0; i < ranges.length; i++){
                        
                        existingCityPolicies[i] += saveTheCountOfPoliciesPerUser[i];
                        
                    }
                    
                }else {
                    
                    Integer[] saveTheCountOfPoliciesPerUser = new Integer[policyCountPerCity.length];
                    
                    for(int i=0; i < policyCountPerCity.length; i++){
                        
                        saveTheCountOfPoliciesPerUser[i] = policyCountPerCity[i];
                        
                    }
                    
                    returningThePoliciesCount.put(getCityOfUser, saveTheCountOfPoliciesPerUser);
                    
                }
            }
            
            
            return returningThePoliciesCount;
            
        }
        
        return null;
        
    }
    
//    int[] userCount(String adminUsername, String adminPassword, int[] ranges){
//        
//        if(validateAdmin(adminUsername, adminPassword)){
//            
//            int[] userCountPerPolicy = new int[ranges.length];
//            
//            for(User aUser: allTheUsersInTheCompany.values()){
//                
//                int[] userPolicyCount = aUser.policyCount(aUser.getName(), aUser.getPassword(), ranges);
//                
//                for(int i=0; i < ranges.length; i++){
//                    
//                    if(userPolicyCount[i] > 0){
//                        
//                        userCountPerPolicy[i]++;
//                        
//                    }
//                    
//                }
//                
//            }
//            
//            return userCountPerPolicy;
//             
//        }
//        
//       return null; 
//       
//    }
    
    int[] userCount(String adminUsername, String adminPassword, int[] ranges){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            int[] userCountPerPolicy = new int[ranges.length];
            
            allTheUsersInTheCompany.values().forEach(x -> {
                
                int[] userPolicyCount = x.policyCount(x.getName(), x.getPassword(), ranges);
                
                IntStream.range(0, ranges.length)
                        .filter(i -> userPolicyCount[i] > 0)
                        .forEach(i -> userCountPerPolicy[i]++);
                
            });
            
            return userCountPerPolicy;
             
        }
        
       return null; 
       
    }
    
    HashMap<String, Integer[]> policyCarModelCount(String adminUsername, String adminPassword, int[] ranges){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            HashMap<String, Integer[]> countingTheCarModelForUsers = new HashMap<>();
            
            for(User users: allTheUsersInTheCompany.values()){
                
                HashMap<String, Integer[]> countingUsers = users.policyCarModelCount(users.getName(), users.getPassword(), ranges);
                
                for(String carModel: countingUsers.keySet()){
                    
                    Integer[] counts = countingTheCarModelForUsers.get(carModel);
                    
                    if(counts == null){
                        
                        counts = new Integer[ranges.length];
                        for(int i=0; i < ranges.length; i++){
                            
                            counts[i] = 0;
                            
                        }
                        
                        countingTheCarModelForUsers.put(carModel, counts);
                        
                    }
               
                    Integer[] userCarModelCount = countingUsers.get(carModel);
                    
                    for(int i=0; i < ranges.length; i++){
                        
                        counts[i] += userCarModelCount[i];
                        
                    }
                    
                    
                }
                
            }
            
            return countingTheCarModelForUsers;
            
        }
        
        return null;
        
    }
    
    HashMap<String, Integer[]> userCarModelCount(String adminUsername, String adminPassword, int[] ranges){
        
        if(validateAdmin(adminUsername, adminPassword)){
            
            HashMap<String, Integer[]> countingTheCarModelForUsers = new HashMap<>();
            
            for(User users: allTheUsersInTheCompany.values()){
                
                HashMap<String, Integer[]> countingUsers = users.policyCarModelCount(users.getName(), users.getPassword(), ranges);
                
                for(String carModel: countingUsers.keySet()){
                    
                    Integer[] userCarModelCount = countingUsers.get(carModel);
                    
                    if(!countingTheCarModelForUsers.containsKey(carModel)){
                        
                        Integer[] newArray = new Integer[ranges.length];
                        for(int i=0; i < ranges.length; i++){
                            
                            newArray[i] = 0;
                            
                        }
                        
                        countingTheCarModelForUsers.put(carModel, newArray);
                        
                    }
                    
                    for(int i=0; i < ranges.length; i++){
                        
                        if(userCarModelCount[i] > 0){
                            
                            countingTheCarModelForUsers.get(carModel)[i]++;
                            
                        }
                        
                    }
                    
                    
                }
                
            }
            
            return countingTheCarModelForUsers;
            
        }
        
        return null;
        
    }
    
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    public String getAdminUsername(){return adminUsername;}
    public void setAdminUsername(String adminUsername){this.adminUsername = adminUsername;}
    
    public String getAdminPassword(){return adminPassword;}
    public void setAdminPassword(String adminPassword){this.adminPassword = adminPassword;}
    
    public int getFlatRate(){return flatRate;}
    public void setFlatRate(int flatRate){this.flatRate = flatRate;}
    
    public HashMap<Integer, User> getUsers(){return allTheUsersInTheCompany;}
    public void setUsers(HashMap<Integer, User> allTheUsersInTheCompany){this.allTheUsersInTheCompany = allTheUsersInTheCompany;}
    
}

//class CompareTotalPremiumPayments implements Comparator<User> {
//        
//    @Override                                      
//    public int compare(User user1, User user2){
//            
//        double theTotPaymentForFirstUser = user1.calcTotalPremiums(500, user1.getName(), user1.getPassword());
//        double theTotPaymentForSecondUser = user2.calcTotalPremiums(500, user2.getName(), user2.getPassword());
//            
//        return Double.compare(theTotPaymentForFirstUser, theTotPaymentForSecondUser);
//            
//    }
//        
//}
//
//class CompareByName implements Comparator<User>{
//    
//    @Override
//    public int compare(User user1, User user2){
//            
//        return user1.getName().compareTo(user2.getName());
//            
//    }
//    
//}
