import java.io.IOException;
import java.util.Vector;

/**
 * Class that gets input from user and finds elements of function using inicsal method
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
    public float solve(Vector<Float> coefficients, float fromBorder, float toBorder, float eps, int max) throws IOException{
        float x1 = fromBorder;
        float x2 = toBorder;
        float tmp;
        if(fromBorder >= toBorder)throw new IOException("Wrong border values");
        if(checkValues(x1, x2, coefficients)) throw new IOException("Values of function have the same sign");
        if(ifDerivativeHaveZeroPoint(coefficients, fromBorder, toBorder, eps, max))throw new IOException("Function have extereme in this section");
        if(eps <= 0)throw new IOException("Eps must be over 0");
        if(max <= 0)throw new IOException("Max must be over 0");
        while(--max >= 0 && Math.abs(x1 - x2) > eps){
            tmp = findZeroPointLinear(x1, x2, coefficients);
            x1 = x2;
            x2 = tmp;
            System.out.println(x1 + " " + x2);
        }
        System.out.println(max);
        if(max <= 0)throw new IOException("Max was not enought to find zero point with that precision");
        return x2;
    }
    /**
     * Finds value of function for argument
     * @param x argument
     * @param coefficients what function
     * @return value of function
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
    /**
     * Method checks if function have extreme in this section using midway method
     * @param coefficients function
     * @param fromBorder start of section
     * @param toBorder end of section
     * @param eps precision
     * @param max max iteration
     * @return
     */
    private boolean ifDerivativeHaveZeroPoint(Vector<Float> coefficients, float fromBorder, float toBorder, float eps, int max){
        Vector<Float> derivativeCoe = new Vector<Float>();
        for(int i = 0; i < coefficients.size() - 1; i++)
            derivativeCoe.add(coefficients.get(i) * (coefficients.size() - i - 1));
        float x1 = fromBorder;
        float x2 = toBorder;
        float x0;
        float fx0;
        if(!checkValues(x1, x2, derivativeCoe)) return false;
        while(max-- > 0 && Math.abs(x1 - x2) > eps){
            x0 = (x1 + x2) / 2;
            fx0 = getValueOfFunction(x0, derivativeCoe);
            //If value of function is 0.001 away from 0
            if(fx0 < 0.001 && fx0 > 0.001) return true;
            if(checkValues(x1, x2, derivativeCoe)){
                x2 = x0;
            }else
                x1 = x0;
        }
        return false;
    }
}
