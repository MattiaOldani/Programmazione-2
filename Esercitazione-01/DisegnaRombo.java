import java.util.Scanner;

public class DisegnaRombo {
    public static void StampaRiga(int spazi, int asterischi) {
        String riga = "";
        for (int i = 0; i < spazi; i++) {
            riga += " ";
        }
        for (int i = 0; i < asterischi; i++) {
            riga += "*";
        }
        System.out.println(riga);
    }

    public static void StampaSopra(int n) {
        int spazi = n, asterischi = 1;
        for (int i = 0; i < n; i++) {
            StampaRiga(spazi, asterischi);
            spazi--;
            asterischi += 2;
        }
    }

    public static void StampaDiagonale(int n) {
        StampaRiga(0, 2 * n + 1);
    }

    public static void StampaSotto(int n) {
        int spazi = 1, asterischi = 2 * n - 1;
        for (int i = 0; i < n; i++) {
            StampaRiga(spazi, asterischi);
            spazi++;
            asterischi -= 2;
        }
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci n: ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        scanner.close();

        StampaSopra(n);
        StampaDiagonale(n);
        StampaSotto(n);
    }
}
