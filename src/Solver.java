import java.util.Vector;

/**
 * Class that gets input from user and finds elemetns of function using inicsal method
 * @author Kucharczyk
 *
 */
public class Solver {
    /**
     * Finds element of function
     * @param coefficients coefficients of function
     * @param fromBorder From this point it looks for result
     * @param toBorder To this point it looks for result
     * @param esp precision of founded point
     * @param max maximum value of iteration of program
     */
    public float solve(Vector<Float> coefficients, float fromBorder, float toBorder, float eps, int max){
        float x1 = fromBorder;
        float x2 = toBorder;
        checkValues(x1, x2, coefficients);
        float tmp;
        while(max-- > 0){
            tmp = findZeroPointLinear(x1, x2, coefficients);
            x1 = x2;
            x2 = tmp;
            if(Math.abs(x1 - x2) < eps) break;
            System.out.println(x1 + "  " + x2);
        }
        return x2;
    }
    /**
     * Finds value of function for argument
     * @param x argument
     * @param coefficients what function
     * @return value of funciton
     */
    private float getValueOfFunction(float x, Vector<Float> coefficients){
        float sum = 0;
        for(int i = 0; i < coefficients.size(); i++){
            sum += coefficients.get(i) * Math.pow(x,coefficients.size() - i - 1);
        }
        return sum;
    }
    /**
     * Finds zero point of linear function based on two points
     * @param x1 first point
     * @param x2 second point
     * @param coefficients function
     * @return x of zero point
     */
    private float findZeroPointLinear(float x1, float x2, Vector<Float> coefficients){
        float a = (getValueOfFunction(x1, coefficients) - getValueOfFunction(x2, coefficients)) / (x1 - x2);
        float b = getValueOfFunction(x1, coefficients) - a*x1;
        return -b/a;
    }
    /**
     * Checks if function are at both sides of OX axle 
     * @param x1 First argument
     * @param x2 Second argument
     * @param coefficients Function
     * @return true if there is - false if not
     */
    private boolean checkValues(float x1, float x2, Vector<Float> coefficients){
        if((getValueOfFunction(x1, coefficients) * (getValueOfFunction(x1, coefficients)) < 0))
            return true;
        return false;
     }
}
