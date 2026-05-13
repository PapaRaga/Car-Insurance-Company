package com.mycompany.assignment3;

import java.util.*;
import java.util.InputMismatchException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Program {
    
    // example attributes for the functions
//    public static final int FLATRATE = 500;
    public static int [] ranges = {200,500,1000,10000};
    
    public static void main(String[] args) throws CloneNotSupportedException, PolicyException, IOException, PolicyHolderNameException{
        
        // Creating the InsuranceCompany object that will get used in all the methods below as a parameter and calling MainMenu method which starts everything
        InsuranceCompany firstInsuranceCompany = new InsuranceCompany("GuardianShield Insurance", "Bruno", "12345", 500);
        
//        DatabaseAccess.testingTheConnection(firstInsuranceCompany);
//        Login.main_login();
//        try{
//            Login l = new Login(firstInsuranceCompany);
//            l.setVisible(true);
//        
//            
//        }catch (PolicyException ex) {
//            
//            System.out.print(ex);
//            
//        }
        
        MainMenu(firstInsuranceCompany);
        
    }

    public static void TestCase(InsuranceCompany firstInsuranceCompany)throws CloneNotSupportedException, PolicyException, IOException, PolicyHolderNameException{
        
        Address addressOfSara = new Address(1, "Hamilton Street", "Auville", "Wollongong");
        User sara = new User("Sara", addressOfSara, "sara123");
        firstInsuranceCompany.addUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), sara);
        
        Car SarasCar1 = new Car("Toyota Camry", 2020, 0, CarType.SUV);
        MyDate SarasDate1 = new MyDate(2030, 9, 25);
        
        sara.createThirdPartyPolicy("Sara Jane", 3890145, SarasCar1, 1, SarasDate1, "Ew", sara.getName(), sara.getPassword());
        
//        System.out.println(sara.calcTotalPremiums(0, sara.getName(), sara.getPassword()));
        
        Car SarasCar2 = new Car("Toyota Camry", 2020, 30000, CarType.SUV);
        MyDate SarasDate2 = new MyDate(2040, 11, 20);
        
        sara.createThirdPartyPolicy("Sara Jane", 3123456, SarasCar2, 1, SarasDate2, "Meh", sara.getName(), sara.getPassword());
        
//        System.out.println(sara.calcTotalPremiums(0, sara.getName(), sara.getPassword()));
        
        Car SarasCar3 = new Car("Toyota Camry", 2020, 10000, CarType.SUV);
        MyDate SarasDate3 = new MyDate(2010, 4, 15);
        
        sara.createThirdPartyPolicy("Sara Jane", 3498102, SarasCar3, 1, SarasDate3, "Heh", sara.getName(), sara.getPassword());
        
//        System.out.println(sara.calcTotalPremiums(0, sara.getName(), sara.getPassword()));
        
        Car SarasCar4 = new Car("Nissan Dualis", 2020, 80000, CarType.SUV);
        MyDate SarasDate4 = new MyDate(2000, 1, 2);
        
        sara.createThirdPartyPolicy("Sara Jane", 3589102, SarasCar4, 1, SarasDate4, "Hah", sara.getName(), sara.getPassword());
        
//        System.out.println(sara.calcTotalPremiums(0, sara.getName(), sara.getPassword()));
        
        int[] SarasResults = sara.policyCount(sara.getName(), sara.getPassword(), ranges);
        
        System.out.print("Sara: ");
        for(int policies: SarasResults){
            
            System.out.print(policies + " ");
            
        }
        
        System.out.println("\n");
        
        Address addressOfJohn = new Address(2, "Valley Road", "Bridgestead", "Wollongong");
        User john = new User("John", addressOfJohn, "john123");
        firstInsuranceCompany.addUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), john);
        
        Car JohnsCar1 = new Car("Nissan Dualis", 2001, 30000, CarType.LUX);
        MyDate JohnsDate1 = new MyDate(2001, 2, 10);
        
        john.createThirdPartyPolicy("John James", 3741026, JohnsCar1, 1, JohnsDate1, "Ew", john.getName(), john.getPassword());
        
//        System.out.println(sara.calcTotalPremiums(0, sara.getName(), sara.getPassword()));
        
        Car JohnsCar2 = new Car("Toyota Camry", 2020, 0, CarType.SUV);
        MyDate JohnsDate2 = new MyDate(2040, 11, 20);
        
        john.createThirdPartyPolicy("John James", 3578102, JohnsCar2, 1, JohnsDate2, "Meh", john.getName(), john.getPassword());
        
//        System.out.println(sara.calcTotalPremiums(0, sara.getName(), sara.getPassword()));
        
        Car JohnsCar3 = new Car("Nissan Dualis", 2002, 80000, CarType.HATCH);
        MyDate JohnsDate3 = new MyDate(2004, 2, 7);
        
        john.createThirdPartyPolicy("John James", 3284910, JohnsCar3, 1, JohnsDate3, "Heh", john.getName(), john.getPassword());
        
//        System.out.println(sara.calcTotalPremiums(0, sara.getName(), sara.getPassword()));
        
        Car JohnsCar4 = new Car("Ford Ranger", 2003, 180000, CarType.SED);
        MyDate JohnsDate4 = new MyDate(2005, 4, 31);
        
        john.createThirdPartyPolicy("John James", 3738910, JohnsCar4, 1, JohnsDate4, "Hah", john.getName(), john.getPassword());
        
        int[] JohnsResults = john.policyCount(john.getName(), john.getPassword(), ranges);
        
        System.out.print("John: ");
        for(int policies: JohnsResults){
            
            System.out.print(policies + " ");
            
        }
        
        System.out.println("\n");
        
        Address addressOfRobert = new Address(3, "Warren Avenue", "Fishfield", "Sydney");
        User robert = new User("Robert", addressOfRobert, "robert123");
        firstInsuranceCompany.addUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), robert);
        
        Car RobertsCar1 = new Car("Ford Ranger", 2006, 0, CarType.LUX);
        MyDate RobertsDate1 = new MyDate(2007, 7, 17);
        
        robert.createThirdPartyPolicy("Robert Adler", 3289046, RobertsCar1, 1, RobertsDate1, "Ew", robert.getName(), robert.getPassword());
        
//        System.out.println(sara.calcTotalPremiums(0, sara.getName(), sara.getPassword()));
        
        Car RobertsCar2 = new Car("Nissan Dualis", 2008, 80000, CarType.SUV);
        MyDate RobertsDate2 = new MyDate(2040, 11, 20);
        
        robert.createThirdPartyPolicy("Robert Adler", 3678102, RobertsCar2, 1, RobertsDate2, "Meh", robert.getName(), robert.getPassword());
        
//        System.out.println(sara.calcTotalPremiums(0, sara.getName(), sara.getPassword()));
        
        Car RobertsCar3 = new Car("Toyota Camry", 2004, 480000, CarType.HATCH);
        MyDate RobertsDate3 = new MyDate(2004, 2, 7);
        
        robert.createThirdPartyPolicy("Robert Adler", 3829016, RobertsCar3, 1, RobertsDate3, "Heh", robert.getName(), robert.getPassword());
        
//        System.out.println(sara.calcTotalPremiums(0, sara.getName(), sara.getPassword()));
        
        Car RobertsCar4 = new Car("Porsche Cayenne", 2005, 20000, CarType.SED);
        MyDate RobertsDate4 = new MyDate(2007, 2, 11);
        
        robert.createThirdPartyPolicy("Robert Adler", 3390291, RobertsCar4, 1, RobertsDate4, "Hah", robert.getName(), robert.getPassword());
        
        int[] RobertsResults = robert.policyCount(robert.getName(), robert.getPassword(), ranges);
        
        System.out.print("Robert: ");
        for(int policies: RobertsResults){
            
            System.out.print(policies + " ");
            
        }
        
        System.out.println("\n");
        
        Address addressOfAlex = new Address(4, "Church Road", "Southingview", "Melbourne");
        User alex = new User("Alex", addressOfAlex, "alex123");
        firstInsuranceCompany.addUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), alex);
        
        Car AlexsCar1 = new Car("Ferrari 488", 2007, 30000, CarType.LUX);
        MyDate AlexsDate1 = new MyDate(2008, 8, 18);
        
        alex.createThirdPartyPolicy("Alex Kari", 3692801, AlexsCar1, 1, AlexsDate1, "Ew", alex.getName(), alex.getPassword());
        
