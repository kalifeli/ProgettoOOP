package progetto;
import java.util.ArrayList;

/**
 * Rappresenta una città appartenente ad un pianeta, sulla quale Babbo Natale dovrà fare scalo per consegnare tutti i regali richiesti.
 * @author Alessandro Feliziani
 * @author Luca Severini
 */
public class Citta{
    private final String nomeCitta;
    private final int numeroCase;
    private ArrayList<Regalo> listaRegali;
    private ArrayList<Collegamento> listaCollegamenti;

    /**
     * Costruttore che attribuisce alla città un nome.
     * @param nomeCitta nome della città
     */
    public Citta(String nomeCitta){
        this.nomeCitta = nomeCitta;
        this.numeroCase = -1;
    }

    /**
     * Una città è descritta da un nome, dal numero di case, presenta una lista di collegamenti con altre città e una
     * lista di regali richiesti a Babbo Natale.
     * @param nomeCitta nome della città
     * @param numeroCase numero di case presenti nella città
     */
    public Citta(String nomeCitta, int numeroCase) {
        this.nomeCitta = nomeCitta;
        this.numeroCase = numeroCase;
        this.listaCollegamenti = new ArrayList<>(); // alla chiamata del costruttore della classe(ovvero alla creazione di una città), vado a creare una lista di Regali e Collegamenti per quella città;
        this.listaRegali = new ArrayList<>();
    }

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
     * @return true se il numero di case è al più di 10, altrimenti false
     */
    public boolean isCittadina() { // !isPaesino
        return numeroCase > 10;
    }

    /**
     * Metodo che fornisce l'accesso alla lista dei regali di una città.
     * @return un ArrayList di Regalo contenente tutti i regali richiesti a Babbo Natale nella città
     */
    public ArrayList<Regalo> getListaRegali() {
        return listaRegali;
    }

    /**
     * Permette di aggiungere un regalo nella lista dei regali della città
     * @param regalo oggetto di tipo Regalo da aggiungere alla lista dei regali
     */
    public void addRegalo(Regalo regalo) {listaRegali.add(regalo);}

    /**
     * Permette di aggiungere un collegamento all'interno della lista dei collegamenti della città.
     * @param collegamento oggetto di tipo Collegamento da aggiungere nella lista dei collegamenti della città
     */
    public void addCollegamento(Collegamento collegamento) {
        listaCollegamenti.add(collegamento);
    }

    /**
     * Metodo che fornisce l'accesso alla lista dei collegamenti della città.
     * @return un ArrayList di tipo Collegamento contenente tutti i collegamenti di una città
     */
    public ArrayList<Collegamento> getListaCollegamenti() {return listaCollegamenti;}

    /**
     * Trova il costo totale dei collegamenti in una città
     * @return un intero rappresentante il costo totale dei regali richiesti nella città
     */
    public int getCostoCollegamentiCitta(){
        int costo = 0;
        for(Collegamento collegamento : getListaCollegamenti())
        {
            costo += collegamento.getTempo();
        }
        return costo;
    }

    /**
     * Metodo booleano che consente di verificare la presenza di un collegamento tra due città.
     * @param citta1 città di partenza
     * @param citta2 città di arrivo
     * @return true se esiste un collegamento tra le due città, altrimenti false
     */
    public boolean esistenzaCollegamento(Citta citta1,Citta citta2){
        for(Collegamento collegamento1 : citta1.getListaCollegamenti()){
            if(collegamento1.getCitta2().getNomeCitta().equals(citta2.getNomeCitta()))
                return true;
        }
        return false;
    }

    /**
     * Metodo che accede alla size della lista dei regali della città
     * @return un intero rappresentante il numero di regali richiesti
     */
    public int getRegaliRichiesti(){
        return getListaRegali().size();
    }

    /**
     * Metodo per ottenere il pianeta di una città
     * @return un oggetto Pianeta
     */
    public Pianeta getPianeta(Settore s1){
        Pianeta pianeta = null;
        for(Pianeta p : s1.getListaPianeti()){
            for(Citta citta : p.getListaCitta()){
                if (citta.getNomeCitta().equals(getNomeCitta())) {
                    pianeta = p;
                    break;
                }
            }
        }
        return pianeta;
    }
}



