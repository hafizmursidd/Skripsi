package Controller;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

    public static BigInteger generatePrime(int panjangbitprime) {
        //melakukan generate bilangan prima dengan panjang bit masukan user
        int N = panjangbitprime;
        SecureRandom random = new SecureRandom();
        BigInteger prime = BigInteger.probablePrime(N, random);
        return prime;
    }

    public static BigInteger hitungN(BigInteger p, BigInteger q) {
        //menghitung nilai n dengan mengalikan nilai prima p da q
        BigInteger n;
        n = p.multiply(q);

        return n;
    }

    public static BigInteger hitungtotient(BigInteger p, BigInteger q) {
        //menghitung nilai totient t= (p-1)*(q-1)
        BigInteger t;
        BigInteger p1 = new BigInteger("1");
        p = p.subtract(p1);
        q = q.subtract(p1);
        t = p.multiply(q);
        return t;
    }

    public static BigInteger hitungFPB(BigInteger e, BigInteger totient) {
        //mencari fpb dari bilangan prima E dan totient
        //memilih nilai e [kunci publik] yang realtif prima dengan m [totient]
        BigInteger r, temp;
        BigInteger nol = new BigInteger("0");
        int compare = e.compareTo(totient);     //if  E<totient=-1

        if (compare == -1) {
            temp = e;
            e = totient;
            totient = temp;
        }
        while (totient.compareTo(nol) != 0) {
            r = e.mod(totient);
            e = totient;
            totient = r;
        }
        return e;
    }

    public static BigInteger hitungPvt(BigInteger e, BigInteger totient) {

        // rumus awal e * d = 1 + k totient(n)
        //disederhanakan jadi d = 1+k(totient(n)) dibagi e
        //nilai k dicoba2
        BigInteger k, h, d;
        BigInteger satu = new BigInteger("1");
        k = new BigInteger("1");

        while (true) {
            d = k.multiply(e); //k*e
            h = d.mod(totient); //d mod totient

            if (h.compareTo(satu) == 0) {
                return k;
            } else {
                k = k.add(satu);

            }
        }
    }

    public static BigInteger[] atributRSA(String messagedigest, int panjangbitprime) {
        String md = messagedigest;
        BigInteger test;
        BigInteger satu = new BigInteger("1");
        BigInteger p = generatePrime(panjangbitprime);
        BigInteger q = generatePrime(panjangbitprime);
        System.out.println("P = " + p);
        System.out.println("Q = " + q);

        BigInteger nilaiN = hitungN(p, q);
        System.out.println("N = " + nilaiN);
        BigInteger totient = hitungtotient(p, q);
        System.out.println("totient = " + totient);
        BigInteger e;

        do {
            e = generatePrime(panjangbitprime);
            test = hitungFPB(e, totient);
        } while (test.compareTo(satu) != 0);

        BigInteger d = hitungPvt(e, totient);

        return new BigInteger[]{e, nilaiN, d};
    }

    public static String[] pemisahanBlok(String messageDigest, BigInteger N) {

        String number = messageDigest;
        int panjangBlok = N.toString().length() - 1; //panjang blok digunakan unutk membagi blok sebelum dienkripsi
        int sisaBlok = number.length() % panjangBlok;
        int digitMax = N.toString().length();
        int panjangperulangan = (number.length() / panjangBlok);

        int panjangArray = (number.length() / panjangBlok);
        if (sisaBlok > 0) {
            panjangArray += 1;
        }
        String[] chipertextBlok = new String[panjangArray];

        int j = 0, i = 0, k = 0, l = 0;

        String tempBlok = "";
        int templength;

        while (k < panjangperulangan) {
            tempBlok = number.substring(i, i + panjangBlok);
            chipertextBlok[k] = tempBlok;
            i += panjangBlok;
            k++;
        }
        if (sisaBlok == 1) {
            tempBlok = number.substring(i);
            chipertextBlok[k] = tempBlok;
        } else if (sisaBlok >= 1) {
            tempBlok = number.substring(i, i + sisaBlok);
            chipertextBlok[k] = tempBlok;
        }

//        System.out.println("panjang adt : " + chipertextBlok.length);
//        System.out.println("panjang k : " + k);
//        System.out.println("panjang : " + panjangArray);
        System.out.print("Hasil Pemisahan Blog : ");

        for (i = 0; i < chipertextBlok.length; i++) {
            System.out.print(chipertextBlok[i] + "\t");
            // System.out.println("");
        }
        return chipertextBlok;
    }

    public static String enkripsi(String blokPlaintext[], BigInteger N, BigInteger e) {

        BigInteger enkripsiValue[] = new BigInteger[blokPlaintext.length];

//      melakukan ekripsi setiap blok  
        BigInteger temp, temp2;
        String tempValue = "";
        System.out.print("\nHasil Enkripsi : ");
        String finalEnkripsi = "";

        for (int i = 0; i < blokPlaintext.length; i++) {
            temp = new BigInteger(blokPlaintext[i]);
            temp2 = temp.modPow(e, N);
            tempValue = temp2.toString();
            enkripsiValue[i] = new BigInteger(tempValue);
            System.out.print(enkripsiValue[i] + "\t");//System.out.println("");
            finalEnkripsi += (enkripsiValue[i].toString() + 't');

        }
        return finalEnkripsi;
    }

    public static String[] pemisahanBlokDes(String enkripsi) {

        String toDeskripsi = enkripsi;
        String[] blokQr = toDeskripsi.split("t", 0);
        System.out.print("\nhasil Blok : ");
        for (String w : blokQr) {
            System.out.print(w + " ");
        }
        return blokQr;
    }

    public static String[] dekripsi(String blokChipertext[], BigInteger N, BigInteger d) {

        String[] dekripsi = new String[blokChipertext.length];
        BigInteger temp, temp2;
        String tempBlok = "";
        System.out.print("Deskripsi Array : ");

        for (int i = 0; i < blokChipertext.length; i++) {
            temp = new BigInteger(blokChipertext[i]);
            temp2 = temp.modPow(d, N); //proses dekripsi
            tempBlok = temp2.toString();
            dekripsi[i] = tempBlok;
            System.out.print(dekripsi[i] + "\t");
            //System.out.println("");
        }

        return dekripsi;
    }

    public static String finalDekripsi(String fromDekripsi[], BigInteger N, int lastLength) {
        String finalDekripsi = "";
        int i;
        int tempL;
        int bitMax = N.toString().length() - 1;

        for (i = 0; i < fromDekripsi.length - 1; i++) {
            if (fromDekripsi[i].length() != bitMax) {

                tempL = fromDekripsi[i].length();
                while (tempL < bitMax) {
                    fromDekripsi[i] = "0" + fromDekripsi[i];
                    tempL++;
                }
            }
            //System.out.print(fromDekripsi[i] + "\t");
            finalDekripsi += fromDekripsi[i];
        }

        tempL = fromDekripsi[i].length();        //4
        bitMax = lastLength;                     //3
        if (tempL < bitMax) {
            while (tempL < bitMax) {
                fromDekripsi[i] = "0" + fromDekripsi[i];
                tempL++;
            }
            finalDekripsi += fromDekripsi[i];;
        } else if (tempL == bitMax) {
            finalDekripsi += fromDekripsi[i];
        }
        System.out.println("\nhasil dekripsi  : " + finalDekripsi);
        System.out.println("");
        return finalDekripsi;
    }

}
/*
    public static void main(String[] args) {

////pembatas

        // TODO code application logic here
        String plaintext = "0044000000000075120000021";  //md5hash dalam desimal
        // String Chipertext = "1608577415250741428326323090315437924432394647125024748780178820212115205656";
        String plaintext3 = "40802";
        String Chipertext = "";
        int bitprima = 15;
        BigInteger plaintext2 = new BigInteger("1234");
        BigInteger N = new BigInteger("9955063");
        BigInteger d = new BigInteger("5591627");
        BigInteger e = new BigInteger("3779");
        String[] abc = pemisahanBlok(plaintext, N);
        String enkripsi = enkripsi(abc, N, e);
        //System.out.println("\nenkripsi : " + enkripsi);

        int lastBlokLength = abc[abc.length - 1].length();
        System.out.println("\nlast length :: " + lastBlokLength);

        String[] pisah = pemisahanBlokDes(enkripsi);
        System.out.println("");
        String[] des = dekripsi(pisah, N, d);
        String finalll = finalDekripsi(des, N, 1);
        System.out.println("finaalll deskripsi \t:: " + finalll);
        System.out.println("finaalll Hash \t\t:: " + plaintext);
}}
//        String ek = enkripsi(abc, N, e);
//        System.out.println("\nhasil "+ek);
        
    

//        String temp123 = deksripsi(plaintext3, d, N);
//        System.out.println("hasi : " + temp123);

/*
        P = 79
        Q = 127
        N = 10033
        totient = 9828
        Hasil Pemisahan Blog 
        4404 7210 8104 2010 7506 6249 7443 8055 0266 0112 3445 6666 6789 9900 9 
        6713 09567 06068 01741 03714 08080 01118 03518 06406 09258 04453 07934 00233 03571 03186 
        nilai : 67130956706068017410371408080011180351806406092580445307934002330357103186
        nilai e : 97
        nilai d : 2533
 */
