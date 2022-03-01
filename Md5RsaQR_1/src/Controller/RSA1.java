package Controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class RSA1 {

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

    public static BigInteger[] enkripsi(String messagedigest, int panjangbitprime) {
        String md = messagedigest;
        BigInteger test;
        BigInteger satu = new BigInteger("1");
        BigInteger p = GeneratePrime(panjangbitprime);
        BigInteger q = GeneratePrime(panjangbitprime);
        System.out.println("P = " + p);
        System.out.println("Q = " + q);

        BigInteger n = hitungN(p, q);
        System.out.println("N = " + n);
        BigInteger totient = hitungtotient(p, q);
        System.out.println("totient = " + totient);
        BigInteger e;

        do {
            e = GeneratePrime(panjangbitprime);
            test = gcd(e, totient);
        } while (test.compareTo(satu) != 0);

        BigInteger d = hitung_pvt(e, totient);
        //batas
        String nilaiSignature = perhitunganEnkripsi(messagedigest, n, e);
        BigInteger S = new BigInteger(nilaiSignature);
        //batas 
        System.out.print("\nnilai : ");
        System.out.print(nilaiSignature + "\n");

        System.out.println("nilai e : " + e);
        System.out.println("nilai d : " + d);

        return new BigInteger[]{d, S, n};
    }

    public static String perhitunganEnkripsi(String messageDigest, BigInteger n, BigInteger e) {
        String number = messageDigest;
        int panjangBlok = n.toString().length() - 1;
        int sisaBlok = number.length() % panjangBlok;
        int digitMax = n.toString().length();
        String finalEnkripsi = "";
        int panjangArray = (number.length() / panjangBlok);
        if (sisaBlok > 0) {
            panjangArray += 1;
        }
        pemecahanBlok xyz[] = pemisahanBlok(number, n, panjangArray);
        bridge(xyz);

//      melakukan ekripsi setiap blok  
        pemecahanBlok enkripsi[] = new pemecahanBlok[panjangArray];
        BigInteger temp, temp2;

//      System.out.println("\nlength : " + enkripsi.length);
        for (int l = 0; l < enkripsi.length; l++) {
            temp = new BigInteger(xyz[l].blok);
            temp2 = temp.modPow(e, n);
            enkripsi[l].blok = temp.toString();
            enkripsi[l].panjangBlok = temp.toString().length();
        }

        String enkripsiString[] = new String[enkripsi.length];
//mengubah bigInteger ke String 
        for (int l = 0; l < enkripsi.length; l++) {
            enkripsiString[l] = enkripsi[l].blok;
        }
//menambahkan bitpengganjal
        System.out.println("");
        for (int l = 0; l < enkripsi.length; l++) {
//            if (l == 0) {
//                finalEnkripsi = enkripsiString[l];
//            } else {
//                while (enkripsiString[l].length() < digitMax) {
//                    enkripsiString[l] = "0" + enkripsiString[l];
//                }

            finalEnkripsi += enkripsiString[l];
            //}
            System.out.print(enkripsiString[l] + " ");
        }
        return finalEnkripsi;
    }

    public static pemecahanBlok[] pemisahanBlok(String messageDigest, BigInteger n, int panjangArray) {

        String number = messageDigest;
        int panjangBlok = n.toString().length() - 1; //panjang blok digunakan unutk membagi blok sebelum dienkripsi
        int sisaBlok = number.length() % panjangBlok;
        int panjangperulangan = (number.length() / panjangBlok);
        int panjang = panjangArray;

        pemecahanBlok[] aaaa = new pemecahanBlok[panjang];
        int j = 0, i = 0, k = 0, l = 0;

        //pemisahan String to blok Array
        String tempBlok = "";
        int templength;

        while (k < panjangperulangan) {
            tempBlok = number.substring(i, i + panjangBlok);
            templength = tempBlok.length();
            pemecahanBlok digest = new pemecahanBlok(tempBlok, templength);
            System.out.println(tempBlok);
            aaaa[j] = digest;
            i += panjangBlok;
            k++;
            j++;
        }
        if (sisaBlok == 1) {
            tempBlok = number.substring(i);
            templength = tempBlok.length();
            pemecahanBlok digest = new pemecahanBlok(tempBlok, templength);
            aaaa[j] = digest;
        } else if (sisaBlok >= 1) {
            tempBlok = number.substring(i, i + sisaBlok);
            templength = tempBlok.length();
            pemecahanBlok digest = new pemecahanBlok(tempBlok, templength);
            aaaa[j] = digest;
        }

        System.out.println("panjang adt : " + aaaa.length);
        System.out.println("panjnag j : " + j);
        System.out.println("panjang : " + panjang);
        System.out.println("Hasil Pemisahan Blog ");
        for (i = 0; i < aaaa.length; i++) {
            System.out.print(aaaa[i].blok + " " + aaaa[i].panjangBlok);
            System.out.println("");
        }

        return aaaa;
    }

public static pemecahanBlok [] bridge (pemecahanBlok [] temp){
pemecahanBlok [] blokPlaintext = temp;
return blokPlaintext;
}

    public static String[] pemisahanBlogDeks(String chipertext, BigInteger n, BigInteger e) {
        String number = chipertext;

        int panjangBlok = n.toString().length();
        int panjangperulangan = (number.length() / panjangBlok);
        int panjang = panjangperulangan;
        String xyz[] = new String[panjang];
        int j = 0, i = 0, k = 0;

//pemisahan String to blok Array
        while (k < panjangperulangan) {
            xyz[j] = number.substring(i, i + panjangBlok);
            i += panjangBlok;
            k++;
            j++;
        }
        System.out.println("Hasil Pemisahan Blog ");
        for (String xyz1 : xyz) {
            System.out.print(xyz1 + " ");
        }
        return xyz;
    }

    public static String deksripsi(String chipertext, BigInteger d, BigInteger N) {
        String hasil = "";
        BigInteger temp;
        BigInteger nilaiN = N;
        BigInteger nilaiD = d;

        String[] tempDes = pemisahanBlogDeks(chipertext, nilaiN, d);
        String deskripsiString = "";

        for (int l = 0; l < tempDes.length; l++) {
            temp = new BigInteger(tempDes[l]);
            // deskripsi[l] = temp.modPow(nilaiD, N);
            //String xx =tempDes[l];
            deskripsiString += temp.modPow(nilaiD, N);
        }
        System.out.println("");
        System.out.println("deskripsi : " + deskripsiString);

        return deskripsiString;
    }

    public static void main(String[] args) {
//
////pembatas
        // TODO code application logic here
        String plaintext = "440472108104201000750662000490007443800005502660112344566666789009";  //md5hash dalam desimal
        // String Chipertext = "1608577415250741428326323090315437924432394647125024748780178820212115205656";
        String plaintext3 = "40802";
        String Chipertext = "";
        int bitprima = 11;
        BigInteger plaintext2 = new BigInteger("1234");
        BigInteger N = new BigInteger("71697774366666699999");
        BigInteger d = new BigInteger("883");
        BigInteger e = new BigInteger("103");

      //  pemecahanBlok[] PemisahanBlokkk = pemisahanBlog(plaintext, N, bitprima);
        // BigInteger[] Signature = enkripsi(plaintext, bitprima);

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
    }

}
