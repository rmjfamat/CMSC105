package IntegratedDataHandling;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class PieChart extends JFrame{
    private ArrayList list;
    private JPanel panelChart;
    private ArrayList percentage;

    public PieChart(ArrayList list, ArrayList percentage, String title){
        this.list = list;
        this.percentage = percentage;
        panelChart = new JPanel();
        add(panelChart);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < list.size(); i++){
            dataset.setValue(list.get(i).toString(), (double)percentage.get(i));
        }

        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
        chart.getPlot();

        ChartPanel chartPanel = new ChartPanel(chart);
        panelChart.add(chartPanel, BorderLayout.CENTER);
        panelChart.validate();
    }
}
