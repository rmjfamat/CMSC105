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

public class DescriptiveStatistics extends JFrame{
	
	public DescriptiveStatistics(){
		
	}
	
	public void display(){
		JFrame lab2 = new JFrame();
		JLabel label = new JLabel("DESCRIPTIVE STATISTICS");
		JRadioButton ungrouped = new JRadioButton("Ungrouped Data");
	    JRadioButton grouped = new JRadioButton("Grouped Data");
	    JRadioButton quit = new JRadioButton("Quit");
	    Box box = Box.createVerticalBox();
	    box.add(label);
	    box.add(ungrouped);
	    box.add(grouped);
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

