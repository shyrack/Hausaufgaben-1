package florian.jahn.hausaufgaben;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        KomplexeZahl y = new KomplexeZahl(4, 5);
        System.out.println(y.getImaginary());
        System.out.println(y.getReal() + "\n");

        KomplexeZahl z = new KomplexeZahl(0, 0);
        System.out.println("z = " + z);
        z = new KomplexeZahl(1, 0);
        System.out.println("z = " + z);
        z = new KomplexeZahl(0, 1);
        System.out.println("z = " + z);
        z = new KomplexeZahl(-4, 0);
        System.out.println("z = " + z);
        KomplexeZahl[] wurzeln = z.getWurzel();
        System.out.println("sqrt(z) = " + Arrays.toString(wurzeln));
        z = new KomplexeZahl(1, 1);
        System.out.println("z = " + z);
        double betrag = z.getBetrag();
        System.out.println("|z| = " + betrag);
        KomplexeZahl z2 = new KomplexeZahl(2, 1);
        System.out.println("z2 = " + z2);
        z.addiere(z2);
        System.out.println("z nach Addition von z2 = " + z);
        z.multipliziere(z2);
        System.out.println("z nach Multiplikation von z2 = " + z);
        z2 = z.getProdukt(new KomplexeZahl(-1, 0));
        System.out.println("z2 = " + z2);
        KomplexeZahl summe = z.getSumme(z2);
        System.out.println("summe = " + summe);
    }

}