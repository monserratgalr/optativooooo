/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Infraestructure.Conections;
/**
 *
 * @author Monse
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;


public class Conexiones {
    private String userDB;
    private String passDB;
    private String portDB;
    private String hostDB;
    private String dataBase;
    private String url;
    private Statement querySQL;
    private ResultSet resultQuery;
    
    public Conexiones(String userDB, String passDB, String hostDB, String portDB, String dataBase){
        this.userDB = userDB;
        this.passDB = passDB;
        this.portDB = portDB;
        this.dataBase = dataBase;
        this.hostDB = hostDB;
        this.url = "jdbc:postgresql://"+this.hostDB+":"+this.portDB+"/"+dataBase;
    }
    public Connection conexionDB() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(this.url, this.userDB, this.passDB);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean verificarConexion() {
        Connection connection = conexionDB();
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión establecida correctamente");
                return true;
            } catch (SQLException e) {
                Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        System.err.println("La conexión no se ha podido establecer");
        return false;
    }
    public Statement getQuerySQL(){
        return this.querySQL;
    }
    public void setQuerySQL(Statement sentencia){
        this.querySQL = sentencia;
    }
    public ResultSet getResultadoQuery(){
        return this.resultQuery;
    }
    public void setResultadoQuery(ResultSet resultado){
        this.resultQuery = resultado;
    }
}

