package progetto;
import java.util.ArrayList;
public class Citta {
    private String nomeCitta;
    private int numeroCase;
    private ArrayList<Regalo> listaRegali;
    private ArrayList<Collegamento> listaCollegamenti;


    //Costruttore
    public Citta(String nomeCitta, int numeroCase) {
        this.nomeCitta = nomeCitta;
        this.numeroCase = numeroCase;
        this.listaCollegamenti = new ArrayList<>(); // alla chiamata del costruttore della classe(ovvero alla creazione di una città), vado a creare una lista di Regali e Collegamenti per quella città;
        this.listaRegali = new ArrayList<>();
    }

    //Metodi getter e setter

    /**
     * Metodo di accesso alla variabile esemplare nomeCitta
     * @return una stringa di testo rappresentante il nome della città
     */
    public String getNomeCitta() {
        return nomeCitta;
    }

    /**
     * Metodo di accesso alla variabile esemplare numeroCase
     * @return un intero che rappresenta il numero di case appartenenti ad una città
     */
    public int getNumeroCase() {return numeroCase;}


    /**
     * Permette, in base al numero di case di una città, di definire la sua grandezza
     * @return true se il numero di case è al più 10, altrimenti false
     */
    public boolean isPaesino() {
        return numeroCase <= 10;
    }

    public ArrayList<Regalo> getListaRegali() {
        return listaRegali;
    }


    /**
     * Permette di aggiungere un regalo nella lista dei regali della città
     * @param regalo
     */
    public void addRegalo(Regalo regalo) {listaRegali.add(regalo);}

    //metodo per aggiungere un collegamento bidirezionale
    public void addCollegamento(Citta citta, int costo) {
        // aggiungi un collegamento alla lista dei collegamenti
        listaCollegamenti.add(new Collegamento(citta, costo)); /*BIDIREZIONALITà*/
        // ti riferisci alla lista dei collegamenti della citta aggiungendo un collegamento
        citta.listaCollegamenti.add(new Collegamento(this, costo)); /*BIDIREZIONALITà*/
    }
    public ArrayList<Collegamento> getListaCollegamenti() {return listaCollegamenti;}
}



