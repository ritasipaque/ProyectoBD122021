/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.vista;

import Comercial.datos.Conexion;
import Comercial.datos.ExistenciaDAO;
import Comercial.dominio.Existencia;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Diana
 */
public class Proceso_Existencia extends javax.swing.JInternalFrame {

    /**
     * Creates new form Proceso_Existencia
     */
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Producto");
        modelo.addColumn("Bodega");
        modelo.addColumn("Cantidad Existencia");
        modelo.addColumn("Fecha Entrada");
        modelo.addColumn("Fecha Salida");
        modelo.addColumn("Estatus Existencia");
        ExistenciaDAO existenciaDAO = new ExistenciaDAO();

        List<Existencia> existencia = existenciaDAO.select();
        Tbl_existencia.setModel(modelo);
        String[] dato = new String[7];
        for (int i = 0; i < existencia.size(); i++) {

            dato[0] = existencia.get(i).getPk_codigo_producto();
            dato[1] = existencia.get(i).getPk_codigo_bodega();
            dato[2] = existencia.get(i).getCantidad_existencia();
            dato[3] = existencia.get(i).getFecha_entrada_existencia();
            dato[4] = existencia.get(i).getFecha_salida_existencia();
            dato[5] = existencia.get(i).getEstatus_existencia();
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscar() {
        Existencia existenciaAConsultar = new Existencia();
        ExistenciaDAO existenciaDAO = new ExistenciaDAO();
        existenciaAConsultar.setPk_codigo_producto(Tbx_producto.getText());
        existenciaAConsultar = existenciaDAO.query(existenciaAConsultar);

        Tbx_bodega.setText(existenciaAConsultar.getPk_codigo_bodega());
        Txt_cantidad.setText(existenciaAConsultar.getCantidad_existencia());
        Txt_fechaentrada.setText(String.valueOf(existenciaAConsultar.getFecha_entrada_existencia()));
        Txt_fechasalida.setText(String.valueOf(existenciaAConsultar.getFecha_salida_existencia()));
        Txt_estatus.setText(String.valueOf(existenciaAConsultar.getEstatus_existencia()));
//        cbx_bodega.setSelectedItem(String.valueOf(0));
    }

    public void limpiar() {

        Tbx_producto.setText("");
        Tbx_bodega.setText("");
        Txt_cantidad.setText("");
        Txt_fechaentrada.setText("");
        Txt_fechasalida.setText("");
        Txt_estatus.setText("");

    }

    public Proceso_Existencia() {
        initComponents();
        llenadoDeTablas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_Ayuda = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Txt_cantidad = new javax.swing.JTextField();
        Txt_fechaentrada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Txt_fechasalida = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Txt_estatus = new javax.swing.JTextField();
        Btn_guardar = new javax.swing.JButton();
        Btn_Modificar = new javax.swing.JButton();
        Btn_Buscar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        Btn_Reporte = new javax.swing.JButton();
        Tbx_bodega = new javax.swing.JTextField();
        Tbx_producto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_existencia = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Btn_Ayuda.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_Ayuda.setText("Ayuda");
        Btn_Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AyudaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Existencia"));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Codigo Producto");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Codigo Bodega");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad Existencia");

