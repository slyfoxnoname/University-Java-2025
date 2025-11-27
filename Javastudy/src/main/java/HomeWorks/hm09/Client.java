package HomeWorks.hm09;

import java.util.Random;

public class Client extends Thread {
    private final CallCenter callCenter;
    private final int clientId;
    private final int T3, T4, T5, T6;
    private int callAttempts = 0;
    private static int maxAttempts = 0;

    private final Random random = new Random();

    public Client(CallCenter callCenter, int clientId, int T3, int T4, int T5, int T6) {
        this.callCenter = callCenter;
        this.clientId = clientId;
        this.T3 = T3;
        this.T4 = T4;
        this.T5 = T5;
        this.T6 = T6;
    }

    @Override
    public void run() {
        while (true) {
            callAttempts++;
            synchronized (Client.class) {
                if (callAttempts > maxAttempts) {
                    maxAttempts = callAttempts;
                }
            }

            if (callCenter.tryServeClient()) {
                System.out.println("Client " + clientId + " is being served on attempt " + callAttempts);
                try {
                    int serviceTime = random.nextInt(T4 - T3 + 1) + T3;
                    sleep(serviceTime * 100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                callCenter.releaseOperator();
                break;
            } else {
                int waitTime = random.nextInt(T6 - T5 + 1) + T5;
                System.out.println("Client " + clientId + " all operators busy, retrying after " + waitTime + " time units");
                try {
                    sleep(waitTime * 100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Client " + clientId + " finished after " + callAttempts + " attempts");
    }

    public static int getMaxAttempts() {
        return maxAttempts;
    }
}

