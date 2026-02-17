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
public class Ejemplo1 {
    
    public void crearPDFNormal(String dest) throws IOException{
        PdfWriter writer = new PdfWriter(dest+"PruebaIText7Ejemplo1.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph("Helo world!"));
        document.close();
    }
}
