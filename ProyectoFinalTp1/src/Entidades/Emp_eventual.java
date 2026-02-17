/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.util.*;

public class Emp_eventual extends Empleado{
    
    private double pagohora;
    private double horas_normales;
    private GregorianCalendar fecha_termino;

    public Emp_eventual() {
        pagohora=0;
        horas_normales=0;
        fecha_termino=new GregorianCalendar();
    }

    public Emp_eventual(String dni, String nombre, String apellido, GregorianCalendar fechaNacimiento, 
            String direccion, String ciudad, String codigo, int horasExtra, GregorianCalendar fecha_ingreso, String area, String cargo,
            double pagohora, double horas_normales, GregorianCalendar fecha_termino) {
        
        super(dni, nombre, apellido, fechaNacimiento, direccion, ciudad, codigo, horasExtra, fecha_ingreso, area, cargo);
        this.pagohora=pagohora;
        this.horas_normales=horas_normales;
        this.fecha_termino=fecha_termino;
    }

    public double getPagohora() {
        return pagohora;
    }

    public void setPagohora(double pagohora) {
        this.pagohora = pagohora;
    }

    public double getHoras_normales() {
        return horas_normales;
    }

    public void setHoras_normales(double horas_normales) {
        this.horas_normales = horas_normales;
    }

    public GregorianCalendar getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(GregorianCalendar fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    @Override
    public String toString() {
        return "\n Empleado eventual: " +
                super.toString()+
                "\n horas normales: " + getHoras_normales() + 
                "\n pago x hora: " + getPagohora() +
                "\n Salario Neto: "+getSalarioNeto()+
                "\n fecha fin contrato: " + getFecha_termino().get(Calendar.DAY_OF_MONTH)+
                "/"+getFecha_termino().get(Calendar.MONTH)+
                "/"+getFecha_termino().get(Calendar.YEAR);
    }

    @Override
    public double getSalarioNeto() {
        return getPagohora()*(getHoras_normales()+getHorasExtra());
    }
    
}
