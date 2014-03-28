/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontend;
import backend.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Jorgen
 */
public class CreateCaseTab extends javax.swing.JPanel {
    private Operator op;
    private Cases cases;

    /**
     * Creates new form CreateCaseTab
     */
    public CreateCaseTab(Operator op) {
        this.op = op;
        this.cases = new Cases(op.getDb());
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

        labelCreateCaseDName = new javax.swing.JLabel();
        labelCreateCaseName = new javax.swing.JLabel();
        labelCreateCaseDNameHeader = new javax.swing.JLabel();
        labelCreateCaseHeader = new javax.swing.JLabel();
        comboBoxCreateCaseSupervisor = new javax.swing.JComboBox();
        labelCreateCaseDSupervisor = new javax.swing.JLabel();
        labelCreateCaseDSupervisorHeader = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        labelDDate = new javax.swing.JLabel();
        labelCustomerDFirstName = new javax.swing.JLabel();
        textFieldCustomerFirstName = new javax.swing.JTextField();
        labelDAddress = new javax.swing.JLabel();
        textFieldAddress = new javax.swing.JTextField();
        textFieldPostPlace = new javax.swing.JTextField();
        textFieldPostalCode = new javax.swing.JTextField();
        labelDPostalCode = new javax.swing.JLabel();
        textFieldPhone = new javax.swing.JTextField();
        labelDPhone = new javax.swing.JLabel();
        labelDSubject = new javax.swing.JLabel();
        textFieldSubject = new javax.swing.JTextField();
        labelDReqDate = new javax.swing.JLabel();
        labelCreateCaseDReqTime = new javax.swing.JLabel();
        ComboBoxCreateCaseReqTime = new javax.swing.JComboBox();
        labelCreateCaseReqDate = new javax.swing.JLabel();
        labelDDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDescription = new javax.swing.JTextArea();
        labelDPrice = new javax.swing.JLabel();
        textFieldPrice = new javax.swing.JTextField();
        labelCreateCaseDInspectDate = new javax.swing.JLabel();
        labelCreateCaseInspectDate = new javax.swing.JLabel();
        labelDStartDate = new javax.swing.JLabel();
        labelDEquipment = new javax.swing.JLabel();
        labelDContacts = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textAreaContacts = new javax.swing.JTextArea();
        labelDStatus = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox();
        buttonComplete = new javax.swing.JButton();
        labelCreateCaseStartDate = new javax.swing.JLabel();
        dateFieldInspectDate = new com.toedter.calendar.JDateChooser();
        dateFieldReqDate = new com.toedter.calendar.JDateChooser();
        dateFieldStartDate = new com.toedter.calendar.JDateChooser();
        textFieldCustomerLastName = new javax.swing.JTextField();
        labelCustomerDLastName = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        textAreaToolList = new javax.swing.JTextArea();

        setLayout(null);

        labelCreateCaseDName.setText("Navn:");
        add(labelCreateCaseDName);
        labelCreateCaseDName.setBounds(54, 74, 36, 16);

        labelCreateCaseName.setText(op.getUser().toString());
        add(labelCreateCaseName);
        labelCreateCaseName.setBounds(164, 74, 84, 16);

        labelCreateCaseDNameHeader.setText("Mottatt av:");
        add(labelCreateCaseDNameHeader);
        labelCreateCaseDNameHeader.setBounds(54, 44, 68, 16);

        labelCreateCaseHeader.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelCreateCaseHeader.setText("Nytt oppdrag ");
        add(labelCreateCaseHeader);
        labelCreateCaseHeader.setBounds(84, 14, 135, 29);

        comboBoxCreateCaseSupervisor.setModel(new javax.swing.DefaultComboBoxModel(op.getUsers().getUsers()));
        comboBoxCreateCaseSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCreateCaseSupervisorActionPerformed(evt);
            }
        });
        add(comboBoxCreateCaseSupervisor);
        comboBoxCreateCaseSupervisor.setBounds(334, 64, 210, 27);

        labelCreateCaseDSupervisor.setText("Navn:");
        add(labelCreateCaseDSupervisor);
        labelCreateCaseDSupervisor.setBounds(294, 74, 36, 16);

        labelCreateCaseDSupervisorHeader.setText("Utføres av:");
        add(labelCreateCaseDSupervisorHeader);
        labelCreateCaseDSupervisorHeader.setBounds(294, 44, 68, 16);

        labelDate.setText("Insert date" );
        add(labelDate);
        labelDate.setBounds(164, 131, 84, 16);

        labelDDate.setText("Dato:");
        add(labelDDate);
        labelDDate.setBounds(54, 131, 34, 16);

        labelCustomerDFirstName.setText("Kunde:");
        add(labelCustomerDFirstName);
        labelCustomerDFirstName.setBounds(40, 160, 43, 16);

        textFieldCustomerFirstName.setToolTipText("");
        textFieldCustomerFirstName.setVerifyInputWhenFocusTarget(false);
        textFieldCustomerFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCustomerFirstNameActionPerformed(evt);
            }
        });
        add(textFieldCustomerFirstName);
        textFieldCustomerFirstName.setBounds(135, 151, 90, 28);

        labelDAddress.setText("Adresse");
        add(labelDAddress);
        labelDAddress.setBounds(34, 186, 50, 16);

        textFieldAddress.setToolTipText("...");
        textFieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAddressActionPerformed(evt);
            }
        });
        add(textFieldAddress);
        textFieldAddress.setBounds(135, 180, 274, 28);

        textFieldPostPlace.setText("updateOnPostnr");
        textFieldPostPlace.setToolTipText("...");
        textFieldPostPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPostPlaceActionPerformed(evt);
            }
        });
        add(textFieldPostPlace);
        textFieldPostPlace.setBounds(233, 214, 177, 28);

        textFieldPostalCode.setToolTipText("...");
        textFieldPostalCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldPostalCodeFocusLost(evt);
            }
        });
        textFieldPostalCode.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                textFieldPostalCodeInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        textFieldPostalCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPostalCodeActionPerformed(evt);
            }
        });
        textFieldPostalCode.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textFieldPostalCodePropertyChange(evt);
            }
        });
        add(textFieldPostalCode);
        textFieldPostalCode.setBounds(135, 214, 92, 28);

        labelDPostalCode.setText("Postnr");
        add(labelDPostalCode);
        labelDPostalCode.setBounds(34, 221, 40, 16);

        textFieldPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPhoneActionPerformed(evt);
            }
        });
        add(textFieldPhone);
        textFieldPhone.setBounds(135, 248, 270, 28);

        labelDPhone.setText("Telefon:");
        add(labelDPhone);
        labelDPhone.setBounds(34, 254, 51, 16);

        labelDSubject.setText("Arbeidets art:");
        add(labelDSubject);
        labelDSubject.setBounds(34, 338, 85, 16);

        textFieldSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSubjectActionPerformed(evt);
            }
        });
        add(textFieldSubject);
        textFieldSubject.setBounds(135, 332, 275, 28);

        labelDReqDate.setText("Ønsket oppstart:");
        add(labelDReqDate);
        labelDReqDate.setBounds(34, 384, 106, 16);

        labelCreateCaseDReqTime.setText("Kl.");
        add(labelCreateCaseDReqTime);
        labelCreateCaseDReqTime.setBounds(417, 381, 20, 16);

        String[] tider = new String[48];
        int teller = 0;
        String time = "";
        String minutt = "";
        for(int i = 0; i<24; i++){
            for(int j = 0; j<31; j+=30){
                time = String.valueOf(i);
                if(i<10){
                    time ="0"+time;
                }
                minutt = String.valueOf(j);
                if(j==0){
                    minutt += "0";
                }
                tider[teller] = time + ":" + minutt;
                teller++;
            }
        }
        ComboBoxCreateCaseReqTime.setModel(new javax.swing.DefaultComboBoxModel(tider));
        ComboBoxCreateCaseReqTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCreateCaseReqTimeActionPerformed(evt);
            }
        });
        add(ComboBoxCreateCaseReqTime);
        ComboBoxCreateCaseReqTime.setBounds(437, 381, 72, 27);
        add(labelCreateCaseReqDate);
        labelCreateCaseReqDate.setBounds(287, 391, 120, 16);

        labelDDescription.setText("Beskrivelse / Annet:");
        add(labelDDescription);
        labelDDescription.setBounds(34, 441, 126, 16);

        textAreaDescription.setColumns(20);
        textAreaDescription.setRows(5);
        jScrollPane1.setViewportView(textAreaDescription);

        add(jScrollPane1);
        jScrollPane1.setBounds(136, 470, 350, 160);

        labelDPrice.setText("Pris:");
        add(labelDPrice);
        labelDPrice.setBounds(564, 34, 27, 16);

        textFieldPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPriceActionPerformed(evt);
            }
        });
        add(textFieldPrice);
        textFieldPrice.setBounds(724, 34, 90, 28);

        labelCreateCaseDInspectDate.setText("Befaring: ");
        add(labelCreateCaseDInspectDate);
        labelCreateCaseDInspectDate.setBounds(564, 74, 80, 16);
        add(labelCreateCaseInspectDate);
        labelCreateCaseInspectDate.setBounds(826, 84, 210, 20);

        labelDStartDate.setText("Avtalt oppstart:");
        add(labelDStartDate);
        labelDStartDate.setBounds(564, 151, 98, 16);

        labelDEquipment.setText("Utstyrsliste:");
        add(labelDEquipment);
        labelDEquipment.setBounds(564, 191, 76, 16);

        labelDContacts.setText("Kontaktpersoner:");
        add(labelDContacts);
        labelDContacts.setBounds(570, 310, 108, 16);

        textAreaContacts.setColumns(20);
        textAreaContacts.setRows(5);
        jScrollPane7.setViewportView(textAreaContacts);

        add(jScrollPane7);
        jScrollPane7.setBounds(700, 300, 270, 100);

        labelDStatus.setText("Status:");
        add(labelDStatus);
        labelDStatus.setBounds(564, 421, 60, 16);

        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Uferdig", "Aktiv", "Ferdig" }));
        add(comboBoxStatus);
        comboBoxStatus.setBounds(684, 421, 102, 27);

        buttonComplete.setText("Ferdig");
        buttonComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCompleteActionPerformed(evt);
            }
        });
        add(buttonComplete);
        buttonComplete.setBounds(684, 581, 260, 50);
        add(labelCreateCaseStartDate);
        labelCreateCaseStartDate.setBounds(734, 151, 210, 20);
        add(dateFieldInspectDate);
        dateFieldInspectDate.setBounds(710, 70, 123, 28);
        add(dateFieldReqDate);
        dateFieldReqDate.setBounds(158, 379, 210, 28);
        add(dateFieldStartDate);
        dateFieldStartDate.setBounds(670, 140, 123, 28);

        textFieldCustomerLastName.setToolTipText("");
        textFieldCustomerLastName.setVerifyInputWhenFocusTarget(false);
        textFieldCustomerLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCustomerLastNameActionPerformed(evt);
            }
        });
        add(textFieldCustomerLastName);
        textFieldCustomerLastName.setBounds(330, 150, 90, 28);

        labelCustomerDLastName.setText("etternavn");
        add(labelCustomerDLastName);
        labelCustomerDLastName.setBounds(240, 150, 80, 16);

        textAreaToolList.setColumns(20);
        textAreaToolList.setRows(5);
        jScrollPane8.setViewportView(textAreaToolList);

        add(jScrollPane8);
        jScrollPane8.setBounds(700, 190, 270, 100);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxCreateCaseSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCreateCaseSupervisorActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCreateCaseSupervisorActionPerformed

    private void textFieldCustomerFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCustomerFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCustomerFirstNameActionPerformed

    private void textFieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAddressActionPerformed

    private void textFieldPostPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPostPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostPlaceActionPerformed

    private void textFieldPostalCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPostalCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostalCodeActionPerformed

    private void textFieldPostalCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPostalCodeFocusLost
        // TODO add your handling code here:
        textFieldPostPlace.setText(textFieldPostalCode.getText());
        // set Field ut i fra postnr = poststed i database!!!
    }//GEN-LAST:event_textFieldPostalCodeFocusLost

    private void textFieldPostalCodeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textFieldPostalCodeInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostalCodeInputMethodTextChanged

    private void textFieldPostalCodePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textFieldPostalCodePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostalCodePropertyChange

    private void textFieldPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPhoneActionPerformed

    private void textFieldSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSubjectActionPerformed

    private void calCreateCaseReqDateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_calCreateCaseReqDateStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_calCreateCaseReqDateStateChanged

    private void calCreateCaseReqDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calCreateCaseReqDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calCreateCaseReqDateActionPerformed

    private void calCreateCaseReqDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calCreateCaseReqDatePropertyChange
        if (evt.getNewValue() instanceof Date){
            Date dato = (Date)evt.getNewValue();
            System.out.println(dato.toString());
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
            String date = DATE_FORMAT.format(dato);
            labelCreateCaseReqDate.setText(date);
        }
    }//GEN-LAST:event_calCreateCaseReqDatePropertyChange

    private void ComboBoxCreateCaseReqTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCreateCaseReqTimeActionPerformed
        System.out.println(ComboBoxCreateCaseReqTime.getSelectedItem());        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxCreateCaseReqTimeActionPerformed

    private void textFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPriceActionPerformed

    private void calCreateCaseInspectDateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_calCreateCaseInspectDateStateChanged

    }//GEN-LAST:event_calCreateCaseInspectDateStateChanged

    private void calCreateCaseInspectDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calCreateCaseInspectDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calCreateCaseInspectDateActionPerformed

    private void calCreateCaseInspectDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calCreateCaseInspectDatePropertyChange
        if (evt.getNewValue() instanceof Date){
            Date dato = (Date)evt.getNewValue();
            System.out.println(dato.toString());
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
            String date = DATE_FORMAT.format(dato);
            labelCreateCaseInspectDate.setText(date);
        }
    }//GEN-LAST:event_calCreateCaseInspectDatePropertyChange

    private void calCreateCaseStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calCreateCaseStartDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calCreateCaseStartDateActionPerformed

    private void calCreateCaseStartDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calCreateCaseStartDatePropertyChange
        if (evt.getNewValue() instanceof Date){
            Date dato = (Date)evt.getNewValue();
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
            String date = DATE_FORMAT.format(dato);
            labelCreateCaseStartDate.setText(date);
        }
    }//GEN-LAST:event_calCreateCaseStartDatePropertyChange

    private void buttonCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCompleteActionPerformed
        Date reqDate = dateFieldReqDate.getDate();
        Date inspectDate = dateFieldInspectDate.getDate();
        Date startDate = dateFieldStartDate.getDate();
        
        String reqDateString = String.format("%1$td-%1$tm-%1$tY", reqDate);
        String inspectDateString = String.format("%1$td-%1$tm-%1$tY", inspectDate);
        String startDateString = String.format("%1$td-%1$tm-%1$tY", startDate);
        
        ArrayList<Integer> errors = this.cases.createCase(
        op.getUser().getId(),
        textFieldCustomerFirstName.getText().trim(),
        textFieldCustomerLastName.getText().trim(),
        textFieldAddress.getText().trim(),
        textFieldPostalCode.getText().trim(),
        textFieldPostPlace.getText().trim(),
        textFieldPhone.getText().trim(),
        textFieldSubject.getText().trim(),
        reqDateString,
        ComboBoxCreateCaseReqTime.getSelectedItem().toString(),
        textAreaDescription.getText().trim(),
        op.getUsers().getUserIdByFullName(comboBoxCreateCaseSupervisor.getSelectedItem().toString()),
        textFieldPrice.getText().trim(),
        inspectDateString,
        startDateString,
        textAreaToolList.getText().trim(),
        textAreaContacts.getText().trim(),
        comboBoxStatus.getSelectedItem().toString()
        );
        
        labelCustomerDFirstName.setForeground(Color.black);
        labelCustomerDLastName.setForeground(Color.black);                            
       // labelCustomerDFirstName.setForeground(Color.red);            
        labelDSubject.setForeground(Color.black);            
        labelDPhone.setForeground(Color.black);           
        labelDPostalCode.setForeground(Color.black);            
        labelDPrice.setForeground(Color.black);                            
        for(Integer i : errors){
            if(i == Cases.NO_CONTRACTOR_FIRSTNAME){
                labelCustomerDFirstName.setForeground(Color.red);
            }
            if(i == Cases.NO_CONTRACTOR_LASTNAME){
                labelCustomerDLastName.setForeground(Color.red);                            
            }
            if(i == Cases.NO_CONTACT_INFO){
               // labelCustomerDFirstName.setForeground(Color.red);            
            }
            if(i == Cases.NO_SUBJECT){
                labelDSubject.setForeground(Color.red);            
            }
            if(i == Cases.WRONG_PHONE_FORMAT){
                labelDPhone.setForeground(Color.red);           
            }
            if(i == Cases.WRONG_POSTALCODE_FORMAT){
                labelDPostalCode.setForeground(Color.red);            
            }
            if(i == Cases.WRONG_PRICE_FORMAT){
                labelDPrice.setForeground(Color.red);            
            }
        }
    }//GEN-LAST:event_buttonCompleteActionPerformed

    private void textFieldCustomerLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCustomerLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCustomerLastNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxCreateCaseReqTime;
    private javax.swing.JButton buttonComplete;
    private javax.swing.JComboBox comboBoxCreateCaseSupervisor;
    private javax.swing.JComboBox comboBoxStatus;
    private com.toedter.calendar.JDateChooser dateFieldInspectDate;
    private com.toedter.calendar.JDateChooser dateFieldReqDate;
    private com.toedter.calendar.JDateChooser dateFieldStartDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel labelCreateCaseDInspectDate;
    private javax.swing.JLabel labelCreateCaseDName;
    private javax.swing.JLabel labelCreateCaseDNameHeader;
    private javax.swing.JLabel labelCreateCaseDReqTime;
    private javax.swing.JLabel labelCreateCaseDSupervisor;
    private javax.swing.JLabel labelCreateCaseDSupervisorHeader;
    private javax.swing.JLabel labelCreateCaseHeader;
    private javax.swing.JLabel labelCreateCaseInspectDate;
    private javax.swing.JLabel labelCreateCaseName;
    private javax.swing.JLabel labelCreateCaseReqDate;
    private javax.swing.JLabel labelCreateCaseStartDate;
    private javax.swing.JLabel labelCustomerDFirstName;
    private javax.swing.JLabel labelCustomerDLastName;
    private javax.swing.JLabel labelDAddress;
    private javax.swing.JLabel labelDContacts;
    private javax.swing.JLabel labelDDate;
    private javax.swing.JLabel labelDDescription;
    private javax.swing.JLabel labelDEquipment;
    private javax.swing.JLabel labelDPhone;
    private javax.swing.JLabel labelDPostalCode;
    private javax.swing.JLabel labelDPrice;
    private javax.swing.JLabel labelDReqDate;
    private javax.swing.JLabel labelDStartDate;
    private javax.swing.JLabel labelDStatus;
    private javax.swing.JLabel labelDSubject;
    private javax.swing.JLabel labelDate;
    private javax.swing.JTextArea textAreaContacts;
    private javax.swing.JTextArea textAreaDescription;
    private javax.swing.JTextArea textAreaToolList;
    private javax.swing.JTextField textFieldAddress;
    private javax.swing.JTextField textFieldCustomerFirstName;
    private javax.swing.JTextField textFieldCustomerLastName;
    private javax.swing.JTextField textFieldPhone;
    private javax.swing.JTextField textFieldPostPlace;
    private javax.swing.JTextField textFieldPostalCode;
    private javax.swing.JTextField textFieldPrice;
    private javax.swing.JTextField textFieldSubject;
    // End of variables declaration//GEN-END:variables
}
