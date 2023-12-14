/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Services.Contactos;

import java.util.List;
import org.example.Infraestructure.DbManagment.Contactos.Movimientos;
import org.example.Infraestructure.DbManagment.Contactos.MovimientosEncapsulamiento;

/**
 *
 * @author Monse
 */
public class MovimientosServicios {
    MovimientosEncapsulamiento movimientoDB;
    public MovimientosServicios(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        movimientoDB = new MovimientosEncapsulamiento(userBD, passDB, hostDB, portDB, dataBase);
    }
    public String registrarMovimiento(Movimientos movimiento1){
           return movimientoDB.registrarMovimiento(movimiento1);
    }
    public String modificarMovimiento(Movimientos movimiento1){
            return movimientoDB.modificarMovimiento(movimiento1);
    }
    public List<Movimientos> consultarMovimiento(){
        return  movimientoDB.consultarMovimiento();
    }
    public String eliminarMovimiento(int movimiento1){
        return movimientoDB.eliminarMovimiento(movimiento1);
    }
}
