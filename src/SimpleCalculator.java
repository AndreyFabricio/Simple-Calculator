import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Andrey Fabricio
 * Github: https://github.com/AndreyFabricio
 * LinkedIn: https://www.linkedin.com/in/andrey-fabricio/
 * 
 * A calculator that performs various operations such as addition, 
 * subtraction, multiplication and division of positive and negative values
 * The calculator also does percentages, square roots and squares
 * 
 * Last update: 30/01/2022
 */

public class SimpleCalculator extends JFrame implements ActionListener {

	Container container=getContentPane();
	JLabel calcText = new JLabel("-1.7976931348623157E308 X 1.7976931348623157E308");
	JLabel holdText = new JLabel("1.7976931348623157E308 X 1.7976931348623157E308");
	
	JButton ce = new JButton("CE");
	JButton c = new JButton("C");
	JButton del = new JButton("DEL");
	
	JButton root = new JButton("√");
	JButton square = new JButton("x²");
	JButton percent = new JButton("%");
	JButton multi = new JButton("X");
	JButton div = new JButton("÷");
	JButton sum = new JButton("+");
	JButton subt = new JButton("-");
	JButton equals = new JButton("=");
	JButton posneg = new JButton("±");
	JButton dot = new JButton(".");
	
	JButton seven = new JButton("7");
	JButton eight = new JButton("8");
	JButton nine = new JButton("9");
	JButton four = new JButton("4");
	JButton five = new JButton("5");
	JButton six = new JButton("6");
	JButton one = new JButton("1");
	JButton two = new JButton("2");
	JButton three = new JButton("3");
	JButton zero = new JButton("0");			
	
	SimpleCalculator()
	{
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		addKeyEvent();
	}
	
	public void setLayoutManager()
	{		
		// Container creation
		container.setLayout(null);
	}
	
	public void setLocationAndSize()
	{
		// Bounding the location and size of the objects in the container
		
		// Labels of text
		calcText.setBounds(7,7,336,70);
		calcText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		calcText.setFont(new Font("Serif",Font.BOLD,30)); // Sets the font size, location, etc
		calcText.setHorizontalAlignment(SwingConstants.RIGHT); // Sets the text to be on the right
		calcText.setVerticalAlignment(SwingConstants.BOTTOM); // Sets the text to be on the bottom
		holdText.setBounds(7,7,336,30);
		holdText.setFont(new Font("Serif",Font.PLAIN,20)); // Sets the font size, location, etc
		holdText.setHorizontalAlignment(SwingConstants.RIGHT); // Sets the text to be on the right
		holdText.setVerticalAlignment(SwingConstants.BOTTOM); // Sets the text to be on the bottom		
		
		// Text formaters (deletes char, clear whole text, etc)
		ce.setBounds(7,80,112,50);
		ce.setFocusPainted(false);
		ce.setFont(new Font("Arial", Font.PLAIN, 22));
		c.setBounds(119,80,112,50);
		c.setFocusPainted(false);
		c.setFont(new Font("Arial", Font.PLAIN, 22));
		del.setBounds(231,80,112,50);
		del.setFocusPainted(false);
		del.setFont(new Font("Arial", Font.PLAIN, 22));
		
		// Mathematical signals
		root.setBounds(7,130,84,50);
		root.setFocusPainted(false);
		root.setFont(new Font("Arial", Font.PLAIN, 22));
		square.setBounds(91,130,84,50);
		square.setFocusPainted(false);
		square.setFont(new Font("Arial", Font.PLAIN, 26));
		percent.setBounds(175,130,84,50);
		percent.setFocusPainted(false);
		percent.setFont(new Font("Arial", Font.PLAIN, 22));
		multi.setBounds(259,130,84,50);
		multi.setFocusPainted(false);
		multi.setFont(new Font("Arial", Font.PLAIN, 22));
		div.setBounds(259,180,84,50);
		div.setFocusPainted(false);
		div.setFont(new Font("Arial", Font.PLAIN, 32));
		sum.setBounds(259,230,84,50);
		sum.setFocusPainted(false);
		sum.setFont(new Font("Arial", Font.PLAIN, 32));
		subt.setBounds(259,280,84,50);
		subt.setFocusPainted(false);
		subt.setFont(new Font("Arial", Font.PLAIN, 32));
		equals.setBounds(259,330,84,50);
		equals.setFocusPainted(false);
		equals.setFont(new Font("Arial", Font.PLAIN, 32));
		posneg.setBounds(7,330,84,50);
		posneg.setFocusPainted(false);
		posneg.setFont(new Font("Arial", Font.PLAIN, 32));
		dot.setBounds(175,330,84,50);
		dot.setFocusPainted(false);
		dot.setFont(new Font("Arial", Font.PLAIN, 32));
		
		// Numbers
		seven.setBounds(7,180,84,50);
		seven.setFocusPainted(false);
		seven.setFont(new Font("Arial", Font.PLAIN, 32));
		eight.setBounds(91,180,84,50);
		eight.setFocusPainted(false);
		eight.setFont(new Font("Arial", Font.PLAIN, 32));
		nine.setBounds(175,180,84,50);
		nine.setFocusPainted(false);
		nine.setFont(new Font("Arial", Font.PLAIN, 32));
		four.setBounds(7,230,84,50);
		four.setFocusPainted(false);
		four.setFont(new Font("Arial", Font.PLAIN, 32));
		five.setBounds(91,230,84,50);
		five.setFocusPainted(false);
		five.setFont(new Font("Arial", Font.PLAIN, 32));
		six.setBounds(175,230,84,50);
		six.setFocusPainted(false);
		six.setFont(new Font("Arial", Font.PLAIN, 32));
		one.setBounds(7,280,84,50);
		one.setFocusPainted(false);
		one.setFont(new Font("Arial", Font.PLAIN, 32));
		two.setBounds(91,280,84,50);
		two.setFocusPainted(false);
		two.setFont(new Font("Arial", Font.PLAIN, 32));
		three.setBounds(175,280,84,50);
		three.setFont(new Font("Arial", Font.PLAIN, 32));
		three.setFocusPainted(false);
		zero.setBounds(91,330,84,50);
		zero.setFont(new Font("Arial", Font.PLAIN, 32));
		zero.setFocusPainted(false);
		
	}
	
	public void addComponentsToContainer()
	{
		
		// Puts the objects in the container
		
		container.add(calcText);
		container.add(holdText);
		
		container.add(ce);
		container.add(c);
		container.add(del);
		
		container.add(root);
		container.add(square);
		container.add(percent);
		container.add(multi);
		container.add(div);
		container.add(sum);
		container.add(subt);
		container.add(equals);
		container.add(posneg);
		container.add(dot);
		
		container.add(one);
		container.add(two);
		container.add(three);
		container.add(four);
		container.add(five);
		container.add(six);
		container.add(seven);
		container.add(eight);
		container.add(nine);
		container.add(zero);
	    
	}
	
	public void addActionEvent()
	{
		// Creates the button listener
		
		//btn.addActionListener(this); 
	}
	
	public void addKeyEvent()
	{
		// Creates the enter key listener
		
		//userTextField.addActionListener(this); 
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
		SimpleCalculator frame=new SimpleCalculator(); // Creates a new frame
        frame.setTitle("Simple Calculator"); // Sets the title
        frame.setBounds(10,10,357,417); // Defines the bounds of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programs closes when exits
        frame.setResizable(false); // And the program its not resizable
        frame.setVisible(true); // Makes the frame visible 

	}

}
