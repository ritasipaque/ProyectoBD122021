package vista;

import dominio.ProcesosRepetidos;
import dominio.AsignacionGobernanta;
import datos.AsignacionGobernantaDAO;
import java.awt.Color;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jefferson Dávila
 */
public class Prcs_AsignacionGobernanta extends javax.swing.JInternalFrame {

    ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
    AsignacionGobernanta pisos = new AsignacionGobernanta();
    AsignacionGobernantaDAO cbxAsignacionGobernanta = new AsignacionGobernantaDAO();
    DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
    DefaultTableModel modelo1, modelo2;

    /**
     * Creates new form Prcs_AsignacionGobernanta
     */
    public Prcs_AsignacionGobernanta() {
        initComponents();
        cbxAsignacionGobernanta.llenarCbx(Cbx_Gobernanta);
        cbxAsignacionGobernanta.llenarCbx2(Cbx_Piso);
        diseño();
        actualizarTabla("");
        tabla1();
        tabla2();
    }

    public void diseño() {
        this.setTitle("Asignación de Gobernanta de Piso");
        Txt_buscar.setBorder(null);
        Rdb_Limpiar2.setVisible(false);
        prcs_repetidos.Cursor(Btn_ayuda, Btn_cancelar, Btn_eliminar, Btn_guardar, Btn_modificar, Btn_reporte, Btn_buscar);
        ImageIcon icono = new ImageIcon("src/main/java/assets/pisos.png");
        this.setFrameIcon(icono);
    }

