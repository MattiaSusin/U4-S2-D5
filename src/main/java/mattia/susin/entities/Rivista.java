package mattia.susin.entities;

import mattia.susin.enums.Periodicità;

public class Rivista extends Elementi {

    //LISTA ATTRIBUTI

    private Periodicità periodicità;

    //LISTA COSTRUTTORI

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicita;
    }

    public Periodicità getPeriodicita() {
        return periodicità;
    }

    //LISTA METODI


    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                "} " + super.toString();
    }
}
