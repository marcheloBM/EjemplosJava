/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfitext7;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import java.io.IOException;

/**
 *
 * @author march
 */
public class Ejemplo3 {
    public static final String DOG="./src/IMG/dog.png";
    public static final String FOX="./src/IMG/fox.png";
    
    public void crearPDFImg(String dest) throws IOException{
        PdfWriter writer = new PdfWriter(dest+"PruebaIText7Ejemplo3.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        Image dog = new Image(ImageDataFactory.create(DOG));
        Image fox = new Image(ImageDataFactory.create(FOX));
        Paragraph p = new Paragraph("El marron rapido")
                .add(fox).add("salta sobre el perezoso").add(dog);
        document.add(p);
        document.close();
    }
}
