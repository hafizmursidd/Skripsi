package Controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger hash = new BigInteger(1, messageDigest);

            // Convert message digest to String value
            String hashtext = hash.toString();
//            String hashtextHex = no.toString(16);
//            System.out.print("Desimal :"+hashtext);
//            
//            System.out.print("\nhex :"+hashtextHex +"\n");
            
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
//        // TODO code application logic here
//        String plaintext = "admin";
//        String chipertext = getMd5(plaintext);
//
//        System.out.println(chipertext);
//
//    }
}
