package ex2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedFifoQueue {
    final int size;
    int pos;
    Lock lock;
    Integer[] fifo;
    final Condition notFull;
    final Condition notEmpty;

    SharedFifoQueue(int size) {
        lock = new ReentrantLock();
        fifo = new Integer[size];
        this.size = size;
        this.pos = 0;

        notFull = lock.newCondition();
        notEmpty = lock.newCondition();

        for (int i = 0; i < size; i++) {
            fifo[i] = -1;
        }
    }

    public void consumir() {
        try {
            lock.lock();
            while (fifo[0] == -1) {
                notFull.await();
            }
            System.out.println("Consumindo");
            pos--;
            fifo[pos] = -1;
            Thread.sleep(1000);
            notEmpty.signal();
        } catch (Exception ex) {
            System.out.println("Error consumir: " + ex);
        } finally {
            lock.unlock();
        }
    }

    public void produzir() {
        try {
            lock.lock();
            while (fifo[size - 1] != -1) {
                notEmpty.await();
            }
            System.out.println("Produzindo");
            fifo[pos] = pos;
            pos++;
            Thread.sleep(1000);
            notFull.signal();
        } catch (Exception ex) {
            System.out.println("Error produzir: " + ex);
        } finally {
            lock.unlock();
        }
    }
}
