/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.assignment3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AdminLogin extends javax.swing.JFrame {
    
    InsuranceCompany firstInsuranceCompany = new InsuranceCompany();

    /**
     * Creates new form AdminUI
     */
    public AdminLogin() throws PolicyException, IOException, PolicyHolderNameException{
        
        test();
        initComponents();
    }
    
    public void test() throws PolicyException, IOException, PolicyHolderNameException{
        
        firstInsuranceCompany = new InsuranceCompany("GuardianShield Insurance", "Bruno", "12345", 500);
        
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
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AdminPassword = new javax.swing.JPasswordField();
        AdminText = new javax.swing.JTextField();
        userIDCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        AccessUsersButton = new javax.swing.JButton();
        valAdm = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        LoadFileAdmin = new javax.swing.JMenuItem();
        SaveFileAdmin = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Admin Username:");

        jLabel2.setText("Admin Password:");

        userIDCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        userIDCombo.setEnabled(false);

        jLabel3.setText("Choose one of the users");

        AccessUsersButton.setText("Access the User");
        AccessUsersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccessUsersButtonActionPerformed(evt);
            }
        });

        valAdm.setText("Validate Admin");
        valAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valAdmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AdminText)
                            .addComponent(AdminPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(57, 57, 57)
                        .addComponent(userIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AccessUsersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(AdminText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(AdminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(valAdm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AccessUsersButton)
                .addGap(39, 39, 39))
        );

        jMenu7.setText("File");

        LoadFileAdmin.setText("Load");
        LoadFileAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFileAdminActionPerformed(evt);
            }
        });
        jMenu7.add(LoadFileAdmin);

        SaveFileAdmin.setText("Save");
        SaveFileAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFileAdminActionPerformed(evt);
            }
        });
        jMenu7.add(SaveFileAdmin);

        jMenuBar3.add(jMenu7);
        jMenuBar3.add(jMenu8);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccessUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccessUsersButtonActionPerformed
        // TODO add your handling code here:
        String selectedUser = (String) userIDCombo.getSelectedItem();
        
        if(selectedUser != null){
            
            int userID = Integer.parseInt(selectedUser);
            User user = firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), userID);
            
            if(user != null){
                    
                    ArrayList<String> cities = firstInsuranceCompany.populateDistinctCityNames(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
            
            
//                    User user = firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), user.getUserID());
                    UserUIFromAdmin userUI = new UserUIFromAdmin(user, this, cities, firstInsuranceCompany);
                    userUI.setVisible(true);
                    this.setVisible(false);
                    
                }else{
                    
                    JOptionPane.showMessageDialog(this, "User not found!");
                    
                }
            
        }else{
            
            JOptionPane.showMessageDialog(this, "Please select a user!");
            
        }
        
    }//GEN-LAST:event_AccessUsersButtonActionPerformed

    private void valAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valAdmActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_valAdmActionPerformed

    private void SaveFileAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFileAdminActionPerformed
        // TODO add your handling code here:
        try{
            
            firstInsuranceCompany.save3();
            
        }catch(IOException ex){
           
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "");
            
        }
    }//GEN-LAST:event_SaveFileAdminActionPerformed

    private void LoadFileAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadFileAdminActionPerformed
        // TODO add your handling code here:
        try{
            
            firstInsuranceCompany = InsuranceCompany.load3();
            
        }catch(IOException ex){
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "");
            
        }catch(ClassNotFoundException e){
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "");
            
        }
    }//GEN-LAST:event_LoadFileAdminActionPerformed

    
    public void login(){
        
        boolean admin = firstInsuranceCompany.validateAdmin(AdminText.getText(), AdminPassword.getText());
        
        if(admin){
            
            JOptionPane.showMessageDialog(this, "Login successful!");
            this.userIDCombo.setEnabled(true);
            userIDCombo.removeAllItems();
            
            ArrayList<Integer> userID = firstInsuranceCompany.populateUserIDs(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
            
            if(userID != null){
                
                ArrayList<String> userIDsCoverted = new ArrayList<>();
                
                for(Integer ids: userID){
                    
                    userIDsCoverted.add(String.valueOf(ids));
                    
                    
                }
                
                userIDCombo.setModel(new DefaultComboBoxModel<>(userIDsCoverted.toArray(new String[0])));
                
                
            }
           
//            if(userID != null && userID.isEmpty()){
//                
//                int firstID = userID.get(0);
//                User user = firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), firstID);
//                
//                if(user != null){
//                    
//                    ArrayList<String> cities = firstInsuranceCompany.populateDistinctCityNames(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//            
//            
////                    User user = firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), user.getUserID());
//                    UserUIFromAdmin userUI = new UserUIFromAdmin(user, this, cities);
//                    userUI.setVisible(true);
//                    this.setVisible(false);
//                    
//                }else{
//                    
//                    JOptionPane.showMessageDialog(this, "User not found!");
//                    
//                }
//            }
            
//            ArrayList<String> cities = firstInsuranceCompany.populateDistinctCityNames(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//            
//            
////            User user = firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), user.getUserID());
//            UserUIFromAdmin userUI = new UserUIFromAdmin(user, this, cities);
//            userUI.setVisible(true);
//            this.setVisible(false);
            
        }else{
            
            JOptionPane.showMessageDialog(this, "Username or Password is incorrect!");
         
        }
            
    }
        
    
//    @Override
//    public void show(){
//        
//        ArrayList<Integer> userID = firstInsuranceCompany.populateUserIDs(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//            
//            if(userID != null){
//                
//                ArrayList<String> userIDsCoverted = new ArrayList<>();
//                
//                for(Integer ids: userID){
//                    
//                    userIDsCoverted.add(String.valueOf(ids));
//                    
//                    
//                }
//                
//                userIDCombo.setModel(new DefaultComboBoxModel<>(userIDsCoverted.toArray(new String[0])));
//                
//                
//            }
//           
//            if(userID != null && userID.isEmpty()){
//                
//                int firstID = userID.get(0);
//                User user = firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), firstID);
//                
//                if(user != null){
//                    
//                    ArrayList<String> cities = firstInsuranceCompany.populateDistinctCityNames(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
//            
//            
//        //            User user = firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), user.getUserID());
//                    UserUIFromAdmin userUI = new UserUIFromAdmin(user, this, cities);
//                    userUI.setVisible(true);
//                    this.setVisible(false);
//                    
//                }else{
//                    
//                    JOptionPane.showMessageDialog(this, "User not found!");
//                    
//                }
//            
//            
////            ArrayList<String> cities = firstInsuranceCompany.populateDistinctCityNames(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
////            
////            
//////            User user = firstInsuranceCompany.findUser(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword(), user.getUserID());
////            UserUIFromAdmin userUI = new UserUIFromAdmin(user, this, cities);
////            userUI.setVisible(true);
////            this.setVisible(false);
//            
//        }else{
//            
//            JOptionPane.showMessageDialog(this, "Username or Password is incorrect!");
//            
//        }
//   
//    }
    
    /**
     * @param args the command line arguments
     */
    public static void main_Adminlogin() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new AdminLogin().setVisible(true);
                } catch (PolicyException ex) {
                    Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PolicyHolderNameException ex) {
                    Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccessUsersButton;
    private javax.swing.JPasswordField AdminPassword;
    private javax.swing.JTextField AdminText;
    private javax.swing.JMenuItem LoadFileAdmin;
    private javax.swing.JMenuItem SaveFileAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> userIDCombo;
    private javax.swing.JButton valAdm;
    // End of variables declaration//GEN-END:variables
}
