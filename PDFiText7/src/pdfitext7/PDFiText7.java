/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfitext7;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import java.io.IOException;

/**
 *
 * @author march
 */
public class PDFiText7 {

    public static final String DEST="";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        new FontSizeExample().crearPDFAll(DEST);
        new Ejemplo1().crearPDFNormal(DEST);
        new Ejemplo2().crearPDFLista(DEST);
        new Ejemplo3().crearPDFImg(DEST);
        new Ejemplo4().crearPDFTablas(DEST);
        new Ejemplo5().crearTablaConAtura(DEST);
        new PruebaExcel().CrearTablaPDF(DEST);
    }
}
