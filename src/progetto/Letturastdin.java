package progetto;

import java.util.ArrayList;
import java.util.Scanner;

public class Letturastdin {
    public class LetturaStdin {
        public static void main(String[] args) {
            // myRecord ospiterà i record che leggeremo da stdin
            ArrayList<Record> myRecords = new ArrayList<>();

            // System.in rappresenta lo stream di input standard
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                String[] fields = temp.split(",");
                myRecords.add(new Record(
                        fields[0],
                        Integer.parseInt(fields[1]),
                        Double.parseDouble(fields[2]),
                        Double.parseDouble(fields[3]))
                );
            }

            // A questo punto, scanner non ha altre linee da leggere
            scanner.close();

            for (Record r: myRecords)
                System.out.println(r);
        }
    }

}