    public void actualizarTabla(String codigo) {
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
        AsignacionGobernantaDAO.codigoAuxiliar = codigo;
        AsignacionGobernantaDAO.nombreAuxiliar = codigo;
        String columnas[] = {"ID", "ID GOBERNANTA", "NO. PISO", "ID AMA LLAVE", "NOM. AMA LLAVE", "ESTADO"};
        int cantidadcolumnas = columnas.length;
        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Datos);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {30, 100, 30, 75, 120, 30};
        AsignacionGobernantaDAO pisosdao = new AsignacionGobernantaDAO();
        List<AsignacionGobernanta> piso = pisosdao.select();
        for (AsignacionGobernanta listaServicio : piso) {
            datos[0] = String.valueOf(listaServicio.getIdAsignacionGobernanta());
            datos[1] = String.valueOf(listaServicio.getIdGobernanta());
            datos[2] = String.valueOf(listaServicio.getIdPiso());
            datos[3] = String.valueOf(listaServicio.getIdAmaDeLlave());
            datos[4] = String.valueOf(listaServicio.getNombreAmaDeLlave());
            if (String.valueOf(listaServicio.getEstadoAsignacionGobernanta()).equals("1")) {
                datos[5] = "Activo";
            } else {
                datos[5] = "Inactivo";
            }
            prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Datos);
        }
    }

    public void tabla1() {
        modelo1 = new DefaultTableModel();
        modelo1.addColumn("ID");
        modelo1.addColumn("NOMBRE");
        Tbl_AmaDeLlave.setModel(modelo1);

        centro.setHorizontalAlignment(JLabel.CENTER);
        Tbl_AmaDeLlave.getColumnModel().getColumn(0).setCellRenderer(centro);
        Tbl_AmaDeLlave.getColumnModel().getColumn(1).setCellRenderer(centro);

        Tbl_AmaDeLlave.getColumnModel().getColumn(0).setPreferredWidth(40);
        Tbl_AmaDeLlave.getColumnModel().getColumn(1).setPreferredWidth(140);

        String datos[] = new String[2];
        AsignacionGobernantaDAO dao = new AsignacionGobernantaDAO();
        List<AsignacionGobernanta> personas = dao.selectAmaDeLlave();
        for (AsignacionGobernanta persona : personas) {
            datos[0] = persona.getIdAmaDeLlave();
            datos[1] = persona.getNombreAmaDeLlave();
            modelo1.addRow(datos);
            Tbl_AmaDeLlave.setModel(modelo1);
        }
    }

    public void tabla2() {
        modelo2 = new DefaultTableModel();
        modelo2.addColumn("ID");
        modelo2.addColumn("NOMBRE");
        Tbl_AmaDeLlaves2.setModel(modelo2);

        centro.setHorizontalAlignment(JLabel.CENTER);
        Tbl_AmaDeLlaves2.getColumnModel().getColumn(0).setCellRenderer(centro);
        Tbl_AmaDeLlaves2.getColumnModel().getColumn(1).setCellRenderer(centro);

        Tbl_AmaDeLlaves2.getColumnModel().getColumn(0).setPreferredWidth(40);
        Tbl_AmaDeLlaves2.getColumnModel().getColumn(1).setPreferredWidth(140);
    }

    public void LimpiarTabla() {
        modelo1 = new DefaultTableModel();
        modelo1.addColumn("ID");
        modelo1.addColumn("NOMBRE");
        Tbl_AmaDeLlave.setModel(modelo1);

        centro.setHorizontalAlignment(JLabel.CENTER);
        Tbl_AmaDeLlave.getColumnModel().getColumn(0).setCellRenderer(centro);
        Tbl_AmaDeLlave.getColumnModel().getColumn(1).setCellRenderer(centro);

        Tbl_AmaDeLlave.getColumnModel().getColumn(0).setPreferredWidth(40);
        Tbl_AmaDeLlave.getColumnModel().getColumn(1).setPreferredWidth(140);
    }

    public void LimpiarTabla2() {
        modelo2 = new DefaultTableModel();
        modelo2.addColumn("ID");
        modelo2.addColumn("NOMBRE");
        Tbl_AmaDeLlaves2.setModel(modelo2);

        centro.setHorizontalAlignment(JLabel.CENTER);
        Tbl_AmaDeLlaves2.getColumnModel().getColumn(0).setCellRenderer(centro);
        Tbl_AmaDeLlaves2.getColumnModel().getColumn(1).setCellRenderer(centro);

        Tbl_AmaDeLlaves2.getColumnModel().getColumn(0).setPreferredWidth(40);
        Tbl_AmaDeLlaves2.getColumnModel().getColumn(1).setPreferredWidth(140);
    }

    public void Limpiar() {
        prcs_repetidos.Limpiar(Txt_buscar);
        Cbx_Gobernanta.setSelectedIndex(0);
        Cbx_Piso.setSelectedIndex(0);
        Rdb_Limpiar2.setSelected(true);
        LimpiarTabla2();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGp_tipo = new javax.swing.ButtonGroup();
        BtnGp_estado = new javax.swing.ButtonGroup();
        Pnl_ingresoDatos = new javax.swing.JPanel();
        Lbl_nombre = new javax.swing.JLabel();
        Lbl_estado = new javax.swing.JLabel();
        Rdb_Activo = new javax.swing.JRadioButton();
        Rdb_Limpiar2 = new javax.swing.JRadioButton();
        Rdb_Inactivo = new javax.swing.JRadioButton();
        Btn_fondoGuardar = new javax.swing.JPanel();
        Btn_guardar = new javax.swing.JLabel();
        Btn_fondo_eliminar = new javax.swing.JPanel();
        Btn_eliminar = new javax.swing.JLabel();
        Btn_fondo_modificar = new javax.swing.JPanel();
        Btn_modificar = new javax.swing.JLabel();
        Btn_fondo_reporte = new javax.swing.JPanel();
        Btn_reporte = new javax.swing.JLabel();
        Btn_fondo_ayuda = new javax.swing.JPanel();
        Btn_ayuda = new javax.swing.JLabel();
        Btn_fondo_cancelar = new javax.swing.JPanel();
        Btn_cancelar = new javax.swing.JLabel();
        Cbx_Gobernanta = new javax.swing.JComboBox<>();
        Lbl_nombre1 = new javax.swing.JLabel();
        Cbx_Piso = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tbl_AmaDeLlave = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tbl_AmaDeLlaves2 = new javax.swing.JTable();
        Lbl_estado1 = new javax.swing.JLabel();
        Lbl_estado2 = new javax.swing.JLabel();
        Btn_AsignarUno = new javax.swing.JButton();
        Btn_QuitarUno = new javax.swing.JButton();
        Pnl_datos = new javax.swing.JPanel();
        Lbl_codigoNombre = new javax.swing.JLabel();
        Txt_buscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Datos = new javax.swing.JTable();
        Btn_fondo_buscar = new javax.swing.JPanel();
        Btn_buscar = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(36, 47, 65));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        Pnl_ingresoDatos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_ingresoDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESO DE DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_nombre.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_nombre.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_nombre.setText("ID Gobernanta:");

        Lbl_estado.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_estado.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_estado.setText("Estado:");

        BtnGp_estado.add(Rdb_Activo);
        Rdb_Activo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        Rdb_Activo.setForeground(new java.awt.Color(255, 255, 255));
        Rdb_Activo.setText("Activo");

        BtnGp_estado.add(Rdb_Limpiar2);

        BtnGp_estado.add(Rdb_Inactivo);
        Rdb_Inactivo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        Rdb_Inactivo.setForeground(new java.awt.Color(255, 255, 255));
        Rdb_Inactivo.setText("Inactivo");

        Btn_fondoGuardar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_guardar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_guardar.setText("Insertar");
        Btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoGuardarLayout = new javax.swing.GroupLayout(Btn_fondoGuardar);
        Btn_fondoGuardar.setLayout(Btn_fondoGuardarLayout);
        Btn_fondoGuardarLayout.setHorizontalGroup(
            Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
        );
        Btn_fondoGuardarLayout.setVerticalGroup(
            Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        Btn_fondo_eliminar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_eliminar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_eliminar.setText("Eliminar");
        Btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_eliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_eliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_eliminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_eliminarLayout = new javax.swing.GroupLayout(Btn_fondo_eliminar);
        Btn_fondo_eliminar.setLayout(Btn_fondo_eliminarLayout);
        Btn_fondo_eliminarLayout.setHorizontalGroup(
            Btn_fondo_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        Btn_fondo_eliminarLayout.setVerticalGroup(
            Btn_fondo_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondo_modificar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_modificar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_modificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_modificar.setText("Modificar");
        Btn_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_modificarLayout = new javax.swing.GroupLayout(Btn_fondo_modificar);
        Btn_fondo_modificar.setLayout(Btn_fondo_modificarLayout);
        Btn_fondo_modificarLayout.setHorizontalGroup(
            Btn_fondo_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_modificarLayout.setVerticalGroup(
            Btn_fondo_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Btn_fondo_reporte.setBackground(new java.awt.Color(97, 212, 195));

        Btn_reporte.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_reporte.setText("Reporte");
        Btn_reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_reporteLayout = new javax.swing.GroupLayout(Btn_fondo_reporte);
        Btn_fondo_reporte.setLayout(Btn_fondo_reporteLayout);
        Btn_fondo_reporteLayout.setHorizontalGroup(
            Btn_fondo_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_reporteLayout.setVerticalGroup(
            Btn_fondo_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondo_ayuda.setBackground(new java.awt.Color(253, 255, 182));

        Btn_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_ayuda.setText("Ayuda");
        Btn_ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_ayudaLayout = new javax.swing.GroupLayout(Btn_fondo_ayuda);
        Btn_fondo_ayuda.setLayout(Btn_fondo_ayudaLayout);
        Btn_fondo_ayudaLayout.setHorizontalGroup(
            Btn_fondo_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_ayudaLayout.setVerticalGroup(
            Btn_fondo_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondo_cancelar.setBackground(new java.awt.Color(255, 128, 115));

        Btn_cancelar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_cancelar.setText("Cancelar");
        Btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_cancelarLayout = new javax.swing.GroupLayout(Btn_fondo_cancelar);
        Btn_fondo_cancelar.setLayout(Btn_fondo_cancelarLayout);
        Btn_fondo_cancelarLayout.setHorizontalGroup(
            Btn_fondo_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        Btn_fondo_cancelarLayout.setVerticalGroup(
            Btn_fondo_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Lbl_nombre1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_nombre1.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_nombre1.setText("NO. PISO:");

        Tbl_AmaDeLlave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tbl_AmaDeLlave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_AmaDeLlaveMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tbl_AmaDeLlave);

        Tbl_AmaDeLlaves2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tbl_AmaDeLlaves2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_AmaDeLlaves2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Tbl_AmaDeLlaves2);

        Lbl_estado1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_estado1.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_estado1.setText("Amas de Llave");

        Lbl_estado2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_estado2.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_estado2.setText("Amas de Llaves Asignadas");

        Btn_AsignarUno.setText(">");
        Btn_AsignarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AsignarUnoActionPerformed(evt);
            }
        });

        Btn_QuitarUno.setText("<");
        Btn_QuitarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_QuitarUnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Pnl_ingresoDatosLayout = new javax.swing.GroupLayout(Pnl_ingresoDatos);
        Pnl_ingresoDatos.setLayout(Pnl_ingresoDatosLayout);
        Pnl_ingresoDatosLayout.setHorizontalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_fondo_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Btn_AsignarUno, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                    .addComponent(Btn_QuitarUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(Lbl_estado1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(Lbl_estado2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Lbl_nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Lbl_nombre1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Lbl_estado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Cbx_Gobernanta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cbx_Piso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addComponent(Rdb_Activo)
                                .addGap(18, 18, 18)
                                .addComponent(Rdb_Limpiar2)
                                .addGap(18, 18, 18)
                                .addComponent(Rdb_Inactivo)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        Pnl_ingresoDatosLayout.setVerticalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_nombre)
                    .addComponent(Cbx_Gobernanta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbx_Piso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_nombre1))
                .addGap(37, 37, 37)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Rdb_Limpiar2)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Rdb_Activo)
                            .addComponent(Lbl_estado)))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Rdb_Inactivo)
                        .addGap(1, 1, 1)))
                .addGap(27, 27, 27)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_estado2)
                    .addComponent(Lbl_estado1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Btn_AsignarUno)
                        .addGap(27, 27, 27)
                        .addComponent(Btn_QuitarUno)
                        .addGap(75, 75, 75)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Pnl_datos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_datos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_codigoNombre.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_codigoNombre.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_codigoNombre.setText("Código:");

        Txt_buscar.setBackground(new java.awt.Color(36, 47, 65));
        Txt_buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txt_buscar.setForeground(new java.awt.Color(255, 255, 255));
        Txt_buscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tbl_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_DatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tbl_Datos);

        Btn_fondo_buscar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_buscar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_buscar.setText("Buscar");
        Btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_buscarLayout = new javax.swing.GroupLayout(Btn_fondo_buscar);
        Btn_fondo_buscar.setLayout(Btn_fondo_buscarLayout);
        Btn_fondo_buscarLayout.setHorizontalGroup(
            Btn_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        Btn_fondo_buscarLayout.setVerticalGroup(
            Btn_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Pnl_datosLayout = new javax.swing.GroupLayout(Pnl_datos);
        Pnl_datos.setLayout(Pnl_datosLayout);
        Pnl_datosLayout.setHorizontalGroup(
            Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_datosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addGroup(Pnl_datosLayout.createSequentialGroup()
                        .addComponent(Lbl_codigoNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7)
                            .addComponent(Txt_buscar))
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Pnl_datosLayout.setVerticalGroup(
            Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_datosLayout.createSequentialGroup()
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_fondo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Pnl_datosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Txt_buscar)
                                .addComponent(Lbl_codigoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseEntered
        Btn_fondo_reporte.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_reporteMouseEntered

    private void Btn_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseExited
        Btn_fondo_reporte.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_reporteMouseExited

    private void Btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseEntered
        Btn_fondoGuardar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_guardarMouseEntered

    private void Btn_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseEntered
        Btn_fondo_eliminar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_eliminarMouseEntered

    private void Btn_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseEntered
        Btn_fondo_modificar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_modificarMouseEntered

    private void Btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseExited
        Btn_fondoGuardar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_guardarMouseExited

    private void Btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseExited
        Btn_fondo_eliminar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_eliminarMouseExited

    private void Btn_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseExited
        Btn_fondo_modificar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_modificarMouseExited

    private void Btn_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseEntered
        Btn_fondo_ayuda.setBackground(new Color(255, 255, 63));
    }//GEN-LAST:event_Btn_ayudaMouseEntered

    private void Btn_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseExited
        Btn_fondo_ayuda.setBackground(new Color(253, 255, 182));
    }//GEN-LAST:event_Btn_ayudaMouseExited

    private void Btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseEntered
        Btn_fondo_cancelar.setBackground(new Color(255, 52, 31));
    }//GEN-LAST:event_Btn_cancelarMouseEntered

    private void Btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseExited
        Btn_fondo_cancelar.setBackground(new Color(255, 128, 115));
    }//GEN-LAST:event_Btn_cancelarMouseExited

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_fondo_buscar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
        Btn_fondo_buscar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_buscarMouseExited

    private void Btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseClicked
        if (prcs_repetidos.isSelected(Rdb_Activo, Rdb_Inactivo)) {
            String cbxGobernanta = Cbx_Gobernanta.getSelectedItem().toString();
            String cbxPiso = Cbx_Piso.getSelectedItem().toString();

            AsignacionGobernantaDAO pisosdao = new AsignacionGobernantaDAO();

            pisos.setIdGobernanta(cbxGobernanta);
            pisos.setIdPiso(cbxPiso);
            for (int i = 0; i < Tbl_AmaDeLlaves2.getRowCount(); i++) {
                String Vector[] = new String[2];
                Vector[0] = Tbl_AmaDeLlaves2.getValueAt(i, 0).toString();
                Vector[1] = Tbl_AmaDeLlaves2.getValueAt(i, 1).toString();
                pisos.setIdAmaDeLlave(Vector[0]);
                pisos.setNombreAmaDeLlave(Vector[1]);
            }
            if (Rdb_Activo.isSelected()) {
                pisos.setEstadoAsignacionGobernanta("1");
            } else if (Rdb_Inactivo.isSelected()) {
                pisos.setEstadoAsignacionGobernanta("0");
            }
            pisosdao.insert(pisos);
            actualizarTabla("");
            prcs_repetidos.AlertaMensaje("guardado", "Asignación", "exitosamente");
            Limpiar();
        } else {
        }

    }//GEN-LAST:event_Btn_guardarMouseClicked

    private void Btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseClicked
