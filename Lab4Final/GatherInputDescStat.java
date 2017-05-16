package IntegratedDataHandling;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GatherInputDescStat {
	private int size;
	private int choice;
	private List list;
	
	public GatherInputDescStat(int choice, JFrame frame, List list){
		this.list = list;
		this.choice = choice;
	}
	
	public List getData(){
		
		String description = JOptionPane.showInputDialog("Enter brief description of data:");	
		for(int j = 0; j < 1; j++){
    	try{
    		if(description == null){
    			break;
    		}
    		else{
    			String input = JOptionPane.showInputDialog("Enter data size:");	
    			if(input == null){
		    		break;
		    	}
		    	else{
			        size = Integer.parseInt(input);
			        list = new ArrayList();
			        
				        if(input != null){
				        	boolean cancel = false;
				        	for (int i = 0; i < size; i++){
					        	String data = JOptionPane.showInputDialog("Enter input " + (i+1));
					        	if(data == null){
					        		cancel = true;
					        		break;
					        		
					        	}
					        	else{
						        	try{
						        		if(choice == 1){
						        			try{
						        				int dataInt = Integer.parseInt(data);
						        				list.add(data);
						        			}
						        			catch(Exception e){
									       		JOptionPane.showMessageDialog(null, "Input is invalid");
									       		i = i-1;
									       	}
						        		}
						        		if(choice == 2){
						        			try{
						        				float dataFloat = Float.parseFloat(data);
						        				if(data.contains(".") == false){
						        					JOptionPane.showMessageDialog(null, "Input is invalid");
						        					i = i -1;
						        				}
								        		else{
							        				list.add(data);
								        		}
						        			}
						        				catch(Exception e){
										       		JOptionPane.showMessageDialog(null, "Input is invalid");
										       		i = i-1;
										       	}
						        			
						        			}
						        		}
						        	
						        	catch(Exception e){
						        		JOptionPane.showMessageDialog(null, "Input is invalid");
						        		i = i-1;
						        	}
					        	}
					        }
				        	if(cancel == false){
				        		ContinueOrEdit con = new ContinueOrEdit();
				        		con.continueProgram(choice, list, description);
				        	}
				        	
			        	}
				        else{
				        	new Menu();
				        }
		    		}
    		}
    	}
    	catch(Exception e){
    		JOptionPane.showMessageDialog(null, "Input is invalid");
    		j = j - 1;
    	}
	}
    	return list;
      
}	
}
