class bank{
    private int balance =0;
    synchronized void deposit(int amt){
        balance=balance+amt;
        System.out.println(amt+" was deposited, "+balance+" is balance");
        notify();
    }
    synchronized void withdraw(int amt){
        while (balance < amt){
            System.out.println("not enough money, waiting.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        balance=balance-amt;
        System.out.println(amt+" was withdrawn, "+balance+" is balance");
    }

}
class dep extends Thread{
    bank acc;
    dep(bank acc){
        this.acc=acc;
    }
    public void run(){
        int[] values={1000, 1500, 2000};
        for (int amt:values){
            acc.deposit(amt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
class wit extends Thread{
    bank acc;
    wit(bank acc){
        this.acc=acc;
    }
    public void run(){
        int[] values={500, 2500, 1000};
        for (int amt:values){
            acc.withdraw(amt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
public class BankThread {
    public static void main(String[] args) {
        bank acc = new bank();
        wit w= new wit(acc);
        dep d= new dep(acc);
        d.start();
        w.start();
    }
} 
