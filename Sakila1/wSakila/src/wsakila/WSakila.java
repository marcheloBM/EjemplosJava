/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wsakila;

import cl.burgos.sakila.DAO.*;
import cl.burgos.sakila.Ent.*;

/**
 *
 * @author palto
 */
public class WSakila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // para la primera vez para guardar datos en la base de datos
        Actor a1 = new Actor("marchelo","burgos");
        ActorDAO.sqlAgregar(a1);
        
        Language l1= new Language("Chino");
        Language l2=new Language(7);
        //LanguageDAO.sqlAgregar(l1);
//        LanguageDAO.sqlEliminar(l2);
    }
    
}