//        System.out.println(sara.calcTotalPremiums(0, sara.getName(), sara.getPassword()));
        
        Car AlexsCar2 = new Car("Nissan Dualis", 2009, 80000, CarType.SUV);
        MyDate AlexsDate2 = new MyDate(2009, 9, 29);
        
        alex.createThirdPartyPolicy("Alex Kari", 3492016, AlexsCar2, 1, AlexsDate2, "Meh", alex.getName(), alex.getPassword());
        
        int[] AlexsResults = alex.policyCount(alex.getName(), alex.getPassword(), ranges);
        
        System.out.print("Alex: ");
        for(int policies: AlexsResults){
            
            System.out.print(policies + " ");
            
        }
        
        System.out.println("\n");
        
        System.out.println("--------------------------------------------------------------------------\n");
        
        int[] allThePoliciesResults = firstInsuranceCompany.policyCount(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), ranges);
        
        System.out.print("The output for all the policies of the users in the company: ");
        for(int allPolicies: allThePoliciesResults){
            
            System.out.print(allPolicies + " ");
            
        }
        
        System.out.println("\n");
        
        System.out.println("--------------------------------------------------------------------------\n");
        
        HashMap<String, Integer[]> policiesPerCityCount = firstInsuranceCompany.policyCityCount(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), ranges);
        
        System.out.print("The output for all the policies of the users per city in the company: \n\n");
        for(String city: policiesPerCityCount.keySet()){
            
            System.out.print(city + " => ");
            
            Integer[] counts = policiesPerCityCount.get(city);
            
            for(Integer countOfPolicies: counts){
                
                System.out.print(countOfPolicies + " ");
                
            }
            
            System.out.println();
            
        }
        
        System.out.println("\n");
        
        System.out.println("--------------------------------------------------------------------------\n");
        
        int[] userCount = firstInsuranceCompany.userCount(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), ranges);
        
        System.out.print("The output for all the users count in the company: ");
        for(int userCountPerRange: userCount){
            
            System.out.print(userCountPerRange + " ");
            
        }
        
        System.out.println("\n");
        
        System.out.println("--------------------------------------------------------------------------\n");
        
        HashMap<String, Integer[]> sarasCarModelCount = sara.policyCarModelCount(sara.getName(), sara.getPassword(), ranges);
        
        System.out.print("The output for all the policies of sara: \n\n");
        for(String carModel: sarasCarModelCount.keySet()){
            
            System.out.print(carModel + " => ");
            
            Integer[] countsForCarModel = sarasCarModelCount.get(carModel);
            
            for(Integer countOfCarModel: countsForCarModel){
                
                System.out.print(countOfCarModel + " ");
                
            }
            
            System.out.println();
            
        }
        
        System.out.println("\n");
        
        HashMap<String, Integer[]> johnsCarModelCount = john.policyCarModelCount(john.getName(), john.getPassword(), ranges);
        
        System.out.print("The output for all the policies of john: \n\n");
        for(String carModel: johnsCarModelCount.keySet()){
            
            System.out.print(carModel + " => ");
            
            Integer[] countsForCarModel = johnsCarModelCount.get(carModel);
            
            for(Integer countOfCarModel: countsForCarModel){
                
                System.out.print(countOfCarModel + " ");
                
            }
            
            System.out.println();
            
        }
        
        System.out.println("\n");
        
        HashMap<String, Integer[]> robertsCarModelCount = robert.policyCarModelCount(robert.getName(), robert.getPassword(), ranges);
        
        System.out.print("The output for all the policies of robert: \n\n");
        for(String carModel: robertsCarModelCount.keySet()){
            
            System.out.print(carModel + " => ");
            
            Integer[] countsForCarModel = robertsCarModelCount.get(carModel);
            
            for(Integer countOfCarModel: countsForCarModel){
                
                System.out.print(countOfCarModel + " ");
                
            }
            
            System.out.println();
            
        }
        
        System.out.println("\n");
        
        HashMap<String, Integer[]> alexsCarModelCount = alex.policyCarModelCount(alex.getName(), alex.getPassword(), ranges);
        
        System.out.print("The output for all the policies of Alex: \n\n");
        for(String carModel: alexsCarModelCount.keySet()){
            
            System.out.print(carModel + " => ");
            
            Integer[] countsForCarModel = alexsCarModelCount.get(carModel);
            
            for(Integer countOfCarModel: countsForCarModel){
                
                System.out.print(countOfCarModel + " ");
                
            }
            
            System.out.println();
            
        }
        
        System.out.println("\n");
        
        HashMap<String, Integer[]> userCountPerCarModel = firstInsuranceCompany.userCarModelCount(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), ranges);
        
        System.out.print("The number of policies owned by a user per range per car model \n\n");
        for(String carModel: userCountPerCarModel.keySet()){
            
            System.out.print(carModel + " => ");
            
            Integer[] counts = userCountPerCarModel.get(carModel);
            
            for(Integer countOfCarModels: counts){
                
                System.out.print(countOfCarModels + " ");
                
            }
            
            System.out.println();
            
        }
        
        System.out.println("\n");
        
        HashMap<String, Integer[]> policyCountPerCarModel = firstInsuranceCompany.policyCarModelCount(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), ranges);
        
        System.out.print("The number of policies in the company per range per car model \n\n");
        for(String carModel: policyCountPerCarModel.keySet()){
            
            System.out.print(carModel + " => ");
            
            Integer[] counts = policyCountPerCarModel.get(carModel);
            
            for(Integer countOfCarModels: counts){
                
                System.out.print(countOfCarModels + " ");
                
            }
            
            System.out.println();
            
        }

        System.out.println("\n---------------------------------------------------------------\n");
        
        ArrayList<Integer> idk = firstInsuranceCompany.populateUserIDs(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
            
        for(Integer wk: idk){
            
            System.out.println(wk);
            
        }
        
    }
    
    public static void AdminMenu(InsuranceCompany firstInsuranceCompany) throws CloneNotSupportedException, PolicyException, IOException, PolicyHolderNameException{
        
        Scanner scan = new Scanner(System.in);
        
        // Creating the Admin Menu
        System.out.println(">>>Welcome to the Admin Menu<<<\n");
        
        System.out.println("1) Test Case from Assignment 2");
        System.out.println("2) Create User");
        System.out.println("3) Create ThirdParty Policy");
        System.out.println("4) Create Comprehensive Policy");
        System.out.println("5) Print User Information");
        System.out.println("6) Filter by Car Model");
        System.out.println("7) Filter by Expiry Date");
        System.out.println("8) Update Address");
        System.out.println("9) Report: Payment by City");
        System.out.println("10) Report: Payment by Car Model for all Users");
        System.out.println("11) Remove policy from User");
        System.out.println("12) Remove user");
        System.out.println("13) Change Admin Password");
        System.out.println("14) Report: Car Model, Total Premium Payment, and Average Premium Payment for a given user");
        System.out.println("15) Report: City Name and Total Premium Payments across all users");
        System.out.println("16) Report: Car Model, Total Premium Payment, and Average Premium Payment across all users");
        System.out.println("17) Binary Save File (InsuranceCompany, User, InsurancePolicy)");
        System.out.println("18) Binary Laod File (InsuranceCompany, User, InsurancePolicy)");
        System.out.println("19) Text Save File (InsuranceCompany, User, InsurancePolicy)");
        System.out.println("20) Text Laod File (InsuranceCompany, User, InsurancePolicy)");
        System.out.println("21) Test Code");
        System.out.println("22) Deep copy of insurance company");
        System.out.println("23) Log Out");
        System.out.print("Please choose an option from 1 to 23: ");
        
        int option = 0;
        
        while(option == 0){
            
            try{
                
                option = scan.nextInt();
                
            }catch(InputMismatchException e){
                        
                String badInput = scan.next();
                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nPlease choose an option from 1 to 14: ");
                        
            }
            
        }
        
        System.out.println();
        
        switch(option){
            
            case 1:
                System.out.println(">>>You have choosen to display the Test Case<<<\n");
                TestCase(firstInsuranceCompany);
                System.out.println("\n---The Test Case is displayed above!---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                scan.nextLine(); //clear the buffer
                AdminMenu(firstInsuranceCompany);
                break;
                
            case 2:
                System.out.println(">>>You have choosen to create a User<<<\n");
                scan.nextLine();
                System.out.print("Enter user name: ");
                String userName = scan.nextLine();
                
                
                
                
                System.out.println("\n---Enter the address details---");
                System.out.print("Enter street number: ");
                
                int streetNum = 0;
                
                while(streetNum == 0){
                    
                    try{
                        
                        streetNum = scan.nextInt();
                        scan.nextLine();
                        
                    }catch(InputMismatchException e){
                        
                        String badInput = scan.next();
                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter street number: ");
                        
                    }
                    
                }
                
                System.out.print("Enter street name: ");
                String streetName = scan.nextLine();
                System.out.print("Enter suburb name: ");
                String suburb = scan.nextLine();
                System.out.print("Enter city name: ");
                String city = scan.nextLine();
                Address newAddress = new Address(streetNum, streetName, suburb, city);
                
                System.out.print("Enter the password that you wish to use: ");
                String passwordRetriver = scan.nextLine();
//                firstInsuranceCompany.addUser();
                
                User newUser = new User(userName, newAddress, passwordRetriver);
                
                firstInsuranceCompany.addUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), newUser);
                
                System.out.println("\nYour assigned ID is: " + newUser.getUserID());
                
                //HashMap<Integer, User> toPrintTheUserID = firstInsuranceCompany.getUsers();
                //User user = firstInsuranceCompany.addUser(userName, newAddress);
                
                
                System.out.println();
                System.out.println("---User Created!---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                break;
                
            case 3:
                System.out.println(">>>You have choosen to create a third party policy for a user<<<\n");
                System.out.print("Enter user ID: ");
                
                int enteredUserID = 0;
                
                while(enteredUserID == 0){
                    
                    try{
                        
                        enteredUserID = scan.nextInt();
                        scan.nextLine();
                        
                    }catch(InputMismatchException e){
                        
                        String badInput = scan.next();
                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter user ID: ");
                        
                    }
                    
                }
                
                if(firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword() ,enteredUserID) != null){
                    
                    System.out.print("Enter policy holder name: ");
                    String policyHolderName = "";
                    
                    while(true){
                        
                        try{
                            
                            policyHolderName = scan.nextLine();
                            Integer.parseInt(policyHolderName);
                            System.out.print("\n---PLEASE ENTER STRING--- \n\nEnter policy holder name: ");
                            
                        }catch(NumberFormatException e){
                            
                            break;
                            
                        }
                        
                    }
                    
                    System.out.print("Enter the ID of the policy: ");
                    int policyID = 0;
                    
                    while(policyID == 0){
                        
                        try{
                            
                           policyID = scan.nextInt();
                           scan.nextLine(); 
                            
                        }catch(InputMismatchException e){
                            
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the ID of the policy: ");
                            
                        }
                           
                    }
                    
                    System.out.println("\n---Enter the car details--- \n");
                    System.out.print("Enter car model: ");
                    String carModel = scan.nextLine();
                    System.out.print("Enter manufacturing year: ");
                    
                    int manufacturingYear = 0;
                    
                    while(manufacturingYear == 0){
                        
                        try{
                            
                            manufacturingYear = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                            
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter manufacturing year: ");
                            
                        }
                                               
                    }
                    
                    System.out.print("Enter the price of the car($): ");
                    
                    int carPrice = 0;
                    
                    while(carPrice == 0){
                        
                        try{
                            
                            carPrice = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                            
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the price of the car($): ");
                            
                        }
                        
                    }
                    
                    System.out.print("Enter the type of the car (SUV, SED, LUX, HATCH): ");
                    
                    //String enteredCarType = "";
                    
                    //Car newCar = null;
//                    boolean isCorrect = false;
//                    
//                    do{
//                        
//                        try{
                            
                    String enteredCarType = scan.nextLine();
                    CarType carType = CarType.valueOf(enteredCarType.toUpperCase());
                    Car newCar = new Car(carModel, manufacturingYear, carPrice, carType);
                            
//                        }catch(IllegalArgumentException e){
//                            
//                            System.out.print("---INVALID CAR TYPE---\n\nEnter the type of the car (SUV, SED, LUX, HATCH): ");
//                            
//                        }
                        //298374SUVHIW
                                                
//                    }while(!isCorrect);
                   
                    System.out.print("Enter number of claims: ");
                    
                    int numOfClaims = 0;
                    
                    while(numOfClaims == 0){
                        
                        try{
                            
                            numOfClaims = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                            
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter number of claims: ");
                            
                        }
                                               
                    }
                    
                    System.out.println("\n---Enter the expiry date of the policy--- \n");
                    System.out.print("Enter the day of expiry: ");
                    
                    int day = 0;
                    
                    while(day == 0){
                        
                        try{
                            
                            day = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                            
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the day of expiry: ");
                            
                        }
                        
                    }
             
                    System.out.print("Enter the month of expiry: ");
                    
                    int month = 0;
                    
                    while(month == 0){
                        
                        try{
                            
                            month = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                            
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the month of expiry: ");
                            
                        }
                        
                    }
                    
                    System.out.print("Enter the year of expiry: ");
                    
                    int year = 0;
                    
                    while(year == 0){
                        
                        try{
                            
                            year = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                            
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the year of expiry: ");
                            
                        }
                        
                    }
                    
                    MyDate enteredExpiryDate = new MyDate(year, month, day);
                    System.out.println("------------------------------------------------\n");
                    System.out.print("Enter your comment about this car: ");
                    String comment = scan.nextLine();
                  
                    try{
                        
                        firstInsuranceCompany.createThirdPartyPolicy(enteredUserID, policyHolderName, policyID, newCar, numOfClaims, enteredExpiryDate, comment, firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                        
                    }catch(PolicyException e){
                        
                        firstInsuranceCompany.createThirdPartyPolicy(enteredUserID, policyHolderName, e.getID(), newCar, numOfClaims, enteredExpiryDate, comment, firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                        System.out.println("\n" + e);
                        System.out.println("\n---Third Party Policy created and added to the user!---\n");
                        System.out.println("Do you want to continue?");
                        scan.nextLine();
                        AdminMenu(firstInsuranceCompany);
                        break;
                        
                    }
                    
                    catch(PolicyHolderNameException ex){
                        
                        System.out.println(ex);
                        System.out.println("Do you want to continue?");
                        scan.nextLine();
//                        System.out.println("\n---Comprehensive Policy could not be created because policy holder name was not valid!---\n");
//                        firstInsuranceCompany.createComprehensivePolicy(newEnteredUserID, ex.getPolicyHolderName(), policyID, newCar, numOfClaims, enteredExpiryDate, age, level, firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                        System.out.println("\n" + ex);
////                        System.out.println("\n---Comprehensive Policy created and added to the user!---\n");
//                        System.out.println("Do you want to continue?");
//                        scan.nextLine();
                        AdminMenu(firstInsuranceCompany);
                        break;
                    }
                    
                    
                    firstInsuranceCompany.createThirdPartyPolicy(enteredUserID, policyHolderName, policyID, newCar, numOfClaims, enteredExpiryDate, comment, firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                    System.out.println("\n---Third Party Policy created and added to the user!---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                    
                }else{
                    
                    System.out.println("\n---Policy could not be created because user does not exist---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                    
                }
                                   
            case 4:
                System.out.println(">>>You have choosen to create a comprehensive policy for a user<<<\n");
                System.out.print("Enter user ID: ");
                
                int newEnteredUserID = 0;
                
                while(newEnteredUserID == 0){
                    
                    try{
                        
                        newEnteredUserID = scan.nextInt();
                        scan.nextLine();
                        
                    }catch(InputMismatchException e){
                        
                        String badInput = scan.next();
                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter user ID: ");
                                                                       
                    }
                                                         
                }
                
                if(firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), newEnteredUserID) != null){
                    
                    System.out.print("Enter policy holder name: ");
                    String policyHolderName = "";
                    
                    while(true){
                        
                        try{
                            
                            policyHolderName = scan.nextLine();
                            Integer.parseInt(policyHolderName);
                            System.out.print("\n---PLEASE ENTER STRING--- \n\nEnter policy holder name: ");
                            
                        }catch(NumberFormatException e){
                            
                            break;
                            
                        }
                        
                    }
                    
                    System.out.print("Enter the ID of the policy: ");
                    
                    int policyID = 0;
                    
                    while(policyID == 0){
                        
                        try{
                            
                            policyID = scan.nextInt();
                            scan.nextLine();
                                                        
                        }catch(InputMismatchException e){
                            
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the ID of the policy: ");
                            
                        }
                                             
                    }
                    
                    System.out.println("\n---Enter the car details--- \n");
                    System.out.print("Enter car model: ");
                    String carModel = scan.nextLine();
                    System.out.print("Enter manufacturing year: ");
                    
                    int manufacturingYear = 0;
                    
                    while(manufacturingYear == 0){
                        
                        try{
                            
                            manufacturingYear = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter manufacturing year: ");
                                                                       
                        }
                        
                    }
                   
                    System.out.print("Enter the price of the car($): ");
                    
                    int carPrice = 0;
                    
                    while(carPrice == 0){
                        
                        try{
                            
                            carPrice = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the price of the car($): ");
                                                                       
                        }
                        
                    }
                                     
                    System.out.print("Enter the type of the car (SUV, SED, LUX, HATCH): ");
                    
                    String enteredCarType = scan.nextLine();
                    CarType carType = CarType.valueOf(enteredCarType.toUpperCase());
                    Car newCar = new Car(carModel, manufacturingYear, carPrice, carType);
                    
                    System.out.print("Enter number of claims: ");
                    
                    int numOfClaims = 0;
                    
                    while(numOfClaims == 0){
                        
                        try{
                            
                            numOfClaims = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter number of claims: ");
                                                                       
                        }
                        
                    }
                    
                    System.out.println("\n---Enter the expiry date of the policy--- \n");
                    System.out.print("Enter the day of expiry: ");
                    
                    int day = 0;
                    
                    while(day == 0){
                        
                        try{
                            
                            day = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the day of expiry: ");
                                                                       
                        }
                        
                    }
                    
                    System.out.print("Enter the month of expiry: ");
                    
                    int month = 0;
                    
                    while(month == 0){
                        
                        try{
                            
                            month = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the month of expiry: ");
                                                                       
                        }
                        
                    }
                    
                    System.out.print("Enter the year of expiry: ");
                    
                    int year = 0;
                    
                    while(year == 0){
                        
                        try{
                            
                            year = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the year of expiry: ");
                                                                       
                        }
                        
                    }
                    
                    MyDate enteredExpiryDate = new MyDate(year, month, day);
                    System.out.println("--------------------------------------------------\n");
                    
                    System.out.print("Enter the driver's age: ");
                    
                    int age = 0;
                    
                    while(age == 0){
                        
                        try{
                            
                            age = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the driver's age: ");
                                                                       
                        }
                        
                    }
                    
                    System.out.print("Enter the level: ");
                    
                    int level = 0;
                    
                    while(level == 0){
                        
                        try{
                            
                            level = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the level: ");
                                                                       
                        }
                        
                    }
                    
                    try{
                        
                        firstInsuranceCompany.createComprehensivePolicy(newEnteredUserID, policyHolderName, policyID, newCar, numOfClaims, enteredExpiryDate, age, level, firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
  
                    }catch(PolicyException e){
                        
                        firstInsuranceCompany.createComprehensivePolicy(newEnteredUserID, policyHolderName, e.getID(), newCar, numOfClaims, enteredExpiryDate, age, level, firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                        System.out.println("\n" + e);
                        System.out.println("\n---Comprehensive Policy created and added to the user!---\n");
                        System.out.println("Do you want to continue?");
                        scan.nextLine();
                        AdminMenu(firstInsuranceCompany);
                        break;
                        
                    }
                    
                    catch(PolicyHolderNameException ex){
                        
                        System.out.println(ex);
                        System.out.println("Do you want to continue?");
                        scan.nextLine();
//                        System.out.println("\n---Comprehensive Policy could not be created because policy holder name was not valid!---\n");
//                        firstInsuranceCompany.createComprehensivePolicy(newEnteredUserID, ex.getPolicyHolderName(), policyID, newCar, numOfClaims, enteredExpiryDate, age, level, firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                        System.out.println("\n" + ex);
////                        System.out.println("\n---Comprehensive Policy created and added to the user!---\n");
//                        System.out.println("Do you want to continue?");
//                        scan.nextLine();
                        AdminMenu(firstInsuranceCompany);
                        break;
                        
                    }
                    
                    firstInsuranceCompany.createComprehensivePolicy(newEnteredUserID, policyHolderName, policyID, newCar, numOfClaims, enteredExpiryDate, age, level, firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                    System.out.println("\n---Comprehensive Policy created and added to the user!---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                    
                }else{
                    
                    System.out.println("\n---Policy could not be created because user does not exist---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                    
                }
                    
            case 5:
                System.out.println(">>>You have choosen to print the user information<<<\n");
                System.out.print("Enter user ID: ");
                
                int userIDToPrintInfo = 0;
                
                while(userIDToPrintInfo == 0){
                    
                    try{
                        
                        userIDToPrintInfo = scan.nextInt();
                        scan.nextLine();
                        
                    }catch(InputMismatchException e){
                        
                        String badInput = scan.next();
                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter user ID: ");
                                                                       
                    }
                                       
                }
                
                if(firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), userIDToPrintInfo) != null){
                    
                    firstInsuranceCompany.printPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), userIDToPrintInfo);
                    System.out.println("\n---User Information Printed!---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                    
                }else{
                    
                    System.out.println("\n---Could not print user information because the entered user ID does not exist---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                }
                      
            case 6:
                System.out.println(">>>You have choosen to print a list with the specified car model<<<\n");
                
                scan.nextLine();
                
                System.out.print("Enter the car model that you want to find: ");
                String carModel = scan.nextLine();
                
//                ArrayList<InsurancePolicy> filterByCarModel = new ArrayList<>();
//                filterByCarModel.addAll(firstInsuranceCompany.filterByCarModel(carModel));
                HashMap<Integer, InsurancePolicy> filterByCarModel = new HashMap<Integer, InsurancePolicy>();
                filterByCarModel.putAll(firstInsuranceCompany.filterByCarModel(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), carModel));
                InsurancePolicy.printPolicies(filterByCarModel);
                
                System.out.print("\nThe total payment for the filtered policies is: $" + InsurancePolicy.calcTotalPayments(filterByCarModel, 500) + "\n");
                
                System.out.println("\n---The list with the asked car model is displayed above!---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                break;
                
            case 7:
                System.out.println(">>>You have choosen to print a list with the specified expiry date<<<\n");
                scan.nextLine();
                
                System.out.print("Enter user ID: ");
                
                int userIDForExpiryDate = 0;
                
                while(userIDForExpiryDate == 0){
                    
                    try{
                        
                        userIDForExpiryDate = scan.nextInt();
                        
                    }catch(InputMismatchException e){
                        
                        String badInput = scan.next();
                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter user ID: ");
                                                                       
                    }
                                        
                }
                
                if(firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), userIDForExpiryDate) != null){
                    
                    System.out.println("\n---Enter the date that you want to check---");
                    System.out.print("\nEnter the day: ");
                    
                    int day = 0;
                    
                    while(day == 0){
                        
                        try{
                            
                            day = scan.nextInt();
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the day: ");
                                                                       
                        }
                        
                    }
                    
                    System.out.print("Enter the month: ");
                    
                    int month = 0;
                    
                    while(month == 0){
                        
                        try{
                            
                            month = scan.nextInt();
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the month: ");
                                                                       
                        }
                        
                    }
                    
                    System.out.print("Enter the year: ");
                    
                    int year = 0;
                    
                    while(year == 0){
                        
                        try{
                            
                           year = scan.nextInt(); 
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the year: ");
                                                                       
                        }
                        
                    }
                            
                    System.out.println();
                    MyDate checkingDate = new MyDate(year, month, day);
        
//                    ArrayList<InsurancePolicy> filtByExpiryDate = new ArrayList<>();
//                    filtByExpiryDate.addAll(firstInsuranceCompany.filterByExpiryDate(userIDForExpiryDate, checkingDate));
                    HashMap<Integer, InsurancePolicy> filtByExpiryDate = new HashMap<Integer, InsurancePolicy>();
                    filtByExpiryDate.putAll(firstInsuranceCompany.filterByExpiryDate(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), userIDForExpiryDate, checkingDate));
                    InsurancePolicy.printPolicies(filtByExpiryDate);
                    
                    System.out.println("\n---The list with the asked expiry date is displayed above!---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                   
                }else{
                    
                    System.out.println("\n---User does not exist---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                    
                }
                
            case 8:
                System.out.println(">>>You have choosen to update a users address information<<<\n");
                scan.nextLine();
                
                System.out.print("Enter user ID: ");
                
                int userIDForNewAddress = 0;
                
                while(userIDForNewAddress == 0){
                    
                    try{
                        
                        userIDForNewAddress = scan.nextInt();
                        
                    }catch(InputMismatchException e){
                        
                        String badInput = scan.next();
                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter user ID: ");
                                                                       
                    }
                    
                }
                
                if(firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), userIDForNewAddress) != null){
                    
                    User user = firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), userIDForNewAddress);
                    
                    System.out.println("\n---Enter the information for a new address---\n");
                    scan.nextLine();
                    System.out.print("Enter the new street in which you live: ");
                    String newStreetInfo = scan.nextLine();
                    System.out.print("Enter the new street number in which you live: ");
                    
                    int newStreetNumInfo = 0;
                    
                    while(newStreetNumInfo == 0){
                        
                        try{
                            
                            newStreetNumInfo = scan.nextInt();
                            scan.nextLine();
                            
                        }catch(InputMismatchException e){
                        
                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the new street number in which you live: ");
                                                                       
                        }
                        
                    }
                    
                    System.out.print("Enter the new suburb in which you live: ");
                    String newSuburbInfo = scan.nextLine();
                    System.out.print("Enter the new city in which you live: ");
                    String newCityInfo = scan.nextLine();
            
                    Address anotherAddress = new Address(newStreetNumInfo, newStreetInfo, newSuburbInfo, newCityInfo);
                    user.setAddress(anotherAddress);
                    System.out.println();
                    
                    System.out.println("User Address Updated!\n");
                    
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                    
                }else{
                    
                    System.out.println("\n---User does not exist---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                    
                }
                    
            case 9:
                System.out.println(">>>You have choosen to aggregate a data report<<<\n");
                scan.nextLine();
                
                ArrayList<String> cities = firstInsuranceCompany.populateDistinctCityNames(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                ArrayList<Double> balances = firstInsuranceCompany.getTotalPaymentPerCity(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), cities);
                firstInsuranceCompany.reportPaymentPerCity(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), cities, balances);
                
                System.out.println("\n---The report is displayed above---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                break;
                
            case 10:
                System.out.println(">>>You have choosen to aggregate a data report about the car models<<<\n");
                scan.nextLine();
                
                ArrayList<String> carModels = firstInsuranceCompany.populateDistinctCarModels(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                ArrayList<Double> premiumPayments = firstInsuranceCompany.getTotalPaymentPerCarModel(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), carModels);
                ArrayList<Integer> counts = firstInsuranceCompany.getTotalCountPerCarModel(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), carModels);
                firstInsuranceCompany.reportPaymentsPerCarModel(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), carModels, counts, premiumPayments);
                
                System.out.println("\n---The report is displayed above---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                break;
                
            case 11:
                System.out.println(">>>You have choosen to remove a policy from a user<<<\n");
                scan.nextLine();
                
                System.out.print("Enter the ID of the user that you want to remove a policy from: ");
                
                int userIDToRemovePolicy = 0;
                
                while(userIDToRemovePolicy == 0){
                    
                    try{
                        
                        userIDToRemovePolicy = scan.nextInt();
                        scan.nextLine();
                        
                    }catch(InputMismatchException e){
                        
                        String badInput = scan.next();
                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the ID of the user that you want to remove a policy from: ");
                                                                       
                    }
                    
                }
                
                System.out.print("Enter the ID of the policy that you want to remove: ");
                
                int policyIDToRemove = 0;
                
                while(policyIDToRemove == 0){
                    
                    try{
                        
                        policyIDToRemove = scan.nextInt();
                        scan.nextLine();
                        
                    }catch(InputMismatchException e){
                        
                        String badInput = scan.next();
                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the ID of the policy that you want to remove: ");
                                                                       
                    }
                                        
                }
                
                if(firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), userIDToRemovePolicy) != null){
                    
                    User user = firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), userIDToRemovePolicy);
                    
                    if(user.findPolicy(policyIDToRemove, user.getName(), user.getPassword()) != null){
                        
//                        ArrayList<InsurancePolicy> ipToGetRemoved = new ArrayList<>();
                        HashMap<Integer, InsurancePolicy> ipToGetRemoved = new HashMap<Integer, InsurancePolicy>();
//                        ipToGetRemoved.addAll(user.getPolicies());
                        ipToGetRemoved.putAll(user.getPolicies());
//                        ipToGetRemoved.remove(user.findPolicy(policyIDToRemove));
                        ipToGetRemoved.remove(policyIDToRemove);
                        user.setPolicies(ipToGetRemoved);
                        
                        System.out.println("\n---The policy got removed---\n");
                        System.out.println("Do you want to continue?");
                        scan.nextLine();
                        AdminMenu(firstInsuranceCompany);
                        break;
                        
                    }else{
                        
                        System.out.println("\n---The entered policy ID does not exist---\n");
                        System.out.println("Do you want to continue?");
                        scan.nextLine();
                        AdminMenu(firstInsuranceCompany);
                        break;
                        
                    }
                          
                }else{
                    
                    System.out.println("\n---The entered user ID does not exist---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                    
                }
                    
            case 12:
                System.out.println(">>>You have choosen to remove a user<<<\n");
                scan.nextLine();
                
                System.out.print("Enter the ID of the user that you want to remove: ");
                
                int userIDToRemove = 0;
                
                while(userIDToRemove == 0){
                    
                    try{
                        
                        userIDToRemove = scan.nextInt();
                        scan.nextLine();
                        
                    }catch(InputMismatchException e){
                        
                        String badInput = scan.next();
                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the ID of the user that you want to remove: ");
                                                                       
                    }
                    
                }
                
                if(firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), userIDToRemove) != null){
                    
//                    ArrayList<User> usersToRemove = new ArrayList<>();
//                    usersToRemove.addAll(firstInsuranceCompany.getUsers());
                    HashMap<Integer, User> usersToRemove = new HashMap<Integer, User>();
                    usersToRemove.putAll(firstInsuranceCompany.getUsers());
//                    usersToRemove.remove(firstInsuranceCompany.findUser(userIDToRemove));
                    usersToRemove.remove(userIDToRemove);
                    
                    firstInsuranceCompany.setUsers(usersToRemove);
                    
                    System.out.println("\n---The user got removed---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                      
                }else{
                    
                    System.out.println("\n---The entered user ID does not exist---\n");
                    System.out.println("Do you want to continue?");
                    scan.nextLine();
                    AdminMenu(firstInsuranceCompany);
                    break;
                    
                }
                
            case 13: 
                System.out.println(">>>You have choosen to change the admin password<<<\n");
                scan.nextLine();
                
                System.out.print("Enter the new password: ");
                String newPassword = scan.nextLine();
                firstInsuranceCompany.setAdminPassword(newPassword);
                
                firstInsuranceCompany.validateAdmin(firstInsuranceCompany.getAdminUsername(), newPassword);
                
                System.out.println("\n---Password changed successfully!---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                break;
                
            case 14:
                System.out.println(">>>You have choosen to print the report about the Car Model, Total Premium Payment, and Average Premium Payment for a given user<<<\n");
                scan.nextLine();
                
                System.out.print("Enter the user ID: ");
                
                int usersID = 0;
                
                while(usersID == 0){
                    
                    try{
                        
                        usersID = scan.nextInt();
                        scan.nextLine();
                        
                    }catch(InputMismatchException e){
                        
                        String badInput = scan.next();
                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the user ID: ");
                        
                    }
                    
                }
                
                User user = firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), usersID);
                
                HashMap<String, Integer> totalCount = user.getTotalCountPerCarModel(user.getName(), user.getPassword());
                HashMap<String, Double> totalPremiumPCM = user.getTotalPremiumPerCarModel(user.getName(), user.getPassword());
                user.reportPaymentsPerCarModelWithHashMap(totalCount, totalPremiumPCM, user.getName(), user.getPassword());
                
                System.out.println("\n---The report is displayed above---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                break;
                
            case 15:
                System.out.println(">>>You have choosen to print the report about the City Name and Total Premium Payment across all users<<<\n");
                scan.nextLine();
                
                HashMap<String, Double> totalPremiumPC = firstInsuranceCompany.getTotalPremiumPerCity(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                
                //ArrayList<User> filteredUser = new ArrayList<User>();
                
//                for(User filterUser: firstInsuranceCompany.getUsers().values()){
//                    if(filterUser.getAddress().getCity().equals("New York")){
////                        filteredUser.add(filterUser);
//                          filterUser.printPolicies(500);
//                    }
//                }
                
                
                
                
                firstInsuranceCompany.reportForPriceAcrossAllCities(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), totalPremiumPC);
                
                System.out.println("\n\n\n\n");
                
                System.out.println("\n---The report is displayed above---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                break;
                
            case 16:
                
                System.out.println(">>>You have choosen to print the report about the Car Model, Total Premium Payment, and Average Premium Payment across all users<<<\n");
                scan.nextLine();
                
                HashMap<String, Integer> totalCountPCM = firstInsuranceCompany.getTotalCountPerCarModel(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                HashMap<String, Double> getTotalPremiumPCM = firstInsuranceCompany.getTotalPremiumPerCarModel(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                firstInsuranceCompany.reportForPremiumPayPerCarModel(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), totalCountPCM, getTotalPremiumPCM);
                
                System.out.println("\n---The report is displayed above---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                break;
                
            case 17:
                
                //testing binary file and list of policies
                
//                System.out.println(">>>testing binary file and list of policies<<<\n");
            
//                HashMap<Integer, InsurancePolicy> thePoliciesSavedInTheBinaryFile = new HashMap<>();
//                
//                HashMap<Integer, User> theUsersSavedInTheBinaryFile = new HashMap<>();
//                
//                theUsersSavedInTheBinaryFile = firstInsuranceCompany.getUsers();
//                
//                for(User userToSave: theUsersSavedInTheBinaryFile.values()){
//                    
//                    for(InsurancePolicy ip: userToSave.getPolicies().values()){
//                        
//                        thePoliciesSavedInTheBinaryFile.put(ip.id, ip);
//                        
//                    }
//                
//                InsurancePolicy.save(thePoliciesSavedInTheBinaryFile, "policies.ser");
//                thePoliciesSavedInTheBinaryFile.clear();
//                
//                thePoliciesSavedInTheBinaryFile = InsurancePolicy.load("policies.ser");
//                InsurancePolicy.printPolicies(thePoliciesSavedInTheBinaryFile);
                
                
                InsurancePolicy.save(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()),"policies1.ser");
                User.save(firstInsuranceCompany.getUsers(),"users1.ser");
                firstInsuranceCompany.save("company1.ser", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                HashMap<Integer,InsurancePolicy> policies=InsurancePolicy.load("policies1.ser");
//                System.out.println("--------------Printing a list of policies loaded from binary file--------------");
//                InsurancePolicy.printPolicies(policies);
               
            
//                System.out.println("\n---------------------------------------------------------------\n");
            
                //testing binary file and list of users
                
//                System.out.println(">>>testing binary file and list of users<<<\n");
//
//                HashMap<Integer, User> users = new HashMap<>();
//                
//                for(User allTheUsers: firstInsuranceCompany.getUsers().values()){
//                    
//                    users.put(allTheUsers.getUserID(), allTheUsers);
//                    
//                }
//                
//                User.save(users, "users.ser");
//                users.clear();
//            
//                users = User.load("users.ser");
//                User.printUsers(users);
                
                
//                User.save(firstInsuranceCompany.getUsers(),"users1.ser");
//                HashMap<Integer,User> users=User.load("users1.ser");
//                System.out.println("-----------------Printing a list of users loaded from binary file-------------------------");
//                System.out.println(users.values());
                
            
//                System.out.println("\n---------------------------------------------------------------\n");
            
                //InsuranceCompany and binary file
                
//                System.out.println(">>>InsuranceCompany and binary file<<<\n");
//                
//                firstInsuranceCompany.save("company.ser");
//                
//                InsuranceCompany insurcomp = new InsuranceCompany();
//                
//                insurcomp.load("company.ser");
//                System.out.println(insurcomp);
                
                
//                firstInsuranceCompany.save("company1.ser", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                    
//                System.out.println("-----------------Printing the insurance company loaded from binary file-------------------------");
//                InsuranceCompany insurcomp = new InsuranceCompany();
//                insurcomp.setAdminUsername(firstInsuranceCompany.getAdminUsername());
//                insurcomp.setAdminPassword(firstInsuranceCompany.getAdminPassword());
//                insurcomp.load("company1.ser", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                System.out.println(insurcomp);
               
                
//                System.out.println("\n---------------------------------------------------------------\n");
            
                // testing text file and list of policies with toDelimitedString
            
//                System.out.println(">>>testing text file and list of policies with toDelimitedString<<<\n");
//                
//                HashMap<Integer, InsurancePolicy> policies2 = new HashMap<>();
//                
//                HashMap<Integer, User> theUsersSavedInTheTextFile = new HashMap<>();
//                
//                theUsersSavedInTheTextFile = firstInsuranceCompany.getUsers();
//                
//                for(User userToSave2: theUsersSavedInTheTextFile.values()){
//                    
//                    for(InsurancePolicy ip: userToSave2.getPolicies().values()){
//                        
//                        policies2.put(ip.id, ip);
//                        
//                    }
//                    
//                }
//                
//                InsurancePolicy.saveTextFile(policies2, "policies.txt");
//                policies2.clear();
//            
//                policies2 = InsurancePolicy.loadTextFile("policies.txt");
//                InsurancePolicy.printPolicies(policies2);
                   
                
//                InsurancePolicy.saveTextFile(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()),"policies1.txt");
//                HashMap<Integer,InsurancePolicy> policies=InsurancePolicy.loadTextFile("policies1.txt");
//                System.out.println("--------------------------Printing a list of policies loaded from Text file-----------------------------");
//                InsurancePolicy.printPolicies(policies);
                
                
//                System.out.println("\n------------------------------------------------------------------------");
            
                // testing text file name and list of users with toDelimitedString
                
//                System.out.println(">>>testing text file and list of users with toDelimitedString<<<\n");
//            
//                HashMap<Integer, User> someUsers = new HashMap<>();
//                
//                for(User allTheUsers: firstInsuranceCompany.getUsers().values()){
//                    
//                    someUsers.put(allTheUsers.getUserID(), allTheUsers);
//                    
//                }
//                
//                User.saveTextFile(someUsers, "users.txt");
//                someUsers.clear();
//            
//                someUsers = User.loadTextFile("users.txt");
//                User.printUsers(someUsers);
                
                
//                User.saveTextFile(firstInsuranceCompany.getUsers(),"users1.txt");
//                HashMap<Integer,User> users=User.loadTextFile("users1.txt");
//                System.out.println("-------------------------Printing a list of users loaded from Text file----------------------------");
//                System.out.println(users.values());
                
                
//                System.out.println("\n---------------------------------------------------------------\n");
            
                // InsuranceCompany and text file
                
//                System.out.println(">>>InsuranceCompany and text file<<<\n");
//            
//                firstInsuranceCompany.saveTextFile("company.txt");
//                InsuranceCompany ic1 = new InsuranceCompany();
//            
//                ic1.loadTextFile("company.txt");
//                
//                System.out.println(ic1);
                
                
//                firstInsuranceCompany.saveTextFile("company1.txt", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                InsuranceCompany insuranceCompany2=new InsuranceCompany();
//                insuranceCompany2.setAdminUsername(firstInsuranceCompany.getAdminUsername());
//                insuranceCompany2.setAdminPassword(firstInsuranceCompany.getAdminPassword());
//                insuranceCompany2.loadTextFile("company1.txt", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                System.out.println("--------------------Printing the isnurance company loaded from text file------------------------------");
//                System.out.println(insuranceCompany2);
                
                
                System.out.println("---The ser files for insurance company, user, and policies are saved---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                
                break;
                
            case 18:
                
                HashMap<Integer,InsurancePolicy> policies=InsurancePolicy.load("policies1.ser");
                System.out.println("--------------Printing a list of policies loaded from binary file--------------");
                InsurancePolicy.printPolicies(policies);
                
                System.out.println("\n\n------------------------------------------------------------------------------\n\n");
                
                HashMap<Integer,User> users=User.load("users1.ser");
                System.out.println("-----------------Printing a list of users loaded from binary file-------------------------");
                System.out.println(users.values());
                
                System.out.println("\n\n------------------------------------------------------------------------------\n\n");
                
                System.out.println("-----------------Printing the insurance company loaded from binary file-------------------------");
                InsuranceCompany insurcomp = new InsuranceCompany();
                insurcomp.setAdminUsername(firstInsuranceCompany.getAdminUsername());
                insurcomp.setAdminPassword(firstInsuranceCompany.getAdminPassword());
                insurcomp.load("company1.ser", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                System.out.println(insurcomp);
                
                System.out.println("\n---The ser files for insurance company, user, and policies are loaded---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                
                break;
                
            case 19:
                
                InsurancePolicy.saveTextFile(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()),"policies1.txt");
                User.saveTextFile(firstInsuranceCompany.getUsers(),"users1.txt");
                firstInsuranceCompany.saveTextFile("company1.txt", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                
                System.out.println("---The txt files for insurance company, user, and policies are saved---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                
                break;
             
            case 20:
                
                HashMap<Integer,InsurancePolicy> policies1 = InsurancePolicy.loadTextFile("policies1.txt");
                System.out.println("--------------------------Printing a list of policies loaded from Text file-----------------------------");
                InsurancePolicy.printPolicies(policies1);
                
                System.out.println("\n\n-----------------------------------------------------------------------\n\n");
                
                HashMap<Integer,User> users1 = User.loadTextFile("users1.txt");
                System.out.println("-------------------------Printing a list of users loaded from Text file----------------------------");
                System.out.println(users1.values());
                
                System.out.println("\n\n-----------------------------------------------------------------------\n\n");
                
                InsuranceCompany insuranceCompany2=new InsuranceCompany();
                insuranceCompany2.setAdminUsername(firstInsuranceCompany.getAdminUsername());
                insuranceCompany2.setAdminPassword(firstInsuranceCompany.getAdminPassword());
                insuranceCompany2.loadTextFile("company1.txt", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                System.out.println("--------------------Printing the isnurance company loaded from text file------------------------------");
                System.out.println(insuranceCompany2);
                
                System.out.println("\n---The txt files for insurance company, user, and policies are loaded---\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                
                break;
                
            case 21:
                
                System.out.println(">>>Displaying the Test Code<<<\n");
                
                Address address1 = new Address(25, "Queen Street", "Box Hill", "Melbourne");
                User user1 = new User("Bruno Hoxha", address1, "12");
        
                Address address2 = new Address(20, "King Street", "Alford", "Sydney");
                User user2 = new User("Ergi Hoxha", address2, "34");
        
                Address address3 = new Address(15, "Prince Street", "Agnes", "Brisbane");
                User user3 = new User("Gledi Hoxha", address3, "56");
        
                Address address4 = new Address(10, "Princess Street", "Agery", "Wollongong");
                User user4 = new User("Emili Hoxha", address4, "78");
                
                firstInsuranceCompany.addUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), user1);
                firstInsuranceCompany.addUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(),user2);
                firstInsuranceCompany.addUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(),user3);
                firstInsuranceCompany.addUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(),user4);
                
                Car car1 = new Car("Benz", 2020, 20000, CarType.SUV);
                MyDate date1 = new MyDate(2030, 9, 25);
                ComprehensivePolicy compPolicy1 = new ComprehensivePolicy("Bruno Hoxha", 3829577, car1, 1,date1, 20,1);
        
                Car car3 = new Car("Volkswagon", 1990, 20000, CarType.LUX);
                MyDate date3 = new MyDate(2027, 7, 20);
                ComprehensivePolicy compPolicy2 = new ComprehensivePolicy("Ergi Hoxha", 3569325, car3, 1, date3, 40, 1);
        
                Car car2 = new Car("Range Rover", 2021, 20000, CarType.SED);
                MyDate date2 = new MyDate(2025, 11, 7);
                ThirdPartyPolicy thirPartPolicy1 = new ThirdPartyPolicy("Bruno Hoxha", 3789341, car2, 3, date2, "Good Car");
        
                Car car4 = new Car("Honda", 2000, 20000, CarType.HATCH);
                MyDate date4 = new MyDate(2027, 4, 15);
                ThirdPartyPolicy thirPartPolicy2 = new ThirdPartyPolicy("Ergi Hoxha", 3283572, car4, 3, date4, "Best Car");
        
                Car car5 = new Car("Benz", 2019, 20000, CarType.SUV);
                MyDate date5 = new MyDate(2027, 5, 20);
                ComprehensivePolicy compPolicy3 = new ComprehensivePolicy("Gledi Hoxha", 3628391, car5, 1, date5, 20,1);

                Car car6 = new Car("Chevelle", 2010, 20000, CarType.LUX);
                MyDate date6 = new MyDate(2027, 5, 13);
                ComprehensivePolicy compPolicy4 = new ComprehensivePolicy("Emili Hoxha", 3829411, car6, 1,date6, 70,1);
                
                firstInsuranceCompany.addPolicy(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), user1.getUserID(), compPolicy1);
                firstInsuranceCompany.addPolicy(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(),user2.getUserID(), compPolicy2);
                firstInsuranceCompany.addPolicy(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(),user3.getUserID(), compPolicy3);
                firstInsuranceCompany.addPolicy(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(),user4.getUserID(), compPolicy4);
                firstInsuranceCompany.addPolicy(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(),user1.getUserID(), thirPartPolicy1);
                firstInsuranceCompany.addPolicy(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(),user2.getUserID(), thirPartPolicy2);
                
                Car car7 = new Car("BMW", 1023, 20000, CarType.LUX);
                MyDate date7 = new MyDate(200, 5, 14);
                firstInsuranceCompany.createThirdPartyPolicy(user3.getUserID(), "Gledi Hoxha", 3291642, car7, 1, date7, "It is an amazing car", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());

                Car car8 = new Car("M4", 1050, 20000, CarType.SED);
                MyDate date8 = new MyDate(100, 5, 19);
                firstInsuranceCompany.createThirdPartyPolicy(user4.getUserID(), "Emili Hoxha", 3953811, car8, 1, date8, "I don't like this car", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());

                Car car9 = new Car("Benz", 500, 20000, CarType.HATCH);
                MyDate date9 = new MyDate(900, 10, 7);
                firstInsuranceCompany.createComprehensivePolicy(user2.getUserID(), "Ergi Hoxha", 3917402, car9, 1, date9, 50, 1, firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());

                Car car10 = new Car("M3", 1050, 20000, CarType.SED);
                MyDate date10 = new MyDate(100, 5, 19);

                firstInsuranceCompany.createThirdPartyPolicy(user1.getUserID(), "Bruno Hoxha", 3164028, car10, 1, date10, "Its an average car", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                
                System.out.print("---------------Printing the policies before the raise------------------------\n\n");
                
                for(InsurancePolicy ip: firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()).values()){
                    
                    System.out.println(ip);
                    
                }
                
                System.out.println();
               
//                InsurancePolicy.carPriceRiseAll(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()), 0.1);
                double risePercent = 0.1;
                
//                Collection<InsurancePolicy> pol = firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()).values();
//                ArrayList<InsurancePolicy> arrayListOfPolicies = new ArrayList<>(pol);
                InsurancePolicy.carPriceRiseAll(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()), risePercent);
                
                System.out.print("---------------Printing the policies after the raise------------------------\n\n");
                
                for(InsurancePolicy ip: firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()).values()){
                    
                    System.out.println(ip);
                    
                }
                
                System.out.println();
                
                System.out.print("-------------------------------------------------------------------\n\n");
                
                System.out.print("---------------Testing the printPolicies method------------------------\n");
                
                InsurancePolicy.printPolicies(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()));
                
                System.out.print("-------------------------------------------------------------------\n\n");
                
                System.out.print("---------------Testing the calcTotalPayments method------------------------\n");
                
                System.out.println(InsurancePolicy.calcTotalPayments(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()), 500));
                
                System.out.print("-------------------------------------------------------------------\n\n");
                
                System.out.print("---------------Testing the filterByCarModel method------------------------\n\n");
                
                HashMap<Integer, InsurancePolicy> filteredPoliciesBasedOnCarModel = InsurancePolicy.filterByCarModel(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()), "Benz");
                
                for(InsurancePolicy ip: filteredPoliciesBasedOnCarModel.values()){
                    
                    System.out.println(ip);
                    
                }
                
                System.out.print("-------------------------------------------------------------------\n\n");
                
                System.out.print("---------------Testing the shallowCopy method------------------------\n\n");
                
                System.out.print("------------------Printing the orginal policies before calling the shallow copy method and changing the policy holder name of one of the policies (3rd policy)-------------------\n\n");
                
