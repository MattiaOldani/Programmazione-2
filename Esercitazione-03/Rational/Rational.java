package Rational;

/*
 * OVVIAMENTE QUESTO CODICE NON L'HO TESTATO, VI PARE?
 * NON SO SE FUNZIONA, SONO LE 17:51 DI MARTEDI E SONO STANCO
 * VOGLIO ANDARE A CASA
 */

/*
 * - Gli oggetti di questa classe rappresentano dei numeri razionali
 *   I numeri razionali sono formati da un numeratore 'num' e da un
 *   denominatore 'den' tali che 'num' non divide 'den' e 'den' non
 *   divide 'num', ovvero il numero è ridotto ai minini termini;
 *   inoltre, 'den' è diverso da 0
 * - Gli oggetti di questa classe sono immutabili 
 */
public class Rational {
    // ATTRIBUTI
    /*
     * Numeratore del numero razionale
     */
    private int num;
    /*
     * Denominatore del numero razionale
     * Questo valore deve essere diverso da 0
     */
    private int den;

    // AF E REP
    /*
     * REPINV:
     *   - 'den' diverso da 0
     *   - 'num' non divide 'den'
     *   - 'den' non divide 'num'
     * AF:
     *   - AF(num, den) = { num / den | den != 0 }
     */

    // COSTRUTTORI
    /*
     * - Restituisce un nuovo numero razionale
     */
    public Rational(int num, int den) throws ArithmeticException {
        if (den == 0)
            throw new ArithmeticException("Impossibile dividere per zero");
        this.num = num;
        this.den = den;
        assert repOk();
    }

    /*
     * - Restituisce un nuovo numero razionale
     * - Viene dato solo il numeratore poichè il denomatore è
     * settato in modo implicito a 1
     */
    public Rational(int num) {
        this.num = num;
        this.den = 1;
        assert repOk();
    }

    // METODI
    /*
     * POST-CONDIZIONI
     *   - Ritorna la somma tra 'this' e 'r' se 'r' è diverso da null;
     *     in caso contrario, viene sollevata l'eccezione non controllata
     *     NullRationalException
     */
    public Rational sum(Rational r) throws NullRationalException {
        if (r == null)
            throw new NullRationalException("Riferimento nullo al numero razionale");
        int n1 = num, n2 = r.num(), d1 = den, d2 = r.den();
        Rational result = new Rational(n1 * d2 + n2 * d2, d1 * d2);
        assert repOk();
        return result.simplify();
    }

    /*
     * POST-CONDIZIONI:
     *   - Ritorna una copia di 'this' dove 'num' è cambiato di segno
     */
    public Rational minus() {
        assert repOk();
        return new Rational(-num, den);
    }

    /*
     * POST-CONDIZIONI:
     *   - Ritorna la differenza di 'this' e 'r' se 'r' non è null;
     *     in caso contrario, viene sollevata l'eccezione non controllata
     *     NullRationalException
     */
    public Rational sub(Rational r) throws NullRationalException {
        if (r == null)
            throw new NullRationalException("Riferimento nullo al numero razionale");
        assert repOk();    
        return sum(r.minus());
    }

    /*
     * 
     */
    public Rational mul(Rational r) {
        Rational result = new Rational(num * r.num(), den * r.den());
        assert repOk();
        return result.simplify();
    }

    /*
     * POST-CONDIZIONI:
     *   - Ritorna una copia di 'this' dove 'num' e 'den' sono invertiti
     */
    public Rational rec() {
        assert repOk();
        return new Rational(den, num);
    }

    /*
     * POST-CONDIZIONI:
     *   - Ritorna la divisione tra 'this' e 'r' se 'r' è diverso da
     *     null e 'r.num' è diverso da 0; nel primo caso viene sollevata
     *     l'eccezione non controllata NullRationalException, nel secondo
     *     caso viene sollevata l'eccezione ArithmeticException
     */
    public Rational div(Rational r) throws NullRationalException, ArithmeticException {
        if (r == null)
            throw new NullRationalException("Riferimento nullo al numero razionale");
        if (r.num == 0)
            throw new ArithmeticException("Impossibile dividere per zero");
        assert repOk();
        return mul(r.rec());
    }

    /*
     * POST-CONDIZIONI:
     *   - Ritorna una copia di 'this' con 'num' e 'den' elevati
     *     alla 'n'-esima potenza
     */
    public Rational power(int n) {
        assert repOk();
        return new Rational((int)Math.pow(num, n), (int)Math.pow(den, n));
    }

    /*
     * POST-CONDIZIONI:
     *   - Ritorna il valore di 'num' di 'this'
     */
    public int num() {
        assert repOk();
        return num;
    }

    /*
     * POST-CONDIZIONI:
     *   - Ritorna il valore di 'den' di 'this'
     */
    public int den() {
        assert repOk();
        return den;
    }

    /*
     * POST-CONDIZIONI:
     *   - Ritorna 'this' semplificato ai minimi termini
     */
    public Rational simplify() {
        assert repOk();
        return new Rational(num / mcd(), den / mcd());
    }

    /*
     * POST-CONDIZIONI:
     *   - Ritorna l'mcd tra 'num' e 'den'
     */
    private int mcd() {
        if (num == 0)
            return 1;
        int a, b, q, r;
        if (num > den) {
            a = num;
            b = den;
        } else {
            a = den;
            b = num;
        }
        while (true) {
            q = a / b;
            r = a % b;
            if (r == 0) {
                return b;
            }
            a = q;
            b = r;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        assert repOk();
        return sb.append(num).append(" / ").append(den).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rational)) {
            assert repOk();
            return false;
        }
        Rational other = (Rational) o;
        assert repOk();
        return (num == other.num() && den == other.den());
    }

    /*
     * Metodo che implementa la funzione di astrazione
     */
    private boolean repOk() {
        return den != 0
            && mcd() == 1;
    }
}