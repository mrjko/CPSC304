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
import javax.swing.JOptionPane;

/**
 *
 * @author jko
 */
public class DeveloperForm extends javax.swing.JFrame {
    
    public Boolean editing = false;
    Statement stmt = null;
    Statement stmt2 = null;
    ResultSet rs = null;
    public static int searchUserID;
    String queryString;
    
    /**
     * Creates new form ProfileForm
     */
    public DeveloperForm() {
        try {
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            stmt = dbc.getMyConnection().createStatement();
            stmt2 = dbc.getMyConnection().createStatement();
            initComponents();
            showProfileInfo();
            showFriendList();
            showGameList();
            showGroupList();
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
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

        editButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextField = new javax.swing.JTextArea();
        logoutButton = new javax.swing.JButton();
        ProfileName = new javax.swing.JLabel();
        Friends = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        friendList = new javax.swing.JList<>();
        GroupAndGames = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        gameList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        groupList = new javax.swing.JList<>();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        createGameButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        deleteFriend = new javax.swing.JButton();
        editGameButton = new javax.swing.JButton();
        deleteGameButton = new javax.swing.JButton();
        createGroupButton = new javax.swing.JButton();
        userRadioButton = new javax.swing.JRadioButton();
        groupRadioButton = new javax.swing.JRadioButton();
        gameRadioButton = new javax.swing.JRadioButton();
        backgroundImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(470, 549));
        setSize(new java.awt.Dimension(470, 549));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setAutoscrolls(true);
        editButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 60, 20));

        descriptionTextField.setColumns(20);
        descriptionTextField.setFont(new java.awt.Font("Univers LT 45 Light", 1, 14)); // NOI18N
        descriptionTextField.setRows(5);
        jScrollPane1.setViewportView(descriptionTextField);
        descriptionTextField.setEditable(false);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 280, 170));

        logoutButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 24)); // NOI18N
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staticImg/logoutIcon.png"))); // NOI18N
        logoutButton.setBorder(null);
        logoutButton.setBorderPainted(false);
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 40, 40));

        ProfileName.setFont(new java.awt.Font("Univers LT 45 Light", 0, 18)); // NOI18N
        ProfileName.setForeground(new java.awt.Color(255, 255, 255));
        ProfileName.setText("Profile Name:");
        getContentPane().add(ProfileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        Friends.setFont(new java.awt.Font("Univers LT 45 Light", 0, 18)); // NOI18N
        Friends.setForeground(new java.awt.Color(255, 255, 255));
        Friends.setText("Friends:");
        getContentPane().add(Friends, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        friendList.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 110, 170));

        GroupAndGames.setFont(new java.awt.Font("Univers LT 45 Light", 1, 12)); // NOI18N

        gameList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gameList.setFont(new java.awt.Font("Univers LT 45 Light", 1, 12)); // NOI18N
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

        GroupAndGames.addTab("Developed Games", jScrollPane4);

        groupList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        groupList.setFont(new java.awt.Font("Univers LT 45 Light", 1, 12)); // NOI18N
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
        jScrollPane2.setViewportView(groupList);

        GroupAndGames.addTab("Groups", jScrollPane2);

        getContentPane().add(GroupAndGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 320, 150));

        searchField.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        searchField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 20));

        searchButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 24)); // NOI18N
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staticImg/searchIcon.png"))); // NOI18N
        searchButton.setBorder(null);
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 40, 40));

        createGameButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        createGameButton.setForeground(new java.awt.Color(255, 255, 255));
        createGameButton.setText("Create Game");
        createGameButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        createGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createGameButtonMouseClicked(evt);
            }
        });
        getContentPane().add(createGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 90, 30));

        refreshButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 24)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staticImg/refreshIcon.png"))); // NOI18N
        refreshButton.setBorder(null);
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });
        getContentPane().add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 40, 40));

        deleteFriend.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        deleteFriend.setForeground(new java.awt.Color(255, 255, 255));
        deleteFriend.setText("Delete");
        deleteFriend.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        deleteFriend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteFriendMouseClicked(evt);
            }
        });
        deleteFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFriendActionPerformed(evt);
            }
        });
        getContentPane().add(deleteFriend, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 60, 20));

        editGameButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        editGameButton.setForeground(new java.awt.Color(255, 255, 255));
        editGameButton.setText("Edit Game");
        editGameButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        editGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editGameButtonMouseClicked(evt);
            }
        });
        getContentPane().add(editGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 90, 30));

        deleteGameButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        deleteGameButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteGameButton.setText("Delete Game");
        deleteGameButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        deleteGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteGameButtonMouseClicked(evt);
            }
        });
        getContentPane().add(deleteGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, 90, 30));

        createGroupButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        createGroupButton.setForeground(new java.awt.Color(255, 255, 255));
        createGroupButton.setText("Create Group");
        createGroupButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        createGroupButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createGroupButtonMouseClicked(evt);
            }
        });
        getContentPane().add(createGroupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 90, 30));

        userRadioButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        userRadioButton.setText("users");
        getContentPane().add(userRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        groupRadioButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        groupRadioButton.setText("groups");
        getContentPane().add(groupRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        gameRadioButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        gameRadioButton.setText("games");
        getContentPane().add(gameRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        backgroundImg.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        backgroundImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staticImg/bgtest.jpg"))); // NOI18N
        backgroundImg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        backgroundImg.setPreferredSize(new java.awt.Dimension(920, 750));
        getContentPane().add(backgroundImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 70, 510, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        if (editing.equals(false)){
          this.descriptionTextField.setEditable(true);
          this.editButton.setText("Save changes");
          editing = true;
        } else {
              String updateStr = "update Account a set a.description = '" + this.descriptionTextField.getText() + 
                      "' where a.username = '" + MainForm.userName.toString() + "'";
              try {
                  stmt.executeUpdate(updateStr);
              } catch (SQLException ex) {
                Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Please limit your description to below 400 characters!", "Not short and sweet!", JOptionPane.INFORMATION_MESSAGE);
        }
          this.descriptionTextField.setEditable(false);
          this.editButton.setText("Edit");
          editing = false;
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void friendListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendListMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2){
            String selectedUser = friendList.getSelectedValue();
            String queryString = "Select A.userID from Account A where A.userName='" + selectedUser + "'";
                try {
                    rs = stmt.executeQuery(queryString);
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
                } catch (SQLException ex) {
                    Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
                }
        }            
    }//GEN-LAST:event_friendListMouseClicked

    private void createGameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createGameButtonMouseClicked
        // TODO add your handling code here:
        new NewGameForm().setVisible(true);
    }//GEN-LAST:event_createGameButtonMouseClicked

    private void gameListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameListMouseClicked
        try {
            if (evt.getClickCount()== 2){
                String selectedGame = gameList.getSelectedValue();
                if (selectedGame == null){
                    return;
                }
                String queryStr = "Select * from Game where gName='" + selectedGame + "'";
                rs = stmt.executeQuery(queryStr);
                rs.next();
                new GameInfoForm(rs.getString("gName"), rs.getString("gDescription"), rs.getInt("creatorID"), rs.getInt("currentPrice")).setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gameListMouseClicked

    private void deleteFriendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteFriendMouseClicked
        // TODO add your handling code here:
        String insertStr;
        String selected = friendList.getSelectedValue();
        try{
            if (selected == null){
                JOptionPane.showMessageDialog(null, "Please select a friend you'd like to delete!", "No selection!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Deleting selected friend:", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION){
            String selectStr = "select * from Account A where A.userName = '" + selected + "'";
            rs = stmt.executeQuery(selectStr);
            rs.next();
            int Uid  = rs.getInt("userID");
            int currID = MainForm.userID;
            insertStr = "delete from FriendsWith where userID1 = "+Uid+" and UserID2 = "+currID;                              
            stmt.executeUpdate(insertStr);
            insertStr = "delete from FriendsWith where userID1 = "+currID+" and UserID2 = "+Uid;                              
            stmt.executeUpdate(insertStr);
            refresh();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameInfoForm.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
    }//GEN-LAST:event_deleteFriendMouseClicked

    private void deleteFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFriendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteFriendActionPerformed

    private void editGameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editGameButtonMouseClicked
        // TODO add your handling code here:
        String selected = gameList.getSelectedValue();
        if (selected == null){
            JOptionPane.showMessageDialog(null, "Please select a game you'd like to edit!", "No selection!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        new EditGameForm(selected).setVisible(true);
    }//GEN-LAST:event_editGameButtonMouseClicked

    private void deleteGameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteGameButtonMouseClicked
        // TODO add your handling code here:       
        String insertStr;
        String selected = gameList.getSelectedValue();
        
        try{
            if (selected == null){
                JOptionPane.showMessageDialog(null, "Please select a game you'd like to delete!", "No selection!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Deleting Selected Game:", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION){ 
                String selectStr = "select * from Game G where G.gName = '" + selected + "'";
                rs = stmt.executeQuery(selectStr);
                rs.next();
                int gid  = rs.getInt("gameID");
                int currID = MainForm.userID;
                insertStr = "delete from Game where gameID = "+gid+" and creatorID = "+currID+"";                              
                stmt.executeUpdate(insertStr);
                refresh();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }//GEN-LAST:event_deleteGameButtonMouseClicked

    private void groupListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupListMouseClicked
        // TODO add your handling code here:
        try {
            if (evt.getClickCount()==2){
                String selectedGroup = groupList.getSelectedValue();
                String queryStr = "Select * from FriendGroup F where F.groupName='" + selectedGroup + "'";
                rs = stmt.executeQuery(queryStr);
                rs.next();
                new GroupInfoForm(rs.getString("groupName"), rs.getString("groupDesc"), rs.getInt("creatorUserID"), rs.getString("dateCreated")).setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_groupListMouseClicked
    private void createGroupButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createGroupButtonMouseClicked
        // TODO add your handling code here:
        new CreateGroupForm().setVisible(true);
    }//GEN-LAST:event_createGroupButtonMouseClicked

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        // TODO add your handling code here:
        int reply = JOptionPane.showConfirmDialog(null, "Log out?", "Leaving?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION){
            new MainForm().setVisible(true);
            MainForm.userName="";
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new DeveloperForm().setVisible(true);
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        // TODO add your handling code here:
        Boolean users = userRadioButton.isSelected();
        Boolean groups = groupRadioButton.isSelected();
        Boolean games = gameRadioButton.isSelected();
        String textField = searchField.getText();

        if (! ( users || groups || games )){
            JOptionPane.showMessageDialog(null, "Please select a search criteria! Note: leaving search field blank will return all results!", "Nothing is selected!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (users){
            new UserLibraryForm(textField).setVisible(true);
        }

        if (groups){
            System.out.println("opening groups library");
            new GroupLibraryForm(textField).setVisible(true);
        }
        if (games){
            System.out.println("games group library");
            new GameLibraryForm(textField).setVisible(true);
        }
    }//GEN-LAST:event_searchButtonMouseClicked

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Friends;
    private javax.swing.JTabbedPane GroupAndGames;
    private javax.swing.JLabel ProfileName;
    private javax.swing.JLabel backgroundImg;
    private javax.swing.JButton createGameButton;
    private javax.swing.JButton createGroupButton;
    private javax.swing.JButton deleteFriend;
    private javax.swing.JButton deleteGameButton;
    private javax.swing.JTextArea descriptionTextField;
    public static javax.swing.JButton editButton;
    private javax.swing.JButton editGameButton;
    private javax.swing.JList<String> friendList;
    private javax.swing.JList<String> gameList;
    private javax.swing.JRadioButton gameRadioButton;
    private javax.swing.JList<String> groupList;
    private javax.swing.JRadioButton groupRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JRadioButton userRadioButton;
    // End of variables declaration//GEN-END:variables

    private void showProfileInfo() {
        try {
            this.setResizable(false); 
            this.ProfileName.setText(MainForm.userName);
            queryString = "select a.description from Account a where a.username = '" +
                    MainForm.userName.toString() + "'";
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
        try {
            String queryStrGroup = "Select DISTINCT G.groupName from FriendGroup G , WithinGroup W where G.gID = W.withinGroupID and W.memberUserID=" + MainForm.userID;
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
  
    private void refresh() {
        this.setVisible(false);
        new DeveloperForm().setVisible(true);
    }
    
}
