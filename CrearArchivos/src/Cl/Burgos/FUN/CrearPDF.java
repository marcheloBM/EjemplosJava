/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.FUN;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author march
 */
public class CrearPDF {
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
    
    private Document doc = new Document();
    static String SO = System.getProperty("os.name");
    public void Crear(){
//        Directorio d = new Directorio();
        javax.swing.filechooser.FileNameExtensionFilter filtroWord=new FileNameExtensionFilter("Adobe Acrobat PDF", "pdf");
        final JFileChooser miArchivo=new JFileChooser();
        miArchivo.setFileFilter(filtroWord);
        miArchivo.setDialogTitle("Guardar archivo");
        miArchivo.setMultiSelectionEnabled(false);
        miArchivo.setAcceptAllFileFilterUsed(false);
        String userDir = System.getProperty("user.home");
        //preferencia de ubicacion
        if(SO.startsWith("Windows")){
            miArchivo.setCurrentDirectory(new File(userDir +"/Desktop"));
        }else{
            miArchivo.setCurrentDirectory(new File(userDir +"/Escritorio"));
        }
        //El nombre del Archivo
        miArchivo.setSelectedFile(new File("Documento"));
        int aceptar=miArchivo.showSaveDialog(null);
        miArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(aceptar==JFileChooser.APPROVE_OPTION){
            File fileWord=miArchivo.getSelectedFile();
            String nombre=fileWord.getName();
        try {    if(nombre.indexOf('.')==-1){
                nombre+=".pdf";
                PdfWriter.getInstance(doc, new FileOutputStream(fileWord.getParentFile()+"/"+nombre));
            }
            doc.open();
            Paragraph preface = new Paragraph();
                // Añadimos una línea vacía
                addEmptyLine(preface, 1);
                // Permite escribir un encabezado grande
                preface.add(new Paragraph("Título del documento", catFont));
                addEmptyLine(preface, 1);
                
                // Creará: Informe generado por: _name, _date
                preface.add(new Paragraph("Informe generado por: Nombre de usuario " +"Prueba"+ ", " + new Date(),smallBold));
                addEmptyLine(preface, 1);
                
                preface.add(new Paragraph("Este documento describe algo que es muy importante ",smallBold));
                addEmptyLine(preface, 1);

                preface.add(new Paragraph("Este documento es una versión preliminar y no está sujeto a su contrato de licencia o cualquier otro acuerdo.",redFont));
            addEmptyLine(preface, 1);
            doc.add(preface);
            
            doc.close();
            
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null,"Hubo un error"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(CrearPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
                try {
                    if(System.getProperty("os.name").equals("Linux")){
//                        Runtime.getRuntime().exec("libreoffice"+fileWord.getAbsolutePath());
                        File objetofile = new File (fileWord.getAbsolutePath()+".pdf");
                        Desktop.getDesktop().open(objetofile);
                    }
                    else{
//                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+fileWord.getAbsolutePath());
                        File objetofile = new File (fileWord.getAbsolutePath()+".pdf");
                        Desktop.getDesktop().open(objetofile);
                    }
                }
                catch (IOException ex) {
                    Logger.getLogger(CrearPDF.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

    }
    }
    
    private static void addEmptyLine(Paragraph paragraph, int number) {
                for (int i = 0; i < number; i++) {
                        paragraph.add(new Paragraph(" "));
                }
        }
    public void ImprimirPDF(JTable table,String nombreUs){
        javax.swing.filechooser.FileNameExtensionFilter filtroWord=new FileNameExtensionFilter("Adobe Acrobat PDF", "pdf");
        final JFileChooser miArchivo=new JFileChooser();
        miArchivo.setFileFilter(filtroWord);
        miArchivo.setDialogTitle("Guardar archivo");
        miArchivo.setMultiSelectionEnabled(false);
        miArchivo.setAcceptAllFileFilterUsed(false);
        String userDir = System.getProperty("user.home");
        //preferencia de ubicacion
        if(SO.startsWith("Windows")){
            miArchivo.setCurrentDirectory(new File(userDir +"/Desktop"));
        }else{
            miArchivo.setCurrentDirectory(new File(userDir +"/Escritorio"));
        }
        //El nombre del Archivo
        miArchivo.setSelectedFile(new File("Documento"));
        int aceptar=miArchivo.showSaveDialog(null);
        miArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(aceptar==JFileChooser.APPROVE_OPTION){
            File fileWord=miArchivo.getSelectedFile();
            String nombre=fileWord.getName();
        try {    if(nombre.indexOf('.')==-1){
                nombre+=".pdf";
                PdfWriter.getInstance(doc, new FileOutputStream(fileWord.getParentFile()+"/"+nombre));
            }
            doc.open();
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            //Agregando encabezados de tabla
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(table.getColumnName(i));
            }
            //Extraer datos de la JTable e insertarlo en PdfPTable
            for (int rows = 0; rows < table.getRowCount() - 1; rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());

                }
            }
            Paragraph preface = new Paragraph();
                // Añadimos una línea vacía
                addEmptyLine(preface, 1);
                // Permite escribir un encabezado grande
                preface.add(new Paragraph("Título del documento", catFont));
                addEmptyLine(preface, 1);
                
                // Creará: Informe generado por: _name, _date
                preface.add(new Paragraph("Informe generado por: Nombre de usuario " +nombreUs + ", " + new Date(),smallBold));
                addEmptyLine(preface, 1);
                
                preface.add(new Paragraph("Este documento describe algo que es muy importante ",smallBold));
                addEmptyLine(preface, 1);

                preface.add(new Paragraph("Este documento es una versión preliminar y no está sujeto a su contrato de licencia o cualquier otro acuerdo.",redFont));
            addEmptyLine(preface, 1);
            doc.add(preface);
            
            doc.add(pdfTable);
            doc.close();
//            System.out.println("done");
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null,"Hubo un error"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
//            Log.log(ex.getMessage());
           
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hubo un error"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
//            Log.log(ex.getMessage());
        }finally{
                try {
                    if(System.getProperty("os.name").equals("Linux")){
//                        Runtime.getRuntime().exec("libreoffice"+fileWord.getAbsolutePath());
                        File objetofile = new File (fileWord.getAbsolutePath()+".pdf");
                        Desktop.getDesktop().open(objetofile);
                    }
                    else{
//                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+fileWord.getAbsolutePath());
                        File objetofile = new File (fileWord.getAbsolutePath()+".pdf");
                        Desktop.getDesktop().open(objetofile);
                    }
                }
                catch (IOException ex) {
                    Logger.getLogger(CrearPDF.class.getName()).log(Level.SEVERE, null, ex);
//                    Log.log(ex.getMessage());
                }
            }

    }
    }
}
