package IntegratedDataHandling;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Data extends JFrame{
	private String[] toDisplay;
	private String desc;
	Data(String[] toDisplay, String desc){
		this.toDisplay = toDisplay;
		this.desc = desc;
	}
	
	public void displayTable(){
		JTable table = new JTable();
		table.setBounds(100, 100, 100, 100);
		setTitle(desc);
		JScrollPane scrollTable = new JScrollPane(table);
		
		int rows = toDisplay.length;
        int cols = 2;
        table.setModel(new DefaultTableModel(rows, cols));
        table.getColumnModel().getColumn(0).setHeaderValue("Index");
        table.getColumnModel().getColumn(1).setHeaderValue("Data");
        
        for (int i = 0; i < toDisplay.length; i++) {
             table.setValueAt("Index " + i, i, 0);
             table.setValueAt(toDisplay[i], i, 1);
        }
        table.setEnabled(false);
    	
		this.add(scrollTable);
		this.setSize(600, 500);
		this.setVisible(true);
	}
	
}
