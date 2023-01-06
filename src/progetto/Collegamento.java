package progetto;

public class Collegamento {
        private Citta citta;
        private int costo;
        //Costruttore
        public Collegamento(Citta citta, int costo){
            this.citta = citta;
            this.costo = costo;
        }
        //Metodi getter e setter
        public Citta getCitta (){
            return citta;
        }
        public int getCosto(){
            return costo;
        }
        //commento prova push
}
