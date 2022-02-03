import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
 * Last update: 03/02/2022
 */

public class SimpleCalculator extends JFrame implements ActionListener {

	// private DecimalFormat df = new DecimalFormat("#.0000");
	
	// Symbols of the first line of buttons
	private String[] cSymb = {
			"CE", "C", "DEL"
	};
	
	// Rest of symbols
	private String[] symb = {
			"√", "x²", "%", "X",
			"7", "8", "9", "÷",
			"4", "5", "6", "+",
			"1", "2", "3", "-",
			"±", "0", ".", "="
	};
	
	private JPanel panel = new JPanel(new BorderLayout(2, 2)); // Outer panel
	private JPanel pan1 = new JPanel(new BorderLayout(1, 1)); // Text panel
	private JPanel pan2 = new JPanel(new BorderLayout(1, 1)); // Buttons panel
	private JPanel cPan = new JPanel(new GridLayout(1, 3, 1, 1)); // Button panel group 1
	private JPanel btnPan = new JPanel(new GridLayout(5, 4, 1, 1)); // Button panel group 2
	private JButton[] cBtns = new JButton[3]; // Buttons of "cSymb"
	private JButton[] btns = new JButton[20]; // Buttons of "symb"
	
	JLabel calcText = new JLabel("0"); // Lower text (Typed text and/or results)
	JLabel holdText = new JLabel(" "); // Upper text (equation)
	
	private int opt = 0; // Holds the equation
	
	private double firstN = 0, secN = 0, holdN = 0; // Holds the numbers for the equations
	
	private boolean repeat = false; // Checks if the equation should be repeated
	
	public SimpleCalculator()
	{ 
		addComponentsToPanels();
	}
	
	private void addComponentsToPanels() {
		
		// Adds the first roll of buttons (C, CE, DEL)
		for(int i = 0; i < cSymb.length; i++) {
			
			cBtns[i] = new JButton(cSymb[i]); // Creates the button
			
			// Configures the appearance of the button
			cBtns[i].setOpaque(false);
			cBtns[i].setBorderPainted(false);
			cBtns[i].setFont(new Font("Arial", Font.BOLD, 22));
			cBtns[i].setFocusPainted(false);
			
			cBtns[i].addActionListener(this); // Add an action listener to the button
			cPan.add(cBtns[i]); // Add button to panel
		}
		// Adds the remaining buttons
		for(int i = 0; i < symb.length; i++) {
			
			btns[i] = new JButton(symb[i]); // Creates the button
			
			// Configures the appearance of the button
			btns[i].setBorderPainted(false);
			btns[i].setOpaque(false);
			btns[i].setFont(new Font("Arial", Font.BOLD, 22));
			btns[i].setFocusPainted(false);
			
			btns[i].addActionListener(this); // Add an action listener to the button
			btnPan.add(btns[i]); // Add button to panel
		}

		// Function maps the buttons after creation
		keyboardMap();
		
		// Create an border around the text
		pan1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		
		// Configures the appearance of the text
		calcText.setFont(new Font("Serif",Font.BOLD,30)); // Sets the font size, location, etc
		calcText.setHorizontalAlignment(SwingConstants.RIGHT); // Sets the text to be on the right
		holdText.setFont(new Font("Serif",Font.PLAIN,20)); // Sets the font size, location, etc
		holdText.setHorizontalAlignment(SwingConstants.RIGHT); // Sets the text to be on the right	
		
		pan1.add(holdText, BorderLayout.NORTH); // Adds the upper text to the panel
		pan1.add(calcText, BorderLayout.CENTER); // Adds the lower text to the panel
		pan2.add(cPan, BorderLayout.NORTH); // Adds the first row of buttons to the panel
		pan2.add(btnPan, BorderLayout.CENTER); // Adds the other buttons to the panel
		
		panel.add(pan1, BorderLayout.NORTH); // Adds panel with the text to the main panel
		panel.add(pan2, BorderLayout.CENTER); // Adds panel with the buttons to the main panel
		add(panel, BorderLayout.CENTER); // Adds panel to the application
		
        setTitle("Simple Calculator"); // Sets the title
        setSize(357,417); // Defines the bounds of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programs closes when exits
        setResizable(false); // And the program its not resizable
        setVisible(true); // Makes the frame visible 
		
	}
	
