/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application;

import java.sql.*;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import pkg304application.database.DatabaseConnection;

/**
 *
 * @author jinyou
 */
public class GroupInfoForm extends javax.swing.JFrame {

    /**
     * Creates new form GroupInfoForm
     */
    ResultSet rs;
    Statement stmt;
    int thisGroupID;
    public GroupInfoForm() {
        try {
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            initComponents();
            stmt = dbc.getMyConnection().createStatement();
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(GroupInfoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public GroupInfoForm(String groupName, String groupDesc, int creatorUserID, String dateCreated){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        
        try {
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            initComponents();
            stmt = dbc.getMyConnection().createStatement();
            showGroupInfo(groupName, groupDesc, creatorUserID, dateCreated);
            showUserList();
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(GameInfoForm.class.getName()).log(Level.SEVERE, null, ex);
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

        groupName = new javax.swing.JLabel();
        infoTab = new javax.swing.JTabbedPane();
        descriptionTab = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        userListTab = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        creatorName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateCreated = new javax.swing.JLabel();
        deleteGroupButton = new javax.swing.JButton();
        editGroupButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        groupName.setText("jLabel1");

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        descriptionTab.setViewportView(descriptionArea);

        infoTab.addTab("Description", descriptionTab);

        userList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        userListTab.setViewportView(userList);

        infoTab.addTab("User List", userListTab);

        jLabel1.setText("Creator");

        creatorName.setText("jLabel2");

        jLabel3.setText("Date Created");

        dateCreated.setText("jLabel4");

        deleteGroupButton.setText("Delete Group");
        deleteGroupButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteGroupButtonMouseClicked(evt);
            }
        });

        editGroupButton.setText("Edit Group");
        editGroupButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editGroupButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(creatorName)
                    .addComponent(dateCreated))
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(infoTab, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editGroupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteGroupButton)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoTab, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(creatorName))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateCreated))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteGroupButton)
                    .addComponent(editGroupButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteGroupButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteGroupButtonMouseClicked
        // TODO add your handling code here:
        String insertStr;
        String selected = groupName.getText();
        try{
            String selectStr = "select * from FriendGroup F where F.groupName = '" + selected + "'";
            rs = stmt.executeQuery(selectStr);
            rs.next();
            int Gid  = rs.getInt("gID");
            int currID = MainForm.userID;
            insertStr = "delete from FriendGroup where creatorUserID = "+currID+" and gID = "+Gid+"";                              
            stmt.executeUpdate(insertStr);
           // insertStr = "delete from WithinGroup where withinGroupID = "+Gid+"";                              
           // stmt.executeUpdate(insertStr);
 
        } catch (SQLException ex) {
            Logger.getLogger(GameInfoForm.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }//GEN-LAST:event_deleteGroupButtonMouseClicked

    private void editGroupButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editGroupButtonMouseClicked
        // TODO add your handling code here:
        String gName = groupName.getText();
        new EditGroupForm(gName).setVisible(true);
    }//GEN-LAST:event_editGroupButtonMouseClicked

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
            java.util.logging.Logger.getLogger(GroupInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroupInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroupInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroupInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GroupInfoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel creatorName;
    private javax.swing.JLabel dateCreated;
    private javax.swing.JButton deleteGroupButton;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JScrollPane descriptionTab;
    private javax.swing.JButton editGroupButton;
    private javax.swing.JLabel groupName;
    private javax.swing.JTabbedPane infoTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> userList;
    private javax.swing.JScrollPane userListTab;
    // End of variables declaration//GEN-END:variables
private void showGroupInfo(String g, String d, int cre, String date) {
        try {
            String queryStr = "Select gID from FriendGroup where groupName='" + g + "'";
            rs = stmt.executeQuery(queryStr);
            rs.next();
            thisGroupID = rs.getInt("gID");
            groupName.setText(g);
            descriptionArea.setText(d);
            dateCreated.setText(date);
            queryStr = "Select userName from Account where userID=" + cre;
            rs = stmt.executeQuery(queryStr);
            rs.next();
            creatorName.setText(rs.getString("userName"));
            //queryStr = "select count(ownerID) from OwnsGame O, Game G where G.gameID = O.gameId and G.gName='" + g + "'";
            //rs = stmt.executeQuery(queryStr);
            //rs.next();
            //playerPopulation.setText(rs.getString("count(ownerID)"));
        } catch (SQLException ex) {
            Logger.getLogger(GameInfoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
}
private void showUserList() {
        try {
            System.out.println("test");
            String queryString = "Select A.userName from Account A, WithinGroup W where W.withinGroupID=" 
                                    + thisGroupID + " and  W.memberUserID = A.userID";
                      System.out.println(queryString);

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
}