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
public class BajaActualizaEmp extends javax.swing.JDialog {

    private ConectorBD hi;
    private static DefaultTableModel modeloTabla = null;
    DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();

    /**
     * Creates new form Baja
     */
    public BajaActualizaEmp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        hi = new ConectorBD();
        cargarComboEmp();
        cargarComboDepartamantos();
        iniciarTabla();
        cargarEmpleados();
        alinear();
    }

    public void alinear() {

        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tablaEmpleados.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(4).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(5).setCellRenderer(Alinear);
        tablaEmpleados.getColumnModel().getColumn(6).setCellRenderer(Alinear);
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
                Integer numDep = d.getDepno();
                Integer numEmp = a.getEmpno();
                String apellidos = a.getApellido();
                String oficio = a.getOficio();
                Date fecha = a.getFechaalt();
                BigDecimal salario = a.getSalario();
                BigDecimal comision = a.getComision();

                modeloTabla.addRow(new Object[]{
                    numEmp, numDep, apellidos, oficio, fecha, salario, comision
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
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.util.Date.class, java.lang.Integer.class, java.lang.Integer.class

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
        modeloTabla.addColumn("DEP");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Oficio");
        modeloTabla.addColumn("Fecha_alta");
        modeloTabla.addColumn("Salario");
        modeloTabla.addColumn("Comisión");

        tablaEmpleados.setModel(modeloTabla);

    }

    public void cargarComboEmp() {
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

        List lista = hi.lanzarConsulta("FROM Empleados ");
        //System.out.println("lista" + lista);
        //Comprobamos que no tengamos un objeto vacio
        if (!lista.isEmpty()) {
            //Recorremos las categorias recuperados y las vamos añadiendo al modelo
            for (Object a1 : lista) {
                Empleados a = (Empleados) a1;
                modeloCombo.addElement(String.valueOf(a.getEmpno()));
            }
            cbNumEmp.setModel(modeloCombo);
        } else {

            JOptionPane.showMessageDialog(this, "Error al cargar los Empleados", "Error comboDptos", 0);
        }
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
        cbNumEmp = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBaja = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        etApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        etOficio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        etComision = new javax.swing.JTextField();
        cbNumDep = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        etSalario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Baja y actualización de Empleados");

        cbNumEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNumEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNumEmpActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Número:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Apellido:");

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Oficio");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Salario:");

        cbNumDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Comisión:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Fecha Alta:");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(etOficio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(etApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(61, 61, 61)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(etComision, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(etSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jBaja)
                                                .addGap(48, 48, 48)
                                                .addComponent(jBActualizar)
                                                .addGap(32, 32, 32)
                                                .addComponent(jBSalir))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cbNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addComponent(cbNumDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(etApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(etSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etOficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(etComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbNumDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        if (cbNumEmp.getSelectedIndex() >= 0) {

            Integer numero = Integer.parseInt(cbNumEmp.getSelectedItem().toString());
            int opcion = JOptionPane.showConfirmDialog(this, "El empleado " + etApellido.getText() + " va a ser actualizado de la base de datos.\n ¿Continuo con la operación?");
            if (opcion == JOptionPane.YES_OPTION) {
                if (hi.EliminarEmp(numero)) {

                JOptionPane.showMessageDialog(null, "Se ha dado de baja el empleado correctamente");

                cargarComboEmp();

            } else {

                JOptionPane.showMessageDialog(this, "Error al eliminar el empleado", "Erro Transaccion", 0);
            }
            cargarEmpleados();
            alinear();
            limpìa();
            }

            

        }


    }//GEN-LAST:event_jBajaActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        if (cbNumEmp.getSelectedIndex() >= 0) {
            String salarioTexto = etSalario.getText();
            String comisionTexto = etComision.getText();
            BigDecimal salario = null;
            BigDecimal comision = null;

            Integer numero = Integer.parseInt(cbNumEmp.getSelectedItem().toString());
            Integer numero2 = Integer.parseInt(cbNumDep.getSelectedItem().toString());
            Empleados a = new Empleados();
            a.setEmpno(numero);
            a.setApellido(etApellido.getText());
            a.setOficio(etOficio.getText());
            try {
                salario = new BigDecimal(salarioTexto);
            } catch (NumberFormatException e) {
                // Manejo de error si la entrada no es un número válido
                System.err.println("Error: Ingresa un número válido para el salario.");
            }
            try {
                comision = new BigDecimal(comisionTexto);
                // Ahora 'salario' es un objeto BigDecimal que puedes usar según tus necesidades
            } catch (NumberFormatException e) {
                // Manejo de error si la entrada no es un número válido
                System.err.println("Error: Ingresa un número válido para el salario.");
            }
            a.setComision(comision);
            a.setSalario(salario);
            a.setFechaalt(calendario.getDate());
            //a.setDepno(Integer.parseInt(cbNumDep.getSelectedItem().toString()));
            Departamentos c = new Departamentos();
            c.setDepno(Integer.parseInt(cbNumDep.getSelectedItem().toString()));
            a.setDepno(c);
            int opcion = JOptionPane.showConfirmDialog(this, "El empleado " + etApellido.getText() + " va a ser actualizado de la base de datos.\n ¿Continuo con la operación?");
            if (opcion == JOptionPane.YES_OPTION) {
                if (hi.ActualizarEmp(a)) {

                JOptionPane.showMessageDialog(null, "Se ha actualizado el album correctamente");

                cargarComboEmp();
                cargarEmpleados();
                alinear();
                limpìa();
            }
            }

            

        }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void cbNumEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNumEmpActionPerformed

        //movido

    }//GEN-LAST:event_cbNumEmpActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        // Cuando hacemos click con el ratón en alguna de las filas
        int row = tablaEmpleados.rowAtPoint(evt.getPoint());//Cogemos el número de fila
        cbNumEmp.setSelectedItem(tablaEmpleados.getValueAt(row, 0).toString());
        cbNumDep.setSelectedItem(tablaEmpleados.getValueAt(row, 1).toString());
        etApellido.setText(tablaEmpleados.getValueAt(row, 2).toString());
        etOficio.setText(tablaEmpleados.getValueAt(row, 3).toString());
        etComision.setText(tablaEmpleados.getValueAt(row, 6).toString());
        calendario.setDate((Date) tablaEmpleados.getValueAt(row, 4));
        etSalario.setText(tablaEmpleados.getValueAt(row, 5).toString());
        //TODO meter el valor del combobox


    }//GEN-LAST:event_tablaEmpleadosMouseClicked

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
            java.util.logging.Logger.getLogger(BajaActualizaEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BajaActualizaEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BajaActualizaEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BajaActualizaEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BajaActualizaEmp dialog = new BajaActualizaEmp(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JComboBox<String> cbNumDep;
    private javax.swing.JComboBox<String> cbNumEmp;
    private javax.swing.JTextField etApellido;
    private javax.swing.JTextField etComision;
    private javax.swing.JTextField etOficio;
    private javax.swing.JTextField etSalario;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jBaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables

    private void limpìa() {
        calendario.setDate(null);
        etApellido.setText("");
        etComision.setText("");
        etOficio.setText("");
        etSalario.setText("");

    }
}
