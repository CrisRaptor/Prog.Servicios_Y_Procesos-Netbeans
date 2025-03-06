package firmadigital;

import firmadigital.FileService;
import firmadigital.KeyManager;
import java.awt.Color;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.NoSuchFileException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author CrisGC
 */
public class Ventana extends javax.swing.JFrame {

    byte[] sign; //Firma digital
    String  chosen_file = "", //Archivo seleccionado
            chosen_key = "", //Clave seleccionada
            key_dir = System.getProperty("user.dir") + "\\claves\\"; //Directorio donde se almacenan las claves
    //Colores personalizados
    Color VERDE_OSCURO = new Color(0,153,51),
            ROJO = new Color(204,0,51),
            AMARILLO = new Color(204,102,0);
    JFileChooser fileChooser = new JFileChooser();
    
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        btnGenerate = new javax.swing.JButton();
        btnValidate = new javax.swing.JButton();
        selectedFileLabel = new javax.swing.JLabel();
        labelArchivoSeleccionado = new javax.swing.JLabel();
        labelElegirArchivo = new javax.swing.JLabel();
        btnSelectFile = new javax.swing.JButton();
        labelOpciones = new javax.swing.JLabel();
        feedbackLabel2 = new javax.swing.JLabel();
        feedbackLabel1 = new javax.swing.JLabel();
        labelElegirClave = new javax.swing.JLabel();
        btnGenerateKey = new javax.swing.JButton();
        labelClaveSeleccionada = new javax.swing.JLabel();
        selectedKeyLabel = new javax.swing.JLabel();
        btnSelectKey = new javax.swing.JButton();
        newKeyLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setText("Firma digital");

        tabbedPane.setBackground(new java.awt.Color(51, 0, 102));
        tabbedPane.setName("Generar firma"); // NOI18N

