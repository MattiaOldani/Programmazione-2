import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ProvaDelNove {
    public static List<List<Integer>> trovaTerne(int n) {
        List<List<Integer>> terne = new ArrayList<>();

        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                for (int c = 1; c < n; c++) {
                    if (a*b != c && checkCifre(a, b, c)) {
                        List<Integer> terna = new ArrayList<>();
                        terna.add(a);
                        terna.add(b);
                        terna.add(c);
                        terne.add(terna);
                    }
                }
            }
        }

        return terne;
    }

    public static boolean checkCifre(int a, int b, int c) {
        int cifre1 = 0, cifre2 = 0;
        cifre1 = riduciCifre(riduciCifre(a) * riduciCifre(b));
        cifre2 = riduciCifre(c);
        return cifre1 == cifre2;
    }

    public static int riduciCifre(int n) {
        int sommaCifre = 0;
        do {
            while (n > 0) {
                sommaCifre += n % 10;
                n /= 10;
            }
            n = sommaCifre;
        } while (n > 9);
        return sommaCifre;
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        scanner.close();

        List<List<Integer>> terne = trovaTerne(n);

        for (List<Integer> terna : terne) {
            for (int elemento : terna) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}
