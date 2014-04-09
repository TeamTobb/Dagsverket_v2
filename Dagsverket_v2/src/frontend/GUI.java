package frontend;
import backend.*;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI extends javax.swing.JFrame {
    private CardLayout cardLayout;
    private CreateCaseTab createCaseTab; 
    private ViewActiveTab viewActiveTab;
    private ViewDraftTab viewDraftTab; 
    private ViewHistoryTab viewHistoryTab;
    private SaleTab saleTab; 
    private AttendanceTab attendanceTab;
    private Database db;   
    private Employees employees;
    private Users users;
    private int selectedTab = 1;
    
    /**
     * Creates new form GUI
     */
    public GUI(User currentUser) {
        initComponents();
        addPanels();
        this.employees = new Employees();
        this.users = new Users();
    }

    public ViewActiveTab getViewActiveTab() {
        return viewActiveTab;
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
        panelContent = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        buttonLogOut = new javax.swing.JButton();
        buttonViewHistory = new javax.swing.JButton();
        buttonSales = new javax.swing.JButton();
        buttonRegisterCase = new javax.swing.JButton();
        labelUserName = new javax.swing.JLabel();
        buttonViewDraftCases = new javax.swing.JButton();
        buttonViewActiveCases = new javax.swing.JButton();
        buttonAttendance = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelMain.setLayout(null);

        panelContent.setMinimumSize(new java.awt.Dimension(1024, 706));
        panelContent.setPreferredSize(new java.awt.Dimension(1024, 706));
        panelContent.setLayout(new java.awt.CardLayout());
        panelMain.add(panelContent);
        panelContent.setBounds(0, 60, 1024, 690);

        panelMenu.setBackground(new java.awt.Color(153, 153, 153));

        buttonLogOut.setBackground(new java.awt.Color(51, 51, 51));
        buttonLogOut.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonLogOut.setForeground(new java.awt.Color(204, 204, 204));
        // Icon taken from http://www.visualpharm.com
        buttonLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logout-button.png")));
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });

        buttonViewHistory.setBackground(new java.awt.Color(51, 51, 51));
        buttonViewHistory.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonViewHistory.setForeground(new java.awt.Color(204, 204, 204));
        buttonViewHistory.setText("Historie");
        buttonViewHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewHistoryActionPerformed(evt);
            }
        });

        buttonSales.setBackground(new java.awt.Color(51, 51, 51));
        buttonSales.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonSales.setForeground(new java.awt.Color(204, 204, 204));
        buttonSales.setText("Vedsalg");
        buttonSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalesActionPerformed(evt);
            }
        });

        buttonRegisterCase.setBackground(new java.awt.Color(51, 51, 51));
        buttonRegisterCase.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonRegisterCase.setForeground(new java.awt.Color(204, 204, 204));
        buttonRegisterCase.setText("Reg. sak");
        buttonRegisterCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterCaseActionPerformed(evt);
            }
        });

        labelUserName.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        labelUserName.setText(users.currentUser.getFirstname() + " " + users.currentUser.getLastname().substring(0, 1));

        buttonViewDraftCases.setBackground(new java.awt.Color(51, 51, 51));
        buttonViewDraftCases.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonViewDraftCases.setForeground(new java.awt.Color(204, 204, 204));
        buttonViewDraftCases.setText("Uferdige");
        buttonViewDraftCases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewDraftCasesActionPerformed(evt);
            }
        });

        buttonViewActiveCases.setBackground(new java.awt.Color(51, 51, 51));
        buttonViewActiveCases.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonViewActiveCases.setForeground(new java.awt.Color(204, 204, 204));
        buttonViewActiveCases.setText("Aktive");
        buttonViewActiveCases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewActiveCasesActionPerformed(evt);
            }
        });

        buttonAttendance.setBackground(new java.awt.Color(51, 51, 51));
        buttonAttendance.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonAttendance.setForeground(new java.awt.Color(204, 204, 204));
        buttonAttendance.setText("Oppmøte");
        buttonAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAttendanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonRegisterCase, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonViewActiveCases, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonViewDraftCases, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonViewHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(labelUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonRegisterCase, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonViewActiveCases, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonViewDraftCases, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonViewHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonSales, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelUserName)
                        .addComponent(buttonAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMain.add(panelMenu);
        panelMenu.setBounds(0, 0, 1024, 62);

        getContentPane().add(panelMain, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegisterCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterCaseActionPerformed
        this.cardLayout.show(panelContent, "CreateCaseTab");
        setAllDarkGray();
        buttonRegisterCase.setBackground(Color.black);        
    }//GEN-LAST:event_buttonRegisterCaseActionPerformed

    private void buttonViewHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewHistoryActionPerformed
        this.viewHistoryTab.updateList();
        this.cardLayout.show(panelContent, "HistoryTab");
        setAllDarkGray();
        buttonViewHistory.setBackground(Color.black);
    }//GEN-LAST:event_buttonViewHistoryActionPerformed

    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        JFrame confirmFrame = new JFrame();
        String[] options = new String[2];
        options[0] = "Nei";
        options[1] = "Ja";
        int result = JOptionPane.showOptionDialog(confirmFrame.getContentPane(),"Er du sikker på at du vil logge ut?","Konfirmasjon", 
                0,JOptionPane.INFORMATION_MESSAGE,null,options,null); 
        
        if(result == 1){
            this.dispose();
            Login.main(null);        
        }
    }//GEN-LAST:event_buttonLogOutActionPerformed

    private void buttonViewDraftCasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewDraftCasesActionPerformed
        
        this.viewDraftTab.updateList();
        this.cardLayout.show(panelContent, "Uferdig");
        setAllDarkGray();
        buttonViewDraftCases.setBackground(Color.black);
    }//GEN-LAST:event_buttonViewDraftCasesActionPerformed

    public CardLayout getCardLayout() {
        return cardLayout;
    }
    
    public JPanel getPanelContent(){
        return this.panelContent;
    }

    private void buttonViewActiveCasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewActiveCasesActionPerformed
        this.cardLayout.show(panelContent, "Aktiv");
        this.viewActiveTab.updateList();
        setAllDarkGray();
        buttonViewActiveCases.setBackground(Color.black);
    }//GEN-LAST:event_buttonViewActiveCasesActionPerformed

    private void buttonSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalesActionPerformed
        this.cardLayout.show(panelContent, "SaleTab");
        setAllDarkGray();
        buttonSales.setBackground(Color.black);
    }//GEN-LAST:event_buttonSalesActionPerformed

    private void buttonAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAttendanceActionPerformed
        this.cardLayout.show(panelContent, "AttendanceTab");
        this.employees.updateGUILists(this.attendanceTab.getTableLeft(), this.attendanceTab.getTableRight());
        setAllDarkGray();
        buttonAttendance.setBackground(Color.black);
    }//GEN-LAST:event_buttonAttendanceActionPerformed

    private void addPanels(){
        this.createCaseTab = new CreateCaseTab(this);
        this.viewActiveTab = new ViewActiveTab(); 
        this.viewDraftTab = new ViewDraftTab(); 
        this.viewHistoryTab = new ViewHistoryTab();
        this.saleTab = new SaleTab(); 
        this.attendanceTab = new AttendanceTab();
        
        cardLayout = (CardLayout) panelContent.getLayout();
        panelContent.add(this.createCaseTab, "CreateCaseTab");        
        panelContent.add(this.viewActiveTab, "Aktiv");
        panelContent.add(this.viewDraftTab, "Uferdig");
        panelContent.add(this.viewHistoryTab, "HistoryTab");        
        panelContent.add(this.saleTab, "SaleTab");     
        panelContent.add(this.attendanceTab, "AttendanceTab");
    }
    
    private void setAllDarkGray(){
        buttonAttendance.setBackground(Color.darkGray);
        buttonSales.setBackground(Color.darkGray);
        buttonViewActiveCases.setBackground(Color.darkGray);
        buttonViewDraftCases.setBackground(Color.darkGray);
        buttonViewHistory.setBackground(Color.darkGray);
        buttonRegisterCase.setBackground(Color.darkGray);
    }
    
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(final User currentUser) {  
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI(currentUser).setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAttendance;
    private javax.swing.JButton buttonLogOut;
    private javax.swing.JButton buttonRegisterCase;
    private javax.swing.JButton buttonSales;
    private javax.swing.JButton buttonViewActiveCases;
    private javax.swing.JButton buttonViewDraftCases;
    private javax.swing.JButton buttonViewHistory;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
