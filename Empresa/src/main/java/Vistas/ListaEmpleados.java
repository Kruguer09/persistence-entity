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
public class ListaEmpleados extends javax.swing.JDialog {

    private static DefaultTableModel modeloTabla = null;
    DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
    private ConectorBD hi;

    /**
     * Creates new form Albumes
     */
    public ListaEmpleados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        hi = new ConectorBD();
        cargarComboDepartamantos();
        iniciarTabla();
        cargarEmpleados();
        alinear();

    }

    public void cargarComboDepartamantos() {
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

        List lista = hi.lanzarConsulta("FROM Departamentos ");
        //System.out.println("lista" + lista);
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

    public void alinear() {

        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tablaEmpleados.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(4).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(5).setCellRenderer(Alinear);
    }

    public void borrarFilas() {
        int filas = modeloTabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTabla.removeRow(0);
        }
        tablaEmpleados.setModel(modeloTabla);
    }

    public void cargarEmpleados() {

        String consulta = "FROM Empleados";
        List<Empleados> empleados = hi.lanzarConsulta(consulta);
        System.out.println("resultado" + empleados);
        borrarFilas();
        if (!empleados.isEmpty()) {
            for (Empleados a : empleados) {
                //Recuperamos los campos que queremos que se muestren en la tabla.
                Departamentos d = a.getDepno();
                if (d.getDepno() == Integer.parseInt(cbNumDep.getSelectedItem().toString())) {
                    Integer numEmp = a.getEmpno();
                    String apellidos = a.getApellido();
                    String oficio = a.getOficio();
                    Date fecha = a.getFechaalt();
                    BigDecimal salario = a.getSalario();
                    BigDecimal comision = a.getComision();

                    modeloTabla.addRow(new Object[]{
                        numEmp, apellidos, oficio, fecha, salario, comision
                    });

                    tablaEmpleados.setModel(modeloTabla);

                    jLAlbumes.setText(tablaEmpleados.getRowCount() + " Empleados encontrados");
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "No existen datos");
        }

    }

    public void iniciarTabla() {
        //Reajustamos el modelo la tabla para que definir que tipo de dato da cada columna
        //Con esto conseguimos que funcione correctamente la reordenación de filas por columna
        modeloTabla = new DefaultTableModel() {
            Class[] tiposDeColumna = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.util.Date.class, java.lang.Integer.class, java.lang.String.class

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
        modeloTabla.addColumn("Numero Empleado");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Oficio");
        modeloTabla.addColumn("Fecha_alta");
        modeloTabla.addColumn("Salario");
        modeloTabla.addColumn("Comisión");

        tablaEmpleados.setModel(modeloTabla);

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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLAlbumes = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbNumDep = new javax.swing.JComboBox<>();
        btBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Listado de Empleados");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("CERRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
        jScrollPane1.setViewportView(tablaEmpleados);

        jLAlbumes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setText("Nº Departamento:");

        cbNumDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNumDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNumDepActionPerformed(evt);
            }
        });

        btBuscar.setText("BUSCAR");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLAlbumes))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbNumDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))
                                .addGap(85, 85, 85)
                                .addComponent(btBuscar)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbNumDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLAlbumes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbNumDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNumDepActionPerformed
        
    }//GEN-LAST:event_cbNumDepActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        borrarFilas();
        cargarEmpleados();
        alinear();
    }//GEN-LAST:event_btBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListaEmpleados dialog = new ListaEmpleados(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btBuscar;
    private javax.swing.JComboBox<String> cbNumDep;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLAlbumes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