//                System.out.print(arrayListOfPolicies.size());
                
                for(InsurancePolicy ip: firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()).values()){
                    
                    System.out.println(ip);
                    
                }
                
                HashMap<Integer, InsurancePolicy> shallowCopyOfPolicies = InsurancePolicy.shallowCopy(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()));
                HashMap<Integer, InsurancePolicy> deepCopyOfPolicies = InsurancePolicy.deepCopy(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()));
                
                System.out.print("\n------------------Printing the shallow copy policies before changing the policy holder name of one of the policies (3rd policy)-------------------\n\n");
                
//                System.out.print(shallowCopyOfPolicies.size());
                
                for(InsurancePolicy ip: shallowCopyOfPolicies.values()){
                    
                    System.out.println(ip);
                    
                }
                
                System.out.print("\n------------------Printing the deep copy policies before changing the policy holder name of one of the policies (3rd policy)-------------------\n\n");
                
                for(InsurancePolicy ip: deepCopyOfPolicies.values()){
                    
                    System.out.println(ip);
                    
                }
                
//                Car car11 = new Car("M80", 1050, 20000, CarType.SUV);
//                MyDate date11 = new MyDate(200, 5, 19);

//                firstInsuranceCompany.createThirdPartyPolicy(user1.getUserID(), "Bruno Hoxha", 3164028, car11, 1, date11, "Its an average/good car", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
                
