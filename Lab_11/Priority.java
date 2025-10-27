 class demo extends Thread {
    
    String name;
    demo(String name) {
        this.name = name;
    }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name+" is running and count= " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
public class Priority {
    public static void main(String[] args) {
        demo t1=new demo("low prio");
        demo t2=new demo("mid prio");
        demo t3=new demo("high prio");
        t1.setPriority(Thread.MIN_PRIORITY);        
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY); 
        t1.start();
        t2.start();
        t3.start();
    }
} 
