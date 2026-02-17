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
public class Ejemplo2 {
    public void crearPDFLista(String dest) throws IOException{
        PdfWriter writer = new PdfWriter(dest+"PruebaIText7Ejemplo2.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        
        //Damistrar Funtes de text
        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ITALIC);
        document.add(new Paragraph("Lista Pruebas").setFont(font));
        List list=new List().setSymbolIndent(12).setListSymbol("\u2022").setFont(font);
        list.add(new ListItem("Prueba 1"))
                .add(new ListItem("Prueba 2"))
                .add(new ListItem("Prueba 3"))
                .add(new ListItem("Prueba 4"))
                .add(new ListItem("Prueba 5"));
        document.add(list);
        document.close();
    }
}
