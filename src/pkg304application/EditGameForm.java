/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application;

import pkg304application.database.DatabaseConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import static pkg304application.GameInfoForm.thisGameID;

/**
 *
 * @author jko
 */
public class EditGameForm extends javax.swing.JFrame {

    /**
     * Creates new form EditGameForm
     */
    
    ResultSet rs;
    Statement stmt;
    String gName;
    
     public EditGameForm() {
            initComponents();
    }
    
    public EditGameForm(String gameName) {
        try {
            initComponents();
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            stmt = dbc.getMyConnection().createStatement();
            showGameInfo(gameName);
            showAchievementList();
        } catch (SQLException ex) {
            Logger.getLogger(EditGameForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameDescriptionArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        addAchievementButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        achievementList = new javax.swing.JList<>();
        saveChangesButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        deleteAchievementButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Game Description:");

        gameDescriptionArea.setColumns(20);
        gameDescriptionArea.setRows(5);
        jScrollPane1.setViewportView(gameDescriptionArea);

        jLabel2.setText("Game Price: ");

        addAchievementButton.setText("Add New Achievements");
        addAchievementButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addAchievementButtonMouseClicked(evt);
            }
        });

        achievementList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        achievementList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                achievementListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(achievementList);

        saveChangesButton.setText("Save Changes");
        saveChangesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveChangesButtonMouseClicked(evt);
            }
        });

        jLabel3.setText("Game Achievements:");

        deleteAchievementButton.setLabel("Delete Achievement");
        deleteAchievementButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteAchievementButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addAchievementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteAchievementButton))
                            .addComponent(saveChangesButton))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAchievementButton)
                    .addComponent(deleteAchievementButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveChangesButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveChangesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveChangesButtonMouseClicked
        try {
            // TODO add your handling code here:
            String updateStr = "update Game set gDescription='" + gameDescriptionArea.getText() + "' , currentPrice="
                    + priceField.getText() + " where gName='" + gName + "'";
            stmt.executeUpdate(updateStr);
            System.out.println("done updating");
            this.setVisible(false);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(EditGameForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_saveChangesButtonMouseClicked

    private void addAchievementButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAchievementButtonMouseClicked
        new AchievementForm(gName).setVisible(true);
    }//GEN-LAST:event_addAchievementButtonMouseClicked

    private void achievementListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_achievementListMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String selectedAchievement = achievementList.getSelectedValue();
            String query = "select A.aID, G.gameID from Game G, Achievement A where A.aName='"
                                    + selectedAchievement + "' and G.gameID = " + thisGameID;
            rs = stmt.executeQuery(query);
            
            
            if (rs.next()){
            new SearchAchievementForm(rs.getInt("aID"), rs.getInt("gameID")).setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_achievementListMouseClicked

    private void deleteAchievementButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteAchievementButtonMouseClicked
        // TODO add your handling code here:
        String insertStr;
        String selected = achievementList.getSelectedValue();
        
        try{
            String selectStr = "select * from Achievement A where A.aName = '" + selected + "'";
            rs = stmt.executeQuery(selectStr);
            rs.next();
            int aid  = rs.getInt("aID");
            
            insertStr = "delete from Achievement where aID = "+aid+"";                              
            stmt.executeUpdate(insertStr);
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }//GEN-LAST:event_deleteAchievementButtonMouseClicked

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
            java.util.logging.Logger.getLogger(EditGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditGameForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> achievementList;
    private javax.swing.JButton addAchievementButton;
    private javax.swing.JButton deleteAchievementButton;
    private javax.swing.JTextArea gameDescriptionArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField priceField;
    private javax.swing.JButton saveChangesButton;
    // End of variables declaration//GEN-END:variables

    private void showGameInfo(String gameName) {
        try {
            gName = gameName;
            String queryStr = "select * from Game where gName='" + gameName + "'";
            rs = stmt.executeQuery(queryStr);
            rs.next();
            gameDescriptionArea.setText(rs.getString("gDescription"));
            priceField.setText(Integer.toString(rs.getInt("currentPrice")));
            
        } catch (SQLException ex) {
            Logger.getLogger(EditGameForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void showAchievementList() {
        try {
            String queryStr = "select A.aName from Achievement A where gameID=" + thisGameID;

            rs = stmt.executeQuery(queryStr);
            DefaultListModel achievementListModel = new DefaultListModel();
            while (rs.next()){
                achievementListModel.addElement(rs.getString("aName"));
            }
            achievementList.setModel(achievementListModel);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
