package vista.planificacion;

import Validaciones.Validaciones;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.bodegaDTO.FormatoTablas;
import modelo.planificacionDAO.UsuarioDAO;
import modelo.planificacionDTO.Usuario;

public class FUsuario extends javax.swing.JInternalFrame {

    UsuarioDAO usuDao;
    private int id = 0;

    public FUsuario() {
        initComponents();
        usuDao = new UsuarioDAO();

        consultarUsuarios();

        FormatoTablas.setOrdenar(tblUsuario);
        FormatoTablas.setCellRender(tblUsuario);
        activarCamposUsuario(false);
    }

    private void consultarUsuarios() {
        FormatoTablas.limpiarTabla(tblUsuario);
        for (Usuario usuario : usuDao.consulta_usuarios()) {
            ((DefaultTableModel) tblUsuario.getModel()).addRow(usuario.getFila());
        }
        int count = tblUsuario.getRowCount();
        lblObservacion.setText("Se encontrarón " + count + " registros");
    }

    private void insertarUsuario() {
        String USUARIO = txtUsuario.getText();
        String CONTRASEÑA = txtContraseña.getText();
        String NOMBRE = txtNombre.getText();
        String ROL = cmbRol.getSelectedItem().toString();
        String ESTADO = cmbEstado.getSelectedItem().toString();

        //creamos la instancia del usuario a insertar
        Usuario u = new Usuario(id, USUARIO, CONTRASEÑA, NOMBRE, ESTADO, ROL);
        if (id == 0) {
            if (usuDao.insertar_usuario(u) == 1) {
                JOptionPane.showMessageDialog(this, "Usuario registrado con éxito", "REGISTRO DE USUARIO", JOptionPane.INFORMATION_MESSAGE);
                limpiarCamposUsuario();
                activarCamposUsuario(false);
                btnGuardar.setEnabled(false);
                btnBuscarActionPerformed(null);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no registrado", "REGISTRO DE USUARIO", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (usuDao.actualizar_usuario(u) == 1) {
                JOptionPane.showMessageDialog(this, "Usuario actualizado con éxito", "ACTUALIZACIÓN DE USUARIO", JOptionPane.INFORMATION_MESSAGE);
                limpiarCamposUsuario();
                activarCamposUsuario(false);
                btnGuardar.setEnabled(false);
                btnBuscarActionPerformed(null);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no actualizado", "ACTUALIZACIÓN DE USUARIO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarUsuario() {
        if (id != 0) {
            if (usuDao.eliminar_usuario(id) == 1) {
                JOptionPane.showMessageDialog(this, "Usuario eliminado con éxito", "ELIMINACIÓN DE USUARIO", JOptionPane.INFORMATION_MESSAGE);
                limpiarCamposUsuario();
                activarCamposUsuario(false);
                btnBuscarActionPerformed(null);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no eliminado", "ELIMINACIÓN DE USUARIO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void obtenerDatosUsuarioTabla() {
        //obtenemos el valor de la fila seleccionada por el clic
        int fila = tblUsuario.getSelectedRow();
        //obtenenos todos los datos de esa fila y asignamos esos valores a cada campo correspondiente
        id = Integer.parseInt(tblUsuario.getValueAt(fila, 0).toString());
        txtUsuario.setText(tblUsuario.getValueAt(fila, 1).toString());
        txtContraseña.setText(tblUsuario.getValueAt(fila, 2).toString());
        txtNombre.setText(tblUsuario.getValueAt(fila, 3).toString());
        cmbRol.setSelectedItem(tblUsuario.getValueAt(fila, 4));
        cmbEstado.setSelectedItem(tblUsuario.getValueAt(fila, 5));
    }//fin de método

    private void activarCamposUsuario(boolean activar) {
        txtUsuario.setEnabled(activar);
        txtContraseña.setEnabled(activar);
        txtNombre.setEnabled(activar);
        cmbRol.setEnabled(activar);
        cmbEstado.setEnabled(activar);
    }

    private boolean validarCamposUsuario() {
        boolean lleno = true;
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.setBackground(Color.yellow);
            lleno = false;
        }
        if (txtContraseña.getText().isEmpty()) {
            txtContraseña.setBackground(Color.yellow);
            lleno = false;
        }
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setBackground(Color.yellow);
            lleno = false;
        }
        if (cmbRol.getSelectedIndex() == 0) {
            cmbRol.setBackground(Color.yellow);
            lleno = false;
        }

        if (cmbEstado.getSelectedIndex() == 0) {
            cmbEstado.setBackground(Color.yellow);
            lleno = false;
        }

        return lleno;
    }

    private void limpiarCamposUsuario() {
        txtUsuario.setText("");
        txtContraseña.setText("");
        txtNombre.setText("");
        cmbRol.setSelectedIndex(0);
        cmbEstado.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        panelUsuarios = new javax.swing.JPanel();
        panelTabla = new javax.swing.JPanel();
        scrollTablaUsuario = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        panelPiesR = new javax.swing.JPanel();
        lblObservacion = new javax.swing.JLabel();
        btnLimpiar1 = new javax.swing.JButton();
        pnlIzq = new javax.swing.JPanel();
        panelCampos2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        cmbEstado = new javax.swing.JComboBox<>();
        txtContraseña = new rojeru_san.RSMPassView();
        btnBuscar = new javax.swing.JButton();
        panelControl = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 255));
        setClosable(true);
        setForeground(new java.awt.Color(255, 255, 255));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MANTENIMIENTO DE USUARIOS");
        setToolTipText("");
        setAutoscrolls(true);
        setDesktopIcon(getDesktopIcon());
        setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        setFrameIcon(null);
        setMaximumSize(new java.awt.Dimension(1200, 650));
        setMinimumSize(new java.awt.Dimension(999, 531));
        setPreferredSize(new java.awt.Dimension(1200, 650));

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTitulo.setForeground(getForeground());
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuarios16.png"))); // NOI18N
        lbTitulo.setText("MANTENIMIENTO DE USUARIOS");

        panelUsuarios.setBackground(new java.awt.Color(204, 204, 204));
        panelUsuarios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelUsuarios.setLayout(new java.awt.BorderLayout(5, 5));

        panelTabla.setBackground(new java.awt.Color(102, 102, 102));
        panelTabla.setLayout(new java.awt.BorderLayout());

        scrollTablaUsuario.setBackground(getBackground());
        scrollTablaUsuario.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollTablaUsuario.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollTablaUsuario.setAutoscrolls(true);

        tblUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        tblUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USUARIO", "CONTRASEÑA", "NOMBRE", "ROL", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuario.setToolTipText("");
        tblUsuario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblUsuario.setColumnSelectionAllowed(true);
        tblUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblUsuario.setFocusable(false);
        tblUsuario.setRowHeight(20);
        tblUsuario.setSelectionBackground(new java.awt.Color(0, 102, 255));
        tblUsuario.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblUsuario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseClicked(evt);
            }
        });
        scrollTablaUsuario.setViewportView(tblUsuario);
        tblUsuario.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblUsuario.getColumnModel().getColumnCount() > 0) {
            tblUsuario.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblUsuario.getColumnModel().getColumn(0).setMaxWidth(30);
            tblUsuario.getColumnModel().getColumn(1).setMinWidth(200);
            tblUsuario.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblUsuario.getColumnModel().getColumn(1).setMaxWidth(200);
            tblUsuario.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblUsuario.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblUsuario.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblUsuario.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        panelTabla.add(scrollTablaUsuario, java.awt.BorderLayout.CENTER);

        panelUsuarios.add(panelTabla, java.awt.BorderLayout.CENTER);

        panelPiesR.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelPiesR.setPreferredSize(new java.awt.Dimension(717, 50));
        panelPiesR.setLayout(new java.awt.BorderLayout());

        lblObservacion.setBackground(new java.awt.Color(204, 204, 204));
        lblObservacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblObservacion.setText("Observación");
        panelPiesR.add(lblObservacion, java.awt.BorderLayout.CENTER);

        btnLimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/btnLimpiar48.png"))); // NOI18N
        btnLimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar1.setMaximumSize(new java.awt.Dimension(50, 50));
        btnLimpiar1.setMinimumSize(new java.awt.Dimension(50, 50));
        btnLimpiar1.setPreferredSize(new java.awt.Dimension(50, 50));
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });
        panelPiesR.add(btnLimpiar1, java.awt.BorderLayout.EAST);

        panelUsuarios.add(panelPiesR, java.awt.BorderLayout.SOUTH);

        pnlIzq.setBackground(new java.awt.Color(204, 204, 204));
        pnlIzq.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlIzq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlIzq.setOpaque(false);

        panelCampos2.setBackground(getBackground());
        panelCampos2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        panelCampos2.setOpaque(false);

        jLabel2.setFont(pnlIzq.getFont());
        jLabel2.setForeground(getForeground());
        jLabel2.setText("Usuario");

        txtUsuario.setFont(pnlIzq.getFont());
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        jLabel4.setFont(pnlIzq.getFont());
        jLabel4.setForeground(getForeground());
        jLabel4.setText("Estado");

        jLabel5.setFont(pnlIzq.getFont());
        jLabel5.setForeground(getForeground());
        jLabel5.setText("Constraseña");

        txtNombre.setFont(pnlIzq.getFont());
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel6.setFont(pnlIzq.getFont());
        jLabel6.setForeground(getForeground());
        jLabel6.setText("Nombre");

        jLabel7.setFont(pnlIzq.getFont());
        jLabel7.setForeground(getForeground());
        jLabel7.setText("Rol");

        cmbRol.setFont(pnlIzq.getFont());
        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "ADMINISTRADOR", "ASISTENTE" }));

        cmbEstado.setFont(pnlIzq.getFont());
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "ACTIVO", "INACTIVO" }));

        txtContraseña.setFont(pnlIzq.getFont());
        txtContraseña.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtContraseña.setPlaceholder("");

        javax.swing.GroupLayout panelCampos2Layout = new javax.swing.GroupLayout(panelCampos2);
        panelCampos2.setLayout(panelCampos2Layout);
        panelCampos2Layout.setHorizontalGroup(
            panelCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCampos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelCampos2Layout.createSequentialGroup()
                        .addGroup(panelCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        panelCampos2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtContraseña, txtNombre, txtUsuario});

        panelCampos2Layout.setVerticalGroup(
            panelCampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCampos2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCampos2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtContraseña, txtNombre, txtUsuario});

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/find.png"))); // NOI18N
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setMaximumSize(new java.awt.Dimension(50, 50));
        btnBuscar.setMinimumSize(new java.awt.Dimension(50, 50));
        btnBuscar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlIzqLayout = new javax.swing.GroupLayout(pnlIzq);
        pnlIzq.setLayout(pnlIzqLayout);
        pnlIzqLayout.setHorizontalGroup(
            pnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIzqLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCampos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlIzqLayout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlIzqLayout.setVerticalGroup(
            pnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIzqLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCampos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 21, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelControl.setBackground(new java.awt.Color(204, 204, 204));
        panelControl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelControl.setPreferredSize(new java.awt.Dimension(717, 50));
        panelControl.setLayout(new javax.swing.BoxLayout(panelControl, javax.swing.BoxLayout.LINE_AXIS));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnNuevo.setToolTipText("Crea un nuevo producto");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setMaximumSize(new java.awt.Dimension(50, 50));
        btnNuevo.setMinimumSize(new java.awt.Dimension(50, 50));
        btnNuevo.setPreferredSize(new java.awt.Dimension(50, 50));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelControl.add(btnNuevo);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        btnGuardar.setToolTipText("Añadir producto");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setEnabled(false);
        btnGuardar.setMaximumSize(new java.awt.Dimension(50, 50));
        btnGuardar.setMinimumSize(new java.awt.Dimension(50, 50));
        btnGuardar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelControl.add(btnGuardar);

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/btnActualizar50.png"))); // NOI18N
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setEnabled(false);
        btnActualizar.setMaximumSize(new java.awt.Dimension(50, 50));
        btnActualizar.setMinimumSize(new java.awt.Dimension(50, 50));
        btnActualizar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        panelControl.add(btnActualizar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/btnEliminar48.png"))); // NOI18N
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setEnabled(false);
        btnEliminar.setMaximumSize(new java.awt.Dimension(50, 50));
        btnEliminar.setMinimumSize(new java.awt.Dimension(50, 50));
        btnEliminar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelControl.add(btnEliminar);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/btnLimpiar48.png"))); // NOI18N
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setEnabled(false);
        btnLimpiar.setMaximumSize(new java.awt.Dimension(50, 50));
        btnLimpiar.setMinimumSize(new java.awt.Dimension(50, 50));
        btnLimpiar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        panelControl.add(btnLimpiar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/btnCancelar42.png"))); // NOI18N
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setMaximumSize(new java.awt.Dimension(50, 50));
        btnCancelar.setMinimumSize(new java.awt.Dimension(50, 50));
        btnCancelar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelControl.add(btnCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlIzq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelControl, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlIzq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseClicked
        activarCamposUsuario(false);
        obtenerDatosUsuarioTabla();
        btnGuardar.setEnabled(false);
        btnLimpiar.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_tblUsuarioMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        activarCamposUsuario(true);
        txtUsuario.requestFocus();
        btnGuardar.setEnabled(true);
        btnLimpiar.setEnabled(true);
        id = 0;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validarCamposUsuario()) {
            if (JOptionPane.showConfirmDialog(this, "Desea realizar esta operación", "Registro de usuario", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                insertarUsuario();
            }
        }//fin validarCampos
        else {
            JOptionPane.showMessageDialog(this, "Existen campos vacíos que debe llenar", "Registro de usuario", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        activarCamposUsuario(true);
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtUsuario.requestFocus();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCamposUsuario();
        activarCamposUsuario(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnLimpiar.setEnabled(false);
        btnActualizar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Desea eliminar este registro", "Eliminación de usuario", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
            eliminarUsuario();
            limpiarCamposUsuario();
            activarCamposUsuario(false);
            btnGuardar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarUsuarios();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCamposUsuario();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        Validaciones.validarIngresoLetras(evt);
        Validaciones.cambiarLetraMayus(evt);
        Validaciones.resaltarVacio(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        FormatoTablas.limpiarTabla(tblUsuario);
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        Validaciones.cambiarLetraMinus(evt);
        Validaciones.resaltarVacio(evt);
    }//GEN-LAST:event_txtUsuarioKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lblObservacion;
    private javax.swing.JPanel panelCampos2;
    private javax.swing.JPanel panelControl;
    private javax.swing.JPanel panelPiesR;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JPanel panelUsuarios;
    private javax.swing.JPanel pnlIzq;
    private javax.swing.JScrollPane scrollTablaUsuario;
    private javax.swing.JTable tblUsuario;
    private rojeru_san.RSMPassView txtContraseña;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
