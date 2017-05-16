package IntegratedDataHandling;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DisplaySample extends JFrame{
	private int method;
	private String[] list;
	private List data = new ArrayList();
	private List samples = new ArrayList();
	private int sampleSize;
	
	DisplaySample(int method, String[]list){
		this.list = list;
		this.method = method;
	}
	
	public void displaySample(){
		for(int i = 0; i < list.length; i++){
			data.add(list[i]);
		}
		
		for(int j = 0; j < 1; j++){
			String input;
			if(method == 1 || method == 2){
				 input = JOptionPane.showInputDialog("Enter sample size:");
			}
			else{
				 input = JOptionPane.showInputDialog("Enter sample size percentage:");
			}
	    	try{
	    		if(input == null){
		    		new SummarizingAndPresentingData();
		    	}
	    		else{
	    			sampleSize = Integer.parseInt(input);
	    			if(method == 1){
	    				BasicSamplingGetSamples random = new BasicSamplingGetSamples(sampleSize, data);
	    				samples = random.getRandomSamples();
	    				displayTable(samples);
	    			}
	    			if(method == 2){
	    				BasicSamplingGetSamples random = new BasicSamplingGetSamples(sampleSize, data);
	    				samples = random.getSystematicSamples();
	    				displayTable(samples);
	    			}
	    			if(method == 3){
	    				BasicSamplingGetSamples random = new BasicSamplingGetSamples(sampleSize, data);
	    				random.getStratifiedSamples();
	    				
	    			}
	    		}
	    	}
	    	catch(Exception e){
	    		JOptionPane.showMessageDialog(null, "Input is invalid");
	    		j = j - 1;
	    	}
		}
	}
	
	private void displayTable(List toDisplay){
		JTable table = new JTable();
		table.setBounds(100, 100, 100, 100);
		JScrollPane scrollTable = new JScrollPane(table);
		
		int rows = toDisplay.size();
        int cols = 2;
        table.setModel(new DefaultTableModel(rows, cols));
        table.getColumnModel().getColumn(0).setHeaderValue("Index");
        table.getColumnModel().getColumn(1).setHeaderValue("Data");
        int a = 0;
        int b = 1;
        for (int i = 0; b < toDisplay.size(); i++) {
             table.setValueAt("Index " + toDisplay.get((a)), i, 0);
             table.setValueAt(toDisplay.get((b)), i, 1);
             a = a+2;
             b = b+2;
        }
        table.setEnabled(false);
    	
		this.add(scrollTable);
		this.setSize(600, 200);
		this.setVisible(true);
	}
	
	private void displayStratifiedTable(List toDisplay){
		JTable table = new JTable();
		table.setBounds(100, 100, 100, 100);
		JScrollPane scrollTable = new JScrollPane(table);
		
		int rows = (toDisplay.size())/2;
        int cols = 2;
        table.setModel(new DefaultTableModel(rows, cols));
        table.getColumnModel().getColumn(0).setHeaderValue("Strata");
        table.getColumnModel().getColumn(1).setHeaderValue("Data");
       
        for (int i = 0; i < toDisplay.size(); i++) {
             table.setValueAt("Index " + i, i, 0);
             table.setValueAt(toDisplay.get((i)), i, 1);
            
        }
        table.setEnabled(false);
    	
		this.add(scrollTable);
		this.setSize(600, 200);
		this.setVisible(true);
	}
	
}
