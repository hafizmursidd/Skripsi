package Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;

public class Docx1 {

    public static String readText(String letakFile) {
        String valueText = "";

        try (FileInputStream fis = new FileInputStream(letakFile)) {
            XWPFDocument file = new XWPFDocument(OPCPackage.open(fis));
            XWPFWordExtractor ext = new XWPFWordExtractor(file);

            valueText = (ext.getText().trim());
        } catch (Exception e) {
            System.out.println(e);
        }
        return valueText;
    }

    public static void writeText(String pathGambar, String pathInput, String pathOutput) {
        try {

            String pathGambarFinal = pathGambar;
            String pathFinalInput = pathInput;
            String pathFinalOutput = pathOutput;

            FileInputStream in = new FileInputStream(pathFinalInput);
            XWPFDocument docx = new XWPFDocument(in);
            XWPFDocument newDocx = new XWPFDocument();

            // Copy styles from old to new docx
            XWPFStyles newStyles = newDocx.createStyles();
            newStyles.setStyles(docx.getStyle());
            double fontSize = docx.getStyles().getDefaultRunStyle().getFontSizeAsDouble();

            List<XWPFParagraph> paragraphs = docx.getParagraphs();
            int p;
            for (p = 0; p < paragraphs.size(); p++) {
                XWPFParagraph oldPar = paragraphs.get(p);
                XWPFParagraph newPar = newDocx.createParagraph();
                // Apply paragraph style

                newPar.setStyle(oldPar.getStyle());
                XWPFRun run = newPar.createRun();
                run.setFontSize(fontSize);
                run.setText(oldPar.getText());
            }
            XWPFParagraph newPar = newDocx.createParagraph();
            newPar.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run = newPar.createRun();
            String imgFile = pathGambarFinal;

            FileInputStream is = new FileInputStream(imgFile);

            run.addBreak();

            run.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(400), Units.toEMU(400)); // 200x200 pixels

            FileOutputStream fos = new FileOutputStream(pathFinalOutput);
            newDocx.write(fos);
            is.close();
            in.close();
            fos.close();    

        } catch (Exception e) {
            System.out.println("Gagal Menuliskan Text Word  : " + e);
        }

    }

    public static void writeTexttt(String pathGambar, String pathInput, String pathOutput) { //mencoba ambilk style dan huruf
        try {

            String pathGambarFinal = pathGambar;
            String pathFinalInput = pathInput;
            String pathFinalOutput = pathOutput;

            FileInputStream in = new FileInputStream(pathInput);
            XWPFDocument docx = new XWPFDocument(in);
            XWPFDocument newDocx = new XWPFDocument();

            double xx = docx.getStyles().getDefaultRunStyle().getFontSizeAsDouble();
            XWPFStyles newStyles = newDocx.createStyles();

            //newStyles.setStyles(docx.getStyle());
            List<XWPFParagraph> paragraphs = docx.getParagraphs();
            int p;
            for (p = 0; p < paragraphs.size(); p++) {
                XWPFParagraph oldPar = paragraphs.get(p);
                newStyles.setStyles(docx.getStyle());
                docx.getStyles().getStyle(oldPar.getStyleID());
                oldPar.getStyleID();
                XWPFParagraph newPar = newDocx.createParagraph();
                // Apply paragraph style   
                newPar.setStyle(oldPar.getStyleID());
                XWPFRun run = newPar.createRun();
                //run.setFontSize(xx);
                run.setText(oldPar.getText());
                //run.setFontFamily("Times New Roman");
            }
            System.out.println("ukuran huruf : " + xx);

            XWPFParagraph newPar = newDocx.createParagraph();
            newPar.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run = newPar.createRun();
            String imgFile = pathGambar;

            FileInputStream is = new FileInputStream(imgFile);
            run.addBreak();
            run.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(200), Units.toEMU(200)); // 200x200 pixels

            FileOutputStream fos = new FileOutputStream(pathFinalOutput);
            newDocx.write(fos);
            is.close();
            in.close();
            fos.close();

        } catch (Exception e) {
            System.out.println("error : " + e);
        }

    }
}
