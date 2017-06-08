import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that asks and read info from user
 * @author Kucharczyk
 *
 */
public class InputReader {
    private List<Float> factor;
    public InputReader(){
        factor = new ArrayList<Float>();
    }
    public void read() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 10;
        System.out.println("Podaj wspó³czynniki wielomianu. Jeœli chcesz zakoñczyæ dodawanie wpisz \"E\".");
        do{
            String s = br.readLine();
            i--;
        }while(i > 0);

        System.out.print("Enter Integer:");
        try{
            i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
    }
}
