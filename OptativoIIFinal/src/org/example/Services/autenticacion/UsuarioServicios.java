/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Services.autenticacion;

import org.example.Infraestructure.DbManagment.autenticacion.Autenticaciones;
import org.example.Infraestructure.Models.UsuarioModels;

/**
 *
 * @author Monse
 */
public class UsuarioServicios {
    private Autenticaciones usuarioDB;
    public UsuarioServicios(String userDB, String passDB, String hostDB, String portDB, String dataBase){
        usuarioDB = new Autenticaciones(userDB, passDB, hostDB, portDB, dataBase);
    }
    public UsuarioModels Autenticar(String usuario){
       return usuarioDB.Autenticar(usuario);
    }

    public UsuarioModels autenticar(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
