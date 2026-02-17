/*
 * Cita.java
 *
 * Created on 5 de junio de 2007, 21:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package agenda;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 * @author Administrador
 */
public class Cita implements Serializable{
    
    private GregorianCalendar gc;
    private String texto;
    /** Creates a new instance of Cita */
    public Cita(GregorianCalendar gc, String texto) {
        this.setGc(gc);
        this.setTexto(texto);
    }

    public GregorianCalendar getGc() {
        return gc;
    }

    public void setGc(GregorianCalendar gc) {
        this.gc = gc;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String toString() {
        int hora = gc.get(GregorianCalendar.HOUR_OF_DAY);
        return hora + "- " + texto;
    }
    

    
}
