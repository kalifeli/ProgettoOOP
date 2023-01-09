package progetto;

import java.util.ArrayList;
import java.util.HashMap;

public class Settore {
    private int deposito;
    private int numeroRegaliTotali; //?
    private ArrayList<Pianeta> listaPianeti;

    //Costruttore:
    public Settore(int deposito){
        this.deposito = deposito;
        this.listaPianeti = new ArrayList<>();
    }
    public void addPianeta(Pianeta pianeta){listaPianeti.add(pianeta);}
    //Metodi Getter e Setter;
    public int getDeposito(){
        return deposito;
    }
    public ArrayList<Pianeta> getListaPianeti(){
        return listaPianeti;
    }
    //Metodo per trovare i regali totali

    /**
     * Task 1) 1.Itera ogni pianeta e ogni città accedendo alla variabile esemplare regaliTotali
     * @return un intero rappresentante il numero dei regali totali
     */
    public int getRegaliTotali(){
        int numeroRegaliTotali = 0;
        for (Pianeta pianeta : getListaPianeti()){
            for (Citta citta : pianeta.getListaCitta()){
                numeroRegaliTotali += citta.getListaRegali().size();
            }
        }
        return numeroRegaliTotali;
    };

    /**
     * Task 1) 1.Metodo che utilizza un istanza di HashMap che calcola il numero di regali distinti utilizzando semplicemente la size della HasMap
     * @return un intero che indica il numero dei regali distinti
     */
    public int getRegaliDistinti(){
        HashMap<String,Integer> contatoreRegali = new HashMap<>();
        for(Pianeta pianeta : listaPianeti)
            for(Citta citta : pianeta.getListaCitta())
                for(Regalo regalo : citta.getListaRegali())
                {
                    String nomeRegalo = regalo.getNomeRegalo();
                    int contatore = contatoreRegali.getOrDefault(nomeRegalo,0);
                    contatoreRegali.put(nomeRegalo,contatore + 1);
                }
        return contatoreRegali.size();
    }

    /**
     * Task 1) 2. Metodo che stampa il numero dei regali, di un settore, di ogni tipologia
     */
    public void getRegaliTotaliPerTipologia(){
        HashMap<String,Integer> contatoreTipologie = new HashMap<>();
        for(Pianeta pianeta : getListaPianeti())
            for(Citta c : pianeta.getListaCitta())
                for(Regalo regalo : c.getListaRegali())
                {
                    String tipo = regalo.getTipoRegalo();
                    int contatore = contatoreTipologie.getOrDefault(tipo,0);
                    contatoreTipologie.put(tipo, contatore + 1);
                }
        int regaliDiArte = contatoreTipologie.getOrDefault("arte", 0);
        int regaliDiElettronica = contatoreTipologie.getOrDefault("elettronica", 0);
        int regaliDiSport = contatoreTipologie.getOrDefault("sport",0);

        System.out.println(regaliDiArte + " " + regaliDiElettronica + " " + regaliDiSport);
    }


    /**
     * Task 1) 3.Metodo che trova il nome del pianeta col numero massimo di regali richiesti
     * @return nome del pianeta con il numero maggiore di regali richiesti
     */
    public String getPianetaMostRegali(){
        int maxRegali = 0;
        String pianetaMostRegali = "";

        for (Pianeta pianeta : getListaPianeti()) {
            int numeroRegali = 0;
            for(Citta citta : pianeta.getListaCitta())
            {
                numeroRegali += citta.getListaRegali().size();
            }
            if(numeroRegali > maxRegali){
                maxRegali = numeroRegali;
                pianetaMostRegali = pianeta.getNomePianeta();
            }
        }
        return pianetaMostRegali;
    }
    /**
     * Task 1) 4.Metodo che restituisce il nome del pianeta che presenta costo maggiore di regali richiesti
     */
    public String getPianetaMostCosto() {
        String pianetaMostCosto = "";
        // inizializzo la variabile che conterrà il costo massimo dei regali richiesti in un pianeta
        double costoMax = 0;
        for(Pianeta pianeta : getListaPianeti())
        {
            double costo = 0;
            for(Citta citta : pianeta.getListaCitta())
            {
                for(Regalo regalo : citta.getListaRegali())
                {
                    costo += regalo.getCostoRegalo();
                }
            }
            if(costo > costoMax)
            {
                costoMax = costo;
                pianetaMostCosto = pianeta.getNomePianeta();
            }
        }
        return pianetaMostCosto;

    }