	private void keyboardMap() {
		
		// Maps C, CE and DEL buttons
		clickOnKey( cBtns[0], "actionPerformed", KeyEvent.VK_SPACE );	
		clickOnKey( cBtns[1], "actionPerformed", KeyEvent.VK_DELETE );	
		clickOnKey( cBtns[2], "actionPerformed", KeyEvent.VK_BACK_SPACE );	
		
		// Maps operations (keyboard)
		clickOnKey( btns[3], "actionPerformed", KeyEvent.VK_ASTERISK );		
		clickOnKey( btns[7], "actionPerformed", KeyEvent.VK_SLASH );
		clickOnKey( btns[11], "actionPerformed", KeyEvent.VK_PLUS );		
		clickOnKey( btns[15], "actionPerformed", KeyEvent.VK_MINUS );
		clickOnKey( btns[18], "actionPerformed", KeyEvent.VK_PERIOD );
		clickOnKey( btns[19], "actionPerformed", KeyEvent.VK_EQUALS );
		
		// Maps operations (numpad)
		clickOnKey( btns[3], "actionPerformed", KeyEvent.VK_MULTIPLY );		
		clickOnKey( btns[7], "actionPerformed", KeyEvent.VK_DIVIDE );
		clickOnKey( btns[11], "actionPerformed", KeyEvent.VK_ADD );		
		clickOnKey( btns[15], "actionPerformed", KeyEvent.VK_SUBTRACT );
		clickOnKey( btns[18], "actionPerformed", KeyEvent.VK_DECIMAL );
		clickOnKey( btns[19], "actionPerformed", KeyEvent.VK_ENTER );		

		// Maps numbers (keyboard)
		clickOnKey( btns[17], "actionPerformed", KeyEvent.VK_0 );
		clickOnKey( btns[12], "actionPerformed", KeyEvent.VK_1 );
		clickOnKey( btns[13], "actionPerformed", KeyEvent.VK_2 );
		clickOnKey( btns[14], "actionPerformed", KeyEvent.VK_3 );
		clickOnKey( btns[8], "actionPerformed", KeyEvent.VK_4 );
		clickOnKey( btns[9], "actionPerformed", KeyEvent.VK_5);
		clickOnKey( btns[10], "actionPerformed", KeyEvent.VK_6 );
		clickOnKey( btns[4], "actionPerformed", KeyEvent.VK_7 );
		clickOnKey( btns[5], "actionPerformed", KeyEvent.VK_8 );
		clickOnKey( btns[6], "actionPerformed", KeyEvent.VK_9 );
		
		// Maps numbers (numpad)
		clickOnKey( btns[17], "actionPerformed", KeyEvent.VK_NUMPAD0 );
		clickOnKey( btns[12], "actionPerformed", KeyEvent.VK_NUMPAD1 );
		clickOnKey( btns[13], "actionPerformed", KeyEvent.VK_NUMPAD2 );
		clickOnKey( btns[14], "actionPerformed", KeyEvent.VK_NUMPAD3 );
		clickOnKey( btns[8], "actionPerformed", KeyEvent.VK_NUMPAD4 );
		clickOnKey( btns[9], "actionPerformed", KeyEvent.VK_NUMPAD5);
		clickOnKey( btns[10], "actionPerformed", KeyEvent.VK_NUMPAD6 );
		clickOnKey( btns[4], "actionPerformed", KeyEvent.VK_NUMPAD7 );
		clickOnKey( btns[5], "actionPerformed", KeyEvent.VK_NUMPAD8 );
		clickOnKey( btns[6], "actionPerformed", KeyEvent.VK_NUMPAD9 );
		
	}

