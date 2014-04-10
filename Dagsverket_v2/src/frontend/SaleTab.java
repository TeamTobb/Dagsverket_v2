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

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class SaleTab extends javax.swing.JPanel {
    
     private Sales sales;
     private Woods woods;
     private Cases cases;
     
     
     private int saleTableView = sales.ALLDELIVERIESVIEW; 

    
    public SaleTab() {
       
       this.sales = new Sales();
       this.woods = new Woods(new Database());
       this.woods.updateWoodList(); //TODO Flytte til gui 
       initComponents();
       this.sales.updateWoodSaleList(jTable2);
       this.cases = new Cases();
       

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorth = new javax.swing.JPanel();
        textHeader = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        panelCenterLeft = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        panelCenterRight = new javax.swing.JPanel();
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
        panelSouth = new javax.swing.JPanel();
        panelSouthLeft = new javax.swing.JPanel();
        ButtonGetURLButton = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonMoreInfo = new javax.swing.JButton();
        buttonDeliver = new javax.swing.JButton();
        comboBoxTableView = new javax.swing.JComboBox();
        panelSouthRight = new javax.swing.JPanel();
        buttonAddWoodType = new javax.swing.JButton();
        buttonDone = new javax.swing.JButton();

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
        textHeader.setText("Ved bestilling");
        panelNorth.add(textHeader);

        add(panelNorth, java.awt.BorderLayout.NORTH);

        panelCenter.setMaximumSize(new java.awt.Dimension(1024, 582));
        panelCenter.setMinimumSize(new java.awt.Dimension(1024, 582));
        panelCenter.setPreferredSize(new java.awt.Dimension(1024, 582));
        panelCenter.setSize(new java.awt.Dimension(1024, 582));
        panelCenter.setLayout(new java.awt.GridLayout(1, 0));

        panelCenterLeft.setLayout(new java.awt.BorderLayout());

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Salg ID", "Kjøper", "Antall", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(60);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(60);
        }
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
        );

        panelCenterLeft.add(jPanel2, java.awt.BorderLayout.CENTER);

        panelCenter.add(panelCenterLeft);

        panelCenterRight.setLayout(new java.awt.BorderLayout());

        labelDFirstName.setText("Fornavn");

        /* limit for hvor mange characters som kan skrives inn */
        textFieldFirstName.setDocument(new JTextFieldLimit(30)); // endre tallet for å endre limit
        textFieldFirstName.setToolTipText("");
        textFieldFirstName.setVerifyInputWhenFocusTarget(false);
        textFieldFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldFirstNameActionPerformed(evt);
            }
        });

        labelDAddress.setText("Adresse");

        /* limit for hvor mange characters som kan skrives inn */
        textFieldAddress.setDocument(new JTextFieldLimit(30)); // endre tallet for å endre limit
        textFieldAddress.setToolTipText("...");
        textFieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAddressActionPerformed(evt);
            }
        });

        labelDPostnr.setText("Postnr");

        /* limit for hvor mange characters som kan skrives inn */
        textFieldPostnr.setDocument(new JTextFieldLimit(4)); // endre tallet for å endre limit
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

        /* limit for hvor mange characters som kan skrives inn */
        textFieldPhone.setDocument(new JTextFieldLimit(8)); // endre tallet for å endre limit
        textFieldPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPhoneActionPerformed(evt);
            }
        });

        labelDPhone.setText("Telefon");

        /* limit for hvor mange characters som kan skrives inn */
        textFieldLastName.setDocument(new JTextFieldLimit(30)); // endre tallet for å endre limit
        textFieldLastName.setToolTipText("");
        textFieldLastName.setVerifyInputWhenFocusTarget(false);
        textFieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldLastNameActionPerformed(evt);
            }
        });

        labelDLastName.setText("Etternavn");

        labelDQuanitity.setText("Antall");

        /* limit for hvor mange characters som kan skrives inn */
        textFieldQuantity.setDocument(new JTextFieldLimit(4)); // endre tallet for å endre limit
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
                    .addGap(76, 76, 76)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelDQuanitity)
                                .addComponent(labelDPrice))
                            .addGap(48, 48, 48)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textFieldQuantity)
                                .addComponent(textFieldPrice)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelDPostnr)
                                        .addComponent(labelDAddress)
                                        .addComponent(labelDPhone)
                                        .addComponent(labelDLastName)
                                        .addComponent(labelDFirstName))
                                    .addGap(40, 40, 40))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(labelDWoodType)
                                    .addGap(49, 49, 49)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(textFieldPostnr, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldPostPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(comboBoxWoodType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(175, 175, 175)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(textFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                            .addComponent(textFieldPhone)
                            .addComponent(textFieldFirstName)))))
            .addContainerGap(78, Short.MAX_VALUE))
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
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(labelDPhone))
            .addGap(51, 51, 51)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(labelDAddress))
                .addComponent(textFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textFieldPostnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldPostPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(labelDPostnr)))
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
            .addContainerGap(176, Short.MAX_VALUE))
    );

    panelCenterRight.add(jPanel3, java.awt.BorderLayout.LINE_START);

    labelHeader.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
    labelHeader.setText("Ny bestilling");
    jPanel4.add(labelHeader);

    panelCenterRight.add(jPanel4, java.awt.BorderLayout.PAGE_START);

    panelCenter.add(panelCenterRight);

    add(panelCenter, java.awt.BorderLayout.CENTER);

    panelSouth.setBackground(new java.awt.Color(153, 153, 153));
    panelSouth.setMaximumSize(new java.awt.Dimension(1024, 62));
    panelSouth.setMinimumSize(new java.awt.Dimension(1024, 62));
    panelSouth.setPreferredSize(new java.awt.Dimension(1024, 62));
    panelSouth.setSize(new java.awt.Dimension(1024, 62));
    panelSouth.setLayout(new java.awt.GridLayout(1, 0));

    panelSouthLeft.setBackground(new java.awt.Color(153, 153, 153));
    panelSouthLeft.setMaximumSize(new java.awt.Dimension(512, 62));
    panelSouthLeft.setMinimumSize(new java.awt.Dimension(512, 62));
    panelSouthLeft.setPreferredSize(new java.awt.Dimension(512, 62));
    panelSouthLeft.setSize(new java.awt.Dimension(512, 62));

    ButtonGetURLButton.setBackground(new java.awt.Color(51, 51, 51));
    ButtonGetURLButton.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
    ButtonGetURLButton.setForeground(new java.awt.Color(204, 204, 204));
    ButtonGetURLButton.setText("Kart");
    ButtonGetURLButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ButtonGetURLButtonActionPerformed(evt);
        }
    });
    panelSouthLeft.add(ButtonGetURLButton);

    buttonDelete.setBackground(new java.awt.Color(51, 51, 51));
    buttonDelete.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
    buttonDelete.setForeground(new java.awt.Color(204, 204, 204));
    buttonDelete.setText("Slett salg ");
    buttonDelete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonDeleteActionPerformed(evt);
        }
    });
    panelSouthLeft.add(buttonDelete);

    buttonMoreInfo.setBackground(new java.awt.Color(51, 51, 51));
    buttonMoreInfo.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
    buttonMoreInfo.setForeground(new java.awt.Color(204, 204, 204));
    buttonMoreInfo.setText("Mer info");
    buttonMoreInfo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonMoreInfoActionPerformed(evt);
        }
    });
    panelSouthLeft.add(buttonMoreInfo);

    buttonDeliver.setBackground(new java.awt.Color(51, 51, 51));
    buttonDeliver.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
    buttonDeliver.setForeground(new java.awt.Color(204, 204, 204));
    buttonDeliver.setText("Levert");
    buttonDeliver.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonDeliverActionPerformed(evt);
        }
    });
    panelSouthLeft.add(buttonDeliver);

    comboBoxTableView.setBackground(new java.awt.Color(51, 51, 51));
    comboBoxTableView.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
    comboBoxTableView.setForeground(new java.awt.Color(204, 204, 204));
    comboBoxTableView.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alle salg", "Levert", "Ikke levert" }));
    comboBoxTableView.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboBoxTableViewActionPerformed(evt);
        }
    });
    panelSouthLeft.add(comboBoxTableView);

    panelSouth.add(panelSouthLeft);

    panelSouthRight.setBackground(new java.awt.Color(153, 153, 153));
    panelSouthRight.setMaximumSize(new java.awt.Dimension(512, 62));
    panelSouthRight.setMinimumSize(new java.awt.Dimension(512, 62));
    panelSouthRight.setSize(new java.awt.Dimension(512, 62));

    buttonAddWoodType.setBackground(new java.awt.Color(51, 51, 51));
    buttonAddWoodType.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
    buttonAddWoodType.setForeground(new java.awt.Color(204, 204, 204));
    buttonAddWoodType.setText("Legg til vedtype");
    buttonAddWoodType.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonAddWoodTypeActionPerformed(evt);
        }
    });
    panelSouthRight.add(buttonAddWoodType);

    buttonDone.setBackground(new java.awt.Color(51, 51, 51));
    buttonDone.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
    buttonDone.setForeground(new java.awt.Color(204, 204, 204));
    buttonDone.setText("Ferdig");
    buttonDone.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonDoneActionPerformed(evt);
        }
    });
    panelSouthRight.add(buttonDone);

    panelSouth.add(panelSouthRight);

    add(panelSouth, java.awt.BorderLayout.SOUTH);
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
        
    }//GEN-LAST:event_textFieldPostnrInputMethodTextChanged

    private void textFieldPostnrFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPostnrFocusLost
        String newAddress = cases.getPostAddressFromDb(textFieldPostnr.getText());
        textFieldPostPlace.setText(newAddress);
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
       
        
       
      
       
       if (errors.isEmpty()){
            
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
      /* limit for hvor mange characters som kan skrives inn */
      textfieldWoodType.setDocument(new JTextFieldLimit(30)); // endre tallet for å endre limit
      /* limit for hvor mange characters som kan skrives inn */
      textfieldPrice.setDocument(new JTextFieldLimit(4)); // endre tallet for å endre limit
      /* limit for hvor mange characters som kan skrives inn */
      textfieldBagSize.setDocument(new JTextFieldLimit(5)); // endre tallet for å endre limit
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

    private void buttonMoreInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoreInfoActionPerformed
        if (jTable2.getSelectedRow()!=-1){
            sales.getMoreInfoFromSale(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString());            
        } else {
            showMessageDialog(null, "Vennligst velg element i tabellen");
        }
        
        
    }//GEN-LAST:event_buttonMoreInfoActionPerformed

    private void buttonDeliverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeliverActionPerformed
       if (jTable2.getSelectedRow()!=-1){
            sales.deliverWood(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString());  
                sales.updateSaleWoodTable(jTable2,saleTableView);
        } else {
            showMessageDialog(null, "Vennligst velg element i tabellen");
        }
        
    }//GEN-LAST:event_buttonDeliverActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        if (jTable2.getSelectedRow()!=-1){
            int result = JOptionPane.showConfirmDialog(null, "Er du sikker på at du ønsker å slette salget? ");            

            if (result == JOptionPane.YES_OPTION){
                sales.deleteSale(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString());
                sales.updateSaleWoodTable(jTable2,saleTableView);

            } 
        } else {
            showMessageDialog(null, "Vennligst velg element i tabellen");
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void comboBoxTableViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTableViewActionPerformed
        
      String view = comboBoxTableView.getSelectedItem().toString(); 
       
      switch (view) {
            case "Alle salg": sales.updateWoodSaleList(jTable2);
                saleTableView = sales.ALLDELIVERIESVIEW;
                     break;
            case "Ikke levert": sales.updateWoodSaleListDelivered(jTable2, "Ikke levert");  
                saleTableView = sales.NOTDELIVEREDVIEW; 
                     break;
            case "Levert":  sales.updateWoodSaleListDelivered(jTable2,"levert");
                saleTableView = sales.DELIVEREDVIEW; 
                     break;
            default: showMessageDialog(null,"Default kjørt"); //TODO
                     break;
      }
      
    

        
    }//GEN-LAST:event_comboBoxTableViewActionPerformed

    private void ButtonGetURLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGetURLButtonActionPerformed
        if (jTable2.getSelectedRow()!=-1){
            sales.getURLToMap(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString());            
        } else {
            showMessageDialog(null, "Vennligst velg element i tabellen");
        }
        
        
    }//GEN-LAST:event_ButtonGetURLButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonGetURLButton;
    private javax.swing.JButton buttonAddWoodType;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonDeliver;
    private javax.swing.JButton buttonDone;
    private javax.swing.JButton buttonMoreInfo;
    private javax.swing.JComboBox comboBoxTableView;
    private javax.swing.JComboBox comboBoxWoodType;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel labelDAddress;
    private javax.swing.JLabel labelDFirstName;
    private javax.swing.JLabel labelDLastName;
    private javax.swing.JLabel labelDPhone;
    private javax.swing.JLabel labelDPostnr;
    private javax.swing.JLabel labelDPrice;
    private javax.swing.JLabel labelDQuanitity;
    private javax.swing.JLabel labelDWoodType;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelCenterLeft;
    private javax.swing.JPanel panelCenterRight;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelSouth;
    private javax.swing.JPanel panelSouthLeft;
    private javax.swing.JPanel panelSouthRight;
    private javax.swing.JTextField textFieldAddress;
    private javax.swing.JTextField textFieldFirstName;
    private javax.swing.JTextField textFieldLastName;
    private javax.swing.JTextField textFieldPhone;
    private javax.swing.JTextField textFieldPostPlace;
    private javax.swing.JTextField textFieldPostnr;
    private javax.swing.JTextField textFieldPrice;
    private javax.swing.JTextField textFieldQuantity;
    private javax.swing.JLabel textHeader;
    // End of variables declaration//GEN-END:variables
}
