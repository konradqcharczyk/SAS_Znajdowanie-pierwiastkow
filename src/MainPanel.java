import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Contains all components of view, reads inforamion from user and calls solver
 * @author Kucharczyk
 *
 */
public class MainPanel extends JPanel{

    private static final long serialVersionUID = 1L;
    private JLabel coefficientsLabel, fromLabel, toLabel, epsLabel, maxLabel, result;
    private JTextField coefficientsTF, fromTF, toTF, epsTF, maxTF;
    private JButton startButton;
    private Solver solver;
    
    private Vector<Float> coefficients;
    private float from, to, eps;
    private int max;
    
    /**
     * Class constructor
     * @param solver logic of program
     */
    public MainPanel(Solver solver){
        this.solver = solver;
        setLayout(new GridLayout(6, 2, 10, 10));
        addCoefficients();
        addFrom();
        addTo();
        addEps();
        addMax();
        addButton();
        addResult();
    }
    /**
     * Adds "coefficient" label and text field
     */
    private void addCoefficients(){
        coefficientsLabel = new JLabel("Coefficients");
        coefficientsTF = new JTextField();
        coefficientsTF.setToolTipText("a b c d ... format");
        add(coefficientsLabel);
        add(coefficientsTF);
    }
    /**
     * Adds "from" label and text field
     */
    private void addFrom(){
        fromLabel = new JLabel("Border from");
        fromTF = new JTextField();
        add(fromLabel);
        add(fromTF);
    }
    /**
     * Adds "to" label and text field
     */
    private void addTo(){
        toLabel = new JLabel("Border to");
        toTF = new JTextField();
        add(toLabel);
        add(toTF);
    }
    /**
     * Adds "Eps" label and text field
     */
    private void addEps(){
        epsLabel = new JLabel("Eps(precision)");
        epsTF = new JTextField();
        add(epsLabel);
        add(epsTF);
    }
    /**
     * Adds "max" label and text field
     */
    private void addMax(){
        maxLabel = new JLabel("Maximum iteration");
        maxTF = new JTextField();
        add(maxLabel);
        add(maxTF);
    }
    /**
     * Adds start button which starts reading info and calls solver
     */
    private void addButton(){
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readInfo();
                try {
                    result.setText(solver.solve(coefficients, from, to, eps, max) + "");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(new JFrame(),
                            e1.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        add(startButton);
    }
    /**
     * Adds result label
     */
    private void addResult(){
        result = new JLabel("", SwingConstants.CENTER);
        add(result);
    }
    /**
     * Reads info from all text fields
     */
    private void readInfo(){
        String[] coefficientTable = coefficientsTF.getText().split(" ");
        coefficients = new Vector<Float>();
        for(String s : coefficientTable)
            coefficients.add(Float.parseFloat(s));
        System.out.println(coefficients);
        from = Float.parseFloat(fromTF.getText());
        to = Float.parseFloat(toTF.getText());
        eps = Float.parseFloat(epsTF.getText());
        max = Integer.parseInt(maxTF.getText());
    }
}
