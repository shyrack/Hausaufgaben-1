package florian.jahn.hausaufgaben;

/**
 * Die Klasse stellt verschiedene Methoden zum Rechnen mit Komplexen Zahlen.
 * Dabei muss ein neues Objekt erstellt werden.
 * Im Konstruktor werden dann der Realteil und Imaginärteil der Zahl übergeben und
 * anschließend in den Attributen gespeichert.
 *
 * @author Florian Jahn, Lucas Dohmen und Jan Wilkening
 * @version 1.0, 14. Oktober 2020
 */
public class KomplexeZahl {

    /**
     * Speichert den Imaginärteil der Komplexen Zahl als double.
     */
    private double imaginary;

    /**
     * Speichert den Realteil der Komplexen Zahl als double.
     */
    private double real;

    /**
     * Erstellt eine neue Instanz der Klasse Komplexe Zahl.
     *
     * @param real      Der Realteil der Komplexen Zahl.
     * @param imaginary Der Imaginärteil der Komplexen Zahl.
     */
    public KomplexeZahl(double real, double imaginary) {

        this.imaginary = imaginary;
        this.real = real;
    }

    /**
     * Gibt den Imaginärteil der aktuellen Komplexen Zahl zurück.
     *
     * @return Der Imaginärteil der Komplexen Zahl.
     */
    public double getImaginary() {

        return this.imaginary;
    }

    /**
     * Gibt den Realteil der aktuellen Komplexen Zahl zurück.
     *
     * @return Der Realteil der Komplexen Zahl.
     */
    public double getReal() {

        return this.real;
    }

    /**
     * Addiert die aktuelle Komplexe Zahl mit der übergebenen Komplexen Zahl.
     *
     * @param z Die Komplexe Zahl, welche mit der aktuellen addiert werden soll.
     */
    public void addiere(KomplexeZahl z) {

        this.imaginary += z.imaginary;
        this.real += z.real;
    }

    /**
     * Multipliziert die aktuelle Komplexe Zahl mit der übergebenen Komplexen Zahl.
     *
     * @param z Die Komplexe Zahl, welche mit der aktuellen multipliziert werden soll.
     */
    public void multipliziere(KomplexeZahl z) {

        double helpImaginary = (this.imaginary * z.real) + (this.real * z.imaginary);

        this.real = (this.real * z.real) - (this.imaginary * z.imaginary);
        this.imaginary = helpImaginary;
    }

    /**
     * Gibt den Betrag der aktuellen Komplexen Zahl zurück.
     *
     * @return Der Betrag der aktuellen Komplexen Zahl.
     */
    public double getBetrag() {

        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    /**
     * Stellt die aktuelle Komplexe Zahl als String dar im Format: a+bi bzw. this.real+this.imaginary*i
     *
     * @return Die Komplexe Zahl als String
     */
    @Override
    public String toString() {

        if (this.imaginary == 0) {

            return Double.toString(this.real);
        } else if (this.imaginary < 0) {

            if (this.imaginary == -1) {

                return this.real + " - i";
            } else {

                return this.real + " - " + Math.abs(this.imaginary) + "i";
            }
        } else {

            if (this.imaginary == 1) {

                return this.real + " + i";
            } else {

                return this.real + " + " + this.imaginary + "i";
            }
        }
    }

    /**
     * Errechnet die Quadratwurzeln der aktuellen Komplexen Zahl.
     *
     * @return Die Quadratwurzeln der aktuellen Komplexen Zahl.
     */
    public KomplexeZahl[] getWurzel() {

        KomplexeZahl[] out = new KomplexeZahl[2];

        if ((this.imaginary == 0) && (this.real == 0)) {

            out[0] = new KomplexeZahl(0, 0);
            out[1] = new KomplexeZahl(0, 0);

            return out;
        }

        double x = Math.sqrt((Math.abs(this.real) + this.getBetrag()) / 2);

        if (this.real >= 0) {

            double y = this.imaginary / (2 * x);

            if (x == 0) {

                out[0] = new KomplexeZahl(x, y);
                out[1] = new KomplexeZahl(x, -y);
            } else {

                out[0] = new KomplexeZahl(x, y);
                out[1] = new KomplexeZahl(-x, -y);
            }
        } else {

            double y = Math.abs(this.imaginary) / (2 * x);

            if (y == 0) {

                out[0] = new KomplexeZahl(y, x);
                out[1] = new KomplexeZahl(y, -x);
            } else {

                out[0] = new KomplexeZahl(y, x);
                out[1] = new KomplexeZahl(-y, -x);
            }
        }

        return out;
    }

    /**
     * Errechnet die Summe der übergebenen und der aktuellen Komplexen Zahl.
     *
     * @param z Die Komplexe Zahl, welche auf die aktuelle addiert werden soll.
     * @return Eine neue Komplexe Zahl, welche die Summe von z und der aktuellen Zahl ist.
     */
    public KomplexeZahl getSumme(KomplexeZahl z) {

        return new KomplexeZahl(this.real + z.real, this.imaginary + z.imaginary);
    }

    /**
     * Errechnet das Produkt der übergebenen und der aktuellen Komplexen Zahl.
     *
     * @param z Die Komplexe Zahl, welche von der aktuellen dividiert werden soll.
     * @return Eine neue Komplexe Zahl, welche das Produkt von z und der aktuellen Zahl ist.
     */
    public KomplexeZahl getProdukt(KomplexeZahl z) {

        double squaredZ = Math.pow(z.real, 2) + Math.pow(z.imaginary, 2);
        double realProduct = ((this.real * z.real) + (this.imaginary * z.imaginary)) / squaredZ;
        double imaginaryProduct = ((this.imaginary * z.real) - (this.real * z.imaginary)) / squaredZ;

        return new KomplexeZahl(realProduct, imaginaryProduct);
    }

}