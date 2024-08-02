package mattia.susin.entities;

import mattia.susin.exceptions.ElementoException;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    //LISTA ATTRIBUTI

    private List<Elementi> elementi;

    //LISTA COSTRUTTORI

    public Catalogo() {
        this.elementi = new ArrayList<>();
    }

    //LISTA METODI

    public void addElementi(Elementi elemento) {
        elementi.add(elemento);
    }

    public void rimuoviElemento(String isbn) throws ElementoException {
        Elementi elemento = elementi.stream()
                .filter(e -> e.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new ElementoException(isbn));
        elementi.remove(elemento);
    }

    public Elementi ricercaIsbn(String isbn) throws ElementoException {
        return elementi.stream()
                .filter(e -> e.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new ElementoException(isbn));
    }

    public List<Elementi> ricercaAnno(int anno) {
        List<Elementi> risultati = new ArrayList<>();
        for (Elementi e : elementi) {
            if (e.getAnnoPubblicazione() == anno) {
                risultati.add(e);
            }
        }
        return risultati;
    }

    public List<Libro> ricercaAutore(String autore) {
        List<Libro> risultati = new ArrayList<>();
        for (Elementi e : elementi) {
            if (e instanceof Libro && ((Libro) e).getAutore().equalsIgnoreCase(autore)) {
                risultati.add((Libro) e);
            }
        }
        return risultati;
    }


}
