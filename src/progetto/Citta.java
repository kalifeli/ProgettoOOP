package progetto;
import java.util.ArrayList;
public class Citta {
    private String nomeCitta;
    private int numeroCase;
    private ArrayList<Collegamento> collegamenti;
    private ArrayList<Regalo> regali;
    //Costruttore
    public Citta (String nomeCitta, int numeroCase, ArrayList<Collegamento> collegamenti, ArrayList<Regalo> regali){
        this.nomeCitta = nomeCitta;
        this.numeroCase = numeroCase;
        this.collegamenti = collegamenti; /*??? why new?*/
        this.regali = regali;
    }
    //Metodi getter e setter
    public String getNomeCitta(){
        return nomeCitta;
    }
    public void setNomeCitta(String nomeCitta){
        this.nomeCitta = nomeCitta;
    }
    public ArrayList<Collegamento> getCollegamenti(){
        return collegamenti;
    }
    //metodo per aggiungere un collegamento bidirezionale
    public void addCollegamento(Citta citta, int costo){
        collegamenti.add(new Collegamento(citta, costo)); /*BIDIREZIONALITà*/
        citta.collegamenti.add(new Collegamento(this, costo)); /*BIDIREZIONALITà*/
    }
    public int getNumeroCase(){
        return numeroCase;
    }
    public void setNumeroCase(int numeroCase){
        this.numeroCase = numeroCase;
    }
    public ArrayList<Regalo> getRegali(){
        return regali;
    }
    public void setRegali(ArrayList<Regalo> regali){
        this.regali = regali;
    }
    //Metodi per categorizzare le città;
    public boolean isPaesino(){
        return numeroCase <= 10;
    }
    public boolean isCittadina(){
        return numeroCase > 10;
    }/*Codice utile per categorizzazione di una città:
    f(citta.getNumeroCase <= 10){
        citta.setIsPeasino(true);
    }
    else{
    citta.setIsPaesino(false);
    } */

}
