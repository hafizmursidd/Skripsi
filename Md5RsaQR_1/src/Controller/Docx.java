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
import java.math.BigInteger;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTStyleImpl;

public class Docx {

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

            XWPFStyles newStyles = newDocx.createStyles();
            newStyles.setStyles(docx.getStyle());
            double fontSize = docx.getStyles().getDefaultRunStyle().getFontSizeAsDouble();
           // System.out.println("font size : " + fontSize);

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
            run.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(200), Units.toEMU(200)); // 200x200 pixels

            FileOutputStream fos = new FileOutputStream(pathFinalOutput);
            newDocx.write(fos);
            is.close();
            in.close();
            fos.close();

        } catch (Exception e) {
            System.out.println("Gagal Menuliskan Text Word  : " + e);
        }

    }
//}


/*
    public static void main(String args[]) {

        String abc = "D:\\1111tesssss\\4.docx";
        writeText(abc, abc, abc);
    }
*/

}
