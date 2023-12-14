/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Services.Contactos;
import java.util.List;
import org.example.Infraestructure.DbManagment.Contactos.Cuentas;
import org.example.Infraestructure.DbManagment.Contactos.CuentasEncapsulamiento;
/**
 *
 * @author Monse
 */
public class CuentasServicios {
    CuentasEncapsulamiento cuentaDB;
    public CuentasServicios(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        cuentaDB = new CuentasEncapsulamiento(userBD, passDB, hostDB, portDB, dataBase);
    }
    public void registrarCuenta(Cuentas cuenta1){
            cuentaDB.registrarCuenta(cuenta1);  
    }
    public void modificarCuenta(Cuentas cuenta1){
           cuentaDB.modificarCuenta(cuenta1);
    }
    public List<Cuentas> consultarCuentas(){
        return  cuentaDB.consultarCuentas();
    }
    public Cuentas consultarCuentaPorId(int idCuenta) {
    return cuentaDB.consultarCuentaPorId(idCuenta);
}
    public void eliminarCuenta(int cuenta1){
        cuentaDB.eliminarCuenta(cuenta1);
    }
}
    

