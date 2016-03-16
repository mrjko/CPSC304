/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application;
import pkg304application.database.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author jko
 */
public class DeveloperForm extends javax.swing.JFrame {
    
    
    public Boolean editing = false;
    Statement stmt = null;
    ResultSet rs = null;
    public static int searchUserID;
    String queryString;
    
    /**
     * Creates new form ProfileForm
     */
    public DeveloperForm() {
            initComponents();
            showProfileInfo();
            showFriendList();
            showGameList();
            showGroupList();
            showReviewList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextField = new javax.swing.JTextArea();
        logoutButton = new javax.swing.JButton();
        ProfileName = new javax.swing.JLabel();
        Friends = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        friendList = new javax.swing.JList<>();
        GroupAndGames = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        groupList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        gameList = new javax.swing.JList<>();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        createGameButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        editButton.setText("Edit");
        editButton.setAutoscrolls(true);
        editButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 100, 30));

        descriptionTextField.setColumns(20);
        descriptionTextField.setRows(5);
        jScrollPane1.setViewportView(descriptionTextField);
        descriptionTextField.setEditable(false);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 550, 200));

        logoutButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        logoutButton.setText("Log out");
        logoutButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 120, 50));

        ProfileName.setFont(new java.awt.Font("PT Serif Caption", 1, 24)); // NOI18N
        ProfileName.setText("Profile Name:");
        getContentPane().add(ProfileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        Friends.setFont(new java.awt.Font("PT Serif Caption", 1, 24)); // NOI18N
        Friends.setText("Friends:");
        getContentPane().add(Friends, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, -1, -1));

        friendList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        friendList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                friendListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(friendList);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 120, 200));

        GroupAndGames.setFont(new java.awt.Font("PT Sans Caption", 1, 14)); // NOI18N

        groupList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        groupList.setFont(new java.awt.Font("PT Serif Caption", 1, 14)); // NOI18N
        groupList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(groupList);

        GroupAndGames.addTab("Groups", jScrollPane2);

        gameList.setFont(new java.awt.Font("PT Serif Caption", 1, 14)); // NOI18N
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
        jScrollPane4.setViewportView(gameList);

        GroupAndGames.addTab("Games", jScrollPane4);

        getContentPane().add(GroupAndGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 770, 220));

        searchField.setFont(new java.awt.Font("PT Serif Caption", 0, 14)); // NOI18N
        searchField.setText("   find a user");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 400, 50));

        searchButton.setFont(new java.awt.Font("PT Serif Caption", 0, 14)); // NOI18N
        searchButton.setText("Search");
        searchButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 140, 50));

        createGameButton.setText("Create Game");
        createGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createGameButtonMouseClicked(evt);
            }
        });
        getContentPane().add(createGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 680, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        if (editing.equals(false)){
          this.descriptionTextField.setEditable(true);
          this.editButton.setText("Save changes");
          editing = true;
        } else {

          if (this.descriptionTextField.getText().length() > 100){
              System.out.println("Description can only be under 100 characters!");
              this.descriptionTextField.setText(" ");
            } else {
              String updateStr = "update Account a set a.description = '" + this.descriptionTextField.getText() + 
                      "' where a.username = '" + MainForm.userName.toString() + "'";
              try {
                  System.out.println(updateStr);
                  stmt.executeUpdate(updateStr);
              } catch (SQLException ex) {
                  Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
              }
              System.out.println("Successfully stored the description");
           }
        
          this.descriptionTextField.setEditable(false);
          this.editButton.setText("Edit");
          editing = false;
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        // TODO add your handling code here:
        new MainForm().setVisible(true);
        MainForm.userName="";
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        // TODO add your handling code here:
        String name = searchField.getText();
        System.out.println(name);
        queryString = "Select A.userID from Account A where A.userName='" + name + "'";
        try {
            rs = stmt.executeQuery(queryString);
            if (rs.next()){
                searchUserID = rs.getInt("userID");
                System.out.println("finished");
                new SearchUserForm().setVisible(true);
            } else {
                System.out.println("no user exists");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return;
    }//GEN-LAST:event_searchButtonMouseClicked

    private void friendListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_friendListMouseClicked

    private void createGameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createGameButtonMouseClicked
        // TODO add your handling code here:
        new NewGameForm().setVisible(true);
    }//GEN-LAST:event_createGameButtonMouseClicked

    private void gameListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameListMouseClicked
        try {
            // TODO add your handling code here:
            String selectedGame = gameList.getSelectedValue();
            String queryStr = "Select * from Game where gName='" + selectedGame + "'";
            rs = stmt.executeQuery(queryStr);
            rs.next();
            new GameInfoForm(rs.getString("gName"), rs.getString("gDescription"), rs.getInt("creatorID"), rs.getInt("currentPrice")).setVisible(true);
            System.out.println("Showing game info of " + rs.getString("gName"));
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gameListMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main() {
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
            java.util.logging.Logger.getLogger(DeveloperForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeveloperForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeveloperForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeveloperForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeveloperForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Friends;
    private javax.swing.JTabbedPane GroupAndGames;
    private javax.swing.JLabel ProfileName;
    private javax.swing.JButton createGameButton;
    private javax.swing.JTextArea descriptionTextField;
    public static javax.swing.JButton editButton;
    private javax.swing.JList<String> friendList;
    private javax.swing.JList<String> gameList;
    private javax.swing.JList<String> groupList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables

    private void showProfileInfo() {
        try {
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            this.setResizable(false); 
            this.ProfileName.setText(MainForm.userName);
            queryString = "select a.description from Account a where a.username = '" +
                    MainForm.userName.toString() + "'";
            System.out.println(queryString);
            stmt= dbc.getMyConnection().createStatement(); 
            rs = stmt.executeQuery(queryString);
            rs.next();
            this.descriptionTextField.setText(rs.getString("description"));
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showFriendList() {
        try {
            String queryString = "Select DISTINCT A.userName from Account A, FriendsWith F where F.userID1=" + MainForm.userID +
                    " and F.userID2=A.userID";
            rs = stmt.executeQuery(queryString);
            DefaultListModel friendListModel = new DefaultListModel();
            while(rs.next()){
                friendListModel.addElement(rs.getString("userName"));
            }
            friendList.setModel(friendListModel);
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    private void showGameList() {
        try {
            String queryStr = "Select * from Game G, Developer D where G.creatorID = D.developerID and D.developerID = " + MainForm.userID;
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
        return;
    }

    private void showReviewList() {
        return;
    }
    
    
}
