/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author march
 */
public class fechas {
    
    public String mostrarFecha(Date date){
        //Muestra la dia mes año
        DateFormat dateFormatFecha = new SimpleDateFormat("dd/MM/yyyy");
        String d=dateFormatFecha.format(date);
        System.out.println("Muestra El dia-mes-año: "+d);
        return d;
    }
    
    public int diferenciaFechas(String fec1, String fec2,int valor){ 
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
    int retorno=0; 
    java.util.Date date1 = null; 
    java.util.Date date2 = null; 
try 
{ 
Calendar cal1 = null; 
date1=df.parse(fec1); 
cal1=Calendar.getInstance(); 

Calendar cal2 = null; 
date2=df.parse(fec2); 
cal2=Calendar.getInstance(); 

// different date might have different offset 
cal1.setTime(date1); 
long ldate1 = date1.getTime() + cal1.get(Calendar.ZONE_OFFSET) + cal1.get(Calendar.DST_OFFSET); 

cal2.setTime(date2); 
long ldate2 = date2.getTime() + cal2.get(Calendar.ZONE_OFFSET) + cal2.get(Calendar.DST_OFFSET); 

// Use integer calculation, truncate the decimals 
int hr1 = (int)(ldate1/3600000); //60*60*1000 
int hr2 = (int)(ldate2/3600000); 

int days1 = (int)hr1/24; 
int days2 = (int)hr2/24; 

int dateDiff = days2 - days1; 
int yearDiff = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR); 
int monthDiff = yearDiff * 12 + cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH); 

if(valor==1) { 
if (dateDiff<0) dateDiff=dateDiff*(-1); 
retorno=dateDiff; 
}else if(valor==2){ 
if (monthDiff<0) monthDiff=monthDiff*(-1); 
retorno=monthDiff; 
}else if(valor==3){ 
if (yearDiff<0) yearDiff=yearDiff*(-1); 
retorno=yearDiff; 
} 
} 
catch (ParseException pe) 
{ 
pe.printStackTrace(); 
} 
return retorno; 
} 
}
