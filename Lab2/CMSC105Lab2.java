package CMSC105LabAns2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CMSC105Lab2 {
    private int choice;
    private GatherInput input = new GatherInput();
    private List<Object> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private String dataSetTitle;
    public static void main (String[]args){
        CMSC105Lab2 lab = new CMSC105Lab2();
        lab.run();
    }

    private void run(){

        do {
            System.out.println("\tSUMMARIZING AND PRESENTING DATA\n" +
                    "1. Categorical\n" +
                    "2. Numerical\n" +
                    "3. Quit\n" +
                    "Enter choice: ");
            choice = sc.nextInt();
        }while (choice < 1 || choice > 3);

        System.out.println("Enter a brief title of your data set.");
    	dataSetTitle = sc.next();
    	
        switch (choice){
            case 1 :
            	CategoricalDataSet categorical = new CategoricalDataSet();
            	input.sampleFrame(choice);
            	categorical.printTable(input.getList(), dataSetTitle);
            	break;
            case 2 :
            	NumericalDataSet numerical = new NumericalDataSet();
                input.sampleFrame(choice);
                numerical.printTable(input.getList(), dataSetTitle);
                break;
            
            case 3 :
                System.exit(0);
                    
        }
    }

}
