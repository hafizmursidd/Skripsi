package Controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class RSA12 {

    BigInteger p, q, n, totient, e, d;
    static String cipherteks;

    public static BigInteger GeneratePrime(int panjangbitprime) {
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

    public static BigInteger gcd(BigInteger e, BigInteger totient) {
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

    public static BigInteger hitung_pvt(BigInteger e, BigInteger totient) {

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
        BigInteger p = GeneratePrime(panjangbitprime);
        BigInteger q = GeneratePrime(panjangbitprime);
        System.out.println("P = " + p);
        System.out.println("Q = " + q);

        BigInteger nilaiN = hitungN(p, q);
        System.out.println("N = " + nilaiN);
        BigInteger totient = hitungtotient(p, q);
        System.out.println("totient = " + totient);
        BigInteger e;

        do {
            e = GeneratePrime(panjangbitprime);
            test = gcd(e, totient);
        } while (test.compareTo(satu) != 0);

        BigInteger d = hitung_pvt(e, totient);

        return new BigInteger[]{e, nilaiN, d};
    }

    public static pemecahanBlok[] pemisahanBlok(String messageDigest, BigInteger n, BigInteger e) {

        String number = messageDigest;
        int panjangBlok = n.toString().length() - 1; //panjang blok digunakan unutk membagi blok sebelum dienkripsi
        int sisaBlok = number.length() % panjangBlok;
        int digitMax = n.toString().length();
        int panjangperulangan = (number.length() / panjangBlok);

        int panjangArray = (number.length() / panjangBlok);
        if (sisaBlok > 0) {
            panjangArray += 1;
        }
        pemecahanBlok[] chipertextBlok = new pemecahanBlok[panjangArray];

        int j = 0, i = 0, k = 0, l = 0;

        String tempBlok = "";
        int templength;

        while (k < panjangperulangan) {
            tempBlok = number.substring(i, i + panjangBlok);
            templength = tempBlok.length();
            pemecahanBlok digest = new pemecahanBlok(tempBlok, templength);
            chipertextBlok[k] = digest;
            i += panjangBlok;
            k++;
        }
        if (sisaBlok == 1) {
            tempBlok = number.substring(i);
            templength = tempBlok.length();
            pemecahanBlok digest = new pemecahanBlok(tempBlok, templength);
            chipertextBlok[k] = digest;
        } else if (sisaBlok >= 1) {
            tempBlok = number.substring(i, i + sisaBlok);
            templength = tempBlok.length();
            pemecahanBlok digest = new pemecahanBlok(tempBlok, templength);
            chipertextBlok[k] = digest;
        }

        System.out.println("panjang adt : " + chipertextBlok.length);
        System.out.println("panjang k : " + k);
        System.out.println("panjang : " + panjangArray);
        System.out.println("Hasil Pemisahan Blog ");
        for (i = 0; i < chipertextBlok.length; i++) {
            System.out.print(chipertextBlok[i].blok + " " + chipertextBlok[i].panjangBlok + "\t");
            // System.out.println("");
        }

        return chipertextBlok;
    }

    public static BigInteger[] enkripsi(pemecahanBlok blokChipertext[], BigInteger n, BigInteger e) {

        BigInteger enkripsiValue[] = new BigInteger[blokChipertext.length];
        System.out.println("length : " + blokChipertext.length);

//      melakukan ekripsi setiap blok  
        BigInteger temp, temp2;
        String tempValue = "";
        System.out.println("Hasil Enkripsi : ");

        for (int i = 0; i < blokChipertext.length; i++) {

            temp = new BigInteger(blokChipertext[i].blok);
            temp2 = temp.modPow(e, n);

            tempValue = temp2.toString();
            enkripsiValue[i] = new BigInteger(tempValue);

            System.out.print(enkripsiValue[i] + "\t");
            //System.out.println("");
        }

        return enkripsiValue;
    }

    public static String[] pemisahanBlokDes(String enkripsi) {

        String toDeskripsi = enkripsi;

        // pemecahanBlok blokQr[] = new pemecahanBlok[blokEnkripsi.length];
        int i = 0;
        //System.out.println("abc : " + blokEnkripsi.length);

        String[] blokQr = toDeskripsi.split("t", 0);
        /*
        for (int k = 0; k < blokEnkripsi.length; k++) {
            int panjangBlok = blokEnkripsi[k].panjangBlok;
            System.out.println("panjang blok : " + panjangBlok);

            tempBlok = toDeskripsi.substring(i, i + panjangBlok);
            templength = tempBlok.length();
            System.out.println("blok : " + tempBlok);
            System.out.println("lengthBLok : " + templength);
            System.out.println("");
            pemecahanBlok digest = new pemecahanBlok(tempBlok, templength);
            blokQr[k] = digest;
            i += panjangBlok;
        }
         */
        for (String w : blokQr) {
            System.out.print(w + " ");
        }

        return blokQr;
    }

    public static String[] dekripsi(String blokChipertext[], BigInteger N, BigInteger d) {

        String[] dekripsi = new String[blokChipertext.length];

//      melakukan ekripsi setiap blok  
        BigInteger temp, temp2;
        String tempBlok = "";
        System.out.println("");
        System.out.println("Final Dekripsi");

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
        int i = 0;
        int tempL;
        int bitMax = N.toString().length() - 1;
        System.out.println("");

        for (i = 0; i < fromDekripsi.length - 1; i++) {
            if (fromDekripsi[i].length() != bitMax) {

                tempL = fromDekripsi[i].length();
                while (tempL < bitMax) {
                    fromDekripsi[i] = "0" + fromDekripsi[i];
                    tempL++;
                }
            }
            System.out.print(fromDekripsi[i] + "\t");
            finalDekripsi += fromDekripsi[i];
        }

        tempL = fromDekripsi[i].length();
        bitMax = lastLength;

        while (tempL < bitMax) {
            fromDekripsi[i] = "0" + fromDekripsi[i];
            tempL++;
        }
        finalDekripsi += fromDekripsi[i];
        System.out.println("\njumlah bit  : " + i);
        System.out.println("from deskripsi : " + fromDekripsi[i]);
        System.out.println("\nhasil dekripsi  : " + finalDekripsi);

        return finalDekripsi;
    }

    public static void main(String[] args) {

        String plaintext = "440472108104201000750662000490007443800005502660112344566666789091";
        int bitprima = 9;

        BigInteger[] value = atributRSA(plaintext, bitprima);
        BigInteger nilaiE = value[0];
        BigInteger nilaiN = value[1];

        System.out.println("nilai e : " + nilaiE);
        System.out.println("nilai N : " + nilaiN);
        System.out.println("nilai d : " + value[2]);

        pemecahanBlok chipertextBlok[] = pemisahanBlok(plaintext, value[1], value[0]);
//        System.out.println("");
//        System.out.println("last blok : " + chipertextBlok[chipertextBlok.length - 1].blok);
        int lastLength = chipertextBlok[chipertextBlok.length - 1].panjangBlok;

        String valueLengthBlokPlaint = "";
        String valueLengthBlokEnkrip = "";
        int temp;

        for (int i = 0; i < chipertextBlok.length; i++) {
            temp = chipertextBlok[i].panjangBlok;
            valueLengthBlokPlaint += Integer.toString(temp);
        }
        System.out.println("\nvalue Text : " + valueLengthBlokPlaint);

        BigInteger valueE[] = enkripsi(chipertextBlok, value[1], value[0]);

        String finalEnkripsi = "";

        for (int i = 0; i < valueE.length; i++) {
            finalEnkripsi += (valueE[i].toString() + 't');
        }
        System.out.println("\nfinal Enkripsi : " + finalEnkripsi);

        String valueBlokQr[] = pemisahanBlokDes(finalEnkripsi);

        String valueDekripsi[] = dekripsi(valueBlokQr, value[1], value[2]);
        String xx = finalDekripsi(valueDekripsi, nilaiN, lastLength);//penambahan blok pengganjal

    }

}
