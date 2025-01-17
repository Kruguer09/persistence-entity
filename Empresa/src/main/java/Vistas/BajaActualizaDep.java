/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.ConectorBD;
import Modelos.Departamentos;
import Modelos.Empleados;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Conti
 */
public class BajaActualizaDep extends javax.swing.JDialog {

    private ConectorBD hi;
    private static DefaultTableModel modeloTabla = null;
    DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();

    /**
     * Creates new form Baja
     */
    public BajaActualizaDep(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        hi = new ConectorBD();

        cargarComboDepartamantos();
        iniciarTabla();
        cargarDepartamentos();
        alinear();
    }

    public void alinear() {

        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tablaEmpleados.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(2).setCellRenderer(Alinear);

    }

    public void cargarDepartamentos() {

        String consulta = "FROM Departamentos";
        List<Departamentos> departamentos = hi.lanzarConsulta(consulta);
        System.out.println("resultado" + departamentos);
        borrarFilas();
        if (!departamentos.isEmpty()) {
            for (Departamentos a : departamentos) {
                //Recuperamos los campos que queremos que se muestren en la tabla
                Integer numDep = a.getDepno();
                String nombre = a.getNombre();
                String loc = a.getLoc();

                modeloTabla.addRow(new Object[]{
                    numDep,nombre, loc
                });

                tablaEmpleados.setModel(modeloTabla);

            }

        } else {

            JOptionPane.showMessageDialog(null, "No existen datos");
        }

    }

    public void borrarFilas() {
        int filas = modeloTabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTabla.removeRow(0);
        }
        tablaEmpleados.setModel(modeloTabla);
    }

    public void iniciarTabla() {
        //Reajustamos el modelo la tabla para que definir que tipo de dato da cada columna
        //Con esto conseguimos que funcione correctamente la reordenación de filas por columna
        modeloTabla = new DefaultTableModel() {
            Class[] tiposDeColumna = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class

            };

            @Override
            public Class getColumnClass(int indiceColumna) {
                return tiposDeColumna[indiceColumna];
            }
        };
        //Damos la posibilidad a la tabla de reordenarse en funcion de la columna
        //cuando el usuario pulsa sobre la cabecera
        tablaEmpleados.setAutoCreateRowSorter(true);

        //Cabeceras de las columnas, mostraremos solamente el titulo, duracion, calificacion y extras.
        modeloTabla.addColumn("Numero Departamento");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Loc");


        tablaEmpleados.setModel(modeloTabla);

    }

    public void cargarComboDepartamantos() {
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

        List lista = hi.lanzarConsulta("FROM Departamentos ");
        System.out.println("lista" + lista);
        //Comprobamos que no tengamos un objeto vacio
        if (!lista.isEmpty()) {
            //Recorremos las categorias recuperados y las vamos añadiendo al modelo
            for (Object a1 : lista) {
                Departamentos a = (Departamentos) a1;
                modeloCombo.addElement(String.valueOf(a.getDepno()));
            }
            cbNumDep.setModel(modeloCombo);
        } else {

            JOptionPane.showMessageDialog(this, "Error al cargar los Departamentos", "Error comboCantante", 0);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBaja = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        etNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbNumDep = new javax.swing.JComboBox<>();
        etLoc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Baja y actualización de Departamentos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nº Departamento");

        jBaja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBaja.setForeground(new java.awt.Color(255, 0, 0));
        jBaja.setText("BAJA");
        jBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBajaActionPerformed(evt);
            }
        });

        jBSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBSalir.setForeground(new java.awt.Color(255, 0, 0));
        jBSalir.setText("SALIR");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBActualizar.setForeground(new java.awt.Color(0, 0, 255));
        jBActualizar.setText("ACTUALIZACIÓN");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Loc:");

        cbNumDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNumDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNumDepActionPerformed(evt);
            }
        });

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jBaja)
                                .addGap(48, 48, 48)
                                .addComponent(jBActualizar)
                                .addGap(32, 32, 32)
                                .addComponent(jBSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbNumDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addComponent(etNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(61, 61, 61)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(etLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbNumDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(etLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBaja)
                    .addComponent(jBActualizar)
                    .addComponent(jBSalir))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBajaActionPerformed

        if (cbNumDep.getSelectedIndex() >= 0) {

            Integer numero = Integer.parseInt(cbNumDep.getSelectedItem().toString());

            if (hi.EliminarDep(numero)) {

                JOptionPane.showMessageDialog(null, "Se ha dado de baja el Departamento correctamente");

                cargarComboDepartamantos();                

            } else {

                JOptionPane.showMessageDialog(this, "Error al eliminar el departamento", "Erro Transaccion", 0);
            }
            cargarDepartamentos();
                alinear();

        }


    }//GEN-LAST:event_jBajaActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        if (cbNumDep.getSelectedIndex() >= 0) {
            String nombre = etNombre.getText();
            String loc = etLoc.getText();
            Integer numero2 = Integer.parseInt(cbNumDep.getSelectedItem().toString());
            Departamentos a = new Departamentos();
            a.setDepno(numero2);
            a.setNombre(nombre);
            a.setLoc(loc);

            
            if (hi.ActualizarDep(a)) {

                JOptionPane.showMessageDialog(null, "Se ha actualizado el album correctamente");

                cargarComboDepartamantos();          
                cargarDepartamentos();
                alinear();

            }

        }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        // Cuando hacemos click con el ratón en alguna de las filas
        int row = tablaEmpleados.rowAtPoint(evt.getPoint());//Cogemos el número de fila
        cbNumDep.setSelectedItem(tablaEmpleados.getValueAt(row,0).toString());
        etNombre.setText(tablaEmpleados.getValueAt(row, 1).toString());
        etLoc.setText(tablaEmpleados.getValueAt(row,2).toString());
        //TODO meter el valor del combobox



    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void cbNumDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNumDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNumDepActionPerformed

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
            java.util.logging.Logger.getLogger(BajaActualizaDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BajaActualizaDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BajaActualizaDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BajaActualizaDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BajaActualizaDep dialog = new BajaActualizaDep(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbNumDep;
    private javax.swing.JTextField etLoc;
    private javax.swing.JTextField etNombre;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jBaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
