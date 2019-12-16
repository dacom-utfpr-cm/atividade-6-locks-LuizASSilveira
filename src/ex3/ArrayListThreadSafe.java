package ex3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class ArrayListThreadSafe {
    ReadWriteLock rwl;
    Lock r;
    Lock w;

    ArrayListThreadSafe(ReadWriteLock rwl) {
        this.rwl = rwl;
        r = this.rwl.readLock();
        w = this.rwl.writeLock();
    }

    public void ler() {
        r.lock();
        try {
            System.out.println("Lendo...");
            Thread.sleep(2000);
            System.out.println("Terminou de ler");

        } catch (Exception ex) {
            System.out.println("Err ler: " + ex);
        } finally {
            r.unlock();
        }
    }

    public void escrever() {
        w.lock();
        try {
            System.out.println("Escrevendo...");
            Thread.sleep(5000);
            System.out.println("Terminou de escrever");

        } catch (Exception ex) {
            System.out.println("Err escrever: " + ex);
        } finally {
            w.unlock();
        }
    }

}
