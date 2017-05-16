package IntegratedDataHandling;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class DescriptiveStatistics extends JFrame{
	
	public DescriptiveStatistics(){
		
	}
	
	public void display(){
		JFrame lab3 = new JFrame();
		JLabel label = new JLabel("DESCRIPTIVE STATISTICS");
		JRadioButton ungrouped = new JRadioButton("Ungrouped Data");
	    JRadioButton grouped = new JRadioButton("Grouped Data");
	    JRadioButton quit = new JRadioButton("Quit");
	    ButtonGroup bg = new ButtonGroup();
		bg.add(ungrouped);
		bg.add(grouped);
		bg.add(quit);
	    Box box = Box.createVerticalBox();
	    box.add(label);
	    box.add(ungrouped);
	    box.add(grouped);
	    box.add(quit);
	    lab3.add(box);
		lab3.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    lab3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    lab3.setPreferredSize(new Dimension(400, 200));
	    lab3.pack();
	    lab3.setLocationRelativeTo(null);
	    lab3.setVisible(true);
	    
	    ungrouped.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	       sampleFrame(1);
	      }
	    });
	    grouped.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        sampleFrame(2);
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
	
	private void sampleFrame(int choice){
		JFrame lab3 = new JFrame();
		JLabel label = new JLabel("Numerical Data Type");
		JRadioButton integer = new JRadioButton("Integer");
	    JRadioButton floating = new JRadioButton("Floating Point");
	    JRadioButton quit = new JRadioButton("Quit");
	    ButtonGroup bg = new ButtonGroup();
		bg.add(integer);
		bg.add(floating);
		bg.add(quit);
	    Box box = Box.createVerticalBox();
	    box.add(label);
	    box.add(integer);
	    box.add(floating);
	    box.add(quit);
	    lab3.add(box);
		lab3.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    lab3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    lab3.setPreferredSize(new Dimension(400, 200));
	    lab3.pack();
	    lab3.setLocationRelativeTo(null);
	    lab3.setVisible(true);
	    List list = null;
	    integer.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  if (choice == 1){
	    		  List data;
	    		  GatherInputDescStat askData = new GatherInputDescStat(1, lab3, list);
			      data = askData.getData();
			      if(data == null){
			        	new DescriptiveStatistics();
			        }
			        else{
				        
			        }
	    	  }
	      }
	    });
	    floating.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  if (choice == 1){
	    		  List data;
	    		  GatherInputDescStat askData = new GatherInputDescStat(2, lab3, list);
			      data = askData.getData();
			      if(data == null){
			        	new DescriptiveStatistics();
			        }
			        else{
				        
			        }
	    	  }
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
}

