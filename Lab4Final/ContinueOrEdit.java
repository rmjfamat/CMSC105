package IntegratedDataHandling;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class ContinueOrEdit extends JFrame {
	private List data = new ArrayList();
	
	public void continueProgram(int dataType, List data, String description){
		
		JFrame choice = new JFrame();
		JLabel label = new JLabel("Continue or Edit data?");
		JRadioButton padayon = new JRadioButton("Continue");
	    JRadioButton edit = new JRadioButton("Edit");
	    
	    JRadioButton quit = new JRadioButton("Quit");
	    ButtonGroup bg = new ButtonGroup();
		bg.add(padayon);
		bg.add(edit);
		bg.add(quit);
	    Box box = Box.createVerticalBox();
	    box.add(padayon);
		box.add(edit);
		
		box.add(quit);
	    choice.add(box);
	    choice.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    choice.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    choice.setPreferredSize(new Dimension(400, 200));
	    choice.pack();
	    choice.setLocationRelativeTo(null);
	    choice.setVisible(true);
	    
	    padayon.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  cont(data, description, dataType);
	      }
	    });
	    edit.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  edit(dataType, data, description);	    	  
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
	
	private void cont(List data, String description, int dataType){
		DisplayLab3Data display = new DisplayLab3Data();
		display.displayTable(data, description);
	
		JFrame con = new JFrame();
		JRadioButton mean = new JRadioButton("Mean");
	    JRadioButton median = new JRadioButton("Median");
	    JRadioButton mode = new JRadioButton("Mode");
	    JRadioButton all = new JRadioButton("All");
	    JRadioButton quit = new JRadioButton("Quit");
	    ButtonGroup bg = new ButtonGroup();
		bg.add(mean);
		bg.add(median);
		bg.add(mode);
		bg.add(all);
		bg.add(quit);
	    Box box = Box.createVerticalBox();
	    box.add(mean);
		box.add(median);
		box.add(mode);
		box.add(all);
		box.add(quit);
	    con.add(box);
		con.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    con.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    con.setPreferredSize(new Dimension(400, 200));
	    con.pack();
	    con.setLocationRelativeTo(null);
	    con.setVisible(true);
	    
	    mean.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	 Mean mean1 = new Mean();
	    	mean1.getMean(data, dataType, con); 
	      }
	    });
	    median.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  Median median1 = new Median();
	    	  median1.getMedian(data, dataType, con); 
	    	  
	      }
	    });
	    
	    mode.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	 
	    	 Mode mode1 = new Mode();
	    	 mode1.getMode(data, dataType, con); 
	      }
	    });
	    
	    all.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  Mean mean1 = new Mean();
	    	  mean1.getMean(data, dataType, con);
	    	  Median median1 = new Median();
	    	  median1.getMedian(data, dataType, con); 
	    	  Mode mode1 = new Mode();
	    	  mode1.getMode(data, dataType, con);
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
	
	private void edit(int dataType, List data,  String description){
	
		JFrame con = new JFrame();
		JLabel label = new JLabel("EDIT");
		JRadioButton edit1 = new JRadioButton("Add");
		JRadioButton edit2 = new JRadioButton("Edit Value at Index");
	    JRadioButton edit3 = new JRadioButton("Delete");
	    JRadioButton quit = new JRadioButton("Quit");
	    ButtonGroup bg = new ButtonGroup();
		bg.add(edit1);
		bg.add(edit2);
		bg.add(edit3);
		bg.add(quit);
	    Box box = Box.createVerticalBox();
	    box.add(label);
	    box.add(edit1);
	    box.add(edit2);
		box.add(edit3);
		box.add(quit);
		con.add(box);
		con.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		con.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		con.setPreferredSize(new Dimension(400, 200));
		con.pack();
		con.setLocationRelativeTo(null);
		con.setVisible(true);
		   
		edit1.addActionListener(new ActionListener()
		  {
		  public void actionPerformed(ActionEvent e)
		  {
			  edit(1, dataType, data, description);
		  }
		});
		edit2.addActionListener(new ActionListener()
		  {
		  public void actionPerformed(ActionEvent e)
		  {
			  edit(2, dataType, data, description);
		    	  
		  }
		});
		edit3.addActionListener(new ActionListener()
		  {
		  public void actionPerformed(ActionEvent e)
		  {
			  edit(3, dataType, data, description);
		    	  
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
	
	private void edit(int choice, int dataType, List data, String description){
		if(choice == 1){
			for(int a = 0; a < 1; a++){ 
			String index = JOptionPane.showInputDialog("Enter data:");
			try{
				if(index == null){
					continueProgram(dataType, data,  description);
				}
				else{
					if(dataType ==1) {
						int index2 = Integer.parseInt(index);
						data.add(index);
					}
					if(dataType == 2){
						
							float dataFloat = Float.parseFloat(index);
		        			if(index.contains(".") == false){
		        				JOptionPane.showMessageDialog(null, "Input is invalid");
		        				a = a -1;
		        			}
				        	else{
			        			data.add(index);
				        	}
		        			
	        		}

					continueProgram(dataType, data,  description);
				}
			}
			catch(Exception e){
	        	JOptionPane.showMessageDialog(null, "Input is invalid");
	        	a = a -1;
	        }
			}
		}
		if(choice == 2){
			int indexTochange = 0;
			for(int a = 0; a < 1; a++){ 
				String index = JOptionPane.showInputDialog("Enter index of data to be changed:");
				try{
					if(index == null){
						continueProgram(dataType, data,  description);
					}
					else{
							int index2 = Integer.parseInt(index);
							if(index2 >= 0 && index2 < data.size()){
								indexTochange = index2;
							}
							else{
								JOptionPane.showMessageDialog(null, "Input is invalid");
		        				a = a -1;
							}
					}
				}
				catch(Exception e){
		        	JOptionPane.showMessageDialog(null, "Input is invalid");
		        	a = a -1;
		        }
				}
			
			for(int a = 0; a < 1; a++){ 
				String index = JOptionPane.showInputDialog("Enter new data:");
				try{
					if(index == null){
						continueProgram(dataType, data,  description);
					}
					else{
						if(dataType ==1){
							int index2 = Integer.parseInt(index);
							data.set(indexTochange, index);
						}
						if(dataType == 2){
							float dataFloat = Float.parseFloat(index);
		        			if(index.contains(".") == false){
		        				JOptionPane.showMessageDialog(null, "Input is invalid");
		        				a = a -1;
		        			}
				        	else{
			        			data.set(indexTochange, index);
				        	}
		        			
	        		}

					continueProgram(dataType, data,  description);
					}
						
				}
				catch(Exception e){
		        	JOptionPane.showMessageDialog(null, "Input is invalid");
		        	a = a -1;
		        }
			}
			
		}
		if(choice == 3){
			for(int a = 0; a < 1; a++){ 
			String index = JOptionPane.showInputDialog("Enter index of data to be deleted:");
			try{
				if(index == null){
					continueProgram(dataType, data,  description);
				}
				else{
						int index2 = Integer.parseInt(index);
						if(index2 >= 0 && index2 < data.size()){
							data.remove(index2);
						}
						else{
							JOptionPane.showMessageDialog(null, "Input is invalid");
	        				a = a -1;
						}

					continueProgram(dataType, data,  description);
				}
			}
			catch(Exception e){
	        	JOptionPane.showMessageDialog(null, "Input is invalid");
	        	a = a -1;
	        }
			}
		}
	}
}
