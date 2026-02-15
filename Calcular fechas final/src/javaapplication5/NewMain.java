/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author marcelo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        String fromDate = "02-02-2017 22:22:22";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        
        java.util.Date utilDate = df.parse(fromDate);
        java.util.Date act = new java.util.Date();
        
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        java.sql.Date ac = new java.sql.Date(act.getTime());
        
        cal c = new cal();
        c.calcularfecha(sqlDate, ac);
        c.calcularHoras(sqlDate, ac);
    }
    
}
