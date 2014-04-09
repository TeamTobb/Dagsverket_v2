package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class AttendanceTab extends javax.swing.JPanel {
    private Employees employees;
    /**
     * Creates new form AttendanceTab
     */
    public AttendanceTab() {
        this.employees = new Employees();
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

        panelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelBottom = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        tableAttending = new javax.swing.JScrollPane();
        tableRight = new javax.swing.JTable();
        panelCenter = new javax.swing.JPanel();
        buttonMoveToAttending = new javax.swing.JButton();
        buttonMoveToNotAttending = new javax.swing.JButton();
        buttonRegisterNewEmployer = new javax.swing.JButton();
        panelLeft = new javax.swing.JPanel();
        tableNotAttending = new javax.swing.JScrollPane();
        tableLeft = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 0));
        setPreferredSize(new java.awt.Dimension(1024, 690));
        setLayout(new java.awt.BorderLayout());

        panelTop.setMaximumSize(new java.awt.Dimension(1024, 62));
        panelTop.setMinimumSize(new java.awt.Dimension(1024, 62));
        panelTop.setPreferredSize(new java.awt.Dimension(1024, 62));
        panelTop.setRequestFocusEnabled(false);
        panelTop.setSize(new java.awt.Dimension(1024, 62));

        jLabel1.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel1.setText("Registrer oppmøte");

        jLabel2.setFont(new java.awt.Font("Optima", 1, 14)); // NOI18N
        jLabel2.setText("Oppmøtte arbeidstaker");

        jLabel3.setFont(new java.awt.Font("Optima", 1, 14)); // NOI18N
        jLabel3.setText("Alle arbeidstakere");

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 507, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(125, 125, 125))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        add(panelTop, java.awt.BorderLayout.NORTH);

        panelBottom.setLayout(new java.awt.BorderLayout());

        panelRight.setPreferredSize(new java.awt.Dimension(425, 690));
        panelRight.setLayout(new javax.swing.BoxLayout(panelRight, javax.swing.BoxLayout.LINE_AXIS));

        tableRight.setAutoCreateRowSorter(true);
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
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableAttending.setViewportView(tableRight);
        tableRight.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panelRight.add(tableAttending);

        panelBottom.add(panelRight, java.awt.BorderLayout.EAST);

        panelCenter.setPreferredSize(new java.awt.Dimension(174, 690));

        buttonMoveToAttending.setBackground(new java.awt.Color(51, 51, 51));
        buttonMoveToAttending.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonMoveToAttending.setForeground(new java.awt.Color(204, 204, 204));
        buttonMoveToAttending.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrowRight.png"))); // NOI18N
        buttonMoveToAttending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoveToAttendingActionPerformed(evt);
            }
        });

        buttonMoveToNotAttending.setBackground(new java.awt.Color(51, 51, 51));
        buttonMoveToNotAttending.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        buttonMoveToNotAttending.setForeground(new java.awt.Color(204, 204, 204));
        buttonMoveToNotAttending.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrowLeft.png"))); // NOI18N
        buttonMoveToNotAttending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoveToNotAttendingActionPerformed(evt);
            }
        });

        buttonRegisterNewEmployer.setBackground(new java.awt.Color(51, 51, 51));
        buttonRegisterNewEmployer.setFont(new java.awt.Font("Optima", 1, 14)); // NOI18N
        buttonRegisterNewEmployer.setForeground(new java.awt.Color(204, 204, 204));
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
                .addContainerGap()
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonRegisterNewEmployer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelCenterLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonMoveToNotAttending, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonMoveToAttending, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCenterLayout.setVerticalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(buttonMoveToAttending, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMoveToNotAttending, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRegisterNewEmployer, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        panelBottom.add(panelCenter, java.awt.BorderLayout.CENTER);

        panelLeft.setPreferredSize(new java.awt.Dimension(425, 690));
        panelLeft.setLayout(new javax.swing.BoxLayout(panelLeft, javax.swing.BoxLayout.LINE_AXIS));

        tableLeft.setAutoCreateRowSorter(true);
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
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableNotAttending.setViewportView(tableLeft);
        tableLeft.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panelLeft.add(tableNotAttending);

        panelBottom.add(panelLeft, java.awt.BorderLayout.WEST);

        add(panelBottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMoveToAttendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoveToAttendingActionPerformed
        try{
            int employeeId = (int)tableLeft.getModel().getValueAt(tableLeft.getSelectedRow(), 0);                 
            this.employees.moveToAttended(employeeId, tableLeft, tableRight);
        }catch(ArrayIndexOutOfBoundsException e){
            showMessageDialog(null, "Vennligst velg en arbeider");
        }
       
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
      textfieldFirstName.setDocument(new JTextFieldLimit(29)); // endre tallet for å endre limit
      textfieldLastName.setDocument(new JTextFieldLimit(29)); // endre tallet for å endre limit
      int result = JOptionPane.showConfirmDialog(null, panelNewEmployee, 
               "Skriv inn fornavn og etternavn", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) { 
          if(textfieldFirstName.getText().trim().equals("") || textfieldLastName.getText().trim().equals("")){
              showMessageDialog(null, "Vennligst skriv inn minst én bokstav i hvert felt");
          }
          else{
            errors = this.employees.createEmployee(
            textfieldFirstName.getText().trim(), textfieldLastName.getText().trim());  
            this.employees.updateGUILists(tableLeft, tableRight);                        
          }
      }
      if(!errors.isEmpty()){
        showMessageDialog(null, "FEIL: Databasen ikke oppdatert"); 
      }
      else{            
      }          
    }//GEN-LAST:event_buttonRegisterNewEmployerActionPerformed

    private void buttonMoveToNotAttendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoveToNotAttendingActionPerformed
        try{
            int employeeId = (int)tableRight.getModel().getValueAt(tableRight.getSelectedRow(), 0);
            this.employees.moveToNotAttended(employeeId, tableLeft, tableRight);       
        }catch(ArrayIndexOutOfBoundsException e){
            showMessageDialog(null, "Vennligst velg en arbeider");
        }       
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelTop;
    private javax.swing.JScrollPane tableAttending;
    private javax.swing.JTable tableLeft;
    private javax.swing.JScrollPane tableNotAttending;
    private javax.swing.JTable tableRight;
    // End of variables declaration//GEN-END:variables
}
