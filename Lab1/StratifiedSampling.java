import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StratifiedSampling extends GatherInput{
	private int samplePercentage;
	private int sampleSize;
	private List strata = new ArrayList<>();
	private List sampleList = new ArrayList<>();
	private List groupList = new LinkedList<>();
	private int compareValue;
	private int randomIndex;
	private Random random = new Random();
	 
	 public StratifiedSampling(){
	        title = "STRATIFIED SAMPLING";
	 }
	 
	 public List randomSamples(List list){
	        Collections.sort(list);
	        compareValue = 0;
	        for(int i = 0; i < list.size(); i++){
	        	if(list.get(i) != list.get(compareValue)){
	        		groupList.add(list.subList(compareValue, i));
	        		compareValue = i;
	        	}
	        	if( i == list.size()-1){
	        		groupList.add(list.subList(compareValue, i+1));
	        	}
	        }
	       
	        for(int i = 0; i < groupList.size(); i++){
	        	System.out.println("Strata " + (i+1));
	        	strata = (List) groupList.get(i);
	        	for(int j = 0; j < strata.size(); j++){
	        		System.out.println((j+1) + ".) " + strata.get(j));
	        	}
	        	System.out.println("\n");
	        }
	        
	        System.out.println("Please indicate the percentage of sample size: ");
	        samplePercentage = sc.nextInt();
	        if (samplePercentage > 100 || samplePercentage <= 0){
	            //default size percentage
	        	samplePercentage = 20;
	        }
	        for(int i = 0; i < groupList.size(); i++){
	        	strata = (List) groupList.get(i);
	        	sampleSize = (int) Math.ceil((strata.size() * samplePercentage)/100.0f);
	        	System.out.println(sampleSize);
	        	System.out.println(strata.size());
	        	for(int j = 0; j < sampleSize; j++){
	                 randomIndex = random.nextInt((strata.size() - 1) + 1) + 1; // index 1 up to size of the list minus 1
	                 randomIndex -= 1;
	                    		
	                sampleList.add(strata.get(randomIndex));
	            }
	        }
	        
	       return sampleList;
	 
	// return groupList;
	 }

}

