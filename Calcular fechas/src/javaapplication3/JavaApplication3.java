/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author march
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        String fechaAnt= "29/10/2008";
//        String fechaHoy= "29/10/2009"; 
//        fechas fe = new fechas();
//        int anios = fe.diferenciaFechas(fechaAnt, fechaHoy, 3); 
//        System.out.println(anios);
//        int meses = fe.diferenciaFechas(fechaAnt, fechaHoy, 2); 
//        System.out.println(meses);
//        int horas = fe.diferenciaFechas(fechaAnt, fechaHoy, 1); 
//        System.out.println(horas);
//
//
//
//        String fechaInicio = "28/12/1999";
//        String fechaActual = "24/04/2017";
//        String[] aFechaIng = fechaInicio.split("/");
//        Integer diaInicio = Integer.parseInt(aFechaIng[0]);
//        Integer mesInicio = Integer.parseInt(aFechaIng[1]);
//        Integer anioInicio = Integer.parseInt(aFechaIng[2]);
//
//        String[] aFecha = fechaActual.split("/");
//        Integer diaActual = Integer.parseInt(aFecha[0]);
//        Integer mesActual = Integer.parseInt(aFecha[1]);
//        Integer anioActual = Integer.parseInt(aFecha[2]);
//
//        System.out.println(diaActual);
//        System.out.println(mesActual);
//        System.out.println(anioActual);
//        int b = 0;
//        int dias = 0;
//        int mes = 0;
//        mes = mesInicio - 1;
//        if(mes==2){
//            if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))){
//                b = 29;
//            }else{
//                b = 28;
//            }
//        }else if(mes <= 7){
//            if(mes == 0){
//                b = 31;
//            }else if(mes % 2==0){
//                b = 30;
//            }else{
//                b = 31;
//            }
//        }else if(mes > 7){
//            if(mes % 2 == 0){
//                b = 31;
//            }else{
//                b = 30;
//            }
//        }
//        if((anioInicio > anioActual) || (anioInicio == anioActual && mesInicio > mesActual) ||
//        (anioInicio == anioActual && mesInicio == mesActual && diaInicio > diaActual)){
//        System.out.println("La fecha de inicio ha de ser anterior a la fecha Actual");
//        }else{
//        if(mesInicio <= mesActual){
//        anios = anioActual - anioInicio;
//        if (diaInicio <= diaActual){
//        meses = mesActual - mesInicio;
//        dias = b - (diaInicio - diaActual);
//        }else{
//        if(mesActual == mesInicio){
//        anios = anios - 1;
//        }
//        meses = (mesActual - mesInicio - 1 + 12) % 12;
//        dias = b - (diaInicio - diaActual);
//        }
//        }else{
//        anios = anioActual - anioInicio - 1;
//        System.out.println(anios);
//        if(diaInicio > diaActual){
//        meses = mesActual - mesInicio - 1 + 12;
//        dias = b - (diaInicio - diaActual);
//        }else{
//        meses = mesActual - mesInicio + 12;
//        dias = diaActual -diaInicio;
//        }
//        }
//        } 
//
//        System.out.println("Años: "+anios);
//        System.out.println("Meses: "+meses);
//        System.out.println("Días: "+dias);
//        Date fechaActual = Date.valueOf(LocalDate.of(2017, 04, 28));
//        deferencia d = new deferencia();
//        long TotalAños = d.getDiffDates(fechaInicio, fechaActual, 0);
//        long TotalMeses = d.getDiffDates(fechaInicio, fechaActual, 1);
//        long TotalDías = d.getDiffDates(fechaInicio, fechaActual, 2);
//        long MesesDelAnio = d.getDiffDates(fechaInicio, fechaActual, 3);
//        long DiasDelMes = d.getDiffDates(fechaInicio, fechaActual, 4);
//                
////        System.out.println(TotalAños);
////        System.out.println(TotalMeses);
////        System.out.println(TotalDías);
////        System.out.println(MesesDelAnio);
////        System.out.println(DiasDelMes);
////        System.out.println("TotalAños:"+TotalAños+" TotalMeses: "+TotalMeses+" TotalDías:"+TotalDías+
////                " MesesDelAnio:"+MesesDelAnio+" DiasDelMes:"+DiasDelMes);
//        System.out.println(fechaInicio+" \n"+fechaActual);
//        System.out.println("Tiempo Transcurrido Años:"+TotalAños+" Meses:"+MesesDelAnio+" Días:"+DiasDelMes);
//        System.out.println("Dias Transcurridos "+TotalDías);
//              2 Forma
        //Fecha a buscar
        Date fechaInicio = Date.valueOf(LocalDate.of(2025, 04, 12));
        //Fecha a actual
        Date fechaActual = Date.valueOf(LocalDate.of(2026, 02, 15));
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
      
        
        
//        String fechaasdas = fechaasdas();
//        System.out.println(fechaasdas);
//        




    }
