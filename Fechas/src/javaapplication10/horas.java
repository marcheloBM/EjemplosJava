/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author march
 */
public class horas {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        int horas,min1,min2,minutos,segundos,seg1,seg2;
        
        int HoraIngreso = 8; 
        int MinutoIngreso = 30; 
        int SegundosIngreso = 00;
        
        int horaSalidaLounch = 7; 
        int MinutoSalidaLounch = 00; 
        int SegundosSalidaLounch = 15;
        
        int HoraRetornoLounch = 10; 
        int MinutoRetornoLounch = 30; 
        int SegundosRetornoLounch = 0; 
        
        int HoraSalida = 11; 
        int MinutoSalida = 30; 
        int SegundosSalida = 15; 

        horas = ((horaSalidaLounch - HoraIngreso) + ( HoraSalida - HoraRetornoLounch)); 
        if (MinutoSalidaLounch >= MinutoIngreso){
            min1 = (MinutoSalidaLounch - MinutoIngreso);
        }else{
            min1 = MinutoIngreso - MinutoSalidaLounch; 
        }
        
        if (MinutoRetornoLounch >= MinutoSalida){
            min2 = (MinutoRetornoLounch - MinutoSalida); 
        }else{
            min2 = (MinutoSalida -MinutoRetornoLounch); 
        } 
        
        //CALCULA LOS MINUTOS 
        minutos = min2+min1; 

        if (SegundosSalidaLounch >= SegundosIngreso){
            seg1 = (SegundosSalidaLounch - SegundosIngreso); 
        }else{
            seg1 = SegundosIngreso - SegundosSalidaLounch; 
        } 
        if (SegundosRetornoLounch >= SegundosSalida){
            seg2 = (SegundosRetornoLounch - SegundosSalida); 
        }else{
            seg2 = (SegundosSalida - SegundosRetornoLounch); 
        } 
        //Calcula los segundos
        segundos = seg1 + seg2; 
        System.out.println("El día de hoy " + new Date()+ " \ntrabajo " +horas +":"+minutos+":" + segundos);
//JOptionPane.showMessageDialog(null, "El día de hoy " + new Date()+ " trabajo " +horas +":"+minutos+":" + segundos, "Hasta Mañana", 2);
    }
    
}
