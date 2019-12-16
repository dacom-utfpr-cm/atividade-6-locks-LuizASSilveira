package ex1;

/**
* Faça um programa usando Lock para simular a atualização de um contador que é acessado por múltiplas threads.
* contador pode diminuir e aumentar.
* @author Luiz A S Silveira
**/


import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main {
    static class Count extends Thread {
        int valor;
        Lock lock;
        private int valorMaximo;

        public Count(Lock lock, int valorMaximo) {
            this.lock = lock;
            this.valorMaximo = valorMaximo;
        }

        @Override
        public void run() {
            Random gerador = new Random();

            while(true) {
                try {
                    if(gerador.nextInt(2) == 1)
                        increment();
                    else
                        decrement();
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                    return;
                }
            }
        }

        public void increment() {
            System.out.println(this.getName() + " Incrementando");
            lock.lock();
            try{
                valor ++;
            } finally {
                lock.unlock();
            }
        }

        public void decrement() {
            System.out.println(this.getName() + " Decrementando");
            lock.lock();
            try{
                valor --;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Count(lock, 1000).start();
        new Count(lock, 1000).start();
        new Count(lock, 1000).start();
        new Count(lock, 1000).start();
        new Count(lock, 1000).start();
        new Count(lock, 1000).start();
        }

}

