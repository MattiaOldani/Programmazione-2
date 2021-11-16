package IntQueueUnbounded;

import java.util.List;
import java.util.LinkedList;

/*
 * - Gli oggetti di questa classe rappresentano delle code di interi
 *   di dimensione variabile
 * - Le code sono tipi di dato che utilizzano una modalità FIFO per
 *   l'accesso ai dati (First In First Out)
 * - Gli oggetti di questa classe sono mutabili
 */
public class IntQueueUnbounded {
    // ATTRIBUTI

    /*
     * Coda di interi
     */
    private List<Integer> queue;

    // AF E REPINV
    /*
     * REP.INV:
     *   - 'queue' non null
     * 
     * AF:
     *   - AF(queue) = { elements[i] | 0 <= i <= queue.size() - 1 }
     */

    // COSTRUTTORI
    
    /*
     * Costruisce una coda vuota
     */
    public IntQueueUnbounded() {
        queue = new LinkedList<>();
        assert repOk();
    }

    // METODI
    
    /*
     * POST-CONDIZIONI:
     *   - inserisce 'n' nella coda
     */
    public void enqueue(int n) {
        queue.add(n);
        assert repOk();
    }
    
    /*
     * EFFETTI COLLATERALI:
     *   - la lista viene modificata se non è vuota
     * POST-CONDIZIONI:
     *   - rimuove l'elemento in testa e lo restituisce se la coda
     *     non è vuota
     *   - solleva l'eccezione non controllata 'EmptyQueueException'
     *     se la coda è vuota
     */
    public int dequeue() throws EmptyQueueException {
        if (queue.size() == 0)
            throw new EmptyQueueException("Impossibile rimuovere un elemento: la coda è vuota");
        else {
            int element = queue.get(0);
            queue.remove(0);
            assert repOk();
            return element;
        }
    }

    /*
     * POST-CONDIZIONI:
     *   - ritorna 'true' se la coda è vuota, 'false' altrimenti
     */
    public boolean isEmpty() {
        boolean empty = (queue.size() == 0);
        assert repOk();
        return empty;
    }
    
    /*
     * POST-CONDIZIONI:
     *   - ritorna il numero di elementi presenti nella coda
     */
    public int size() {
        int s = queue.size();
        assert repOk();
        return s;
    }

    /*
     * POST-CONDIZIONI:
     *   - ritorna la coda sotto forma di stringa
     */
    @Override
    public String toString() {
        String s = new String(queue.toString());
        assert repOk();
        return s;
    }

    /*
     * Metodo che implementa la funzione di astrazione
     */
    private boolean repOk() {
        return queue != null;
    }
}