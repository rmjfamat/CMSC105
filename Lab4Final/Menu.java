package IntegratedDataHandling;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class Menu extends JFrame{
	
	public Menu(){
		
	}
	public void displayMenu() {
		JFrame menu = new JFrame("Measue of Central Tendency and Dispersion");
		JLabel label = new JLabel("MENU");
	    JRadioButton lab1 = new JRadioButton("Basic Sampling Methods");
	    JRadioButton lab2 = new JRadioButton("Summarizing and Presenting Data");
	    JRadioButton lab3 = new JRadioButton("Descritive Statistics");
	    JRadioButton quit = new JRadioButton("Quit");
	    ButtonGroup bg = new ButtonGroup();
		bg.add(lab1);
		bg.add(lab2);
		bg.add(lab3);
		bg.add(quit);
	    Box box = Box.createVerticalBox();
	    box.add(label);
	    box.add(lab1);
	    box.add(lab2);
	    box.add(lab3);
	    box.add(quit);
	    
	    menu.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    menu.add(box);
	    menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    menu.setPreferredSize(new Dimension(400, 200));
	    menu.pack();
	    menu.setLocationRelativeTo(null);
	    menu.setVisible(true);
	    
	    lab1.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	BasicSamplingMethods firstChoice = new BasicSamplingMethods();
	        firstChoice.display();
	      }
	    });
	    
	    lab2.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	SummarizingAndPresentingData secondChoice = new SummarizingAndPresentingData();
	        secondChoice.display();
	      }
	    });
	    
	    lab3.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	DescriptiveStatistics thirdChoice = new DescriptiveStatistics();
	        thirdChoice.display();
	      }
	    });
	    
	    quit.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        System.exit(0);
	      }
	    });
	}
	
	public static void main(String[] args) {
		 Menu show  = new Menu();
		 show.displayMenu();
	  }
	
}
