import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by mmcalvarez on 2/21/2017.
 */
public class SystematicSampling extends GatherInput {

    private int sampleSize;
    private int startingPoint;
    private int k;
    private Random random = new Random();
    private List<Object> sampleList = new ArrayList<>();
    //private Scanner sc = new Scanner(System.in);

    public SystematicSampling(){
        title = "SYSTEMATIC SAMPLING";
    }

    public List<Object> randomSamples(List<Object> list){
        System.out.println("Please indicate the sample size: ");
        sampleSize = sc.nextInt();
        if (sampleSize > list.size() || sampleSize <= 0){
            //default computed n
            sampleSize = (int) Math.ceil(list.size() * .2);
        }
        k = list.size() / sampleSize;
        startingPoint = random.nextInt((k - 1) + 1) + 1;
        /*System.out.println(startingPoint);
        System.out.println(k);*/
        for(int i = 0, j = startingPoint - 1; i < sampleSize; i++, j += k){
            sampleList.add(list.get(j));
        }
        return sampleList;
    }
}
