/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Services.Contactos;

import java.util.List;
import javax.swing.JOptionPane;
import org.example.Infraestructure.DbManagment.Contactos.Personas;
import org.example.Infraestructure.DbManagment.Contactos.PersonasEncapsulamiento;

/**
 *
 * @author Monse
 */
public class PersonasServicios {
    PersonasEncapsulamiento personasDB;
    public PersonasServicios(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        personasDB = new PersonasEncapsulamiento(userBD, passDB, hostDB, portDB, dataBase);
    }
    public void registrarPersona(Personas persona1){
        if(validarDatos(persona1)){
           personasDB.registrarPersona(persona1);
        }
        else{
            JOptionPane.showInputDialog("La operacion no se ha podido realizar...");
        }
    }
    public String modificarPersona(Personas persona1){
        if(validarDatos(persona1)){
            personasDB.modificarPersona(persona1);
            JOptionPane.showInputDialog("La informacion de la persona ha sido actualizada correctamente!");
        }
        return "No se ha podido completar la operacion...";
    }
    public List<Personas> consultarPersona(){
        return  personasDB.consultarPersonas();
    }
    public Personas consultarPersonaPorId(int id) {
        return personasDB.consultarPersonaPorId(id);
    }
    public Personas consultarPersonaPorDocumento(String documento) {
        return personasDB.consultarPersonaPorDocumento(documento);
    }
    public void eliminarPersona(int persona){
         personasDB.eliminarPersona(persona);
    }
    private boolean validarDatos(Personas persona) {
        try {
        if(persona.getNombre().trim().isEmpty())
            throw new Exception("No puede dejar este campo vacio!");     
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
