package vista.planificacion;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JOptionPane;
import modelo.planificacionDAO.UsuarioDAO;
import modelo.planificacionDTO.Usuario;

public class FConfiguracion extends javax.swing.JDialog {

    UsuarioDAO operDAO = null;
    Usuario usuLog;

    public FConfiguracion(Frame frame, boolean bln, Usuario usuLog) throws IOException {
        super(frame, bln);
        initComponents();
        this.usuLog = usuLog;
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("images/loginJefPla.png"));
        return retValue;
    }
    
    public void limpiarContraseñas(){
        txfClaveActual.setText("");
        txfNuevaClave1.setText("");
        txfNuevaClave2.setText("");
    }

    private void cambiarContraseña() {
        String contraseñaActual = txfClaveActual.getText();
        String nuevaContraseña1 = txfNuevaClave1.getText();
        String nuevaContraseña2 = txfNuevaClave2.getText();

        //VERIFICAMOS QUE TODOS LOS CAMPOS DE CONTRASEÑAS ESTEN LLENOS
        if (!contraseñaActual.isEmpty() && !nuevaContraseña1.isEmpty() && !nuevaContraseña2.isEmpty()) {
            
            if (nuevaContraseña1.equals(nuevaContraseña2)) {//VERIFICAMOS QUE LA NUEVA CONTRASEÑA COINCIDA
                if(usuLog.getContraseña().equals(contraseñaActual)){
                    UsuarioDAO operDao = new UsuarioDAO();
                    usuLog.setContraseña(nuevaContraseña1);
                    if(operDao.cambiarContraseña(usuLog)==1){
                        JOptionPane.showMessageDialog(this, "Contreseña actualizada con éxito", "CAMBIO DE CONTRASEÑA", JOptionPane.INFORMATION_MESSAGE);
                        limpiarContraseñas();;
                    }else{
                        JOptionPane.showMessageDialog(this, "Error al actualizar contraseña", "CAMBIO DE CONTRASEÑA", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "La contraseña actual no coinciden", "CAMBIO DE CONTRASEÑA", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La nueva contraseña no coinciden", "CAMBIO DE CONTRASEÑA", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar las contraseñas", "CAMBIO DE CONTRASEÑA", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_login = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlCambioClave = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txfClaveActual = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txfNuevaClave1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txfNuevaClave2 = new javax.swing.JPasswordField();
        btnConfirmar = new rojeru_san.RSButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración de cuenta");
        setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        setResizable(false);

        pnl_login.setBackground(new java.awt.Color(0, 102, 255));
        pnl_login.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnl_login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/config16.png"))); // NOI18N
        lbTitulo.setText("CONFIGURACIÓN");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        pnlCambioClave.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambio de contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlCambioClave.setOpaque(false);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Constraseña actual");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nueva constraseña");

        txfNuevaClave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNuevaClave1ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Repita nueva constraseña");

        btnConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setForeground(new java.awt.Color(0, 112, 192));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setColorText(new java.awt.Color(0, 112, 192));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCambioClaveLayout = new javax.swing.GroupLayout(pnlCambioClave);
        pnlCambioClave.setLayout(pnlCambioClaveLayout);
        pnlCambioClaveLayout.setHorizontalGroup(
            pnlCambioClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCambioClaveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCambioClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfClaveActual)
                    .addComponent(txfNuevaClave1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfNuevaClave2)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCambioClaveLayout.setVerticalGroup(
            pnlCambioClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCambioClaveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfClaveActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNuevaClave1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNuevaClave2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCambioClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCambioClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_loginLayout = new javax.swing.GroupLayout(pnl_login);
        pnl_login.setLayout(pnl_loginLayout);
        pnl_loginLayout.setHorizontalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginLayout.createSequentialGroup()
                .addGroup(pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_loginLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_loginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_loginLayout.setVerticalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnl_login, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        cambiarContraseña();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txfNuevaClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNuevaClave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNuevaClave1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnConfirmar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnlCambioClave;
    private javax.swing.JPanel pnl_login;
    private javax.swing.JPasswordField txfClaveActual;
    private javax.swing.JPasswordField txfNuevaClave1;
    private javax.swing.JPasswordField txfNuevaClave2;
    // End of variables declaration//GEN-END:variables
}
