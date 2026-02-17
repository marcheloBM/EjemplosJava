/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.*;


public class Paciente extends Persona{
    
    private String nro_historia;
    private String sexo;
    private String grupo_sanguineo;
    private String medicamentos_alergico;

    public Paciente() {
        nro_historia="";
        sexo="M";
        grupo_sanguineo="";
        medicamentos_alergico="";
        
    }

    public Paciente(String dni, String nombre, String apellido, GregorianCalendar fechaNacimiento, String direccion, String ciudad,
            String nro_historia, String sexo, String grupo_sanguineo, String medicamentos_alergico) {
        super(dni, nombre, apellido, fechaNacimiento, direccion, ciudad);
        this.nro_historia=nro_historia;
        this.sexo=sexo;
        this.grupo_sanguineo=grupo_sanguineo;
        this.medicamentos_alergico=medicamentos_alergico;
    }

    public String getNro_historia() {
        return nro_historia;
    }

    public void setNro_historia(String nro_historia) {
        this.nro_historia = nro_historia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public String getMedicamentos_alergico() {
        return medicamentos_alergico;
    }

    public void setMedicamentos_alergico(String medicamentos_alergico) {
        this.medicamentos_alergico = medicamentos_alergico;
    }

    @Override
    public String toString() {
        return "\n Paciente: " + super.toString()+
                "\n nro historia: " + getNro_historia() +
                "\n sexo: " + getSexo() +
                "\n grupo sanguineo: " + getGrupo_sanguineo() +
                "\n medicamentos alergico: " + getMedicamentos_alergico();
    }
    
    
    
}
