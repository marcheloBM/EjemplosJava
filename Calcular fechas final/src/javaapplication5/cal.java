/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author marcelo
 */
public class cal {
    public void calcularfecha(Date buscar,Date actual){
        //Fecha a buscar
        Date fechaInicio = buscar;
        //Fecha a actual
        Date fechaActual = actual;
        deferencia d = new deferencia();
        long TotalAños = d.getDiffDates(fechaInicio, fechaActual, 0);
        long TotalMeses = d.getDiffDates(fechaInicio, fechaActual, 1);
        long TotalDías = d.getDiffDates(fechaInicio, fechaActual, 2);
        long MesesDelAnio = d.getDiffDates(fechaInicio, fechaActual, 3);
        long DiasDelMes = d.getDiffDates(fechaInicio, fechaActual, 4);
                
//        System.out.println(TotalAños);
//        System.out.println(TotalMeses);
//        System.out.println(TotalDías);
//        System.out.println(MesesDelAnio);
//        System.out.println(DiasDelMes);
//        System.out.println("TotalAños:"+TotalAños+" TotalMeses: "+TotalMeses+" TotalDías:"+TotalDías+
//                " MesesDelAnio:"+MesesDelAnio+" DiasDelMes:"+DiasDelMes);
        System.out.println(fechaInicio+" \n"+fechaActual);
        System.out.println("Tiempo Transcurrido Años:"+TotalAños+" Meses:"+MesesDelAnio+" Días:"+DiasDelMes);
        System.out.println("Dias Transcurridos "+TotalDías);
    }
    public String mostrarFecha(java.util.Date date){
        //Muestra la dia mes año
        DateFormat dateFormatFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String d=dateFormatFecha.format(date);
        System.out.println("Muestra El dia-mes-año: "+d);
        return d;
    }
    public void calcularHoras(Date dateStar,Date dateSto){
        
        String dateStart = mostrarFecha(dateStar);
        String dateStop = mostrarFecha(dateSto);

        Date d1 = dateStar;
        Date d2 = dateSto;   

        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000;         
        long diffMinutes = diff / (60 * 1000);         
        long diffHours = diff / (60 * 60 * 1000);                      
        System.out.println("Time in seconds: " + diffSeconds + " seconds.");         
        System.out.println("Time in minutes: " + diffMinutes + " minutes.");         
        System.out.println("Time in hours: " + diffHours + " hours.");
    }
}
