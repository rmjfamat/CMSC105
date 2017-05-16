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
	    
	    method1.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {	 
	    	  sampleChoice(1);	
	      }
	    });
	    
	   method2.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {	
	    	sampleChoice(2);	        
	      }
	    });
	    
	   method3.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {	 
	    	  sampleChoice(3);	
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
	
	private void sampleChoice(int choice){
		JFrame lab1 = new JFrame();
		JLabel label = new JLabel("BASIC SAMPLING METHODS");
		JRadioButton integer = new JRadioButton("Integer");
		JRadioButton floating = new JRadioButton("Floating Point");
	    JRadioButton character = new JRadioButton("Character");
	    JRadioButton quit = new JRadioButton("Quit");
	    ButtonGroup bg = new ButtonGroup();
		bg.add(integer);
		bg.add(floating);
		bg.add(character);
		bg.add(quit);
	    Box box = Box.createVerticalBox();
	    box.add(label);
	    box.add(integer);
	    box.add(floating);
	    box.add(character);
	    box.add(quit);
	    lab1.add(box);
		lab1.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    lab1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    lab1.setPreferredSize(new Dimension(400, 200));
	    lab1.pack();
	    lab1.setLocationRelativeTo(null);
	    lab1.setVisible(true);
	    
	    String[] list = null;
	    integer.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  String[] data;
	    	  GatherInputSampling askData = new GatherInputSampling(1, lab1, list);
		      data = askData.getData();
		      if(data == null){
		        	new BasicSamplingMethods();
		        }
		        else{
			        DisplaySample sample = new DisplaySample(choice, data);
			        sample.displaySample();
		        }
	      }
	    });
	    floating.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  String[] data;
	    	  GatherInputSampling askData = new GatherInputSampling(2, lab1, list);
		      data = askData.getData();
		      if(data == null){
		        	new BasicSamplingMethods();
		        }
		        else{
			        DisplaySample sample = new DisplaySample(choice, data);
			        sample.displaySample();
		        }
	      }
	    });
	    character.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  String[] data;
	    	  GatherInputSampling askData = new GatherInputSampling(3, lab1, list);
		      data = askData.getData();
		      if(data == null){
		        	new BasicSamplingMethods();
		        }
		        else{
			        DisplaySample sample = new DisplaySample(choice, data);
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
