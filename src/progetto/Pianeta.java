package progetto;

import java.util.ArrayList;
public class Pianeta {
    private String nomePianeta;
    private int numeroCitta;
    private ArrayList<Citta> listaCitta;
    private boolean statoVisita;   //NUOVA AGGIUNTA PER TASK3; "ISVISITED" IN INGLESE

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
     * @param visitaEffettuata
     */
    public void impostaStatoVisita(boolean visitaEffettuata){
        this.statoVisita = visitaEffettuata;           //NUOVA AGGIUNTA TASK3; "VISITED" IN INGLESE
    }

    /**
     * Metodo che ritorna lo statoVisita
     * @return
     */
    public boolean getStatoVisita(){
        this.statoVisita = statoVisita;
        return statoVisita;
    }

}
