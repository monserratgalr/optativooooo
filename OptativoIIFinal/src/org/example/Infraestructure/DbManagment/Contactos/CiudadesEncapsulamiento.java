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

public class CiudadesEncapsulamiento {
    private Conexiones conexion;
    public CiudadesEncapsulamiento(String userDB, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userDB, passDB, hostDB, portDB, dataBase);
    }
    public void registrarCiudad(Ciudades ciudad1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO ciudad(" +
                    "nombre_ciudad,"+
                    "departamento, " +
                    "codigo_postal) " +
                    "values('" +
                    ciudad1.getNombre_ciudad() + "', '" +
                    ciudad1.getDepartamento() + "', '" +
                    ciudad1.getCodigo_postal() + "')");
            conexion.conexionDB().close();
            JOptionPane.showInputDialog("Registrado correctamente!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void modificarCiudad(Ciudades ciudad1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE ciudad SET"+
             "nombre_ciudad='"+ciudad1.getNombre_ciudad()+"',"+"departamento='"+ciudad1.getDepartamento()+"',"+
             "codigo_postal='"+ciudad1.getCodigo_postal()+"'WHERE id_ciudad="+ciudad1.getId_ciudad());
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "La informacion del cliente ha sido actualizada correctamente!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Ciudades>consultarCiudades() {
    List<Ciudades> ciudades = new ArrayList<>();
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM ciudad1"));
        while (conexion.getResultadoQuery().next()) {
           Ciudades ciudad1 = new Ciudades();
           ciudad1.setId_ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
           ciudad1.setNombre_ciudad(conexion.getResultadoQuery().getString("nombre_ciudad"));
           ciudad1.setDepartamento(conexion.getResultadoQuery().getString("departamento"));
           ciudad1.setCodigo_postal(conexion.getResultadoQuery().getString("codigo_postal"));
           ciudades.add(ciudad1);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return ciudades;
}
    public Ciudades consultarCiudadPorId(int idCiudad) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM ciudad WHERE id_ciudad="+idCiudad));
        if (conexion.getResultadoQuery().next()) {
            Ciudades ciudad1 = new Ciudades();
            ciudad1.setId_ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
            ciudad1.setNombre_ciudad(conexion.getResultadoQuery().getString("nombre_ciudad"));
            ciudad1.setDepartamento(conexion.getResultadoQuery().getString("departamento"));
            ciudad1.setCodigo_postal(conexion.getResultadoQuery().getString("codigo_postal"));
            return ciudad1;
        } else {
            return null;  
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public String eliminarCiudad(int ciudad1) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM ciudad1 WHERE id_ciudad="+ciudad1);
        conexion.conexionDB().close();
        if (rowCount > 0) {
            return "La ciudad con el id"+ ciudad1+ "ha sido eliminada correctamente!";
        } else {
            return "No existe ninguna ciudad con el id ingresado "+ciudad1+"...";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
    

