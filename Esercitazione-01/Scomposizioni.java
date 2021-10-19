import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class Scomposizioni {
    public static boolean primo(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static List<Integer> scomponi(int n) {
        List<Integer> fattori = new ArrayList<>();
        
        while (true) {
            if (primo(n)) {
                fattori.add(n);
                break;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    fattori.add(i);
                    n /= i;
                    break;
                }
            }
        }
        return fattori;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        List<List<Integer>> scomposizioni = new ArrayList<>();
        scomposizioni.add(List.of());
        scomposizioni.add(List.of());

        for (int i = 2; i <= n; i++) {
            scomposizioni.add(scomponi(i));
        }

        for (int i = 0; i <= n; i++) {
            System.out.println(Integer.toString(i) + " => " + Arrays.toString(scomposizioni.get(i).toArray()));
        }
    }
}