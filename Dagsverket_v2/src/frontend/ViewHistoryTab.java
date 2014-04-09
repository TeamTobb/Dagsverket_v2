/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontend;

import backend.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorgen
 */
public class ViewHistoryTab extends javax.swing.JPanel {
    private Cases cases;
    private Users users;

    /**
     * Creates new form ViewHistoryTab
     */
    public ViewHistoryTab() {
        this.cases = new Cases(); 
        this.users = new Users(); 
        initComponents();
    }    
    
    public void updateList(){    
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] insertTable = new Object[4];
        this.cases.updateCaseList("Ferdig");

        for(int i = 0; i<this.cases.getCases().size(); i++){
            insertTable[0] = this.cases.getCases().get(i).getId();
            insertTable[1] = this.cases.getCases().get(i).getSubject();
            insertTable[2] = this.cases.getCases().get(i).getStartDate();
            insertTable[3] = this.users.getUserById(this.cases.getCases().get(i).getSupervisorId()).toString();
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
        jLabel1 = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelSouth = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(1024, 706));
        setMinimumSize(new java.awt.Dimension(1024, 706));
        setPreferredSize(new java.awt.Dimension(1024, 706));
        setSize(new java.awt.Dimension(1024, 706));
        setLayout(new java.awt.BorderLayout());

        panelNorth.setMaximumSize(new java.awt.Dimension(1024, 62));
        panelNorth.setMinimumSize(new java.awt.Dimension(1024, 62));
        panelNorth.setPreferredSize(new java.awt.Dimension(1024, 62));
        panelNorth.setSize(new java.awt.Dimension(1024, 62));

        jLabel1.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel1.setText("ViewHistoryTab");

        javax.swing.GroupLayout panelNorthLayout = new javax.swing.GroupLayout(panelNorth);
        panelNorth.setLayout(panelNorthLayout);
        panelNorthLayout.setHorizontalGroup(
            panelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNorthLayout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jLabel1)
                .addContainerGap(435, Short.MAX_VALUE))
        );
        panelNorthLayout.setVerticalGroup(
            panelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNorthLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(panelNorth, java.awt.BorderLayout.NORTH);

        panelCenter.setMaximumSize(new java.awt.Dimension(1024, 582));
        panelCenter.setMinimumSize(new java.awt.Dimension(1024, 582));
        panelCenter.setPreferredSize(new java.awt.Dimension(1024, 582));
        panelCenter.setSize(new java.awt.Dimension(1024, 582));
        panelCenter.setLayout(new javax.swing.BoxLayout(panelCenter, javax.swing.BoxLayout.LINE_AXIS));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        panelCenter.add(jScrollPane1);

        add(panelCenter, java.awt.BorderLayout.CENTER);

        panelSouth.setBackground(new java.awt.Color(153, 153, 153));
        panelSouth.setMaximumSize(new java.awt.Dimension(1024, 62));
        panelSouth.setMinimumSize(new java.awt.Dimension(1024, 62));
        panelSouth.setPreferredSize(new java.awt.Dimension(1024, 62));
        panelSouth.setSize(new java.awt.Dimension(1024, 62));

        javax.swing.GroupLayout panelSouthLayout = new javax.swing.GroupLayout(panelSouth);
        panelSouth.setLayout(panelSouthLayout);
        panelSouthLayout.setHorizontalGroup(
            panelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        panelSouthLayout.setVerticalGroup(
            panelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        add(panelSouth, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelSouth;
    // End of variables declaration//GEN-END:variables
}
