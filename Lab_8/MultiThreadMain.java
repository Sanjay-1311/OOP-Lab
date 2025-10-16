package Lab_8;



public class MultiThreadMain {
    public static void main(String[] args) {
        Thread1 randObj = new Thread1();
        Thread2 squareObj = new Thread2();
        Thread3 cubeObj = new Thread3();

        Thread t = new Thread(() -> {

            while (true) {
                int num = randObj.randomgen(); 
                System.out.println("\nGenerated Number: " + num);

                if (num % 2 != 0) {
                    new Thread(() -> cubeObj.function3(num)).start();
                } else {
                    new Thread(() -> squareObj.function2(num)).start();
                }

                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
    }
}

