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

public class BasicSamplingMethods extends JFrame{
	
	public BasicSamplingMethods(){
		
	}
	
	public void display(){
		JFrame lab1 = new JFrame();
		JLabel label = new JLabel("BASIC SAMPLING METHODS");
		JRadioButton method1 = new JRadioButton("Simple Random Sampling Method");
	    JRadioButton method2 = new JRadioButton("Systematic Sampling");
	    JRadioButton method3 = new JRadioButton("Stratified Sampling");
	    JRadioButton quit = new JRadioButton("Quit");
		ButtonGroup bg = new ButtonGroup();
		bg.add(method1);
		bg.add(method2);
		bg.add(method3);
		bg.add(quit);
	    Box box = Box.createVerticalBox();
	    box.add(label);
	    box.add(method1);
	    box.add(method2);
	    box.add(method3);
	    box.add(quit);
	    lab1.add(box);
		lab1.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    lab1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    lab1.setPreferredSize(new Dimension(400, 200));
	    lab1.pack();
	    lab1.setLocationRelativeTo(null);
	    lab1.setVisible(true);
	    
	    String[] list = null;
        GatherInput askData = new GatherInput(lab1, list);
        
	    method1.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {	 
	        String[] data = askData.getData();
	        if(data == null){
	        	new BasicSamplingMethods();
	        }
	        else{
		        DisplaySample sample = new DisplaySample(1, data);
		        sample.displaySample();
	        }
	      }
	    });
	    
	   method2.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {	 
	        String[] data = askData.getData();
	        if(data == null){
	        	new BasicSamplingMethods();
	        }
	        else{
	        	DisplaySample sample = new DisplaySample(2, data);
		        sample.displaySample();
	        }
	        
	      }
	    });
	    
	   method3.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {	 
	        String[] data = askData.getData();
	        if(data == null){
	        	new BasicSamplingMethods();
	        }
	        else{
	        	DisplaySample sample = new DisplaySample(3, data);
		        sample.displaySample();
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
