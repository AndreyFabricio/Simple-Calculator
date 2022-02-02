import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * @author Andrey Fabricio
 * Github: https://github.com/AndreyFabricio
 * LinkedIn: https://www.linkedin.com/in/andrey-fabricio/
 * 
 * A calculator that performs various operations such as addition, 
 * subtraction, multiplication and division of positive and negative values
 * The calculator also does percentages, square roots and squares
 * 
 * Last update: 02/02/2022
 */

public class SimpleCalculator extends JFrame implements ActionListener {

	private DecimalFormat df = new DecimalFormat("#.0000");
	
	private String[] cSymb = {
			"CE", "C", "DEL"
	};
	
	private String[] symb = {
			"√", "x²", "%", "X",
			"7", "8", "9", "÷",
			"4", "5", "6", "+",
			"1", "2", "3", "-",
			"±", "0", ".", "="
	};
	
	private JPanel panel = new JPanel(new BorderLayout(2, 2));
	private JPanel pan1 = new JPanel(new BorderLayout(1, 1));
	private JPanel pan2 = new JPanel(new BorderLayout(1, 1));
	private JPanel cPan = new JPanel(new GridLayout(1, 3, 1, 1));
	private JPanel btnPan = new JPanel(new GridLayout(5, 4, 1, 1));
	private JButton[] cBtns = new JButton[3];
	private JButton[] btns = new JButton[20];
	
	JLabel calcText = new JLabel("0");
	JLabel holdText = new JLabel("1");
	
	private int opt = 0;
	
	private double firstN = 0, secN = 0;
	
	public SimpleCalculator()
	{
		addComponentsToPanels();
	}
	
	private void addComponentsToPanels() {
		
		for(int i = 0; i < cSymb.length; i++) {
			
			cBtns[i] = new JButton(cSymb[i]);
			
			cBtns[i].setOpaque(false);
			cBtns[i].setBorderPainted(false);
			cBtns[i].setFont(new Font("Arial", Font.BOLD, 22));
			cBtns[i].setFocusPainted(false);
			cBtns[i].addActionListener(this);
			cPan.add(cBtns[i]);
		}
		for(int i = 0; i < symb.length; i++) {
			
			btns[i] = new JButton(symb[i]);
			
			btns[i].setBorderPainted(false);
			btns[i].setOpaque(false);
			btns[i].setFont(new Font("Arial", Font.BOLD, 22));
			btns[i].setFocusPainted(false);
			btns[i].addActionListener(this);
			btnPan.add(btns[i]);
		}

		pan1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		
		calcText.setFont(new Font("Serif",Font.BOLD,30)); // Sets the font size, location, etc
		calcText.setHorizontalAlignment(SwingConstants.RIGHT); // Sets the text to be on the right
		holdText.setFont(new Font("Serif",Font.PLAIN,20)); // Sets the font size, location, etc
		holdText.setHorizontalAlignment(SwingConstants.RIGHT); // Sets the text to be on the right	
		
		pan1.add(holdText, BorderLayout.NORTH);
		pan1.add(calcText, BorderLayout.CENTER);
		pan2.add(cPan, BorderLayout.NORTH);
		pan2.add(btnPan, BorderLayout.CENTER);
		
		panel.add(pan1, BorderLayout.NORTH);
		panel.add(pan2, BorderLayout.CENTER);
		add(panel, BorderLayout.CENTER);
		
        setTitle("Simple Calculator"); // Sets the title
        setSize(357,417); // Defines the bounds of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programs closes when exits
        setResizable(false); // And the program its not resizable
        setVisible(true); // Makes the frame visible 
		
	}
	
    @Override
    public void actionPerformed(ActionEvent e) 
    {
    	// If the btn is clicked resets "error" and "userTextField"
    	// and calls createFibonacci function
    	
    	
    	/*
    	 * if (e.getSource() == btn || e.getSource() == userTextField) {
        	error.setText("");
        	fbnTextField.setVisible(false);
        	createFibonacci();
        	userTextField.setText(""); // Resets the text field
        }
    	 */
    	
    }
	
	public static void main(String[] args) {
		new SimpleCalculator();

	}

}