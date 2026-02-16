/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import FUN.ComandosCMD;
import FUN.Directorio;
import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author march
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Directorio.crearDirecPre();
        NewJFrame frame = new NewJFrame();
        frame.setVisible(true);

//        String fechaInsta = "cmd /c wmic os get installdate";
//        String fi = ComandosCMD.cmd(fechaInsta);
//        fi=fi.substring(0, fi.indexOf('.'));
//        int n1=0;
//        int n2=4;
//        String fecha="";
//        for (int i = 0; i < 6; i++) {
//            if(n1==0){
//                fecha=fecha+""+fi.substring(n1,n2);
//                n1=n1+4;
//                n2=n2+2;
//            }else{
//                if(n1==8){
//                    fecha=fecha+" "+fi.substring(n1,n2);
//                    n1=n1+2;
//                    n2=n2+2;
//                }else{
//                    if(n1>=8){
//                        fecha=fecha+":"+fi.substring(n1,n2);
//                        n1=n1+2;
//                        n2=n2+2;
//                    }else{
//                        fecha=fecha+"-"+fi.substring(n1,n2);
//                        n1=n1+2;
//                        n2=n2+2;
//                    }
//                }
//            }
//        }
//        System.out.println(fecha);
//        String largo = "990715586";
//        System.out.println(largo.length());
        
//        Properties p = System.getProperties();
//        p.list(System.out);
        
//        String OP = System.getProperty("os.name");
//        System.out.println(OP);

//        String comando = "ipconfig";
//        String rep = ComandosCMD.cmd(comando);
//        System.out.println(rep);
        
//       String d = "Al fondo de la plaza se elevaba el Ayuntamiento, un edificio encalado,"
//               + " con un largo balcón en el primer piso y ventanas enrejadas en la planta baja."
//               + " Junto al portalón de piedra, en letras doradas, se ";
//        System.out.println(d.length());
//        String OrigenCarpeta = "Trabajo"; 
//        String SO = System.getProperty("os.name");
//        System.out.println(SO);
//        if(SO.startsWith("Windows")){
//            System.out.println("Es Windows");
//            File directorio = new File("c:/"+ OrigenCarpeta ); 
//            directorio.mkdir();
//        }else{
//            System.out.println("Es Otro");
//            File directorio = new File("/media/devtroce/java/"+ OrigenCarpeta ); 
//            directorio.mkdir();
//        }
        
//        javax.swing.filechooser.FileNameExtensionFilter filtroWord=new FileNameExtensionFilter("Microsoft Word 2016", "docx");
//        
//        final JFileChooser miArchivo=new JFileChooser();
//        miArchivo.setFileFilter(filtroWord);
//        miArchivo.setSelectedFile(new File("Documento"));
//        String userDir = System.getProperty("user.home");
//        miArchivo.setCurrentDirectory(new File(userDir +"/Desktop"));
//        int aceptar=miArchivo.showSaveDialog(null);
//        miArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        if(aceptar==JFileChooser.APPROVE_OPTION){
//            File fileWord=miArchivo.getSelectedFile();
//            String nombre=fileWord.getName();
//            if(nombre.indexOf('.')==-1){
//                nombre+=".docx";
//                fileWord=new File(fileWord.getParentFile(), nombre);
//            }
//        }
        
    }
    
}
