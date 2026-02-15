/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.ENT;

/**
 *
 * @author march
 */
public class Cuenta {
    private String numeroCuenta;
    private String nombre;
    private String saldo;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public Cuenta(String numeroCuenta, String nombre, String saldo) {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.saldo = saldo;
    }
    
    
}
