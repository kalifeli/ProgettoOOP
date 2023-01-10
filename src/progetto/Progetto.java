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
        // genero la lista dei pianeti con i pianeti letti in input dal file
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
                for(int j = 0; j < collegamenti.length; ++j){
                    //creo un aray di String che mi rappresenti nel campo[0] == citta2, campo[1] == costo
                    // datiCollegamenti viene ad ogni iterazione del ciclo for
                    String[] datiCollegamenti = collegamenti[j].split("#");
                    // istanzio un collegamento temporaneo che mi permette di tener traccia ogni volta dei collegamenti che creo
                    Collegamento collegamentoTemp = new Collegamento(campi[0],datiCollegamenti[0],Integer.parseInt(datiCollegamenti[1]));
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

        for(int i = 0; i < numeroCittaTotali; ++i)
        {
            temp = scanner.nextLine();
            campi = temp.split(" : ");
            for(Pianeta pianeta : s1.getListaPianeti())
                for(Citta citta : pianeta.getListaCitta())
                {
                    if(citta.getNomeCitta().equals(campi[0])){
                        String[] regaliTemp = campi[1].split(",");
                        for(int j = 0; j < regaliTemp.length; ++j)
                        {
                            for(Regalo regalo : listaRegali){
                                if(regaliTemp[0].equals(regalo.getNomeRegalo())) {
                                    citta.addRegalo(regalo);
                                }
                            }

                        }

                    }

                }

        }
        System.out.println(s1.getRegaliTotali() + " " + s1.getRegaliDistinti()); // 12 4
        s1.getRegaliTotaliPerTipologia(); // 5 4 3
        System.out.println(s1.getPianetaMostRegali()); // p1
        System.out.println(s1.getPianetaMostCosto()); // p1
        System.out.println(s1.getCittaMostRegali());// c1
        System.out.println(s1.getCittadinaMostCase());
        System.out.println(s1.getCittaMostCollegamenti());// c2

        if(s1.task2_1(1,10))
            System.out.println("YES");
        if (s1.task2_2())
            System.out.println("YES");
        System.out.println();
        if(s1.task2_4())
            System.out.println("YES");

    }
}
