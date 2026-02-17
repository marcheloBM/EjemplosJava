/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfitext7;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author march
 */
public class PruebaExcel {
    
    public void CrearTablaPDF(String dest){
        try {
            // Creamos un documento pdf con iText
            PdfWriter pdfWriter = new PdfWriter(dest+"./Ejemplo Excel.pdf");
            PdfDocument pdfDoc = new PdfDocument(pdfWriter);
            Document doc = new Document(pdfDoc, PageSize.LETTER);
            //Arriba,Abajo,derecha,izqueda
            doc.setMargins(80, 20, 20, 150);
            
            PdfFont font1 = PdfFontFactory.createFont(FontConstants.COURIER);
//            PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ITALIC);
            
            Paragraph parrafo1 = new Paragraph("Notas Ensayo 1").setFont(font1);
            // Cambiamos el tamaño de fuente del parrafo 2 lo hacemos mas pequeño
            parrafo1.setFontSize(12f);
            
            // Creamos unas tablas
            float[] anchos = {300f, 50f};
            Table tabla1 = new Table(anchos);
            Table tabla2 = new Table(anchos);
            Table tabla3 = new Table(anchos);
            
            // Agregamos contenido a las tablas
            tabla1.addCell("Nombre");
            tabla1.addCell("Retraso");
            tabla1.addCell("Marchelo");
            tabla1.addCell("0");
//            tabla1.addCell("\n");
//            tabla1.addCell("\n");
            Paragraph parrafo2 = new Paragraph("");
            // Cambiamos el tamaño de fuente del parrafo 2 lo hacemos mas pequeño
            parrafo2.setFontSize(20f);
            
            tabla2.addCell("Criterios de evaluación");
            tabla2.addCell(" ");
            tabla2.addCell("INTRODUCCIÓN (20%)");
            tabla2.addCell(" ");
            tabla2.addCell("Planteo del problema");
            tabla2.addCell("2");
            tabla2.addCell("Definición de términos relevantes");
            tabla2.addCell("3");
            tabla2.addCell("Presentación de argumento central");
            tabla2.addCell("3");
            tabla2.addCell("DESARROLLO (30%)");
            tabla2.addCell("");
            tabla2.addCell("Estructura y orden en la presentación");
            tabla2.addCell("4");
            tabla2.addCell("Calidad de los análisis");
            tabla2.addCell("4");
            tabla2.addCell("Relación con argumento central");
            tabla2.addCell("4");
            tabla2.addCell("CONCLUSIONES (20%)");
            tabla2.addCell("");
            tabla2.addCell("Relación con el argumento inicial");
            tabla2.addCell("4");
            tabla2.addCell("Aportación personal");
            tabla2.addCell("4");
            tabla2.addCell("Relevancia para la discusión");
            tabla2.addCell("4");
            tabla2.addCell("BIBLIOGRAFÍA  (10%)");
            tabla2.addCell("");
            tabla2.addCell("Bibliografía");
            tabla2.addCell("2");
            tabla2.addCell("Citas en texto");
            tabla2.addCell("2");
            tabla2.addCell("ASPECTOS FORMALES (20%)");
            tabla2.addCell("");
            tabla2.addCell("Ortografía");
            tabla2.addCell("5");
            tabla2.addCell("Extensión");
            tabla2.addCell("4");
            tabla2.addCell("Puntaje");
            tabla2.addCell("");
            tabla2.addCell("Nota Parcial");
            tabla2.addCell("");
            tabla2.addCell("Descuento por retraso");
            tabla2.addCell("");
            tabla2.addCell("Nota Ensayo");
            tabla2.addCell("");
            
//            tabla3.addCell("Ejemplo con");
//            tabla3.addCell("Con tamaño");
            Paragraph parrafo3 = new Paragraph("Comentario:");
            // Cambiamos el tamaño de fuente del parrafo 2 lo hacemos mas pequeño
            parrafo3.setFontSize(12f);
            
            
            // Cambiamos el tamaño de fuente de la tabla 1, lo hacemos mas pequeño
//            tabla2.setFontSize(20f);
//            // Cambiamos el tamaño de fiente de la tabla 2, lo hacemos mas grande
//            tabla3.setFontSize(20f);
            
            doc.add(parrafo1);
            
            doc.add(tabla1);
            doc.add(parrafo2);
            doc.add(tabla2);
            doc.add(parrafo3);
//            doc.add(tabla3);
            
            doc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(PruebaExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
