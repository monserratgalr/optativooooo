/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Infraestructure.Models;
import org.example.Infraestructure.DbManagment.Contactos.Personas;
/**
 *
 * @author Monse
 */
public class UsuarioModels {
    private int id_usuario;
    private Personas persona;
    private String usuario;
    private String contraseña;
    private String estado;
        public UsuarioModels(int id_usuario, Personas persona, String usuario, String contraseña, String estado) {
        this.id_usuario = id_usuario;
        this.persona = persona;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = estado;
    }
    public UsuarioModels() {   
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Personas getPersona() {
        return persona;
    }
    public void setPersona(Personas persona) {
        this.persona = persona;
    }
}
