public class LineaComando {
    public static void main(String[] args) {
        // Prendo i valori da riga di comando
        // Calcolo anche la somma dei valori
        int somma = 0;
        // Eseguo la conta al contrario perchè è kek
        // args.length restituisce la lunghezza di args
        for (int i = args.length - 1; i >= 0; i--) {
            // Il valore in args è una string
            // La parso con parseInt()
            somma += Integer.parseInt(args[i]);
        }
        System.out.println("Somma: " + somma);
    }
}