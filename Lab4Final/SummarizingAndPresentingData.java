package IntegratedDataHandling;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
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
	    ButtonGroup bg = new ButtonGroup();
		bg.add(numerical);
		bg.add(categorical);
		bg.add(quit);
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
	    
	    numerical.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        numerical();
	      }
	    });
	    categorical.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        categorical();
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
	
	private void numerical(){
		JFrame lab2 = new JFrame();
		JLabel label = new JLabel("NUMERICAL");
		JRadioButton integer = new JRadioButton("Integer");	//method 1
	    JRadioButton floating = new JRadioButton("Floating Point"); //method 2
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
	    lab2.add(box);
		lab2.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    lab2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    lab2.setPreferredSize(new Dimension(400, 200));
	    lab2.pack();
	    lab2.setLocationRelativeTo(null);
	    lab2.setVisible(true);
	    
	    String[] list = null;
	    integer.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  GatherInputSummarizingData askData = new GatherInputSummarizingData(1, lab2, list);
	    	  String[] data = askData.getData();
	    	  String title = " ";
	    	  List dataSet = new ArrayList();
	    	  if(data == null){
	    		  new SummarizingAndPresentingData();
	    	  }
	    	  else{
		    	  title = askData.getTitle();
		    	  for(int i = 0; i < data.length; i++){
		    		  dataSet.add(data[i]);
		    	  }
	    	  } 
	    	  
	    	  if(data != null && dataSet != null){
	    		  SummarizingAndPresentingDataDisplay disp = new SummarizingAndPresentingDataDisplay();
	    		  disp.Numerical(dataSet, title, 1);
	    	  }
	    	  else{
	    		  new Menu();
	    	  }
	      }
	    });
	    floating.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  GatherInputSummarizingData askData = new GatherInputSummarizingData(2, lab2, list);
	    	  String[] data = askData.getData();
	    	  String title = " ";
	    	  List dataSet = new ArrayList();
	    	  if(data == null){
	    		  new SummarizingAndPresentingData();
	    	  }
	    	  else{
		    	  title = askData.getTitle();
		    	  for(int i = 0; i < data.length; i++){
		    		  dataSet.add(data[i]);
		    	  }
	    	  } 
	    	  
	    	  if(data != null && dataSet != null){
	    		  SummarizingAndPresentingDataDisplay disp = new SummarizingAndPresentingDataDisplay();
	    		  disp.Numerical(dataSet, title, 2);
	    	  }
	    	  else{
	    		  new Menu();
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
	
	private void categorical(){
		JFrame lab2 = new JFrame();
		JLabel label = new JLabel("CATEGORICAL");
		JRadioButton numerical = new JRadioButton("Integer"); //method 1
	    JRadioButton alpha = new JRadioButton("Alphabet Characters"); //method 3
	    JRadioButton string = new JRadioButton("String"); //method 4
	    JRadioButton quit = new JRadioButton("Quit");
	    ButtonGroup bg = new ButtonGroup();
		bg.add(numerical);
		bg.add(alpha);
		bg.add(string);
		bg.add(quit);
	    Box box = Box.createVerticalBox();
	    box.add(label);
	    box.add(numerical);
	    box.add(alpha);
	    box.add(string);
	    box.add(quit);
	    lab2.add(box);
		lab2.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    lab2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    lab2.setPreferredSize(new Dimension(400, 200));
	    lab2.pack();
	    lab2.setLocationRelativeTo(null);
	    lab2.setVisible(true);
	    
	    String[] list = null;
	    numerical.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  GatherInputSummarizingData askData = new GatherInputSummarizingData(1, lab2, list);
	    	  String[] data = askData.getData();
	    	  String title = " ";
	    	  List dataSet = new ArrayList();
	    	  if(data == null){
	    		  new SummarizingAndPresentingData();
	    	  }
	    	  else{
		    	  title = askData.getTitle();
		    	  for(int i = 0; i < data.length; i++){
		    		  dataSet.add(data[i]);
		    	  }
	    	  } 
	    	  
	    	  if(data != null && dataSet != null){
	    		  SummarizingAndPresentingDataDisplay disp = new SummarizingAndPresentingDataDisplay();
	    		  disp.Categorical(dataSet, title);
	    	  }
	    	  else{
	    		  new Menu();
	    	  }
	      }
	    });
	    alpha.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  GatherInputSummarizingData askData = new GatherInputSummarizingData(3, lab2, list);
	    	  String[] data = askData.getData();
	    	  String title = " ";
	    	  List dataSet = new ArrayList();
	    	  if(data == null){
	    		  new SummarizingAndPresentingData();
	    	  }
	    	  else{
		    	  title = askData.getTitle();
		    	  for(int i = 0; i < data.length; i++){
		    		  dataSet.add(data[i]);
		    	  }
	    	  } 
	    	  
	    	  if(data != null && dataSet != null){
	    		  SummarizingAndPresentingDataDisplay disp = new SummarizingAndPresentingDataDisplay();
	    		  disp.Categorical(dataSet, title);
	    	  }
	    	  else{
	    		  new Menu();
	    	  }
	    	  
	      }
	    });
	    string.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  GatherInputSummarizingData askData = new GatherInputSummarizingData(4, lab2, list);
	    	  String[] data = askData.getData();
	    	  String title = " ";
	    	  List dataSet = new ArrayList();
	    	  if(data == null){
	    		  new SummarizingAndPresentingData();
	    	  }
	    	  else{
		    	  title = askData.getTitle();
		    	  for(int i = 0; i < data.length; i++){
		    		  dataSet.add(data[i]);
		    	  }
	    	  } 
	    	  
	    	  if(data != null && dataSet != null){
	    		  SummarizingAndPresentingDataDisplay disp = new SummarizingAndPresentingDataDisplay();
	    		  disp.Categorical(dataSet, title);
	    	  }
	    	  else{
	    		  new Menu();
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

