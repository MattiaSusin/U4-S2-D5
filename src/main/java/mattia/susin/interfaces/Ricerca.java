package mattia.susin.interfaces;

import mattia.susin.entities.Elementi;

public interface Ricerca {
    boolean ricerca(Elementi elementi);

    public interface ElementSearch {
        boolean search(Elementi elemento);
    }
}
