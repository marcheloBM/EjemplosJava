/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

/**
 *
 * @author march
 */
public class JavaApplication17 {

    public JavaApplication17() throws Exception {

    System.out.println("This is Word To Document Class");

           File file = null; 
           FileOutputStream fos = null; 
           XWPFDocument document = null; 
           XWPFParagraph para = null; 
           XWPFRun run = null; 
           try { 
               // Crear el primer párrafo y establecer su texto. 
               document = new XWPFDocument(); 
               para = document.createParagraph(); 

               para.setAlignment(ParagraphAlignment.CENTER); 

               para.setSpacingAfter(100); 

               para.setSpacingAfterLines(10);
               run = para.createRun(); 
               for(int i=1; i<=5; i++)
               run.setText("Test Name Marchelo Value 12345678 Normal Ranges09384"); 
               run.addBreak();    // similar a la nueva línea
//               run.addBreak();

               XWPFTable table = document.createTable(4, 3);

               table.setRowBandSize(1);
               table.setWidth(1);
               table.setColBandSize(1);
               table.setCellMargins(1, 1, 100, 30);

               table.setStyleID("finest");


               table.getRow(1).getCell(1).setText("EXAMPLE OF TABLE");
               table.getRow(2).getCell(1).setText("fine");
               XWPFParagraph p1 = table.getRow(0).getCell(0).getParagraphs().get(0);
               p1.setAlignment(ParagraphAlignment.CENTER);
                       XWPFRun r1 = p1.createRun();
                       r1.setBold(true);
                       r1.setText("Test Name");
                       r1.setItalic(true);
                       r1.setFontFamily("Courier");
                       r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
                       r1.setTextPosition(100);

              //Locating the cell values
                        table.getRow(0).getCell(1).setText("Value"); 
                        table.getRow(0).getCell(2).setText("Normal Ranges"); 

                       table.getRow(2).getCell(2).setText("numeric values");

                        table.setWidth(120);

               file = new File("nwhpe.docx"); 
               if(file.exists())
                   file.delete();


               FileOutputStream out = new FileOutputStream(file);
               document.write(out);
               out.close();
           } catch (Exception e){
               System.out.println("Erro"+e.getMessage());
           }

       } 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        new JavaApplication17();
    }
    
}
