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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class ViewDraftTab extends javax.swing.JPanel {
    private Cases cases;
    private Users users;
    private addEmployeeFrame addEmployeeFrame;  
    private Employees employees;
    private DetailedView detailedView;

    /**
     * Creates new form ViewDraftTab
     */
    public ViewDraftTab() {
        initComponents();
        this.cases = new Cases();
        this.users = new Users();
        this.employees = new Employees();
    }
    
    public JTable getTable(){
        return jTable1;
    }
    
    public void updateList(){    
        String startDate = ""; 
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] insertTable = new Object[6];
        this.users.updateUserList();        
        this.cases.updateCaseList("Uferdig");
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

        jPanel1 = new javax.swing.JPanel();
        panelTop1 = new javax.swing.JPanel();
        panelBottom1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        panelNorth = new javax.swing.JPanel();
        textHeader = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelSouth = new javax.swing.JPanel();
        buttonToggle1 = new javax.swing.JButton();
        buttonAddEmployee1 = new javax.swing.JButton();
        buttonDrivingRoute = new javax.swing.JButton();

        jPanel1.setSize(new java.awt.Dimension(1024, 846));
        jPanel1.setLayout(new java.awt.BorderLayout());

        panelTop1.setMaximumSize(new java.awt.Dimension(32767, 785));
        panelTop1.setMinimumSize(new java.awt.Dimension(100, 785));
        panelTop1.setRequestFocusEnabled(false);
        panelTop1.setLayout(new javax.swing.BoxLayout(panelTop1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(panelTop1, java.awt.BorderLayout.NORTH);

        panelBottom1.setBackground(new java.awt.Color(153, 153, 153));
        panelBottom1.setMaximumSize(new java.awt.Dimension(1024, 62));
        panelBottom1.setMinimumSize(new java.awt.Dimension(1024, 62));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout panelBottom1Layout = new javax.swing.GroupLayout(panelBottom1);
        panelBottom1.setLayout(panelBottom1Layout);
        panelBottom1Layout.setHorizontalGroup(
            panelBottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        panelBottom1Layout.setVerticalGroup(
            panelBottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBottom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelBottom1, java.awt.BorderLayout.CENTER);

        setBounds(new java.awt.Rectangle(0, 0, 1024, 706));
        setMinimumSize(new java.awt.Dimension(1024, 706));
        setPreferredSize(new java.awt.Dimension(1024, 706));
        setLayout(new java.awt.BorderLayout());

        panelNorth.setMaximumSize(new java.awt.Dimension(1024, 62));
        panelNorth.setMinimumSize(new java.awt.Dimension(1024, 62));
        panelNorth.setPreferredSize(new java.awt.Dimension(1024, 62));

        textHeader.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        textHeader.setText("Uferdige oppdrag");
        panelNorth.add(textHeader);

        add(panelNorth, java.awt.BorderLayout.NORTH);

        panelCenter.setBounds(new java.awt.Rectangle(0, 0, 1024, 582));
        panelCenter.setMaximumSize(new java.awt.Dimension(1024, 582));
        panelCenter.setMinimumSize(new java.awt.Dimension(1024, 582));
        panelCenter.setPreferredSize(new java.awt.Dimension(1024, 582));
        panelCenter.setRequestFocusEnabled(false);
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
        panelSouth.setToolTipText("");
        panelSouth.setMaximumSize(new java.awt.Dimension(1024, 62));
        panelSouth.setPreferredSize(new java.awt.Dimension(1024, 62));

        buttonToggle1.setBackground(new java.awt.Color(51, 51, 51));
        buttonToggle1.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonToggle1.setForeground(new java.awt.Color(204, 204, 204));
        buttonToggle1.setText("Detaljer");
        buttonToggle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonToggle1ActionPerformed(evt);
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

        buttonDrivingRoute.setBackground(new java.awt.Color(51, 51, 51));
        buttonDrivingRoute.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonDrivingRoute.setForeground(new java.awt.Color(204, 204, 204));
        buttonDrivingRoute.setText("Se kjørerute");
        buttonDrivingRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDrivingRouteActionPerformed(evt);
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
                    .addComponent(buttonToggle1)
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
                        .addComponent(buttonToggle1)
                        .addComponent(buttonAddEmployee1)
                        .addComponent(buttonDrivingRoute))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        add(panelSouth, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonToggle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonToggle1ActionPerformed
        try{
            int id = (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            Case currentCase = cases.getCaseById(id);
            this.detailedView = new DetailedView(currentCase, this);
            this.detailedView.setVisible(true);
        }catch(Exception e){
            showMessageDialog(null, "Vennligst velg et oppdrag");
        }
    }//GEN-LAST:event_buttonToggle1ActionPerformed

    private void buttonAddEmployee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddEmployee1ActionPerformed
        try{
            int id = (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            this.addEmployeeFrame = new addEmployeeFrame(id);
            this.addEmployeeFrame.setVisible(true);
        }catch(Exception e){
            showMessageDialog(null, "Vennligst velg et oppdrag");
        }
    }//GEN-LAST:event_buttonAddEmployee1ActionPerformed

    private void buttonDrivingRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDrivingRouteActionPerformed
        try{
            int id = (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            URLGenerator.generateMapURL(this.cases.getCaseById(id).getAddress(), this.cases.getCaseById(id).getPostalCode(),
                                    this.cases.getCaseById(id).getPostPlace());
        }catch(Exception e){
            showMessageDialog(null, "Vennligst velg et oppdrag");
        }
    }//GEN-LAST:event_buttonDrivingRouteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddEmployee1;
    private javax.swing.JButton buttonDrivingRoute;
    private javax.swing.JButton buttonToggle1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel panelBottom1;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelSouth;
    private javax.swing.JPanel panelTop1;
    private javax.swing.JLabel textHeader;
    // End of variables declaration//GEN-END:variables
}
