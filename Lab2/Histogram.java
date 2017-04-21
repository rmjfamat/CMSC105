package CMSC105LabAns2;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by mmcalvarez on 4/4/2017.
 */
public class Histogram extends JFrame {
    private ArrayList list;
    private JPanel panelChart;
    private ArrayList percentage;

    public Histogram(ArrayList list, ArrayList percentage, String title){
        this.list = list;
        this.percentage = percentage;
        panelChart = new JPanel();
        add(panelChart);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);


        JFreeChart barChart = ChartFactory.createBarChart(title, "Midpoint", "Frequency", createDataSet(), PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot categoryPlot = barChart.getCategoryPlot();
        categoryPlot.setDomainGridlinesVisible(true);
        categoryPlot.getDomainAxis().setCategoryMargin(0.0);

        ChartFrame chartFrame = new ChartFrame("Histogram", barChart);
        chartFrame.setVisible(true);
        chartFrame.setSize(500, 500);
    }

    private CategoryDataset createDataSet(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < list.size(); i++){
            dataset.setValue((double)percentage.get(i), list.get(i).toString(), percentage.get(i).toString());
        }
        return dataset;
    }
}
