package progetto;

import java.util.ArrayList;
import java.util.Scanner;

public class Progetto {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Settore s1 = new Settore(); // genera una lista di pianeti

        String temp = scanner.nextLine();
        String[] campi = temp.split(" ");
        s1.setDeposito(Integer.parseInt(campi[0]));
        int numeroPianeti = Integer.parseInt(campi[1]);
        int numeroTotaleRegali = Integer.parseInt(campi[2]);
        //creo una lista dei regali
        ArrayList<Regalo> listaRegali = new ArrayList<>();
        //aggiungo i regali letti da stdin nella listaRegali
        for(int i = 0; i < numeroTotaleRegali; ++i)
        {
            temp = scanner.nextLine();
            campi = temp.split(" ");
            Regalo regaloTemp = new Regalo(campi[0],Double.parseDouble(campi[1]),campi[2]);
            listaRegali.add(regaloTemp);
        }
        // istanzio oggetti di tipo Pianeta con i dati letti in input dal file e li aggiungo nella lista dei pianeti del settore 1
        int numeroCittaTotali = 0;
        for(int i = 0; i < numeroPianeti; ++i)
        {
            temp = scanner.nextLine();
            campi = temp.split(" ");
            Pianeta pianetaTemp = new Pianeta(campi[0],Integer.parseInt(campi[1]));
            s1.addPianeta(pianetaTemp);
            numeroCittaTotali += pianetaTemp.getNumeroCitta();
        }


        // istanzio le citta e aggiungerle nei rispettivi pianeti di appartenenza
        for(int i = 0; i < numeroCittaTotali; ++i)
        {
            temp = scanner.nextLine();
            campi = temp.split(" ");
            Citta cittaTemp = new Citta(campi[0],Integer.parseInt(campi[2]));
            //se il file presenta i collegamenti con altre citta
            if(!campi[3].equals("-")){
                //creo un array di String che contiene campi di questo tipo x#y
                String[] collegamenti = campi[3].split(",");

                //su tutti i campi di collegamenti
                for (String s : collegamenti) {
                    //creo un aray di String che mi rappresenti nel campo[0] == citta2, campo[1] == costo
                    // datiCollegamenti viene ad ogni iterazione del ciclo for
                    String[] datiCollegamenti = s.split("#");
                    Citta cittaDest = new Citta(datiCollegamenti[0]);
                    // istanzio un collegamento temporaneo che mi permette di tener traccia ogni volta dei collegamenti che creo
                    Collegamento collegamentoTemp = new Collegamento(cittaTemp, cittaDest, Integer.parseInt(datiCollegamenti[1]));
                    //aggiungo ogni volta il collegamento all'interno della listaCollegamenti della città
                    cittaTemp.addCollegamento(collegamentoTemp);
                }
            }

            for(Pianeta pianeta : s1.getListaPianeti())
            {
                if(campi[1].equals(pianeta.getNomePianeta()))
                {
                    pianeta.addCitta(cittaTemp);
                }
            }

        }

        for(int i = 0; i < numeroCittaTotali; ++i){
            if(!scanner.hasNextLine()) {
                break;
            }
            temp = scanner.nextLine();
            campi = temp.split(" : ");
            String[] regaliTemp = campi[1].split(",");
            for(Pianeta pianeta : s1.getListaPianeti())
                for(Citta citta : pianeta.getListaCitta())
                {
                    if(citta.getNomeCitta().equals(campi[0])){

                        for (String s : regaliTemp) {
                            for (Regalo regalo : listaRegali) {
                                if (s.equals(regalo.getNomeRegalo())) {
                                    citta.addRegalo(regalo);
                                }
                            }
                        }

                    }

                }

        }
        // inizializzo le citta che erano passate come collegamenti come dei veri oggetti
        for(Pianeta pianeta : s1.getListaPianeti()){
            for(Citta citta1 : pianeta.getListaCitta()){
                for(Citta citta2 : pianeta.getListaCitta()){
                    for(Collegamento collegamento : citta1.getListaCollegamenti()){
                        if(collegamento.getCitta2().getNomeCitta().equals(citta2.getNomeCitta())){
                            collegamento.setCitta2(citta2);
                        }
                    }
                }
            }
        }

        temp = scanner.nextLine();
        campi = temp.split(" ");

        switch(campi[0]){
            case "TASK1":
                System.out.println(s1.getRegaliTotali() + " " + s1.getRegaliDistinti()); // 12 4
                s1.task1_2(); // 5 4 3
                System.out.println(s1.getPianetaMostRegali()); // p1
                System.out.println(s1.getPianetaMostCosto()); // p1
                System.out.println(s1.getCittaMostRegali());// c1
                System.out.println(s1.getCittadinaMostCase());
                System.out.println(s1.getCittaMostCollegamenti());// c2
                break;
            case "TASK2":
                int p = Integer.parseInt(campi[1]);
                int q = Integer.parseInt(campi[2]);
                if(s1.task2_1(p,q) && s1.task2_2() && s1.task2_3() && s1.task2_4())
                    System.out.println("YES");
                else
                    System.out.println("NO");
                break;
            case "TASK3":
                Simulazione simulazione = new Simulazione(s1);
                int numeroCittaDaVisitare = Integer.parseInt(campi[1]);
                ArrayList<Citta> pianoDiConsegna = new ArrayList<>();
                for(int i = 0; i < numeroCittaDaVisitare;++i){
                    temp = scanner.nextLine();
                    for(Pianeta pianeta: s1.getListaPianeti()){
                        for(Citta citta : pianeta.getListaCitta())
                        {
                            if(citta.getNomeCitta().equals(temp)){
                                pianoDiConsegna.add(citta);
                            }
                        }
                    }
                }
                // vedo se ci sono doppioni di citta all'interno del piano di consegna e se BAbbo Natale visita tutte le citta
                for(Pianeta pianeta : s1.getListaPianeti()){ // p1 -> c1 c2 c3 c4  p2 -> c5 piano consegna -> c1 c2 c5 c4 c3
                    for(Citta citta : pianeta.getListaCitta()){
                        int contatore = 0;
                        for(int i = 0; i < numeroCittaDaVisitare; ++i){
                            if(citta.getNomeCitta().equals(pianoDiConsegna.get(i).getNomeCitta())){
                                contatore++;
                            }
                        }
                        if(contatore != 1){
                            System.out.println("NOT VALID");
                            return;
                        }
                    }
                }
                simulazione.simula(pianoDiConsegna,s1);

        }
    }
}
