import java.util.Scanner;
import IntSet.IntSet;

public class TestIntSet {
    public static void main(String[] args) {
        IntSet set = new IntSet();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            set.insert(scanner.nextInt());
            System.out.println("Insieme aggiornato: " + set.toString());
        }
        scanner.close();
    }
}
