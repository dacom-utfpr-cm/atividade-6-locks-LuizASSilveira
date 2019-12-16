package ex2;
class Produtor extends Thread {

    SharedFifoQueue fifo;
    Produtor(SharedFifoQueue fifo) {
        this.fifo = fifo;
    }

    @Override
    public void run() {
        while (true) {
            fifo.produzir();
        }
    }
}