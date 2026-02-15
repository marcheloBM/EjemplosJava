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
public class restar_fechas {

    /**
     * @param args the command line arguments
     */
    public void restar_fecha() {

        Date fechaActual = new Date();
        Date fechaInicio =new Date("2017/03/04 19:45:00");
//        String fechaInicio = "24-04-1989";
//        String fechaActual = "02-03-2017";
//        Date date = new Date();
        DateFormat dateFormatFecha = new SimpleDateFormat("dd/MM/yyyy");
        String dayI=dateFormatFecha.format(fechaInicio);
        String dayA=dateFormatFecha.format(fechaActual);
//        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
//        fechaActual = df.format(date);
        String[] aFechaIng = dayI.split("/");
        Integer diaInicio = Integer.parseInt(aFechaIng[0]);
        Integer mesInicio = Integer.parseInt(aFechaIng[1]);
        Integer anioInicio = Integer.parseInt(aFechaIng[2]);

        String[] aFecha = dayA.split("/");
        Integer diaActual = Integer.parseInt(aFecha[0]);
        Integer mesActual = Integer.parseInt(aFecha[1]);
        Integer anioActual = Integer.parseInt(aFecha[2]);

        System.out.println("Dia: "+diaActual);
        System.out.println("Mes: "+mesActual);
        System.out.println("Año: "+anioActual);
        int b = 0;
        int dias = 0;
        int mes = 0;
        int anios = 0;
        int meses = 0;
        mes = mesInicio - 1;
        if (mes == 2) {
            if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))) {
                b = 29;
            } else {
                b = 28;
            }
        } else if (mes <= 7) {
            if (mes == 0) {
                b = 31;
            } else if (mes % 2 == 0) {
                b = 30;
            } else {
                b = 31;
            }
        } else if (mes > 7) {
            if (mes % 2 == 0) {
                b = 31;
            } else {
                b = 30;
            }
        }
        if ((anioInicio > anioActual) || (anioInicio == anioActual && mesInicio > mesActual)
                || (anioInicio == anioActual && mesInicio == mesActual && diaInicio > diaActual)) {
            System.out.println("La fecha de inicio debe ser anterior a la fecha Actual");
        } else {
            if (mesInicio <= mesActual) {
                anios = anioActual - anioInicio;
                if (diaInicio <= diaActual) {
                    meses = mesActual - mesInicio;
                    dias = b - (diaInicio - diaActual);
                } else {
                    if (mesActual == mesInicio) {
                        anios = anios - 1;
                    }
                    meses = (mesActual - mesInicio - 1 + 12) % 12;
                    dias = b - (diaInicio - diaActual);
                }
            } else {
                anios = anioActual - anioInicio - 1;
                System.out.println("Años: "+anios);
                if (diaInicio > diaActual) {
                    meses = mesActual - mesInicio - 1 + 12;
                    dias = b - (diaInicio - diaActual);
                } else {
                    meses = mesActual - mesInicio + 12;
                    dias = diaActual - diaInicio;
                }
            }
        }

        System.out.println("Años: " + anios);
        System.out.println("Meses: " + meses);
        System.out.println("Días: " + dias);

    }

    public static void main(String[] args) {
        new restar_fechas().restar_fecha();
    }
    
}
