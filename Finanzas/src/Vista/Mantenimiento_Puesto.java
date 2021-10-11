/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PuestoDAO;
import Modelo.Puesto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OtakuGT
 */
public class Mantenimiento_Puesto extends javax.swing.JInternalFrame {
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre Puesto");
        modelo.addColumn("Salario");
        PuestoDAO puestoDAO = new PuestoDAO();
        List<Puesto> puestos = puestoDAO.select();
        Tabla.setModel(modelo);
        Object[] objeto = new Object[3];
        for (int i = 0; i < puestos.size(); i++) {
            objeto[0] = puestos.get(i).getId_puesto();
            objeto[1] = puestos.get(i).getNombre_puesto();
            objeto[2] = puestos.get(i).getSalario_puesto();

            modelo.addRow(objeto);
        }
    }

    /**
     * Creates new form Mantenimiento_Puesto
     */
    public Mantenimiento_Puesto() {
        initComponents();
        llenadoDeTablas();
    }

    
    public void limpiar() {
        txt_ID.setText("");
        txt_nombre.setText("");
        txt_salario.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_ID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_salario = new javax.swing.JTextField();
        Btn_ingresar = new javax.swing.JButton();
        Btn_mod = new javax.swing.JButton();
        Btn_elim = new javax.swing.JButton();
        Btn_bus = new javax.swing.JButton();
        Btn_rep = new javax.swing.JButton();
        Btn_ay = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("ID");

        jLabel2.setText("Nombre");

        jLabel3.setText("Salario");

        Btn_ingresar.setText("Ingresar");
        Btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ingresarActionPerformed(evt);
            }
        });

        Btn_mod.setText("Modificar");
        Btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_modActionPerformed(evt);
            }
        });

        Btn_elim.setText("Eliminar");
        Btn_elim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_elimActionPerformed(evt);
            }
        });

        Btn_bus.setText("Buscar");
        Btn_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_busActionPerformed(evt);
            }
        });

        Btn_rep.setText("Reporte");

        Btn_ay.setText("?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_salario, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ID, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_ay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Btn_ingresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(Btn_mod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_elim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_bus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_rep)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(Btn_ay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_ingresar)
                    .addComponent(Btn_mod)
                    .addComponent(Btn_elim)
                    .addComponent(Btn_bus)
                    .addComponent(Btn_rep))
                .addGap(14, 14, 14))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ingresarActionPerformed
        Puesto puestoins = new Puesto();
        PuestoDAO puestoDAO = new PuestoDAO();

        if (txt_ID.getText().length() != 0 || txt_nombre.getText().length() != 0
            || txt_salario.getText().length() != 0 ) {
            {
        String ID = txt_ID.getText();
        int IntID = Integer.parseInt(ID);
        double sdouble = Double.parseDouble(txt_salario.getText()); 
                puestoins.setId_puesto(IntID);
                puestoins.setNombre_puesto(txt_nombre.getText());
                puestoins.setSalario_puesto(sdouble);
              
                limpiar();
                llenadoDeTablas();
                puestoDAO.insert(puestoins);
                        JOptionPane.showMessageDialog(null, "El registro se completo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios","Error!",JOptionPane.ERROR_MESSAGE);
            llenadoDeTablas();
        }
        llenadoDeTablas();
    }//GEN-LAST:event_Btn_ingresarActionPerformed

    private void Btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_modActionPerformed
        Puesto puestomod = new Puesto();
        PuestoDAO puestoDAO = new PuestoDAO();
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de modificar el registro?", "Alerta!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
        switch (resp) {
            case JOptionPane.YES_OPTION:
                String ID = txt_ID.getText();
                int IntID = Integer.parseInt(ID);
                double sdouble = Double.parseDouble(txt_salario.getText()); 
                puestomod.setId_puesto(IntID);
                puestomod.setNombre_puesto(txt_nombre.getText());
                puestomod.setSalario_puesto(sdouble);
                //
                
                puestoDAO.update(puestomod);
                JOptionPane.showMessageDialog(null, "Modificación Exitosa");
                llenadoDeTablas();
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "No se ha modificado ningun registro");
                break;
            case JOptionPane.CANCEL_OPTION:
                break;
            default:
                break;
        
        }
    }//GEN-LAST:event_Btn_modActionPerformed

    private void Btn_elimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_elimActionPerformed
        Puesto puestoelim = new Puesto();
        PuestoDAO puestoDAO = new PuestoDAO();
        String texto=txt_ID.getText();
        texto=texto.replaceAll(" ", "");
        if(texto.length()==0){
             JOptionPane.showMessageDialog(null, "No hay texto en el ID", "Error", JOptionPane.ERROR_MESSAGE);
           
        }
        else  {  
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el registro?", "Alerta!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            switch (resp) {
                case JOptionPane.YES_OPTION:
                    String ID = txt_ID.getText();
                    int IntID = Integer.parseInt(ID);
                    puestoelim.setId_puesto(IntID);
                    puestoDAO.delete(puestoelim);
                    JOptionPane.showMessageDialog(null, "Usuario Eliminado.");
                    llenadoDeTablas();
                    limpiar();
                    break;
                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(null, "No se ha eliminado ningun registro");
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
                default:
                    break;
            }
        }
        
    }//GEN-LAST:event_Btn_elimActionPerformed

    private void Btn_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_busActionPerformed
        Puesto puestobus = new Puesto();
        PuestoDAO puestoDAO = new PuestoDAO();
        String texto=txt_ID.getText();
        texto=texto.replaceAll(" ", "");
        if(texto.length()==0){
             JOptionPane.showMessageDialog(null, "No hay texto en el ID de busqueda", "Error de busqueda", JOptionPane.ERROR_MESSAGE);
           
        }
        else  {  
            JOptionPane.showMessageDialog(null, "Registro Encontrado", "Busqueda Encontrada", JOptionPane.INFORMATION_MESSAGE);
        int IntID=Integer.parseInt(txt_ID.getText());  
        puestobus.setId_puesto(IntID);
        
        puestobus = puestoDAO.query(puestobus);
        
        txt_ID.setText(String.valueOf(puestobus.getId_puesto()));
        txt_nombre.setText(String.valueOf(puestobus.getNombre_puesto()));
        txt_salario.setText(String.valueOf(puestobus.getSalario_puesto()));
        llenadoDeTablas();
        }
    }//GEN-LAST:event_Btn_busActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_ay;
    private javax.swing.JButton Btn_bus;
    private javax.swing.JButton Btn_elim;
    private javax.swing.JButton Btn_ingresar;
    private javax.swing.JButton Btn_mod;
    private javax.swing.JButton Btn_rep;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_salario;
    // End of variables declaration//GEN-END:variables
}