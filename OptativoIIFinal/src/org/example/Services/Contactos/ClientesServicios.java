/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Services.Contactos;

import java.util.List;
import org.example.Infraestructure.DbManagment.Contactos.Clientes;
import org.example.Infraestructure.DbManagment.Contactos.ClientesEncapsulamiento;
/**
 *
 * @author Monse
 */
public class ClientesServicios {
    public class Cliente {
    ClientesEncapsulamiento clienteDB;
    public Cliente(String userDB, String passDB, String hostDB, String portDB, String dataBase){
        clienteDB = new ClientesEncapsulamiento(userDB, passDB, hostDB, portDB, dataBase);
    }
    public void registrarCliente(Clientes cliente1){
            clienteDB.registrarCliente(cliente1);
    }
    public void modificarCliente(Clientes cliente1){
           clienteDB.modificarCliente(cliente1);
    }
    public List<Clientes> consultarClientes(){
        return  clienteDB.consultarClientes();
    }
    public Clientes consultarClientePorId(int id_cliente) {
    return clienteDB.consultarClientePorId(id_cliente);
}
    public void eliminarCliente(int cliente1){
        clienteDB.eliminarCliente(cliente1);
    }
}   
}
