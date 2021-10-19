import java.util.Scanner;

public class DisegnaV {
    public static void StampaV(int n) {
        int spazio_esterno = 0, spazio_interno = 2 * n - 3;
        for (int i = 0; i < n; i++) {
            String riga = "";
            for (int j = 0; j < spazio_esterno; j++) {
                riga += " ";
            }
            riga += "*";
            for (int j = 0; j < spazio_interno; j++) {
                riga += " ";
            }
            if (i != n - 1) {
                riga += "*";
            }
            System.out.println(riga);
            spazio_esterno += 1;
            spazio_interno -= 2;
        }
    }

    public static void main(String[] args) {
        int n = 0;
        System.out.print("Inserisci n: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        scanner.close();

        StampaV(n);
    }
}