//                ComprehensivePolicy policy11 = new ComprehensivePolicy("Bruno Hoxha", 3267819, car11, 1, date11, 31, 1);
                
//                System.out.print("\n------------------Printing the shallow copy policies after adding the new policy-------------------\n\n");
                
//                shallowCopyOfPolicies.add(policy11);
                
//                user1.addPolicy(policy11, user1.getName(), user1.getPassword());
                
//                user1.addPolicy(policy11, user1.getName(), user1.getPassword());
                
                compPolicy1.setPolicyHolderName("Ajde Kala");
                
//                ArrayList<InsurancePolicy> shallowCopyOfPolicies2 = InsurancePolicy.shallowCopy(arrayListOfPolicies);
                
//                System.out.print(shallowCopyOfPolicies.size());
                
//                for(InsurancePolicy ip: shallowCopyOfPolicies){
//                    
//                    System.out.println(ip);
//                    
//                }
                
                System.out.print("\n------------------Printing the original arrayList with policies after changing the policy holder name of one of the policies (3rd policy)-------------------\n\n");
                
//                System.out.print(arrayListOfPolicies.size());
                
                for(InsurancePolicy ip: firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()).values()){
                    
                    System.out.println(ip);
                    
                }
                
                System.out.print("\n------------------Printing the shallow copy policies after changing the policy holder name of one of the policies (3rd policy)-------------------\n\n");
                
