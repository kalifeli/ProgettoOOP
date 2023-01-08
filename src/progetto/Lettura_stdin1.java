package progetto;
import java.util.Scanner;

public class Lettura_stdin1 {
    Scanner scanner = new Scanner(System.in);

    // Lettura del numero di regali nel deposito di Babbo Natale
    System.out.print("Inserisci il numero di regali nel deposito di Babbo Natale: ");
    int numRegali = scanner.nextInt();

    // Lettura del numero di pianeti presenti nel settore
    System.out.print("Inserisci il numero di pianeti presenti nel settore: ");
    int numPianeti = scanner.nextInt();

    // Lettura dei nomi e delle informazioni sui pianeti
    for(int i = 0; i < numPianeti; i++) {
        System.out.print("Inserisci il nome del pianeta: ");
        String nomePianeta = scanner.nextLine();

        // Lettura del numero di città presenti sul pianeta
        System.out.print("Inserisci il numero di città presenti sul pianeta: ");
        int numCitta = scanner.nextInt();

        // Lettura dei nomi e delle informazioni sulle città
        for (int j = 0; j < numCitta; j++) {
            System.out.print("Inserisci il nome della città: ");
            String nomeCitta = scanner.nextLine();

            // Lettura del numero di case presenti nella città
            System.out.print("Inserisci il numero di case presenti nella città: ");
            int numCase = scanner.nextInt();

            // Determinazione se la città è un paesino o una cittadina
            String tipoCitta;
            if (numCase <= 10) {
                tipoCitta = "paesino";
            } else {
                tipoCitta = "cittadina";
            }

            // Lettura del numero di regali richiesti dalla città
            System.out.print("Inserisci il numero di regali richiesti dalla città: ");
            int numRegaliRichiesti = scanner.nextInt();

            // Lettura dei nomi, costi e tipologie dei regali richiesti
            for (int k = 0; k < numRegaliRichiesti; k++) {

            }
