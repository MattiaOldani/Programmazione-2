import SimpleMap.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Il docente Santini considera l'istruzione '+ 1 2' come un'istruzione
 * non valida poichè '1' è un numero e quindi non va bene come chiave
 * Nella mia testa anche '1' va bene perchè a tutti gli effetti esiste
 * la stringa '1' quindi i risultati del file 'expected.txt' sono diversi
 * da quelli che ottiene il mio misero e malfatto programma
 * 
 * EDIT: sono uno scemo e invece '1' è proprio una stringa
 */

public class TestSimpleMap {
    public static void main(String[] args) {
        List<String> sequence = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
            sequence.add(scanner.nextLine());
        scanner.close();

        SimpleMap map = new SimpleMap();
        for (String s : sequence) {
            String[] splitted = s.split(" ");
            //System.out.println(splitted.length);
            //for (String k : splitted)
            //    System.out.println(k.toString());
            if (splitted[0].equals("+")) {
                //System.out.println(splitted.toString());
                try {
                    String key = splitted[1];
                    int value = Integer.parseInt(splitted[2]);
                    map.put(key, value);
                } catch (NullKeyException e) {
                    System.out.println(e);
                }
            } else {
                //System.out.println(splitted);
                String key = splitted[1];
                try {
                    int removed = map.remove(key);
                    System.out.println("Elemento associato alla chiave rimossa: " + removed);
                } catch (NullKeyException e) {
                    // System.out.println(e);
                } catch (AbsentKeyException e) {
                    // System.out.println(e);
                }
            }
        }

        System.out.println("Numero di elementi nella lista: " + map.size());
    }
}