//        if (prcs_repetidos.isSelected(Rdb_Activo, Rdb_Inactivo)) {
//            String cbxGobernanta = Cbx_Gobernanta.getSelectedItem().toString();
//            String cbxLlave = Cbx_Piso.getSelectedItem().toString();
//            AsignacionGobernantaDAO pisosdao = new AsignacionGobernantaDAO();
//            pisos.setIdGobernanta(cbxGobernanta);
//            pisos.setIdAmaDeLlave(cbxLlave);
//            if (Rdb_Activo.isSelected()) {
//                pisos.setEstadoAsignacionGobernanta("1");
//            } else if (Rdb_Inactivo.isSelected()) {
//                pisos.setEstadoAsignacionGobernanta("0");
//            }
//            pisosdao.update(pisos);
//            actualizarTabla("");
//            prcs_repetidos.AlertaMensaje("modificado", "Asignación", "exitosamente");
//            Limpiar();
//        }

    }//GEN-LAST:event_Btn_modificarMouseClicked

    private void Btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseClicked
//        if (prcs_repetidos.ConfirmarEliminacion("eliminar", "Piso", this)) {
//            AsignacionGobernantaDAO pisosdao = new AsignacionGobernantaDAO();
//            String cbxGobernanta = Cbx_Gobernanta.getSelectedItem().toString();
//            pisos.setIdAsignacionGobernanta(cbxGobernanta);
//            pisosdao.delete(pisos);
//            actualizarTabla("");
//            prcs_repetidos.AlertaMensaje("eliminada", "Asignación", "exitosamente");
//            Limpiar();
//        } else {
//            JOptionPane.showMessageDialog(null, "No se pudo eliminar la asignación.");
//        }

    }//GEN-LAST:event_Btn_eliminarMouseClicked

    private void Tbl_DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_DatosMouseClicked
        if (evt.getClickCount() == 2) {
            int cadena1 = Integer.parseInt(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 1).toString());
            int cadena2 = Integer.parseInt(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 2).toString());
            int cadena3 = Integer.parseInt(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 3).toString());

            Cbx_Gobernanta.setSelectedItem(cadena1);
            Cbx_Piso.setSelectedItem(cadena2);

