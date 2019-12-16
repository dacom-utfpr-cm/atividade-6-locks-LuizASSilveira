package ex3;

class Consumidor extends Thread {
    ArrayListThreadSafe array;
    Consumidor(ArrayListThreadSafe array) {
        this.array = array;
    }
    @Override
    public void run() {
        while(true) {
            array.ler();
        }
    }
}