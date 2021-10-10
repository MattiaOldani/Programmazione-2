import java.util.ArrayList;
import java.util.List;

public class Liste {
    public static void main(String[] args) {
        // Definiamo una nuova lista di Integer
        List<Integer> lista = new ArrayList<>();

        // Aggiungo elementi alla lista
        for (int i = 0; i < 10; i++) {
            // Si può usare direttamente add(i)
            // Qua viene fatto il boxing
            lista.add(Integer.valueOf(i));
        }
        System.out.println("Lista: " + lista);

        // Calcolo la somma degli elementi
        // Posso utilizzare un for-each
        int somma = 0;
        for (Integer x: lista) {
            // Posso anche evitare intValue()
            // Qua viene fatto l'unboxing
            somma += x.intValue();
        }
        System.out.println("Somma: " + somma);

        // Al posto di un for-each uso size()
        somma = 0;
        for (int i = 0; i < lista.size(); i++) {
            // Per avere un elemento ad un certo indice uso get(index)
            somma += lista.get(i);
        }
        System.out.println("Somma: " + somma);
    }
}