/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFStyles;

public class CopyWord {

    private static void copyStyle(XWPFDocument srcDoc, XWPFDocument destDoc, XWPFStyle style) {
        if (destDoc == null || style == null) {
            return;
        }

        if (destDoc.getStyles() == null) {
            destDoc.createStyles();
        }

        List<XWPFStyle> usedStyleList = srcDoc.getStyles().getUsedStyleList(style);
        for (XWPFStyle xwpfStyle : usedStyleList) {
            destDoc.getStyles().addStyle(xwpfStyle);
        }
    }

    public static void main(String[] args) throws Exception {

        FileInputStream in = new FileInputStream("D:\\12\\12.docx");
        XWPFDocument doc = new XWPFDocument(in);
        // XWPFDocument newDoc = new XWPFDocument();
        // XWPFDocument doc = new XWPFDocument(new FileInputStream("source.docx"));
        XWPFDocument destDoc = new XWPFDocument();
        OutputStream out = new FileOutputStream("D:\\12\\Destination.docx");
        XWPFParagraph pr = doc.getParagraphs().get(0);
        destDoc.createParagraph();
        int pos = destDoc.getParagraphs().size() - 1;
        destDoc.setParagraph(pr, pos);
        destDoc.write(out);
        
        

    }

 }
