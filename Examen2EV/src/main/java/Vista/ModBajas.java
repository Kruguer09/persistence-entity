/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Controlador.ControladorBD;
import Modelo.Tarea;
import java.util.List;
import com.mysql.cj.conf.BooleanPropertyDefinition;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Conti
 */
public class ModBajas extends javax.swing.JDialog {

    private ControladorBD hi;

    /**
     * Creates new form ModBajas
     */
    public ModBajas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        hi = new ControladorBD();
        cargarComboTareas();

    }

    public void cargarComboTareas() {
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

        List lista = hi.lanzarConsulta("FROM Tarea");
        //Comprobamos que no tengamos un objeto vacio
        if (!lista.isEmpty()) {
            //Recorremos las categorias recuperados y las vamos añadiendo al modelo
            for (Object can : lista) {
                Tarea car = (Tarea) can;
                modeloCombo.addElement(car.getIdTarea().toString());
            }
            jtComboID.setModel(modeloCombo);
        } else {

            JOptionPane.showMessageDialog(this, "Error al cargar los dptos", "Error comboDptos", 0);
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

        jLabel1 = new javax.swing.JLabel();
        jtID1 = new javax.swing.JLabel();
        jtDescripcion1 = new javax.swing.JLabel();
        jtResponsable1 = new javax.swing.JLabel();
        jtEstado1 = new javax.swing.JLabel();
        jtResponsable2 = new javax.swing.JTextField();
        jtDescripcion2 = new javax.swing.JTextField();
        jtComboID = new javax.swing.JComboBox<>();
        jModificacion = new javax.swing.JButton();
        jBaja = new javax.swing.JButton();
        jtEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Baja/Modificacion de tareas");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setText("BAJA/MODIFICACIÓN");

        jtID1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jtID1.setText("ID");

        jtDescripcion1.setText("Descripción");

        jtResponsable1.setText("Responsable");

        jtEstado1.setText("Estado");

        jtResponsable2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtResponsable2ActionPerformed(evt);
            }
        });

        jtDescripcion2.setAlignmentY(0.0F);
        jtDescripcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDescripcion2ActionPerformed(evt);
            }
        });

        jtComboID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jtComboID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtComboIDActionPerformed(evt);
            }
        });

        jModificacion.setBackground(new java.awt.Color(255, 255, 0));
        jModificacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jModificacion.setText("ACTUALIZAR");
        jModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModificacionActionPerformed(evt);
            }
        });

        jBaja.setBackground(new java.awt.Color(255, 0, 51));
        jBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBaja.setForeground(new java.awt.Color(255, 255, 255));
        jBaja.setText("ELIMINAR");
        jBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBajaActionPerformed(evt);
            }
        });

        jtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "En proceso", "Finalizada" }));
        jtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jModificacion)))
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jtID1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtDescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtComboID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtResponsable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jtDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jtEstado1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jtResponsable2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(146, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtComboID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtID1))
                .addGap(18, 18, 18)
                .addComponent(jtDescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModificacion)
                    .addComponent(jBaja))
                .addGap(24, 24, 24))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jtDescripcion1)
                    .addGap(66, 66, 66)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtResponsable1)
                        .addComponent(jtResponsable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jtEstado1)
                    .addContainerGap(81, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtResponsable2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtResponsable2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtResponsable2ActionPerformed

    private void jtDescripcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDescripcion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDescripcion2ActionPerformed

    private void jtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEstadoActionPerformed

    private void jtComboIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtComboIDActionPerformed
        Tarea baja = new Tarea();

        if (jtComboID.getSelectedIndex() >= 0) {
            Integer numero = Integer.parseInt(jtComboID.getSelectedItem().toString());
            baja.setIdTarea(numero);

            baja = hi.Buscar(baja);
            jtDescripcion2.setText(baja.getDescripcion());
            jtResponsable2.setText(baja.getResponsable());
            jtEstado.setSelectedItem(baja.getEstado());
        } else
            JOptionPane.showMessageDialog(this, "Error al cargar las tareas", "Error combo", 0);
    }//GEN-LAST:event_jtComboIDActionPerformed

    private void jModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModificacionActionPerformed
        if (jtComboID.getSelectedIndex() >= 0) {
            int id = jtComboID.getSelectedIndex();
            String descripcion = jtDescripcion2.getText();
            String responsable = jtResponsable2.getText();
            String estado = jtEstado.toString();

            Tarea a = new Tarea();
            a.setIdTarea(id);
            a.setEstado(estado);
            a.setDescripcion(descripcion);
            a.setResponsable(responsable);

            int opcion = JOptionPane.showConfirmDialog(this, "La tareava a ser actualizado de la base de datos.\n ¿Continuo con la operación?");
            if (opcion == JOptionPane.YES_OPTION) {
                if (hi.actualizar(a)) {

                    JOptionPane.showMessageDialog(null, "Se ha actualizado el album correctamente");

                    cargarComboTareas();


                }
            }
        }
    }//GEN-LAST:event_jModificacionActionPerformed

    private void jBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBajaActionPerformed
        if (jtComboID.getSelectedIndex() >= 0) {

            Integer numero = Integer.parseInt(jtComboID.getSelectedItem().toString());
            int opcion = JOptionPane.showConfirmDialog(this, "La tarea " + jtComboID.getSelectedItem().toString() + " va a ser eliminada de la base de datos.\n ¿Continuo con la operación?");
            if (opcion == JOptionPane.YES_OPTION) {

                if (hi.eliminar(numero)) {

                    JOptionPane.showMessageDialog(null, "Se ha dado de baja el album correctamente");

                    cargarComboTareas();

                } else {

                    JOptionPane.showMessageDialog(this, "Error al eliminar el album", "Erro Transaccion", 0);
                }

            }
        }
    }//GEN-LAST:event_jBajaActionPerformed

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
            java.util.logging.Logger.getLogger(ModBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModBajas dialog = new ModBajas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jModificacion;
    private javax.swing.JComboBox<String> jtComboID;
    private javax.swing.JLabel jtDescripcion1;
    private javax.swing.JTextField jtDescripcion2;
    private javax.swing.JComboBox<String> jtEstado;
    private javax.swing.JLabel jtEstado1;
    private javax.swing.JLabel jtID1;
    private javax.swing.JLabel jtResponsable1;
    private javax.swing.JTextField jtResponsable2;
    // End of variables declaration//GEN-END:variables
}