	// Calls button functionality when respective key is pressed
	public static void clickOnKey(
		    final AbstractButton button, String actionName, int key )
		{
		    button.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW )
		        .put( KeyStroke.getKeyStroke( key, 0 ), actionName );

		    button.getActionMap().put( actionName, new AbstractAction()
		    {
		        @Override
		        public void actionPerformed( ActionEvent e )
		        {
		            button.doClick();
		        }
		    } );
		}
	
    @Override
    public void actionPerformed(ActionEvent e) 
    {
    	// Gets the button symbol and does the respective action with "doActions"
    	String btnClick = e.getActionCommand();     	
    	doActions(btnClick);
    	
    }
	
	private void doActions(String btnClick) {
		
		switch(btnClick) {
    	
		// Add numbers to "calcText"
		case "0":
			if(calcText.getText() != "0")
				calcText.setText(calcText.getText() + "0");
			repeat = false;
			break;
		case "1":
			if(calcText.getText() == "0")
				calcText.setText("1");
			else
				calcText.setText(calcText.getText() + "1");
			repeat = false;
			break;
		case "2":
			if(calcText.getText() == "0")
				calcText.setText("2");
			else
				calcText.setText(calcText.getText() + "2");
			repeat = false;
			break;
		case "3":
			if(calcText.getText() == "0")
				calcText.setText("3");
			else
				calcText.setText(calcText.getText() + "3");
			repeat = false;
			break;
		case "4":
			if(calcText.getText() == "0")
				calcText.setText("4");
			else
				calcText.setText(calcText.getText() + "4");
			repeat = false;
			break;
		case "5":
			if(calcText.getText() == "0")
				calcText.setText("5");
			else
				calcText.setText(calcText.getText() + "5");
			repeat = false;
			break;
		case "6":
			if(calcText.getText() == "0")
				calcText.setText("6");
			else
				calcText.setText(calcText.getText() + "6");
			repeat = false;
			break;
		case "7":
			if(calcText.getText() == "0")
				calcText.setText("7");
			else
				calcText.setText(calcText.getText() + "7");
			repeat = false;
			break;
		case "8":
			if(calcText.getText() == "0")
				calcText.setText("8");
			else
				calcText.setText(calcText.getText() + "8");
			repeat = false;
			break;
		case "9":
			if(calcText.getText() == "0")
				calcText.setText("9");
			else
				calcText.setText(calcText.getText() + "9");
			repeat = false;
			break;
		
		// Does the operations
		case "X":
			// Multiplication
			opt = 1;
			firstN = Double.parseDouble(calcText.getText());
			holdText.setText(numberFormating(firstN) + " X ");
			calcText.setText("0");
			repeat = false;
			break;
		case "÷":
			// Division
			opt = 2;
			firstN = Double.parseDouble(calcText.getText());
			holdText.setText(numberFormating(firstN) + "/");
			calcText.setText("0");
			repeat = false;
			break;
		case "+":
			// Sum
			opt = 3;
			firstN = Double.parseDouble(calcText.getText());
			holdText.setText(numberFormating(firstN) + " + ");
			calcText.setText("0");
			repeat = false;
			break;
		case "-":
			// Subtraction
			opt = 4;
			firstN = Double.parseDouble(calcText.getText());
			holdText.setText(numberFormating(firstN) + " - ");
			calcText.setText("0");
			repeat = false;
			break;
		case "√":
			// Square root
			firstN = Double.parseDouble(calcText.getText());
			holdText.setText("√(" + numberFormating(firstN) + ")");
			calcText.setText(""+ numberFormating(Math.sqrt(firstN)));
			break;
		case "x²":
			// Squares
			firstN = Double.parseDouble(calcText.getText());
			holdText.setText("(" + numberFormating(firstN) + ")²");
			calcText.setText(""+ numberFormating(Math.pow(firstN, 2)));
			break;
		case "%":
			// Percentages
			if (holdText.getText() != " ") {
				secN = Double.parseDouble(calcText.getText());
				runPercentage();
				repeat = true;
			}
			break;
		case "=":
			// Gives the result
			if (holdText.getText() != " ") {
				if (!repeat)
					secN = Double.parseDouble(calcText.getText());
				runopt();
				repeat = true; // With true, repeats the operation
			}
			break;
			
		// Formating
		case "C":
			// Deletes all text (resets the calculator)
			calcText.setText("0");
			holdText.setText(" ");
			break; 
		case "CE":
			// Deletes current text (calcText)
			calcText.setText("0");
			break; 
		case "DEL":
			// Deletes last char of the current text (calcText)
			if(calcText.getText().length() - 1 > 0)
				calcText.setText(calcText.getText().substring(0, calcText.getText().length() - 1));
			else
				calcText.setText("0");
			break; 
		case "±":
			// Changes signal of the number in "calcText"
			firstN = Double.parseDouble(calcText.getText()) * (-1);
			if (firstN != -0)
				calcText.setText(numberFormating(firstN));
			break;
		case ".":
			// Adds decimal places in the number on "calcText"
			if(!calcText.getText().contains("."))
				calcText.setText(calcText.getText() + ".");
			break;    
		default:
			break;
			
		}
		
		
	}

	private void runPercentage() {
		
		if(repeat) {
			// Dont loses the percent value when user repeats the operation
			secN = holdN;
			firstN = Double.parseDouble(calcText.getText());
		}
		else {
			// Holds the percentage
			holdN = secN;
		}
		
		// Gets the X% value and then runs the operations
		secN = secN * firstN;
		secN = secN / 100;
		runopt();		

		// Formating variables
		String getSymbol = "";
		double tempNum = 0;
		
		switch(opt) {
		// Gets the current working symbol/operation
		case 1:
			getSymbol = " X ";
			tempNum = Double.parseDouble(calcText.getText()) / 100; // Formats the result after multiplication
			calcText.setText(numberFormating(tempNum));
			break;
		case 2:
			getSymbol = "/";
			tempNum = Double.parseDouble(calcText.getText()) * 100; // Formats the result after division
			calcText.setText(numberFormating(tempNum));
			break;
		case 3:
			getSymbol = " + ";
			break;
		case 4:
			getSymbol = " - ";
			break;
		default:
			break;
		}
		
		// Puts the operation formated in "holdText"
		holdText.setText(numberFormating(firstN) + getSymbol + numberFormating(holdN) + "%");
		
	}

	private void runopt() {
		
		if(repeat) {
			// Dont loses the working value when user repeats the operation
			secN = holdN;
			firstN = Double.parseDouble(calcText.getText());
		}
		else {
			// Holds the working value
			holdN = secN;
		}
		
		switch(opt) {
		// Do the basic operations
		// 1-Multiplication, 2-Division, 3-Sum, 4-Subtraction
		case 1:
			calcText.setText(numberFormating(firstN * secN));
			holdText.setText(numberFormating(firstN) + " X " + numberFormating(secN));
			break;
		case 2:
			if(secN != 0) {
				calcText.setText(numberFormating(firstN / secN));
				holdText.setText(numberFormating(firstN) + " / " + numberFormating(secN));
			}
			else {
				holdText.setText("Division by 0 is not possible");
			}
			break;
		case 3:
			calcText.setText(numberFormating(firstN + secN));
			holdText.setText(numberFormating(firstN) + " + " + numberFormating(secN));
			break;
		case 4:
			calcText.setText(numberFormating(firstN - secN));
			holdText.setText(numberFormating(firstN) + " - " + numberFormating(secN));
			break;
		default:
			break;
		}
		
	}

	private String numberFormating(double num) {
		
		// This function removes 0s in the decimal places if there is only 0s
		
		String tempNum[] = {
				"" + num
		};
		
		tempNum = tempNum[0].split("\\."); // Regex to split the number in the decimal
		
		if(tempNum[1].matches("[0]+")) // Regex to gets the zeroes
			return tempNum[0];
		else
			return tempNum[0] + "." + tempNum[1];
	}

	public static void main(String[] args) {
		
		new SimpleCalculator();

	}

}