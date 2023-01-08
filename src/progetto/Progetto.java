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

        System.out.println(s1.getRegaliTotali() + " " + s1.getRegaliDistinti());
        s1.getRegaliTotaliPerTipologia();
        System.out.println(s1.getPianetaMostRegali());
        System.out.println(s1.getPianetaMostCosto());
    }
}
