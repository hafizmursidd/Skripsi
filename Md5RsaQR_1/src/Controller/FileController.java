/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileController {

    public static String getFile() {

        //mengambil file yang akan diproses
        JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        file.setCurrentDirectory(new File("D:\\"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Word file", "docx", "text");
        file.addChoosableFileFilter(filter);
        file.setAcceptAllFileFilterUsed(false);

        int a = file.showOpenDialog(null);

        if (a == JFileChooser.APPROVE_OPTION) {
            File getFile = file.getSelectedFile();
            String path = getFile.getAbsolutePath();
            return path;
        } else {
            return "wrongpath";
        }
    }

    public static String saveFile() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setCurrentDirectory(new File("D:\\"));
        int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            return path;
        } else {
            return "wrongpath";
        }
    }


  //  public static void main(String[] args) throws Exception {
//
       // System.out.println(saveFile());
//        FileInputStream in = new FileInputStream("D:\\12.docx");
//        XWPFDocument doc = new XWPFDocument(in);
//        // XWPFDocument newDoc = new XWPFDocument();
//        // XWPFDocument doc = new XWPFDocument(new FileInputStream("source.docx"));
//        XWPFDocument destDoc = new XWPFDocument();
//        OutputStream out = new FileOutputStream("D:\\Destination.docx");
//        XWPFParagraph pr = doc.getParagraphs().get(0);
//        destDoc.createParagraph();
//        int pos = destDoc.getParagraphs().size() - 1;
//        destDoc.setParagraph(pr, pos);
//        destDoc.write(out);

  //  }
}
