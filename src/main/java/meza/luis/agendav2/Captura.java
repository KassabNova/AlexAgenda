/*

 */

package meza.luis.agendav2;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import static meza.luis.agendav2.Metodos.mostrarFoto;
import static meza.luis.agendav2.Metodos.showConfirmDialog;
import static meza.luis.agendav2.Metodos.showMessageDialog;
import static meza.luis.agendav2.Metodos.verificarEmail;

/**
 * @author ALUMNOS
 */
public class Captura extends javax.swing.JInternalFrame {

    FileInputStream fileInputStream;
    int longitud;
    Metodos enlace = new Metodos();
    Connection conexion = enlace.obtenerConexion();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");

    public Captura() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        JFCFoto = new javax.swing.JFileChooser();
        gruposexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        JLID = new javax.swing.JLabel();
        JTFNombre = new javax.swing.JTextField();
        jLN = new javax.swing.JLabel();
        JTFApellido = new javax.swing.JTextField();
        jLA = new javax.swing.JLabel();
        JTFDomicilio = new javax.swing.JTextField();
        jLD = new javax.swing.JLabel();
        JTFEmail = new javax.swing.JTextField();
        jLE = new javax.swing.JLabel();
        JTFEdad = new javax.swing.JTextField();
        jLT = new javax.swing.JLabel();
        JTFTelefono = new javax.swing.JTextField();
        jLF = new javax.swing.JLabel();
        JRBMasculino = new javax.swing.JRadioButton();
        jLED = new javax.swing.JLabel();
        JRBFemenino = new javax.swing.JRadioButton();
        jLS = new javax.swing.JLabel();
        JDCfechadenacimiento = new com.toedter.calendar.JDateChooser();
        avisonombre = new javax.swing.JLabel();
        avisoapellido = new javax.swing.JLabel();
        avisodomicilio = new javax.swing.JLabel();
        avisoemail = new javax.swing.JLabel();
        avisofecha = new javax.swing.JLabel();
        avisoedad = new javax.swing.JLabel();
        avisosexo = new javax.swing.JLabel();
        avisotelefono = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JLFoto = new javax.swing.JLabel();
        jBFoto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jBBuscar = new javax.swing.JButton();
        jBAgregar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        JBLimpiar = new javax.swing.JButton();

        JLID.setText("ID");

        JTFNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFNombreKeyTyped(evt);
            }
        });

        jLN.setText("Nombre");

        JTFApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFApellidoKeyTyped(evt);
            }
        });

        jLA.setText("Apellido");

        JTFDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFDomicilioKeyTyped(evt);
            }
        });

        jLD.setText("Domicilio");

        jLE.setText("E-mail");

        JTFEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFEdadKeyTyped(evt);
            }
        });

        jLT.setText("Telefono");

        JTFTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFTelefonoKeyTyped(evt);
            }
        });

        jLF.setText("FechadeNacimiento");

        gruposexo.add(JRBMasculino);
        JRBMasculino.setText("Masculino");
        JRBMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorSexo(evt);
            }
        });

        jLED.setText("Edad");

        gruposexo.add(JRBFemenino);
        JRBFemenino.setText("Femenino");
        JRBFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorSexo(evt);
            }
        });
        jLS.setText("Sexo");

        avisonombre.setForeground(new java.awt.Color(255, 0, 51));
        avisonombre.setText(" ");

        avisoapellido.setForeground(new java.awt.Color(255, 0, 51));

        avisodomicilio.setForeground(new java.awt.Color(255, 0, 51));

        avisoemail.setForeground(new java.awt.Color(255, 0, 51));

        avisofecha.setForeground(new java.awt.Color(255, 0, 51));

        avisoedad.setForeground(new java.awt.Color(255, 0, 51));

        avisosexo.setForeground(new java.awt.Color(255, 0, 51));

        avisotelefono.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLD)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTFDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLS)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JRBMasculino))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLT)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTFTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JRBFemenino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(avisosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(avisoapellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avisodomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avisotelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLED)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avisoedad, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avisoemail, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avisonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JLID, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JDCfechadenacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avisofecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLN)
                    .addComponent(avisonombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLA)
                    .addComponent(JTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avisoapellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLD)
                    .addComponent(JTFDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avisodomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLE)
                    .addComponent(JTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avisoemail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLF)
                    .addComponent(JDCfechadenacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(avisofecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLED)
                    .addComponent(JTFEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avisoedad, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLS)
                    .addComponent(JRBMasculino)
                    .addComponent(JRBFemenino)
                    .addComponent(avisosexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLT)
                    .addComponent(JTFTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avisotelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        JLFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jBFoto.setText("Foto");
        jBFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(JLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jBFoto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(JLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBFoto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jBBuscarActionPerformed(evt);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        JBLimpiar.setText("Limpiar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBAgregar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBModificar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JBLimpiar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jBBuscar)
                .addGap(18, 18, 18)
                .addComponent(jBAgregar)
                .addGap(18, 18, 18)
                .addComponent(jBModificar)
                .addGap(18, 18, 18)
                .addComponent(jBEliminar)
                .addGap(18, 18, 18)
                .addComponent(JBLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }

    private void selectorSexo(java.awt.event.ActionEvent evt) {
        var button = (JRadioButton)evt.getSource();
        button.setSelected(true);
        if(button.getText() == "Masculino"){
            JRBFemenino.setSelected(false);
        } else {
            JRBMasculino.setSelected(false);
        }
    }

    private void jBFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFotoActionPerformed
        JFCFoto = new JFileChooser();
        JFCFoto.setFileSelectionMode
                (JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro =
                new FileNameExtensionFilter("JPG", "jpg");
        JFCFoto.setFileFilter(filtro);
        int estado = JFCFoto.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fileInputStream = new FileInputStream(JFCFoto.getSelectedFile());
                longitud =
                        (int) JFCFoto.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read
                                    (JFCFoto.getSelectedFile())
                            .getScaledInstance(JLFoto.getWidth(),
                                    JLFoto.getHeight(),
                                    Image.SCALE_DEFAULT);
                    JLFoto.setIcon(new ImageIcon(icono));
                    JLFoto.updateUI();
                } catch (IOException ex) {
                    showMessageDialog(rootPane, "Imagen:" + ex, "ERROR");
                }
            } catch (FileNotFoundException ex) {
                showMessageDialog(rootPane, "Imagen no encontrada:" + ex, "ERROR");
            }
        }
    }

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed

        int confirmacion = showConfirmDialog(rootPane, "Seguro que quiere agregar?", "AGREGANDO");
        if (confirmacion == 0) { // Esto significa que sí

            Usuario usuario = Usuario.builder()
                    .nombre(JTFNombre.getText())
                    .apellido(JTFApellido.getText())
                    .domicilio(JTFDomicilio.getText())
                    .email(JTFEmail.getText())
                    .birthdate(JDCfechadenacimiento.getDate())
                    .edad(Integer.parseInt(JTFEdad.getText()))
                    .telefono(JTFTelefono.getText())
                    .build();
            usuario.sexo = (JRBMasculino.isSelected()) ? "Masculino" : "Femenino";

            enlace.Agregar(usuario, fileInputStream, longitud);
            showMessageDialog(rootPane, "Se agregó", "Agregando");
        } else { //Aqui entra si no cancela accion
            showMessageDialog(rootPane, "Acción cancelada", "Cancelando");
        }
    }

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        String idFila = JOptionPane.showInputDialog(rootPane, "ID de fila a borrar?",
                "BORRANDO", JOptionPane.QUESTION_MESSAGE);
        if (idFila.isBlank()) { //Si idFila no trae nada
            showMessageDialog(rootPane, "No se encontró el ID:" + idFila, "Usuario no encontrado");
        } else {
            if (enlace.Eliminar(idFila)) { //Si tuvo exito al borrar
                showMessageDialog(rootPane, "Se borró exitosamente el usuario:" + idFila, "Exito");
            } else { //Si NO tuvo exito
                showMessageDialog(rootPane, "Hubo un error al borrar el usuario:" + idFila, "Exito");
            }
        }
    }

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {
        String nombre = JOptionPane.showInputDialog(rootPane, "Nombre a buscar?",
                "BUSCANDO", JOptionPane.QUESTION_MESSAGE);
        Usuario usuario;

        if (nombre != null) {
            String[] resultados = enlace.Buscar(nombre);
            if (resultados[0] == null) {
                showMessageDialog(rootPane, "No se encontró a: " + nombre, "ERROR");
            } else {
                usuario = Usuario.builder()
                        .ID(Integer.valueOf(resultados[0]))
                        .nombre(resultados[1])
                        .apellido(resultados[2])
                        .domicilio(resultados[3])
                        .email(resultados[4])
                        .birthdate(dateFormat.parse(resultados[5]))
                        .edad(Integer.valueOf(resultados[6]))
                        .telefono(resultados[8])
                        .build();
                usuario.sexo = (resultados[7].equals("Masculino")) ? "Masculino" : "Femenino";

                actualizarFormulario(usuario);
            }
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void JTFEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFEdadKeyTyped
        // TODO add your handling code here:
         char validar=evt.getKeyChar();

if(Character.isLetter(validar)){
    getToolkit().beep();
    evt.consume();                                    
    JOptionPane.showMessageDialog(rootPane,"Ingresar Solo Numero:");
    }                                
    }//GEN-LAST:event_JTFEdadKeyTyped

    private void JTFNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFNombreKeyTyped
        // TODO add your handling code here:
        char validar=evt.getKeyChar();
        
if(Character.isDigit(validar)){
    getToolkit().beep();
    evt.consume();
    JOptionPane.showMessageDialog(rootPane,"Ingresar Solo Letras:");
    }//GEN-LAST:event_JTFNombreKeyTyped
  }
    private void JTFApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFApellidoKeyTyped
        // TODO add your handling code here:
                char validar=evt.getKeyChar();
        
