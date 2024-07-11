/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

/**
 *
 * @author USER
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        menu_Altas = new javax.swing.JMenu();
        menu_altaDepartamentos = new javax.swing.JMenuItem();
        menu_altaEmpleado = new javax.swing.JMenuItem();
        menu_consultas = new javax.swing.JMenu();
        menu_listarDepartamentos = new javax.swing.JMenuItem();
        menu_listarEmpleados = new javax.swing.JMenuItem();
        menu_bajaDep = new javax.swing.JMenuItem();
        menu_baja_emp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu_Altas.setText("Altas");

        menu_altaDepartamentos.setText("Departamentos");
        menu_altaDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_altaDepartamentosActionPerformed(evt);
            }
        });
        menu_Altas.add(menu_altaDepartamentos);

        menu_altaEmpleado.setText("Empleados");
        menu_altaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_altaEmpleadoActionPerformed(evt);
            }
        });
        menu_Altas.add(menu_altaEmpleado);

        jMenuBar1.add(menu_Altas);

        menu_consultas.setText("Consultas");

        menu_listarDepartamentos.setText("ListarDepartamentos");
        menu_listarDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listarDepartamentosActionPerformed(evt);
            }
        });
        menu_consultas.add(menu_listarDepartamentos);

        menu_listarEmpleados.setText("ListarEmpleados");
        menu_listarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listarEmpleadosActionPerformed(evt);
            }
        });
        menu_consultas.add(menu_listarEmpleados);

        menu_bajaDep.setText("Baja-editaDepartamentos");
        menu_bajaDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_bajaDepActionPerformed(evt);
            }
        });
        menu_consultas.add(menu_bajaDep);

        menu_baja_emp.setText("Baja-editaEmpleados");
        menu_baja_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_baja_empActionPerformed(evt);
            }
        });
        menu_consultas.add(menu_baja_emp);

        jMenuBar1.add(menu_consultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_baja_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_baja_empActionPerformed
        new BajaActualizaEmp(this,true).setVisible(true); 
    }//GEN-LAST:event_menu_baja_empActionPerformed

    private void menu_altaDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_altaDepartamentosActionPerformed
        new AltaDepartamentos(this,true).setVisible(true);  
    }//GEN-LAST:event_menu_altaDepartamentosActionPerformed

    private void menu_altaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_altaEmpleadoActionPerformed
        new AltaEmpleados(this,true).setVisible(true);  
    }//GEN-LAST:event_menu_altaEmpleadoActionPerformed

    private void menu_listarDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listarDepartamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_listarDepartamentosActionPerformed

    private void menu_listarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listarEmpleadosActionPerformed
        new ListaEmpleados(this,true).setVisible(true);  
    }//GEN-LAST:event_menu_listarEmpleadosActionPerformed

    private void menu_bajaDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_bajaDepActionPerformed
        new BajaActualizaDep(this,true).setVisible(true);  
    }//GEN-LAST:event_menu_bajaDepActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menu_Altas;
    private javax.swing.JMenuItem menu_altaDepartamentos;
    private javax.swing.JMenuItem menu_altaEmpleado;
    private javax.swing.JMenuItem menu_bajaDep;
    private javax.swing.JMenuItem menu_baja_emp;
    private javax.swing.JMenu menu_consultas;
    private javax.swing.JMenuItem menu_listarDepartamentos;
    private javax.swing.JMenuItem menu_listarEmpleados;
    // End of variables declaration//GEN-END:variables
}
