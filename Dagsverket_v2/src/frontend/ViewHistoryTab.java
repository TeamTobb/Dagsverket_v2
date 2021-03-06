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
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class ViewHistoryTab extends javax.swing.JPanel {
    private Cases cases;
    private Users users;
    private addEmployeeFrame addEmployeeFrame;  
    private Employees employees;
    private DetailedView detailedView;

    /**
     * Creates new form ViewHistoryTab
     */
    public ViewHistoryTab() {
        this.cases = new Cases(); 
        this.users = new Users();
        this.employees = new Employees();
        initComponents();
    }
    
    public void updateList(){    
        String startDate = ""; 
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] insertTable = new Object[6];
        this.users.updateUserList();
        this.cases.updateCaseList("Ferdig");
        for(int i = 0; i<this.cases.getCases().size(); i++){
            insertTable[0] = this.cases.getCases().get(i).getId();
            insertTable[1] = this.cases.getCases().get(i).getSubject();
            insertTable[2] = this.cases.getCases().get(i).getEmployer().getFirstname();
            insertTable[3] = this.cases.getCases().get(i).getEmployer().getLastname();
            if(this.cases.getCases().get(i).getStartDate().equals("null-null-null")){        
                insertTable[4] = "";
            }else{
                insertTable[4] = this.cases.getCases().get(i).getStartDate();                
            }
            insertTable[5] = this.users.getUserById(this.cases.getCases().get(i).getSupervisorId()).toString();
            model.insertRow(jTable1.getRowCount(), insertTable);                     
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

        panelNorth = new javax.swing.JPanel();
        textHeader = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelSouth = new javax.swing.JPanel();
        buttonDrivingRoute = new javax.swing.JButton();
        buttonAddEmployee1 = new javax.swing.JButton();
        buttonViewDetails = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1024, 706));
        setMinimumSize(new java.awt.Dimension(1024, 706));
        setPreferredSize(new java.awt.Dimension(1024, 706));
        setSize(new java.awt.Dimension(1024, 706));
        setLayout(new java.awt.BorderLayout());

        panelNorth.setMaximumSize(new java.awt.Dimension(1024, 62));
        panelNorth.setMinimumSize(new java.awt.Dimension(1024, 62));
        panelNorth.setPreferredSize(new java.awt.Dimension(1024, 62));
        panelNorth.setSize(new java.awt.Dimension(1024, 62));

        textHeader.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        textHeader.setText("Ferdige oppdrag");
        panelNorth.add(textHeader);

        add(panelNorth, java.awt.BorderLayout.NORTH);

        panelCenter.setMaximumSize(new java.awt.Dimension(1024, 582));
        panelCenter.setMinimumSize(new java.awt.Dimension(1024, 582));
        panelCenter.setPreferredSize(new java.awt.Dimension(1024, 582));
        panelCenter.setSize(new java.awt.Dimension(1024, 582));
        panelCenter.setLayout(new javax.swing.BoxLayout(panelCenter, javax.swing.BoxLayout.LINE_AXIS));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Saksnummer", "Emne", "K. fornavn", "K. etternavn", "Utførelsesdato", "Ansvarlig"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(85);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(85);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(85);
            jTable1.getColumnModel().getColumn(2).setMinWidth(140);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(140);
            jTable1.getColumnModel().getColumn(3).setMinWidth(140);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(140);
            jTable1.getColumnModel().getColumn(4).setMinWidth(140);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(140);
        }
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panelCenter.add(jScrollPane1);

        add(panelCenter, java.awt.BorderLayout.CENTER);

        panelSouth.setBackground(new java.awt.Color(153, 153, 153));
        panelSouth.setMaximumSize(new java.awt.Dimension(1024, 62));
        panelSouth.setMinimumSize(new java.awt.Dimension(1024, 62));
        panelSouth.setPreferredSize(new java.awt.Dimension(1024, 62));
        panelSouth.setSize(new java.awt.Dimension(1024, 62));

        buttonDrivingRoute.setBackground(new java.awt.Color(51, 51, 51));
        buttonDrivingRoute.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonDrivingRoute.setForeground(new java.awt.Color(204, 204, 204));
        buttonDrivingRoute.setText("Se kjørerute");
        buttonDrivingRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDrivingRouteActionPerformed(evt);
            }
        });

        buttonAddEmployee1.setBackground(new java.awt.Color(51, 51, 51));
        buttonAddEmployee1.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonAddEmployee1.setForeground(new java.awt.Color(204, 204, 204));
        buttonAddEmployee1.setText("Legg til arbeidere");
        buttonAddEmployee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddEmployee1ActionPerformed(evt);
            }
        });

        buttonViewDetails.setBackground(new java.awt.Color(51, 51, 51));
        buttonViewDetails.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonViewDetails.setForeground(new java.awt.Color(204, 204, 204));
        buttonViewDetails.setText("Detaljer");
        buttonViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSouthLayout = new javax.swing.GroupLayout(panelSouth);
        panelSouth.setLayout(panelSouthLayout);
        panelSouthLayout.setHorizontalGroup(
            panelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSouthLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(buttonViewDetails)
                    .addGap(5, 5, 5)
                    .addComponent(buttonAddEmployee1)
                    .addGap(5, 5, 5)
                    .addComponent(buttonDrivingRoute)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelSouthLayout.setVerticalGroup(
            panelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
            .addGroup(panelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSouthLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(panelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonViewDetails)
                        .addComponent(buttonAddEmployee1)
                        .addComponent(buttonDrivingRoute))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        add(panelSouth, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDrivingRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDrivingRouteActionPerformed
        try{
            int id = (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            URLGenerator.generateMapURL(this.cases.getCaseById(id).getAddress(), this.cases.getCaseById(id).getPostalCode(),
                                    this.cases.getCaseById(id).getPostPlace());
        }catch(Exception e){
            showMessageDialog(null, "Vennligst velg et oppdrag");
        }
    }//GEN-LAST:event_buttonDrivingRouteActionPerformed

    private void buttonAddEmployee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddEmployee1ActionPerformed
        try{
            int id = (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            this.addEmployeeFrame = new addEmployeeFrame(id);
            this.addEmployeeFrame.setVisible(true);
        }catch(Exception e){
            showMessageDialog(null, "Vennligst velg et oppdrag");
        }
    }//GEN-LAST:event_buttonAddEmployee1ActionPerformed

    private void buttonViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewDetailsActionPerformed
        try{
            int id = (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            Case currentCase = cases.getCaseById(id);
            this.detailedView = new DetailedView(currentCase, this);
            this.detailedView.setVisible(true);
        }catch(Exception e){
            showMessageDialog(null, "Vennligst velg et oppdrag");
        }
    }//GEN-LAST:event_buttonViewDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddEmployee1;
    private javax.swing.JButton buttonDrivingRoute;
    private javax.swing.JButton buttonViewDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelSouth;
    private javax.swing.JLabel textHeader;
    // End of variables declaration//GEN-END:variables
}
