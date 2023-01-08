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
        for(Pianeta pianeta : getListaPianeti())
            for(Citta c : pianeta.getListaCitta())
                for(Regalo regalo : c.getListaRegali())
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
            int numeroRegali = pianeta.getRegaliTotali();
            if (numeroRegali > maxRegali) {
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
        double costoMax = getListaPianeti().get(0).getCostoRegaliPianeta();
        for(int i = 1; i < getListaPianeti().size(); ++i )
        {
            double costoRegaliPianeta = getListaPianeti().get(i).getCostoRegaliPianeta();
            if(costoRegaliPianeta > costoMax) {
                costoMax = costoRegaliPianeta;
                pianetaMostCosto = getListaPianeti().get(i).getNomePianeta();
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
                int regali = citta.getListaRegali().size();
                if (regali > maxRegali) {
                    //cittaMostRegali = String.valueOf(citta); //il compilatore mi ha detto di wrapparlo. Questo punto lo devo capire meglio
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
                    //cittadinaMostcase = String.valueOf(citta); //compilatore mi ha detto di wrappare
                    maxCase = citta.getNumeroCase();
                }
            }
        }
        return cittadinaMostcase;
    }
    //7)Metodo che restituisce il nome della cittadina con più collegamenti
    public String getCittadinaMostCollegamenti(){
        String cittadinaMostCollegamenti = "";
        int maxCollegamenti = 0;
        for (Pianeta pianeta : getListaPianeti()){
            for (Citta citta : pianeta.getListaCitta()){
                if (citta.getListaCollegamenti().size() > maxCollegamenti){
                    cittadinaMostCollegamenti = String.valueOf(citta); //compilatore mi ha detto di wrappare
                }
            }
        }
        return cittadinaMostCollegamenti;
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



}
