package IntegratedDataHandling;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class SummarizingAndPresentingData extends JFrame{
	
	public SummarizingAndPresentingData(){
		
	}
	
	public void display(){
		JFrame lab2 = new JFrame();
		JLabel label = new JLabel("SUMMARIZING AND PRESENTING DATA");
		JRadioButton numerical = new JRadioButton("Numerical");
	    JRadioButton categorical = new JRadioButton("Categorical");
	    JRadioButton quit = new JRadioButton("Quit");
	    Box box = Box.createVerticalBox();
	    box.add(label);
	    box.add(numerical);
	    box.add(categorical);
	    box.add(quit);
	    lab2.add(box);
		lab2.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    lab2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    lab2.setPreferredSize(new Dimension(400, 200));
	    lab2.pack();
	    lab2.setLocationRelativeTo(null);
	    lab2.setVisible(true);
	    
	    
	    quit.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        System.exit(0);
	      }
	    });
	}
}

