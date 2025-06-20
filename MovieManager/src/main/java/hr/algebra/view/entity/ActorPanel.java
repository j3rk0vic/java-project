/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.algebra.view.entity;

import hr.algebra.dal.ActorRepository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Actor;
import hr.algebra.utilities.MessageUtils;
import hr.algebra.view.model.ActorTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author ivanjerkovic
 */
public class ActorPanel extends javax.swing.JPanel {

    /**
     * Creates new form ActorPanel
     */
    public ActorPanel() {
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

        jLabel3 = new javax.swing.JLabel();
        tfActorFirstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfActorLastName = new javax.swing.JTextField();
        lbActorFirstNameError = new javax.swing.JLabel();
        lbActorLastNameError = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbActors = new javax.swing.JTable();
        btnAddActor = new javax.swing.JButton();
        btnUpdateActor = new javax.swing.JButton();
        btnDeleteActor = new javax.swing.JButton();
        btnDeleteAllActors = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel3.setText("First name:");

        jLabel5.setText("Last name:");

        lbActorFirstNameError.setForeground(new java.awt.Color(255, 0, 51));
        lbActorFirstNameError.setText("X");

        lbActorLastNameError.setForeground(new java.awt.Color(255, 0, 51));
        lbActorLastNameError.setText("X");

        tbActors.setModel(new javax.swing.table.DefaultTableModel(
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
        tbActors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbActorsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbActorsMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbActors);

        btnAddActor.setText("Add Actor");
        btnAddActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActorActionPerformed(evt);
            }
        });

        btnUpdateActor.setText("Update Actor");
        btnUpdateActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActorActionPerformed(evt);
            }
        });

        btnDeleteActor.setText("Delete Actor");
        btnDeleteActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActorActionPerformed(evt);
            }
        });

        btnDeleteAllActors.setText("Delete All");
        btnDeleteAllActors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActorsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfActorFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbActorFirstNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfActorLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbActorLastNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddActor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateActor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnDeleteActor, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeleteAllActors, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfActorFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbActorFirstNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfActorLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbActorLastNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateActor)
                    .addComponent(btnAddActor))
                .addGap(2, 2, 2)
                .addComponent(btnDeleteAllActors)
                .addGap(7, 7, 7)
                .addComponent(btnDeleteActor)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private ActorRepository repository;
    private ActorTableModel model;
    
    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;
    
    private Actor selectedActor;
    
    private void btnAddActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActorActionPerformed
        if (!formValid()) {
            return;
        }

        try {
            Actor actor = new Actor(
                tfActorFirstName.getText().trim(),
                tfActorLastName.getText().trim()
            );

            repository = RepositoryFactory.getActorRepository();
            repository.createActor(actor);
            model.setActors(repository.selectActors());
            clearForm();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActorActionPerformed

    private void btnUpdateActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActorActionPerformed
        if (selectedActor == null) {
            MessageUtils.showInformationMessage("INFO", "Please select");
            return;
        }

        if (!formValid()) {
            return;
        }

        try {
            selectedActor.setFirstName(tfActorFirstName.getText().trim());
            selectedActor.setLastName(tfActorLastName.getText().trim());

            repository.updateActor(selectedActor.getIdActor(), selectedActor);
            model.setActors(repository.selectActors());
            clearForm();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActorActionPerformed

    private void btnDeleteActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActorActionPerformed
        if (selectedActor == null) {
            MessageUtils.showInformationMessage("INFO", "Please select");
            return;
        }

        try {
            repository.deleteActor(selectedActor.getIdActor());
            model.setActors(repository.selectActors());
            clearForm();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActorActionPerformed

    private void btnDeleteAllActorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllActorsActionPerformed
        if (!MessageUtils.showConfirmDialog("Confirm", "Are you sure you want to delete ALL actors?")) {
            return;
        }

        try {
            repository.deleteAllActors();
            model.setActors(repository.selectActors());
            clearForm();
            MessageUtils.showInformationMessage("INFO", "All actors deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtils.showErrorMessage("ERROR", "Could not delete all actors.");
        }
    }//GEN-LAST:event_btnDeleteAllActorsActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void tbActorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbActorsMouseClicked
        selectActor();
    }//GEN-LAST:event_tbActorsMouseClicked

    private void tbActorsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbActorsMouseReleased
        selectActor();
    }//GEN-LAST:event_tbActorsMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddActor;
    private javax.swing.JButton btnDeleteActor;
    private javax.swing.JButton btnDeleteAllActors;
    private javax.swing.JButton btnUpdateActor;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbActorFirstNameError;
    private javax.swing.JLabel lbActorLastNameError;
    private javax.swing.JTable tbActors;
    private javax.swing.JTextField tfActorFirstName;
    private javax.swing.JTextField tfActorLastName;
    // End of variables declaration//GEN-END:variables
    
    private boolean formValid() {
        hideErrors();
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setVisible(validationFields.get(i).getText().trim().isEmpty());
        }
        return ok;
    }
    
    private void hideErrors() {
        errorLabels.forEach(e -> e.setVisible(false));
    }
    
    private void initTable() throws Exception {
        repository = RepositoryFactory.getActorRepository();
        tbActors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbActors.setAutoCreateRowSorter(true);
        tbActors.setRowHeight(25);
        model = new ActorTableModel(repository.selectActors());
        tbActors.setModel(model);
    }

    private void init() {
        try {
            initValidation();
            hideErrors();
            initTable();
        } catch (Exception ex) {
            Logger.getLogger(ActorPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationFields = Arrays.asList(
                tfActorFirstName,
                tfActorLastName
        );
        errorLabels = Arrays.asList(
                lbActorFirstNameError,
                lbActorLastNameError
        );
    }

    private void clearForm() {
        hideErrors();
        validationFields.forEach(e -> e.setText(""));
    }

    private void selectActor() {
        int selectedRow = tbActors.getSelectedRow();
        int rowIndex = tbActors.convertRowIndexToModel(selectedRow);

        int id = (int) model.getValueAt(rowIndex, 0);

        try {
            Optional<Actor> opt = repository.selectActor(id);
            if (opt.isPresent()) {
                selectedActor = opt.get();
                fillForm(selectedActor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void fillForm(Actor actor) {
        tfActorFirstName.setText(actor.getFirstName());
        tfActorLastName.setText(actor.getLastName());
    }
}
