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

public class CuentasEncapsulamiento {
    private Conexiones conexion;
    public CuentasEncapsulamiento(String userDB, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userDB, passDB, hostDB, portDB, dataBase);
    }
    public void registrarCuenta(Cuentas cuenta1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cuentas(" +
                    "id_cliente,"+ "nro_cuenta,"+ "fecha_alta"+ "tipo_cuenta,"+
                    "estado,"+ "saldo,"+ "nro_contrato,"+ "costo_mantenimiento,"+
                    "prom_acreditacion,"+ "moneda)"+
                    "values('"+
                    cuenta1.getId_cliente()+"','"+
                    cuenta1.getNum_cuenta()+"','"+
                    cuenta1.getFecha_alta()+"','"+
                    cuenta1.getTipo_cuenta()+"','"+
                    cuenta1.getEstado()+"','"+
                    cuenta1.getSaldo()+"','"+
                    cuenta1.getNum_contrato()+"','"+
                    cuenta1.getCosto_mantenimiento()+"','"+
                    cuenta1.getProm_acreditacion()+"','"+
                    cuenta1.getMoneda()+"')");
            conexion.conexionDB().close();
            JOptionPane.showInputDialog("Registrado correctamente!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void modificarCuenta(Cuentas cuenta1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cuentas SET"+
                    "id_cliente='"+cuenta1.getId_cliente()+"',"+
                    "nro_cuenta='"+cuenta1.getNum_cuenta()+"',"+
                    "fecha_alta='"+cuenta1.getFecha_alta()+"',"+
                    "tipo_cuenta='"+cuenta1.getTipo_cuenta()+"',"+
                    "estado='"+cuenta1.getEstado()+"',"+
                    "saldo='"+cuenta1.getSaldo()+"',"+
                    "nro_contrato='"+cuenta1.getNum_contrato()+"',"+
                    "costo_mantenimiento='"+ cuenta1.getCosto_mantenimiento()+"',"+ 
                    "prom_acreditacion='"+cuenta1.getProm_acreditacion() + "'," +
                    "moneda='"+cuenta1.getMoneda()+"'"+
                    "WHERE id_cuenta="+cuenta1.getId_cuenta());
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "La cuenta ha sido actualizada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Cuentas consultarCuentaPorId(int idCuenta) {
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cuentas WHERE id_cuenta="+idCuenta));
        if (conexion.getResultadoQuery().next()) {
            Cuentas cuenta = new Cuentas();
            cuenta.setId_cuenta(conexion.getResultadoQuery().getInt("id_cuenta"));
            cuenta.setId_cliente(conexion.getResultadoQuery().getInt("id_cliente"));
            cuenta.setNum_cuenta(conexion.getResultadoQuery().getString("nro_cuenta")); 
            cuenta.setFecha_alta(conexion.getResultadoQuery().getString("fecha_alta"));
            cuenta.setTipo_cuenta(conexion.getResultadoQuery().getString("tipo_cuenta"));
            cuenta.setEstado(conexion.getResultadoQuery().getString("estado"));
            cuenta.setSaldo(conexion.getResultadoQuery().getString("saldo"));
            cuenta.setNum_contrato(conexion.getResultadoQuery().getString("nro_contrato"));
            cuenta.setCosto_mantenimiento(conexion.getResultadoQuery().getString("costo_mantenimiento"));
            cuenta.setProm_acreditacion(conexion.getResultadoQuery().getString("prom_acreditacion"));
            cuenta.setMoneda(conexion.getResultadoQuery().getString("moneda"));
            return cuenta;
        } else {
            return null; 
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public List<Cuentas> consultarCuentas() {
    List<Cuentas> cuentas = new ArrayList<>();
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cuentas"));
        while (conexion.getResultadoQuery().next()) {
            Cuentas cuenta1 = new Cuentas();
            cuenta1.setId_cuenta(conexion.getResultadoQuery().getInt("id_cuenta"));
            cuenta1.setId_cliente(conexion.getResultadoQuery().getInt("id_cliente"));
            cuenta1.setNum_cuenta(conexion.getResultadoQuery().getString("nro_cuenta")); 
            cuenta1.setFecha_alta(conexion.getResultadoQuery().getString("fecha_alta"));
            cuenta1.setTipo_cuenta(conexion.getResultadoQuery().getString("tipo_cuenta"));
            cuenta1.setEstado(conexion.getResultadoQuery().getString("estado"));
            cuenta1.setSaldo(conexion.getResultadoQuery().getString("saldo"));
            cuenta1.setNum_contrato(conexion.getResultadoQuery().getString("nro_contrato"));
            cuenta1.setCosto_mantenimiento(conexion.getResultadoQuery().getString("costo_mantenimiento"));
            cuenta1.setProm_acreditacion(conexion.getResultadoQuery().getString("prom_acreditacion"));
            cuenta1.setMoneda(conexion.getResultadoQuery().getString("moneda")); 
            cuentas.add(cuenta1);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return cuentas;
}
   public void eliminarCuenta(int cuenta1) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cuentas WHERE id_cuenta="+cuenta1);
        conexion.conexionDB().close();
        if (rowCount > 0) {
            JOptionPane.showMessageDialog(null, "La cuenta ha sido eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "La cuenta no se ha podido eliminar, vuelva a intentar");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
   

