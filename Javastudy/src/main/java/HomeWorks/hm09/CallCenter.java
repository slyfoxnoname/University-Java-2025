package HomeWorks.hm09;

import java.util.concurrent.Semaphore;

public class CallCenter {
    private final Semaphore operators;

    public CallCenter(int numberOfOperators) {
        this.operators = new Semaphore(numberOfOperators, true);
    }

    public boolean tryServeClient() {
        return operators.tryAcquire();  // Якщо оператор вільний — займаємо
    }

    public void releaseOperator() {
        operators.release();  // Звільняємо оператора
    }
}