//            String Vector[] = new String[2];
//            Vector[0] = Tbl_AmaDeLlave.getValueAt(filaSeleccionada, 0).toString();
//            Vector[1] = Tbl_AmaDeLlave.getValueAt(filaSeleccionada, 1).toString();
//            modelo2.addRow(Vector);

            if (Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 5).toString().equals("Activo")) {
                Rdb_Activo.setSelected(true);
            } else {
                Rdb_Inactivo.setSelected(true);
            }
        }
    }//GEN-LAST:event_Tbl_DatosMouseClicked

    private void Btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseClicked
        Limpiar();
    }//GEN-LAST:event_Btn_cancelarMouseClicked

    private void Btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseClicked
        actualizarTabla(Txt_buscar.getText());
    }//GEN-LAST:event_Btn_buscarMouseClicked

    private void Btn_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseClicked
        prcs_repetidos.imprimirAyuda("AyudaMantenimientoPisos.chm");
    }//GEN-LAST:event_Btn_ayudaMouseClicked

    private void Btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseClicked
        prcs_repetidos.imprimirReporte("Rpt_MantPisos.jrxml");
    }//GEN-LAST:event_Btn_reporteMouseClicked

    private void Tbl_AmaDeLlaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_AmaDeLlaveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tbl_AmaDeLlaveMouseClicked

    private void Tbl_AmaDeLlaves2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_AmaDeLlaves2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tbl_AmaDeLlaves2MouseClicked

    private void Btn_AsignarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AsignarUnoActionPerformed
        int filaSeleccionada = Tbl_AmaDeLlave.getSelectedRow();
        if (1 == 1) {
            if (filaSeleccionada >= 0) {
                String Vector[] = new String[2];
                Vector[0] = Tbl_AmaDeLlave.getValueAt(filaSeleccionada, 0).toString();
                Vector[1] = Tbl_AmaDeLlave.getValueAt(filaSeleccionada, 1).toString();
                modelo2.addRow(Vector);
                modelo1.removeRow(filaSeleccionada);
            }
        }
    }//GEN-LAST:event_Btn_AsignarUnoActionPerformed

    private void Btn_QuitarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_QuitarUnoActionPerformed
        int filaSeleccionada = Tbl_AmaDeLlaves2.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String Vector[] = new String[2];
            Vector[0] = Tbl_AmaDeLlaves2.getValueAt(filaSeleccionada, 0).toString();
            Vector[1] = Tbl_AmaDeLlaves2.getValueAt(filaSeleccionada, 1).toString();
            modelo1.addRow(Vector);
            modelo2.removeRow(filaSeleccionada);
        }
    }//GEN-LAST:event_Btn_QuitarUnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGp_estado;
    private javax.swing.ButtonGroup BtnGp_tipo;
    private javax.swing.JButton Btn_AsignarUno;
    private javax.swing.JButton Btn_QuitarUno;
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JLabel Btn_buscar;
    private javax.swing.JLabel Btn_cancelar;
    private javax.swing.JLabel Btn_eliminar;
    private javax.swing.JPanel Btn_fondoGuardar;
    private javax.swing.JPanel Btn_fondo_ayuda;
    private javax.swing.JPanel Btn_fondo_buscar;
    private javax.swing.JPanel Btn_fondo_cancelar;
    private javax.swing.JPanel Btn_fondo_eliminar;
    private javax.swing.JPanel Btn_fondo_modificar;
    private javax.swing.JPanel Btn_fondo_reporte;
    private javax.swing.JLabel Btn_guardar;
    private javax.swing.JLabel Btn_modificar;
    private javax.swing.JLabel Btn_reporte;
    private javax.swing.JComboBox<String> Cbx_Gobernanta;
    private javax.swing.JComboBox<String> Cbx_Piso;
    private javax.swing.JLabel Lbl_codigoNombre;
    private javax.swing.JLabel Lbl_estado;
    private javax.swing.JLabel Lbl_estado1;
    private javax.swing.JLabel Lbl_estado2;
    private javax.swing.JLabel Lbl_nombre;
    private javax.swing.JLabel Lbl_nombre1;
    private javax.swing.JPanel Pnl_datos;
    private javax.swing.JPanel Pnl_ingresoDatos;
    private javax.swing.JRadioButton Rdb_Activo;
    private javax.swing.JRadioButton Rdb_Inactivo;
    private javax.swing.JRadioButton Rdb_Limpiar2;
    private javax.swing.JTable Tbl_AmaDeLlave;
    private javax.swing.JTable Tbl_AmaDeLlaves2;
    private javax.swing.JTable Tbl_Datos;
    private javax.swing.JTextField Txt_buscar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator7;
    // End of variables declaration//GEN-END:variables
}
