/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ingenio.ds.util;

import static ingenio.ds.util.ImageResizer.copyImage;

/**
 *
 * @author march
 */
public class image {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Ruta de la imagen original
        String originalPath = "imagenes/GamePad1.jpg";
        
        // Ruta donde se guardará la copia redimensionada
        String copyPath = "imagenes2/GamePad1.jpg";
        
        // Llamada al método
        copyImage(originalPath, copyPath);
        
        System.out.println("Imagen copiada y redimensionada en: " + copyPath);

    }
    
}
