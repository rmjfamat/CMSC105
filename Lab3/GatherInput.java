package CMSCLabAns3;

import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.ArrayList;

import javax.swing.*;

public class GatherInput {
	private int size;
	
	public void getData(JFrame frame){
		String input = JOptionPane.showInputDialog("Enter data size:");

	    	try{
	        size = Integer.parseInt(input);
	        String [] list = new String[size];
	     
	        for (int i = 0; i < size; i++){
	        	String data = JOptionPane.showInputDialog("Enter input " + i);
	        	list[i] = data;
	        }
	        JFrame display = new JFrame();  
	        JOptionPane.showInputDialog(display, "DATA SET", "Input", JOptionPane.QUESTION_MESSAGE,
	            null, list, "Titan");
	    	}
	    	catch(Exception a){
	    		JOptionPane.showMessageDialog(null, "Input is invalid");
	    	}
	      
	}
}
