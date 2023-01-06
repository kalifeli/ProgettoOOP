package progetto;

import java.util.List;
import java.util.Set;

public class Pianeta {
    private String nomePianeta;
    private List<Citta> lecitta; /*citta o leCitta?*/
    private int regaliTotali; //sono i totali o i richiesti?
    private int regaliDistinti; //questi sono complicati, devo vedere meglio

    //Costruttore:
    public Pianeta(String nomePianeta, List<Citta> lecitta, int regaliTotali /*regali distinti?*/){
        this.nomePianeta = nomePianeta;
        this.lecitta = lecitta;
        this.regaliTotali = regaliTotali;
    }
    public String getNomePianeta(){
        return nomePianeta;
    }
    public void setNomePianeta(String nomePianeta){
        this.nomePianeta = nomePianeta;
    }
    public int getRegaliTotali(){
        return regaliTotali;
    }
    public List<Citta> getLecitta(){
        return lecitta;
    }


    //Ancora da rivedere
}