//                shallowCopyOfPolicies.add(policy11);
                
//                user1.addPolicy(policy11, user1.getName(), user1.getPassword());
                
//                user1.addPolicy(policy11, user1.getName(), user1.getPassword());
                
//                ArrayList<InsurancePolicy> shallowCopyOfPolicies2 = InsurancePolicy.shallowCopy(arrayListOfPolicies);
                
//                System.out.print(shallowCopyOfPolicies.size());
                
                for(InsurancePolicy ip: shallowCopyOfPolicies.values()){
                    
                    System.out.println(ip);
                    
                }
                
                System.out.print("\n------------------Printing the deep copy policies after changing the policy holder name of one of the policies (3rd policy)-------------------\n\n");
                
                for(InsurancePolicy ip: deepCopyOfPolicies.values()){
                    
                    System.out.println(ip);
                    
                }
                
                System.out.print("\n-------------------------------------------------------------------\n\n");
                
                System.out.print("---------------Testing the filterByExpiryDate method------------------------\n\n");
                
                MyDate testDate = new MyDate(2024, 1, 11);
                
                HashMap<Integer, InsurancePolicy> filteredPoliciesByDate = InsurancePolicy.filterByExpiryDate(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()), testDate);
                
                for(InsurancePolicy ip: filteredPoliciesByDate.values()){
                    
                    System.out.print(ip + "\n");
                    
                }
                
                System.out.print("-------------------------------------------------------------------\n\n");
                
                System.out.print("---------------Testing the printPolicies method from User class------------------------\n\n");
                
                user1.printPolicies(500);
                
                System.out.print("-------------------------------------------------------------------\n\n");
                
                System.out.print("---------------Testing the shallowCopy method from Users------------------------\n\n");
                
//                Collection<User> collectTheUsers = firstInsuranceCompany.getUsers().values();
//                
//                ArrayList<User> allTheUsers = new ArrayList<>(collectTheUsers);
                
                HashMap<Integer, User> shallowCopiedUsers = User.shallowCopy(firstInsuranceCompany.getUsers());
                HashMap<Integer, User> deepCopiedUsers = User.deepCopy(firstInsuranceCompany.getUsers());
                
                System.out.print("------------------Printing the orginal users before changing the second users city location to London-------------------\n\n");
                
                for(User aUser: firstInsuranceCompany.getUsers().values()){
                    
                    System.out.println(aUser);
                    
                }
                
                System.out.print("\n------------------Printing the shallow copy users before changing the second users city location to London-------------------\n\n");
                
//                ArrayList<User> copiedUsersShallow = User.shallowCopy(allTheUsers);
                
                for(User aUser: shallowCopiedUsers.values()){
                    
                    System.out.println(aUser);
                    
                }
                
                System.out.print("\n------------------Printing the deep copy users before changing the second users city location to London-------------------\n\n");
                
//                ArrayList<User> copiedUsersDeep = User.deepCopy(allTheUsers);
                
                for(User aUser: deepCopiedUsers.values()){
                    
                    System.out.println(aUser);
                    
                }
                
                user2.getAddress().setCity("London");
                
//                Address address10 = new Address(3, "God knows", "Where", "I am");
//                User user10 = new User("Fabian Ibro", address10, "fabi");
                
                System.out.print("\n------------------Printing the original arrayList with users after changing the second users city location to London-------------------\n\n");
                
//                System.out.print(arrayListOfPolicies.size());
                
                for(User aUser: firstInsuranceCompany.getUsers().values()){
                    
                    System.out.println(aUser);
                    
                }
                
                System.out.print("\n------------------Printing the shallow copy users after changing the second users city location to London-------------------\n\n");
                
//                allTheUsers.add(user10);
                
//                ArrayList<User> copiedUsersShallow2 = User.shallowCopy(allTheUsers);
                
                for(User aUser: shallowCopiedUsers.values()){
                    
                    System.out.println(aUser);
                    
                }
                
                System.out.print("\n------------------Printing the deep copy users before changing the second users city location-------------------\n\n");
                
                for(User aUser: deepCopiedUsers.values()){
                    
                    System.out.println(aUser);
                    
                }
                
                System.out.print("-------------------------------------------------------------------\n\n");
                
                System.out.print("---------------Testing the calcTotalPremiums method from InsuranceCompany------------------------\n\n");
                
                System.out.print("The total calc payment for the entire insurance company is: " +firstInsuranceCompany.calcTotalPayments(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()));
                
                System.out.println();
                
                System.out.print("-------------------------------------------------------------------\n\n");
                
                System.out.print("---------------Testing the carPriceRise method from InsuranceCompany------------------------\n\n");
                
                System.out.print("---------------Printing out the car prices before the rise------------------------\n\n");
                
                for(User users2: firstInsuranceCompany.getUsers().values()){
                    
                    System.out.println(users2);
                    
                }
                
