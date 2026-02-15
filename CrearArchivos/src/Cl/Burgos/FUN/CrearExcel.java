/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.FUN;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


/**
 *
 * @author march
 */
public class CrearExcel {
    private Workbook libro=new HSSFWorkbook();
    static String SO = System.getProperty("os.name");
    public void Crear(){
        javax.swing.filechooser.FileNameExtensionFilter filtroWord=new FileNameExtensionFilter("Microsoft Excel 2016", "xls");
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
            if(nombre.indexOf('.')==-1){
                nombre+=".xls";
                fileWord=new File(fileWord.getParentFile(), nombre);
            }else{
                nombre+=".xls";
                fileWord=new File(fileWord.getParentFile(), nombre);
            }
            try {
                FileOutputStream output = new FileOutputStream(fileWord);
                //Creamos un nuevo libro
                
                //Creamos una nueva hoja
//                Sheet hoja = libro.createSheet("Hoja1");

//                //Creamos una Fila
//                Row fila = hoja.createRow(0);
//                //Creamos una celda
//                Cell celda = fila.createCell(0);
//                //Añadimos el texto
//                celda.setCellValue("Hola mundo");
                
//                for(int i=0;i<10;i++){
////                    for (int j = 0; j < 10; j++) {
//                        Row fila = hoja.createRow(i);
//                        //Creamos una celda
//                        Cell celda = fila.createCell(1);
//                        //Añadimos el texto
//                        celda.setCellValue("Hola");
////                    }
//                }

                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet();
                workbook.setSheetName(0, "Hoja excel");

                String[] headers = new String[]{
                    "Producto",
                    "Precio",
                    "Enlace"
                };

                Object[][] data = new Object[][] {
                    new Object[] { "PlayStation 4 (PS4) - Consola 500GB", new BigDecimal("340.95"), "https://www.amazon.es/PlayStation-4-PS4-Consola-500GB/dp/B013U9CW8A/ref=sr_1_1?ie=UTF8&qid=1464521925&sr=8-1&keywords=playstation" },
                    new Object[] { "Raspberry Pi 3 Modelo B (1,2 GHz Quad-core ARM Cortex-A53, 1GB RAM, USB 2.0)", new BigDecimal("41.95"), "https://www.amazon.es/Raspberry-Modelo-GHz-Quad-core-Cortex-A53/dp/B01CD5VC92/ref=sr_1_1?ie=UTF8&qid=1464521956&sr=8-1&keywords=raspberry+pi" },
                    new Object[] { "Gigabyte Brix - Barebón (Intel, Core i5, 2,6 GHz, 6, 35 cm (2.5\"), Serial ATA III, SO-DIMM) Negro ", new BigDecimal("421.36"), "https://www.amazon.es/Gigabyte-Brix-Bareb%C3%B3n-Serial-SO-DIMM/dp/B00HFCTUPM/ref=sr_1_5?ie=UTF8&qid=1464522011&sr=8-5&keywords=brix" }
                };

                CellStyle headerStyle = workbook.createCellStyle();
                Font font = workbook.createFont();
//                font.setBoldweight(Font.BOLDWEIGHT_BOLD);
                headerStyle.setFont(font);
        //
                CellStyle style = workbook.createCellStyle();
                style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        //        style.setFillPattern(CellStyle.SOLID_FOREGROUND);

                HSSFRow headerRow = sheet.createRow(0);
                for (int i = 0; i < headers.length; ++i) {
                    String header = headers[i];
                    HSSFCell cell = headerRow.createCell(i);
                    cell.setCellStyle(headerStyle);
                    cell.setCellValue(header);
                }

                for (int i = 0; i < data.length; ++i) {
                    HSSFRow dataRow = sheet.createRow(i + 1);

                    Object[] d = data[i];
                    String product = (String) d[0];
                    BigDecimal price = (BigDecimal) d[1];
                    String link = (String) d[2];

                    dataRow.createCell(0).setCellValue(product);
                    dataRow.createCell(1).setCellValue(price.doubleValue());
                    dataRow.createCell(2).setCellValue(link);
                }

//                HSSFRow dataRow = sheet.createRow(1 + data.length);
//                HSSFCell total = dataRow.createCell(1);
//                total.setCellType(Cell.CELL_TYPE_FORMULA);
//                total.setCellStyle(style);
//                total.setCellFormula(String.format("SUM(B2:B%d)", 1 + data.length));

        //        FileOutputStream file = new FileOutputStream("workbook.xls");
                workbook.write(output);
                output.close();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
            finally{
                try {
                    if(System.getProperty("os.name").equals("Linux")){
//                        Runtime.getRuntime().exec("libreoffice"+fileWord.getAbsolutePath());
                        File objetofile = new File (fileWord.getAbsolutePath());
                        Desktop.getDesktop().open(objetofile);
                    }
                    else{
//                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+fileWord.getAbsolutePath());
                        File objetofile = new File (fileWord.getAbsolutePath());
                        Desktop.getDesktop().open(objetofile);
                    }
                }
                catch (IOException ex) {
                    Logger.getLogger(CrearExcel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
