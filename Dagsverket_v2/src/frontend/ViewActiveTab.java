/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontend;

import backend.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorgen
 */
public class ViewActiveTab extends javax.swing.JPanel {     
    private Cases cases; 
    private Users users;
    private addEmployeeFrame addEmployeeFrame;  
    private Employees employees;
    private DetailedView detailedView;
    /**
     * Creates new form ViewActiveTab
     */
    public ViewActiveTab() {
        initComponents();
        panelCenter.setVisible(true);
        this.cases = new Cases();
        this.users = new Users();
        this.employees = new Employees();
    }
    
    public void updateList(){    
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0);
    Object[] insertTable = new Object[4];
    this.cases.updateCaseList("Aktiv");

    for(int i = 0; i<this.cases.getCases().size(); i++){
        insertTable[0] = this.cases.getCases().get(i).getId();
        insertTable[1] = this.cases.getCases().get(i).getSubject();
        insertTable[2] = this.cases.getCases().get(i).getStartDate();
        insertTable[3] = this.users.getUserById(this.cases.getCases().get(i).getSupervisorId()).toString();
        model.insertRow(jTable2.getRowCount(), insertTable);                     
       }    
    }
    
    
    public JTable getTable(){
        return jTable2;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        panelSouth = new javax.swing.JPanel();
        buttonToggle1 = new javax.swing.JButton();
        buttonAddEmployee1 = new javax.swing.JButton();
        buttonDrivingRoute = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 51));
        setMaximumSize(new java.awt.Dimension(1024, 706));
        setMinimumSize(new java.awt.Dimension(1024, 706));
        setSize(new java.awt.Dimension(1024, 706));
        setLayout(new java.awt.BorderLayout());

        panelNorth.setMaximumSize(new java.awt.Dimension(1024, 62));
        panelNorth.setMinimumSize(new java.awt.Dimension(1024, 62));
        panelNorth.setPreferredSize(new java.awt.Dimension(1024, 62));
        panelNorth.setSize(new java.awt.Dimension(1024, 62));

        jLabel1.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel1.setText("ViewActiveTab");

        javax.swing.GroupLayout panelNorthLayout = new javax.swing.GroupLayout(panelNorth);
        panelNorth.setLayout(panelNorthLayout);
        panelNorthLayout.setHorizontalGroup(
            panelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorthLayout.createSequentialGroup()
                .addGap(408, 408, 408)
                .addComponent(jLabel1)
                .addContainerGap(457, Short.MAX_VALUE))
        );
        panelNorthLayout.setVerticalGroup(
            panelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNorthLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        add(panelNorth, java.awt.BorderLayout.NORTH);

        panelCenter.setMaximumSize(new java.awt.Dimension(1024, 582));
        panelCenter.setMinimumSize(new java.awt.Dimension(1024, 582));
        panelCenter.setPreferredSize(new java.awt.Dimension(1024, 582));
        panelCenter.setSize(new java.awt.Dimension(1024, 582));
        panelCenter.setLayout(new javax.swing.BoxLayout(panelCenter, javax.swing.BoxLayout.LINE_AXIS));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Saksnummer", "Emne", "Utførelsesdato", "Ansvarlig"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(80);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(80);
            jTable2.getColumnModel().getColumn(2).setMinWidth(140);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(140);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(140);
        }

        panelCenter.add(jScrollPane2);

        add(panelCenter, java.awt.BorderLayout.CENTER);

        panelSouth.setBackground(new java.awt.Color(153, 153, 153));
        panelSouth.setMaximumSize(new java.awt.Dimension(1024, 62));
        panelSouth.setMinimumSize(new java.awt.Dimension(1024, 62));
        panelSouth.setPreferredSize(new java.awt.Dimension(1024, 62));
        panelSouth.setSize(new java.awt.Dimension(1024, 62));

        buttonToggle1.setText("Detaljer");
        buttonToggle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonToggle1ActionPerformed(evt);
            }
        });
        panelSouth.add(buttonToggle1);

        buttonAddEmployee1.setText("Legg til arbeidere");
        buttonAddEmployee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddEmployee1ActionPerformed(evt);
            }
        });
        panelSouth.add(buttonAddEmployee1);

        buttonDrivingRoute.setText("Se kjørerute");
        buttonDrivingRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDrivingRouteActionPerformed(evt);
            }
        });
        panelSouth.add(buttonDrivingRoute);

        add(panelSouth, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDrivingRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDrivingRouteActionPerformed
        try{
            int id = (int)jTable2.getValueAt(jTable2.getSelectedRow(), 0); 
            String address = this.cases.getCaseById(id).getAddress();
            String[] addressArray = address.split(" ");
            String addressURL = "http://www.google.no/maps/dir/Hornebergveien+5,+7038+Trondheim/";        
            for(int i = 0; i<addressArray.length; i++){
                if(i<addressArray.length-1){
                    addressURL+= addressArray[i] + "+";            
                }
                else{
                    addressURL += addressArray[i];
                }
            }  
            addressURL += ",";        
            String postalCode = "+"+this.cases.getCaseById(id).getPostalCode();
            addressURL += postalCode;
            addressURL += "+";   
            addressURL += this.cases.getCaseById(id).getPostPlace();
            addressURL+="/";
            addressURL = addressURL.replaceAll("æ", "ae");
            addressURL = addressURL.replaceAll("ø", "ae");
            addressURL = addressURL.replaceAll("å", "ae");
            addressURL = addressURL.replaceAll("Æ", "AE");
            addressURL = addressURL.replaceAll("Ø", "O");
            addressURL = addressURL.replaceAll("Å", "AA");                
            try {
                Desktop d = Desktop.getDesktop();
                d.browse(new URI(addressURL)); 
            } catch(IOException | URISyntaxException ex) {
                ex.printStackTrace();
            } 
        }catch(ArrayIndexOutOfBoundsException e){
            showMessageDialog(null, "Vennligst velg et oppdrag");
        }

    }//GEN-LAST:event_buttonDrivingRouteActionPerformed

    private void buttonToggle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonToggle1ActionPerformed
        try{
            int id = (int)jTable2.getValueAt(jTable2.getSelectedRow(), 0);
            Case currentCase = cases.getCaseById(id);
            this.detailedView = new DetailedView(currentCase, this);
            this.detailedView.setVisible(true);
        }catch(ArrayIndexOutOfBoundsException e){
            showMessageDialog(null, "Vennligst velg et oppdrag"); 
        }
    }//GEN-LAST:event_buttonToggle1ActionPerformed

    private void buttonAddEmployee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddEmployee1ActionPerformed
        try{
            int id = (int)jTable2.getValueAt(jTable2.getSelectedRow(), 0);
            this.addEmployeeFrame = new addEmployeeFrame(id);
            this.addEmployeeFrame.setVisible(true);
        }catch(ArrayIndexOutOfBoundsException e){
            showMessageDialog(null, "Vennligst velg et oppdrag"); 
        }
    }//GEN-LAST:event_buttonAddEmployee1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddEmployee1;
    private javax.swing.JButton buttonDrivingRoute;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonToggle1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelSouth;
    // End of variables declaration//GEN-END:variables
}
