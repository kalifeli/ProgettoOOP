package progetto;
import java.util.ArrayList;
public class Citta {
    private String nomeCitta;
    private int numeroCase;
    private ArrayList<Regalo> listaRegali;
    private ArrayList<Collegamento> listaCollegamenti;

    private Pianeta pianeta; //NUOVA AGGIUNTA PER TASK3  //Devo metterlo nel costruttore?
    private int regaliRichiesti; //NUOVA AGGIUNTA PER TASK3
    private boolean statoVisita;   //NUOVA AGGIUNTA PER TASK3; "ISVISITED" IN INGLESE


    //Costruttore
    public Citta(String nomeCitta){
        this.nomeCitta = nomeCitta;
        this.numeroCase = -1;
    }
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
    public void addCollegamento(Collegamento collegamento) {
        listaCollegamenti.add(collegamento);
    }
    public ArrayList<Collegamento> getListaCollegamenti() {return listaCollegamenti;}

    /**
     * Trova il costo totale dei collegamenti in una città
     * @return un double rappresentante il costo totale dei regali richiesti dalla citta
     */
    public double getCostoCollegamentiCitta(){
        double costo = 0;
        for(Collegamento collegamento : getListaCollegamenti())
        {
            costo += collegamento.getTempo();
        }
        return costo;
    }

    /**
     * Metodo che restituisce il numero di regali richiesti in una città di una tipologia
     * @param tipoRegalo una stringa che rappresenta il tipo del regalo richiesto
     * @return un intero che rappresenta il numero totale di regali della tipologia indicata richiesti in una citta
     */
    public int getNumeroRegaliDiTipo(String tipoRegalo){
        int contatoreTipoRegalo = 0;
        for(Regalo regalo : getListaRegali()) {
            if (regalo.getTipoRegalo().equals(tipoRegalo))
                contatoreTipoRegalo++;
        }
        return contatoreTipoRegalo;
    }
    public boolean esistenzaCollegamento(Citta citta1,Citta citta2){
        for(Collegamento collegamento1 : citta1.getListaCollegamenti()){
            if(collegamento1.getCitta2().getNomeCitta().equals(citta2.getNomeCitta()))
                return true;
        }
        return false;
    }

    /**
     * Metodo che mi restituisce quanti regali sono nella lista
     * @param p
     * @return
     */
    public int getRegaliRichiesti(Pianeta p){
        int regaliRichiesti = 0;
        for (Citta c : p.getListaCitta()){
            regaliRichiesti = c.getListaRegali().size();
        }
        return regaliRichiesti; //effettivamente viene aggiornato bene?  //NUOVA AGGIUNTA PER TASK3
    }

    /**
     * Metodo per ottenere il pianeta di una città
     * @return
     */
    public Pianeta getPianeta(){   //NUOVA AGGIUNTA PER TASK3
        return this.pianeta;
    }

    /**
     * Metodo che restituisce un booleano e controlla se una citta è connessa a un'altra
     * @param citta
     * @return
     */
    public boolean isConnectedTo(Citta citta){
        for (Collegamento c : listaCollegamenti){
            if (c.getCitta1().equals(this.nomeCitta) && c.getCitta2().equals(citta.getNomeCitta())){
                return true;
            }
        }
        return false;      //NUOVA AGGIUNTA PER TASK3
    }

    /**
     * Metodo che setta i regali richiesti
     * @param regali
     */
    public void setRegaliRichiesti(int regali){    //NUOVA AGGIUNTA PER TASK3
        this.regaliRichiesti = regali;
    }

    /**
     * Metodo che imposta lo statoVisita per le città
     * @param visitaEffettuata
     */
    public void impostaStatoVisita(boolean visitaEffettuata){
        this.statoVisita = visitaEffettuata;           //NUOVA AGGIUNTA TASK3; "VISITED" IN INGLESE
    }
}



