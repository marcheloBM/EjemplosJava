/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.GregorianCalendar;


public class Medico extends Empleado{
    
    private double salario;
    private double porcentaje;
    private String especialidad;
    private String servicio;
    private int num_consultorio;

    public Medico() {
        salario=0;
        porcentaje=0;
        especialidad="";
        servicio="";
        num_consultorio=0;
    }

    public Medico(String dni, String nombre, String apellido, GregorianCalendar fechaNacimiento, String direccion, 
            String ciudad, String codigo, int horasExtra, GregorianCalendar fecha_ingreso, String area, String cargo,
            double salario, double porcentaje, String especialidad, String servicio, int num_consultorio) {
        
        super(dni, nombre, apellido, fechaNacimiento, direccion, ciudad, codigo, horasExtra, fecha_ingreso, area, cargo);
        this.salario=salario;
        this.porcentaje=porcentaje;
        this.especialidad=especialidad;
        this.servicio=servicio;
        this.num_consultorio=num_consultorio;           
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getNum_consultorio() {
        return num_consultorio;
    }

    public void setNum_consultorio(int num_consultorio) {
        this.num_consultorio = num_consultorio;
    }

    @Override
    public String toString() {
        return "\n Medico:" + super.toString()+
                "\n salario: " + getSalario() +
                "\n porcentaje: " + getPorcentaje() +
                "\n especialidad: " + getEspecialidad() +
                "\n servicio: " + getServicio() +
                "\n numero consultorio: " + getNum_consultorio()+
                "\n Salario Neto: "+getSalarioNeto();
    }

    @Override
    public double getSalarioNeto() {
        return getSalario()*(1+getPorcentaje()*getHorasExtra());
    }
    
}
