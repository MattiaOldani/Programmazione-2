import IntQueue.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TestIntQueue {
    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt())
            n = scanner.nextInt();
        
        List<Integer> sequence = new ArrayList<>();
        while (scanner.hasNextInt()) {
            sequence.add(scanner.nextInt());
        }

        IntQueue queue = new IntQueue(n);
        int numEnqueue = 0, numDequeue = 0;

        for (int i = 0; i <= sequence.size() - 1; i++) {
            if (sequence.get(i) == 1) {
                numEnqueue++;
                try {
                    queue.enqueue(numEnqueue);
                } catch (FullQueueException e) {
                    System.out.println("IntQueue: " + queue.toString());
                    System.out.println("Numeri di elementi: " + queue.size());
                }
            } else {
                int estratto;
                numDequeue++;
                try {
                    estratto = queue.dequeue();
                    System.out.println("Numero estratto dalla coda: " + Integer.toString(estratto));
                } catch (EmptyQueueException e) {}
            }
            if (numDequeue > numEnqueue) {
                System.out.println("IntQueue: " + queue.toString());
                System.out.println("Numeri di elementi: " + queue.size());
            }
        }

        System.out.println("IntQueue: " + queue.toString());
        System.out.println("Numeri di elementi: " + queue.size());

        scanner.close();
    }
}