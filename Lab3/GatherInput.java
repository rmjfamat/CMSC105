package CMSCLabAns3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GatherInput {
	private int size;
	
	public void getData(JFrame frame){
		JLabel label =  new JLabel("Enter Data Size ");
		JTextField data = new JTextField();
		JButton cont = new JButton("Continue");
		data.setColumns(10);
		
		Box newBox = Box.createHorizontalBox();
		newBox.add(label);
		newBox.add(data);
		newBox.add(cont);
		frame.add(newBox);
		frame.setBounds(300, 400, 200, 100);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    
	    cont.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	try{
	        size = Integer.parseInt(data.getText());
	        System.out.println(size);
	    	}
	    	catch(Exception a){
	    		JOptionPane.showMessageDialog(null, "Input is invalid");
	    	}
	      }
	    });
	}

	
	

}