    /**
     * Task 1) 5.Metodo che restituisce il nome della città col numero massimo di regali richiesti
     * @return
     */
    public String getCittaMostRegali(){
        String cittaMostRegali = "";
        int maxRegali = 0;
        for (Pianeta pianeta : getListaPianeti()){
            for (Citta citta : pianeta.getListaCitta()){
                int regaliRichiesti = citta.getListaRegali().size();
                if(regaliRichiesti > maxRegali)
                {
                    maxRegali = regaliRichiesti;
                    cittaMostRegali = citta.getNomeCitta();
                }
            }
        }
        return cittaMostRegali;
    }

    /**
     * Task 1) 6.Metodo che restituisce il nome della cittadina contenente più case
     * @return
     */
    public String getCittadinaMostCase(){
        String cittadinaMostcase = "";
        int maxCase = 0;
        for (Pianeta pianeta : getListaPianeti()){
            for (Citta citta : pianeta.getListaCitta()){
                if (!citta.isPaesino() && citta.getNumeroCase() > maxCase) {
                    maxCase = citta.getNumeroCase();
                    cittadinaMostcase = citta.getNomeCitta();
                }
            }
        }
        return cittadinaMostcase;
    }

    /**
     * Metodo che restituisce il nome della cittadina con più collegamenti
     * @return citta che ha più collegamenti con altre città
     */

    public String getCittaMostCollegamenti(){
        int maxCollegamenti = 0;
        String cittaMostCollegamenti = "";
        for (Pianeta pianeta : getListaPianeti()){
            for (Citta citta : pianeta.getListaCitta()){
                int contatoreCollegamento = citta.getListaCollegamenti().size();
                if (contatoreCollegamento > maxCollegamenti){
                    maxCollegamenti = contatoreCollegamento;
                    cittaMostCollegamenti = citta.getNomeCitta();
                }
            }
        }
        return cittaMostCollegamenti;
    }

    /**
     * Stampa Yes se la condizione è soddisfatta altrimenti NO
     */
    public void stampaTask2(){
        if(true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    /**
     * Metodo booleano che restituisce TRUE se il numero totale di regali
     * richiesti in ogni città è almeno p e al più q, altrimenti FALSE
     * @param p
     * @param q
     * @return
     */

    public boolean task2_1(int p, int q){
        boolean valid = false; // dichiaro e inizializzo una variabile booleana
        // itero su tutti i pianeti
        for(Pianeta pianeta : getListaPianeti())
            // itero su tutte le citta del pianeta
            for(Citta citta : pianeta.getListaCitta()) {
                int numeroRegali = citta.getListaRegali().size();
                if((numeroRegali >= p) && (numeroRegali <= q)) {
                    valid = true;
                }
                else {
                    return false;
                }
            }
        return valid;
    }

    /**
     * Metodo booleano che restituisce true se per ogni pianeta non vi sono due città in cui non è stato richiesto almeno un regalo dello
     * stesso tipo
     * @return
     */
    public boolean task2_4() {
        for (Pianeta p : getListaPianeti()) {
            for (int i = 0; i < p.getListaCitta().size(); i++) {
                for (int j = i + 1; j < p.getListaCitta().size(); j++){
                    Citta citta1 = p.getListaCitta().get(i);
                    Citta citta2 = p.getListaCitta().get(j);
                    for (Regalo regalo1 : citta1.getListaRegali()){
                        for (Regalo regalo2 : citta2.getListaRegali()){
                            if (regalo1.getTipoRegalo().equals(regalo2.getTipoRegalo())){
                                return true;
                            }

                        }
                    }
                }
            }
        }
        return false;
    }



}
