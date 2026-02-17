/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfitext7;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author march
 */
public class Ejemplo4 {
    
//    public static final String DATA="./src/BD/bd_simple.txt";
    public static final String DATA="./src/BD/base_datos.txt";
    
    public void crearPDFTablas(String dest) throws IOException{
        PdfWriter writer = new PdfWriter(dest+"PruebaIText7Ejemplo4.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        //Arriba,Abajo,derecha,izqueda
        document.setMargins(20, 20, 20, 20);
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        
//        Table table = new Table(new float[]{2,4,4});
        Table table = new Table(new float[]{4,1,3,4,3,3,3,3,1});
        table.setWidth(100);
        
        BufferedReader br = new BufferedReader(new FileReader(DATA));
        String line =br.readLine();
        process(table, line, bold, true);
        
        while ((line=br.readLine())!=null) {
            process(table, line, font, false);
            
        }
        
        br.close();
        document.add(table);
        document.close();
    }
    
    public void process(Table table,String line,PdfFont font,boolean isHeader){
//        StringTokenizer tokenizer = new StringTokenizer(line, ",");
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        while (tokenizer.hasMoreTokens()) {            
            if(isHeader){
                table.addHeaderCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
            }else{
                table.addCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
            }
        }
    }
}
