/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package word;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Felipe
 */
public class Word {

  
    // clase para eclipse 
    public static void main(String[] args) {
         
      
        // TODO code application logic here
        
        XWPFDocument lol = new XWPFDocument();
        
        XWPFParagraph paragraph =  lol.createParagraph();
        XWPFRun run = paragraph.createRun();
        
       run.setText("Prueba de World");
        
        run.setFontSize(25);
        run.setFontFamily("Helvetica");
        // es para dibujar y tipo de linea en debajo de titulo
        run.setUnderline(UnderlinePatterns.THICK);
        run.setBold(true);
        run.setItalic(true);
        //se trabaja con el color hexadecimal
        run.setColor("DF0101");

        paragraph.setAlignment(ParagraphAlignment.CENTER);
    
        // declaramos otra para el parrafo
        XWPFParagraph paragraph2 =  lol.createParagraph();
        XWPFRun runs = paragraph2.createRun();
        runs.addBreak();
        runs.setFontSize(15);
        runs.setFontFamily("Arial");
        runs.setText("Texto de prueba para el world");
        
        // alinear de parrafo
        paragraph2.setAlignment(ParagraphAlignment.LEFT);
    
        
        
        try{
            FileOutputStream output = new FileOutputStream("prueba.docx");
            lol.write(output);
            output.close();
                JOptionPane.showMessageDialog(null,"WORD EXPORTADOS CON EXITOS!");
        }catch(Exception e){
            e.printStackTrace();
        }
      
       }
    
    // metodo para netbeasn llamada de valor
     public void prola(String titulo,String parrafo,String ubicacion) {
        // TODO code application logic here
        
        XWPFDocument lol = new XWPFDocument();
        
        XWPFParagraph paragraph =  lol.createParagraph();
        XWPFRun run = paragraph.createRun();
        
       run.setText(titulo);
        
        run.setFontSize(25);
        run.setFontFamily("Helvetica");
        // es para dibujar y tipo de linea en debajo de titulo
        run.setUnderline(UnderlinePatterns.THICK);
        run.setBold(true);
        run.setItalic(true);
        //se trabaja con el color hexadecimal
        run.setColor("DF0101");

        paragraph.setAlignment(ParagraphAlignment.CENTER);
    
        // declaramos otra para el parrafo
        XWPFParagraph paragraph2 =  lol.createParagraph();
        XWPFRun runs = paragraph2.createRun();
        runs.addBreak();
        runs.setFontSize(15);
        runs.setFontFamily("Arial");
        runs.setText(parrafo);
        
        // alinear de parrafo
        paragraph2.setAlignment(ParagraphAlignment.LEFT);
 
        try{
            FileOutputStream output = new FileOutputStream(ubicacion+".docx");
            lol.write(output);
            output.close();
                JOptionPane.showMessageDialog(null,"WORD EXPORTADOS CON EXITOS!");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
