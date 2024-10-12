package Laskin;

import java.lang.Math;

public class Laskin {

    private double tulos;  	// Muuttuja tulokselle

    public void nollaa() {  // Nollaa tulosmuuttuja
        tulos = 0;
    }

    public double annaTulos() {
        return tulos;
    }

    public void lisaa(double n) {
        tulos = tulos + n;
    }

    public void vahenna(double n) {
        tulos = tulos - n;
    }

    public void kerro(double n) {
        tulos = tulos * n;
    }

    public void jaa(double n) {
        if (n==0) throw new ArithmeticException("Nollalla ei voi jakaa");
        tulos = tulos / n;
    }

    public void nelio(double n) {
        tulos = n * n;
    }

    public void neliojuuri(double n) {
        if(n < 0) throw new ArithmeticException("Negatiiviselle luvulle ei voi laskea neliöjuurta");
        tulos = (double) Math.sqrt(n);
    }

    public void virtaON() {
        System.out.println("Virta päällä.");
        tulos = 0;
    }

    public void virtaOFF() {
        System.out.println("Virta pois päältä.");
        tulos = 0;
    }

}