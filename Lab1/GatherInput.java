import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mmcalvarez on 2/18/2017.
 */
public class GatherInput {
    String title;
    private int populationSize;
    private int choiceOfFrame;
    private int sampleInt;
    char sampleChar;
    Scanner sc = new Scanner(System.in);
    List<Object> list = new ArrayList<>();

    public void sampleFrame(){
        do {
            System.out.println("Please enter population size: ");
            populationSize = sc.nextInt();
        }while (populationSize <= 0);

        do {
            System.out.println("Press 1 if your sampling frame is numerical\nPress 2 if your sampling frame is character.");
            choiceOfFrame = sc.nextInt();

            try {
                if (choiceOfFrame == 1) {
                    System.out.println("Enter your samples: ");
                    for (int i = 0; i < populationSize; i++) {
                        sampleInt = sc.nextInt();
                        list.add(sampleInt);
                    }
                }
                if (choiceOfFrame == 2) {
                    System.out.println("Enter your samples: ");
                    try{
                        for(int i = 0; i < populationSize; i++){
                            sampleChar = sc.next().charAt(0);
                            if((sampleChar - '0') <= 9 && (sampleChar - 0) >= 0){
                                System.out.println("Samples must be characters.");
                                System.exit(0);
                            }else {
                                list.add(sampleChar);
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
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
