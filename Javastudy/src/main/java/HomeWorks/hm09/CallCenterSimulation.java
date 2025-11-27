package HomeWorks.hm09;

import java.util.Random;

public class CallCenterSimulation {

    public static void main(String[] args) {
        int N = 3;
        int numberOfClients = 10;  

        int T1 = 1, T2 = 3;  // Інтервал надходження дзвінків
        int T3 = 2, T4 = 5;  // Час обслуговування
        int T5 = 1, T6 = 4;  // Час передзвонювання

        CallCenter callCenter = new CallCenter(N);
        Random random = new Random();

        Client[] clients = new Client[numberOfClients];

        //потоків-клієнтів з випадковими затримками T1..T2
        
        for (int i = 0; i < numberOfClients; i++) {
            try {
                int arrivalDelay = random.nextInt(T2 - T1 + 1) + T1;
                Thread.sleep(arrivalDelay * 100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clients[i] = new Client(callCenter, i + 1, T3, T4, T5, T6);
            clients[i].start();
        }

        // Чекаємо завершення всіх потоків
        for (Client client : clients) {
            try {
                client.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nMaximum call attempts by a single client: " + Client.getMaxAttempts());
    }
}
