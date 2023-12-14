/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Infraestructure.DbManagment.Contactos;
/**
 *
 * @author Monse
 */

import org.example.Infraestructure.Conections.Conexiones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PersonasEncapsulamiento {
        private Conexiones conexion;
    public PersonasEncapsulamiento(String userDB, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userDB, passDB, hostDB, portDB, dataBase);
    }
    public void registrarPersona(Personas persona1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO personas(" +
                    "id_ciudad,"+ "nombre,"+ "apellido,"+
                    "tipo_documento,"+ "nro_documento,"+ "direccion,"+
                    "celular,"+ "email,"+ "estado)"+
                    "values('" +
                    persona1.getId_ciudad()+"', '"+
                    persona1.getNombre()+"', '"+
                    persona1.getApellido()+"', '"+
                    persona1.getTipo_documento()+"', '"+
                    persona1.getNro_documento()+"', '"+
                    persona1.getDireccion()+"', '"+
                    persona1.getCelular()+"', '"+
                    persona1.getEmail()+"', '"+
                    persona1.getEstado()+"')");
            conexion.conexionDB().close();
            JOptionPane.showInputDialog("Registrado correctamente!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String modificarPersona(Personas persona1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE personas SET " +
                    "nombre='"+persona1.getNombre()+"',"+
                    "apellido='"+persona1.getApellido()+"',"+
                    "tipo_documento='"+persona1.getTipo_documento()+"',"+
                    "nro_documento='"+persona1.getNro_documento()+"',"+
                    "direccion='"+persona1.getDireccion()+"',"+
                    "celular='"+persona1.getCelular()+"',"+
                    "email='"+persona1.getEmail()+"',"+
                    "estado='"+persona1.getEstado()+"'WHERE personas.id_persona="+persona1.getId_persona());
            conexion.conexionDB().close();
            return "La informacion personal de la persona ha sido modificada correctamente"+persona1.getNombre();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Personas> consultarPersonas() {
    List<Personas> personas = new ArrayList<>();
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM personas"));
        while (conexion.getResultadoQuery().next()) {
            Personas persona1 = new Personas();
            persona1.setId_persona(conexion.getResultadoQuery().getInt("id_persona"));
            persona1.setId_ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
            persona1.setNombre(conexion.getResultadoQuery().getString("nombre"));
            persona1.setApellido(conexion.getResultadoQuery().getString("apellido"));
            persona1.setTipo_documento(conexion.getResultadoQuery().getString("tipo_documento"));
            persona1.setNro_documento(conexion.getResultadoQuery().getString("nro_documento"));
            persona1.setDireccion(conexion.getResultadoQuery().getString("direccion"));
            persona1.setCelular(conexion.getResultadoQuery().getString("celular"));
            persona1.setEmail(conexion.getResultadoQuery().getString("email"));
            persona1.setEstado(conexion.getResultadoQuery().getString("estado"));
            personas.add(persona1);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return personas;
}
    public Personas consultarPersonaPorId(int id){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM personas WHERE id_persona="+id));
            if (conexion.getResultadoQuery().next()) {
                Personas persona1 =new Personas();
                persona1.setId_persona(conexion.getResultadoQuery().getInt("id_persona"));
                persona1.setId_ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
                persona1.setNombre(conexion.getResultadoQuery().getString("nombre"));
                persona1.setApellido(conexion.getResultadoQuery().getString("apellido"));
                persona1.setTipo_documento(conexion.getResultadoQuery().getString("tipo_documento"));
                persona1.setNro_documento(conexion.getResultadoQuery().getString("nro_documento"));
                persona1.setDireccion(conexion.getResultadoQuery().getString("direccion"));
                persona1.setCelular(conexion.getResultadoQuery().getString("celular"));
                persona1.setEmail(conexion.getResultadoQuery().getString("email"));
                persona1.setEstado(conexion.getResultadoQuery().getString("estado"));
                return persona1;
            } 
            else {
                return null; 
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public Personas consultarPersonaPorDocumento(String documento) {
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM personas WHERE nro_documento = '" + documento + "'"));
            if (conexion.getResultadoQuery().next()) {
                Personas persona1 = new Personas();
                persona1.setId_persona(conexion.getResultadoQuery().getInt("id_persona"));
                persona1.setId_ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
                persona1.setNombre(conexion.getResultadoQuery().getString("nombre"));
                persona1.setApellido(conexion.getResultadoQuery().getString("apellido"));
                persona1.setTipo_documento(conexion.getResultadoQuery().getString("tipo_documento"));
                persona1.setNro_documento(conexion.getResultadoQuery().getString("nro_documento"));
                persona1.setDireccion(conexion.getResultadoQuery().getString("direccion"));
                persona1.setCelular(conexion.getResultadoQuery().getString("celular"));
                persona1.setEmail(conexion.getResultadoQuery().getString("email"));
                persona1.setEstado(conexion.getResultadoQuery().getString("estado"));
                return persona1;
            } else {
                return null; 
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void eliminarPersona(int persona1) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM personas WHERE id_persona="+persona1);
        conexion.conexionDB().close();
        if (rowCount > 0) {
            JOptionPane.showMessageDialog(null, "La persona ha sido eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la operacion, vuelva a intentar");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
    

