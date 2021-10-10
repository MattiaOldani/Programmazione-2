import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        // Creo uno scanner e una lista di parole
        Scanner s = new Scanner(System.in);
        List<String> parole = new ArrayList<>();
        
        // Fino a quando c'è un elemento in Stdin lo leggo
        while (s.hasNext()) {
            parole.add(s.next());
        }
        s.close();
        System.out.println("Parole inserite: " + parole);

        // Esistono anche le varianti di hasNext e next
        // Dipende dal tipo di dato che dobbiamo leggere
    }
}