/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author marcelo
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.util.Date utilDate = new java.util.Date();
        java.util.Date act = new java.util.Date();
        
        
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        java.sql.Date ac = new java.sql.Date(act.getTime());
        
        cal c = new cal();
        c.calcularfecha(sqlDate, ac);
        c.calcularHoras(ac, ac);
    }
    
}
