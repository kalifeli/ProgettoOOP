package progetto;

public class Collegamento {
    private String citta1;
    private String citta2;
    private int tempo;

    public Collegamento(String citta1,String citta2, int tempo) {
        this.citta1 = citta1;
        this.citta2 = citta2;
        this.tempo = tempo;
    }
    public String getCitta1(){return citta1;}
    public String getCitta2() {
            return citta2;
        }
    public int getTempo() {
        return tempo;
    }
}

