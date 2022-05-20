/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package meza.luis.agendav2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author ALUMNOS
 */
public class Metodos {
    static Logger login =
            Logger.getLogger(Metodos.class.getName());

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

    public void Agregar(String nombre, String apellido, String domicilio,
                        String email, String fechadenacimiento, int edad, String sexo, String telefono,
                        FileInputStream fis, int longitud) {

        Connection conexion = obtenerConexion();

        try {
            String query = "insert into Personas(Nombre, Apellido, Domicilio, Email, FechadeNacimiento, Edad, Sexo, Telefono, Foto) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            instruccion.setString(1, nombre);
            instruccion.setString(2, apellido);
            instruccion.setString(3, domicilio);
            instruccion.setString(4, email);
            instruccion.setString(5, fechadenacimiento);
            instruccion.setInt(6, edad);
            instruccion.setString(7, sexo);
            instruccion.setString(8, telefono);
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
                    resultados[5] = rs.getString("FechadeNacimineto");
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

    public byte[] obtenerFoto(int id) {
        byte[] resultados = new byte[127];
        Connection conexion = obtenerConexion();
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

}

