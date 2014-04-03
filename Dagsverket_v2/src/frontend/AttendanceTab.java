/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontend;

import backend.Operator;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorgen
 */
public class AttendanceTab extends javax.swing.JPanel {
    private Operator op; 

    /**
     * Creates new form AttendanceTab
     */
    public AttendanceTab(Operator op) {
        this.op = op;
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

        panelLeft = new javax.swing.JPanel();
        tableNotAttending = new javax.swing.JScrollPane();
        tableLeft = new javax.swing.JTable();
        panelCenter = new javax.swing.JPanel();
        buttonMoveToAttending = new javax.swing.JButton();
        buttonMoveToNotAttending = new javax.swing.JButton();
        buttonRegisterNewEmployer = new javax.swing.JButton();
        panelRight = new javax.swing.JPanel();
        tableAttending = new javax.swing.JScrollPane();
        tableRight = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 0));
        setPreferredSize(new java.awt.Dimension(1024, 690));
        setLayout(new java.awt.BorderLayout());

        panelLeft.setPreferredSize(new java.awt.Dimension(425, 690));
        panelLeft.setLayout(new javax.swing.BoxLayout(panelLeft, javax.swing.BoxLayout.LINE_AXIS));

        tableLeft.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Fornavn", "Etternavn", "Sist reg", "Ant uten"
            }
        ));
        tableNotAttending.setViewportView(tableLeft);

        panelLeft.add(tableNotAttending);

        add(panelLeft, java.awt.BorderLayout.WEST);

        panelCenter.setBackground(new java.awt.Color(153, 153, 153));
        panelCenter.setPreferredSize(new java.awt.Dimension(174, 690));

        buttonMoveToAttending.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonMoveToAttending.setText("->");
        buttonMoveToAttending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoveToAttendingActionPerformed(evt);
            }
        });

        buttonMoveToNotAttending.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonMoveToNotAttending.setText("<-");
        buttonMoveToNotAttending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoveToNotAttendingActionPerformed(evt);
            }
        });

        buttonRegisterNewEmployer.setFont(new java.awt.Font("Optima", 1, 14)); // NOI18N
        buttonRegisterNewEmployer.setText("Registrer ny person");
        buttonRegisterNewEmployer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterNewEmployerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCenterLayout = new javax.swing.GroupLayout(panelCenter);
        panelCenter.setLayout(panelCenterLayout);
        panelCenterLayout.setHorizontalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCenterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonRegisterNewEmployer))
                    .addGroup(panelCenterLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(buttonMoveToAttending, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCenterLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(buttonMoveToNotAttending, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        panelCenterLayout.setVerticalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(buttonMoveToAttending, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(buttonRegisterNewEmployer, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(buttonMoveToNotAttending, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(panelCenter, java.awt.BorderLayout.CENTER);

        panelRight.setPreferredSize(new java.awt.Dimension(425, 690));
        panelRight.setLayout(new javax.swing.BoxLayout(panelRight, javax.swing.BoxLayout.LINE_AXIS));

        tableRight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Fornavn", "Etternavn", "Sist reg", "Ant uten"
            }
        ));
        tableAttending.setViewportView(tableRight);

        panelRight.add(tableAttending);

        add(panelRight, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMoveToAttendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoveToAttendingActionPerformed
        String firstName = (String)tableLeft.getModel().getValueAt(tableLeft.getSelectedRow(), 1);
        String lastName = (String)tableLeft.getModel().getValueAt(tableLeft.getSelectedRow(), 2);        
        this.op.getEmployees().moveToAttended(firstName, lastName, tableLeft, tableRight);
       
    }//GEN-LAST:event_buttonMoveToAttendingActionPerformed

    private void buttonRegisterNewEmployerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterNewEmployerActionPerformed
      ArrayList<Integer> errors = new ArrayList<Integer>();
      JTextField textfieldFirstName = new JTextField(5);
      JTextField textfieldLastName = new JTextField(5);
      JPanel panelNewEmployee = new JPanel();
      panelNewEmployee.add(new JLabel("Fornavn:"));
      panelNewEmployee.add(textfieldFirstName);
      panelNewEmployee.add(Box.createHorizontalStrut(15));
      panelNewEmployee.add(new JLabel("Etternavn:"));
      panelNewEmployee.add(textfieldLastName);
      
      
      int result = JOptionPane.showConfirmDialog(null, panelNewEmployee, 
               "Skriv inn fornavn og etternavn", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
        errors = this.op.getEmployees().createEmployee(
        textfieldFirstName.getText().trim(), textfieldLastName.getText().trim());  
        this.op.getEmployees().updateGUILists(tableLeft, tableRight);
      }
      if(!errors.isEmpty()){
        showMessageDialog(null, "FEIL: Databasen ikke oppdatert"); 
      }
      else{  
          System.out.println("WOHOOOOO");
      }          
    }//GEN-LAST:event_buttonRegisterNewEmployerActionPerformed

    private void buttonMoveToNotAttendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoveToNotAttendingActionPerformed
        String firstName = (String)tableRight.getModel().getValueAt(tableRight.getSelectedRow(), 1);
        String lastName = (String)tableRight.getModel().getValueAt(tableRight.getSelectedRow(), 2);        
        this.op.getEmployees().moveToNotAttended(firstName, lastName, tableLeft, tableRight);       
    }//GEN-LAST:event_buttonMoveToNotAttendingActionPerformed

    public JTable getTableLeft() {
        return tableLeft;
    }

    public JTable getTableRight() {
        return tableRight;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonMoveToAttending;
    private javax.swing.JButton buttonMoveToNotAttending;
    private javax.swing.JButton buttonRegisterNewEmployer;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JScrollPane tableAttending;
    private javax.swing.JTable tableLeft;
    private javax.swing.JScrollPane tableNotAttending;
    private javax.swing.JTable tableRight;
    // End of variables declaration//GEN-END:variables
}
