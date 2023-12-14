/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Infraestructure.DbManagment.Contactos;

/**
 *
 * @author Monse
 */
    public class Ciudades {
        
    private int id_ciudad;
    private String nombre_ciudad;
    private String departamento;
    private String codigo_postal;

    public int getId_ciudad() {
        return id_ciudad;
    }
    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    public String getNombre_ciudad() {
        return nombre_ciudad;
    }
    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getCodigo_postal() {
        return codigo_postal;
    }
    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }   
}
