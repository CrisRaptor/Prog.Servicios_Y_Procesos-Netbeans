package confidencialidadidentidad;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.NoSuchFileException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author CrisGC
 */
public class Ventana extends javax.swing.JFrame {
    byte[] sign; //Firma digital
    final int KEY_SIZE = 16; //Tama�o de clave
    String  chosen_file = "", //Archivo seleccionado
            chosen_key_sign = "", //Clave seleccionada para firmar
            chosen_key_validate = "", //Clave seleccionada para validar
            key_dir = System.getProperty("user.dir") + "\\claves\\"; //Directorio donde se almacenan las claves
    //Colores personalizados
    static Color VERDE_OSCURO = new Color(0,153,51),
            ROJO = new Color(204,0,51),
            AMARILLO = new Color(204,102,0),
            AZUL = new Color(102,102,255);
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

        tabPane = new javax.swing.JTabbedPane();
        panelEncode = new javax.swing.JPanel();
        labelKeyEncode = new javax.swing.JLabel();
        cipherKeyEncode = new javax.swing.JTextField();
        btnEncode = new javax.swing.JButton();
        panelSign = new javax.swing.JPanel();
        selectedKeySignLabel = new javax.swing.JLabel();
        labelClaveSeleccionada = new javax.swing.JLabel();
        labelElegirClave = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        btnSelectKeySign = new javax.swing.JButton();
        panelValidate = new javax.swing.JPanel();
        labelElegirClave1 = new javax.swing.JLabel();
        btnSelectKeyValidate = new javax.swing.JButton();
        labelClaveSeleccionada1 = new javax.swing.JLabel();
        selectedKeyValidateLabel = new javax.swing.JLabel();
        btnValidate = new javax.swing.JButton();
        panelDecode = new javax.swing.JPanel();
        btnDecode = new javax.swing.JButton();
        cipherKeyDecode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        labelChooseFile = new javax.swing.JLabel();
        btnSelectFile = new javax.swing.JButton();
        labelArchivo = new javax.swing.JLabel();
        selectedFileLabel = new javax.swing.JLabel();
        newKeyLabel = new javax.swing.JLabel();
        btnGenerateKey = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaFeedback = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Confidencialidad e Identidad");
        setName("frame"); // NOI18N

        tabPane.setBackground(new java.awt.Color(102, 0, 102));

        labelKeyEncode.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelKeyEncode.setText("Clave");

