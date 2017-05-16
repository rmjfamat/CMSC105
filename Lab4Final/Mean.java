package IntegratedDataHandling;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Mean extends JFrame{
    List<Double> var = new ArrayList<>();
    Double sum2;

    Mean(){

    }

    public void getMean(List<Object> list, int choice, JFrame frame){
        float sum = 0.0f;
        float total = 0.0f;
        float mean;
        float s;

        switch (choice){
            case 1 :
                for (int i = 0; i < list.size(); i++){
                    sum += Integer.parseInt((String) list.get(i));
                }
                mean = sum/list.size();

                for (int i = 0; i < list.size(); i++){
                    total += Math.pow(Integer.parseInt((String) list.get(i)) - mean, 2);
                }
                s = (float) Math.sqrt(total/(list.size()-1));
                
                JOptionPane.showMessageDialog(frame,
                	    "Mean: " + mean + "\nStandard Deviation" + s,
                	    "Mean",
                	    JOptionPane.PLAIN_MESSAGE);

                break;

            case 2 :
                for (int i = 0; i < list.size(); i++){
                    sum += Double.parseDouble((String) list.get(i));
                }
                mean = sum/list.size();

                for (int i = 0; i < list.size(); i++){
                    total += Math.pow(Double.parseDouble((String) list.get(i)) - mean, 2);
                }
                s = (float) Math.sqrt(total/(list.size()-1));
                JOptionPane.showMessageDialog(frame,
                	    "Mean: " + mean + "\nStandard Deviation" + s,
                	    "Mean",
                	    JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }

    public void getMean(ArrayList<Double> columnD, ArrayList<Double> freq, ArrayList<Double> product2){
    	float total1 = 0.0f;
        float total2 = 0.0f;
        float total3 = 0.0f;
        float mean;
        float s;


        for (int i = 0; i < columnD.size();i++){
            total1 += columnD.get(i);
        }

        for (int i = 0; i < freq.size();i++){
            total2 += freq.get(i);
        }

        for (int i = 0; i < product2.size(); i++){
            total3 += product2.get(i);
        }
        mean = (total1/total2);
        System.out.println("[Mean] " + mean + "\n");
        float numerator = (float) ((total2 * total3) - Math.pow(total1, 2));
        float denominator = total2 * (total2 - 1.0f);
        float variance = (numerator/denominator);
        s = (float) Math.sqrt(numerator/denominator);

        //System.out.println("MM Gwapa");

        System.out.println("[Variance] " + variance + "\n");
        System.out.println("[Standard Deviation] " + s + "\n");
    }
}

