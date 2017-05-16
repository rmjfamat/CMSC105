package IntegratedDataHandling;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GatherInputGrouped {
	private int choice;
	private List list;
	private int size;
	
	public GatherInputGrouped(int choice, JFrame frame, List list){
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
				        	String classInterval = JOptionPane.showInputDialog("Enter class interval:");	
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
