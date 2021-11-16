package SimpleMap;

import java.util.List;
import java.util.ArrayList;

/*
 * - Gli oggetti di questa classe rappresentano delle mappe da 
 *   'String' a 'int'
 * - Le mappe sono tipi di dato che mettono in relazione una chiave
 *   'k' con uno e un unico valore 'v'; l'insieme delle chiavi non
 *   contiene valori duplicati
 * - Gli oggetti di questa classe sono mutabili
 */
public class SimpleMap {
    // ATTRIBUTI
    /*
     * Lista delle chiavi
     */
    private List<String> keys;
    /*
     * Lista dei valori associati alle chiavi
     */
    private List<Integer> values;

    // AF E REPINV
    /*
     * REPINV:
     *   - 'keys' non null
     *   - 'values' non null
     *   - keys.size() == values.size()
     *   - keys non contiene elementi ripetuti
     *   - keys non contiene riferimenti null
     * 
     * AF:
     *   - AF(keys, values) = { keys[i] : values[i] | 0 <= i <= keys.size() - 1 }
     */

    // COSTRUTTORI
    /*
     * Crea una nuova mappa vuota
     */
    public SimpleMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
        assert repOk();
    }

    // METODI
    /*
     * EFFETTI COLLATERALI:
     *   - A 'keys' viene aggiunta 'key' se 'key' non è null
     *   - A 'values' viene aggiunto 'value' se 'key' non è null
     * POST-CONDIZIONI:
     *   - A 'keys' viene aggiunta 'key' se 'key' non è null; in
     *     caso contrario viene sollevata l'eccezione non controllata
     *     'NullKeyException'
     *   - A 'values' viene aggiunto 'value' se 'key' non è null; in
     *     caso contrario viene sollevata l'eccezione descritta in precedenza
     */
    public void put(String key, int value) throws NullKeyException {
        if (key == null)
            throw new NullKeyException("La chiave ha un riferimento nullo");
        else {
            if (keys.indexOf(key) == -1) {
                keys.add(key);
                values.add(value);
                repOk();
            }
        }
    }

    /*
     * EFFETTI COLLATERALI:
     *   - A 'keys' viene rimosso l'elemento 'key' se 'key' non è null
     *   - A 'values' viene rimosso l'elemento associato a 'key' se 
     *     'key' non è null
     * POST-CONDIZIONI:
     *   - A 'keys' viene rimosso l'elemento 'key' se 'key' non è null;
     *     in caso contrario viene sollevata l'eccezione non controllata
     *     'NullKeyException'
     *   - A 'values' viene rimosso l'elemento associato a 'key' se 'key'
     *     non è null; in caso contrario l'eccezione sollevata è quella
     *     descritta al punto precedente
     */
    public int remove(String key) throws NullKeyException, AbsentKeyException {
        if (key == null)
            throw new NullKeyException("La chiave ha un riferimento nullo");
        else {
            if (keys.contains(key)) {
                int index = keys.indexOf(key);
                int removed = get(key);
                keys.remove(index);
                values.remove(index);
                assert repOk();
                return removed;
            } else {
                throw new AbsentKeyException("La chiave da eliminare non esiste"); 
            }
        }
    }

    /*
     * EFFETTI COLLATERALI:
     *   - Ritorna l'elemento associato a 'key' se 'key' non è null
     * POST-CONDIZIONI:
     *   - Ritorna l'elemento associato a 'key' se 'key' non è null;
     *     in caso contrario, viene sollevata l'eccezione non controllata
     *     'NullKeyException'
     */
    public int get(String key) throws NullKeyException, AbsentKeyException {
        if (key == null)
            throw new NullKeyException("La chiave ha un riferimento nullo");
        else {
            int index = keys.indexOf(key);
            if (index == -1)
                throw new AbsentKeyException("Chiave inesistente");
            int value = values.get(index);
            repOk();
            return value;
        }
    }

    /*
     * POST-CONDIZIONI:
     *   - Restituisce il numero di chiavi contenute nella mappa
     */
    public int size() {
        assert repOk();
        return keys.size();
    }

    /*
     * Restituisce la mappa sotto forma di stringa
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < keys.size(); i++) {
            sb.append(keys.get(i)).append(" -> ").append(values.get(i));
            if (i != keys.size() - 1)
                sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    /*
     *
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SimpleMap))
            return false;
        SimpleMap other = (SimpleMap) o;
        assert repOk();
        return keys.equals(other.keys) && values.equals(other.values);
    }

    /*
     * Metodo che implementa la funzione di astrazione
     */
    private boolean repOk() {
        for (int i = 0; i < keys.size() - 1; i++)
            for (int j = i + 1; j < keys.size(); j++)
                if (keys.get(i) == keys.get(j) || keys.get(i) == null || keys.get(j) == null)
                    return false;
        return keys != null
            && values != null
            && keys.size() == values.size();
    } 
}
