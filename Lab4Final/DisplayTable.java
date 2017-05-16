package IntegratedDataHandling;

import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.ui.RefineryUtilities;

public class DisplayTable extends JFrame {
	
	JTable table;
	ArrayList list;
	ArrayList frequency;
	ArrayList percent;
	String title;
	
	public void makeTableCategorical(ArrayList list, ArrayList frequency, ArrayList percent, String dataSetTitle) {
		this.list =  list;
		this.frequency =  frequency;
		this.percent = percent;
		title = dataSetTitle;
		
		setLayout(new GridLayout());
		setTitle(title);
		table = new JTable();
		table.setBounds(100, 100, 100, 100);
		JScrollPane scrollTable = new JScrollPane(table);
		
		int rows = list.size() + 1;
	    int cols = 2;
	    table.setModel(new DefaultTableModel(rows, cols));
	    table.getColumnModel().getColumn(0).setHeaderValue("Value");
	    table.getColumnModel().getColumn(1).setHeaderValue("Percent");
	     
	    for (int i = 0; i < list.size(); i++) {
	         table.setValueAt(list.get((i)), i, 0);
	         table.setValueAt(percent.get((i)) + ".%", i, 1); 
	    }
	    table.setValueAt( "Total: 100.00%", list.size(), 1); 
	    table.setEnabled(false);
	    	
	    this.add(scrollTable);
		this.setSize(600, 200);
		this.setVisible(true);
	}
	
