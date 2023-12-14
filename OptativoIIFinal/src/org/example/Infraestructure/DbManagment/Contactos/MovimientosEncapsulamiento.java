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

public class MovimientosEncapsulamiento {
    private Conexiones conexion;
    public MovimientosEncapsulamiento(String userDB, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userDB, passDB, hostDB, portDB, dataBase);
    }
    public String registrarMovimiento(Movimientos movimiento1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO movimientos(" +
                    "id_cuenta,"+ "fecha_movimiento,"+ "tipo_movimiento,"+
                    "saldo_anterior,"+ "saldo_actual,"+ "monto_movimiento,"+
                    "cuenta_origen,"+ "canal)"+
                    "values('" +
                    movimiento1.getId_cuenta()+"','"+
                    movimiento1.getFecha_movimiento()+"','"+
                    movimiento1.getTipo_movimiento()+"','"+
                    movimiento1.getSaldo_anterior()+"','"+
                    movimiento1.getSaldo_actual()+"','"+
                    movimiento1.getMonto_movimiento()+"','"+
                    movimiento1.getCuenta_origen()+"','"+
                    movimiento1.getCanal() + "')");
            conexion.conexionDB().close();
            return "El movimiento ha sido registrado correctamente!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String modificarMovimiento(Movimientos movimiento1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE movimientos SET " +
                    "id_cuenta='"+movimiento1.getId_cuenta()+"',"+
                    "fecha_movimiento='"+movimiento1.getFecha_movimiento()+"',"+
                    "tipo_movimiento='"+movimiento1.getTipo_movimiento()+"',"+
                    "saldo_anterior='"+movimiento1.getSaldo_anterior()+"',"+
                    "saldo_actual='"+movimiento1.getSaldo_actual()+"',"+
                    "monto_movimiento='"+movimiento1.getMonto_movimiento()+"',"+
                    "cuenta_origen='"+movimiento1.getCuenta_origen()+"',"+
                    "canal='"+movimiento1.getCanal()+"',"+
                    "'WHERE movimientos.id_movimiento="+movimiento1.getId_movimiento());
            conexion.conexionDB().close();
            return "Los datos del movimiento han sido modificados correctamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Movimientos> consultarMovimiento() {
    List<Movimientos> movimientos = new ArrayList<>();
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM movimientos"));
        while (conexion.getResultadoQuery().next()) {
            Movimientos movimiento1 = new Movimientos();
            movimiento1.setId_movimiento(conexion.getResultadoQuery().getInt("id_movimiento"));
            movimiento1.setId_cuenta(conexion.getResultadoQuery().getInt("id_cuenta"));
            movimiento1.setFechaMovimiento(conexion.getResultadoQuery().getString("fecha_movimiento"));
            movimiento1.setTipoMovimiento(conexion.getResultadoQuery().getString("tipo_movimiento"));
            movimiento1.setSaldo_anterior(conexion.getResultadoQuery().getString("saldo_anterior"));
            movimiento1.setSaldo_actual(conexion.getResultadoQuery().getString("saldo_actual"));
            movimiento1.setMonto_movimiento(conexion.getResultadoQuery().getString("monto_movimiento"));
            movimiento1.setCuenta_origen(conexion.getResultadoQuery().getString("cuenta_origen"));
            movimiento1.setCanal(conexion.getResultadoQuery().getString("canal"));
            movimientos.add(movimiento1);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return movimientos;
}
    public String eliminarMovimiento(int movimiento1) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM movimientos WHERE id_movimiento="+movimiento1);
        conexion.conexionDB().close();
        if (rowCount > 0) {
            return "El movimiento con el id "+movimiento1+"ha sido eliminado correctamente";
        } else {
            return "No se encontró ningun movimiento con el id ingresado"+movimiento1;
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
    

