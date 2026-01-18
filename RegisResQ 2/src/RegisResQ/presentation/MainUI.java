package RegisResQ.presentation;

import RegisResQ.application.Animal;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import RegisResQ.application.*;
import RegisResQ.persistence.*;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import java.util.List;
import RegisResQ.application.*;
import java.util.*;

/**
 * MainUI is the primary graphical user interface (GUI) class for the RegisResQ
 * application. It allows users to view, add, modify, and delete records of
 * adoptable pets. The interface includes a JTable for displaying animal records
 * and various input components such as text fields, combo boxes, and buttons.
 *
 * <p>
 * This class satisfies accessibility and usability requirements, including
 * support for keyboard mnemonics, full-row selection in the table, and
 * intuitive focus behavior.
 * </p>
 *
 * <p>
 * Author: Dylan Forbord
 * </p>
 */
public class MainUI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainUI.class.getName());

    private List<Animal> animals;
    private AnimalTableModel model;
    private AnimalDao dao = new AnimalDao();
    private int selectedRow = -1;

    /**
     * Constructs the MainUI window and initializes all user interface
     * components. Loads animal data from the database and configures UI
     * behavior such as keyboard mnemonics, column widths, table listeners, and
     * input focus events.
     */
    public MainUI() {
        initComponents();
        setLocationRelativeTo(null);

        // Loads animals from database
        animals = dao.getAll(); // dao is AnimalDao declared as a private field
        model = new AnimalTableModel();
        model.setAnimals(animals);
        jTable1.setModel(model);
        model.fireTableDataChanged();

        // Adjust Column Widths
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);

        // Full-row selection
        jTable1.setColumnSelectionAllowed(false);
        jTable1.setRowSelectionAllowed(true);

        // Populates text fields and combo boxes when row is clicked
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selectedRow = row;

                    BreedTxtFld.setText(model.getValueAt(row, 1).toString());
                    NameTxtFld.setText(model.getValueAt(row, 2).toString());

                    // Date into year-month-day
                    String date = model.getValueAt(row, 4).toString();
                    String[] parts = date.split("-");
                    YearTxtFld.setText(parts[0]);
                    MonthtxtFld.setText(parts[1]);
                    DayTxtFld.setText(parts[2]);

                    // Combo boxes
                    typeCombo.setSelectedItem(model.getValueAt(row, 0).toString());
                    snCombo.setSelectedItem(model.getValueAt(row, 3).toString());
                }
            }
        });

        // Set Mnemonics for Labels
        NameLbl.setDisplayedMnemonic('n');
        NameLbl.setLabelFor(NameTxtFld);

        BreedLbl.setDisplayedMnemonic('b');
        BreedLbl.setLabelFor(BreedTxtFld);

        ArrDateLbl.setDisplayedMnemonic('d');
        ArrDateLbl.setLabelFor(MonthtxtFld);

        TypeLbl.setDisplayedMnemonic('t');
        TypeLbl.setLabelFor(typeCombo);

        SNLbl.setDisplayedMnemonic('s');
        SNLbl.setLabelFor(snCombo);

        // Set Mnemonics for Buttons
        addBtn.setMnemonic('a');
        modifyBtn.setMnemonic('m');
        deleteBtn.setMnemonic('d');
        exitBtn.setMnemonic('x');
        clearBtn.setMnemonic('c');

        // Set Mnemonic for Menu
        fileButton.setMnemonic('f');
        exitMenuItem.setMnemonic('x');

        // Add Focus Listeners to date fields
        MonthtxtFld.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (MonthtxtFld.getText().equals("MM")) {
                    MonthtxtFld.selectAll();
                }
            }
        });

        DayTxtFld.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (DayTxtFld.getText().equals("DD")) {
                    DayTxtFld.selectAll();
                }
            }
        });

        YearTxtFld.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (YearTxtFld.getText().equals("YYYY")) {
                    YearTxtFld.selectAll();
                }
            }
        });
    }

    /**
     * Clears all input fields and resets combo boxes to their default values.
     * Used after adding, modifying, or deleting a record to reset the form.
     */
    private void clearFields() {
        NameTxtFld.setText("");
        BreedTxtFld.setText("");
        DayTxtFld.setText("DD");
        MonthtxtFld.setText("MM");
        YearTxtFld.setText("YYYY");
        typeCombo.setSelectedIndex(0);
        snCombo.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPanel = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        NameLbl = new javax.swing.JLabel();
        BreedLbl = new javax.swing.JLabel();
        ArrDateLbl = new javax.swing.JLabel();
        TypeLbl = new javax.swing.JLabel();
        SNLbl = new javax.swing.JLabel();
        NameTxtFld = new javax.swing.JTextField();
        BreedTxtFld = new javax.swing.JTextField();
        MonthtxtFld = new javax.swing.JTextField();
        DayTxtFld = new javax.swing.JTextField();
        YearTxtFld = new javax.swing.JTextField();
        typeCombo = new javax.swing.JComboBox<>();
        snCombo = new javax.swing.JComboBox<>();
        addBtn = new javax.swing.JButton();
        modifyBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        fileMenu = new javax.swing.JMenuBar();
        fileButton = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RegisResQ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Type", "Breed", "Name", "Sterilized", "Arrived"
            }
        ));
        jScrollPanel.setViewportView(jTable1);

        NameLbl.setText("Name");

        BreedLbl.setText("Breed");

        ArrDateLbl.setText("Arrival Date");

        TypeLbl.setText("Type of Animal");

        SNLbl.setText("Spayed/Neutered");

        NameTxtFld.setToolTipText("");

        BreedTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BreedTxtFldActionPerformed(evt);
            }
        });

        MonthtxtFld.setText("MM");
        MonthtxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthtxtFldActionPerformed(evt);
            }
        });

        DayTxtFld.setText("DD");

        YearTxtFld.setText("YYYY");
        YearTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearTxtFldActionPerformed(evt);
            }
        });

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dog", "Cat" }));

        snCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        modifyBtn.setText("Modify");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        fileButton.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileButton.add(exitMenuItem);

        fileMenu.add(fileButton);

        setJMenuBar(fileMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ArrDateLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MonthtxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DayTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(YearTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TypeLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SNLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(snCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(modifyBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(exitBtn))
                        .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BreedLbl)
                            .addGap(30, 30, 30)
                            .addComponent(BreedTxtFld))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(NameLbl)
                            .addGap(30, 30, 30)
                            .addComponent(NameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLbl)
                    .addComponent(NameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BreedLbl)
                    .addComponent(BreedTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArrDateLbl)
                    .addComponent(MonthtxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DayTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(YearTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TypeLbl)
                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SNLbl)
                    .addComponent(snCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(modifyBtn)
                    .addComponent(deleteBtn)
                    .addComponent(exitBtn))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void MonthtxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthtxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonthtxtFldActionPerformed

    private void BreedTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BreedTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BreedTxtFldActionPerformed

    private void YearTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearTxtFldActionPerformed
    /**
     * Handles the action of the "Add" button. Creates a new Animal (Dog or Cat)
     * based on input fields, validates it, adds it to the database, updates the
     * local list and table model, and clears the input fields.
     *
     * @param evt the ActionEvent triggered when the Add button is clicked.
     */
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String date = YearTxtFld.getText() + "-" + MonthtxtFld.getText() + "-" + DayTxtFld.getText();
        boolean sterilizedValue = snCombo.getSelectedItem().toString().equals("Yes");

        Animal a;
        if (typeCombo.getSelectedItem().toString().equals("Dog")) {
            a = new Dog(BreedTxtFld.getText(), NameTxtFld.getText(), sterilizedValue, date);
        } else {
            a = new Cat(BreedTxtFld.getText(), NameTxtFld.getText(), sterilizedValue, date);
        }

        if (!a.validate()) {
            JOptionPane.showMessageDialog(null, "Invalid animal data. Please check all fields.");
            return;
        }

        if (!dao.add(a)) {
            JOptionPane.showMessageDialog(null, "Failed to add animal to database.");
            return;
        }

        animals.add(a);
        selectedRow = -1;
        model.setAnimals(animals);
        model.fireTableDataChanged();
        clearFields();
    }//GEN-LAST:event_addBtnActionPerformed
    /**
     * Handles the action of the "Modify" button. Updates the selected animal's
     * attributes with new values from input fields, validates and persists the
     * updated data, refreshes the table, and clears the form.
     *
     * @param evt the ActionEvent triggered when the Modify button is clicked.
     */
    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
        if (selectedRow < 0) {
            return;
        }

        Animal a = animals.get(selectedRow);
        String date = YearTxtFld.getText() + "-" + MonthtxtFld.getText() + "-" + DayTxtFld.getText();
        boolean sterilizedValue = snCombo.getSelectedItem().toString().equals("Yes");

        a.setBreed(BreedTxtFld.getText());
        a.setName(NameTxtFld.getText());
        a.setDateArrived(date);
        a.setSterilized(sterilizedValue);

        if (!a.validate()) {
            JOptionPane.showMessageDialog(null, "Invalid updated animal data.");
            return;
        }
        
        

        if (!dao.update(a)) {
            JOptionPane.showMessageDialog(null, "Database update failed.");
            return;
        }

        selectedRow = -1;
        model.fireTableDataChanged();
        clearFields();    }//GEN-LAST:event_modifyBtnActionPerformed
    /**
     * Handles the action of the "Delete" button. Prompts the user for
     * confirmation before deleting the selected animal from the database and
     * local list, updates the table model, and clears the input fields.
     *
     * @param evt the ActionEvent triggered when the Delete button is clicked.
     */
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if (selectedRow < 0) {
            return;
        }

        int selectedOption = JOptionPane.showConfirmDialog(
                null,
                "Delete the selected row?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        if (selectedOption == JOptionPane.YES_OPTION) {
            Animal a = animals.get(selectedRow);

            if (!dao.delete(a)) {
                JOptionPane.showMessageDialog(null, "Failed to delete from database.");
                return;
            }

            animals.remove(selectedRow);
            model.fireTableDataChanged();
            selectedRow = -1;
            clearFields();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed
    /**
     * Exits the application when the Exit button is clicked.
     *
     * @param evt the ActionEvent triggered when the Exit button is clicked.
     */
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed
    /**
     * Clears all form fields when the Clear button is clicked.
     *
     * @param evt the ActionEvent triggered when the Clear button is clicked.
     */
    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        clearFields();

    }//GEN-LAST:event_clearBtnActionPerformed

    /**
     * Launches the RegisResQ MainUI application. Sets the Nimbus look and feel
     * (if available) and makes the MainUI window visible.
     *
     * @param args command line arguments (not used)
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ArrDateLbl;
    private javax.swing.JLabel BreedLbl;
    private javax.swing.JTextField BreedTxtFld;
    private javax.swing.JTextField DayTxtFld;
    private javax.swing.JTextField MonthtxtFld;
    private javax.swing.JLabel NameLbl;
    private javax.swing.JTextField NameTxtFld;
    private javax.swing.JLabel SNLbl;
    private javax.swing.JLabel TypeLbl;
    private javax.swing.JTextField YearTxtFld;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileButton;
    private javax.swing.JMenuBar fileMenu;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JComboBox<String> snCombo;
    private javax.swing.JComboBox<String> typeCombo;
    // End of variables declaration//GEN-END:variables
}
