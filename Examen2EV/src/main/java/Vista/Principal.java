/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Conti
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
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

        jLabel1 = new javax.swing.JLabel();
        jAlta1 = new javax.swing.JButton();
        jModBorrar1 = new javax.swing.JButton();
        jConsultas = new javax.swing.JButton();
        jConsultas1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programa de gestión de tareas - 2EV");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setText("GESTIÓN DE TAREAS");

        jAlta1.setBackground(new java.awt.Color(204, 255, 204));
        jAlta1.setText("Alta de nuevas tareas");
        jAlta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlta1ActionPerformed(evt);
            }
        });

        jModBorrar1.setBackground(new java.awt.Color(204, 204, 255));
        jModBorrar1.setText("Modificación/Borrado");
        jModBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModBorrar1ActionPerformed(evt);
            }
        });

        jConsultas.setBackground(new java.awt.Color(255, 204, 204));
        jConsultas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jConsultas.setText("Listar las tareas");
        jConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultasActionPerformed(evt);
            }
        });

        jConsultas1.setBackground(new java.awt.Color(102, 102, 255));
        jConsultas1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jConsultas1.setForeground(new java.awt.Color(255, 255, 255));
        jConsultas1.setText("Consultas");
        jConsultas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jAlta1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jModBorrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(78, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jConsultas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jConsultas1)))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jAlta1)
                .addGap(30, 30, 30)
                .addComponent(jModBorrar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jConsultas1)
                    .addComponent(jConsultas))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jModBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModBorrar1ActionPerformed
        new ModBajas(this, true).setVisible(true);
    }//GEN-LAST:event_jModBorrar1ActionPerformed

    private void jConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultasActionPerformed
        new ListadoTareas(this, true).setVisible(true);
    }//GEN-LAST:event_jConsultasActionPerformed

    private void jAlta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlta1ActionPerformed
        new Altas (this, true).setVisible(true);
    }//GEN-LAST:event_jAlta1ActionPerformed

    private void jConsultas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultas1ActionPerformed
       new PantallaConsultas(this, true).setVisible(true);
    }//GEN-LAST:event_jConsultas1ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAlta1;
    private javax.swing.JButton jConsultas;
    private javax.swing.JButton jConsultas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jModBorrar1;
    // End of variables declaration//GEN-END:variables
}
