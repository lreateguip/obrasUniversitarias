package vista.planificacion;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.planificacionDAO.ArchivoDAO;
import modelo.planificacionDTO.Archivo;
import modelo.planificacionDTO.Usuario;

/**
 *
 * @author Luis Reategui
 */
public class FRepositorio extends javax.swing.JInternalFrame {

    /**
     * Creates new form FRepositorio
     */
    Usuario usuLog = null;
    Archivo archivoLoc = null;
    Thread proc;
    ArrayList<Archivo> lstArchivos;
    ArrayList<Archivo> lstArchivosSubir;
    ArchivoDAO docDAO = new ArchivoDAO();

    public FRepositorio(Usuario usuLog) {
        initComponents();
        this.usuLog = usuLog;
        actualizarDatosLog();
    }

    private void actualizarDatosLog() {
        setTitle("VENTANA REPOSITORIO - " + usuLog.getUsuario());
    }

    private void consultarArchivos() {
        lstArchivos = new ArrayList<>();
        try {
            String imagen = "";//RUTA DE LA IMAGEN DE ARCHIVO POR DEFECTO

            panel_repositorio.removeAll();//LIMPIAMOS TODO EL PANEL ANTES DE CONSULTAR LOS ARCHIVOS

            lstArchivos = docDAO.consultarArchivos(); //OBTENEMOS LA LISTA DE TODOS LOS ARCHIVOS DE LA BASE DE DATOS
            for (Archivo archivo : lstArchivos) {

                switch (archivo.getExtension().toLowerCase()) {
                    case "doc":
                    case "docx":
                        imagen = "/images/word38.png";
                        break;
                    case "xls":
                    case "xlsx":
                        imagen = "/images/excel38.png";
                        break;
                    case "pdf":
                        imagen = "/images/pdf38.png";
                        break;
                    case "txt":
                        imagen = "/images/txt38.png";
                        break;
                    case "dwg":
                        imagen = "/images/dwg38.png";
                        break;
                    default:
                        imagen = "/images/no38.png";
                        break;
                }
                //asignamos la imagen correspondiente al archivo según la extensión
                archivo.setImagen(imagen);

                //CREAMOS UN OBJETO GRAFICO DEL ARCHIVOS CON LOS DATOS DE CADA OBJETO OBTENEIDO DE LA BASE
                FArchivo docGraf = new FArchivo(archivo);
                //AGREGAMOS EL OBJETO GRAFICO DE ARCHIVO AL PANEL CON EL GRIDLAYOUT
                panel_repositorio.add(docGraf);

                //asignamos un evento para recuperar el objeto al darle un clic
                docGraf.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        archivoLoc = docGraf.getArchivo();
                        if (me.getButton() == 3) {//CLIC DERECHO
                            if (JOptionPane.showConfirmDialog(panel_repositorio, archivoLoc.toString() + "\n\n¿Desea descargar este archivo?",
                                    "DESCARGAR ARCHIVO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                                //preparacion del nombre del archivo incluido su extensión

                                File archivoDescargado = new File("C:/Archivos/" + archivoLoc.getTitulo() + "." + archivoLoc.getExtension());
                                try {
                                    int op = 0;
                                    if (archivoDescargado.exists()) {
                                        op = JOptionPane.showConfirmDialog(null, "Archivo ya existe.\nDesear sobreescribirlo?",
                                                "DESCARGAR DE ARCHIVO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                    }
                                    if (op == 0) {
                                        try (FileOutputStream fos = new FileOutputStream(archivoDescargado)) {
                                            byte[] buffer = new byte[1024];
                                            while (archivoLoc.getImput().read(buffer) > 0) {
                                                fos.write(buffer);
                                            }
                                        }
                                    }
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(FRepositorio.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(FRepositorio.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                });
                validate(); //CONFIRMAMOS LOS CAMBIOS GRAFICOS
                repaint();
            }
            lbEncontrados.setText("Archivos encontrados: " + lstArchivos.size());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void consultarCriterio(String criterio) {
        lstArchivos = new ArrayList<>();
        String imagen;//PARA RUTA DE LA IMAGEN DE ARCHIVO

        panel_repositorio.removeAll();//LIMPIAMOS TODO EL PANEL ANTES DE CONSULTAR LOS ARCHIVOS

        lstArchivos = docDAO.consultarArchivosPorCriterio(criterio); //OBTENEMOS LA LISTA DE TODOS LOS ARCHIVOS DE LA BASE DE DATOS

        for (Archivo archivo : lstArchivos) {

            switch (archivo.getExtension().toLowerCase()) {
                case "doc":
                case "docx":
                    imagen = "/images/word38.png";
                    break;
                case "xls":
                case "xlsx":
                    imagen = "/images/excel38.png";
                    break;
                case "pdf":
                    imagen = "/images/pdf38.png";
                    break;
                case "txt":
                    imagen = "/images/txt38.png";
                    break;
                case "dwg":
                    imagen = "/images/dwg38.png";
                    break;
                default:
                    imagen = "/images/no38.png";
                    break;
            }
            //asignamos la imagen correspondiente al archivo según la extensión
            archivo.setImagen(imagen);

            //CREAMOS UN OBJETO GRAFICO DEL ARCHIVOS CON LOS DATOS DE CADA OBJETO OBTENEIDO DE LA BASE
            FArchivo docGraf = new FArchivo(archivo);
            //AGREGAMOS EL OBJETO GRAFICO DE ARCHIVO AL PANEL CON EL GRIDLAYOUT
            panel_repositorio.add(docGraf);

            //asignamos un evento para recuperar el objeto al darle un clic
            docGraf.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    archivoLoc = docGraf.getArchivo();
                    if (me.getButton() == 3) {//CLIC DERECHO
                        if (JOptionPane.showConfirmDialog(panel_repositorio, archivoLoc.toString() + "\n\n¿Desea descargar este archivo?",
                                "DESCARGAR ARCHIVO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                            //preparacion del nombre del archivo incluido su extensión

                            File archivoDescargado = new File("C:/Archivos/" + archivoLoc.getTitulo() + "." + archivoLoc.getExtension());
                            try {
                                int op = 0;
                                if (archivoDescargado.exists()) {
                                    op = JOptionPane.showConfirmDialog(null, "Archivo ya existe.\nDesear sobreescribirlo?",
                                            "DESCARGAR DE ARCHIVO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                }
                                if (op == 0) {
                                    try (FileOutputStream fos = new FileOutputStream(archivoDescargado)) {
                                        byte[] buffer = new byte[1024];
                                        while (archivoLoc.getImput().read(buffer) > 0) {
                                            fos.write(buffer);
                                        }
                                    }
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(FRepositorio.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(FRepositorio.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            });
            repaint();
        }
        lbEncontrados.setText("Archivos encontrados: " + lstArchivos.size());
    }

    private void eliminarArchivos() {
        ArrayList<Integer> lstIDEliminar = new ArrayList<>();
        ArchivoDAO oper = new ArchivoDAO();
        //RECORRE EL PANEL DE ARCHIVOS PARA DETERMINAR CUALES ESTAN VISTIADOS PARA SER ELIMINADOS
        for (Component componente : panel_repositorio.getComponents()) {
            FArchivo archivoEli = (FArchivo) componente;
            if (archivoEli.isSeleccionado()) {
                lstIDEliminar.add(archivoEli.getArchivo().getId());
            }
        }

        //PREGUNTAS SI ESTA SEGURO DE ELIMINAR
        int numArcEli = lstIDEliminar.size();
        if (numArcEli > 0) {
            if ((JOptionPane.showConfirmDialog(this, "Esta seguro de eliminar los " + numArcEli + " archivo(s)", "ELIMINAR ARCHIVO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) == 0) {
                for (Integer id : lstIDEliminar) {
                    oper.eliminarArchivo(id);
                }
            }
        }
    }

    private void buscarrArchivos() {
        JFileChooser VENTANA_ARCHIVO;
        File[] ARCHIVOS;

        VENTANA_ARCHIVO = new JFileChooser();
        VENTANA_ARCHIVO.setDialogTitle("BUSCAR ARCHIVOS");
        FileNameExtensionFilter filtroDoc = new FileNameExtensionFilter("Documento", "doc", "docx", "xls", "xlsx", "dwg", "txt", "pdf");
        FileNameExtensionFilter filtroImg = new FileNameExtensionFilter("Imagen", "png", "jpg", "jpeg", "bmp");

        VENTANA_ARCHIVO.setFileFilter(filtroDoc);
        VENTANA_ARCHIVO.addChoosableFileFilter(filtroImg);
        VENTANA_ARCHIVO.setMultiSelectionEnabled(true);
        VENTANA_ARCHIVO.showOpenDialog(null);
        // muestra error si es inválido
        ARCHIVOS = VENTANA_ARCHIVO.getSelectedFiles();

        if ((ARCHIVOS[0] == null) || (ARCHIVOS[0].getName().isEmpty())) {
            //JOptionPane.showMessageDialog(, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
        } // fin de if
        else {
            DefaultListModel modelo = new DefaultListModel();
            lstTitulos.setModel(modelo);

            lstArchivosSubir = new ArrayList<>();

            String usuario = usuLog.getUsuario();

            for (File file : ARCHIVOS) {
                String nombre = file.getName().substring(0, file.getName().indexOf("."));
                String ext = file.getName().substring(file.getName().indexOf(".") + 1, file.getName().length());
                long TamañoB = file.length();
                String rutaOrigen = file.getAbsolutePath();

                modelo.addElement(file.getName());

                Archivo arcSubir = new Archivo();
                arcSubir.setTitulo(nombre);
                arcSubir.setTamañoBytes(TamañoB);
                arcSubir.setExtension(ext);
                arcSubir.setRuta(rutaOrigen);
                arcSubir.setUsuario(usuario);

                //AGREGA EL OBJETO ARCHIVO A LA LISTA DE ARCHIVOS PARA INSERTAR EN LA BASE
                lstArchivosSubir.add(arcSubir);
            }
        }
    }

    private void insertarArchivos() {
        ArchivoDAO docDAO = new ArchivoDAO();
        for (Archivo archivoInsert : lstArchivosSubir) {
            if (docDAO.insertarArchivo(archivoInsert) != 1) {
                JOptionPane.showMessageDialog(this, "Error al ingresar archivo", "GUARDAR ARCHIVO", JOptionPane.ERROR_MESSAGE);
            }
        }
        lstTitulos.removeAll();
    }

    private void limpiarLista(){
        ((DefaultListModel)lstTitulos.getModel()).removeAllElements();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        panel_titulo = new javax.swing.JPanel();
        lbtTitulo = new javax.swing.JLabel();
        panel_datos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTitulos = new javax.swing.JList<>();
        barProceso = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        txtCriterio = new rojeru_san.RSMTextFull();
        lbEncontrados = new javax.swing.JLabel();
        btnAgregar = new rojeru_san.RSButton();
        btnEliminar = new rojeru_san.RSButton();
        btnConsultar = new rojeru_san.RSButton();
        btnBuscarArchivos = new rojeru_san.RSButton();
        scroolRepositorio = new javax.swing.JScrollPane();
        panel_repositorio = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("REPOSITORIO");

        panel_principal.setBackground(new java.awt.Color(0, 102, 255));
        panel_principal.setLayout(new java.awt.BorderLayout());

        panel_titulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        panel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        panel_titulo.setOpaque(false);
        panel_titulo.setPreferredSize(new java.awt.Dimension(930, 50));

        lbtTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbtTitulo.setForeground(panel_titulo.getForeground());
        lbtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/repositorio16.png"))); // NOI18N
        lbtTitulo.setText("REPOSITORIO DE ARCHIVOS");

        javax.swing.GroupLayout panel_tituloLayout = new javax.swing.GroupLayout(panel_titulo);
        panel_titulo.setLayout(panel_tituloLayout);
        panel_tituloLayout.setHorizontalGroup(
            panel_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        panel_tituloLayout.setVerticalGroup(
            panel_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_principal.add(panel_titulo, java.awt.BorderLayout.PAGE_START);

        panel_datos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        panel_datos.setForeground(new java.awt.Color(255, 255, 255));
        panel_datos.setOpaque(false);
        panel_datos.setPreferredSize(new java.awt.Dimension(300, 464));

        lstTitulos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ARCHIVOS CARGADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11))); // NOI18N
        jScrollPane1.setViewportView(lstTitulos);

        barProceso.setToolTipText("");
        barProceso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barProceso.setStringPainted(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("FILTROS DE BÚSQUEDA"));

        txtCriterio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCriterio.setPlaceholder("Escriba un criterio de búsqueda");
        txtCriterio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCriterioKeyPressed(evt);
            }
        });

        lbEncontrados.setBackground(new java.awt.Color(255, 255, 255));
        lbEncontrados.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbEncontrados.setForeground(new java.awt.Color(51, 0, 255));
        lbEncontrados.setText("Archivos encontrados: 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbEncontrados, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEncontrados, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setForeground(new java.awt.Color(0, 112, 192));
        btnAgregar.setText("Agregar");
        btnAgregar.setColorHover(new java.awt.Color(0, 112, 192));
        btnAgregar.setColorText(new java.awt.Color(0, 112, 192));
        btnAgregar.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setForeground(new java.awt.Color(0, 112, 192));
        btnEliminar.setText("Eliminar");
        btnEliminar.setColorHover(new java.awt.Color(0, 112, 192));
        btnEliminar.setColorText(new java.awt.Color(0, 112, 192));
        btnEliminar.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnConsultar.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar.setForeground(new java.awt.Color(0, 112, 192));
        btnConsultar.setText("Consultar");
        btnConsultar.setColorHover(new java.awt.Color(0, 112, 192));
        btnConsultar.setColorText(new java.awt.Color(0, 112, 192));
        btnConsultar.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnBuscarArchivos.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarArchivos.setForeground(new java.awt.Color(0, 112, 192));
        btnBuscarArchivos.setText("Buscar archivos");
        btnBuscarArchivos.setColorHover(new java.awt.Color(0, 112, 192));
        btnBuscarArchivos.setColorText(new java.awt.Color(0, 112, 192));
        btnBuscarArchivos.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        btnBuscarArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArchivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_datosLayout = new javax.swing.GroupLayout(panel_datos);
        panel_datos.setLayout(panel_datosLayout);
        panel_datosLayout.setHorizontalGroup(
            panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBuscarArchivos, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_datosLayout.createSequentialGroup()
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addComponent(barProceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(18, 18, 18))
        );
        panel_datosLayout.setVerticalGroup(
            panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscarArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_principal.add(panel_datos, java.awt.BorderLayout.WEST);

        scroolRepositorio.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroolRepositorio.setViewportBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 255), 2, true));
        scroolRepositorio.setAutoscrolls(true);

        panel_repositorio.setBackground(new java.awt.Color(255, 255, 255));
        panel_repositorio.setAutoscrolls(true);
        panel_repositorio.setLayout(new java.awt.GridLayout(0, 4, 5, 5));
        scroolRepositorio.setViewportView(panel_repositorio);

        panel_principal.add(scroolRepositorio, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        insertarArchivos();
        consultarArchivos();
        limpiarLista();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarArchivos();
        consultarArchivos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        consultarArchivos();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtCriterioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //obtenemos el texto (criterio) ingresado en la interfaz y almacenamos en una variable
            String criterio = txtCriterio.getText().toLowerCase();
            //llamanos a al método buscar por criterio y le enviamos el criterio ingresado
            consultarCriterio(criterio);
        }
    }//GEN-LAST:event_txtCriterioKeyPressed

    private void btnBuscarArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArchivosActionPerformed
        buscarrArchivos();
    }//GEN-LAST:event_btnBuscarArchivosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barProceso;
    private rojeru_san.RSButton btnAgregar;
    private rojeru_san.RSButton btnBuscarArchivos;
    private rojeru_san.RSButton btnConsultar;
    private rojeru_san.RSButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEncontrados;
    private javax.swing.JLabel lbtTitulo;
    private javax.swing.JList<String> lstTitulos;
    private javax.swing.JPanel panel_datos;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JPanel panel_repositorio;
    private javax.swing.JPanel panel_titulo;
    private javax.swing.JScrollPane scroolRepositorio;
    private rojeru_san.RSMTextFull txtCriterio;
    // End of variables declaration//GEN-END:variables
}
