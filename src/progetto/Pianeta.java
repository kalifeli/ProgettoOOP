package progetto;

import java.util.ArrayList;
public class Pianeta {
    private String nomePianeta;
    private int regaliTotali; // regali del pianeta
    private ArrayList<Citta> listaCitta;

    /**
     * Costruttore della classe Pianeta che è descritto univocamente da un nome e da il numero dei regali totali
     * @param nomePianeta nome univoco per il pianeta
     */
    public Pianeta(String nomePianeta){
        this.nomePianeta = nomePianeta;
        this.listaCitta = new ArrayList<>();
    }
    public String getNomePianeta(){
        return nomePianeta;
    }
    public int getRegaliTotali(){
        return regaliTotali;
    }
    public ArrayList<Citta> getListaCitta(){
        return listaCitta;
    }

}
