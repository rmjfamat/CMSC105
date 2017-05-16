package IntegratedDataHandling;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class DisplayLab3Data extends JFrame {
	JTable table;

    public void displayTable(List list, String title){
        setLayout(new GridLayout());
        setTitle(title);
        table = new JTable();
        table.setSize(500, 500);
        table.setBounds(300,300,300, 300);


        int rows = list.size();
        int cols = 2;
        table.setModel(new DefaultTableModel(rows, cols));
        table.getColumnModel().getColumn(0).setHeaderValue("Index");
        table.getColumnModel().getColumn(1).setHeaderValue("Data");

        for (int i = 0; i < list.size(); i++) {
            table.setValueAt("Index " + (i+1), i, 0);
            table.setValueAt(list.get((i)), i, 1);
        }

        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
}