//    public static String fechaasdas(){
//        //pruebas 31-12-2008 09:45 && 09-04-2009 12:27 //hay 3 meses 9 dias 2 horas 41 minutos
//        String fechaInicial =   "31-12-2005 09:45:00";
//        String fechaFinal =     "09-04-2009 12:27:00";
//        //System.out.println("año :"+fecha.substring(6,10));
//        //System.out.println("dia :"+fecha.substring(0,2));
//        //System.out.println("mes :"+fecha.substring(3,5));
//        //System.out.println("hora :"+fecha.substring(11,13));
//        //System.out.println("minuto :"+fecha.substring(14,16));
//        //System.out.println("seg :"+fecha.substring(17,19));
//    
//    
//        
//        java.util.GregorianCalendar jCal = new java.util.GregorianCalendar();
//        java.util.GregorianCalendar jCal2 = new java.util.GregorianCalendar();
//        //jCal.set(year, month, date, hourOfDay, minute)
//        jCal.set(Integer.parseInt(fechaInicial.substring(6,10)), Integer.parseInt(fechaInicial.substring(3,5))-1, Integer.parseInt(fechaInicial.substring(0,2)), Integer.parseInt(fechaInicial.substring(11,13)),Integer.parseInt(fechaInicial.substring(14,16)), Integer.parseInt(fechaInicial.substring(17,19)));
//        jCal2.set(Integer.parseInt(fechaFinal.substring(6,10)), Integer.parseInt(fechaFinal.substring(3,5))-1, Integer.parseInt(fechaFinal.substring(0,2)), Integer.parseInt(fechaFinal.substring(11,13)),Integer.parseInt(fechaFinal.substring(14,16)), Integer.parseInt(fechaFinal.substring(17,19)));
//        
//        //System.out.println("Date format " + dateformat.format(jCal.getTime()) + "\n");
//        //System.out.println("Date format " + dateformat.format(jCal2.getTime()) + "\n");
// 
//        long diferencia = jCal2.getTime().getTime()-jCal.getTime().getTime();
//        double minutos = diferencia / (1000 * 60);
//        long horas = (long) (minutos / 60);
//        long minuto = (long) (minutos%60);
//        long segundos = (long) diferencia % 1000;
//        long dias = horas/24;
//        //Calcular meses...
//        //Crear vector para almacenar los diferentes dias maximos segun correponda
//        String[] mesesAnio = new String[12];
//        mesesAnio[0] = "31";
//        //validacion de los años bisiestos
//        if (jCal.isLeapYear(jCal.YEAR)){mesesAnio[1] = "29";}else{mesesAnio[1] = "28";}
//        mesesAnio[2] = "31";
//        mesesAnio[3] = "30";
//        mesesAnio[4] = "31";
//        mesesAnio[5] = "30";
//        mesesAnio[6] = "31";
//        mesesAnio[7] = "31";
//        mesesAnio[8] = "30";
//        mesesAnio[9] = "31";
//        mesesAnio[10] = "30";
//        mesesAnio[11] = "31";
//        int diasRestantes = (int) dias;
//        //variable almacenará el total de meses que hay en esos dias
//        int totalMeses = 0;
//        int mesActual = jCal.MONTH;
//        //Restar los dias de cada mes desde la fecha de ingreso hasta que ya no queden sufcientes dias para 
//        // completar un mes.
//        for (int i=0; i<=11; i++ ){
//            //Validar año, si sumando 1 al mes actual supera el fin de año, 
//            // setea la variable a principio de año 
//            if ((mesActual+1)>=12){
//                mesActual = i;
//            }
//            //Validar que el numero de dias resultantes de la resta de las 2 fechas, menos los dias
//            //del mes correspondiente sea mayor a cero, de ser asi totalMeses aumenta,continuar hasta 
//            //que ya nos se cumpla.
//            if ((diasRestantes -Integer.parseInt(mesesAnio[mesActual]))>=0){
//                totalMeses ++;
//                diasRestantes = diasRestantes- Integer.parseInt(mesesAnio[mesActual]);
//                mesActual ++;
//            }else{
//                break;
//            }
//        }
//        //Resto de horas despues de sacar los dias
//        horas = horas % 24;
//        String salida ="";
//        if (totalMeses > 0){
//            if (totalMeses > 1)
//                salida = salida+  String.valueOf(totalMeses)+" Meses,  ";
//            else
//                salida = salida+  String.valueOf(totalMeses)+" Mes, ";
//        }
//        if (diasRestantes > 0){
//            if (diasRestantes > 1)
//                salida = salida+  String.valueOf(diasRestantes)+" Dias, ";
//            else
//                salida = salida+  String.valueOf(diasRestantes)+" Dia, ";
//        }
//        
//        
//         salida =salida +"Horas "+String.valueOf(horas)+": Minutos "+String.valueOf(minuto)+": Segundos "+String.valueOf(segundos)+".";
//        return salida;
//        }
}
