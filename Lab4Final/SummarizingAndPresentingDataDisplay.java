package IntegratedDataHandling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class SummarizingAndPresentingDataDisplay {
	List<Object> sortedList = new LinkedList<>();
    List<Object> strata = new ArrayList<>();
    ArrayList value = new ArrayList<>();
    ArrayList frequency = new ArrayList<>();
    ArrayList percent = new ArrayList<>();
    private int compareValue;
    private double freqNum;
	
	public void Numerical(List list, String dataSetTitle, int choice){
 
        for(int i = 0; i < list.size(); i++){
        	value.add(list.get(i));
        }
        
        DisplayTable tab = new DisplayTable();
        tab.makeTablenumerical(value, dataSetTitle, choice);
       
	}
	
	public void Categorical(List list, String dataSetTitle){
        Collections.sort(list);
        compareValue = 0;
        for(int i = 0; i < list.size(); i++){
        	if(list.get(i).equals(list.get(compareValue))){	
        	}
        	else{
        		sortedList.add(list.subList(compareValue, i));
        		compareValue = i;
        	}
        	if( i == list.size()-1){
        		sortedList.add(list.subList(compareValue, i+1));
        	}
        }
        
        
        for (int i = 0; i < sortedList.size(); i++){
            strata = (List) sortedList.get(i);
            value.add(strata.get(0));
            freqNum = ((((double)strata.size())/((double)list.size()))) * 100.0f;
            percent.add(freqNum);
        } 
        
        DisplayTable tab = new DisplayTable();
        tab.makeTableCategorical(value, frequency, percent, dataSetTitle);
        
        int displayPieChart =  JOptionPane.showConfirmDialog(null, "Display Pie Chart?");
        
        if(displayPieChart == 0){
            new PieChart(value, percent, dataSetTitle);
        }
        else if(displayPieChart == 1){
        	new Menu();
        }
        else{
        	new Menu();
        }
    }
}
