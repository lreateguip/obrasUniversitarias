package vista.planificacion;

import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.planificacionDTO.Usuario;

public class FPlanificacion extends javax.swing.JFrame {

    private FUsuario venUsu = null;
    private FRepositorio venRep = null;
    private VenContacto venCont = null;
    private Usuario usuLog = null;

    public FPlanificacion(Usuario usuLog) throws Exception {
        //INICIA LOS COMPONENTES GRAFICOS
        initComponents();
        //ACTUALIZAMOS EL USUARIO QUE INICIÓ SESIÓN
        this.usuLog = usuLog;
        //SEGUN EL ROL DEL USUSARIO ACTIVAMOS LOS COMPONENTES PERMITIDOS
        habilitarOpciones(this.usuLog.getRol());
        //CONFIGURACIÓN BASICA DE ESTA VENTANA
        configurarVentana();
        iniciarFechaHora(lbFecha, lbHora);
        actualizarDatosLog();
    }

    private void iniciarFechaHora(JLabel lbFecha, JLabel lbHora) {
        String strDateFormat = "yyyy-MMM-dd HH:mm:ss"; // El formato de fecha está especificado  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

        Thread proc = new Thread(() -> {
            while (true) {
                String fecha_hora[] = objSDF.format(new Date()).split(" ");
                lbFecha.setText(fecha_hora[0]);
                lbHora.setText(fecha_hora[1]);
            }
        });
        proc.start();
    }

    private void actualizarDatosLog() {
        lbNombreUsuario.setText(usuLog.getNombre());
        lbRol.setText(usuLog.getRol());
    }

    private void configurarVentana() {
        setTitle("JEFATURA DE PLANIFICACCIÓN - USUARIO: " + usuLog.getUsuario());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void habilitarOpciones(String rol) {
        //EVALUAMOS EL ROL Y ACTIVAMOS EL GRUPO DE OPCIONES RESPECTIVAS
        switch (rol.toLowerCase()) {
            case "administrador":
                activarRolAdmin();
                break;
            case "asistente":
                activarRolAsistente();
                break;
            default:
                JOptionPane.showMessageDialog(this, "El usuario no tiene un rol válido", "INICIO DE SESIÓN", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }

    private void activarRolAdmin() {
        btnConfiguracion.setEnabled(true);
        btnRepositorio.setEnabled(true);
        btnSalir.setEnabled(true);
        btnUsuarios.setEnabled(true);
    }

    private void activarRolAsistente() {
        btnRepositorio.setEnabled(true);
        btnSalir.setEnabled(true);
    }

    public static void getSemFin() {
        GregorianCalendar gc = new GregorianCalendar();
        int day = 0;
        gc.add(Calendar.DATE, day);
        //semFin = gc.get(Calendar.WEEK_OF_YEAR) + gc.get(Calendar.YEAR);
    }

    //CONFIGURAR EL ICONO DEL JFRAME REPOSITORIO
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("images/infra.png"));
        return retValue;
    }

    private void cerrarTodasVentanas() {
        for (JInternalFrame ven : escritorio.getAllFrames()) {
            ven.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEscritorio = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        panel_mantenimiento = new javax.swing.JPanel();
        btnRepositorio = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnConfiguracion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbImagenUsuario = new javax.swing.JLabel();
        lbNombreUsuario = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        lbRol = new javax.swing.JLabel();
        barra_menu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemCerrarSesion = new javax.swing.JMenuItem();
        menuSoporte2 = new javax.swing.JMenu();
        itemContacto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JEFETURA DE PLANIFICACIÓN");
        setBackground(new java.awt.Color(0, 102, 255));
        setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        panelEscritorio.setBackground(getBackground());
        panelEscritorio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        panelEscritorio.setOpaque(false);
        panelEscritorio.setLayout(new java.awt.BorderLayout());

        escritorio.setToolTipText("Escritorio de trabajo");
        escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );

        panelEscritorio.add(escritorio, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelEscritorio, java.awt.BorderLayout.CENTER);

        panel_mantenimiento.setBackground(getBackground());
        panel_mantenimiento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        panel_mantenimiento.setToolTipText("");

        btnRepositorio.setBackground(getForeground());
        btnRepositorio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRepositorio.setForeground(getBackground());
        btnRepositorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/repositorio64.png"))); // NOI18N
        btnRepositorio.setText("Repositorio");
        btnRepositorio.setToolTipText("Mantenimiento de productos de reciclaje");
        btnRepositorio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRepositorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRepositorio.setEnabled(false);
        btnRepositorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRepositorio.setMaximumSize(new java.awt.Dimension(105, 105));
        btnRepositorio.setMinimumSize(new java.awt.Dimension(105, 105));
        btnRepositorio.setPreferredSize(new java.awt.Dimension(105, 105));
        btnRepositorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRepositorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepositorioActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(getForeground());
        btnUsuarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUsuarios.setForeground(getBackground());
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuarios64.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setToolTipText("Mantenimiento de los donantes");
        btnUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setEnabled(false);
        btnUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setMaximumSize(new java.awt.Dimension(105, 105));
        btnUsuarios.setMinimumSize(new java.awt.Dimension(105, 105));
        btnUsuarios.setPreferredSize(new java.awt.Dimension(105, 105));
        btnUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnConfiguracion.setBackground(getForeground());
        btnConfiguracion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConfiguracion.setForeground(getBackground());
        btnConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/config64.png"))); // NOI18N
        btnConfiguracion.setText("Configuración");
        btnConfiguracion.setToolTipText("Realizar la recepción de reciclaje");
        btnConfiguracion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguracion.setEnabled(false);
        btnConfiguracion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConfiguracion.setMaximumSize(new java.awt.Dimension(105, 105));
        btnConfiguracion.setMinimumSize(new java.awt.Dimension(105, 105));
        btnConfiguracion.setPreferredSize(new java.awt.Dimension(105, 105));
        btnConfiguracion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });

