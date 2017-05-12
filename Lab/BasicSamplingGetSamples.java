package IntegratedDataHandling;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BasicSamplingGetSamples {
	private List data = new ArrayList();
	private List samples = new ArrayList();
	private int sampleSize;
	private int randomIndex;
	private int startingPoint;
    private int k;
	private Random random = new Random();
	private int samplePercentage;
	private List strata = new ArrayList<>();
	private List groupList = new LinkedList<>();
	private int compareValue;
	
	BasicSamplingGetSamples(int sampleSize, List data){
		this.sampleSize = sampleSize;
		this.data = data;
	}
	public List getRandomSamples(){
		if (sampleSize > data.size() || sampleSize <= 0){
            //default computed n
            sampleSize = (int) Math.ceil(data.size() * .2);
        }
        for(int i = 0; i < sampleSize; i++){
            do{
                randomIndex = random.nextInt((data.size() - 1) + 1) + 1; // index 1 up to size of the list minus 1
                //System.out.println(randomIndex + "lll");
                randomIndex -= 1;
            }while(samples.contains(data.get(randomIndex)));
            samples.add(randomIndex);
            samples.add(data.get(randomIndex));
        }
        return samples;	
	}
	
	public List getSystematicSamples(){
		if (sampleSize > data.size() || sampleSize <= 0){
            //default computed n
            sampleSize = (int) Math.ceil(data.size() * .2);
        }
        k = data.size() / sampleSize;
        startingPoint = random.nextInt((k - 1) + 1) + 1;
        
        for(int i = 0, j = startingPoint - 1; i < sampleSize; i++, j += k){
        	samples.add(j);
            samples.add(data.get(j));
        }
        return samples;
	}
	
	public List getStratifiedSamples(){
		Collections.sort(data);
        compareValue = 0;
        for(int i = 0; i < data.size(); i++){
        	if(data.get(i) != data.get(compareValue)){
        		groupList.add(data.subList(compareValue, i));
        		compareValue = i;
        	}
        	if( i == data.size()-1){
        		groupList.add(data.subList(compareValue, i+1));
        	}
        }
       
        /*for(int i = 0; i < groupList.size(); i++){
        	
        	strata = (List) groupList.get(i);
        	for(int j = 0; j < strata.size(); j++){
        		System.out.println((j+1) + ".) " + strata.get(j));
        	}
        	System.out.println("\n");
        }*/ //print strata
        
        
        if (samplePercentage > 100 || samplePercentage <= 0){
        	samplePercentage = 20;
        }
        for(int i = 0; i < groupList.size(); i++){
        	strata = (List) groupList.get(i);
        	sampleSize = (int) Math.ceil((strata.size() * samplePercentage)/100.0f);
        	
        	for(int j = 0; j < sampleSize; j++){
                 randomIndex = random.nextInt((strata.size() - 1) + 1) + 1; // index 1 up to size of the list minus 1
                 randomIndex -= 1;
                
                samples.add(strata.get(randomIndex));
                
                //display of stratified
            }
        }
        
       return samples;
	}
	
}
