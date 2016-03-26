/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application;
import pkg304application.database.*;
import java.sql.*;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
/**
 *
 * @author jinyou
 */
public class AdminForm extends javax.swing.JFrame {


    /**
     * Creates new form AdminForm
     */
    Statement stmt = null;
    Statement stmt2 = null;
    ResultSet rs = null;
    public AdminForm() {
  try {
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            stmt = dbc.getMyConnection().createStatement();
            stmt2 = dbc.getMyConnection().createStatement();
            initComponents();
            showUserList();
            showGameList();
            showGroupList();
            showReviewList();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deleteButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        Tabs = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        gameList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        groupList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        reviewList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deleteButton.setText("Delete");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });

        userList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        userList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userList);

        Tabs.addTab("Users", jScrollPane1);

        gameList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        gameList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(gameList);

        Tabs.addTab("Games", jScrollPane2);

        groupList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        groupList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(groupList);

        Tabs.addTab("Groups", jScrollPane3);

        reviewList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        reviewList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reviewListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(reviewList);

        Tabs.addTab("Reviews", jScrollPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(logoutButton)
                        .addGap(18, 18, 18)
                        .addComponent(refreshButton)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutButton)
                            .addComponent(refreshButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        // TODO add your handling code here:
        String selected;
        try{
            // AT the game tab
            if (Tabs.getSelectedIndex()==0){
                selected = userList.getSelectedValue();
                String selectStr = "delete from Account where userName = '" + selected + "'";
                stmt.executeUpdate(selectStr);
            }
            if (Tabs.getSelectedIndex()==1){
                selected = gameList.getSelectedValue();
                String deleteStr = "delete from Game where gName = '"+ selected +"'";                              
                stmt.executeUpdate(deleteStr);
            } 
            
            if (Tabs.getSelectedIndex()==2){
                selected = groupList.getSelectedValue();
                String delete = "delete from FriendGroup where groupName = '"+selected+"'";
                stmt.executeUpdate(delete);
            }
            if (Tabs.getSelectedIndex()==3){
                selected = reviewList.getSelectedValue();
                String delete = "delete from Review where reviewID = '"+selected+"'";
                stmt.executeUpdate(delete);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        // TODO add your handling code here:
        new MainForm().setVisible(true);
        MainForm.userName="";
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new AdminForm().setVisible(true);
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void userListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userListMouseClicked
        // TODO add your handling code here:
       
            // TODO add your handling code here:
            String selected = userList.getSelectedValue();
            String queryStr = "Select * from Account where userName='" + selected + "'";         
                    try {
                        rs = stmt.executeQuery(queryStr);
                        System.out.println(queryStr);
                        if (rs.next()){
                            String check = "select * from Developer where developerID=" + rs.getInt("userID");
                            ResultSet rs2 = stmt2.executeQuery(check);
                            if (rs2.next()){
                                new SearchUserForm(rs.getInt("userID"), true).setVisible(true);
                            } else {
                                new SearchUserForm(rs.getInt("userID"), false).setVisible(true);
                            }
                        } else {
                            System.out.println("no user exists");
                        }
                    } 
         catch (SQLException ex) {
            Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userListMouseClicked

    private void gameListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameListMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String selectedGame = gameList.getSelectedValue();
            if (selectedGame == null){
                return;
            }
            String queryStr = "Select * from Game where gName='" + selectedGame + "'";
            rs = stmt.executeQuery(queryStr);
            rs.next();
            new GameInfoForm(rs.getString("gName"), rs.getString("gDescription"), rs.getInt("creatorID"), rs.getInt("currentPrice")).setVisible(true);
            System.out.println("Showing game info of " + rs.getString("gName"));
        } catch (SQLException ex) {
            Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gameListMouseClicked

    private void groupListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupListMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String selectedGroup = groupList.getSelectedValue();
            String queryStr = "Select * from FriendGroup F where F.groupName='" + selectedGroup + "'";
            rs = stmt.executeQuery(queryStr);
            rs.next();
            new GroupInfoForm(rs.getString("groupName"), rs.getString("groupDesc"), rs.getInt("creatorUserID"), rs.getString("dateCreated")).setVisible(true);
            System.out.println("Showing group info of " + rs.getString("groupName"));
        } catch (SQLException ex) {
            Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_groupListMouseClicked

    private void reviewListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reviewListMouseClicked
        try {            
            String selectedReview = reviewList.getSelectedValue();
            String reviewID = " ";

            int i = selectedReview.length() - 1;
            System.out.println("i is : "+ i );
            System.out.println("substring is " + selectedReview.substring(i));
            while (i > 0 && selectedReview.charAt(i) != ' '){
                reviewID = selectedReview.substring(i);
                i --;
            }
            
            String query = "select * from Review where reviewID = " + Integer.parseInt(reviewID);
            rs = stmt.executeQuery(query);
            rs.next();
            new SearchReviewForm(rs.getInt("reviewerID"), rs.getInt("gameReviewedID")).setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_reviewListMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JButton deleteButton;
    private javax.swing.JList<String> gameList;
    private javax.swing.JList<String> groupList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JList<String> reviewList;
    private javax.swing.JList<String> userList;
    // End of variables declaration//GEN-END:variables
    private void showUserList() {
        try {
            String queryString = "Select userName from Account, Admin where adminID != userID";
            rs = stmt.executeQuery(queryString);
            DefaultListModel userListModel = new DefaultListModel();
            while(rs.next()){
                userListModel.addElement(rs.getString("userName"));
            }
            userList.setModel(userListModel);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showGameList() {
        
         try {
            String queryStr = "Select DISTINCT gName from Game ";
            rs = stmt.executeQuery(queryStr);
            DefaultListModel gameListModel = new DefaultListModel();
            while (rs.next()){
                gameListModel.addElement(rs.getString("gName"));
            }
            gameList.setModel(gameListModel);
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showGroupList() {
        try {
            String queryStrGroup = "Select DISTINCT groupName from FriendGroup";
            rs = stmt.executeQuery(queryStrGroup);
            DefaultListModel groupListModel = new DefaultListModel();
            while (rs.next()){
                groupListModel.addElement(rs.getString("groupName"));
            }
            groupList.setModel(groupListModel);
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showReviewList() {
        try {
            String query = "select R.reviewID, A.userName, G.gName from Account A, Review R, Game G where A.userID=R.reviewerID and G.gameID=gameReviewedID";
            rs = stmt.executeQuery(query);
            DefaultListModel reviewListModel = new DefaultListModel();
            while (rs.next()){
                reviewListModel.addElement("Player: " + rs.getString("userName") + " || Review of: " + rs.getString("gName") + " || Review ID: " + 
                            Integer.toString(rs.getInt("reviewID")));
            }
            reviewList.setModel(reviewListModel);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}