	public void makeTablenumerical(ArrayList list, String dataSetTitle, int choice){
	
		this.list =  list;
		title = dataSetTitle;
		
		setLayout(new GridLayout());
		setTitle(title);
		table = new JTable();
		table.setBounds(100, 100, 100, 100);
		JScrollPane scrollTable = new JScrollPane(table);
	        
	        ArrayList LCL = new ArrayList();
	        ArrayList UCL = new ArrayList();
	        ArrayList TLCL = new ArrayList();
	        ArrayList TUCL = new ArrayList();
	        ArrayList dataSet = new ArrayList();
	        ArrayList frequency = new ArrayList();
	        ArrayList freqPercent = new ArrayList();
	        ArrayList CF = new ArrayList();
	        ArrayList cfPercent = new ArrayList();
	        ArrayList midpoint = new ArrayList();
	        int kk = 0;
	        
	        if(choice == 1){
		        for(int i = 0; i < list.size(); i++){
					  int input = Integer.parseInt((String) list.get(i));
					  dataSet.add(input);
				  }
		        
		        Collections.sort(dataSet);
		        
		        Integer lclStart =  (Integer) dataSet.get(0);
		        LCL.add(lclStart);
		        
		        int k = (int) Math.ceil(1 + (3.322 * Math.log10(dataSet.size())));
		        kk = k;
		        int max = (int) dataSet.get(list.size()-1);
		        int min = (int) dataSet.get(0);
		        int range = max - min;
		        Integer width = (int)(Math.ceil(range/k));
		        Integer uclStart = lclStart + width;
		        UCL.add(uclStart);
		      //get class limits
		        for(int i = 0;  i < k-1; i++){
		        	lclStart = uclStart + 1;
		        	uclStart = lclStart + width;
		        	LCL.add(lclStart);
		        	UCL.add(uclStart);
		        }
		        
		      //get class limits
		        for(int i = 0; i < LCL.size(); i++){
		        	double tlcl = ((Integer) LCL.get(i)).doubleValue();
		        	double tucl = ((Integer) UCL.get(i)).doubleValue();
		        	TLCL.add(tlcl - 0.5);
		        	TUCL.add(tucl + 0.5);
		        }
		        
		        //get mid
		        for(int i = 0; i < LCL.size(); i++){
		        	double mid1 = (double) TLCL.get(i);
		             double mid2 = (double) TUCL.get(i);
		             double mid = (mid1 + mid2)/2;
			         midpoint.add(mid);	
		        }
		       //get freq
		        for(int i = 0; i < LCL.size(); i++){
		        	int freq = 0;
		        	int cl1 = (int) LCL.get(i);
		        	int cl2 = (int) UCL.get(i);
		        	for(int j = 0; j < dataSet.size(); j++){
		        		int val = (int) dataSet.get(j);
		        		if(val >= cl1 && val <= cl2){
		        			freq++;
		        		}
		        	}
		        	frequency.add(freq);
		        }
		        //get percent
		        Integer size = (Integer) dataSet.size();
			    Integer getF;
			    Double percent;
			       for(int i = 0; i  < frequency.size(); i++ ){
			    	   getF = (Integer) frequency.get(i);
			    	   percent = ((getF.doubleValue())/(size.doubleValue())) * 100.0f;
			    	   freqPercent.add(percent);
			       } 
		       //get CF
		       int freq1 = (int) frequency.get(0);
		       CF.add(freq1);
		       for(int i = 1; i < frequency.size(); i++){
		    	   freq1 = freq1 + (int)frequency.get(i);
		    	   CF.add(freq1);
		       }
		       Integer size2 = (Integer) CF.get(CF.size()-1);
			   Integer getCf;
			   Double cPercent;
			       for(int i = 0; i  < CF.size(); i++ ){
			    	   getCf = (Integer) CF.get(i);
			    	   cPercent = ((getCf.doubleValue())/(size2.doubleValue())) * 100.0f;
			    	   cfPercent.add(cPercent);
			       } 
		
	        }
	        
	        if(choice == 2){
	        	for(int i = 0; i < list.size(); i++){
					  double input = Double.parseDouble((String) list.get(i));
					  dataSet.add(input);
				  }
		        
		        Collections.sort(dataSet);
		        
		        Double lclStart =  (Double) dataSet.get(0);
		        LCL.add(lclStart);
		        
		        int k = (int) Math.ceil(1 + (3.322 * Math.log10(dataSet.size())));
		        kk = k;
		        double max = (double) dataSet.get(list.size()-1);
		        double min = (double) dataSet.get(0);
		        double range = max - min;
		        Double width = (Double)Math.ceil((range/k));
		        

		        Double uclStart = lclStart + width;
		        UCL.add(uclStart);
		        
		        //get class limits
		        for(int i = 0;  i < k-1; i++){
		        	lclStart = uclStart + 1;
		        	uclStart = lclStart + width;
		        	LCL.add(lclStart);
		        	UCL.add(uclStart);
		        }
		        
		        //get true class limits
		        for(int i = 0; i < LCL.size(); i++){
		        	double tlcl = (double) LCL.get(i);
		        	double tucl = (double) UCL.get(i);
		        	TLCL.add(tlcl - 0.5);
		        	TUCL.add(tucl + 0.5);
		        }
		        //get mid
		        for(int i = 0; i < LCL.size(); i++){
		        	double mid1 = (double) TLCL.get(i);
		            double mid2 = (double) TUCL.get(i);
		            double mid = (mid1 + mid2)/2;
			        midpoint.add(mid);	
		        }
		        //get freq
		        for(int i = 0; i < LCL.size(); i++){
		        	int freq = 0;
		        	double cl1 = (double) LCL.get(i);
		        	double cl2 = (double) UCL.get(i);
		        	for(int j = 0; j < dataSet.size(); j++){
		        		double val = (double) dataSet.get(j);
		        		if(val >= cl1 && val <= cl2){
		        			freq++;
		        		}
		        	}
		        	frequency.add(freq);
		        }
		        //get percent
		        Integer size = (Integer) dataSet.size();
			    Integer getF;
			    Double percent;
			       for(int i = 0; i  < frequency.size(); i++ ){
			    	   getF = (Integer) frequency.get(i);
			    	   percent = ((getF.doubleValue())/(size.doubleValue())) * 100.0f;
			    	   freqPercent.add(percent);
			       } 
		        //get CF
		        int freq1 = (int) frequency.get(0);
			    CF.add(freq1);
			    for(int i = 1; i < frequency.size(); i++){
			    	 freq1 = freq1 + (int)frequency.get(i);
			    	 CF.add(freq1);
			    }
			    
			    //get cf%
			    Integer size2 = (Integer) CF.get(CF.size()-1);
			    Integer getCf;
			    Double cPercent;
			       for(int i = 0; i  < CF.size(); i++ ){
			    	   getCf = (Integer) CF.get(i);
			    	   cPercent = ((getCf.doubleValue())/(size2.doubleValue())) * 100.0f;
			    	   cfPercent.add(cPercent);
			       } 
	        }
	        
	        int rows = LCL.size() + 1;
	        int cols = 7;
	        table.setModel(new DefaultTableModel(rows, cols));
	        table.getColumnModel().getColumn(0).setHeaderValue("CL");
	        table.getColumnModel().getColumn(1).setHeaderValue("True CL");
	        table.getColumnModel().getColumn(2).setHeaderValue("MIDPOINTS");
	        table.getColumnModel().getColumn(3).setHeaderValue("FREQ");
	        table.getColumnModel().getColumn(4).setHeaderValue("%");
	        table.getColumnModel().getColumn(5).setHeaderValue("CF");
	        table.getColumnModel().getColumn(6).setHeaderValue("C%");
	        
	        for (int i = 0; i < LCL.size(); i++) {
	             table.setValueAt(LCL.get(i) + " - " + UCL.get(i), i, 0);	//cl
	             table.setValueAt(TLCL.get(i) + " - " + TUCL.get(i), i, 1);	//tcl
	             table.setValueAt(midpoint.get(i), i, 2);//mid 
	             table.setValueAt(frequency.get(i), i, 3); //freq
	             table.setValueAt(CF.get(i), i, 5); // cf
	             table.setValueAt("Total: ", kk, 0); // 
	             table.setValueAt(dataSet.size(),kk, 3); 
	             table.setValueAt(cfPercent.get(i), i, 6);	//cf %
	             table.setValueAt(freqPercent.get(i), i, 4); // freq %
	             table.setValueAt(100.00 +"%", kk, 4); //total freq%
	        }
	        this.add(scrollTable);
			this.setSize(600, 200);
			this.setVisible(true);
			
			int displayHistogramChart =  JOptionPane.showConfirmDialog(null, "Display Histogram?");
	        
	        if(displayHistogramChart == 0){
	        	final Histogram demo = new Histogram(frequency,midpoint,dataSetTitle);
	            demo.pack();
	            RefineryUtilities.centerFrameOnScreen(demo);
	            demo.setVisible(true);
	        }
	        else if(displayHistogramChart == 1){
	        	new Menu();
	        }
	        else{
	        	new Menu();
	        }
		}
 
}
