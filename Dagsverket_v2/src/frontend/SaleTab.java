/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontend;

import backend.*;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SaleTab extends javax.swing.JPanel {
    
     private Sales sales;
     private Woods woods;

    /**
     * Creates new form SaleTab
     */
    public SaleTab() {
       
       this.sales = new Sales();
       this.woods = new Woods(new Database());
       this.woods.updateWoodList(); //TODO Flytte til gui 
       initComponents();
       this.sales.updateWoodSaleList(jTable2);

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
        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        buttonUpdateTable = new javax.swing.JButton();
        buttonMoreInfo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        panelRight = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        labelDFirstName = new javax.swing.JLabel();
        textFieldFirstName = new javax.swing.JTextField();
        labelDAddress = new javax.swing.JLabel();
        textFieldAddress = new javax.swing.JTextField();
        labelDPostnr = new javax.swing.JLabel();
        textFieldPostnr = new javax.swing.JTextField();
        textFieldPostPlace = new javax.swing.JTextField();
        textFieldPhone = new javax.swing.JTextField();
        labelDPhone = new javax.swing.JLabel();
        textFieldLastName = new javax.swing.JTextField();
        labelDLastName = new javax.swing.JLabel();
        labelDQuanitity = new javax.swing.JLabel();
        textFieldQuantity = new javax.swing.JTextField();
        comboBoxWoodType = new javax.swing.JComboBox();
        labelDWoodType = new javax.swing.JLabel();
        labelDPrice = new javax.swing.JLabel();
        textFieldPrice = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        labelHeader = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        buttonDone = new javax.swing.JButton();
        buttonAddWoodType = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(1, 0));

        panelLeft.setLayout(new java.awt.BorderLayout());

        jToggleButton1.setText("Old Sale");

        buttonUpdateTable.setText("Oppdater Liste");
        buttonUpdateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateTableActionPerformed(evt);
            }
        });

        buttonMoreInfo.setText("Mer info");
        buttonMoreInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoreInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonUpdateTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(buttonMoreInfo)
                .addGap(41, 41, 41)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUpdateTable)
                    .addComponent(buttonMoreInfo)
                    .addComponent(jToggleButton1))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        panelLeft.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Salg id", "Kjøper", "Antall", "Status"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(60);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelLeft.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(panelLeft);

        panelRight.setLayout(new java.awt.BorderLayout());

        labelDFirstName.setText("Fornavn");

        textFieldFirstName.setToolTipText("");
        textFieldFirstName.setVerifyInputWhenFocusTarget(false);
        textFieldFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldFirstNameActionPerformed(evt);
            }
        });

        labelDAddress.setText("Adresse");

        textFieldAddress.setToolTipText("...");
        textFieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAddressActionPerformed(evt);
            }
        });

        labelDPostnr.setText("Postnr");

        textFieldPostnr.setToolTipText("...");
        textFieldPostnr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPostnrActionPerformed(evt);
            }
        });
        textFieldPostnr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldPostnrFocusLost(evt);
            }
        });
        textFieldPostnr.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                textFieldPostnrInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        textFieldPostnr.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textFieldPostnrPropertyChange(evt);
            }
        });

        textFieldPostPlace.setToolTipText("...");
        textFieldPostPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPostPlaceActionPerformed(evt);
            }
        });

        textFieldPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPhoneActionPerformed(evt);
            }
        });

        labelDPhone.setText("Telefon");

        textFieldLastName.setToolTipText("");
        textFieldLastName.setVerifyInputWhenFocusTarget(false);
        textFieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldLastNameActionPerformed(evt);
            }
        });

        labelDLastName.setText("Etternavn");

        labelDQuanitity.setText("Antall");

        textFieldQuantity.setToolTipText("...");
        textFieldQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldQuantityActionPerformed(evt);
            }
        });
        textFieldQuantity.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                textFieldQuantityInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        textFieldQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldQuantityKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldQuantityKeyReleased(evt);
            }
        });

        comboBoxWoodType.setModel(new javax.swing.DefaultComboBoxModel(
            woods.getWoodsStringList()));
    comboBoxWoodType.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboBoxWoodTypeActionPerformed(evt);
        }
    });

    labelDWoodType.setText("Type");

    labelDPrice.setText("Pris");

    textFieldPrice.setEditable(false);
    textFieldPrice.setToolTipText("...");
    textFieldPrice.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            textFieldPriceActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(78, 78, 78)
                    .addComponent(labelDPhone))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelDLastName)
                                    .addComponent(labelDFirstName))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(labelDPostnr)
                                        .addGap(61, 61, 61)
                                        .addComponent(textFieldPostnr, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(textFieldPostPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(labelDAddress)
                                        .addGap(51, 51, 51)
                                        .addComponent(textFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelDWoodType)
                                            .addComponent(labelDQuanitity)
                                            .addComponent(labelDPrice))
                                        .addGap(64, 64, 64)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(comboBoxWoodType, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(textFieldQuantity)
                                            .addComponent(textFieldPrice)))))))))
            .addContainerGap(59, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelDFirstName)
                .addComponent(textFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(labelDLastName))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(labelDPhone))
                .addComponent(textFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(51, 51, 51)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(labelDAddress))
                .addComponent(textFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(6, 6, 6)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(labelDPostnr))
                .addComponent(textFieldPostnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textFieldPostPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(61, 61, 61)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(comboBoxWoodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(labelDWoodType))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelDQuanitity)
                .addComponent(textFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelDPrice)
                .addComponent(textFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(124, Short.MAX_VALUE))
    );

    panelRight.add(jPanel3, java.awt.BorderLayout.CENTER);

    labelHeader.setFont(new java.awt.Font("Optima", 1, 36)); // NOI18N
    labelHeader.setText("Ved bestilling");
    jPanel4.add(labelHeader);

    panelRight.add(jPanel4, java.awt.BorderLayout.PAGE_START);

    buttonDone.setText("Ferdig");
    buttonDone.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonDoneActionPerformed(evt);
        }
    });

    buttonAddWoodType.setText("Legg til vedtype");
    buttonAddWoodType.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonAddWoodTypeActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(buttonAddWoodType)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
            .addComponent(buttonDone)
            .addGap(46, 46, 46))
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(buttonAddWoodType)
                .addComponent(buttonDone))
            .addContainerGap(49, Short.MAX_VALUE))
    );

    panelRight.add(jPanel5, java.awt.BorderLayout.PAGE_END);

    add(panelRight);
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldQuantityActionPerformed
        textFieldPrice.setText(woods.getPrice(comboBoxWoodType.getSelectedItem().toString(), textFieldQuantity.getText()));
    }//GEN-LAST:event_textFieldQuantityActionPerformed

    private void textFieldPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPhoneActionPerformed

    private void textFieldPostPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPostPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostPlaceActionPerformed

    private void textFieldPostnrPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textFieldPostnrPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostnrPropertyChange

    private void textFieldPostnrInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textFieldPostnrInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostnrInputMethodTextChanged

    private void textFieldPostnrFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPostnrFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostnrFocusLost

    private void textFieldPostnrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPostnrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostnrActionPerformed

    private void textFieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAddressActionPerformed

    private void textFieldFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldFirstNameActionPerformed

    private void textFieldLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldLastNameActionPerformed

    private void textFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPriceActionPerformed
            
        
