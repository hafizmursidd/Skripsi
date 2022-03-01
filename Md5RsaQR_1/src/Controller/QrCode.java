package Controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

public class QrCode {

    public static String buildQR(String fileText, String pathName) {

        // String data = "abcdefg123446741414";
        String data = fileText;
        try {

            ByteArrayOutputStream out = QRCode.from(data)
                    .to(ImageType.PNG).stream();

            String Path_name = pathName;

            FileOutputStream fout = new FileOutputStream(new File(Path_name));
            fout.write(out.toByteArray());
            fout.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
        return pathName;
    }

    public static String readQR(String path) {

        String getPath = path;
        String resultHash = "failed";
        System.out.println("path : " + getPath);

        try {
            FileInputStream fs = new FileInputStream(getPath);
            XWPFDocument docx = new XWPFDocument(fs);

            List<XWPFPictureData> piclist = docx.getAllPictures();
            Iterator<XWPFPictureData> iterator = piclist.iterator();
            XWPFPictureData pic = iterator.next();
            byte[] bytepic = pic.getData();
            BufferedImage barcBufferedImage = ImageIO.read(new ByteArrayInputStream(bytepic));
            LuminanceSource source = new BufferedImageLuminanceSource(barcBufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Reader reader = new MultiFormatReader();
            Result result = reader.decode(bitmap);
            resultHash = result.getText();
            //System.out.println("result : " + resultText);
            //System.out.println("");
        } catch (Exception e) {
            //System.out.println("Data QR tidak teridentifikasi");
        }
        return resultHash;
    }


}
/*
    public static void main(String[] args) {
        // TODO code application logic here
        String letakFile = "D:\\qrcode\\11.docx";
        String hasil = readQR(letakFile);
        String ggg = Docx.readText(letakFile);
        System.out.println("");
        System.out.println("gggg : " + ggg);
        System.out.println("");
        System.out.println("hasilnya : " + hasil);

    }
}
*/
