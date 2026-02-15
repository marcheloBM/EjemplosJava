/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author march
 */
public class FechaHorasCalcular {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date fechaInicio = new Date();
        Date fechaAnterio =new Date("1989/04/24 19:45:00");
        
        System.out.println("Fecha Actual Completa: "+fechaInicio);
        System.out.println("Fecha Anterio Completa: "+fechaAnterio);
        
        DateFormat dateFormatFecha = new SimpleDateFormat("dd/MM/yyyy");
        String dac=dateFormatFecha.format(fechaInicio);
        System.out.println("Fecha Actual Solo Dia-Mes-Año: "+dac);
                     
        String[] aFechaActual = dac.split("/");
        Integer diaActual = Integer.parseInt(aFechaActual[0]);
        Integer mesActual = Integer.parseInt(aFechaActual[1]);
        Integer anioActual = Integer.parseInt(aFechaActual[2]);
        
        System.out.println("Dia Actual: "+diaActual);
        System.out.println("Mes Actual: "+mesActual);
        System.out.println("Año Actual: "+anioActual);
        
        DateFormat dateFormatHoras = new SimpleDateFormat("HH:mm:ss");
        String d1=dateFormatHoras.format(new Date());
        System.out.println("Fecha Solo Horas-Minutos-Segundos: "+d1);
        
        String[] aHoraActual = d1.split(":");
        Integer horaActual = Integer.parseInt(aHoraActual[0]);
        Integer minutoActual = Integer.parseInt(aHoraActual[1]);
        Integer segundoActual = Integer.parseInt(aHoraActual[2]);
        
        System.out.println("Hora Actual: "+horaActual);
        System.out.println("Minuto Actual: "+minutoActual);
        System.out.println("Segundo Actual: "+segundoActual);
        
        String dan=dateFormatFecha.format(fechaAnterio);
        System.out.println("Fecha Anterior Solo Dia-Mes-Año: "+dan);
        String[] aFechaAnterio = dan.split("/");
        Integer diaAnterior = Integer.parseInt(aFechaAnterio[0]);
        Integer mesAnterior = Integer.parseInt(aFechaAnterio[1]);
        Integer anioAnterior = Integer.parseInt(aFechaAnterio[2]);
        System.out.println("Dia Anterior: "+diaAnterior);
        System.out.println("Mes Anterior: "+mesAnterior);
        System.out.println("Año Anterior: "+anioAnterior);
        
        
        
    }
    
}
