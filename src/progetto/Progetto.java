package progetto;

public class Progetto {
    public static void main(String[] args) {
        /*
                r1 10 arte
                r2 5 elettronica
                r3 8 arte
                r4 6 sport
                r5 12 elettronica
        */

        // Creazione delle istanze dei regali
        Regalo r1 = new Regalo("r1",10,"arte");
        Regalo r2 = new Regalo("r2",5,"elettronica");
        Regalo r3 = new Regalo("r3",8,"arte");
        Regalo r4 = new Regalo("r4",6,"sport");
        Regalo r5 = new Regalo("r5",12,"elettronica");

        /*
            p1 4
            p2 1
         */

        // creazione delle istanze dei pianeti
        Pianeta p1 = new Pianeta("p1"); // ha 4 città
        Pianeta p2 = new Pianeta("p2"); // ha 1 città



        /*
        c1 p1 1 c2#2,c3#8
        c2 p1 2 c1#2,c3#4,c4#12
        c3 p1 1 c1#8,c2#4,c4#3
        c4 p1 4 c2#12,c3#3
        c5 p5 3 -
         */
        // Creazione delle istanze delle citta e assegnazione ai rispettivi pianeti
        Citta c1 = new Citta("c1",1);
        p1.getListaCitta().add(c1);
        Citta c2 = new Citta("c2",2);
        p1.getListaCitta().add(c2);
        Citta c3 = new Citta("c3",1);
        p1.getListaCitta().add(c3);
        Citta c4 = new Citta("c4",4);
        p1.getListaCitta().add(c4);
        Citta c5 = new Citta("c5",3);
        p2.getListaCitta().add(c5);

        /*
        c1 : r1,r2,r3
        c2 : r2,r4
        c3 : r1,r3,r4
        c4 : r1,r2
        c5 : r2,r4
         */
        // Aggiunta dei regali alle citta
        c1.addRegalo(r1);
        c1.addRegalo(r2);
        c1.addRegalo(r3);


        c2.addRegalo(r2);
        c2.addRegalo(r4);

        c3.addRegalo(r1);
        c3.addRegalo(r3);
        c3.addRegalo(r4);

        c4.addRegalo(r1);
        c4.addRegalo(r2);

        c5.addRegalo(r2);
        c5.addRegalo(r4);

        Settore s1 = new Settore(100);
        s1.addPianeta(p1);
        s1.addPianeta(p2);

        //COLLEGAMENTI
        Collegamento collegamento1 = new Collegamento(c1,c2,2);
        c1.addCollegamento(collegamento1);

        Collegamento collegamento2 = new Collegamento(c1,c3,8);
        c1.addCollegamento(collegamento2);

        c2.addCollegamento(new Collegamento(c2,c1,2));
        c2.addCollegamento(new Collegamento(c2,c3,4));
        c2.addCollegamento(new Collegamento(c2,c4,12));

        c3.addCollegamento(new Collegamento(c3,c1,8));
        c3.addCollegamento(new Collegamento(c3,c2,4));
        c3.addCollegamento(new Collegamento(c3,c4,3));

        c4.addCollegamento(new Collegamento(c4,c2,12));
        c4.addCollegamento(new Collegamento(c4,c3,3));

        //TASK 1 (sono riportati i risultati affianco ad ogni stampa)
        System.out.println(s1.getRegaliTotali() + " " + s1.getRegaliDistinti()); // 12 4
        s1.getRegaliTotaliPerTipologia(); // 5 4 3
        System.out.println(s1.getPianetaMostRegali()); // p1
        System.out.println(s1.getPianetaMostCosto()); // p1
        System.out.println(s1.getCittaMostRegali());// c1
        System.out.println(s1.getCittadinaMostCase());
        System.out.println(s1.getCittaMostCollegamenti());// c2

        //TASK 2 (sono riportati i risultati affianco ad ogni stampa)
        if(s1.task2_1(1,10)) // yes
            System.out.println("YES");
        else
            System.out.println("NO");

        if(s1.task2_2()) // yes
            System.out.println("YES");
        else
            System.out.println("NO");







        /*
        c1 p1 1 c2#2,c3#8 -> 10
        c2 p1 2 c1#2,c3#4,c4#12 -> 18
        c3 p1 1 c1#8,c2#4,c4#3 -> 15
        c4 p1 4 c2#12,c3#3 -> 15
        c5 p5 3 -
         */








    }
}
