package ex3;


class Produtor extends Thread {
    ArrayListThreadSafe array;
    Produtor(ArrayListThreadSafe array) {
        this.array = array;
    }

    @Override
    public void run() {
        while(true) {
            array.escrever();
        }
    }
}