        btnEncode.setBackground(new java.awt.Color(102, 102, 255));
        btnEncode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEncode.setText("Cifrar archivo");
        btnEncode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                encodeBtn(evt);
            }
        });

        javax.swing.GroupLayout panelEncodeLayout = new javax.swing.GroupLayout(panelEncode);
        panelEncode.setLayout(panelEncodeLayout);
        panelEncodeLayout.setHorizontalGroup(
            panelEncodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncodeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEncodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cipherKeyEncode, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(labelKeyEncode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEncode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        panelEncodeLayout.setVerticalGroup(
            panelEncodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncodeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelKeyEncode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cipherKeyEncode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEncode, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tabPane.addTab("Encriptar", panelEncode);

        selectedKeySignLabel.setForeground(new java.awt.Color(153, 153, 255));
        selectedKeySignLabel.setText("-");

        labelClaveSeleccionada.setForeground(new java.awt.Color(153, 153, 153));
        labelClaveSeleccionada.setText("Clave seleccionada:");
        labelClaveSeleccionada.setToolTipText("");

        labelElegirClave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelElegirClave.setText("Elegir clave");

        btnGenerate.setBackground(new java.awt.Color(102, 102, 255));
        btnGenerate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerate.setText("Generar firma");
        btnGenerate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signBtn(evt);
            }
        });

        btnSelectKeySign.setBackground(new java.awt.Color(153, 153, 0));
        btnSelectKeySign.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSelectKeySign.setText("Clave");
        btnSelectKeySign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keySignSelectBtn(evt);
            }
        });

        javax.swing.GroupLayout panelSignLayout = new javax.swing.GroupLayout(panelSign);
        panelSign.setLayout(panelSignLayout);
        panelSignLayout.setHorizontalGroup(
            panelSignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSignLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelClaveSeleccionada)
                    .addGroup(panelSignLayout.createSequentialGroup()
                        .addComponent(labelElegirClave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelectKeySign, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(selectedKeySignLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        panelSignLayout.setVerticalGroup(
            panelSignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSignLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSignLayout.createSequentialGroup()
                        .addComponent(labelClaveSeleccionada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedKeySignLabel))
                    .addGroup(panelSignLayout.createSequentialGroup()
                        .addGroup(panelSignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelElegirClave)
                            .addComponent(btnSelectKeySign))
                        .addGap(44, 44, 44)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tabPane.addTab("Firmar", panelSign);

        labelElegirClave1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelElegirClave1.setText("Elegir clave");

        btnSelectKeyValidate.setBackground(new java.awt.Color(153, 153, 0));
        btnSelectKeyValidate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSelectKeyValidate.setText("Clave");
        btnSelectKeyValidate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyValidateSelectBtn(evt);
            }
        });

        labelClaveSeleccionada1.setForeground(new java.awt.Color(153, 153, 153));
        labelClaveSeleccionada1.setText("Clave seleccionada:");
        labelClaveSeleccionada1.setToolTipText("");

        selectedKeyValidateLabel.setForeground(new java.awt.Color(153, 153, 255));
        selectedKeyValidateLabel.setText("-");

        btnValidate.setBackground(new java.awt.Color(0, 102, 51));
        btnValidate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnValidate.setText("Validar Firma");
        btnValidate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                validateBtn(evt);
            }
        });

        javax.swing.GroupLayout panelValidateLayout = new javax.swing.GroupLayout(panelValidate);
        panelValidate.setLayout(panelValidateLayout);
        panelValidateLayout.setHorizontalGroup(
            panelValidateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValidateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelClaveSeleccionada1)
                    .addGroup(panelValidateLayout.createSequentialGroup()
                        .addComponent(labelElegirClave1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelectKeyValidate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectedKeyValidateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        panelValidateLayout.setVerticalGroup(
            panelValidateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValidateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValidateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelValidateLayout.createSequentialGroup()
                        .addComponent(labelClaveSeleccionada1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedKeyValidateLabel))
                    .addGroup(panelValidateLayout.createSequentialGroup()
                        .addGroup(panelValidateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSelectKeyValidate)
                            .addComponent(labelElegirClave1))
                        .addGap(44, 44, 44)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tabPane.addTab("Validar", panelValidate);

        btnDecode.setBackground(new java.awt.Color(255, 102, 102));
        btnDecode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDecode.setText("Descifrar archivo");
        btnDecode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decodeBtn(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Clave");

        javax.swing.GroupLayout panelDecodeLayout = new javax.swing.GroupLayout(panelDecode);
        panelDecode.setLayout(panelDecodeLayout);
        panelDecodeLayout.setHorizontalGroup(
            panelDecodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDecodeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDecodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cipherKeyDecode, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDecode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        panelDecodeLayout.setVerticalGroup(
            panelDecodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDecodeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cipherKeyDecode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDecode)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tabPane.addTab("Desencriptar", panelDecode);

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setText("Confidencialidad e Identidad");
        title.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        labelChooseFile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelChooseFile.setText("Elegir archivo");

        btnSelectFile.setBackground(new java.awt.Color(0, 153, 51));
        btnSelectFile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSelectFile.setText("Archivo");
        btnSelectFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectFileBtn(evt);
            }
        });

        labelArchivo.setForeground(new java.awt.Color(153, 153, 153));
        labelArchivo.setText("Archivo seleccionado:");

        selectedFileLabel.setForeground(new java.awt.Color(153, 153, 255));
        selectedFileLabel.setText("-");

        btnGenerateKey.setBackground(new java.awt.Color(204, 102, 0));
        btnGenerateKey.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerateKey.setText("Generar nueva clave");
        btnGenerateKey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newKeyBtn(evt);
            }
        });

        textAreaFeedback.setColumns(20);
        textAreaFeedback.setRows(5);
        jScrollPane1.setViewportView(textAreaFeedback);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelChooseFile)
                                .addGap(18, 18, 18)
                                .addComponent(btnSelectFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(labelArchivo)
                            .addComponent(selectedFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGenerateKey)
                            .addComponent(newKeyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelChooseFile)
                    .addComponent(btnSelectFile)
                    .addComponent(btnGenerateKey))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedFileLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(newKeyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectFileBtn(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectFileBtn
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int val = fileChooser.showOpenDialog(null);

        if (val == JFileChooser.OPEN_DIALOG) {
            chosen_file = fileChooser.getSelectedFile().getAbsolutePath();
            String fileName = fileChooser.getSelectedFile().getName();
            selectedFileLabel.setText(fileName);
        }

        resetFeedback(textAreaFeedback);
    }//GEN-LAST:event_selectFileBtn

    private void newKeyBtn(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newKeyBtn
        try {
            KeyPair keys = KeyManager.generarClaves();
            int id = KeyManager.guardarClaves(keys, key_dir);
            changeFeedback(textAreaFeedback, "Nuevas claves con id " + id, AMARILLO);
        } catch (Exception ex) {
            exceptionResolver(ex);
        }
    }//GEN-LAST:event_newKeyBtn

    private void encodeBtn(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encodeBtn
        if (!"".equals(chosen_file) && !"".equals(cipherKeyEncode.getText().trim())
            && cipherKeyEncode.getText().trim().length() >= KEY_SIZE) {
            try {
                Key clave = AESSimpleManager.obtenerClave(cipherKeyEncode.getText().trim(), KEY_SIZE);
                String text =  new String(FileService.readFile(chosen_file));
                String encodedText = AESSimpleManager.cifrar(text, clave);

                FileService.writeFile(selectedFileLabel.getText() + ".cifrado", encodedText);
                File file = new File(chosen_file.trim());
                file.delete();
                changeFeedback(textAreaFeedback, "Archivo cifrado con �xito.", VERDE_OSCURO);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            String more_details = "";
            
            if ("".equals(chosen_file)) {
                more_details = " Archivo no encontrado.";
            } else if ("".equals(cipherKeyEncode.getText().trim())) {
                more_details = " Clave vacia invalida.";
            } else if (cipherKeyEncode.getText().trim().length() < KEY_SIZE) {
                more_details = " Clave invalida. Requiere 16 caracteres.";
            }
            changeFeedback(textAreaFeedback, "Fallo al cifrar."+more_details, ROJO);
        }
    }//GEN-LAST:event_encodeBtn

    private void decodeBtn(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decodeBtn
        if (!"".equals(chosen_file) && !"".equals(cipherKeyDecode.getText().trim())
                && cipherKeyDecode.getText().trim().length() >= KEY_SIZE) {
            try {
                Key clave = AESSimpleManager.obtenerClave(cipherKeyDecode.getText().trim(), KEY_SIZE);
                String encodedText = new String(FileService.readFile(chosen_file));
                String decodedText = AESSimpleManager.descifrar(encodedText, clave);

                FileService.writeFile(selectedFileLabel.getText().substring(
                        0, selectedFileLabel.getText().lastIndexOf('.')), decodedText);
                File file = new File(chosen_file.trim());
                file.delete();
                changeFeedback(textAreaFeedback, "Archivo descifrado con �xito.", VERDE_OSCURO);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            String more_details = "";
            
            if ("".equals(chosen_file)) {
                more_details = " Archivo no encontrado.";
            } else if ("".equals(cipherKeyEncode.getText().trim())) {
                more_details = " Clave vacia invalida.";
            } else if (cipherKeyEncode.getText().trim().length() < KEY_SIZE) {
                more_details = " Clave invalida. Requiere 16 caracteres.";
            }
            changeFeedback(textAreaFeedback, "Fallo al cifrar."+more_details, ROJO);
        }
    }//GEN-LAST:event_decodeBtn

    private void keySignSelectBtn(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keySignSelectBtn
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File(key_dir));
        int val = fileChooser.showOpenDialog(null);

        if (val == JFileChooser.OPEN_DIALOG) {
            chosen_key_sign = fileChooser.getSelectedFile().getAbsolutePath();
            String fileName = fileChooser.getSelectedFile().getName();
            selectedKeySignLabel.setText(fileName);
        }

        resetFeedback(textAreaFeedback);
    }//GEN-LAST:event_keySignSelectBtn

    private void signBtn(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signBtn
        try {
            Signature signature = Signature.getInstance("DSA");
            signature.initSign(KeyManager.getClavePrivada(chosen_key_sign));
            signature.update(FileService.readFile(chosen_file));
            sign = signature.sign();

            changeFeedback(textAreaFeedback, "Firma generada con �xito.", VERDE_OSCURO);
            resetFeedback(textAreaFeedback);
        } catch (Exception ex) {
            exceptionResolver(ex);
        }
    }//GEN-LAST:event_signBtn

    private void keyValidateSelectBtn(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyValidateSelectBtn
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File(key_dir));
        int val = fileChooser.showOpenDialog(null);

        if (val == JFileChooser.OPEN_DIALOG) {
            chosen_key_validate = fileChooser.getSelectedFile().getAbsolutePath();
            String fileName = fileChooser.getSelectedFile().getName();
            selectedKeyValidateLabel.setText(fileName);
        }

        resetFeedback(textAreaFeedback);
    }//GEN-LAST:event_keyValidateSelectBtn

    private void validateBtn(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_validateBtn
        try {
            Signature signature = Signature.getInstance("DSA");
            signature.initVerify(KeyManager.getClavePublica(chosen_key_validate));
            signature.update(FileService.readFile(chosen_file));

            if (signature.verify(sign)) {
                changeFeedback(textAreaFeedback, "Mensaje verificado.", VERDE_OSCURO);
            } else {
                changeFeedback(textAreaFeedback, """
                                                 Atencion: el fichero no es fiable.
                                                 Esta modificado o encriptado por otra clave.""", AMARILLO);
            }
        } catch (Exception ex) {
            exceptionResolver(ex);
        }
    }//GEN-LAST:event_validateBtn

    /*Metodos personalizados*/
    
    /*Gestion de labels de feedback*/
    private void changeFeedback(JTextArea textArea, String text, Color color) {
        textArea.setText(text);
        textArea.setForeground(color);
    }

    private void resetFeedback(JTextArea textArea) {
        textArea.setText("");
        textArea.setForeground(Color.black);
    }

    /*Control de errores*/
    private void exceptionResolver(Exception ex) {
        switch (ex) {
            /*Errores IO*/
            case UnsupportedEncodingException e -> {
                changeFeedback(textAreaFeedback, "Error, encriptaci�n no v�lida.", ROJO);
            }
            case NoSuchFileException e -> {
                changeFeedback(textAreaFeedback, "Error, clave no encontrada.", ROJO);
            }
            case FileNotFoundException e -> {
                changeFeedback(textAreaFeedback, "Error, elige un archivo v�lido.", ROJO);
            }
            case IOException e -> {
                changeFeedback(textAreaFeedback, "Error, archivo no encontrado.", ROJO);
            }
            
            /*Errores firma*/
            case NoSuchAlgorithmException e -> {
                changeFeedback(textAreaFeedback, "Error, algoritmo no v�lido.", ROJO);
            }
            case InvalidKeySpecException e -> {
                changeFeedback(textAreaFeedback, "Error, clave inv�lida.\nElige la clave publica.", ROJO);
            }
            case InvalidKeyException e -> {
                changeFeedback(textAreaFeedback, "Error, clave inv�lida.", ROJO);
            }
            case SignatureException e -> {
                changeFeedback(textAreaFeedback, "Error al firmar.", ROJO);
            }
            
            default -> {
                changeFeedback(textAreaFeedback, "Error desconocido: " + ex.getMessage(), ROJO);
            }
        }
    }
    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDecode;
    private javax.swing.JButton btnEncode;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnGenerateKey;
    private javax.swing.JButton btnSelectFile;
    private javax.swing.JButton btnSelectKeySign;
    private javax.swing.JButton btnSelectKeyValidate;
    private javax.swing.JButton btnValidate;
    private javax.swing.JTextField cipherKeyDecode;
    private javax.swing.JTextField cipherKeyEncode;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelArchivo;
    private javax.swing.JLabel labelChooseFile;
    private javax.swing.JLabel labelClaveSeleccionada;
    private javax.swing.JLabel labelClaveSeleccionada1;
    private javax.swing.JLabel labelElegirClave;
    private javax.swing.JLabel labelElegirClave1;
    private javax.swing.JLabel labelKeyEncode;
    private javax.swing.JLabel newKeyLabel;
    private javax.swing.JPanel panelDecode;
    private javax.swing.JPanel panelEncode;
    private javax.swing.JPanel panelSign;
    private javax.swing.JPanel panelValidate;
    private javax.swing.JLabel selectedFileLabel;
    private javax.swing.JLabel selectedKeySignLabel;
    private javax.swing.JLabel selectedKeyValidateLabel;
    private static javax.swing.JTabbedPane tabPane;
    private javax.swing.JTextArea textAreaFeedback;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
