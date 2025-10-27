class msg implements Runnable{
    String text;
    msg(String text){
        this.text=text;
    }
    public void run() {
        for (int i = 0; i<5;i++){
            System.out.println(text);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


public class run {
    public static void main(String[] args) {
        Thread hi= new Thread(new msg("HI"));
        Thread ai= new Thread(new msg("AI"));
        hi.start();
        ai.start();
    }
} 
