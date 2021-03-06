/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application;

import java.awt.Color;
import pkg304application.database.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jko
 */
public class MainForm extends javax.swing.JFrame {

    public static String userName = "";
    public static int userID = 0;
    DatabaseConnection dbc = new DatabaseConnection();
    Statement stmt = null;
    ResultSet rs = null;
    
    public MainForm() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logInTitle = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        signUpButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        noAccountLabel = new javax.swing.JLabel();
        backgroundImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(358, 369));
        setResizable(false);
        setSize(new java.awt.Dimension(358, 369));
        getContentPane().setLayout(null);

        logInTitle.setFont(new java.awt.Font("Nanum Brush Script", 0, 36)); // NOI18N
        logInTitle.setForeground(new java.awt.Color(255, 255, 255));
        logInTitle.setText("Log In:");
        getContentPane().add(logInTitle);
        logInTitle.setBounds(200, 50, 110, 20);

        userNameLabel.setFont(new java.awt.Font("Nanum Brush Script", 0, 20)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        userNameLabel.setText("Username:");
        getContentPane().add(userNameLabel);
        userNameLabel.setBounds(80, 80, 100, 16);

        passwordLabel.setFont(new java.awt.Font("Nanum Brush Script", 0, 20)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password:");
        getContentPane().add(passwordLabel);
        passwordLabel.setBounds(80, 150, 90, 24);

        userNameTextField.setFont(new java.awt.Font("Nanum Brush Script", 0, 20)); // NOI18N
        userNameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        getContentPane().add(userNameTextField);
        userNameTextField.setBounds(80, 110, 200, 28);

        passwordTextField.setFont(new java.awt.Font("Nanum Brush Script", 0, 10)); // NOI18N
        passwordTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        getContentPane().add(passwordTextField);
        passwordTextField.setBounds(80, 180, 200, 30);

        signUpButton.setFont(new java.awt.Font("Nanum Brush Script", 0, 20)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setText("[  Sign up!  ]");
        signUpButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        signUpButton.setBorderPainted(false);
        signUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signUpButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signUpButtonMouseEntered(evt);
            }
        });
        getContentPane().add(signUpButton);
        signUpButton.setBounds(180, 270, 100, 28);

        loginButton.setFont(new java.awt.Font("Nanum Brush Script", 0, 20)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("[         Enter!           ]");
        loginButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        loginButton.setBorderPainted(false);
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(80, 230, 200, 30);

        noAccountLabel.setFont(new java.awt.Font("Nanum Brush Script", 0, 20)); // NOI18N
        noAccountLabel.setForeground(new java.awt.Color(255, 255, 255));
        noAccountLabel.setText("No Account?");
        getContentPane().add(noAccountLabel);
        noAccountLabel.setBounds(80, 270, 81, 24);

        backgroundImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staticImg/bgtest.jpg"))); // NOI18N
        backgroundImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        getContentPane().add(backgroundImg);
        backgroundImg.setBounds(0, 0, 370, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signUpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpButtonMouseClicked
        new SignUpForm().setVisible(true);
    }//GEN-LAST:event_signUpButtonMouseClicked

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        // TODO add your handling code here:
        if (validateAccount()){
            
            try {
                Boolean isPlayer = false;
                Boolean isAdmin = false;
                
                String queryStr = "Select playerID from Player P where P.playerID='" + userID + "'";
                stmt = dbc.getMyConnection().createStatement(); 
                rs = stmt.executeQuery(queryStr);
                if (rs.next()){
                    isPlayer = true;
                }
                String adminStr = "Select AdminID from Admin where AdminID ="+userID+"";
                stmt = dbc.getMyConnection().createStatement();
                rs = stmt.executeQuery(adminStr);
                if(rs.next()){
                    isAdmin = true;
                }
                if (isPlayer) {
                    new ProfileForm().setVisible(true);
                    this.setVisible(false);
                    this.dispose();
                }
                else if(isAdmin){
                  new AdminForm().setVisible(true);
                  this.setVisible(false);
                  this.dispose();
                }
                else {
                    new DeveloperForm().setVisible(true);
                    this.setVisible(false);
                    this.dispose();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_loginButtonMouseClicked

    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseEntered
        this.loginButton.setForeground(Color.yellow);
    }//GEN-LAST:event_loginButtonMouseEntered

    private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseExited
        this.loginButton.setForeground(Color.white);
    }//GEN-LAST:event_loginButtonMouseExited

    private void signUpButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpButtonMouseEntered
        this.signUpButton.setForeground(Color.yellow);
    }//GEN-LAST:event_signUpButtonMouseEntered

    private void signUpButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpButtonMouseExited
        this.signUpButton.setForeground(Color.white);
    }//GEN-LAST:event_signUpButtonMouseExited
                    
    /**
     * @param args the command line arguments
     */
    public static void main() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundImg;
    private javax.swing.JLabel logInTitle;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel noAccountLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables

    private boolean validateAccount() {
        String u = userNameTextField.getText();
        String p = passwordTextField.getText();                       
        try {
            Statement stmt = dbc.getMyConnection().createStatement();         
            String queryStr = "Select * from Account a where a.userName='" + u + "' and a.password='"
                    + p +"'";
            rs = stmt.executeQuery(queryStr);            
            if(rs.next()){
                queryStr = "Select A.userID from Account A where A.userName='" + u + "'";
                rs = stmt.executeQuery(queryStr);
                rs.next();
                userID = rs.getInt("userID");
                userName = u;
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Please check your username or password!", "Invalid Information", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
             Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return false;
    }
}
