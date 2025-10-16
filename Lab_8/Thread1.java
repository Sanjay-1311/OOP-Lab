package Lab_8;
import java.util.Random;

public class Thread1{ 
    public int randomgen(){
        Random random = new Random();
        int randomInt = random.nextInt(100);
        return randomInt;
    }
}
