package progetto;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulazione {
    private ArrayList<Citta> cittaVisitate;
    private HashMap<String, Pianeta> pianetiVisitati;
    private int regaliRimanenti;
    public Simulazione(ArrayList<Citta> tutteLeCitta, ArrayList<Pianeta> tuttiIPianeti, int regaliIniziali){  //tutteLeCitta si può togliere?
        this.cittaVisitate = new ArrayList<>();
        this.pianetiVisitati = new HashMap<>();
        for (Pianeta p : tuttiIPianeti){
            this.pianetiVisitati.put(p.getNomePianeta(), p);  //passaggio poco chiaro
        }
        this.regaliRimanenti = regaliIniziali;   //Perché all'inizio i regali rimanenti sono massimi, giusto?
    }
    public void simula(ArrayList<Citta> pianoDiConsegna, Pianeta p){; //spero di aver parametrizzato bene
        Citta cittaPrecedente = null;
        Pianeta pianetaPrecedente = null;
        for(Citta citta : pianoDiConsegna){
            if (citta.getRegaliRichiesti(p) > regaliRimanenti){
                System.out.println("NOT VALID");
                return;
            }
            if(cittaPrecedente != null){   //è necessario?
                if(pianetaPrecedente == citta.getPianeta() && !cittaPrecedente.isConnectedTo(citta)){
                    System.out.println("NOT VALID");
                    return;
                }
            }
            regaliRimanenti -= citta.getRegaliRichiesti(p);
            citta.setRegaliRichiesti(0);
            cittaVisitate.add(citta);

            pianetiVisitati.get(citta.getPianeta().getNomePianeta()).impostaStatoVisita(true); //ricordati che è una mappa e tramite la key (String) stai accedendo al value
            cittaPrecedente = citta;
            pianetaPrecedente = citta.getPianeta();
        }
        for(Citta citta : cittaVisitate){
            if(citta.getRegaliRichiesti(p) != 0){
                System.out.println("NOT VALID");    //verifica se tutti i regali sono stati consegnati
                return;
            }
        }
        for(Pianeta pianeta : pianetiVisitati.values()){  //Verifica se tutti i pianeti sono stati visitati
            if(!pianeta.getStatoVisita()){
                System.out.println("NOT VALID");
                return;
            }
        }
        System.out.println("VALID");
    }
}
