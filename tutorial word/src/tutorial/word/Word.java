/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.word;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Israel-ICM
 */
public class Word {
    private XWPFDocument document=new XWPFDocument();
    public void crear(){
        javax.swing.filechooser.FileNameExtensionFilter filtroWord=new FileNameExtensionFilter("Microsoft Word 2013", "docx");
        final JFileChooser miArchivo=new JFileChooser();
        miArchivo.setFileFilter(filtroWord);
        int aceptar=miArchivo.showSaveDialog(null);
        miArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(aceptar==JFileChooser.APPROVE_OPTION){
            File fileWord=miArchivo.getSelectedFile();
            String nombre=fileWord.getName();
            if(nombre.indexOf('.')==-1){
                nombre+=".docx";
                fileWord=new File(fileWord.getParentFile(), nombre);
            }
            try {
                FileOutputStream output=new FileOutputStream(fileWord);
                //FileOutputStream output=new FileOutputStream("documento de prueba.docx");

                XWPFParagraph paragraphTitulo=document.createParagraph();
                XWPFRun runTitulo=paragraphTitulo.createRun();

                paragraphTitulo.setAlignment(ParagraphAlignment.CENTER);
                runTitulo.setBold(true);
                runTitulo.setFontSize(15);
                runTitulo.setUnderline(UnderlinePatterns.WORDS);
                runTitulo.setText("Este es el titulo");
                runTitulo.setColor("2f66f2");
                runTitulo.addBreak();

                XWPFParagraph paragraph=document.createParagraph();
                XWPFRun run=paragraph.createRun();
                run.setText("Este es el parrafo njrkev rnvjre nvjrkv nrjvk trnjktr nvbjrtk njrtk bntjrk ntrjkb ntrjk tnrjkg tnrjkt");
                run.setText(" 2da linea Este es el parrafo njrkev rnvjre nvjrkv nrjvk trnjktr nvbjrtk njrtk bntjrk ntrjkb ntrjk tnrjkg tnrjkt");
                run.setText(" 3ra linea Este es el parrafo njrkev rnvjre nvjrkv nrjvk trnjktr nvbjrtk njrtk bntjrk ntrjkb ntrjk tnrjkg tnrjkt");
                run.addBreak();
                run.setText(" 4ta linea Este es el parrafo njrkev rnvjre nvjrkv nrjvk trnjktr nvbjrtk njrtk bntjrk ntrjkb ntrjk tnrjkg tnrjkt");
                run.addBreak();

                for(int i=0;i<10;i++){
                    XWPFParagraph paragraphLista=document.createParagraph();
                    XWPFRun runLista=paragraphLista.createRun();
                    runLista.setText("Item "+i);
                    paragraphLista.setNumID(BigInteger.ONE);
                }

                document.write(output);
                output.close();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage().toString());
            }
            
            finally{
                try {
                    if(System.getProperty("os.name").equals("Linux")){
                        Runtime.getRuntime().exec("libreoffice"+fileWord.getAbsolutePath());
                    }
                    else{
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+fileWord.getAbsolutePath());
                    }
                }
                catch (IOException ex) {
                    Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
