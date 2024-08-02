package mattia.susin.exceptions;

public class ElementoException extends Throwable {
    public ElementoException(String isbn) {
        super("Elemento con ID ISBN " + isbn + " non trovato!");
    }
}
