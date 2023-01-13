package progetto;

import java.util.ArrayList;
public class Pianeta {
    private String nomePianeta;
    private int numeroCitta;
    private ArrayList<Citta> listaCitta;
    private boolean statoVisita; // non essendo stata inizializzta per default viene messa a false;

    /**
     * Costruttore della classe Pianeta che è descritto univocamente da un nome e da il numero dei regali totali
     * @param nomePianeta nome univoco per il pianeta
     */
    public Pianeta(String nomePianeta,int numeroCitta){
        this.nomePianeta = nomePianeta;
        this.numeroCitta = numeroCitta;
        this.listaCitta = new ArrayList<>();
    }
    public String getNomePianeta(){
        return nomePianeta;
    }
    public int getNumeroCitta() {return numeroCitta;}
    public ArrayList<Citta> getListaCitta(){
        return listaCitta;
    }

    public void addCitta(Citta citta){listaCitta.add(citta);}
    /**
     * metodo che imposta lo statoVisita a visita effettuata
     * @param statoVisita
     */
    public void impostaStatoVisita(boolean statoVisita){
        this.statoVisita = statoVisita;
    }

    /**
     * Metodo che ritorna lo statoVisita
     * @return
     */
    public boolean getStatoVisita(){
        return statoVisita;
    }

}
