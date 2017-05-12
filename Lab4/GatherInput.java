package IntegratedDataHandling;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GatherInput {
	private int size;
	private String [] list;
	
	public GatherInput(JFrame frame, String[] list){
		this.list = list;
	}
	
	public String[] getData(){
		
		for(int j = 0; j < 1; j++){
			String input = JOptionPane.showInputDialog("Enter data size:");
			
	    	try{
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
						        		int dataInt = Integer.parseInt(data);
						        	}
						        	catch(Exception e){
						        		JOptionPane.showMessageDialog(null, "Input is invalid");
						        		i = i-1;
						        	}
					        	}
					        }
				        	if(cancel == false){
						        JFrame display = new JFrame();  
						        JOptionPane.showInputDialog(display, "DATA SET", "Input", JOptionPane.QUESTION_MESSAGE,
						            null, list, "Titan");
				        	}
			        	}
				        else{
				        	new Menu();
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
