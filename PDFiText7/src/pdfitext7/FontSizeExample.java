/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfitext7;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author march
 */
public class FontSizeExample {
    private static Logger LOGGER = Logger.getLogger("mx.hash.fontsize.fontsizeitext.FontSizeExample");
    
    public void crearPDFAll(String dest){
        try {
            // Creamos un documento pdf con iText
            PdfWriter pdfWriter = new PdfWriter(dest+"./fontSize.pdf");
            PdfDocument pdfDoc = new PdfDocument(pdfWriter);
            Document doc = new Document(pdfDoc, PageSize.LETTER);
            
            // Creamos unos parrafos
            Paragraph parrafo1 = new Paragraph("Prueba con el tamaño por default Prueba con el tamaño por default Prueba con el tamaño por default Prueba con el tamaño por default Prueba con el tamaño por default Prueba con el tamaño por default Prueba con el tamaño por default Prueba con el tamaño por default Prueba con el tamaño por default Prueba con el tamaño por default Prueba con el tamaño por default Prueba con el tamaño por default Prueba con el tamaño por default");
            Paragraph parrafo2 = new Paragraph("Demostracion de letra mas pequeña Demostracion de letra mas pequeña Demostracion de letra mas pequeña Demostracion de letra mas pequeña Demostracion de letra mas pequeña Demostracion de letra mas pequeña Demostracion de letra mas pequeña Demostracion de letra mas pequeña Demostracion de letra mas pequeña Demostracion de letra mas pequeña Demostracion de letra mas pequeña Demostracion de letra mas pequeña Demostracion de letra mas pequeña");
            Paragraph parrafo3 = new Paragraph("Ejemplo con una letra mas grande Ejemplo con una letra mas grande Ejemplo con una letra mas grande Ejemplo con una letra mas grande Ejemplo con una letra mas grande Ejemplo con una letra mas grande Ejemplo con una letra mas grande Ejemplo con una letra mas grande Ejemplo con una letra mas grande Ejemplo con una letra mas grande Ejemplo con una letra mas grande Ejemplo con una letra mas grande Ejemplo con una letra mas grande ");
            
            // Creamos unas tablas
            float[] anchos = {150f, 150f, 150f};
            Table tabla1 = new Table(anchos);
            Table tabla2 = new Table(anchos);
            Table tabla3 = new Table(anchos);
            
            // Agregamos contenido a las tablas
            tabla1.addCell("Ejemplo con");
            tabla1.addCell("Con tamaño");
            tabla1.addCell("default");
            
            tabla2.addCell("Ejemplo con");
            tabla2.addCell("Con tamaño");
            tabla2.addCell("mas pequeño");
            
            tabla3.addCell("Ejemplo con");
            tabla3.addCell("Con tamaño");
            tabla3.addCell("mas grande");            
            
            // Cambiamos el tamaño de fuente del parrafo 2 lo hacemos mas pequeño
            parrafo2.setFontSize(8f);
            
            // Cambiamos el tamaño de fuente del parrafo 3 lo hacemos mas grande
            parrafo3.setFontSize(20f);
            
            // Cambiamos el tamaño de fuente de la tabla 1, lo hacemos mas pequeño
            tabla2.setFontSize(8f);
            
            // Cambiamos el tamaño de fiente de la tabla 2, lo hacemos mas grande
            tabla3.setFontSize(20f);            
            
            doc.add(parrafo1);
            doc.add(parrafo2);
            doc.add(parrafo3);
            doc.add(tabla1);
            doc.add(tabla2);
            doc.add(tabla3);
            
            doc.close();
        } catch (FileNotFoundException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
}
