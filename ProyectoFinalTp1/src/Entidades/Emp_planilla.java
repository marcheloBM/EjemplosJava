/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.*;


public class Emp_planilla extends Empleado{
    
    private double salario;
    private double porcentaje_hora;

    public Emp_planilla() {
        salario=0;
        porcentaje_hora=0;
    }

    public Emp_planilla(String dni, String nombre, String apellido, GregorianCalendar fechaNacimiento, 
            String direccion, String ciudad, String codigo, int horasExtra, GregorianCalendar fecha_ingreso,
            String area, String cargo, double salario, double porcentaje_hora) {
        
        super(dni, nombre, apellido, fechaNacimiento, direccion, ciudad, codigo, horasExtra, fecha_ingreso, area, cargo);
        this.salario=salario;
        this.porcentaje_hora=porcentaje_hora;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getPorcentaje_hora() {
        return porcentaje_hora;
    }

    public void setPorcentaje_hora(double porcentaje_hora) {
        this.porcentaje_hora = porcentaje_hora;
    }

    @Override
    public String toString() {
        return "\n Empleado de planilla: " +
                super.toString()+
                "\n Salario: "+getSalario()+
                "\n Salario Neto: "+getSalarioNeto();
    }
    

    @Override
    public double getSalarioNeto() {
        return getSalario()*(1+getPorcentaje_hora()*getHorasExtra());
    }
    
}
