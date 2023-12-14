/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Services.Contactos;
/**
 *
 * @author Monse
 */
import java.util.List;
import javax.swing.JOptionPane;
import org.example.Infraestructure.DbManagment.Contactos.Ciudades;
import org.example.Infraestructure.DbManagment.Contactos.CiudadesEncapsulamiento;

public class CiudadesServicios {
    CiudadesEncapsulamiento ciudadDB;
    public CiudadesServicios (String userBD, String passDB,String  hostDB, String portDB,String  dataBase){
        ciudadDB = new CiudadesEncapsulamiento(userBD, passDB, hostDB, portDB, dataBase);
    }
    public void registrarCiudad(Ciudades ciudad1){
        if(validarDatos(ciudad1)){
           ciudadDB.registrarCiudad(ciudad1);
        }else{
            JOptionPane.showMessageDialog(null, "El registro no pudo completarse", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void modificarCiudad(Ciudades ciudad1){
           ciudadDB.modificarCiudad(ciudad1);
    }
    public List<Ciudades> consultarCiudad(){
        return  ciudadDB.consultarCiudades();
    }
    public String eliminarCiudad(int ciudad1){
        return ciudadDB.eliminarCiudad(ciudad1);
    }
    public Ciudades consultarCiudadPorId(int idCiudad) {
    Ciudades ciudad1 = ciudadDB.consultarCiudadPorId(idCiudad);
    if (ciudad1 == null) {
        JOptionPane.showInputDialog("Registrado correctamente!");
    }
    return ciudad1;
}
    private boolean validarDatos(Ciudades ciudad1) {
        try {
        if(ciudad1.getNombre_ciudad().trim().isEmpty())
            throw new Exception("El nombre de la ciudad no debe estar vacío");
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
} 

