/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.*;


public abstract class Persona {
    
    private String dni;
    private String nombre;
    private String apellido;
    private GregorianCalendar fechaNacimiento;
    private String direccion;
    private String ciudad;

    public Persona() {
        dni="";
        nombre="";
        apellido="";
        fechaNacimiento=new GregorianCalendar();
        direccion="";
        ciudad="";
    }

    public Persona(String dni, String nombre, String apellido, GregorianCalendar fechaNacimiento, String direccion, String ciudad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setFechaNacimiento(int dia, int mes, int año){
        fechaNacimiento=new GregorianCalendar(año, mes, dia);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return  "\n dni: " + getDni() +
                "\n nombre: " + getNombre() +
                "\n apellido: " + getApellido() +
                "\n fecha de Nacimiento: " + getFechaNacimiento().get(Calendar.DAY_OF_MONTH) +
                "/"+getFechaNacimiento().get(Calendar.MONTH)+"/"+
                getFechaNacimiento().get(Calendar.YEAR)+
                "\n direccion: " + getDireccion() +
                "\n ciudad:" + getCiudad();
    }
    
    
    
    
}
