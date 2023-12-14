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

public class ClientesEncapsulamiento {
        private Conexiones conexion;
    public ClientesEncapsulamiento(String userDB, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userDB, passDB, hostDB, portDB, dataBase);
    }
    public void registrarCliente(Clientes cliente1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cliente(" +
                    "id_persona,"+ "fecha_ingreso,"+ "calificacion,"+"estado)"+
                    "values('" +
                    cliente1.getId_persona()+"','"+cliente1.getFecha_ingreso()+"','"+
                    cliente1.getCalificacion()+"','"+cliente1.getEstado()+"')");
            conexion.conexionDB().close();
            JOptionPane.showInputDialog("Registrado correctamente!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void modificarCliente(Clientes cliente1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cliente SET " +
                    "id_persona='"+cliente1.getId_persona()+"',"+
                    "fecha_ingreso='"+cliente1.getFecha_ingreso()+"',"+
                    "calificacion='"+cliente1.getCalificacion()+"',"+
                    "estado='"+cliente1.getEstado()+"'WHERE id_cliente="+cliente1.getId_cliente());
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "El cliente ha sido actualizado corrextamente!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Clientes> consultarClientes() {
    List<Clientes> clientes = new ArrayList<>();
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cliente"));
        while (conexion.getResultadoQuery().next()) {
            Clientes cliente1 = new Clientes();
            cliente1.setId_cliente(conexion.getResultadoQuery().getInt("id_cliente"));
            cliente1.setId_persona(conexion.getResultadoQuery().getInt("id_persona")); 
            cliente1.setFecha_ingreso(conexion.getResultadoQuery().getString("fecha_ingreso")); 
            cliente1.setCalificacion(conexion.getResultadoQuery().getString("calificacion"));
            cliente1.setEstado(conexion.getResultadoQuery().getString("estado"));
            clientes.add(cliente1);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return clientes;
}
    public Clientes consultarClientePorId(int idCliente) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cliente WHERE id_cliente="+idCliente));
        if (conexion.getResultadoQuery().next()) {
            Clientes cliente1 = new Clientes();
            cliente1.setId_cliente(conexion.getResultadoQuery().getInt("id_cliente"));
            cliente1.setId_persona(conexion.getResultadoQuery().getInt("id_persona"));
            cliente1.setFecha_ingreso(conexion.getResultadoQuery().getString("fecha_ingreso"));
            cliente1.setCalificacion(conexion.getResultadoQuery().getString("calificacion"));
            cliente1.setEstado(conexion.getResultadoQuery().getString("estado"));
            return cliente1;
        } else {
            return null;
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public void eliminarCliente(int cliente1) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cliente WHERE id_cliente="+cliente1);
        conexion.conexionDB().close();
        if (rowCount > 0) {
            JOptionPane.showMessageDialog(null, "El cliente ha sido eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "El cliente no ha sido eliminado, vuelva a intentar");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
    

