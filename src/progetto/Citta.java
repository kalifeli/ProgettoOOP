package progetto;
import java.util.ArrayList;
import java.util.List;
public class Citta {
    private String nomeCitta;
    private int numeroCase;
    private List<Collegamento> collegamenti;
    private List<Regalo> regali;
    //Costruttore
    public Citta (String nomeCitta, int numeroCase, List<Collegamento> collegamenti, List<Regalo> regali){
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
    public List<Collegamento> getCollegamenti(){
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
    public List<Regalo> getRegali(){
        return regali;
    }
    public void setRegali(List<Regalo> regali){
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
