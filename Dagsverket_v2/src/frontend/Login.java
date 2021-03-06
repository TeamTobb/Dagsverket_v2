/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/
package frontend;

import backend.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.JOptionPane.*;

public class Login extends javax.swing.JFrame {
    private Database db;
    private Users users;
    
    
    /**
     * Creates new form Login
     */
    public Login() {
        this.db = new Database();
        this.users = new Users();
        users.updateUserListByStatus(1); // 1 = active users (not deleted)
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

        panelMain = new javax.swing.JPanel();
        panelNorth = new javax.swing.JPanel();
        textHeader = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listUserNames = new javax.swing.JList();
        panelSouth = new javax.swing.JPanel();
        buttonLogIn = new javax.swing.JButton();
        buttonNewUser = new javax.swing.JButton();
        buttonDeleteUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelMain.setBackground(new java.awt.Color(204, 0, 0));
        panelMain.setPreferredSize(new java.awt.Dimension(530, 474));
        panelMain.setLayout(new java.awt.BorderLayout());

        panelNorth.setBackground(new java.awt.Color(153, 153, 153));
        panelNorth.setPreferredSize(new java.awt.Dimension(530, 62));

        textHeader.setFont(new java.awt.Font("Optima", 1, 48)); // NOI18N
        textHeader.setText("DAGSVERKET");
        panelNorth.add(textHeader);

        panelMain.add(panelNorth, java.awt.BorderLayout.NORTH);

        panelCenter.setMaximumSize(new java.awt.Dimension(32767, 225));
        panelCenter.setMinimumSize(new java.awt.Dimension(23, 225));
        panelCenter.setPreferredSize(new java.awt.Dimension(530, 225));
        panelCenter.setSize(new java.awt.Dimension(0, 225));
        panelCenter.setLayout(new javax.swing.BoxLayout(panelCenter, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(32767, 225));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(23, 225));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(260, 225));
        jScrollPane2.setSize(new java.awt.Dimension(43, 225));

        listUserNames.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        listUserNames.setModel(new javax.swing.AbstractListModel() {
            String[] strings = users.getUsers();
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listUserNames);

        panelCenter.add(jScrollPane2);
        jScrollPane2.getAccessibleContext().setAccessibleName("Dagsverket");

        panelMain.add(panelCenter, java.awt.BorderLayout.CENTER);

        panelSouth.setBackground(new java.awt.Color(153, 153, 153));
        panelSouth.setPreferredSize(new java.awt.Dimension(530, 62));

        buttonLogIn.setBackground(new java.awt.Color(51, 51, 51));
        buttonLogIn.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonLogIn.setForeground(new java.awt.Color(204, 204, 204));
        buttonLogIn.setText("Logg inn");
        buttonLogIn.setPreferredSize(new java.awt.Dimension(150, 50));
        buttonLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogInActionPerformed(evt);
            }
        });
        panelSouth.add(buttonLogIn);

        buttonNewUser.setBackground(new java.awt.Color(51, 51, 51));
        buttonNewUser.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonNewUser.setForeground(new java.awt.Color(204, 204, 204));
        buttonNewUser.setText("Ny bruker");
        buttonNewUser.setPreferredSize(new java.awt.Dimension(150, 50));
        buttonNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewUserActionPerformed(evt);
            }
        });
        panelSouth.add(buttonNewUser);

        buttonDeleteUser.setBackground(new java.awt.Color(51, 51, 51));
        buttonDeleteUser.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonDeleteUser.setForeground(new java.awt.Color(204, 204, 204));
        buttonDeleteUser.setText("Slett bruker");
        buttonDeleteUser.setPreferredSize(new java.awt.Dimension(150, 50));
        buttonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteUserActionPerformed(evt);
            }
        });
        panelSouth.add(buttonDeleteUser);

        panelMain.add(panelSouth, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogInActionPerformed
        try{
            User selectedUser = users.getUserByIndex(listUserNames.getSelectedIndex());
            users.setCurrentUser(selectedUser);
            GUI.main(selectedUser);
            this.dispose();
        }catch(ArrayIndexOutOfBoundsException e){
            showMessageDialog(null, "Vennligst velg en bruker"); 
        }                
    }//GEN-LAST:event_buttonLogInActionPerformed

    private void buttonNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewUserActionPerformed
      int error = 0; 
      JTextField textfieldFirstName = new JTextField(8);
      JTextField textfieldLastName = new JTextField(8);
      JPanel panelNewUser = new JPanel();
      panelNewUser.add(new JLabel("Fornavn:"));
      panelNewUser.add(textfieldFirstName);
      panelNewUser.add(Box.createHorizontalStrut(15)); // a spacer
      panelNewUser.add(new JLabel("Etternavn:"));
      panelNewUser.add(textfieldLastName);
      
      /* Maks characters som input */
      textfieldFirstName.setDocument(new JTextFieldLimit(12));
      textfieldLastName.setDocument(new JTextFieldLimit(12));
      
      int result = JOptionPane.showConfirmDialog(null, panelNewUser, 
               "Skriv inn fornavn og etternavn", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION){
          if(textfieldFirstName.getText().trim().equals("") || textfieldLastName.getText().trim().equals("")){
              showMessageDialog(null, "Vennligst skriv inn minst én bokstav i hvert felt");
          }else{
              error = users.createUser(textfieldFirstName.getText(), textfieldLastName.getText());
              if(error == 0){
                 showMessageDialog(null, "FEIL: Databasen ikke oppdatert"); 
              }else{
                users.updateUserListByStatus(1);
                listUserNames.setListData(users.getUsers());
                listUserNames.updateUI();
              }
          }
      }
    }//GEN-LAST:event_buttonNewUserActionPerformed

    private void buttonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteUserActionPerformed
        JFrame confirmFrame = new JFrame();
        String[] options = new String[2];
        options[0] = "Nei";
        options[1] = "Ja";
        int result = JOptionPane.showOptionDialog(confirmFrame.getContentPane(),"Er du sikker på at du vil slette brukeren?","Konfirmasjon", 
                0,JOptionPane.INFORMATION_MESSAGE,null,options,null); 
        
        if(result == 1){
            this.users.updateUserListByStatus(1);
            String[]names = null;
            try{
                User userToBeDeleted = users.getUserByIndex(listUserNames.getSelectedIndex());
                //names = ((String)listUserNames.getSelectedValue()).split(" ");
                try{
                    db.createConnection();
                    PreparedStatement updateUser = db.getConnection().prepareStatement(
                            "UPDATE users SET status = 0 WHERE firstName = ? AND lastNAme = ?");
                    updateUser.setString(1, userToBeDeleted.getFirstname());
                    updateUser.setString(2, userToBeDeleted.getLastname());  
                    db.executeUpdate(updateUser);
                    users.updateUserListByStatus(1);
                    listUserNames.setListData(users.getUsers());
                    listUserNames.updateUI();
                }catch(SQLException e){
                    showMessageDialog(null, "feil i delete user: " +e);
                }
                finally{
                    db.closeAll();
                }
            }catch(NullPointerException e){
                showMessageDialog(null, "Vennligst velg en bruker"); 
            }        
        }       
    }//GEN-LAST:event_buttonDeleteUserActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDeleteUser;
    private javax.swing.JButton buttonLogIn;
    private javax.swing.JButton buttonNewUser;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listUserNames;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelSouth;
    private javax.swing.JLabel textHeader;
    // End of variables declaration//GEN-END:variables
}
