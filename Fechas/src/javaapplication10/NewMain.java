/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author march
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    
        public static Date aDate(String strFecha){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy/MM/dd");
        Date fecha = null;

        try {
        fecha = formatoDelTexto.parse(strFecha);
        } catch (java.text.ParseException ex) {
        ex.printStackTrace();
        }
        return fecha;
        }
        public static int fechasDiferenciaEnDias(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
        fechaInicial = df.parse(fechaInicioString);
        }
        catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
        fechaFinal = df.parse(fechaFinalString);
        }
        catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ( (int) dias);
        }

    public static void main(String[] args) {
        // TODO code application logic here
        aDate("2017/03/04");
        Date fechaActual = new Date();
        Date fechaInicio =new Date("2017/03/04 19:45:00");
        int dato=fechasDiferenciaEnDias(fechaInicio, fechaActual);
        System.out.println(dato);
        
    }
    
}