if(Character.isDigit(validar)){
    getToolkit().beep();
    evt.consume();
    JOptionPane.showMessageDialog(rootPane,"Ingresar Solo Letras:");
    } 
    }//GEN-LAST:event_JTFApellidoKeyTyped

    private void JTFDomicilioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFDomicilioKeyTyped
        // TODO add your handling code here:
                char validar=evt.getKeyChar();
        
if(Character.isDigit(validar)){
    getToolkit().beep();
    evt.consume();
    JOptionPane.showMessageDialog(rootPane,"Ingresar Solo Letras:");
    } 
    }//GEN-LAST:event_JTFDomicilioKeyTyped

    private void JTFTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFTelefonoKeyTyped
        // TODO add your handling code here:
                 char validar=evt.getKeyChar();

if(Character.isLetter(validar)){
    getToolkit().beep();
    evt.consume();                                    
    JOptionPane.showMessageDialog(rootPane,"Ingresar Solo Numero:");
    } 
    }//GEN-LAST:event_JTFTelefonoKeyTyped

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
                Metodos enlace = new Metodos();
        String idFila= JOptionPane.showInputDialog(rootPane, "ID de fila a borrar?",
                "BORRANDO", JOptionPane.QUESTION_MESSAGE);
        if (idFila != null) {
            boolean resultado = enlace.Eliminar(idFila);
            if(resultado){
                JOptionPane.showMessageDialog(rootPane, "Se borró exitosamente el usuario:" + idFila);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Hubo un error al borrar el usuario:" + idFila);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se encontró el ID:" + idFila);
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBModificarActionPerformed
    
    
    private void mostrarFoto(int id) {
        Metodos enlace = new Metodos();
        byte[] resultado = enlace.obtenerFoto(id);
        if (resultado == null)
            JOptionPane.showMessageDialog(rootPane, "La persona no tiene foto.");
        else {
            try {
                imgFoto = convertirImagen(resultado);
                Icon foto = new ImageIcon(
                        imgFoto.getScaledInstance(JLFoto.getWidth(), JLFoto.getHeight(), Image.SCALE_DEFAULT));
                JLFoto.setIcon(foto);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }

    private void jBLimpiarActionPerformed() {
        limpiarFormulario();
    }

    private void limpiarFormulario() {
        JTFApellido.setText("");
        JTFDomicilio.setText("");
        JTFEmail.setText("");
        JTFNombre.setText("");
        JTFTelefono.setText("");
        JTFEdad.setText("");
        JDCfechadenacimiento.setDate(null);
        JRBMasculino.setSelected(false);
        JRBFemenino.setSelected(false);
        JLFoto.setIcon(null);
    }

    private void actualizarFormulario(Usuario usuario) {
        JLID.setText(String.valueOf(usuario.ID));
        JTFNombre.setText(usuario.nombre);
        JTFApellido.setText(usuario.apellido);
        JTFDomicilio.setText(usuario.domicilio);
        JTFEmail.setText(usuario.email);
        JDCfechadenacimiento.setDate(usuario.birthdate);
        JTFEdad.setText(String.valueOf(usuario.calcularEdad()));
        JTFTelefono.setText(usuario.telefono);
        mostrarFoto(rootPane, JLFoto, conexion, usuario.ID);
    }

    private boolean verificarFormulario(Usuario usuario){
        int errores = 0;
        boolean esFormularioValido = true;
        errores += (verificarEmail(usuario.email)) ? 1 : 0 ;


        esFormularioValido = (errores > 0) ? false : true;

        return esFormularioValido;
    }
    private com.toedter.calendar.JDateChooser JDCfechadenacimiento;
    private javax.swing.JFileChooser JFCFoto;
    private javax.swing.JLabel JLFoto;
    private javax.swing.JLabel JLID;
    private javax.swing.JRadioButton JRBFemenino;
    private javax.swing.JRadioButton JRBMasculino;
    private javax.swing.JTextField JTFApellido;
    private javax.swing.JTextField JTFDomicilio;
    private javax.swing.JTextField JTFEdad;
    private javax.swing.JTextField JTFEmail;
    private javax.swing.JTextField JTFNombre;
    private javax.swing.JTextField JTFTelefono;
    private javax.swing.JLabel avisoapellido;
    private javax.swing.JLabel avisodomicilio;
    private javax.swing.JLabel avisoedad;
    private javax.swing.JLabel avisoemail;
    private javax.swing.JLabel avisofecha;
    private javax.swing.JLabel avisonombre;
    private javax.swing.JLabel avisosexo;
    private javax.swing.JLabel avisotelefono;
    private javax.swing.ButtonGroup gruposexo;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBFoto;
    private javax.swing.JButton jBModificar;
    private javax.swing.JLabel jLA;
    private javax.swing.JLabel jLD;
    private javax.swing.JLabel jLE;
    private javax.swing.JLabel jLED;
    private javax.swing.JLabel jLF;
    private javax.swing.JLabel jLN;
    private javax.swing.JLabel jLS;
    private javax.swing.JLabel jLT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}