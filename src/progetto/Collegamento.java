package progetto;

/**
 * Rappresenta un collegamento tra due città dello stesso pianeta, descritto anche da un tempo di percorrenza
 * @author Alessandro Feliziani
 * @author Luca Severini
 */
public class Collegamento {
    private Citta citta1;
    private Citta citta2;
    private final int tempo;

    /**
     * Un collegamento ha una città di partenza e una città di arrivo e un costo.
     * @param citta1 città di partenza
     * @param citta2 città di arrivo
     * @param tempo costo del collegamento tra le due città
     */
    public Collegamento(Citta citta1,Citta citta2, int tempo) {
        this.citta1 = citta1;
        this.citta2 = citta2;
        this.tempo = tempo;
    }

    /**
     * Metodo di accesso alla variabile di esemplare citta1.
     * @return un oggetto Citta rappresentante la città di partenza
     */
    public Citta getCitta1(){return citta1;}

    /**
     * Metodo di accesso alla variabile di esemplare citta2.
     * @return un oggetto Citta rappresentante la città di arrivo
     */
    public Citta getCitta2() {return citta2;}

    /**
     * Metodo di accesso alla variabile di esemplare tempo.
     * @return un intero rappresentante il costo del collegamento tra le due città
     */
    public int getTempo() {return tempo;}

    /**
     * Metodo modificatore per la citta2.
     * @param citta2 città di arrivo nel collegamento
     */
    public void setCitta2(Citta citta2) {this.citta2 = citta2;}

}

