/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel4.pkg1;

import java.io.File;
import java.io.FileOutputStream;
 
//import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author march
 */
public class CrearExcel {
    
    public void Crear(){
        String fileName = "Productos.xlsx";
        String filePath = fileName;
        //Seteando el nombre de la hoja donde agregaremos los items
        String hoja = "Hoja1"; 
         
        //Creando objeto libro de Excel
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet hoja1 = book.createSheet(hoja);
         
        //Cabecera de la hoja de excel
        String[] header = new String[]{"Código", "Producto", "Descripción"};
 
        //Contenido de la hoja de excel
        String[][] document = new String[][]{
            {"C001", "Computador Laptop HP.", "Compurtador marca HP color negro."},
            {"C002", "Computador Escritorio Lenovo.", "Compurtador marca lenovo color negro con monitor integrado."},
            {"C003", "Impresora HP.", "Impresora marca HP, multifuncional color negro."},
            {"C004", "Mouse Inalambrico Logitec.", "Mouse Inalambrico color azul con negro."},
            {"C005", "Teclado Inalambrico Lenovo.", "Teclado Inalambrico color blanco."}
        };
 
        //Aplicando estilo color negrita a los encabezados
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
        font.setBold(true);//Seteando fuente negrita al encabezado del archivo excel
        style.setFont(font);
 
        //Generando el contenido del archivo de Excel
        for (int i = 0; i <= document.length; i++) {
            XSSFRow row = hoja1.createRow(i);//se crea las filas
            for (int j = 0; j < header.length; j++) {
                if (i == 0) {//Recorriendo cabecera
                    XSSFCell cell = row.createCell(j);//Creando la celda de la cabecera en conjunto con la posición
                    cell.setCellStyle(style); //Añadiendo estilo a la celda creada anteriormente
                    cell.setCellValue(header[j]);//Añadiendo el contenido de nuestra lista de productos
                } else {//para el contenido
                    XSSFCell cell = row.createCell(j);//Creando celda para el contenido del producto
                    cell.setCellValue(document[i - 1][j]); //Añadiendo el contenido
                }
            }
        }
 
        File excelFile;
        excelFile = new File(filePath); // Referenciando a la ruta y el archivo Excel a crear
        try (FileOutputStream fileOuS = new FileOutputStream(excelFile)) {
            if (excelFile.exists()) { // Si el archivo existe lo eliminaremos
                excelFile.delete();
                System.out.println("Archivo eliminado.!");
            }
            book.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            System.out.println("Archivo Creado.!");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
    
    public void Crear2(){
        // Creamos el archivo donde almacenaremos la hoja
        // de calculo, recuerde usar la extension correcta,
        // en este caso .xlsx
        File archivo = new File("reporte.xlsx");

        // Creamos el libro de trabajo de Excel formato OOXML
        Workbook workbook = new XSSFWorkbook();

        // La hoja donde pondremos los datos
        Sheet pagina = workbook.createSheet("Reporte de productos");

        // Creamos el estilo paga las celdas del encabezado
        CellStyle style = workbook.createCellStyle();
        // Indicamos que tendra un fondo azul aqua
        // con patron solido del color indicado
        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        String[] titulos = {"Identificador", "Consumos",
            "Precio Venta", "Precio Compra"};
        Double[] datos = {1.0, 10.0, 45.5, 25.50};

        // Creamos una fila en la hoja en la posicion 0
        Row fila = pagina.createRow(0);

        // Creamos el encabezado
        for (int i = 0; i < titulos.length; i++) {
            // Creamos una celda en esa fila, en la posicion 
            // indicada por el contador del ciclo
            Cell celda = fila.createCell(i);

            // Indicamos el estilo que deseamos 
            // usar en la celda, en este caso el unico 
            // que hemos creado
            celda.setCellStyle(style);
            celda.setCellValue(titulos[i]);
        }

        // Ahora creamos una fila en la posicion 1
        fila = pagina.createRow(1);

        // Y colocamos los datos en esa fila
        for (int i = 0; i < datos.length; i++) {
            // Creamos una celda en esa fila, en la
            // posicion indicada por el contador del ciclo
            Cell celda = fila.createCell(i);

            celda.setCellValue(datos[i]);
        }

        // Ahora guardaremos el archivo
        try {
            // Creamos el flujo de salida de datos,
            // apuntando al archivo donde queremos 
            // almacenar el libro de Excel
            FileOutputStream salida = new FileOutputStream(archivo);

            // Almacenamos el libro de 
            // Excel via ese 
            // flujo de datos
            workbook.write(salida);

            // Cerramos el libro para concluir operaciones
            workbook.close();

            System.out.println("Archivo creado existosamente en {0}"+archivo.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no localizable en sistema de archivos");
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        }
    }
    
}
