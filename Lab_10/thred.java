class weather extends Thread{
    public void run(){
        for (int i=0;i<5;i++){
            System.out.println("today is hot, humid and sunny");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
public class thred {
    public static void main(String[] args){
        weather t1= new weather();
        weather t2= new weather();

        t1.start();
        t2.start();
    }
}