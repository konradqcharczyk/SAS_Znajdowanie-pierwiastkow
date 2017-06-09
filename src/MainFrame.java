
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Main frame of program
 * @author Kucharczyk
 *
 */
public class MainFrame extends JFrame{
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    
    MainPanel mainPanel;
    Solver solver;
    
    /**
     * Class constructor
     */
    public MainFrame(){
        solver = new Solver();
        setSize(WIDTH, HEIGHT);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        mainPanel = new MainPanel(solver);
        setLocationRelativeTo(null);
        add(mainPanel);
    }

}
