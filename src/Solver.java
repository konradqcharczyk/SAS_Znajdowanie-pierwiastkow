import java.util.Vector;

/**
 * Class that gets input from user and finds elemetns of function using inicsal method
 * @author Kucharczyk
 *
 */
public class Solver {
    /**
     * Vector that contains all of coeddicients
     */
    private Vector<Float> coefficients;
    /**
     * Borders from where to where elemetns can be found
     */
    private float fromBorder, toBorder;
    /**
     * The accuracy of the calculated value of function element
     */
    private float esp;
    /**
     * Maximum number of iteration calculations
     */
    private int max;
    
    /**
     * Class constructor
     * @param coefficients 
     * @param fromBorder
     * @param toBorder
     * @param esp
     * @param max
     */
    public Solver(Vector<Float> coefficients, float fromBorder, float toBorder, float esp, int max){
        this.coefficients = coefficients;
        this.fromBorder = fromBorder;
        this.toBorder = toBorder;
        this.esp = esp;
        this.max = max;
    }
}
