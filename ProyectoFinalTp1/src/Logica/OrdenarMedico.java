/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.*;
import Entidades.Medico;

public class OrdenarMedico implements Comparator<Medico>{

    @Override
    public int compare(Medico o1, Medico o2) {
        return o1.getEspecialidad().compareToIgnoreCase(o2.getEspecialidad())*-1;
    }
    
}
