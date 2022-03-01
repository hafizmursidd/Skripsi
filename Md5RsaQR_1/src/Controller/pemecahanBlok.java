package Controller;

import java.math.BigInteger;
import java.util.ArrayList;

public class pemecahanBlok {

    public String blok;
    public int panjangBlok;

    public pemecahanBlok() {

    }

    public pemecahanBlok(String blok, int panjangBlok) {
        this.blok = blok;
        this.panjangBlok = panjangBlok;
    }

    public void setValue(String newValue, int newPanjangBlok) {
        this.blok = newValue;
        this.panjangBlok = newPanjangBlok;
    }

    public int getLength() {
        return this.panjangBlok;
    }

    public String getValue() {
        return this.blok;
    }
    }

