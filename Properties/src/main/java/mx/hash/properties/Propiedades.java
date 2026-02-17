/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.hash.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author david
 */
public class Propiedades {
    public static void main(String[] args){
        File archivo = new File("archivo.properties");       
        
        System.out.println("Crearemos un nuevo archivo de configuraciones");
        try {            
            System.out.println("\tCreando el flujo de escritura a archivo");
            
            try (OutputStream outputStream = new FileOutputStream(archivo)) {
                System.out.println("\tCreando el objeto Properties");
                Properties prop = new Properties();
                
                System.out.println("\tCreamos las claves del archivo properties y sus valores");
                // set key and value
                prop.setProperty("db.url", "localhost");
                prop.setProperty("db.usuario", "hashSoft");
                prop.setProperty("db.password", "password");
                
                System.out.println("\tAlmacenamos el arhivo");
                System.out.println("\tCon un comentario al inicio");
                prop.store(outputStream, "Config");
                
                System.out.println("\tEl archivo se cierra en este punto gracias al Try-catch con recursos");
            }
            
            System.out.println("");
            System.out.println("");
            System.out.println("Leemos el archivo de configuracion");
            System.out.println("\tCreando el flujo de lectura a archivo");
            
            try (InputStream inputStream = new FileInputStream(archivo)) {
                Properties prop = new Properties();
                prop.load(inputStream);
                System.out.println("\tLeemos el valor de las claves");
                // get value by key
                System.out.println(prop.getProperty("db.url"));
                System.out.println(prop.getProperty("db.usuario"));
                System.out.println(prop.getProperty("db.password"));
            }
            
            System.out.println("");
            System.out.println("");
            System.out.println("Editaremos el valor de una clave");
            Properties prop = new Properties();
            
            try (InputStream inputStream = new FileInputStream(archivo)) {
                System.out.println("\tPrimero leeremos el archivo ya existente");
                prop.load(inputStream);
            }
      
            try (OutputStream outputStream = new FileOutputStream(archivo)) {          
                System.out.println("\tCambiamos el valor de una de las claves");
                // set key and value
                prop.setProperty("db.url", "serverPrincipal.dyndns.org");
                
                System.out.println("\tAlmacenamos el arhivo");
                prop.store(outputStream, "Config");
            }
            
            System.out.println("");
            System.out.println("");
            System.out.println("** Mostramos las claves");           
            try (InputStream inputStream = new FileInputStream(archivo)) {
                prop = new Properties();
                prop.load(inputStream);
                System.out.println("\tLeemos el valor de las claves");
                // get value by key
                System.out.println(prop.getProperty("db.url"));
                System.out.println(prop.getProperty("db.usuario"));
                System.out.println(prop.getProperty("db.password"));
            }            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado!");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error de entrada salida!");
            ex.printStackTrace();
        }
        
        
    }
}
