package CMSC105LabAns2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NumericalDataSet extends GatherInput{
	
	List<Object> sortedList = new LinkedList<>();
    List<Object> strata = new ArrayList<>();
    ArrayList value = new ArrayList<>();
    ArrayList frequency = new ArrayList<>();
    ArrayList percent = new ArrayList<>();
    private int compareValue;
    private double freqNum;
	
	public void printTable(List list, String dataSetTitle){
        Collections.sort(list);
        compareValue = 0;
        for(int i = 0; i < list.size(); i++){
        	if(list.get(i) != list.get(compareValue)){
        		sortedList.add(list.subList(compareValue, i));
        		compareValue = i;
        	}
        	if( i == list.size()-1){
        		sortedList.add(list.subList(compareValue, i+1));
        	}
        }
        for (int i = 0; i < sortedList.size(); i++){
            strata = (List) sortedList.get(i);
            frequency.add(strata.size());
            value.add(strata.get(0));
            freqNum = ((((double)strata.size())/((double)list.size()))) * 100.0f;
            percent.add(freqNum);
        }
        
        Table tab = new Table();
        tab.makeTable(value, frequency, percent, dataSetTitle, 2);
        
        System.out.println("View chart?\n Press 1 if YES.\n Press 0 if NO.\n");
        int choice = sc.nextInt();
        if(choice == 1){
            new Histogram(frequency, percent, dataSetTitle);
        }else if (choice == 2){
            System.exit(0);
        }
	}
}
