/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.util.*;

public abstract class Empleado extends Persona implements Salario{
    
    private String codigo;
    private int horasExtra;
    private GregorianCalendar fecha_ingreso;
    private String area;
    private String cargo;

    public Empleado() {
        codigo="";
        horasExtra=0;
        fecha_ingreso=new GregorianCalendar();
        area="";
        cargo="";
    }

    public Empleado(String dni, String nombre, String apellido, GregorianCalendar fechaNacimiento, String direccion, String ciudad,
            String codigo, int horasExtra, GregorianCalendar fecha_ingreso, String area, String cargo) {
        super(dni, nombre, apellido, fechaNacimiento, direccion, ciudad);
        this.codigo=codigo;
        this.horasExtra=horasExtra;
        this.fecha_ingreso=fecha_ingreso;
        this.area=area;
        this.cargo=cargo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public GregorianCalendar getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(GregorianCalendar fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "\nEmpleado: " + super.toString()+
                "\n codigo: " + getCodigo() +
                "\n horasExtra: " + getHorasExtra() +
                "\n fecha ingreso: " + getFecha_ingreso().get(Calendar.DAY_OF_MONTH) +
                "/"+getFecha_ingreso().get(Calendar.MONTH)+
                "/"+getFecha_ingreso().get(Calendar.YEAR)+
                "\n area: " + getArea() + 
                "\n cargo: " + getCargo();
    }

    
    
    
    
    
}
