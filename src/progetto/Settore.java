package progetto;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Rappresenta il settore Astrale in cui il nostro Babbo Natale Intergalattico viaggia nel tentativo disperato di consegnare
 * tutti i regali.
 * @author Alessandro Feliziani
 * @author Luca Severini
 */
public class Settore {
    private int deposito;
    private final ArrayList<Pianeta> listaPianeti;

    /**
     * Costruttore vuoto che inizializza il deposito del settore a 0.
     */
    public Settore(){
        this.deposito = 0;
        this.listaPianeti = new ArrayList<>();
    }

    /**
     * Metodo modificatore del deposito di Babbo Natale.
     * @param deposito un intero rappresentante il numero di regali sulla slitta di Babbo Natale
     */
    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }

    /**
     * Metodo che aggiunge un pianeta alla lista dei pianeti di un settore astrale.
     * @param pianeta oggetto di tipo Pianeta da aggiungere nella lista dei pianeti
     */
    public void addPianeta(Pianeta pianeta){listaPianeti.add(pianeta);}

    /**
     * Metodo di accesso alla variabile di esemplare deposito.
     * @return un intero rappresentante i regali sulla slitta di Babbo Natale
     */
    public int getDeposito(){
        return deposito;
    }

    /**
     * Metodo che fornisce l'accesso alla lista dei pianeti di un settore astrale.
     * @return un ArrayList di tipo Pianeta contenente tutti i pianeti di un settore astrale
     */
    public ArrayList<Pianeta> getListaPianeti(){
        return listaPianeti;
    }

    // TASK 1
    /**
     * Task 1) 1.Itera ogni pianeta e ogni città accedendo alla variabile esemplare regaliTotali.
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
    }

    /**
     * Task 1) 1.Metodo che utilizza un istanza di HashMap che calcola il numero di regali distinti utilizzando la size della HashMap.
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
     * Task 1) 2. Metodo che stampa il numero dei regali, di un settore, di ogni tipologia.
     */
    public void task1_2(){
        int regaliArte = 0;
        int regaliElettronica = 0;
        int regaliSport = 0;

        for(Pianeta pianeta : getListaPianeti()){
            for(Citta citta : pianeta.getListaCitta())
            {
                for(Regalo regalo : citta.getListaRegali()) {
                    switch (regalo.getTipoRegalo()) {
                        case "arte" -> regaliArte++;
                        case "elettronica" -> regaliElettronica++;
                        case "sport" -> regaliSport++;
                    }
                }
            }
        }
        System.out.println(regaliArte + " " + regaliElettronica + " " + regaliSport);
    }


    /**
     * Task 1) 3.Metodo che trova il nome del pianeta col numero massimo di regali richiesti.
     * @return il primo nome del pianeta con il numero maggiore di regali richiesti in ordine lessicografico crescente,
     * altrimenti una stringa vuota
     */
    public String getPianetaMostRegali(){
        // una lista in cui introduco nomi di pianeta che hanno lo stesso numero di regali massimi
        ArrayList<String> nomiValidi = new ArrayList<>();
        int maxRegali = 0;
        String pianetaMostRegali;

        for (Pianeta pianeta : getListaPianeti()) {
            int numeroRegali = 0;
            for(Citta citta : pianeta.getListaCitta())
            {
                numeroRegali += citta.getListaRegali().size();
            }
            if(numeroRegali > maxRegali){
                maxRegali = numeroRegali;
                pianetaMostRegali = pianeta.getNomePianeta();
                nomiValidi.clear();
                nomiValidi.add(pianetaMostRegali);
            } else if (numeroRegali == maxRegali) {
                nomiValidi.add(pianeta.getNomePianeta());
            }
        }
        if(nomiValidi.size() > 0){
            String primoPerOrdine = nomiValidi.get(0);
            for(int i = 1; i < nomiValidi.size(); ++i){
                if(nomiValidi.get(i).compareTo(primoPerOrdine) < 0)
                {
                    primoPerOrdine = nomiValidi.get(i);
                }
            }
            return primoPerOrdine;
        }
        return "";
    }
    /**
     * Task 1) 4.Metodo che restituisce il nome del pianeta che presenta costo maggiore di regali richiesti.
     * @return il nome del primo pianeta con il costo maggiore di regali richiesti in ordine lessicografico crescente,
     * altrimenti una stringa vuota
     */
    public String getPianetaMostCosto() {
        ArrayList<String> nomiValidi = new ArrayList<>();
        String pianetaMostCosto;
        // inizializzo la variabile che conterrà il costo massimo dei regali richiesti in un pianeta
        int costoMax = 0;

        for(Pianeta pianeta : getListaPianeti())
        {  // calcolo costoMax di ogni pianeta
            int costo = 0;
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
                nomiValidi.clear();
                nomiValidi.add(pianetaMostCosto);
            }else if(costo == costoMax){
                nomiValidi.add(pianeta.getNomePianeta());
            }
        }
        if(nomiValidi.size() > 0){
            String primoInOrdine = nomiValidi.get(0);
            for(int i = 1; i < nomiValidi.size(); ++i){
                if(nomiValidi.get(i).compareTo(primoInOrdine) < 0)
                    primoInOrdine = nomiValidi.get(i);
            }
            return primoInOrdine;
        }
        return "";

    }

    /**
     * Task 1) 5.Metodo che restituisce il nome della città col numero massimo di regali richiesti.
     * @return Stringa rappresentante la prima citta con il numero maggiore di regali richiesti in ordine lessicografico
     * crescente, altrimenti una stringa nulla
     */
    public String getCittaMostRegali(){
        ArrayList<String> nomiValidi = new ArrayList<>();
        String cittaMostRegali;
        int maxRegali = 0;
        for (Pianeta pianeta : getListaPianeti()){
            for (Citta citta : pianeta.getListaCitta()){
                int regaliRichiesti = citta.getListaRegali().size();
                if(regaliRichiesti > maxRegali)
                {
                    maxRegali = regaliRichiesti;
                    cittaMostRegali = citta.getNomeCitta();
                    nomiValidi.clear();
                    nomiValidi.add(cittaMostRegali);
                }else if(regaliRichiesti == maxRegali){
                    nomiValidi.add(citta.getNomeCitta());
                }
            }
        }
        if(nomiValidi.size() > 0)
        {
            String primoNomeInOrdine = nomiValidi.get(0); // inizializzo la variabile string con il primo nome della lista nomiValidi
            for(int i = 1; i < nomiValidi.size(); ++i){
                if(nomiValidi.get(i).compareTo(primoNomeInOrdine) < 0){
                    primoNomeInOrdine = nomiValidi.get(i);
                }
            }
            return primoNomeInOrdine;
        }
        return "";
    }

    /**
     * Task 1) 6.Metodo che restituisce il nome della cittadina contenente più case.
     * @return una Stringa rappresentante il nome della prima cittadina con il numero maggiore di case in ordine lessico
     * grafico crescente, altrimenti una stringa vuota
     */
    public String getCittadinaMostCase(){
        ArrayList<String> nomiValidi = new ArrayList<>();
        String cittadinaMostcase;
        int maxCase = 0;
        for (Pianeta pianeta : getListaPianeti()){
            for (Citta citta : pianeta.getListaCitta()){
                if (citta.isCittadina() && citta.getNumeroCase() > maxCase) {
                    maxCase = citta.getNumeroCase();
                    cittadinaMostcase = citta.getNomeCitta();
                    nomiValidi.clear();
                    nomiValidi.add(cittadinaMostcase);
                } else if (!citta.isCittadina() && citta.getNumeroCase() == maxCase) {
                    nomiValidi.add(citta.getNomeCitta());
                }
            }
        }
        if(nomiValidi.size() > 0){
            String primaPerOrdine = nomiValidi.get(0);
            for(int i = 1; i < nomiValidi.size(); ++i){
                if(nomiValidi.get(i).compareTo(primaPerOrdine) < 0)
                    primaPerOrdine = nomiValidi.get(i);
            }
            return primaPerOrdine;
        }
        return "";
    }

    /**
     * Task 1) 7.Metodo che restituisce il nome della citta con più collegamenti.
     * @return una stringa rappresentante la prima citta che ha più collegamenti con altre città in ordine lessicografico crescente,
     * altrimenti una stringa vuota.
     */

    public String getCittaMostCollegamenti(){
        ArrayList<String> nomiValidi = new ArrayList<>();
        int maxCollegamenti = 0;
        String cittaMostCollegamenti;
        for (Pianeta pianeta : getListaPianeti()){
            for (Citta citta : pianeta.getListaCitta()){
                int contatoreCollegamento = citta.getListaCollegamenti().size();
                if (contatoreCollegamento > maxCollegamenti){
                    maxCollegamenti = contatoreCollegamento;
                    cittaMostCollegamenti = citta.getNomeCitta();
                    nomiValidi.clear();
                    nomiValidi.add(cittaMostCollegamenti);
                } else if (contatoreCollegamento == maxCollegamenti) {
                    nomiValidi.add(citta.getNomeCitta());
                }
            }
        }
        if(nomiValidi.size() > 0){
            String primaPerOrdine = nomiValidi.get(0);
            for(int i = 1; i < nomiValidi.size(); ++i){
                if(nomiValidi.get(i).compareTo(primaPerOrdine) < 0)
                    primaPerOrdine = nomiValidi.get(i);
            }
            return primaPerOrdine;
        }
        return "";
    }

    //TASK 2

    /**
     * Metodo booleano che restituisce true se il numero totale di regali
     * richiesti in ogni città è almeno p e al più q, altrimenti false.
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
     * il costo massimo di collegamenti è uguale anche a quello di altre città nel pianeta.
     * @return true se vi è una sola città la cui somma del costo dei suoi collegamenti è il massimo
     * in quel pianeta, altrimenti false
     */

    public boolean task2_2(){
        for(Pianeta pianeta : getListaPianeti()) {
            int costoMax = 0;
            for (Citta citta : pianeta.getListaCitta()) {
                int costo = citta.getCostoCollegamentiCitta();
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
     * Metodo che torna true se per ogni pianeta, non vi sono tre città collegate tra loro in cui sono stati richiesti lo stesso
     * numero di regali di tipo arte ed elettronica.
     * @return true se per ogni pianeta, non vi sono tre città collegate tra loro in cui sono stati richiesti lo stesso
     * numero di regali di tipo arte ed elettronica
     */
    public boolean task2_3(){
        boolean valido = true;
        for(Pianeta pianeta : getListaPianeti()){
            for(Citta citta : pianeta.getListaCitta()){
                for(Collegamento collegamento1 : citta.getListaCollegamenti()){
                    for(Collegamento collegamento2 : collegamento1.getCitta2().getListaCollegamenti()){

                        if(citta.esistenzaCollegamento(collegamento2.getCitta2(),collegamento1.getCitta1())){
                            int[] regaliArte = new int[3];
                            int[] regaliElettronica = new int[3];

                            for(Regalo regalo : citta.getListaRegali()){
                                // riservo il campo 0 per città c1
                                if(regalo.getTipoRegalo().equals("arte"))
                                    regaliArte[0] += 1;
                                if(regalo.getTipoRegalo().equals("elettronica"))
                                    regaliElettronica[0] += 1;
                            }
                            for(Regalo regalo : collegamento1.getCitta2().getListaRegali()){
                                // riservo il campo 1 per città c2
                                if(regalo.getTipoRegalo().equals("arte"))
                                    regaliArte[1] += 1;
                                if(regalo.getTipoRegalo().equals("elettronica"))
                                    regaliElettronica[1] += 1;
                            }
                            for(Regalo regalo : collegamento2.getCitta2().getListaRegali()){
                                // riservo il campo 2 per città c3
                                if(regalo.getTipoRegalo().equals("arte"))
                                    regaliArte[2] += 1;
                                if(regalo.getTipoRegalo().equals("elettronica"))
                                    regaliElettronica[2] += 1;
                            }

                            if(regaliArte[0] == regaliArte[1] && regaliArte[0] == regaliArte[2]){

                                valido = regaliElettronica[0] != regaliElettronica[1] || regaliElettronica[0] != regaliElettronica[2];
                            }else
                                valido = true;

                        }
                    }
                }
            }
        }
        return valido;
    }


    /**
     * Metodo booleano che restituisce true se per ogni pianeta non vi sono due città in cui non è stato richiesto almeno un regalo dello
     * stesso tipo.
     * @return true se per ogni pianeta non vi sono due città in cui non è stato richiesto almeno un regalo dello
     * stesso tipo, altrimenti false
     */
    public boolean task2_4() {
        boolean valido = false;
        for (Pianeta p : getListaPianeti()) {
            for (int i = 0; i < p.getListaCitta().size(); i++) {
                Citta citta1 = p.getListaCitta().get(i);
                //System.out.print(citta1.getNomeCitta() + " -> ");
                for (int j = 0; j < p.getListaCitta().size(); j++){
                    Citta citta2 = p.getListaCitta().get(j);
                    if(citta1.equals(citta2))
                        continue;
                    //System.out.print(citta2.getNomeCitta() + " ");
                    int contatore = 0;
                    for (Regalo regalo1 : citta1.getListaRegali()){
                        for (Regalo regalo2 : citta2.getListaRegali()){
                            if (regalo1.getTipoRegalo().equals(regalo2.getTipoRegalo())){
                                contatore++;
                            }
                        }
                    }
                    //System.out.print("( " + contatore + " )");
                    if(contatore > 0){
                        valido = true;
                    }else
                        return false;
                }
                //System.out.println();
            }
        }
        return valido;
    }

}
