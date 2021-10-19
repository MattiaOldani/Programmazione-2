import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Kaprekar {
    public static List<Integer> DividiCifre(int n) {
        List<Integer> cifre = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            cifre.add(n % 10);
            n /= 10;
        }
        Collections.sort(cifre);
        return cifre;
    }

    public static int TrovaMassimo(int n) {
        List<Integer> cifre = DividiCifre(n);
        int minimo = 0;
        for (int i = 3; i >= 0; i--) {
            minimo += (cifre.get(i) * Math.pow(10, i));
        }
        return minimo;
    }

    public static int TrovaMinimo(int n) {
        List<Integer> cifre = DividiCifre(n);
        int massimo = 0;
        for (int i = 0; i < 4; i++) {
            massimo += (cifre.get(i) * Math.pow(10, 3 - i));
        }
        return massimo;
    }

    public static List<Integer> GeneraSequenza(int n) {
        List<Integer> lista = new ArrayList<>();
        lista.add(n);
        while (n != 6174) {
            int massimo = TrovaMassimo(n);
            int minimo = TrovaMinimo(n);
            n = massimo - minimo;
            lista.add(n);
        }
        return lista;
    }

    public static void StampaSequenza(List<Integer> lista) {
        for (int n : lista) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero di 4 cifre: ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        scanner.close();

        List<Integer> lista = GeneraSequenza(n);
        
        StampaSequenza(lista);
    }
}
