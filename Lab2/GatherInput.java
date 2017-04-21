package CMSC105LabAns2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GatherInput {
    String title;
    private String dataSetTitle;
    private int populationSize;
    private int choiceOfFrame;
    private int sampleInt;
    private char sampleChar;
    private String sampleString;
    private int categoricalSampleType;
   
    Scanner sc = new Scanner(System.in);
    List<Object> list = new ArrayList<>();

    public void sampleFrame(int choiceOfFrame){
    	
        do {
            System.out.println("Please enter population size: ");
            populationSize = sc.nextInt();
        }while (populationSize <= 0);

        do {
            try {
                if (choiceOfFrame == 2) {
                    System.out.println("Enter your samples: ");
                    for (int i = 0; i < populationSize; i++) {
        				try{
        			    sampleInt = sc.nextInt();
        			    list.add(sampleInt);
        				}
        				catch(Exception e){
        					System.out.println("Your samples are invalid.");
        					break;
        				}
                        
        			}
                }
                if (choiceOfFrame == 1) {
                	do{
                		System.out.println("Choose the sample type:\n1. Numerical\n2. Alphabet Character\n3. String");
                		categoricalSampleType = sc.nextInt();
                		int invalid;
                		do{
                			invalid = 0;
                			list.clear();
	                   		System.out.println("Enter your samples: ");
	                		
	                		if(categoricalSampleType == 1 ){
	                			for (int i = 0; i < populationSize; i++) {
	                				try{
	                			    sampleInt = sc.nextInt();
	                			    list.add(sampleInt);
	                				}
	                				catch(Exception e){
	                					System.out.println("Your samples are invalid.");
	                					break;
	                				}
	                                
	                			}
	                		}
	                		if(categoricalSampleType == 2){  
	                			              			
	                			for (int i = 0; i < populationSize; i++) {
		                                sampleChar = sc.next().charAt(0);
		                                if((sampleChar >= 'a' && sampleChar <= 'z') || (sampleChar >= 'A' && sampleChar <= 'Z')){
		                                	list.add(sampleChar);
		                                }
		                                else{
		                                	invalid = 1;
		                                	break;
		                                }
	                			}
	                		}
	                		if(categoricalSampleType == 3){
	                			for (int i = 0; i < populationSize; i++) {
	                                sampleString = sc.next();
	                                list.add(sampleString);
	                			}
	                		}
                		}while(invalid == 1);
                		
                	} while (categoricalSampleType > 3 && categoricalSampleType < 1);
                }
            } catch (Exception e) {
                throw new RuntimeException("Your samples are invalid.");
            }


            for (int i = 1; i <= list.size(); i++) {
                System.out.println(i + ".) " + list.get(i - 1));
            }

        } while (choiceOfFrame < 1 || choiceOfFrame > 2);
    }

    public List<Object> getList(){
        return list;
    }
    
    public void print(List<Object> list){
        System.out.println(title);
        for (int i = 1; i <= list.size(); i++) {
            System.out.println("[" + i + "] " + list.get(i - 1));
        }
    }

}