//                System.out.print(firstInsuranceCompany.carPriceRise(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), 0.1));
                firstInsuranceCompany.carPriceRise(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), 0.1);
                
                System.out.print("---------------Printing out the car prices after the rise (10%)------------------------\n\n");
                
                for(User users2: firstInsuranceCompany.getUsers().values()){
                    
                    System.out.println(users2);
                    
                }
                
                System.out.print("-------------------------------------------------------------------\n\n");
                
                System.out.print("---------------Testing the filterByCarModel method from InsuranceCompany------------------------\n\n");
                
                ArrayList<InsurancePolicy> retrievedCars = firstInsuranceCompany.filterByCarModel("Benz");
                
                for(InsurancePolicy ip: retrievedCars){
                    
                    System.out.println(ip);
                    
                }
                
                System.out.print("-------------------------------------------------------------------\n\n");
                
                System.out.print("---------------A) Search for the policy/ies that have in their policyholdername John------------------------\n\n");
                
                Car johnCar = new Car("Honda", 2023, 20000, CarType.LUX);
                MyDate johnDate = new MyDate(300, 6, 14);
                ThirdPartyPolicy JohnPolicy = new ThirdPartyPolicy("John Wick", 3578201, johnCar, 1, johnDate, "IDK");
                
                Car johnCar2 = new Car("Toyota", 2015, 20000, CarType.SUV);
                MyDate johnDate2 = new MyDate(700, 6, 14);
                ThirdPartyPolicy JohnPolicy2 = new ThirdPartyPolicy("Johnathan Joestar", 3258901, johnCar2, 1, johnDate2, "WHO KNOWS");
                
                Car aRandomCar = new Car("T1", 2009, 5000, CarType.HATCH);
                MyDate aRandomDate = new MyDate(900, 6, 14);
                ThirdPartyPolicy aRandomPolicy = new ThirdPartyPolicy("Bruno Hoxha", 3360145, aRandomCar, 1, aRandomDate, "MEH");
                
                Car aRandomCar2 = new Car("K2", 2009, 29000, CarType.SED);
                MyDate aRandomDate2 = new MyDate(1000, 6, 14);
                ThirdPartyPolicy aRandomPolicy2 = new ThirdPartyPolicy("Bruno Hoxha", 3147082, aRandomCar2, 1, aRandomDate2, "EH");
                
                user1.addPolicy(JohnPolicy, user1.getName(), user1.getPassword());
                user1.addPolicy(JohnPolicy2, user1.getName(), user1.getPassword());
                user1.addPolicy(aRandomPolicy, user1.getName(), user1.getPassword());
                user1.addPolicy(aRandomPolicy2, user1.getName(), user1.getPassword());
                
                Collection<InsurancePolicy> newOriginalList = firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()).values();
                ArrayList<InsurancePolicy> newArrayList = new ArrayList<>(newOriginalList);
                
                newArrayList.stream()
                        .filter(x->x.getPolicyHolderName().contains("John"))
                        .forEach(System.out::println);
                
                System.out.print("\n---------------B) Search for the policy/ies that have in their policyholdername John and display the total premium for all the policies found------------------------\n\n");
                
                newArrayList.stream()
                        .filter(x->x.getPolicyHolderName().contains("John"))
                        .map(x->x.calcPay(500))
                        .forEach(System.out::println);
                
                System.out.print("\n---------------C) Find the first policy with the premium between $200 and $500, sort them by ID, and display the name, ID, and premium for each policy------------------------\n\n");
                
                System.out.print("\n-----------------------------------Printing all the users with their current policies-------------------------\n");
                
                for(User allUsers: firstInsuranceCompany.getUsers().values()){
                    
                    System.out.print(allUsers + "\n");
                    
                }
                
                System.out.print("\n-----------------------Printing the first policy between $200 and $500-------------------------\n");
                
                newArrayList.stream()
                        .filter(x->x.calcPay(10)>= 200 && x.calcPay(10) <= 500)
                        .findFirst()
                        .map(x->"Name: " + x.getPolicyHolderName() + " ID: " + x.getID() + " Premium: " + x.calcPay(10))
                        .ifPresent(System.out::println);
                
                System.out.print("\n---------------D) Find all the policies with the premium between $200 and $500, sort them by ID, and display the name, ID, and premium for each policy------------------------\n\n");
                        
                newArrayList.stream()
                        .filter(x->x.calcPay(10)>= 200 && x.calcPay(10) <= 500)
                        .sorted(Comparator.comparingInt(InsurancePolicy::getID))
                        .map(x->"Name: " + x.getPolicyHolderName() + " ID: " + x.getID() + " Premium: " + x.calcPay(10))
                        .forEach(System.out::println);
                
                System.out.print("\n---------------E) Calculate the total premium for all the policies with the premium between $200 and $500------------------------\n\n");

                double total = newArrayList.stream()
                        .filter(x->x.calcPay(10)>= 200 && x.calcPay(10) <= 500)
                        .mapToDouble(x->x.calcPay(10))
                        .sum();
                
                System.out.print("The total for the policies between $200 and $500 is: " + total + "\n");
                
                System.out.print("\n---------------F)------------------------\n\n");
                
                Predicate<InsurancePolicy> carType = x->x.car.type.equals(x.car.type.LUX);
                ArrayList<InsurancePolicy> policies3 = filterPolicies(newArrayList, carType);
                InsurancePolicy.printPolicies(policies3);
                
                System.out.print("\n--------------------------------After sorting by car type and the prices of the cars-----------------------------------\n\n");
                Collections.sort(policies3, new compareCarPrices());
                InsurancePolicy.printPolicies(policies3);
                
                System.out.print("\n--------------------------------Aggregating the list of policies based on expiry date year-----------------------------------\n\n");
                
                Map<Integer, List<InsurancePolicy>> idk = policies3.stream()
                        .collect(Collectors.groupingBy(x-> x.getExpiryDate().getYear()));
                
                idk.forEach((year, policy) -> {
                    
                    policy.forEach(System.out::println);
                    
                    
                });
                
//                InsurancePolicy.printPolicies(filterPolicies(newArrayList, x->x.getExpiryDate().getYear() == 2020));
//                InsurancePolicy.printPolicies(filterPolicies(newArrayList, x->x.getCar().getModel().contains("Toyota")));
                
                
                System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"); 
                
                
                
                
//                System.out.println("---DEEP COPY POLICIES BEFORE CHANGING THE POLICY HOLDER NAME---\n");
//                
//                HashMap<Integer, InsurancePolicy> theDeepCopiedPolicies = user1.deepCopyPolicies(user1.getName(), user1.getPassword());
//        
//                HashMap<Integer, InsurancePolicy> theShallowCopiedPolicies = user1.shallowCopyPolicies(user1.getName(), user1.getPassword());
//
//                user1.getAddress().setCity("New York");

//                Car car11 = new Car("Volvo", 2014, 18000, CarType.LUX);
//                MyDate date11 = new MyDate(2019, 3, 17);
//                ThirdPartyPolicy thirPartPolicy11 = new ThirdPartyPolicy("Bruno Hoxha", 3399281, car11, 1, date11, "Meh");
//                user1.addPolicy(thirPartPolicy11, user1.getName(), user1.getPassword());
//                
//                for(InsurancePolicy ip: theDeepCopiedPolicies.values()){
//
//                    ip.print();
//
//                }
                
//                System.out.println("\n---SHALLOW COPY POLICIES BEFORE CHANGING THE POLICY HOLDER NAME---\n");
//        
//                for(InsurancePolicy ip: theShallowCopiedPolicies.values()){
//
//                    ip.print();
//
//                }

//                compPolicy1.setPolicyHolderName("Declan Idklastname");
//
//                 System.out.println("\n---DEEP COPY POLICIES AFTER CHANGING THE POLICY HOLDER NAME---\n");
//
//                for(InsurancePolicy ip: theDeepCopiedPolicies.values()){
//
//                    ip.print();
//
//                }

//                System.out.println("\n---SHALLOW COPY POLICIES AFTER CHANGING THE POLICY HOLDER NAME---\n");
//
//                for(InsurancePolicy ip: theShallowCopiedPolicies.values()){
//
//                    ip.print();
//
//                }
                
