import Rational.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TestRational {
    public static void main(String[] args) {
        List<Integer[]> sequence = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int num = Integer.parseInt(elements[0]);
            int den = Integer.parseInt(elements[1]);
            Integer[] rational = {num, den};
            sequence.add(rational);
        }
        scanner.close();

        Rational other = new Rational(1, 2);
        System.out.println("Tutte le operazioni vengono eseguite con " + other.toString() + " come altro fattore");
        for (Integer[] elements : sequence) {
            Rational r = new Rational(elements[0], elements[1]);
            System.out.println("Numeratore: " + r.num() + " | Denominatore: " + r.den());
            System.out.println("Somma: " + r.sum(other));
            System.out.println("Inverso: " + r.minus());
            System.out.println("Sottrazione: " + r.sub(other));
            System.out.println("Prodotto: " + r.mul(other));
            System.out.println("Reciproco: " + r.rec());
            System.out.println("Divisione: " + r.div(other));
            System.out.println("Potenza alla 2: " + r.power(2));
            System.out.println("Potenza alla -2: " + r.power(-2));
            System.out.println();
        }
    }
}
