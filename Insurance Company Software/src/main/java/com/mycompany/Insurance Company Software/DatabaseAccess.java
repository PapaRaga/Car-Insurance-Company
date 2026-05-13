/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3;

/**
 *
 * @author User
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import database;
public class DatabaseAccess {
  
    public static void testingTheConnection(InsuranceCompany ic) {
        
        Connection myCon = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "170578");
            
            if(myCon != null){
                
                   System.out.println("Successfully connected.");
			}else{
			   System.out.println("Failed to connect.");
                
                
            }
            
        }catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String query = "create table IF NOT EXISTS INSURANCE_COMPANY("
			+ "COMPANY_NAME VARCHAR(250) NOT NULL, "
			+ "ADMIN_USERNAME VARCHAR(250) NOT NULL, "
			+ "ADMIN_PASSWORD VARCHAR(250) NOT NULL, "
                        + "FLATRATE INT NOT NULL,"
			+ "PRIMARY KEY (COMPANY_NAME) )";
        
        String query1 = "create table IF NOT EXISTS USER_TABLE("
			+ "USER_NAME VARCHAR(250) NOT NULL, "
			+ "USER_ID INT NOT NULL, "
			+ "STREET_NUMBER INT NOT NULL, "
                        + "STREET_NAME VARCHAR(250) NOT NULL, "
                        + "SUBURB VARCHAR(250) NOT NULL, "
                        + "CITY VARCHAR(250) NOT NULL, "
                        + "USER_PASSWORD INT NOT NULL,"
			+ "PRIMARY KEY (USER_ID) )";
        
//        String query2 = "create table IF NOT EXISTS POLICIES("
//			+ "POLICYHOLDERNAME VARCHAR(250) NOT NULL, "
//			+ "POLICY_ID INT NOT NULL, "
//			+ "CAR VARCHAR(250) NOT NULL, "
//                        + "NUMBEROFCLAIMS INT NOT NULL,"
//                        + "MYDATE DATE NOT NULL,"
//			+ "PRIMARY KEY (POLICY_ID) )";
        
//        String insertAdminInformation = "INSERT INTO INSURANCE_COMPANY (COMPANY_NAME, ADMIN_USERNAME, ADMIN_PASSWORD, FLATRATE)"
//                + "VALUES ('" + ic.getName() + "', '"
//                + ic.getAdminUsername() + "', '"
//                + ic.getAdminPassword() + "', '"
//                + ic.getFlatRate() + "')";

        
        String insertUserInformation = "INSERT INTO USER_TABLE (USER_NAME, USER_ID, STREET_NUMBER, STREET_NAME, SUBURB, CITY, USER_PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = myCon.prepareStatement(insertUserInformation)){
            
            for(User users: ic.getUsers().values()){
                
                ps.setString(1, users.getName());
                ps.setInt(2, users.getUserID());
                ps.setInt(3, users.getAddress().getStreetNum());
                ps.setString(4, users.getAddress().getStreet());
                ps.setString(5, users.getAddress().getSuburb());
                ps.setString(6, users.getAddress().getCity());
                ps.setString(7, users.getPassword());
                
//                ps.executeUpdate();

//                ps.addBatch();
                
            }
            
//            ps.executeBatch();
             
        }catch(SQLException e){
            
            System.out.print(e);
            
        }
        
//        String insertUserInformation = "INSERT INTO USER_TABLE (NAME, USER_ID, STREET_NUMBER, STREET, SUBURB, CITY, PASSWORD) VALUES";
//        for(User users: ic.getUsers().values()){
//            
//                insertUserInformation += "('" + users.getName() + "', "
//                + users.getUserID() + ", '"
//                + users.getAddress().getStreetNum() + "', '"
//                + users.getAddress().getStreet() + "', '"
//                + users.getAddress().getSuburb() + "', '"
//                + users.getAddress().getCity() + "', '"
//                + users.getPassword() + "'),";
//            
//        }
//        
//        insertUserInformation = insertUserInformation.substring(0, insertUserInformation.length() - 1);
//        
//        System.out.println("Query: " + insertUserInformation);
 
		try{			
			//get connection
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "170578");
 
			//create statement
			statement = myCon.createStatement();
 
			//execute query
			statement.execute(query);
                        statement.execute(query1);
//                        statement.execute(insertAdminInformation);
                        statement.execute(insertUserInformation);
                        
//                        resultSet = statement.executeQuery("SELECT * FROM insurance_company");
//                        
//                        System.out.println("NAME\tADMINNAME\tADMINPASSWORD\tFLATRATE");
//                        System.out.println("==\t====\t====\t==========");
//                        
//                        while(resultSet.next()) {
//                            
//                            System.out.println(resultSet.getString(1) + "\t" +
//                                    
//                                    resultSet.getString(2) + "\t" +
//                                    resultSet.getString(3) + "\t" +
//                                    resultSet.getInt(4));
//                            
//                        }
 
			//close connection
			statement.close();
			myCon.close();
 
			System.out.println("Table created successfully.");
		}catch(Exception e){
			e.printStackTrace();
		}




        
    }

    
    
}
