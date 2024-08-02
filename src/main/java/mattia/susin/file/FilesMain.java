package mattia.susin.file;

import mattia.susin.entities.Catalogo;
import mattia.susin.entities.Elementi;
import mattia.susin.entities.Libro;
import mattia.susin.entities.Rivista;
import mattia.susin.enums.Periodicità;
import mattia.susin.exceptions.ElementoException;

import java.util.Scanner;

public class FilesMain {
    public static void main(String[] args) {

        //LISTA ATTRIBUTI

        Catalogo catalogo = new Catalogo();
        Scanner scanner = new Scanner(System.in);

        //LISTA COSTRUTTORI

        while (true) {
            System.out.println("Scegli l'opzione desiderata");
            System.out.println("1-Aggiungi Libri");
            System.out.println("2-Aggiungi Rivista");
            System.out.println("3-Rimuovi Elemento");
            System.out.println("4-Ricerca con ID");
            System.out.println("5-Ricerca per Annata");
            System.out.println("6-Ricerca per Autore");
            System.out.println("0-Annulla Operazione");

            int selezione = scanner.nextInt();


            switch (selezione) {
                case 1:
                    System.out.print("ID: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Anno: ");
                    int anno = scanner.nextInt();
                    System.out.print("Numero Pagine: ");
                    int pagine = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Autore: ");
                    String autore = scanner.nextLine();
                    System.out.print("Genere: ");
                    String genere = scanner.nextLine();
                    Libro libro = new Libro(isbn, titolo, anno, pagine, autore, genere);
                    catalogo.addElementi(libro);
                    System.out.println("Libro aggiunto!");
                    break;

                case 2:
                    System.out.print("ID: ");
                    isbn = scanner.nextLine();
                    System.out.print("Titolo: ");
                    titolo = scanner.nextLine();
                    System.out.print("Anno: ");
                    anno = scanner.nextInt();
                    System.out.print("Numero Pagine: ");
                    pagine = scanner.nextInt();                                                                         //TODO Uso dell'Enums
                    System.out.println("Periodicità --> 1-SETTIMANALE: ");
                    System.out.println("Periodicità --> 2-MENSILE: ");
                    System.out.println("Periodicità --> 3-SEMESTRALE: ");
                    int periodo = scanner.nextInt();
                    scanner.nextLine();
                    Periodicità periodicità;

                    switch (periodo) {
                        case 1:
                            periodicità = Periodicità.SETTIMANALE;
                            break;
                        case 2:
                            periodicità = Periodicità.MENSILE;
                            break;
                        case 3:
                            periodicità = Periodicità.SEMESTRALE;
                            break;
                        default:
                            System.out.println("Periodicità non valida!");
                            continue;                                                                                   //TODO Te lo fa saltare il 'continue'
                    }

                    Rivista rivista = new Rivista(isbn, titolo, anno, pagine, periodicità);
                    catalogo.addElementi(rivista);
                    System.out.println("Rivista aggiunta!");
                    break;

                case 3:
                    System.out.print("Inserisci ID dell'elemento da rimuovere: ");
                    isbn = scanner.nextLine();
                    try {
                        catalogo.rimuoviElemento(isbn);
                        System.out.println("Elemento rimosso!");
                    } catch (ElementoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Inserisci l'ID: ");
                    isbn = scanner.nextLine();
                    try {
                        Elementi elemento = catalogo.ricercaIsbn(isbn);
                        System.out.println(elemento);
                    } catch (ElementoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Inserisci Anno di Pubblicazione: ");
                    anno = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Risultati:");
                    catalogo.ricercaAnno(anno).forEach(System.out::println);
                    break;

                case 6:
                    System.out.print("Inserisci Autore: ");
                    autore = scanner.nextLine();
                    System.out.println("Risultati:");
                    catalogo.ricercaAutore(autore).forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Uscita dal programma.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        }
    }
}
