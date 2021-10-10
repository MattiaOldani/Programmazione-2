public class Stringhe {
    public static void main(String[] args) {
        // Il tipo String è immutabile
        // Nella variabile viene salvato il riferimento all'oggetto
        String s = "pippo";
        String t = s;
        System.out.println(s + ", " + t);
        // Cambio il riferimento di s: creo una nuova stringa
        // Il riferimento a pippo però non viene perso
        s = s + "lone";
        System.out.println(s + ", " + t);
        // Qua il riferimento a "pippolone" viene perso
        s = s.toUpperCase();
        System.out.println(s + " " + t);
    }
}
