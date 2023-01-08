package progetto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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
        HashMap<Regalo,Integer> contatoreRegali = new HashMap<>();
        for(Pianeta pianeta : listaPianeti)
            for(Citta c : pianeta.getListaCitta())
                for(Regalo regalo : c.getListaRegali())
                {
                    int contatore = contatoreRegali.getOrDefault(regalo,0);
                    contatoreRegali.put(regalo,contatore + 1);
                }
        return contatoreRegali.size();
    }

    //2)Metodo numero regali totali richiesti per ogni tipologia (salto per il momento)


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
    /*4)Metodo che restituisce il nome del pianeta col costo più alto di regali richiesti
    public String getPianetaMostCosto(){
        String pianetaMostCosto = "";
        int maxCosto = 0;
        //devo ancora implementare la classe per calcolare il costo.
    }*/
    //volendo questi metodi sarebbero potuti essere implementati in altre classi. Per implementarli nella classe settore è importante ricordarsi di passare nei parametri dei metodi "Settore"

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
                    cittaMostRegali = String.valueOf(citta); //il compilatore mi ha detto di wrapparlo. Questo punto lo devo capire meglio
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
                    cittadinaMostcase = String.valueOf(citta); //compilatore mi ha detto di wrappare
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

    //Mancano alcuni metodi della task 1. La task 2 non è stata minimamente toccata.
    //Ancora devo realizzare un metodo per calcolare il costo dei regali per ogni pianeta
    //Ancora non ho realizzato il metodo per trovare il numero di regali totali richiesti per ogni tipologia

    /**
     * Stampa Yes se la condizione è soddisfatta altrimenti NO
     */
    public void stampaTask2(){
        if(true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public boolean task2_1(int p, int q){
        boolean valid = true; // dichiaro e inizializzo una variabile booleana
        // itero su tutti i pianeti
        for(Pianeta pianeta : getListaPianeti())
            // itero su tutte le citta del pianeta
            for(Citta c : pianeta.getListaCitta()) {
                if(valid = false)
                    return valid;
                // controlla il numero delle caso con gli indici presi in input
                if (c.getNumeroCase() >= p && c.getNumeroCase() <= q)
                    valid = true;
                else
                    valid = false;
            }
        return valid;
    }



}
