/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Infraestructure.DbManagment.autenticacion;

import java.sql.SQLException;
import org.example.Infraestructure.Conections.Conexiones;
import org.example.Infraestructure.DbManagment.Contactos.Personas;
import org.example.Infraestructure.Models.UsuarioModels;
/**
 *
 * @author Monse
 */
public class Autenticaciones {
        private  Conexiones conexion;
        private Personas personas;
    public Autenticaciones(String userDB, String passDB, String hostDB, String portDB, String dataBase){
        this.conexion= new Conexiones(userDB, passDB, hostDB, portDB, dataBase);
    }
    public UsuarioModels Autenticar (String usuario){
        try{
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * from usuario="+usuario));
                    if(conexion.getResultadoQuery().next()){
                        return new UsuarioModels(  
                        conexion.getResultadoQuery().getInt("id_usuario"),
                        personas.consultarPersonas(conexion.getResultadoQuery().getInt("id_persona")),
                        conexion.getResultadoQuery().getString("usuario"),
                        conexion.getResultadoQuery().getString("contraseña"),
                        conexion.getResultadoQuery().getString("estado")
                        );
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
   
        
    
    
    
    

