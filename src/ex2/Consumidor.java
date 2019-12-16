package ex2;

class Consumidor extends Thread {
    SharedFifoQueue fifo;
    Consumidor(SharedFifoQueue fifo) {
        this.fifo = fifo;
    }
    @Override
    public void run() {
        while (true) {
            fifo.consumir();
        }
    }
}