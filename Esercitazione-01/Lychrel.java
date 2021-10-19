import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Lychrel {
    public static boolean palindromo(int n) {
        return n == contrario(n);
    }

    public static int contrario(int n) {
        int lunghezza = (int)Math.log10(n), x = 0;
        while (n > 0) {
            x += (n % 10) * Math.pow(10, lunghezza);
            n /= 10;
            lunghezza--;
        }
        return x;
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci n: ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        scanner.close();

        List<Integer> sequenza = new ArrayList<>();
        sequenza.add(n);

        while (!palindromo(n)) {
            int m = contrario(n);
            n += m;
            sequenza.add(n);
        }

        System.out.println("La sequenza di numeri è:");
        for (int elemento: sequenza) {
            System.out.println(elemento);
        }
    }
}
