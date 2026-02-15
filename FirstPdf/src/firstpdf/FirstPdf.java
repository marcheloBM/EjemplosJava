/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstpdf;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class FirstPdf {
        private static String FILE = "FirstPdf.pdf";
        private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
        private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL, BaseColor.RED);
        private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);
        private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);

        public static void main(String[] args) {
                try {
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(FILE));
                        document.open();
                        addMetaData(document);
                        addTitlePage(document);
                        addContent(document);
                        document.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        // iText permite agregar metadatos al PDF que se puede ver en su Adobe
        // Reader
        // bajo Archivo -> Propiedades
        private static void addMetaData(Document document) {
                document.addTitle("Mi primer PDF");
                document.addSubject("Uso de iText");
                document.addKeywords("Java, PDF, iText");
                document.addAuthor("Lars Vogel");
                document.addCreator("Lars Vogel");
        }

        private static void addTitlePage(Document document)throws DocumentException {
                Paragraph preface = new Paragraph();
                // Añadimos una línea vacía
                addEmptyLine(preface, 1);
                // Permite escribir un encabezado grande
                preface.add(new Paragraph("Título del documento", catFont));

                addEmptyLine(preface, 1);
                // Creará: Informe generado por: _name, _date
                preface.add(new Paragraph(
                                "Informe generado por: " + System.getProperty("Nombre de usuario") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                                smallBold));
                addEmptyLine(preface, 3);
                preface.add(new Paragraph(
                                "Este documento describe algo que es muy importante ",
                                smallBold));

                addEmptyLine(preface, 8);

                preface.add(new Paragraph(
                                "Este documento es una versión preliminar y no está sujeto a su contrato de licencia o cualquier otro acuerdo con vogella.com ;-).",
                                redFont));

                document.add(preface);
                // Iniciar una nueva página
                document.newPage();
        }

        private static void addContent(Document document) throws DocumentException {
                Anchor anchor = new Anchor("Primer Capítulo", catFont);
                anchor.setName("Primer Capítulo");

                // El segundo parámetro es el número del capítulo
                Chapter catPart = new Chapter(new Paragraph(anchor), 1);

                Paragraph subPara = new Paragraph("Subcategoría 1", subFont);
                Section subCatPart = catPart.addSection(subPara);
                subCatPart.add(new Paragraph("Hola"));

                subPara = new Paragraph("Subcategoría 2", subFont);
                subCatPart = catPart.addSection(subPara);
                subCatPart.add(new Paragraph("Párrafo 1"));
                subCatPart.add(new Paragraph("Párrafo 2"));
                subCatPart.add(new Paragraph("Párrafo 3"));

                // añadir una lista
                createList(subCatPart);
                Paragraph paragraph = new Paragraph();
                addEmptyLine(paragraph, 5);
                subCatPart.add(paragraph);

                // Agregue una tabla
                createTable(subCatPart);

                // Ahora agregue todo esto al documento
                document.add(catPart);

                // Siguiente sección
                anchor = new Anchor("Segundo capítulo", catFont);
                anchor.setName("Segundo capítulo");

                // El segundo parámetro es el número del capítulo
                catPart = new Chapter(new Paragraph(anchor), 1);

                subPara = new Paragraph("Subcategoría", subFont);
                subCatPart = catPart.addSection(subPara);
                subCatPart.add(new Paragraph("Este es un mensaje muy importante"));

                // Ahora agregue todo esto al documento
                document.add(catPart);

        }

        private static void createTable(Section subCatPart)
                        throws BadElementException {
                PdfPTable table = new PdfPTable(3);

                // t.setBorderColor(BaseColor.GRAY);
                // t.setPadding(4);
                // t.setSpacing(4);
                // t.setBorderWidth(1);

                PdfPCell c1 = new PdfPCell(new Phrase("Encabezado de tabla 1"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Encabezado de tabla 2"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Encabezado de tabla 3"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                table.setHeaderRows(1);

                table.addCell("1.0");
                table.addCell("1.1");
                table.addCell("1.2");
                table.addCell("2.1");
                table.addCell("2.2");
                table.addCell("2.3");

                subCatPart.add(table);

        }

        private static void createList(Section subCatPart) {
                List list = new List(true, false, 10);
                list.add(new ListItem("Primer punto"));
                list.add(new ListItem("Segundo punto"));
                list.add(new ListItem("Tercer punto"));
                subCatPart.add(list);
        }

        private static void addEmptyLine(Paragraph paragraph, int number) {
                for (int i = 0; i < number; i++) {
                        paragraph.add(new Paragraph(" "));
                }
        }
}
