package progetto;

public class Collegamento {
        private Citta destinazione;
        private int tempo;

        public Collegamento(Citta destinazione, int tempo) {
            this.destinazione = destinazione;
            this.tempo = tempo;
        }

        public Citta getDestinazione() {
            return destinazione;
        }

        public int getTempo() {
            return tempo;
        }
}
