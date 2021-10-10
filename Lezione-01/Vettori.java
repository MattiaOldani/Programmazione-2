import java.util.Arrays;

public class Vettori {
    public static void main(String[] args) {
        // Gli array sono mutabili
        // Per definirli usiamo i letterali
        int[] v = { 1, 2, 3 };
        String[] nomi = { "ciao", "mamma" };
        // Per stampare il vettore come stringa
        // possiamo usare un metodo della classe Arrays
        System.out.println(Arrays.toString(v));
        // Vado a modificare il valore di v
        v[0] = 1000;
        System.out.println(Arrays.toString(v) + "\n");

        // Il fatto che l'array sia di String non implica che
        // io non possa modificare un elemento dell'array
        System.out.println(Arrays.toString(nomi));
        nomi[0] = "addio";
        System.out.println(Arrays.toString(nomi) + "\n");

        // Esistono poi i vettori di vettori
        int[][] m = { { 1, 2 }, { 3, 4, 5 } };
        // Se provo a stampare con Arrays.ToString() noto
        // che viene stampato un array di riferimenti
        System.out.println(Arrays.toString(m));
        // Devo stampare singolarmente i vettori
        System.out.println(Arrays.toString(m[0]));
        System.out.println(Arrays.toString(m[1]));
        // Se ora modifico un elemento dell'array usando
        // una variabile esterna, la modifica si riflette
        // anche sull'array iniziale
        int[] x = m[0];
        x[1] = 100;
        System.out.println(Arrays.toString(m[0]));
        System.out.println(Arrays.toString(m[1]));
    }
}
