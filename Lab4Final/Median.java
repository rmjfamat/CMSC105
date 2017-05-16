package IntegratedDataHandling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Median extends JFrame{
    private int middle = 0;

    Median(){

    }

    public void getMedian(List<Object> list, int choice, JFrame frame){

        switch (choice){
            case 1 :

                String temp;
                for (int j = 0; j < list.size(); j++){
                    for (int i = 0; i<list.size()-1; i++){
                        if (Integer.parseInt((String) list.get(i)) > Integer.parseInt((String) list.get(i+1))){
                            temp =  (String) list.get(i);
                            list.set(i, list.get(i+1));
                            list.set(i+1, temp);
                        }
                    }
                }
                break;

            case 2 :
                String temporary;
                for (int j = 0; j < list.size(); j++){
                    for (int i = 0; i<list.size()-1; i++){
                        if ( Double.parseDouble((String) list.get(i)) >  Double.parseDouble((String) list.get(i+1))){
                            temporary =  (String) list.get(i);
                            list.set(i,  list.get(i+1));
                            list.set(i+1, temporary);
                        }
                    }
                }
                break;
        }
    	
    	if (list.size() % 2 != 0){
            middle = (list.size()/2) + 1;
            JOptionPane.showMessageDialog(frame,
            	    "Median: " + list.get(middle -1),
            	    "Median",
            	    JOptionPane.PLAIN_MESSAGE);
            
        }
    	else{
        	middle = list.size()/2;
        	
        	if(choice == 1){
        		int one =  Integer.parseInt((String) list.get(middle-1));
                int two = Integer.parseInt((String) list.get(middle));
                double sum = (one + two) / 2.0;
                JOptionPane.showMessageDialog(frame,
                	    "Median: " + sum,
                	    "Median",
                	    JOptionPane.PLAIN_MESSAGE);

        	}
        	else{
        		double one = Double.parseDouble((String) list.get(middle-1));
                double two = Double.parseDouble((String) list.get(middle));
                double sum = (one + two) / 2.0;
                JOptionPane.showMessageDialog(frame,
                	    "Median: " + sum,
                	    "Median",
                	    JOptionPane.PLAIN_MESSAGE);
        	}
            
        }
        
    }
}

