package IntegratedDataHandling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mode extends JFrame{

	Mode(){

    }

    public void getMode(List<Object> list, int choice, JFrame frame) {

    	ArrayList mode = new ArrayList();

		if (choice == 1){
			for (int i = 0; i < list.size(); i++){
				boolean flag = false;
				int value = Integer.parseInt((String) list.get(i));
				for (int j = i+1; j < list.size(); j++){
					if (Integer.parseInt((String) list.get(j)) == value){
						flag = true;
						break;
					}
				}
				if (flag && !mode.contains(list.get(i))){
					mode.add(list.get(i));
				}
			}

		} else {
			for (int i = 0; i < list.size(); i++){
				boolean flag = false;
				double value = Double.parseDouble((String) list.get(i));
				for (int j = i+1; j < list.size(); j++){
					if (Double.parseDouble((String) list.get(j)) == value){
						flag = true;
						break;
					}
				}
				if (flag && !mode.contains(list.get(i))){
					mode.add(list.get(i));
				}
			}
		}

		if (mode.size() == 1){
			 JOptionPane.showMessageDialog(frame,
             	    "Mode: " + mode + "--->Unimodal",
             	    "Mode",
             	    JOptionPane.PLAIN_MESSAGE);
		}
		if (mode.size() == 2){
			JOptionPane.showMessageDialog(frame,
             	    "Mode: " + mode + "---> Bimodal",
             	    "Mode",
             	    JOptionPane.PLAIN_MESSAGE);
		}
		if (mode.size() > 2){
			JOptionPane.showMessageDialog(frame,
             	    "Mode: " + mode + "--->Multimodal",
             	    "Mode",
             	    JOptionPane.PLAIN_MESSAGE);
		}
		if (mode.isEmpty()){
			JOptionPane.showMessageDialog(frame,
             	    "Mode: No mode.",
             	    "Mode",
             	    JOptionPane.PLAIN_MESSAGE);
		}

	}

	public void getMode(ArrayList<Double> freq, List<Double> lower, List<Double> upper) {
		double max = 0;
		int counter = 0;

		for (int i = 0; i < freq.size(); i++) { //get the maximum
			if (freq.get(i) > max) {
				max = freq.get(i);
			}
		}
		for (int i = 0; i < freq.size(); i++){
			if (max == freq.get(i)){
				counter++;
				System.out.println("Modal Class/es: " + lower.get(i) + " - " + upper.get(i));
			}
		}
		if (counter == 1){
			System.out.println("--> Unimodal\n");
		}
		if (counter == 2){
			System.out.println("--> Bimodal\n");
		}
		if (counter > 2){
			System.out.println("--> Multimodal\n");
		}
		if (counter == 0){
			System.out.println("--> No mode\n");
		}
	}
}

