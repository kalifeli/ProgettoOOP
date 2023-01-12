package progetto;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulazione {
    private ArrayList<Citta> cittaVisitate;
    private HashMap<String, Pianeta> pianetiVisitati;
    private int deposito; // quanti regali babbo Natale ha sulla slitta
    public Simulazione(Settore s1){
        this.cittaVisitate = new ArrayList<>();
        this.pianetiVisitati = new HashMap<>();
        for (Pianeta pianeta : s1.getListaPianeti()){
            this.pianetiVisitati.put(pianeta.getNomePianeta(), pianeta);
        }
        this.deposito = s1.getDeposito();
    }
    public void simula(ArrayList<Citta> pianoDiConsegna,Settore s1){
        Citta cittaPrecedente = null;
        Pianeta pianetaPrecedente = null;

        for(Citta citta : pianoDiConsegna){
            if (citta.getRegaliRichiesti() > deposito){
                System.out.println("NOT VALID");
                return;
            }
            if(cittaPrecedente != null){
                if(pianetaPrecedente == citta.getPianeta(s1) && !cittaPrecedente.esistenzaCollegamento(citta,cittaPrecedente)){
                    System.out.println("NOT VALID");
                    return;
                }
            }
            deposito -= citta.getRegaliRichiesti();
            System.out.println(deposito);
            citta.getListaRegali().clear();
            cittaVisitate.add(citta);

            pianetiVisitati.get(citta.getPianeta(s1).getNomePianeta()).impostaStatoVisita(true); //ricordati che è una mappa e tramite la key (String) stai accedendo al value
            cittaPrecedente = citta;
            pianetaPrecedente = citta.getPianeta(s1);
        }

        for(Pianeta pianeta : pianetiVisitati.values()){
            //per ogni pianeta che ho visitato
            //controllo se l'ho visitato
            if(!pianeta.getStatoVisita()){
                System.out.println("NOT VALID");
                return;
            }
            //se lo stato della visita è true controllo ogni citta del pianeta visitato
            for(Citta citta : cittaVisitate){
                //vedo se ad ogni città Babbo Natale ha consegnato i regali
                if(citta.getListaRegali().size() != 0){
                    System.out.println("NOT VALID");    //verifica se tutti i regali sono stati consegnati
                    return;
                }
            }

        }
        System.out.println("VALID");

    }
}
