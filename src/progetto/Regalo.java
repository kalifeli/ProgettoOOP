package progetto;

/**
 * Regalo richiesto da una città descritto da un nome, un costo e dalla sua tipologia.
 * @author AlessandroFeliziani
 * @author Luca Severini
 */
public class Regalo {
    private final String nomeRegalo;
    private final int costoRegalo;
    private final String tipoRegalo;

    /**
     * Un regalo ha un nome, un costo e una tipologia.
     * @param nomeRegalo nome del regalo richiesto
     * @param costoRegalo costo del regalo richiesto
     * @param tipoRegalo tipologia del regalo richiesto
     */
    public Regalo(String nomeRegalo, int costoRegalo, String tipoRegalo) {
        this.nomeRegalo = nomeRegalo;
        this.costoRegalo = costoRegalo;
        this.tipoRegalo = tipoRegalo;
    }

    /**
     * Metodo che accede alla variabile di esemplare nomeRegalo.
     * @return una stringa che rappresenta il nome del regalo
     */
    public String getNomeRegalo() {return nomeRegalo;}

    /**
     * Metodo di accesso alla variabile di esemplare costoRegalo.
     * @return un intero che rappresenta il costo del regalo
     */
    public int getCostoRegalo(){return costoRegalo;}

    /**
     * Metodo di accesso alla variabile di esemplare tipoRegalo.
     * @return una stringa rappresentante la tipologia del regalo
     */
    public String getTipoRegalo() {return tipoRegalo;}
}
