package Controller;

public class NewClass {

    public static void main(String[] args) {

        String number = "44042108104201000750";
        String tempBlok = "";
        int panjangBlok = 5;
        int templength;
        int k = 0, i = 0;
        int panjangPerulangan = 4;
        pemecahanBlok digest = new pemecahanBlok();

        while (k < panjangPerulangan) {
            tempBlok = number.substring(i, i + panjangBlok);
            templength = tempBlok.length();
            i += panjangBlok;
            k++;
        }
    }

}
