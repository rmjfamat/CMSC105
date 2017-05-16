package IntegratedDataHandling;


import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Histogram extends JFrame {
    private ArrayList list;
    private String title;
    private ArrayList percentage;

    public Histogram(ArrayList list, ArrayList percentage, String title) {
        this.list = list;
        this.percentage = percentage;
        this.title = title;

        final CategoryDataset dataset = createDataSet();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(450, 500));
        setContentPane(chartPanel);


    }

    private CategoryDataset createDataSet(){

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < list.size(); i++){
            dataset.addValue((int) list.get(i), list.get(i).toString(), percentage.get(i).toString());
        }

        return dataset;
    }

    private JFreeChart createChart(final CategoryDataset dataset){
        final JFreeChart chart = ChartFactory.createBarChart(
                title,         // chart title
                "Midpoint",               // domain axis label
                "Frequency",                  // range axis label
                dataset,                  // data
                PlotOrientation.VERTICAL, // orientation
                true,                     // include legend
                true,                     // tooltips?
                false                     // URLs?
        );

        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setDomainGridlinesVisible(true);
        plot.getDomainAxis().setCategoryMargin(0.0);


        ((BarRenderer) plot.getRenderer()).setItemMargin(0.0);

        return chart;
    }
}
