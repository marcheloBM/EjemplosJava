/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author march
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String wind="95 10 7";
        String[] parts = wind.split(" ");
        for (int i = 0; i < parts.length; i++) {
//            System.out.println(parts[i].toString());
            if(parts[i].equals("95")){ System.out.println("Windows "+parts[i].toString()); }
            if(parts[i].equals("98")){ System.out.println("Windows "+parts[i].toString()); }
            if(parts[i].equals("NT")){ System.out.println("Windows "+parts[i].toString()); }
            if(parts[i].equals("ME")){ System.out.println("Windows "+parts[i].toString()); }
            if(parts[i].equals("XP")){ System.out.println("Windows "+parts[i].toString()); }
            if(parts[i].equals("Vista")){ System.out.println("Windows "+parts[i].toString()); }
            if(parts[i].equals("7")){ System.out.println("Windows "+parts[i].toString()); }
            if(parts[i].equals("8")){ System.out.println("Windows "+parts[i].toString()); }
            if(parts[i].equals("10")){ System.out.println("Windows "+parts[i].toString()); }
        }
        
//        String consulta,resp,codigo,nombre;
//        consulta="select * from persona where ";
//        resp="";
//        codigo="987";
//        nombre="";
//        if(codigo.length()>1){
//            resp="Codigo="+codigo;
//        }
//        if(nombre.length()>1){
//            resp="nombre="+nombre;
//        }
//        if(codigo.length()>1 && nombre.length()>1){
//            resp="Codigo="+codigo+" or nombre="+nombre; ;
//        }
//        
//        System.out.println(consulta+resp);
    }
    
}
