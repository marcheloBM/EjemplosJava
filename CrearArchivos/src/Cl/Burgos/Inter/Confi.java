/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Inter;

/**
 *
 * @author march
 */
public interface Confi {
    //Configuracion de BD localhot
    String ip="localhost";
    String puerto="3306";
    String BaseDatos="RepararPC";
    String userBD="root";
    String passBD="";
    // BD Windows 7
//    String ip="192.168.1.84";
//    String puerto="3306";
//    String BaseDatos="RepararPC";
//    String userBD="marchelo";
//    String passBD="HP2117la";
    //Configuracion de Log
    String nameLog="LogErrorJava.log";
    //Configuracion de Directorio
    static String carpeta = "RepararPC";
    static String SO = System.getProperty("os.name");
    static String userDir = System.getProperty("user.home");
    
    String archivoWorld="Microsoft Word 2016";
    String extencionWorld="docx";
    String mensajeGuar="Guardar archivo";
    String nombrePrede="Documento";
    
}
