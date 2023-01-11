package progetto;

public class Collegamento {
    private Citta citta1;
    private Citta citta2;
    private int tempo;

    public Collegamento(Citta citta1,Citta citta2, int tempo) {
        this.citta1 = citta1;
        this.citta2 = citta2;
        this.tempo = tempo;
    }
    public Citta getCitta1(){return citta1;}
    public Citta getCitta2() {
            return citta2;
        }
    public int getTempo() {
        return tempo;
    }

    public void setCitta1(Citta citta1) {
        this.citta1 = citta1;
    }

    public void setCitta2(Citta citta2) {
        this.citta2 = citta2;
    }

}

