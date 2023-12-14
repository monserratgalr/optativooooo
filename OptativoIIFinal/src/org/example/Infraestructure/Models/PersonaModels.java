/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Infraestructure.Models;

/**
 *
 * @author Monse
 */
public class PersonaModels {
    public int id_persona;
    public String nombre;
    public String apellido;
    public String tipo_docu;
    public String nro_docu;
    public String direccion;
    public String celular;
    public String email;
    public String fecha_nacimiento;
    public String estado;

    public PersonaModels(int id_persona, String nombre, String apellido, String tipo_docu, String nro_docu, String direccion, String celular, String email, String fecha_nacimiento, String estado) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_docu = tipo_docu;
        this.nro_docu = nro_docu;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado = estado;
    }
    public PersonaModels() {
    }
    public int getId_persona() {
        return id_persona;
    }
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTipo_docu() {
        return tipo_docu;
    }
    public void setTipo_docu(String tipo_docu) {
        this.tipo_docu = tipo_docu;
    }
    public String getNro_docu() {
        return nro_docu;
    }
    public void setNro_docu(String nro_docu) {
        this.nro_docu = nro_docu;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    } 
}
