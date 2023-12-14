/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Infraestructure.DbManagment.Contactos;

/**
 *
 * @author Monse
 */
public class Movimientos {
    private String fecha_movimiento;
    private String tipo_movimiento;
    private String saldo_anterior;
    private String saldo_actual;
    private String monto_movimiento;
    private String cuenta_origen;
    private String canal;
    private int id_movimiento;
    private int id_cuenta;

    

    public String getFecha_movimiento() {
        return fecha_movimiento;
    }
    public void setFechaMovimiento(String fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }
    public String getTipo_movimiento() {
        return tipo_movimiento;
    }
    public void setTipoMovimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }
    public String getSaldo_anterior() {
        return saldo_anterior;
    }
    public void setSaldo_anterior(String saldo_anterior) {
        this.saldo_anterior = saldo_anterior;
    }
    public String getSaldo_actual() {
        return saldo_actual;
    }
    public void setSaldo_actual(String saldo_actual) {
        this.saldo_actual = saldo_actual;
    }
    public String getMonto_movimiento() {
        return monto_movimiento;
    }
    public void setMonto_movimiento(String monto_movimiento) {
        this.monto_movimiento = monto_movimiento;
    }
    public String getCuenta_origen() {
        return cuenta_origen;
    }
    public void setCuenta_origen(String cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }
    public String getCanal() {
        return canal;
    }
    public void setCanal(String canal) {
        this.canal = canal;
    }
    public int getId_movimiento() {
        return id_movimiento;
    }
    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }
    public int getId_cuenta() {
        return id_cuenta;
    }
    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }  
}