        btnSalir.setBackground(getForeground());
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setForeground(getBackground());
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salir64.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("Ajustes del sistema");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setMaximumSize(new java.awt.Dimension(105, 105));
        btnSalir.setMinimumSize(new java.awt.Dimension(105, 105));
        btnSalir.setPreferredSize(new java.awt.Dimension(105, 105));
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel1.setBackground(getForeground());
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(getBackground());

        lbImagenUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagenUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pefil64.png"))); // NOI18N

        lbNombreUsuario.setForeground(panel_mantenimiento.getBackground());
        lbNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNombreUsuario.setText("Usuario");

        lbFecha.setForeground(panel_mantenimiento.getBackground());
        lbFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha.setText("Fecha");

        lbHora.setForeground(panel_mantenimiento.getBackground());
        lbHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHora.setText("Hora");

        lbRol.setForeground(panel_mantenimiento.getBackground());
        lbRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRol.setText("Rol");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbImagenUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbNombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbImagenUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_mantenimientoLayout = new javax.swing.GroupLayout(panel_mantenimiento);
        panel_mantenimiento.setLayout(panel_mantenimientoLayout);
        panel_mantenimientoLayout.setHorizontalGroup(
            panel_mantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mantenimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_mantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRepositorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_mantenimientoLayout.setVerticalGroup(
            panel_mantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_mantenimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRepositorio, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panel_mantenimiento, java.awt.BorderLayout.WEST);

        barra_menu.setBackground(new java.awt.Color(204, 204, 204));
        barra_menu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        barra_menu.setForeground(new java.awt.Color(255, 255, 255));
        barra_menu.setToolTipText("");
        barra_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        barra_menu.setOpaque(false);

        menuArchivo.setBackground(new java.awt.Color(102, 102, 102));
        menuArchivo.setForeground(getForeground());
        menuArchivo.setText("Archivo");
        menuArchivo.setFont(barra_menu.getFont());

        itemCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        itemCerrarSesion.setFont(barra_menu.getFont());
        itemCerrarSesion.setText("Cerrar sesión");
        itemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarSesionActionPerformed(evt);
            }
        });
        menuArchivo.add(itemCerrarSesion);

        barra_menu.add(menuArchivo);

        menuSoporte2.setBackground(new java.awt.Color(102, 102, 102));
        menuSoporte2.setForeground(getForeground());
        menuSoporte2.setText("Soporte");
        menuSoporte2.setFont(barra_menu.getFont());

        itemContacto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itemContacto.setFont(barra_menu.getFont());
        itemContacto.setText("Contacto");
        itemContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemContactoActionPerformed(evt);
            }
        });
        menuSoporte2.add(itemContacto);

        barra_menu.add(menuSoporte2);

        setJMenuBar(barra_menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Desea salir del sistema", "Salir del sistema", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed

    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        try {
            if (venUsu == null || !venUsu.isShowing()) {
                venUsu = new FUsuario();
                venUsu.setVisible(true);
                escritorio.add(venUsu);
                venUsu.setSelected(true);
            } else {
                venUsu.setSelected(true);
            }
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FPlanificacion.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnRepositorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepositorioActionPerformed
        try {
            if (venRep == null || venRep.isShowing()) {
                venRep = new FRepositorio(usuLog);
                venRep.setVisible(true);
                escritorio.add(venRep);
                venRep.setSelected(true);
            } else {
                venRep.setSelected(true);
            }
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FPlanificacion.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRepositorioActionPerformed

    private void itemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarSesionActionPerformed
        btnSalirActionPerformed(evt);
    }//GEN-LAST:event_itemCerrarSesionActionPerformed

    private void itemContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemContactoActionPerformed
        try {
            if (venCont == null || venCont.isClosed()) {
                venCont = new VenContacto();
                venCont.setVisible(true);
                escritorio.add(venCont);
                venCont.setSelected(true);
            } else {
                venCont.setSelected(true);
            }
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FPlanificacion.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemContactoActionPerformed

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
            java.util.logging.Logger.getLogger(FPlanificacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPlanificacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPlanificacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPlanificacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barra_menu;
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnRepositorio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemContacto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbImagenUsuario;
    private javax.swing.JLabel lbNombreUsuario;
    private javax.swing.JLabel lbRol;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuSoporte2;
    private javax.swing.JPanel panelEscritorio;
    private javax.swing.JPanel panel_mantenimiento;
    // End of variables declaration//GEN-END:variables
}