// TODO add your handling code here:
    }//GEN-LAST:event_textFieldPriceActionPerformed

    private void buttonDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDoneActionPerformed
        ArrayList<Integer> errors = new ArrayList<Integer>();
        labelDPhone.setForeground(Color.black);
        labelDLastName.setForeground(Color.black);
        labelDFirstName.setForeground(Color.black);
        labelDWoodType.setForeground(Color.black);
        labelDPostnr.setForeground(Color.black);
        labelDAddress.setForeground(Color.black);
        labelDQuanitity.setForeground(Color.black);
        
        errors =  sales.createSale(textFieldFirstName.getText().trim(), textFieldLastName.getText().trim(), 
                         textFieldPhone.getText().trim(), (String)comboBoxWoodType.getSelectedItem(),
                         textFieldPostnr.getText().trim(), textFieldAddress.getText().trim(), 
                         textFieldQuantity.getText().trim(), textFieldPostPlace.getText().trim(), "Ikke levert");
       
        
       System.out.println(errors.size());
      
       
       if (errors.isEmpty()){
            System.out.println("Clearing");
            this.sales.updateWoodSaleList(jTable2);
            
            //Clear all the fields
            textFieldPhone.setText("");
            textFieldPostPlace.setText("");
            textFieldLastName.setText("");
            textFieldFirstName.setText("");
            textFieldPostnr.setText("");
            textFieldAddress.setText("");
            textFieldQuantity.setText("");
            textFieldPrice.setText("");
            
       } else {
           for(Integer i : errors){
            if(i == Sales.NO_CUSTOMER_FIRSTNAME){
                labelDFirstName.setForeground(Color.red);
            }
            if(i == Sales.NO_CUSTOMER_LASTNAME){
                labelDLastName.setForeground(Color.red);                            
            }
            
            if(i == Sales.NO_PHONENUMBER){
                labelDPhone.setForeground(Color.red);            
            }
            
            if(i == Sales.WRONG_PHONE_FORMAT){
                labelDPhone.setForeground(Color.red);            
            }
            if(i == Sales.NO_ADDRESS_INFO){
                labelDAddress.setForeground(Color.red);           
            }            
            if(i == Sales.WRONG_POSTALCODE_FORMAT){
                labelDPostnr.setForeground(Color.red);            
            }
            if(i == Sales.WRONG_POSTNUMBER){
                labelDPostnr.setForeground(Color.red);            
            }
            if(i == Sales.WRONG_QUANTITY_FORMAT){
                labelDQuanitity.setForeground(Color.red);            
            }
            if(i == Sales.NO_QUANTITY){
                labelDQuanitity.setForeground(Color.red);            
            } 
        }      
       }       
    }//GEN-LAST:event_buttonDoneActionPerformed

    private void comboBoxWoodTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxWoodTypeActionPerformed
        textFieldPrice.setText(woods.getPrice(comboBoxWoodType.getSelectedItem().toString(), textFieldQuantity.getText()));
    }//GEN-LAST:event_comboBoxWoodTypeActionPerformed

    private void buttonAddWoodTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddWoodTypeActionPerformed
      JTextField textfieldWoodType = new JTextField(10);
      JTextField textfieldPrice = new JTextField(5);
      JTextField textfieldBagSize = new JTextField(5);
      
      JPanel panelWood = new JPanel();
      panelWood.add(new JLabel("Vedtype:"));
      panelWood.add(textfieldWoodType);
      panelWood.add(Box.createHorizontalStrut(15)); // a spacer
      panelWood.add(new JLabel("Bag størrelse:"));
      panelWood.add(textfieldBagSize);
      panelWood.add(Box.createHorizontalStrut(15)); // a spacer
      panelWood.add(new JLabel("Pris:"));
      panelWood.add(textfieldPrice);
      
      
      int result = JOptionPane.showConfirmDialog(null, panelWood, 
            "Skriv inn vedtype, bagstørrelse og pris på den nye vedtypen", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {  
           if (woods.addWood(textfieldWoodType.getText(), textfieldBagSize.getText(),textfieldPrice.getText())){
               DefaultComboBoxModel model = new DefaultComboBoxModel(woods.getWoodsStringList());           
               model.addElement(textfieldWoodType.getText());
               comboBoxWoodType.setModel(model);
           } else {               
            showMessageDialog(null, "Alle feltene må være utfylt","Error",JOptionPane.WARNING_MESSAGE);            
           }
           
      }
      

        
    }//GEN-LAST:event_buttonAddWoodTypeActionPerformed

    private void textFieldQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldQuantityKeyTyped
        //Not in Use
    }//GEN-LAST:event_textFieldQuantityKeyTyped

    private void textFieldQuantityInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textFieldQuantityInputMethodTextChanged
        //Not in Use
    }//GEN-LAST:event_textFieldQuantityInputMethodTextChanged

    private void textFieldQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldQuantityKeyReleased
        textFieldPrice.setText(woods.getPrice(comboBoxWoodType.getSelectedItem().toString(), textFieldQuantity.getText()));
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldQuantityKeyReleased

    private void buttonUpdateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateTableActionPerformed
        this.sales.updateWoodSaleList(jTable2);
        
// TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdateTableActionPerformed

    private void buttonMoreInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoreInfoActionPerformed
        if (jTable2.getSelectedRow()!=-1){
            sales.getMoreInfoFromSale(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString());            
        }
        
        
    }//GEN-LAST:event_buttonMoreInfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddWoodType;
    private javax.swing.JButton buttonDone;
    private javax.swing.JButton buttonMoreInfo;
    private javax.swing.JButton buttonUpdateTable;
    private javax.swing.JComboBox comboBoxWoodType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelDAddress;
    private javax.swing.JLabel labelDFirstName;
    private javax.swing.JLabel labelDLastName;
    private javax.swing.JLabel labelDPhone;
    private javax.swing.JLabel labelDPostnr;
    private javax.swing.JLabel labelDPrice;
    private javax.swing.JLabel labelDQuanitity;
    private javax.swing.JLabel labelDWoodType;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JTextField textFieldAddress;
    private javax.swing.JTextField textFieldFirstName;
    private javax.swing.JTextField textFieldLastName;
    private javax.swing.JTextField textFieldPhone;
    private javax.swing.JTextField textFieldPostPlace;
    private javax.swing.JTextField textFieldPostnr;
    private javax.swing.JTextField textFieldPrice;
    private javax.swing.JTextField textFieldQuantity;
    // End of variables declaration//GEN-END:variables
}
