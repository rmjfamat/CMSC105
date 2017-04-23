package CMSCLabAns3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu {

  public void displayJFrame()
  {
    JFrame frame = new JFrame("Measue of Central Tendency and Dispersion");
    JLabel label = new JLabel("MENU");
    JRadioButton grouped = new JRadioButton("Grouped Data");
    JRadioButton ungrouped = new JRadioButton("Ungrouped Data");
    JRadioButton quit = new JRadioButton("Quit");
    Box box = Box.createVerticalBox();
    box.add(label);
    box.add(ungrouped);
    box.add(grouped);
    box.add(quit);
	  

    ButtonGroup bg = new ButtonGroup();
    bg.add(grouped);
    bg.add(quit);
    bg.add(ungrouped);
    
    frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    frame.add(box);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(400, 400));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    grouped.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        GatherInput groupedData = new GatherInput();
        groupedData.getData(frame);
      }
    });
    
    ungrouped.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
    	GatherInput ungroupedData = new GatherInput();
        ungroupedData.getData(frame);
      }
    });
    
    quit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    });

    
  }
  public static void main(String[] args) {
	 Menu menu = new Menu();
	 menu.displayJFrame();
  }
}
