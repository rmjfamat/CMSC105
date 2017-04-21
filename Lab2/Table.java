package CMSC105LabAns2;

import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame {
	
	JTable table;
	ArrayList list;
	ArrayList frequency;
	ArrayList percent;
	String title;
	private int choice;
	
	public void makeTable(ArrayList list, ArrayList frequency, ArrayList percent, String dataSetTitle, int choice) {
		this.list =  list;
		this.frequency =  frequency;
		this.percent = percent;
		title = dataSetTitle;
		this.choice = choice;
		
		setLayout(new GridLayout());
		setTitle(title);
		table = new JTable();
		table.setBounds(100, 100, 100, 100);
		JScrollPane scrollTable = new JScrollPane(table);
		
		if(choice == 1){
			int rows = list.size();
	        int cols = 2;
	        table.setModel(new DefaultTableModel(rows, cols));
	        table.getColumnModel().getColumn(0).setHeaderValue("Value");
	        table.getColumnModel().getColumn(1).setHeaderValue("Percent");
	        
	        for (int i = 0; i < list.size(); i++) {
	             table.setValueAt(list.get((i)), i, 0);
	             table.setValueAt(percent.get((i)), i, 1);
	        }
		}
		
		if(choice == 2){
			int rows = list.size();
	        int cols = 8;
	        table.setModel(new DefaultTableModel(rows, cols));
	        table.getColumnModel().getColumn(0).setHeaderValue("Value");
	        table.getColumnModel().getColumn(1).setHeaderValue("CL");
	        table.getColumnModel().getColumn(2).setHeaderValue("True CL");
	        table.getColumnModel().getColumn(3).setHeaderValue("MIDPOINTS");
	        table.getColumnModel().getColumn(4).setHeaderValue("FREQ");
	        table.getColumnModel().getColumn(5).setHeaderValue("%");
	        table.getColumnModel().getColumn(6).setHeaderValue("CF");
	        table.getColumnModel().getColumn(7).setHeaderValue("C%");
	        
	        ArrayList cl = new ArrayList();
	        Integer clvalue = (int) list.get(0);
	        cl.add(clvalue);
	        int k = (int) Math.ceil(1 + (3.322 * Math.log(list.size())));
	        int max = (int) list.get(list.size()-1);
	        int min = (int) list.get(0);
	        int range = max - min;
	        Integer width = (int)Math.ceil(range/k);
	        ArrayList cf = new ArrayList();
	        Integer cf1 = (Integer) frequency.get(0);
	        cf.add(cf1);
	        Double cPercent;
	        ArrayList cPercent2 = new ArrayList();
	        
	       for(int i = 0; i  < list.size(); i++ ){
	    	   clvalue = clvalue + width;
	    	   cl.add(clvalue);
	       }
	       for(int i = 1; i  < frequency.size(); i++ ){
	    	   cf1 =  cf1 + (Integer) frequency.get(i);
	    	   cf.add(cf1);
	       }
	       Integer size = (Integer) cf.get(cf.size()-1);
	       Integer getCf;
	       for(int i = 0; i  < cf.size(); i++ ){
	    	   getCf = (Integer) cf.get(i);
	    	   cPercent = ((getCf.doubleValue())/(size.doubleValue())) * 100.0f;
	    	   cPercent2.add(cPercent);
	       } 
	       
	       

	        for (int i = 0; i < list.size(); i++) {
	             table.setValueAt(list.get((i)), i, 0);
	             Integer cl1 = (Integer) cl.get(i);
	             Integer cl2 = (cl1 + width) - 1;
	             table.setValueAt(cl1 + "-" + cl2, i, 1);
	             double tcl = ((Integer) cl1).doubleValue();
	             double tcl2 = cl2.doubleValue();
	             table.setValueAt((tcl-0.5) + "-" + (tcl2 + 0.5), i, 2);
	             table.setValueAt((tcl + tcl2)/2, i, 3);
	             table.setValueAt(frequency.get((i)), i, 4);
	             table.setValueAt(percent.get((i)), i, 5);
	             table.setValueAt(cf.get((i)), i, 6);
	             table.setValueAt(cPercent2.get(i) , i, 7);
	        }
		}
        
        table.setEnabled(false);
	
		this.add(scrollTable);
		this.setSize(600, 200);
		this.setVisible(true);
		
		
	}
	
}
