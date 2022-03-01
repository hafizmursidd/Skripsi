/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.BreakClear;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyles;

import java.math.BigInteger;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;
//import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
//import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation.Enum;

public class SimpleDocument {

    public static void main(String[] args) throws Exception {
        String pathGambar = "D:\\qrcode\\admin.png";

        FileInputStream in = new FileInputStream("D:\\12\\12.docx");

        XWPFDocument doc = new XWPFDocument(in);
        XWPFDocument newDoc = new XWPFDocument();

        // Copy styles from old to new doc
        XWPFStyles newStyles = newDoc.createStyles();
        newStyles.setStyles(doc.getStyle());

        List<XWPFParagraph> paragraphs = doc.getParagraphs();

        for (int p = 0; p < paragraphs.size(); p++) {
            XWPFParagraph oldPar = paragraphs.get(p);
            XWPFParagraph newPar = newDoc.createParagraph();

            // Apply paragraph style
            newPar.setStyle(oldPar.getStyle());
            XWPFRun run = newPar.createRun();
            run.setText(oldPar.getText());

//            run.setFontSize(12);
//            run.setFontFamily("Times New Roman");
        }
        XWPFParagraph newPar = newDoc.createParagraph();
        newPar.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = newPar.createRun();
        String imgFile = pathGambar;
        FileInputStream is = new FileInputStream(imgFile);

        run.addBreak();

        run.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(200), Units.toEMU(200)); // 200x200 pixels
        is.close();

        FileOutputStream outNewDoc = new FileOutputStream("D:\\qrcode\\baru123.docx");
        newDoc.write(outNewDoc);
        in.close();
        outNewDoc.close();
    }
//        try (XWPFDocument doc = new XWPFDocument()) {
//
//            XWPFParagraph p1 = doc.createParagraph();
//            p1.setAlignment(ParagraphAlignment.CENTER);
//            p1.setBorderBottom(Borders.DOUBLE);
//            p1.setBorderTop(Borders.DOUBLE);
//
//            p1.setBorderRight(Borders.DOUBLE);
//            p1.setBorderLeft(Borders.DOUBLE);
//            p1.setBorderBetween(Borders.SINGLE);
//
//            p1.setVerticalAlignment(TextAlignment.TOP);
//
//            XWPFRun r1 = p1.createRun();
//            r1.setBold(true);
//            r1.setText("The quick brown fox");
//            r1.setBold(true);
//            r1.setFontFamily("Courier");
//            r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
//            r1.setTextPosition(100);
//
//            XWPFParagraph p2 = doc.createParagraph();
//            p2.setAlignment(ParagraphAlignment.RIGHT);
//
//            //BORDERS
//            p2.setBorderBottom(Borders.DOUBLE);
//            p2.setBorderTop(Borders.DOUBLE);
//            p2.setBorderRight(Borders.DOUBLE);
//            p2.setBorderLeft(Borders.DOUBLE);
//            p2.setBorderBetween(Borders.SINGLE);
//
//            XWPFRun r2 = p2.createRun();
//            r2.setText("jumped over the lazy dog");
//            r2.setStrikeThrough(true);
//            r2.setFontSize(20);
//
//            XWPFRun r3 = p2.createRun();
//            r3.setText("and went away");
//            r3.setStrikeThrough(true);
//            r3.setFontSize(20);
//            r3.setSubscript(VerticalAlign.SUPERSCRIPT);
//
//            // hyperlink
//            XWPFHyperlinkRun hyperlink = p2.insertNewHyperlinkRun(0, "http://poi.apache.org/");
//            hyperlink.setUnderline(UnderlinePatterns.SINGLE);
//            hyperlink.setColor("0000ff");
//            hyperlink.setText("Apache POI");
//
//            XWPFParagraph p3 = doc.createParagraph();
//            p3.setWordWrapped(true);
//            p3.setPageBreak(true);
//
//            //p3.setAlignment(ParagraphAlignment.DISTRIBUTE);
//            p3.setAlignment(ParagraphAlignment.BOTH);
//            p3.setSpacingBetween(15, LineSpacingRule.EXACT);
//
//            p3.setIndentationFirstLine(600);
//
//
//            XWPFRun r4 = p3.createRun();
//            r4.setTextPosition(20);
//            r4.setText("To be, or not to be: that is the question: "
//                    + "Whether 'tis nobler in the mind to suffer "
//                    + "The slings and arrows of outrageous fortune, "
//                    + "Or to take arms against a sea of troubles, "
//                    + "And by opposing end them? To die: to sleep; ");
//            r4.addBreak(BreakType.PAGE);
//            r4.setText("No more; and by a sleep to say we end "
//                    + "The heart-ache and the thousand natural shocks "
//                    + "That flesh is heir to, 'tis a consummation "
//                    + "Devoutly to be wish'd. To die, to sleep; "
//                    + "To sleep: perchance to dream: ay, there's the rub; "
//                    + ".......");
//            r4.setItalic(true);
//
//            try (FileOutputStream out = new FileOutputStream("D:\\\\12\\\\output2Oktter11.docx")) {
//                doc.write(out);
//            }
//        }
//    }

}
