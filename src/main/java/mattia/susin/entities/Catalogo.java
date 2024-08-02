package mattia.susin.entities;

import mattia.susin.exceptions.ElementoException;
import mattia.susin.interfaces.Ricerca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return elementi.stream()
                .filter(e -> e instanceof Libro && ((Libro) e).getAutore().equalsIgnoreCase(autore))
                .map(e -> (Libro) e)
                .collect(Collectors.toList());
    }

    public List<Elementi> ricerca(Ricerca gestione) {
        return elementi.stream()
                .filter(gestione::ricerca)
                .collect(Collectors.toList());
    }
}


