package ex2;

/**
 * Crie uma classe SharedFifoQueue e use Conditions para controlar se a fila está vazia ou cheia. Teste usando threads
 * produtoras e consumidoras.
 * @author Luiz A S Silveira
 **/

public class Main {
    public static void main(String[] args) {
        SharedFifoQueue fifo = new SharedFifoQueue(7);

        for (int i = 0; i < 10; i++) {
            new Consumidor(fifo).start();
            new Produtor(fifo).start();
        }

    }
}
