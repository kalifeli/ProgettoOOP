package progetto;

import java.util.ArrayList;
import java.util.HashMap;

public class Settore {
    private int deposito;
    private ArrayList<Pianeta> listaPianeti;

    //Costruttore:
    public Settore(){
        this.deposito = 0;
        this.listaPianeti = new ArrayList<>();
    }
    public Settore(int deposito){
        this.deposito = deposito;
        this.listaPianeti = new ArrayList<>();
    }

    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }

    public void addPianeta(Pianeta pianeta){listaPianeti.add(pianeta);}
    //Metodi Getter e Setter;

    public int getDeposito(){
        return deposito;
    }
    public ArrayList<Pianeta> getListaPianeti(){
        return listaPianeti;
    }
    // TASK 1

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
        for(Pianeta pianeta : getListaPianeti())
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
     * Per i quesiti da 2 a 7, nel caso in cui vi siano più nomi validi (es, due pianeti con lo stesso numero
     * massimo), restituire il primo in ordine lessicografico crescente. La risposta ad ogni quesito sta su di
     * una singola riga. Se non vi è una risposta per un quesito, stampare una riga vuota.
     */

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
    //TASK 2

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
     * @param p minimo di regali richiesti in ogni citta
     * @param q massimo di regali richiesti in ogni citta
     * @return true se il numero dei regali richiesti in ogni città è almeno p e al più q, altrimenti false
     */
    public boolean task2_1(int p, int q){
        boolean valid = false; // dichiaro e inizializzo una variabile booleana
        // itero su tutti i pianeti
        for(Pianeta pianeta : getListaPianeti())
            // itero su tutte le citta del pianeta
            for(Citta citta : pianeta.getListaCitta()) {
                int numeroRegaliRichiesti = citta.getListaRegali().size();
                if((numeroRegaliRichiesti >= p) && (numeroRegaliRichiesti <= q)) {
                    valid = true;
                }
                else {
                    return false;
                }
            }
        return valid;
    }
    /**
     * Calcola il costo massimo dei collegamenti di una città in ogni pianeta verificando, tramite un contatore, se il
     * il costo massimo di collegamenti è uguale anche a quello di altre città nel pianeta
     * @return true se vi è una sola città la cui somma del costo dei suoi collegamenti è il massimo
     * in quel pianeta, altrimenti false
     */

    public boolean task2_2(){
        for(Pianeta pianeta : getListaPianeti()) {
            double costoMax = 0;
            for (Citta citta : pianeta.getListaCitta()) {
                double costo = 0;
                costo += citta.getCostoCollegamentiCitta();
                if(costo > costoMax)
                    costoMax = costo;
            }
            int contatore = 0;
            for(Citta citta : pianeta.getListaCitta()){
                if(citta.getCostoCollegamentiCitta() == costoMax)
                    contatore++;
            }
            if(contatore > 1)
            {
                return false;
            }
        }
        return true;
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

    /**
     * c1-c2-c4
     * se c'è un collegamento di tre citta
     *      confronta i regali richiesti di tipologia arte della prima citta con la seconda e la terza
     *      se il numero di regali di tipologia arte nelle tre città è uguale
     *          cofronta i regali richiesti di tipologia elettronica della prima città con la seconda e la terza
     *          se il numero di regali richiesti di tipologia elettronica è uguale per le tre citta
     *              return false
     * return true;
     *
     *
     * c1 = arte = 1, elettronica = 2, sport = 1
     * c2 = arte = 3, elettronica = 4, sport = 2
     * c4 = arte = 8, elettronica = 12, sport = 3
     *
     * FALSE
     * TRUE
     *
     *
     */










}