        btnGenerate.setBackground(new java.awt.Color(102, 102, 255));
        btnGenerate.setText("Generar firma");
        btnGenerate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerateMouseClicked(evt);
            }
        });
        tabbedPane.addTab("Generar firma", btnGenerate);

        btnValidate.setBackground(new java.awt.Color(0, 102, 51));
        btnValidate.setText("Validar Firma");
        btnValidate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValidateMouseClicked(evt);
            }
        });
        tabbedPane.addTab("Validar firma", btnValidate);

        selectedFileLabel.setForeground(new java.awt.Color(153, 153, 255));
        selectedFileLabel.setText("-");

        labelArchivoSeleccionado.setForeground(new java.awt.Color(153, 153, 153));
        labelArchivoSeleccionado.setText("Archivo seleccionado:");

        labelElegirArchivo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelElegirArchivo.setText("Elegir archivo");

        btnSelectFile.setBackground(new java.awt.Color(0, 153, 51));
        btnSelectFile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSelectFile.setText("Archivo");
        btnSelectFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelectFileMouseClicked(evt);
            }
        });

        labelOpciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelOpciones.setForeground(new java.awt.Color(153, 153, 153));
        labelOpciones.setText("Opciones");

        labelElegirClave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelElegirClave.setText("Elegir clave");

        btnGenerateKey.setBackground(new java.awt.Color(204, 102, 0));
        btnGenerateKey.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerateKey.setText("Generar nueva clave");
        btnGenerateKey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerateKeyMouseClicked(evt);
            }
        });

        labelClaveSeleccionada.setForeground(new java.awt.Color(153, 153, 153));
        labelClaveSeleccionada.setText("Clave seleccionada:");
        labelClaveSeleccionada.setToolTipText("");

        selectedKeyLabel.setForeground(new java.awt.Color(153, 153, 255));
        selectedKeyLabel.setText("-");

        btnSelectKey.setBackground(new java.awt.Color(153, 153, 0));
        btnSelectKey.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSelectKey.setText("Clave");
        btnSelectKey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelectKeyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPane)
                    .addComponent(feedbackLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(feedbackLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGenerateKey)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newKeyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelOpciones)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelClaveSeleccionada)
                                    .addComponent(selectedKeyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelElegirClave)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSelectKey)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelElegirArchivo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSelectFile))
                                    .addComponent(labelArchivoSeleccionado)
                                    .addComponent(selectedFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerateKey)
                    .addComponent(newKeyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelClaveSeleccionada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedKeyLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSelectKey)
                            .addComponent(labelElegirClave))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelElegirArchivo)
                            .addComponent(btnSelectFile))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelArchivoSeleccionado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedFileLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelOpciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feedbackLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(feedbackLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Boton para seleccionar un fichero*/
    private void btnSelectFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectFileMouseClicked
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int val = fileChooser.showOpenDialog(null);

        if (val == JFileChooser.OPEN_DIALOG) {
            chosen_file = fileChooser.getSelectedFile().getAbsolutePath();
            String fileName = fileChooser.getSelectedFile().getName();
            selectedFileLabel.setText(fileName);
        }

        resetFeedback(feedbackLabel1);
        resetFeedback(feedbackLabel2);
    }//GEN-LAST:event_btnSelectFileMouseClicked

    /*Boton para generar una firma*/
    private void btnGenerateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateMouseClicked
        try {
            Signature signature = Signature.getInstance("DSA");
            signature.initSign(KeyManager.getClavePrivada(chosen_key));
            signature.update(FileService.readFile(chosen_file));
            sign = signature.sign();

            changeFeedback(feedbackLabel1, "Firma generada con �xito.", VERDE_OSCURO);
            resetFeedback(feedbackLabel2);
        } catch (Exception ex) {
            exceptionResolver(ex);
        }
    }//GEN-LAST:event_btnGenerateMouseClicked

    /*Boton para validar una firma*/
    private void btnValidateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValidateMouseClicked
        try {
            Signature signature = Signature.getInstance("DSA");
            signature.initVerify(KeyManager.getClavePublica(chosen_key));
            signature.update(FileService.readFile(chosen_file));

            if (signature.verify(sign)) {
                changeFeedback(feedbackLabel1, "Mensaje verificado.", VERDE_OSCURO);
                resetFeedback(feedbackLabel2);
            } else {
                changeFeedback(feedbackLabel1, "Atencion: el fichero no es fiable.", AMARILLO);
                changeFeedback(feedbackLabel2, "Esta modificado o encriptado por otra clave.", AMARILLO);
            }
        } catch (Exception ex) {
            exceptionResolver(ex);
        }
    }//GEN-LAST:event_btnValidateMouseClicked

    /*Boton para generar nuevas claves*/
    private void btnGenerateKeyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateKeyMouseClicked
        try {
            KeyPair keys = KeyManager.generarClaves();
            int id = KeyManager.guardarClaves(keys, key_dir);
            changeFeedback(newKeyLabel, "Nuevas claves con id " + id, AMARILLO);
        } catch (Exception ex) {
            exceptionResolver(ex);
        }
    }//GEN-LAST:event_btnGenerateKeyMouseClicked

    /*Boton para seleccionar una clave*/
    private void btnSelectKeyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectKeyMouseClicked
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File(key_dir));
        int val = fileChooser.showOpenDialog(null);

        if (val == JFileChooser.OPEN_DIALOG) {
            chosen_key = fileChooser.getSelectedFile().getAbsolutePath();
            String fileName = fileChooser.getSelectedFile().getName();
            selectedKeyLabel.setText(fileName);
        }

        resetFeedback(feedbackLabel1);
        resetFeedback(feedbackLabel2);
    }//GEN-LAST:event_btnSelectKeyMouseClicked

    /*Boton para seleccionar una clave*/
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    /*Metodos personalizados*/
    
    /*Gestion de labels de feedback*/
    private void changeFeedback(JLabel label, String text, Color color) {
        label.setText(text);
        label.setForeground(color);
    }

    private void resetFeedback(JLabel label) {
        label.setText("");
        label.setForeground(Color.black);
    }

    /*Control de errores*/
    private void exceptionResolver(Exception ex) {
        switch (ex) {
            /*Errores IO*/
            case UnsupportedEncodingException e -> {
                changeFeedback(feedbackLabel1, "Error, encriptaci�n no v�lida.", ROJO);
                resetFeedback(feedbackLabel2);
            }
            case NoSuchFileException e -> {
                changeFeedback(feedbackLabel1, "Error, clave no encontrada.", ROJO);
                resetFeedback(feedbackLabel2);
            }
            case FileNotFoundException e -> {
                changeFeedback(feedbackLabel1, "Error, elige un archivo v�lido.", ROJO);
                resetFeedback(feedbackLabel2);
            }
            case IOException e -> {
                changeFeedback(feedbackLabel1, "Error, archivo no encontrado.", ROJO);
                resetFeedback(feedbackLabel2);
            }
            
            /*Errores firma*/
            case NoSuchAlgorithmException e -> {
                changeFeedback(feedbackLabel1, "Error, algoritmo no v�lido.", ROJO);
                resetFeedback(feedbackLabel2);
            }
            case InvalidKeySpecException e -> {
                changeFeedback(feedbackLabel1, "Error, clave inv�lida.", ROJO);
                changeFeedback(feedbackLabel2, "Elige la clave publica.", ROJO);
            }
            case InvalidKeyException e -> {
                changeFeedback(feedbackLabel1, "Error, clave inv�lida.", ROJO);
                resetFeedback(feedbackLabel2);
            }
            case SignatureException e -> {
                changeFeedback(feedbackLabel1, "Error al firmar.", ROJO);
                resetFeedback(feedbackLabel2);
            }
            
            default -> {
                changeFeedback(feedbackLabel1, "Error desconocido: " + ex.getMessage(), ROJO);
                resetFeedback(feedbackLabel2);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnGenerateKey;
    private javax.swing.JButton btnSelectFile;
    private javax.swing.JButton btnSelectKey;
    private javax.swing.JButton btnValidate;
    private javax.swing.JLabel feedbackLabel1;
    private javax.swing.JLabel feedbackLabel2;
    private javax.swing.JLabel labelArchivoSeleccionado;
    private javax.swing.JLabel labelClaveSeleccionada;
    private javax.swing.JLabel labelElegirArchivo;
    private javax.swing.JLabel labelElegirClave;
    private javax.swing.JLabel labelOpciones;
    private javax.swing.JLabel newKeyLabel;
    private javax.swing.JLabel selectedFileLabel;
    private javax.swing.JLabel selectedKeyLabel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
