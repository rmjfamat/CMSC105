import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by mmcalvarez on 2/18/2017.
 */
public class SimpleRandomSampling extends GatherInput{
    private int sampleSize;
    private int randomIndex;
    private Random random = new Random();
    private List<Object> sampleList = new ArrayList<>();
    //Scanner sc = new Scanner(System.in);

    public SimpleRandomSampling(){
        title = "RANDOM SAMPLING";
    }

    public List<Object> randomSamples(List<Object> list){
        System.out.println("Please indicate the sample size: ");
        sampleSize = sc.nextInt();
        if (sampleSize > list.size() || sampleSize <= 0){
            //default computed n
            sampleSize = (int) Math.ceil(list.size() * .2);
        }
        for(int i = 0; i < sampleSize; i++){
            do{
                randomIndex = random.nextInt((list.size() - 1) + 1) + 1; // index 1 up to size of the list minus 1
                //System.out.println(randomIndex + "lll");
                randomIndex -= 1;
            }while(sampleList.contains(list.get(randomIndex)));

            sampleList.add(list.get(randomIndex));
        }
        return sampleList;
    }
}
