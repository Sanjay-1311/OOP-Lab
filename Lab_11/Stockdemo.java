package Lab_11;
class stock {
    private int items= 0;
    int capacity= 5;

    synchronized void add() {
        while (items== capacity) {
            System.out.println("stock full producer waiting.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        items =items+1;
        System.out.println("1 item added, stock= " + items);
        notify();
    }

    synchronized void get() {
        while (items== 0) {
            System.out.println("stock empty consumer waiting.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        items= items - 1;
        System.out.println("1 item removed, stock= " + items);
        notify();
    }
}

class producer extends Thread {
    stock s;
    producer(stock s) {
        this.s = s;
    }
    public void run() {
        for (int i = 0; i < 7; i++) {
            s.add();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class consumer extends Thread {
    stock s;
    consumer(stock s) {
        this.s = s;
    }
    public void run() {
        for (int i = 0; i < 7; i++) {
            s.get();
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class Stockdemo {
    public static void main(String[] args) {
        stock s=new stock();
        producer p=new producer(s);
        consumer c=new consumer(s);
        p.start();
        c.start();
    }
} 