        Txt_cantidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Txt_fechaentrada.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Fecha entrada");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Fecha Salida");

        Txt_fechasalida.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Estatus");

        Txt_estatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Btn_guardar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_guardar.setText("Guardar");
        Btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_guardarActionPerformed(evt);
            }
        });

        Btn_Modificar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_Modificar.setText("Modificar");
        Btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ModificarActionPerformed(evt);
            }
        });

        Btn_Buscar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_Buscar.setText("Buscar");
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });

        Btn_Eliminar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_Eliminar.setText("Eliminar");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        Btn_Reporte.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_Reporte.setText("Reporte");
        Btn_Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ReporteActionPerformed(evt);
            }
        });

        Tbx_bodega.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Tbx_producto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txt_cantidad)
                            .addComponent(Tbx_bodega)
                            .addComponent(Tbx_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(Btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_fechaentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_fechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(Txt_fechaentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Tbx_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tbx_bodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_fechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Existencia Detalle"));

        Tbl_existencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tbl_existencia);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("PROCESO EXISTENCIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(191, 191, 191)
                        .addComponent(Btn_Ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_guardarActionPerformed
        // TODO add your handling code here:
        String id = "0";
        Proceso_Existencia proexistenciaDAO = new Proceso_Existencia();
        ExistenciaDAO existenciaDAO = new ExistenciaDAO();
        Existencia existenciaAInsertar = new Existencia();
        //        String cbxproducto = Cbx_producto.getSelectedItem().toString();
        existenciaAInsertar.setPk_codigo_producto(Tbx_producto.getText());

        existenciaAInsertar.setPk_codigo_bodega(Tbx_bodega.getText());
        existenciaAInsertar.setCantidad_existencia(Txt_cantidad.getText());
        existenciaAInsertar.setFecha_entrada_existencia(Txt_fechaentrada.getText());
        existenciaAInsertar.setFecha_salida_existencia(Txt_fechasalida.getText());
        existenciaAInsertar.setEstatus_existencia(Txt_estatus.getText());

        existenciaDAO.insert(existenciaAInsertar);
        llenadoDeTablas();
        limpiar();
        //        
//                Bitacora Insertar = new Bitacora();
//                Insertar.setId_Usuario(Login.usuarioComercial);
//                Insertar.setAccion("Insertar");
//        
//                Insertar.setCodigoAplicacion("3001");
//                Insertar.setModulo("3000");
//        
//                try {
//                        BitacoraDAO.insert(Insertar);
//                    } catch (UnknownHostException ex) {
//                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//                Registro_ventaDao  DAO = new Registro_ventaDao();
//        
//                Registro_venta Inserta = new Registro_venta();
//                Inserta.setUsuario(Login.usuarioComercial);
//                Inserta.setAccion("Insertar");
//        
//                Inserta.setTabla("3001");
//                Inserta.setTotal(Txt_total.getText());

    }//GEN-LAST:event_Btn_guardarActionPerformed

    private void Btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ModificarActionPerformed
        // TODO add your handling code here:
        ExistenciaDAO existenciaDAO = new ExistenciaDAO();
        Existencia existenciaAActualizar = new Existencia();
        existenciaAActualizar.setPk_codigo_producto(Tbx_producto.getText());

        existenciaAActualizar.setPk_codigo_bodega(Tbx_bodega.getText());
        existenciaAActualizar.setCantidad_existencia(Txt_cantidad.getText());
        existenciaAActualizar.setFecha_entrada_existencia(Txt_fechaentrada.getText());
        existenciaAActualizar.setFecha_salida_existencia(Txt_fechasalida.getText());
        existenciaAActualizar.setEstatus_existencia(Txt_estatus.getText());
        existenciaDAO.update(existenciaAActualizar);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa.");
        llenadoDeTablas();
        limpiar();
        //        
//                Bitacora Insertar = new Bitacora();
//                Insertar.setId_Usuario(Login.usuarioComercial);
//                Insertar.setAccion("Insertar");
//        
//                Insertar.setCodigoAplicacion("3001");
//                Insertar.setModulo("3000");
//        
//                try {
//                        BitacoraDAO.insert(Insertar);
//                    } catch (UnknownHostException ex) {
//                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//                Registro_ventaDao  DAO = new Registro_ventaDao();
//        
//                Registro_venta Inserta = new Registro_venta();
//                Inserta.setUsuario(Login.usuarioComercial);
//                Inserta.setAccion("Insertar");
//        
//                Inserta.setTabla("3001");
//                Inserta.setTotal(Txt_total.getText());
    }//GEN-LAST:event_Btn_ModificarActionPerformed

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed
        // TODO add your handling code here:
        buscar();
        //        
//                Bitacora Insertar = new Bitacora();
//                Insertar.setId_Usuario(Login.usuarioComercial);
//                Insertar.setAccion("Insertar");
//        
//                Insertar.setCodigoAplicacion("3001");
//                Insertar.setModulo("3000");
//        
//                try {
//                        BitacoraDAO.insert(Insertar);
//                    } catch (UnknownHostException ex) {
//                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//                Registro_ventaDao  DAO = new Registro_ventaDao();
//        
//                Registro_venta Inserta = new Registro_venta();
//                Inserta.setUsuario(Login.usuarioComercial);
//                Inserta.setAccion("Insertar");
//        
//                Inserta.setTabla("3001");
//                Inserta.setTotal(Txt_total.getText());
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        // TODO add your handling code here:
        ExistenciaDAO existenciaDAO = new ExistenciaDAO();
        Existencia existenciaAEliminar = new Existencia();
        existenciaAEliminar.setPk_codigo_producto(Tbx_producto.getText());
        existenciaDAO.delete(existenciaAEliminar);
        JOptionPane.showMessageDialog(null, "Registro Eliminado.");

        llenadoDeTablas();
        limpiar();
        //        
//                Bitacora Insertar = new Bitacora();
//                Insertar.setId_Usuario(Login.usuarioComercial);
//                Insertar.setAccion("Insertar");
//        
//                Insertar.setCodigoAplicacion("3001");
//                Insertar.setModulo("3000");
//        
//                try {
//                        BitacoraDAO.insert(Insertar);
//                    } catch (UnknownHostException ex) {
//                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//                Registro_ventaDao  DAO = new Registro_ventaDao();
//        
//                Registro_venta Inserta = new Registro_venta();
//                Inserta.setUsuario(Login.usuarioComercial);
//                Inserta.setAccion("Insertar");
//        
//                Inserta.setTabla("3001");
//                Inserta.setTotal(Txt_total.getText());
    }//GEN-LAST:event_Btn_EliminarActionPerformed
    private Connection connection = null;
    private void Btn_ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ReporteActionPerformed
        // TODO add your handling code here:
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;
        try {
            connection = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/main/java/Comercial/reportes/existencia.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de Proceso Existencia");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_Btn_ReporteActionPerformed

    private void Btn_AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AyudaActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\AyudaProcesoExistencia.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\AyudaProcesoExistencia.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
    }//GEN-LAST:event_Btn_AyudaActionPerformed
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Ayuda;
    private javax.swing.JButton Btn_Buscar;
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_Modificar;
    private javax.swing.JButton Btn_Reporte;
    private javax.swing.JButton Btn_guardar;
    private javax.swing.JTable Tbl_existencia;
    private javax.swing.JTextField Tbx_bodega;
    private javax.swing.JTextField Tbx_producto;
    private javax.swing.JTextField Txt_cantidad;
    private javax.swing.JTextField Txt_estatus;
    private javax.swing.JTextField Txt_fechaentrada;
    private javax.swing.JTextField Txt_fechasalida;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
