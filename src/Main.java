
import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Main class of program. Purpose of program is to find elements of function using inicsal method.
 * User gives coefficients of the polynomial, borders, precision and max number of iteration.
 * @author Kucharczyk
 *
 */
public class Main {
    public static void main(String[] args)  { 
        EventQueue.invokeLater(new Runnable() { 
            @Override
            public void run() {
                MainFrame frame = new MainFrame(); 
                frame.setTitle("Sas Project");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true); 
            }
        });
    }
}
