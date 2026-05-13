/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.assignment3;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Login extends javax.swing.JFrame {

    InsuranceCompany firstInsuranceCompany = new InsuranceCompany();
    
    /**
     * Creates new form Login
     * @param firstInsuranceCompany
     * @throws com.mycompany.week7.PolicyException
     * @throws java.io.IOException
     * @throws com.mycompany.week7.PolicyHolderNameException
     */
    public Login() throws PolicyException, IOException, PolicyHolderNameException{
        
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UserText = new javax.swing.JTextField();
        UserPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        UserText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserTextActionPerformed(evt);
            }
        });

        UserPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserPasswordActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UserPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(UserText))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(UserText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(UserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Load");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("List of Users");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserTextActionPerformed

    private void UserPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserPasswordActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_UserPasswordActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        
        String output = "";
        for(User user: firstInsuranceCompany.getUsers().values()){
            
            output += "Username: " + user.getName() + " Password: " + user.getPassword() + "\n";
            
        }
        
        JOptionPane.showMessageDialog(this, output);
        
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        try{
            
            firstInsuranceCompany = InsuranceCompany.load2();
            
        }catch(IOException ex){
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "");
            
        }catch(ClassNotFoundException e){
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "");
            
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        try{
            
            firstInsuranceCompany.save2();
            
        }catch(IOException ex){
           
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "");
            
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void login(){
        
        User user = firstInsuranceCompany.findingTheUserToValidate(UserText.getText(), UserPassword.getText());
        UserPassword.setText("");
        
        if(user != null){
            
            ArrayList<String> cities = firstInsuranceCompany.populateDistinctCityNames(firstInsuranceCompany.getAdminUsername(), firstInsuranceCompany.getAdminPassword());
            UserUI userUI = new UserUI(user, this, cities);
            userUI.setVisible(true);
            this.setVisible(false);
            
        }else{
            
            JOptionPane.showMessageDialog(this, "Username or Password is incorrect!");
            
        }
            
    }
    
    /**
     * @param args the command line arguments
     * @throws com.mycompany.week7.PolicyException
     * @throws java.io.IOException
     * @throws com.mycompany.week7.PolicyHolderNameException
     */
    public static void main_login() throws PolicyException, IOException, PolicyHolderNameException{
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (PolicyException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PolicyHolderNameException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField UserPassword;
    private javax.swing.JTextField UserText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
