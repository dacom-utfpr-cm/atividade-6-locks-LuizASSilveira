package ex3;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Faça uma classe ArrayListThreadSafe usando ReadWriteLock. Teste usando threads que realizam leitura e escrita
 * para essa estrutura.
 * @author Luiz A S Silveira
 **/

public class Main {
    public static void main(String[] args) {
        ArrayListThreadSafe array = new ArrayListThreadSafe(new ReentrantReadWriteLock(true));

        for (int i = 0; i < 10; i++) {
            new Consumidor(array).start();
            new Produtor(array).start();
        }
    }
}
