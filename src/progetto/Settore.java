package progetto;

import java.util.List;
import java.util.Set;

public class Settore {
    int deposito;
    private List<Pianeta> pianeti;
    private int numeroRegaliTotali;
    private Set<String> regaliDistinti; //(salto per ora perché non so come implementarlo)

    //Costruttore:
    public Settore(int deposito, List<Pianeta> pianeti,int numeroRegaliTotali, Set<String> regaliDistinti){
        this.deposito = deposito;
        this.pianeti = pianeti;
        this.numeroRegaliTotali = numeroRegaliTotali;
        this.regaliDistinti = regaliDistinti; //??? impostazione regaliDistinti corretta ???
    }
    public void addPianeta(Pianeta pianeta){
        pianeti.add(pianeta);
        //regaliTotali += pianeta.getRegaliTotali (da fare)
        //regaliDistinti += pianeta.getRegaliDistinti (da fare)
    }
    //Metodi Getter e Setter;
    public int getDeposito(){
        return deposito;
    }
    public void setDeposito(int deposito){
        this.deposito = deposito;
    }
    public List<Pianeta> getPianeti(){
        return pianeti;
    }
    //Metodo per trovare i regali totali
    public int getRegaliTotali(Settore settore){
        int numeroRegaliTotali = 0;
        for (Pianeta pianeta : settore.getPianeti()){
            for (Citta citta : pianeta.getLecitta()){
                numeroRegaliTotali += citta.getRegali().size();
            }
        }
        return numeroRegaliTotali;
    };
    //1)Metodo regali distinti (salto per ora perché non so bene come funziona)

    //2)Metodo numero regali totali richiesti per ogni tipologia (salto per il momento)

    //3)Metodo che trova il nome del pianeta col numero massimo di regali richiesti
    public String getPianetaMostRegali(Settore settore){
        int maxRegali = 0;
        String pianetaMostRegali = "";
        for (Pianeta pianeta : settore.getPianeti()) {
            int numeroRegali = pianeta.getRegaliTotali(); //sono i totali o i richiesti? CAREFUL Luca

            if (numeroRegaliTotali > maxRegali) {
                maxRegali = numeroRegaliTotali;
                pianetaMostRegali = pianeta.getNomePianeta();
            }
        }
        return pianetaMostRegali;
    }
    //4)Metodo che restituisce il nome del pianeta col costo più alto di regali richiesti
    public String getPianetaMostCosto(Settore settore){
        String pianetaMostCosto = "";
        int maxCosto = 0;
        //devo ancora implementare la classe per calcolare il costo
    }
    //volendo questi metodi sarebbero potuti essere implementati in altre classi. Per implementarli nella classe settore è importante ricordarsi di passare nei parametri dei metodi "Settore"
    //5)Metodo che restituisce il nome della città col numero massimo di regali richiesti
    public String getCittaMostRegali(Settore settore){
        String cittaMostRegali = "";
        int maxRegali = 0;
        for (Pianeta pianeta : settore.getPianeti()){
            for (Citta citta : pianeta.getLecitta()){
                int regali = citta.getRegali().size();
                if (regali > maxRegali) {
                    cittaMostRegali = String.valueOf(citta); //il compilatore mi ha detto di wrapparlo. Questo punto lo devo capire meglio
                }
            }
        }
        return cittaMostRegali;
    }
    //6)Metodo che restituisce il nome della cittadina contenente più case
    public String getCittadinaMostCase(Settore settore){
        String cittadinaMostcase = "";
        int maxCase = 0;
        for (Pianeta pianeta : settore.getPianeti()){
            for (Citta citta : pianeta.getLecitta()){
                if (citta.isCittadina() && citta.getNumeroCase() > maxCase) {
                    cittadinaMostcase = String.valueOf(citta); //compilatore mi ha detto di wrappare
                    maxCase = citta.getNumeroCase();
                }
            }
        }
        return cittadinaMostcase;
    }
    //7)Metodo che restituisce il nome della cittadina con più collegamenti
    public String getCittadinaMostCollegamenti(Settore settore){
        String cittadinaMostCollegamenti = "";
        int maxCollegamenti = 0;
        for (Pianeta pianeta : settore.getPianeti()){
            for (Citta citta : pianeta.getLecitta()){
                if (citta.getCollegamenti().size() > maxCollegamenti){
                    cittadinaMostCollegamenti = String.valueOf(citta); //compilatore mi ha detto di wrappare
                }
            }
        }
        return cittadinaMostCollegamenti;
    }

    //Mancano alcuni metodi della task 1. La task 2 non è stata minimamente toccata.
    //Ancora non ho capito come riuscire a trovare i regali distinti
    //Ancora devo realizzare un metodo per calcolare il costo dei regali per ogni pianeta
    //Ancora non ho realizzato il metodo per trovare il numero di regali totali richiesti per ogni tipologia


}
