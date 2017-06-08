
import java.io.IOException;

/**
 * Main class of program. Purpose of program is to find elements of function using inicsal method.
 * User gives coefficients of the polynomial, borders, precision and max number of iteration.
 * @author Kucharczyk
 *
 */
public class Main {
    private InputReader inputReader;
    
    public static void main(String[] args)  { 
        Main main = new Main();
        main.init();
    }
    
    private void init(){
        inputReader = new InputReader();
        try {
            inputReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
