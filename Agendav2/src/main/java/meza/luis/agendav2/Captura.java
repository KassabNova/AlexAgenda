/*

 */
package meza.luis.agendav2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
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
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ALUMNOS
 */
public class Captura extends javax.swing.JInternalFrame {

    FileInputStream fis;
    int longitud;
    Image imgFoto;
    String nomabus;

    public Captura() {
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

        JFCFoto = new javax.swing.JFileChooser();
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

        jLN.setText("Nombre");

        jLA.setText("Apellido");

        jLD.setText("Domicilio");

        jLE.setText("E-mail");

        jLT.setText("Telefono");

        jLF.setText("FechadeNacimiento");

        JRBMasculino.setText("Masculino");
        JRBMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBMasculinoActionPerformed(evt);
            }
        });

        jLED.setText("Edad");

        JRBFemenino.setText("Femenino");

        jLS.setText("Sexo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLA)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(JTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLF)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JDCfechadenacimiento,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLS)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(JRBMasculino)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JRBFemenino))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLT)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JTFTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                        jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLED)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JTFEdad))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                        jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(JTFEmail))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                        jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLD)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JTFDomicilio,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 69,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(JLID, javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                        jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLN)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(JTFNombre,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 94,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JLID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLN, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLA)
                                        .addComponent(JTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLD)
                                        .addComponent(JTFDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLE)
                                        .addComponent(JTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLF)
                                        .addComponent(JDCfechadenacimiento, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLED)
                                        .addComponent(JTFEdad, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLS)
                                        .addComponent(JRBMasculino)
                                        .addComponent(JRBFemenino))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLT)
                                        .addComponent(JTFTelefono, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(39, Short.MAX_VALUE))
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
                                                .addComponent(JLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(jBFoto)))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(JLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 92,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBFoto)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBModificar.setText("Modificar");

        jBEliminar.setText("Eliminar");

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
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JRBMasculinoActionPerformed(
            java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRBMasculinoActionPerformed

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
                fis = new FileInputStream(JFCFoto.getSelectedFile());
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
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(rootPane, "Imagen:" + ioe);
                }
            } catch (FileNotFoundException fnfe) {
                JOptionPane.showMessageDialog(rootPane, "Imagen:" + fnfe);
            }
        }
    }//GEN-LAST:event_jBFotoActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        String nombre = JTFNombre.getText();
        String apellido = JTFApellido.getText();
        String domicilio = JTFDomicilio.getText();
        String email = JTFEmail.getText();
        Date fecha = JDCfechadenacimiento.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        String fechadenacimiento = sdf.format(fecha);
        int edad = Integer.parseInt(JTFEdad.getText());
        String sexo;
        if (JRBMasculino.isSelected())
            sexo = "Masculino";
        else
            sexo = "Femenino";
        String telefono = JTFTelefono.getText();

        Metodos enlace = new Metodos();
        enlace.Agregar(nombre, apellido, domicilio, email, fechadenacimiento, edad, sexo, telefono, fis, longitud);
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        Metodos enlace = new Metodos();
        nomabus = JOptionPane.showInputDialog(rootPane, "Nombre a buscar?",
                "BUSCANDO", JOptionPane.QUESTION_MESSAGE);
        if (nomabus != null) {
            String[] resultados = enlace.Buscar(nomabus);
            if (resultados[0] == null) {
                JOptionPane.showMessageDialog(rootPane, "No se encontró a:" + nomabus);
            } else {
                JLID.setText(resultados[0]);
                JTFNombre.setText(resultados[1]);
                JTFApellido.setText(resultados[2]);
                JTFDomicilio.setText(resultados[3]);
                JTFTelefono.setText(resultados[4]);
                JTFEmail.setText(resultados[5]);

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
                    Date fechaNac = sdf.parse(resultados[6]);
                    JDCfechadenacimiento.setDate(fechaNac);
                } catch (ParseException pex) {
                    Logger.getLogger(Captura.class.getName())
                            .log(Level.SEVERE, null, pex);
                }
                JTFEdad.setText(resultados[7]);
                if (resultados[8].equals("Masculino"))
                    JRBMasculino.setSelected(true);
                else
                    JRBFemenino.setSelected(true);

                mostrarFoto(Integer.parseInt(JLID.getText()));
            }
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

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

    private Image convertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new
                ByteArrayInputStream(bytes);
        Iterator lector = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader ir = (ImageReader) lector.next();
        Object objeto = bais;
        ImageInputStream iis = ImageIO.createImageInputStream(objeto);
        ir.setInput(iis, true);
        ImageReadParam irp = ir.getDefaultReadParam();
        return ir.read(0, irp);
    }

    private void JBLimpiarActionPerformed() {
        JTFApellido.setText("");
        JTFDomicilio.setText("");
        JTFEmail.setText("");
        JTFNombre.setText("");
        JTFTelefono.setText("");
    }

    private ResultSet Registro;

    private void Limpiar_txt() {
        JTFApellido.setText("");
        JTFDomicilio.setText("");
        JTFEmail.setText("");
        JTFNombre.setText("");
        JTFTelefono.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBLimpiar;
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