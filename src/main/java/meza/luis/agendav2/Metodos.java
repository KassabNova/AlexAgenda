/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package meza.luis.agendav2;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 * @author ALUMNOS
 */
public class Metodos {
    static Logger login =
            Logger.getLogger(Metodos.class.getName());
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");

    public Connection obtenerConexion() {
        Connection conexion = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //net.ucanaccess.jdbc.UcanaccessDriver test;

            String miBaseDatos = "jdbc:ucanaccess:///"
                    + System.getProperty("user.dir")
                    + "//AgendaV2.accdb";
            conexion = DriverManager.getConnection(miBaseDatos, "YO", "CHOCOMILK");
        } catch (ClassNotFoundException fex) {
            login.log(Level.SEVERE, null, fex);
            JOptionPane.showMessageDialog(null, "ERROR. DRIVER. \n" + fex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName())
                    .log(Level.SEVERE, null, "ERROR. CONEXION. \n" + ex);
        }
        return conexion;
    }

    public void Agregar(Usuario usuario, FileInputStream fis, int longitud) {

        Connection conexion = obtenerConexion();

        try {
            String query = "insert into Personas(Nombre, Apellido, Domicilio, Email, FechadeNacimiento, Edad, Sexo, Telefono, Foto) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            instruccion.setString(1, usuario.nombre);
            instruccion.setString(2, usuario.apellido);
            instruccion.setString(3, usuario.domicilio);
            instruccion.setString(4, usuario.email);
            instruccion.setString(5, dateFormat.format(usuario.birthdate));
            instruccion.setInt(6, usuario.edad);
            instruccion.setString(7, usuario.sexo);
            instruccion.setString(8, usuario.telefono);
            instruccion.setBinaryStream(9, fis, longitud);
            instruccion.executeUpdate();
            instruccion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                login.log(Level.SEVERE, null, ex);
            }
        }
    }

    public String[] Buscar(String nombre) {
        String[] resultados = new String[9];
        Connection conexion = obtenerConexion();
        try {
            String query = "select * from Personas where Nombre = ?";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            instruccion.setString(1, nombre);
            try {
                ResultSet rs = instruccion.executeQuery();
                while (rs.next()) {
                    resultados[0] = rs.getString("id");
                    resultados[1] = rs.getString("Nombre");
                    resultados[2] = rs.getString("Apellido");
                    resultados[3] = rs.getString("Domicilio");
                    resultados[4] = rs.getString("Email");
                    resultados[5] = rs.getString("FechadeNacimiento");
                    resultados[6] = rs.getString("Edad");
                    resultados[7] = rs.getString("Sexo");
                    resultados[8] = rs.getString("Telefono");
                }
                rs.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Exception: " + ex);
            }
            instruccion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                login.log(Level.SEVERE, null, ex);
            }
        }
        return resultados;
    }

    public boolean Eliminar(String id){
        Connection conexion = obtenerConexion();
        boolean resultado = false;
        try {
            String query = "delete from Personas where Id = ?";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            instruccion.setString(1, id);
            try {
                resultado = (instruccion.executeUpdate() > 0) ? true : false;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Exception: " + ex);
            }
            instruccion.close();
        } catch (SQLException ex) {
            resultado = false;
            Logger.getLogger(Metodos.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                login.log(Level.SEVERE, null, ex);
            }
        }
        return resultado;

    }

    public static int showConfirmDialog(JRootPane rootPane, String message, String title){
        return JOptionPane.showConfirmDialog(rootPane, message,title, JOptionPane.YES_NO_OPTION);
    }
    public static void showMessageDialog(JRootPane rootPane, String message, String title){
        JOptionPane.showMessageDialog(rootPane, "Se agregó","Agregando", JOptionPane.OK_OPTION);
    }
    public static void mostrarFoto(JRootPane rootPane, JLabel JLFoto, Connection conexion, int id) {
        byte[] resultado = obtenerFoto(conexion, id);
        Image imgFoto;
        if (resultado == null)
            showMessageDialog(rootPane, "La persona no tiene foto.", "ERROR");
        else {
            try {
                imgFoto = convertirImagen(resultado);
                Icon foto = new ImageIcon(
                        imgFoto.getScaledInstance(JLFoto.getWidth(), JLFoto.getHeight(), Image.SCALE_DEFAULT));
                JLFoto.setIcon(foto);
            } catch (IOException ex) {
                showMessageDialog(rootPane, ex.getMessage(), "ERROR");
            }
        }
    }
    public static Image convertirImagen(byte[] bytes) throws IOException {
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
    public static byte[] obtenerFoto(Connection conexion, int id) {
        byte[] resultados = new byte[127];
        try {
            String query = "select Foto from Personas where Id = ?";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            instruccion.setInt(1, id);
            try {
                ResultSet rs = instruccion.executeQuery();
                while (rs.next()) {
                    resultados = rs.getBytes("Foto");
                }
                rs.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Exception: " + ex);
            }
            instruccion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                login.log(Level.SEVERE, null, ex);
            }
        }
        return resultados;
    }

    public static boolean verificarEmail(String email){
        String regex = "^(.+)@(.+)$";
        boolean isValidEmail = Pattern.compile(regex).matcher(email).matches();

        return isValidEmail;
    }
}

