package progetto;

import java.util.ArrayList;

/**
 * Rappresenta un pianeta, appartenente al settore astrale, in cui Babbo Natale farà visita con la sua slitta Intergalattica
 * @author Alessandro Feliziani
 * @author Luca Severini
 */
public class Pianeta {
    private final String nomePianeta;
    private final int numeroCitta;
    private final ArrayList<Citta> listaCitta;
    private boolean statoVisita;

    /**
     * Costruttore della classe Pianeta che è descritto univocamente da un nome e dal numero dei regali totali
     * @param nomePianeta nome univoco per il pianeta
     */
    public Pianeta(String nomePianeta,int numeroCitta){
        this.nomePianeta = nomePianeta;
        this.numeroCitta = numeroCitta;
        this.listaCitta = new ArrayList<>();
    }

    /**
     * Metodo di accesso alla variabile di esemplare nomePianeta.
     * @return una stringa rappresentante il nome del pianeta
     */
    public String getNomePianeta(){
        return nomePianeta;
    }

    /**
     * Metodo di accesso alla variabile di esemplare numeroCitta.
     * @return un intero rappresentate il numero di città di un pianeta
     */
    public int getNumeroCitta() {return numeroCitta;}

    /**
     * Metodo che fornisce l'accesso alla lista delle città presenti in un pianeta.
     * @return un ArrayList di tipo Citta contenente tutte le città presenti in un pianeta
     */
    public ArrayList<Citta> getListaCitta(){return listaCitta;}

    /**
     * Aggiunge una città alla lista delle città di un pianeta.
     * @param citta oggetto Citta da inserire.
     */
    public void addCitta(Citta citta){listaCitta.add(citta);}

    /**
     * Imposta lo stato della visita di un pianeta
     * @param statoVisita booleano che indica se il pianeta è stato visitato
     */
    public void impostaStatoVisita(boolean statoVisita){
        this.statoVisita = statoVisita;
    }

    /**
     * Metodo che ritorna lo statoVisita
     * @return true se il pianeta è stato visitato, altrimenti false
     */
    public boolean getStatoVisita(){
        return statoVisita;
    }

}
