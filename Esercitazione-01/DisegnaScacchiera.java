import java.util.Scanner;

public class DisegnaScacchiera {
    public static void StampaScacchiera(int n) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < n; j++) {
                StampaLinea(n, i);
            }
        }
    }

    public static void StampaLinea(int n, int i) {
        int flag = i % 2;
        String riga = "";
        for (int j = 0; j < 8; j++) {
            for (int t = 0; t < n; t++) {
                if (flag == 0) {
                    riga += "-";
                } else {
                    riga += "#";
                }
            }
            flag = (flag + 1) % 2;
        }
        System.out.println(riga);
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci n: ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        scanner.close();

        StampaScacchiera(n);
    }
}
