/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontend;

import backend.Database;
import backend.Sales;
import backend.Woods;

/**
 *
 * @author Hoxmark
 */
public class MoreInfoOnSale extends javax.swing.JFrame {
     private Sales sales;
     private Woods woods;
    /**
     * Creates new form MoreInfoOnSale
     */
    public MoreInfoOnSale(String customerFirstName, String customerLastName, String phoneNumber, String woodType, 
                          String postnr, String address, String quantity, String postalPlace) {
        initComponents();
        sales = new Sales();
        woods = new Woods(new Database());
        woods.updateWoodList();
        fillInAllData(customerFirstName, customerLastName, phoneNumber, woodType, 
                           postnr,  address,  quantity, postalPlace);
    
         
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        labelDWoodType = new javax.swing.JLabel();
        labelDPrice = new javax.swing.JLabel();
        textFieldPrice = new javax.swing.JTextField();
        textFieldWoodType = new javax.swing.JTextField();
        buttonClose = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                                                .addComponent(textFieldQuantity)
                                                .addComponent(textFieldPrice)
                                                .addComponent(textFieldWoodType)))))))))
                .addContainerGap(72, Short.MAX_VALUE))
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
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelDWoodType)
                    .addComponent(textFieldWoodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDQuanitity)
                    .addComponent(textFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDPrice)
                    .addComponent(textFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        buttonClose.setText("Lukk");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        buttonUpdate.setText("Oppdater");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Vedsalg");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(438, 438, 438)
                .addComponent(buttonClose))
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel1))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(buttonUpdate)
                    .addContainerGap(413, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClose)
                .addGap(0, 44, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(602, Short.MAX_VALUE)
                    .addComponent(buttonUpdate)
                    .addGap(32, 32, 32)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldFirstNameActionPerformed

    private void textFieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAddressActionPerformed

    private void textFieldPostnrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPostnrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostnrActionPerformed

    private void textFieldPostnrFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPostnrFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostnrFocusLost

    private void textFieldPostnrInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textFieldPostnrInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostnrInputMethodTextChanged

    private void textFieldPostnrPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textFieldPostnrPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostnrPropertyChange

    private void textFieldPostPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPostPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPostPlaceActionPerformed

    private void textFieldPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPhoneActionPerformed

    private void textFieldLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldLastNameActionPerformed

    private void textFieldQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldQuantityActionPerformed
       
    }//GEN-LAST:event_textFieldQuantityActionPerformed

    private void textFieldQuantityInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textFieldQuantityInputMethodTextChanged
        //Not in Use
    }//GEN-LAST:event_textFieldQuantityInputMethodTextChanged

    private void textFieldQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldQuantityKeyTyped
        //Not in Use
    }//GEN-LAST:event_textFieldQuantityKeyTyped

    private void textFieldQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldQuantityKeyReleased
       
    }//GEN-LAST:event_textFieldQuantityKeyReleased

    private void textFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPriceActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPriceActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_buttonCloseActionPerformed

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
            java.util.logging.Logger.getLogger(MoreInfoOnSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoreInfoOnSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoreInfoOnSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoreInfoOnSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        System.out.println("MoreInfoOnSale");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MoreInfoOnSale().setVisible(true);
            }
        });
    }
    
    private void fillInAllData(String customerFirstName, String customerLastName, String phoneNumber, String woodType, 
                          String postnr, String address, String quantity, String postalPlace){
        
         textFieldPhone.setText(phoneNumber);
         textFieldPostPlace.setText(postalPlace);
         textFieldLastName.setText(customerLastName);
         textFieldFirstName.setText(customerFirstName);
         textFieldPostnr.setText(postnr);
         textFieldAddress.setText(address);
         textFieldQuantity.setText(quantity);
         textFieldWoodType.setText(woodType);
         textFieldPrice.setText(woods.getPrice(woodType, textFieldQuantity.getText()));
         
         
         System.out.println("fillInAllData OK");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelDAddress;
    private javax.swing.JLabel labelDFirstName;
    private javax.swing.JLabel labelDLastName;
    private javax.swing.JLabel labelDPhone;
    private javax.swing.JLabel labelDPostnr;
    private javax.swing.JLabel labelDPrice;
    private javax.swing.JLabel labelDQuanitity;
    private javax.swing.JLabel labelDWoodType;
    private javax.swing.JTextField textFieldAddress;
    private javax.swing.JTextField textFieldFirstName;
    private javax.swing.JTextField textFieldLastName;
    private javax.swing.JTextField textFieldPhone;
    private javax.swing.JTextField textFieldPostPlace;
    private javax.swing.JTextField textFieldPostnr;
    private javax.swing.JTextField textFieldPrice;
    private javax.swing.JTextField textFieldQuantity;
    private javax.swing.JTextField textFieldWoodType;
    // End of variables declaration//GEN-END:variables
}
