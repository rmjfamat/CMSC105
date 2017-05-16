package IntegratedDataHandling;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GatherInputSummarizingData {
	private int size;
	private int method;
	private String [] list;
	private String title;
	
	public GatherInputSummarizingData(int method, JFrame frame, String[] list){
		this.list = list;
		this.method = method;
	}
	
	public String[] getData(){
		
		for(int j = 0; j < 1; j++){
			
			String description = JOptionPane.showInputDialog("Enter brief title of data:");	
			title = description;
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
							        		if(method == 1){
							        			int dataInt = Integer.parseInt(data);
							        		}
							        		else if(method == 2){
							        			float dataFloat = Float.parseFloat(data);
							        			if(data.contains(".") == false){
							        				JOptionPane.showMessageDialog(null, "Input is invalid");
									        		i = i-1;
							        			}
							        			else{
							        				list[i] = data; 
							        			}
							        		}
							        		else if(method == 3){
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
							        		else if(method == 4){
							        			String dataString = data;
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
	
	public String getTitle(){
		if(title == null){
			title = "Cancelled Program";
		}
		return title;
	}
}
