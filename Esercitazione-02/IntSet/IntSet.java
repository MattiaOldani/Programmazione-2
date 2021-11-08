package IntSet;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/*
 * Gli oggetti di questa classe rappresentano degli insiemi di interi ordinati in modo crescente
 * Gli oggetti di questa classe sono mutabili
 */
public class IntSet {
    // ATTRIBUTI
    /*
     * Lista contenente gli elementi dell'insieme
     * [1, 2, 3, 4] --> {1, 2, 3, 4}
     */
    List<Integer> set;

    // COSTRUTTORI
    /*
     * Crea l'insieme vuoto, ovvero privo di elementi
     */
    public IntSet() {
        set = new ArrayList<>();
    }

    // METODI
    /*
     * EFFETTI COLLATERALI: se 'n' non appartiene a 'set' allora 'set' = 'set' U 'n'
     */
    public void insert(int n) {
        if (!set.contains(n)) {
            set.add(n);
            Collections.sort(set);
        }
    }

    /*
     * EFFETTI COLLATERALI: se 'n' appartiene a 'set' allora 'set' = 'set' \ {'n'}
     */
    public void delete(int n) throws EmptyException {
        if (set.size() == 0)
            throw new EmptyException("Impossibile accedere agli elementi di un insieme vuoto");
        else
            if (set.contains(n)) {
                int index = set.indexOf(n);
                set.remove(index);
            }
    }

    /*
     * POST-CONDIZIONI: ritorna un valore casuale dell'insieme se l'insieme non è vuoto
     */
    public int choose() throws EmptyException {
        if (set.size() == 0)
            throw new EmptyException("Impossibile accedere agli elementi di un insieme vuoto");
        else
            return set.get(set.size() / 2);
    }

    /*
     * POST-CONDIZIONI: ritorna la cardinalità del set (il numero di elementi)
     */
    public int size() {
        return set.size();
    }

    /*
     * POST-CONDIZIONI: ritorna true se 'x' è contenuto in 'set', false altrimenti
     */
    public boolean contains(int x) {
        int min = 0, max = set.size();
        while (min < max) {
            int m = (min + max) / 2;
            if (set.get(m) == x)
                return true;
            else if (set.get(m) < x)
                min = m + 1;
            else
                max = m;
        }
        return false;
    }

    /*
     * POST-CONDIZIONI: ritorna la rappresentazione sotto forma di String del set
     */
    @Override
    public String toString() {
        String result = new String("{");
        for (int i = 0; i < set.size(); i++) {
            if (i == set.size() - 1)
                result += Integer.toString(set.get(i));
            else
                result += Integer.toString(set.get(i)) + ", ";
        }
        result += "}";
        return result;
    }
}
