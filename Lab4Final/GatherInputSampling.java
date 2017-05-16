package IntegratedDataHandling;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GatherInputSampling {
	private int size;
	private int choice;
	private String [] list;
	
	public GatherInputSampling(int choice, JFrame frame, String[] list){
		this.list = list;
		this.choice = choice;
	}
	
	public String[] getData(){
		
		for(int j = 0; j < 1; j++){
			
			String description = JOptionPane.showInputDialog("Enter brief title of data:");	
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
				        list = new String[size];
				        
					        if(input != null){
					        	boolean cancel = false;
					        	for (int i = 0; i < size; i++){
						        	String data = JOptionPane.showInputDialog("Enter input " + (i+1));
						        	if(data == null){
						        		cancel = true;
						        		break;
						        		
						        	}
						        	else{
							        	list[i] = data;
							        	try{
							        		if(choice == 1){
							        			int dataInt = Integer.parseInt(data);
							        		}
							        		if(choice == 2){
							        			float dataFloat = Float.parseFloat(data);
							        			if(data.contains(".") == false){
							        				JOptionPane.showMessageDialog(null, "Input is invalid");
									        		i = i-1;
							        			}
							        			else{
							        				list[i] = data; 
							        			}
							        		}
							        		else if(choice == 3){
							        			String dataChar;
							        			if(data.length() == 1){
							        				if((data.charAt(0) >= 'a' && data.charAt(0) <= 'z') || (data.charAt(0) >= 'A' && data.charAt(0) <= 'Z')){
								        				dataChar = data;
								        				list[i] = dataChar;
								        			}
							        				else{
								        				JOptionPane.showMessageDialog(null, "Input is invalid");
										        		i = i-1;
								        			}
							        			}	
							        			else{
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
					        		Data data = new Data(list, description);
							        data.displayTable();
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
