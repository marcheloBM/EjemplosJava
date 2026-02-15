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
public class JavaApplication10 {
    private static Object dateFormat;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Muestra la dia mes año
        DateFormat dateFormatFecha = new SimpleDateFormat("dd/MM/yyyy");
        String d=dateFormatFecha.format(new Date());
        System.out.println(dateFormatFecha.format(new Date()));
        
        //Muestra horas minutoa y segundos
        DateFormat dateFormatHoras = new SimpleDateFormat("HH:mm:ss");
        String d1=dateFormatHoras.format(new Date());
        System.out.println(dateFormatHoras.format(new Date()));
        
        //Muestra El dia en palabras
        DateFormat dateFormatDia = new SimpleDateFormat("EEEE");
        String d2=dateFormatDia.format(new Date());
        System.out.println(dateFormatDia.format(new Date()));
        
        //Muestra la zona horaria
        DateFormat dateFormatZona = new SimpleDateFormat("z");
        String d3=dateFormatZona.format(new Date());
        System.out.println(dateFormatZona.format(new Date()));
        
        //Muestra senana del año
        DateFormat dateFormatSena = new SimpleDateFormat("w");
        String d4=dateFormatSena.format(new Date());
        System.out.println(dateFormatSena.format(new Date()));
        
        //Muestra senana del mes
        DateFormat dateFormatSenaAno = new SimpleDateFormat("W");
        String d5=dateFormatSenaAno.format(new Date());
        System.out.println(dateFormatSenaAno.format(new Date()));
        
        
        System.out.println("-------------------------------------------------");
        System.out.println("Fecha actual "+d+" \nHora Actual "+d1+" \nDia "+d2+" \nLa zona Horaria "+d3+" \nSenana del año "+d4+" \nSenana del mes "+d5);
        
        
        
    }
    
}