//                System.out.println("-------------------------------------------------------------------");
//        
//                ArrayList<InsurancePolicy> sortByExpiryDate = user1.sortPoliciesByDate(user1.getName(), user1.getPassword());
//
//                System.out.println("\n---PRINTING USER INFORMATION WITHOUT SORITING THE POLICIES---\n");
//
//                user1.print(user1.getName(), user1.getPassword());
//
//                System.out.println("\n---SORTING THE POLICIES BY EXPIRY DATE(COMPARABLE)---\n");
//
//                for(InsurancePolicy ip: sortByExpiryDate){
//
//                    ip.print();
//
//                }
//                
//                System.out.println("\n--------------------------------------------------------------------\n");
//        
//                HashMap<Integer, User> theDeepCopiedUsers = firstInsuranceCompany.deepCopyUsers(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                HashMap<Integer, User> theShallowCopiedUsers = firstInsuranceCompany.shallowCopyUsers(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//
//                Address address11 = new Address(10, "Jumbuck Street", "Jindalee", "QLD");
//                User user11 = new User("Jet John", address11, "Jet123");
//                firstInsuranceCompany.addUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(),user11);
//                
//                System.out.println("---DEEP COPY USERS BEFORE CHANGING A USER'S NAME---\n");
//                for(User aUser: theDeepCopiedUsers.values()){
//
//                    aUser.print(aUser.getName(), aUser.getPassword());
//
//                }
//
//                System.out.println("\n---SHALLOW COPY USERS BEFORE CHANGING A USER'S NAME---\n");
//                for(User aUser: theShallowCopiedUsers.values()){
//
//                    aUser.print(aUser.getName(), aUser.getPassword());
//
//                }
//                
//                System.out.println("\n------------------------------------------------------------------------\n");
//        
//                user1.setName("Michael Myers");
//
//                System.out.println("---DEEP COPY USERS AFTER CHANGING A USER'S NAME---\n");
//                for(User someUser: theDeepCopiedUsers.values()){
//
//                    someUser.print(someUser.getName(), someUser.getPassword());
//
//                }
//
//                System.out.println("\n---SHALLOW COPY USERS AFTER CHANGING A USER'S NAME---\n");
//                for(User someUser: theShallowCopiedUsers.values()){
//
//                    someUser.print(someUser.getName(), someUser.getPassword());
//
//                }
//
//                System.out.println("\n------------------------------------------------------------------------\n");
//
//                System.out.println("---SORTING USERS BY CITY NAME(COMPARABLE)---\n");
//                
//                ArrayList<User> sortUsersInTheCompany = firstInsuranceCompany.sortUsers(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                
//                for(User someUser: sortUsersInTheCompany){
//
//                    someUser.print(someUser.getName(), someUser.getPassword());
//
//                }
//                
//                System.out.println("\n------------------------------------------------------------------------\n");
//                
//                System.out.println("-----------------------COPYING THE INSURANCE COMPNAY AND CHANGING ITS NAME-----------------------");
//                
//                InsuranceCompany clonedCompany = (InsuranceCompany) firstInsuranceCompany.clone();
//
//                firstInsuranceCompany.setName("SSS");
//
//                System.out.println("\nOriginal List: \n " + firstInsuranceCompany);
//                System.out.println("Cloned List: \n" + clonedCompany);
//                
//                System.out.println("\n------------------------------------------------------------------------\n");
//                
//                System.out.println("---------------------SORTING USERS BY THIER PREMIUM PAYMENT(COMPARATOR)---------------------\n");
//                
//                System.out.println("\n---------------------------Before sorting-------------------------------\n");
//            
//                HashMap<Integer, User> AllTheUsers = firstInsuranceCompany.getUsers();
//
//                for(User printUsers: AllTheUsers.values()){
//
//                    System.out.println(printUsers);
//
//                }
//
//                System.out.println("\n---------------------------After sorting-------------------------------\n");
//
//                System.out.println(firstInsuranceCompany.sortUsersByPremium(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()) + "\n");
//                
//                System.out.println("\n------------------------------------------------------------------------\n");
//                
//                System.out.println("---------------------------------SAVING AND LOADING POLICIES TO A .SER FILE-------------------------------------");
//                
//                try {
//                    InsurancePolicy.save(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()),"policies1.ser");
//                    HashMap<Integer,InsurancePolicy> policies5 = InsurancePolicy.load("policies1.ser");
//                    System.out.println("--------------Printing a list of policies loaded from binary file--------------");
//                    InsurancePolicy.printPolicies(policies5);
//                }catch(Exception e) {
//                    
//                    System.err.println(e);
//                }
//                
//                System.out.println("\n---------------------------------SAVING AND LOADING USERS TO A .SER FILE-------------------------------------\n");
//                
//                try {
//                    User.save(firstInsuranceCompany.getUsers(),"users1.ser");
//                    HashMap<Integer,User> users5 = User.load("users1.ser");
//                    System.out.println("-----------------Printing a list of users loaded from binary file-------------------------");
//                    System.out.println(users5.values());
//                }catch(Exception e) {
//                    System.err.println(e);
//                }
//                
//                System.out.println("\n---------------------------------SAVING AND LOADING COMPANY TO A .SER FILE-------------------------------------\n");
//                
//                try {
//                    firstInsuranceCompany.save("company1.ser", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                    
//                    System.out.println("-----------------Printing the insurance company loaded from binary file-------------------------");
//                    InsuranceCompany insurcomp5 = new InsuranceCompany();
//                    insurcomp5.setAdminUsername(firstInsuranceCompany.getAdminUsername());
//                    insurcomp5.setAdminPassword(firstInsuranceCompany.getAdminPassword());
//                    insurcomp5.load("company1.ser", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                    System.out.println(insurcomp5);
//                }catch(Exception e) {
//                    System.err.println(e);
//                }
//                
//                System.out.println("---------------------------------SAVING AND LOADING POLICIES TO A .TXT FILE-------------------------------------");
//                
//                try{
//                    InsurancePolicy.saveTextFile(firstInsuranceCompany.allPolicies(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword()),"policies1.txt");
//                    HashMap<Integer,InsurancePolicy> policies5 = InsurancePolicy.loadTextFile("policies1.txt");
//                    System.out.println("--------------------------Printing a list of policies loaded from Text file-----------------------------");
//                    InsurancePolicy.printPolicies(policies5);
//                }catch(Exception e) {
//                    System.err.println(e);
//                }
//                
//                System.out.println("---------------------------------SAVING AND LOADING USERS TO A .TXT FILE-------------------------------------");
//                
//                try {
//                    User.saveTextFile(firstInsuranceCompany.getUsers(),"users1.txt");
//                    HashMap<Integer,User> users5 = User.loadTextFile("users1.txt");
//                    System.out.println("-------------------------Printing a list of users loaded from Text file----------------------------");
//                    System.out.println(users5.values());
//                }catch(Exception e) {
//                    System.err.println(e);
//                }
//                
//                System.out.println("---------------------------------SAVING AND LOADING COMPANY TO A .TXT FILE-------------------------------------");
//                
//                try{
//                    firstInsuranceCompany.saveTextFile("company1.txt", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                    InsuranceCompany insuranceCompany25=new InsuranceCompany();
//                    insuranceCompany25.setAdminUsername(firstInsuranceCompany.getAdminUsername());
//                    insuranceCompany25.setAdminPassword(firstInsuranceCompany.getAdminPassword());
//                    insuranceCompany25.loadTextFile("company1.txt", firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//                    System.out.println("--------------------Printing the isnurance company loaded from text file------------------------------");
//                    System.out.println(insuranceCompany25);
//                }catch(Exception e) {
//                    System.err.println(e);
//                }
                
                System.out.println("\n-------The test code is displayed above-------\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                break;
                
            
            case 22:
                
                System.out.println(">>>Displaying the cloned insurance company<<<\n");
                
                InsuranceCompany clonedCompany1 = (InsuranceCompany) firstInsuranceCompany.clone();

                firstInsuranceCompany.setName("SSS");

                System.out.println("\nOriginal List: \n " + firstInsuranceCompany);
                System.out.println("Cloned List: \n" + clonedCompany1);
                
                System.out.println("\n-------The cloned insurance company is displayed above-------\n");
                System.out.println("Do you want to continue?");
                scan.nextLine();
                scan.nextLine();
                AdminMenu(firstInsuranceCompany);
                break;
                
            case 23:
                MainMenu(firstInsuranceCompany);
                System.exit(0);
                
            default:
                System.out.println(">>>Please enter a valid option!<<<\n");
                AdminMenu(firstInsuranceCompany);
                break;
            
        }
        
    }
    
    public static void MainMenu(InsuranceCompany firstInsuranceCompany)throws CloneNotSupportedException, PolicyException, IOException, PolicyHolderNameException{
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println(">>>Main Menu<<<\n");
        System.out.println("1) Admin Login");
        System.out.println("2) User Login");
        System.out.println("3) Exit Program");
        System.out.print("Please choose an option from 1-3: ");
        
        int option = 0;
        
        while(option == 0){
            
            try{
                
                option = scan.nextInt();
                
            }catch(InputMismatchException e){
                        
                String badInput = scan.next();
                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nPlease choose an option from 1-3: ");
                        
            }
            
        }
       
        System.out.println();
        scan.nextLine();
        
        switch(option){
            
            case 1:
                AdminLogin.main_Adminlogin();
//                System.out.print("Enter admin username: ");
//                String adminUsername = scan.nextLine();
//                System.out.print("Enter admin password: ");
//                String adminPassword = scan.nextLine();
//                
//                if(firstInsuranceCompany.validateAdmin(adminUsername, adminPassword)){
//            
//                    System.out.println("\n>>>Login successful!<<<\n");
//                    AdminMenu(firstInsuranceCompany);
//                    
//            
//                }else{
//                    
//                    System.out.println("\n>>>Invalid username or password!Try again<<<\n");
//                    MainMenu(firstInsuranceCompany);
//                    
//                }
//           
                break;
                
            case 2:
                
//                UserMenu(firstInsuranceCompany);
                Login.main_login();
                
                break;
                
            case 3:
                System.exit(0);
            
            default:
                System.out.println(">>>Please enter a valid option!<<<\n");
                MainMenu(firstInsuranceCompany);
                break;
                
        }
        
    }
    
    public static void UserMenu(InsuranceCompany firstInsuranceCompany) throws CloneNotSupportedException, PolicyException, IOException, PolicyHolderNameException{
        
//        User user = getUserBeforeAccessingUserMenu(firstInsuranceCompany);

        Scanner scan = new Scanner(System.in);
        
        User user = userLogin(firstInsuranceCompany);
        
//        System.out.println("\n>>>Welcome to the User Menu<<<\n");
//        
//        System.out.println("1) Create ThirdParty Policy");
//        System.out.println("2) Create Comprehensive Policy");
//        System.out.println("3) Print a policy");
//        System.out.println("4) Print the policies and their costs");
//        System.out.println("5) Calculate the total premium payment");
//        System.out.println("6) Filter by Car Model");
//        System.out.println("7) Filter by Expiry Date");
//        System.out.println("8) Change Address");
//        System.out.println("9) Remove policy");
//        System.out.println("10) Print User Information");
//        System.out.println("11) Report: Payment by Car Model for User");
//        System.out.println("12) Log Out");
//        System.out.print("Please choose an option from 1 to 12: ");
//        
//        int option = 0;
//        
//        while(option == 0){
//            
//            try{
//                
//                option = scan.nextInt();
//                
//            }catch(InputMismatchException e){
//                        
//                String badInput = scan.next();
//                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nPlease choose an option from 1 to 12: ");
//                        
//            }
//            
//        }
//        
//        System.out.println();

        int option;
        
        do{
            
            option = DisplayUsersMenu(firstInsuranceCompany);
            
            switch(option){
        
                // get user id
                case 1:
    //                System.out.println(">>>You have choosen to create a third party policy<<<\n");
    //                System.out.print("Enter your user ID: ");
    //                
    //                int enteredUserID = 0;
    //                
    //                while(enteredUserID == 0){
    //                    
    //                    try{
    //                        
    //                        enteredUserID = scan.nextInt();
    //                        scan.nextLine();
    //                        
    //                    }catch(InputMismatchException e){
    //                        
    //                        String badInput = scan.next();
    //                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter your user ID: ");
    //                        
    //                    }
    //                    
    //                }

                    System.out.println(">>>You have choosen to create a third party policy<<<\n");

                    if(user != null){

    //                    User user = firstInsuranceCompany.findUser(enteredUserID);
                        scan.nextLine();
                        System.out.print("Enter policy holder name: ");
                        String policyHolderName = scan.nextLine();
                        System.out.print("Enter the ID of the policy: ");

                        int policyID = 0;

                        while(policyID == 0){

                            try{

                                policyID = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the ID of the policy: ");

                            }

                        }

                        System.out.println("\n---Enter the car details--- \n");
                        System.out.print("Enter car model: ");
                        String carModel = scan.nextLine();
                        System.out.print("Enter manufacturing year: ");

                        int manufacturingYear = 0;

                        while(manufacturingYear == 0){

                            try{

                                manufacturingYear = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter manufacturing year: ");

                            }

                        }

                        System.out.print("Enter the price of the car($): ");

                        int carPrice = 0;

                        while(carPrice == 0){

                            try{

                                carPrice = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the price of the car($): ");

                            }

                        }

                        System.out.print("Enter the type of the car (SUV, SED, LUX, HATCH): ");
                        String enteredCarType = scan.nextLine();
                        CarType carType = CarType.valueOf(enteredCarType.toUpperCase());
                        Car newCar = new Car(carModel, manufacturingYear, carPrice, carType);
                        System.out.print("Enter number of claims: ");

                        int numOfClaims = 0;

                        while(numOfClaims == 0){

                            try{

                                numOfClaims = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter number of claims: ");

                            }

                        }

                        System.out.println("\n---Enter the expiry date of the policy--- \n");
                        System.out.print("Enter the day of expiry: ");

                        int day = 0;

                        while(day == 0){

                            try{

                                day = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the day of expiry: ");

                            }

                        }

                        System.out.print("Enter the month of expiry: ");

                        int month = 0;

                        while(month == 0){

                            try{

                               month = scan.nextInt();
                               scan.nextLine(); 

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the month of expiry: ");

                            }

                        }

                        System.out.print("Enter the year of expiry: ");

                        int year = 0;

                        while(year == 0){

                            try{

                                year = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the year of expiry: ");

                            }

                        }

                        MyDate enteredExpiryDate = new MyDate(year, month, day);
                        System.out.println("------------------------------------------------");
                        System.out.print("\nEnter your comment about this car: ");
                        String comment = scan.nextLine();

                        try{

                            user.createThirdPartyPolicy(policyHolderName, policyID, newCar, numOfClaims, enteredExpiryDate, comment, user.getName(), user.getPassword());

                        }catch(PolicyException e){

                            user.createThirdPartyPolicy(policyHolderName, e.getID(), newCar, numOfClaims, enteredExpiryDate, comment, user.getName(), user.getPassword());
                            System.out.println("\n" + e);
                            System.out.println("\n---Third Party Policy created and added to your list of policies!---\n");
                            System.out.println("Please, press any key to continue");
                            scan.nextLine();
                            
                            break;

                        }

                        catch(PolicyHolderNameException ex){

                            System.out.println(ex);
                            System.out.println("Please, press any key to continue");
                            scan.nextLine();
                            
                            break;

                        }

                        user.createThirdPartyPolicy(policyHolderName, policyID, newCar, numOfClaims, enteredExpiryDate, comment, user.getName(), user.getPassword());
                        System.out.println("\n---Third Party Policy created and added to your list of policies!---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }else{

                        System.out.println("---Policy could not be created because user ID does not exist---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }

                case 2:
                    System.out.println(">>>You have choosen to create a comprehensive policy<<<\n");
    //                System.out.print("Enter your user ID: ");

    //                int newEnteredUserID = 0;
    //                
    //                while(newEnteredUserID == 0){
    //                    
    //                    try{
    //                        
    //                        newEnteredUserID = scan.nextInt();
    //                        scan.nextLine();
    //                        
    //                    }catch(InputMismatchException e){
    //                        
    //                        String badInput = scan.next();
    //                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter your user ID: ");
    //                        
    //                    }
    //                                       
    //                }

                    if(user != null){

    //                    User user = firstInsuranceCompany.findUser(newEnteredUserID);
                        scan.nextLine();
                        System.out.print("Enter policy holder name: ");
                        String policyHolderName = scan.nextLine();
                        System.out.print("Enter the ID of the policy: ");

                        int policyID = 0;

                        while(policyID == 0){

                            try{

                                policyID = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the ID of the policy: ");

                            }

                        }

                        System.out.println("\n---Enter the car details--- \n");
                        System.out.print("Enter car model: ");
                        String carModel = scan.nextLine();
                        System.out.print("Enter manufacturing year: ");

                        int manufacturingYear = 0;

                        while(manufacturingYear == 0){

                            try{

                                manufacturingYear = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter manufacturing year: ");

                            }

                        }

                        System.out.print("Enter the price of the car($): ");

                        int carPrice = 0;

                        while(carPrice == 0){

                            try{

                                carPrice = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the price of the car($): ");

                            }

                        }

                        System.out.print("Enter the type of the car (SUV, SED, LUX, HATCH): ");
                        String enteredCarType = scan.nextLine();
                        CarType carType = CarType.valueOf(enteredCarType.toUpperCase());
                        Car newCar = new Car(carModel, manufacturingYear, carPrice, carType);
                        System.out.print("Enter number of claims: ");

                        int numOfClaims = 0;

                        while(numOfClaims == 0){

                            try{

                                numOfClaims = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter number of claims: ");

                            }

                        }

                        System.out.println("\n---Enter the expiry date of the policy--- \n");
                        System.out.print("Enter the day of expiry: ");

                        int day = 0;

                        while(day == 0){

                            try{

                                day = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the day of expiry: ");

                            }

                        }

                        System.out.print("Enter the month of expiry: ");

                        int month = 0;

                        while(month == 0){

                            try{

                                month = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the month of expiry: ");

                            }

                        }

                        System.out.print("Enter the year of expiry: ");

                        int year = 0;

                        while(year == 0){

                            try{

                                year = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the year of expiry: ");

                            }

                        }

                        MyDate enteredExpiryDate = new MyDate(year, month, day);
                        System.out.println("--------------------------------------------------");

                        System.out.print("\nEnter the driver's age: ");

                        int age = 0;

                        while(age == 0){

                            try{

                               age = scan.nextInt();
                               scan.nextLine(); 

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the driver's age: ");

                            }

                        }

                        System.out.print("Enter the level: ");

                        int level = 0;

                        while(level == 0){

                            try{

                                level = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the level: ");

                            }

                        }

                        try{

                            user.createComprehensivePolicy(policyHolderName, policyID, newCar, numOfClaims, enteredExpiryDate, age, level, user.getName(), user.getPassword());

                        }catch(PolicyException e){

                            user.createComprehensivePolicy(policyHolderName, e.getID(), newCar, numOfClaims, enteredExpiryDate, age, level, user.getName(), user.getPassword());
                            System.out.println("\n" + e);
                            System.out.println("\n---Comprehensive Policy created and added to your list of policies!---\n");
                            System.out.println("Please, press any key to continue");
                            scan.nextLine();
                            
                            break;
                        }

                        catch(PolicyHolderNameException ex){

                            System.out.println(ex);
                            System.out.println("Please, press any key to continue");
                            scan.nextLine();
                            
                            break;

                        }

                        user.createComprehensivePolicy(policyHolderName, policyID, newCar, numOfClaims, enteredExpiryDate, age, level, user.getName(), user.getPassword());
                        System.out.println("\n---Comprehensive Policy created and added to your list of policies!---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }else{

                        System.out.println("---Policy could not be created because user ID does not exist---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }

                case 3:
                    System.out.println(">>>You have choosen to print a policy<<<\n");
    //                System.out.print("Enter your user ID: ");
    //                
    //                int userIDToFindPolicy = 0;
    //                
    //                while(userIDToFindPolicy == 0){
    //                    
    //                    try{
    //                        
    //                        userIDToFindPolicy = scan.nextInt();
    //                        
    //                    }catch(InputMismatchException e){
    //                        
    //                        String badInput = scan.next();
    //                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter your user ID: ");
    //                        
    //                    }
    //                    
    //                }

                    if(user != null){

    //                    User user = firstInsuranceCompany.findUser(userIDToFindPolicy);

                        System.out.print("Enter policy ID: ");

                        int policyID = 0;

                        while(policyID == 0){

                            try{

                                policyID = scan.nextInt();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter policy ID: ");

                            }

                        }

                        System.out.println();
                        System.out.print(user.findPolicy(policyID, user.getName(), user.getPassword()));
                        System.out.println("\n\n---Policy exists and is shown above!---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        scan.nextLine();
                        
                        break;

                    }else{

                        System.out.println("---Policy could not be found because user ID does not exist---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }

                case 4:
                    System.out.println(">>>You have choosen to print your policies and their costs<<<\n");
    //                System.out.print("Enter your user ID: ");
    //                
    //                int userIDToPrintInfo = 0;
    //                
    //                while(userIDToPrintInfo == 0){
    //                    
    //                    try{
    //                        
    //                        userIDToPrintInfo = scan.nextInt();
    //                        scan.nextLine();
    //                        
    //                    }catch(InputMismatchException e){
    //                        
    //                        String badInput = scan.next();
    //                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter your user ID: ");
    //                        
    //                    }
    //                    
    //                }

                    System.out.println();

                    if(user != null){

    //                    User user = firstInsuranceCompany.findUser(userIDToPrintInfo);
                        user.printPolicies(500, user.getName(), user.getPassword());
                        System.out.println("---User's Policies Printed!---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }else{

                        System.out.println("---Could not print user information because the entered user ID does not exist---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }

                case 5:
                    System.out.println(">>>You have choosen to calculate the total premium payment for your policies<<<\n");
    //                System.out.print("Enter your user ID: ");
    //                
    //                int userIDToCalcPolcies = 0;
    //                
    //                while(userIDToCalcPolcies == 0){
    //                    
    //                    try{
    //                        
    //                        userIDToCalcPolcies = scan.nextInt();
    //                        scan.nextLine();
    //                        
    //                    }catch(InputMismatchException e){
    //                        
    //                        String badInput = scan.next();
    //                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter your user ID: ");
    //                        
    //                    }
    //                    
    //                }

                    System.out.println();

                    if(user != null){

    //                    User user = firstInsuranceCompany.findUser(userIDToCalcPolcies);

                        System.out.print("The total premium payment for all your polciies is: $" + user.calcTotalPremiums(500, user.getName(), user.getPassword()));
                        System.out.println("\n\n---Total Premium Payment is shown above!---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }else{

                        System.out.println("---Could not calculate total premium payment because the entered user ID does not exist---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }

                case 6:
                    System.out.println(">>>You have choosen to find the policies that are assigned to the same car model<<<\n");
    //                System.out.print("Enter your user ID: ");
    //                
    //                int userIDToFilterPoliciesByCarModel = 0;
    //                
    //                while(userIDToFilterPoliciesByCarModel == 0){
    //                    
    //                    try{
    //                        
    //                        userIDToFilterPoliciesByCarModel = scan.nextInt();
    //                        scan.nextLine();
    //                        
    //                    }catch(InputMismatchException e){
    //                        
    //                        String badInput = scan.next();
    //                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter your user ID: ");
    //                        
    //                    }
    //                    
    //                }

                    if(user != null){

    //                    User user = firstInsuranceCompany.findUser(userIDToFilterPoliciesByCarModel);

                        System.out.print("Enter the car model: ");
                        String carModel = scan.nextLine();
                        System.out.println();

    //                   ArrayList<InsurancePolicy> ipWithCarModel = new ArrayList<>();
    //                   ipWithCarModel.addAll(user.filterByCarModel(carModel));
                        HashMap<Integer, InsurancePolicy> ipWithCarModel = new HashMap<Integer, InsurancePolicy>();
                        ipWithCarModel.putAll(user.filterByCarModel(carModel, user.getName(), user.getPassword()));

                        for(InsurancePolicy ip: ipWithCarModel.values()){

                           System.out.println(ip); 
                        }

                        System.out.println("\n---Policies with the desired car model are shown above!---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;  

                    }else{

                        System.out.println("---The list of policies with the asked car model is not displayed becasue the user ID does not exist---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }

                case 7:
                    System.out.println(">>>You have choosen to find the policies that are expired<<<\n");
    //                System.out.print("Enter your user ID: ");
    //                
    //                int userIDToFilterExpiredPolicies = 0;
    //                
    //                while(userIDToFilterExpiredPolicies == 0){
    //                    
    //                    try{
    //                        
    //                        userIDToFilterExpiredPolicies = scan.nextInt();
    //                        scan.nextLine();
    //                        
    //                    }catch(InputMismatchException e){
    //                        
    //                        String badInput = scan.next();
    //                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter your user ID: ");
    //                        
    //                    }
    //                    
    //                }

                    if(user != null){

    //                    User user = firstInsuranceCompany.findUser(userIDToFilterExpiredPolicies);

                        System.out.println("\n---Enter the date, for which you want to check the expired policies---\n");
                        System.out.print("Enter the day: ");

                        int day = 0;

                        while(day == 0){

                            try{

                                day = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the day: ");

                            }

                        }

                        System.out.print("Enter the month: ");

                        int month = 0;

                        while(month == 0){

                            try{

                                month = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the month: ");

                            }

                        }

                        System.out.print("Enter the year: ");

                        int year = 0;

                        while(year == 0){

                            try{

                                year = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the year: ");

                            }

                        }

                        System.out.println();
                        MyDate expiryDate = new MyDate(year, month, day);

    //                    ArrayList<InsurancePolicy> ipThatHaveExpired = new ArrayList<>();
    //                    ipThatHaveExpired.addAll(user.filterByExpiryDate(expiryDate));
                        HashMap<Integer, InsurancePolicy> ipThatHaveExpired = new HashMap<Integer, InsurancePolicy>();
                        ipThatHaveExpired.putAll(user.filterByExpiryDate(expiryDate, user.getName(), user.getPassword()));

                        for(InsurancePolicy ip: ipThatHaveExpired.values()){

                            System.out.println(ip);

                        }

                        System.out.println("\n---Policies that have expired are shown above!---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break; 

                    }else{

                        System.out.println("---The list of policies that have expired is not displayed becasue the user ID does not exist---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }                

                case 8:
                    System.out.println(">>>You have choosen to change your address<<<\n");
    //                System.out.print("Enter your user ID: ");
    //                
    //                int userIDToChangeAddress = 0;
    //                
    //                while(userIDToChangeAddress == 0){
    //                    
    //                    try{
    //                        
    //                        userIDToChangeAddress = scan.nextInt();
    //                        scan.nextLine();
    //                        
    //                    }catch(InputMismatchException e){
    //                        
    //                        String badInput = scan.next();
    //                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter your user ID: ");
    //                        
    //                    }
    //                    
    //                }

                    if(user != null){

    //                    User user = firstInsuranceCompany.findUser(userIDToChangeAddress);

                        System.out.println("\n---Enter the information for a new address---\n");
                        System.out.print("Enter the new street in which you live: ");
                        String newStreetInfo = scan.nextLine();
                        System.out.print("Enter the new street number in which you live: ");

                        int newStreetNumInfo = 0;

                        while(newStreetNumInfo == 0){

                            try{

                                newStreetNumInfo = scan.nextInt();
                                scan.nextLine();

                            }catch(InputMismatchException e){

                                String badInput = scan.next();
                                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the new street number in which you live: ");

                            }

                        }

                        System.out.print("Enter the new suburb in which you live: ");
                        String newSuburbInfo = scan.nextLine();
                        System.out.print("Enter the new city in which you live: ");
                        String newCityInfo = scan.nextLine();

                        Address anotherAddress = new Address(newStreetNumInfo, newStreetInfo, newSuburbInfo, newCityInfo);
                        user.setAddress(anotherAddress);
                        System.out.println();

                        System.out.println("Your address is updated!\n");

                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }else{

                        System.out.println("---The address could not be updated because the user ID does not exist---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }

                case 9:
                    System.out.println(">>>You have choosen to remove a policy<<<\n");
                    scan.nextLine();

    //                System.out.print("Enter your user ID: ");
    //                
    //                int userIDToRemovePolicy = 0;
    //                
    //                while(userIDToRemovePolicy == 0){
    //                    
    //                    try{
    //                        
    //                        userIDToRemovePolicy = scan.nextInt();
    //                        scan.nextLine();
    //                        
    //                    }catch(InputMismatchException e){
    //                        
    //                        String badInput = scan.next();
    //                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter your user ID: ");
    //                        
    //                    }
    //                    
    //                }

                    System.out.print("Enter the ID of the policy that you want to remove: ");

                    int policyIDToRemove = 0;

                    while(policyIDToRemove == 0){

                        try{

                            policyIDToRemove = scan.nextInt();
                            scan.nextLine();

                        }catch(InputMismatchException e){

                            String badInput = scan.next();
                            System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter the ID of the policy that you want to remove: ");

                        }

                    }

                    if(user != null){

    //                    User user = firstInsuranceCompany.findUser(userIDToRemovePolicy);

                        if(user.findPolicy(policyIDToRemove, user.getName(), user.getPassword()) != null){

    //                        ArrayList<InsurancePolicy> ipToGetRemoved = new ArrayList<>();
    //                        ipToGetRemoved.addAll(user.getPolicies());
                            HashMap<Integer, InsurancePolicy> ipToGetRemoved = new HashMap<Integer, InsurancePolicy>();
                            ipToGetRemoved.putAll(user.getPolicies());
    //                        ipToGetRemoved.remove(user.findPolicy(policyIDToRemove));
                            ipToGetRemoved.remove(policyIDToRemove);
                            user.setPolicies(ipToGetRemoved);

                            System.out.println("\n---The policy got removed---\n");
                            System.out.println("Please, press any key to continue");
                            scan.nextLine();
                            
                            break;

                        }else{

                            System.out.println("---The entered policy ID does not exist---\n");
                            System.out.println("Please, press any key to continue");
                            scan.nextLine();
                            
                            break;

                        }

                    }else{

                        System.out.println("---The entered user ID does not exist---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }

                case 10:
                    System.out.println(">>>You have choosen to display your information<<<\n");
    //                System.out.print("Enter your user ID: ");
    //                
    //                int userIDToDisplayUserInformation = 0;
    //                
    //                while(userIDToDisplayUserInformation == 0){
    //                    
    //                    try{
    //                        
    //                        userIDToDisplayUserInformation = scan.nextInt();
    //                        scan.nextLine();
    //                        
    //                    }catch(InputMismatchException e){
    //                        
    //                        String badInput = scan.next();
    //                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter your user ID: ");
    //                        
    //                    }
    //                    
    //                }

                    if(user != null){

    //                    User user = firstInsuranceCompany.findUser(userIDToDisplayUserInformation);

                        user.print(user.getName(), user.getPassword());

                        System.out.println("\n---The user information is displayed above---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }else{

                        System.out.println("---The user information could not be displayed because the user ID does not exist---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        
                        break;

                    }

                case 11:
                    System.out.println(">>>You have choosen to aggregate a data report<<<\n");

    //                System.out.print("Enter your user ID: ");
    //                
    //                int userIDForDataAggregation = 0;
    //                
    //                while(userIDForDataAggregation == 0){
    //                    
    //                    try{
    //                        
    //                        userIDForDataAggregation = scan.nextInt();
    //                        
    //                    }catch(InputMismatchException e){
    //                        
    //                        String badInput = scan.next();
    //                        System.out.print("\n---PLEASE ENTER INTEGER--- \n\nEnter your user ID: ");
    //                        
    //                    }
    //                    
    //                }

                    if(user != null){

    //                    User user = firstInsuranceCompany.findUser(userIDForDataAggregation);

                        ArrayList<String> carModels = user.populateDistinctCarModels(user.getName(), user.getPassword());
                        ArrayList<Double> premiumPayments = user.getTotalPaymentPerCarModel(carModels, user.getName(), user.getPassword());
                        ArrayList<Integer> counts = user.getTotalCountPerCarModel(carModels, user.getName(), user.getPassword());
                        user.reportPaymentsPerCarModel(carModels, counts, premiumPayments, user.getName(), user.getPassword());

                        System.out.println("\n---The report is displayed above---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        scan.nextLine();
                        
                        break;

                    }else{

                        System.out.println("---The report could not be displayed because the user ID does not exist---\n");
                        System.out.println("Please, press any key to continue");
                        scan.nextLine();
                        break;

                    }

                case 12:
                    MainMenu(firstInsuranceCompany);
                    break;

                default:
                    System.out.println(">>>Please enter a valid option (1-12)!<<<\n");
                    System.out.println("Please, press any key to continue");
                    scan.nextLine();
                    break;
            }
            
        }while(option != 12);        
             
    }
      
    public static User userLogin(InsuranceCompany firstInsuranceCompany) throws CloneNotSupportedException, PolicyException, IOException, PolicyHolderNameException{
        
        Scanner scan = new Scanner(System.in);
        
        User user = null;
        boolean flag = false;
        while(!flag){
            
            System.out.print("Enter username: ");
            String username = scan.nextLine();
            System.out.print("Enter password: ");
            String password = scan.nextLine();
            
            user = firstInsuranceCompany.findingTheUserToValidate(username, password);
            
            if(user != null){
                
                flag = true;
                System.out.println("\n>>>Login successful!<<<\n");
                
            }else{
                
                System.out.println("\n>>>Invalid username or password!Try again<<<\n");
                MainMenu(firstInsuranceCompany);
                
            }
            
        }
        
        return user;
        
    }
    
    public static Integer DisplayUsersMenu(InsuranceCompany firstInsuranceCompany) throws CloneNotSupportedException, PolicyException, IOException, PolicyHolderNameException{
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n>>>Welcome to the User Menu<<<\n");
        
        System.out.println("1) Create ThirdParty Policy");
        System.out.println("2) Create Comprehensive Policy");
        System.out.println("3) Print a policy");
        System.out.println("4) Print the policies and their costs");
        System.out.println("5) Calculate the total premium payment");
        System.out.println("6) Filter by Car Model");
        System.out.println("7) Filter by Expiry Date");
        System.out.println("8) Change Address");
        System.out.println("9) Remove policy");
        System.out.println("10) Print User Information");
        System.out.println("11) Report: Payment by Car Model for User");
        System.out.println("12) Log Out");
        System.out.print("Please choose an option from 1 to 12: ");
        
        int option = 0;
        
        while(option == 0){
            
            try{
                
                option = scan.nextInt();
                
            }catch(InputMismatchException e){
                        
                String badInput = scan.next();
                System.out.print("\n---PLEASE ENTER INTEGER--- \n\nPlease choose an option from 1 to 12: ");
                        
            }
            
        }
        
        System.out.println();
        return option;
        
    }
    
    static ArrayList<InsurancePolicy> filterPolicies(ArrayList<InsurancePolicy> policies, Predicate<InsurancePolicy> criteria){
        
        return policies.stream()
                .filter(criteria)
                .collect(Collectors.toCollection(ArrayList::new));
        
    }
    
}

class compareCarPrices implements Comparator<InsurancePolicy> {
        
    @Override                                      
    public int compare(InsurancePolicy pol1, InsurancePolicy pol2){
            
        return (int)(pol1.getCar().getPrice() - pol2.getCar().getPrice());
            
    }
        
}
