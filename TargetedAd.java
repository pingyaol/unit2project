import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class TargetedAd {

    private static ArrayList<String> positiveUsers = new ArrayList<String>();
    private static ArrayList<String> negativeUsers = new ArrayList<String>();
    private static HashMap<String, Double> sentimentWords = new HashMap<String, Double>();
    private static ArrayList<Double> userSents = new ArrayList<Double>(); 

    public static void main(String[] args) {
        System.out.println("Start");
        DataCollector dc = new DataCollector();
        dc.setData("comments.txt", "sentimentWords.txt");

        // Load sentiment words and their sentiment

        try {
            Scanner input = new Scanner(new File("/Users/test/Downloads/unit2project/targetWords.txt"));
            while(input.hasNextLine()){
            String[] temp = input.nextLine().split(",");
            sentimentWords.put(temp[0],Double.parseDouble(temp[1]));
            // System.out.println("added "+ temp[0]+", "+temp[1]);
            }
            input.close();
        }
        catch(Exception e){
            System.out.println("Error reading or parsing targetWords.csv");
        }
        
        for (Map.Entry<String, Double> entry : sentimentWords.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println("Key=" + key + ", Value=" + value);
        }

        // Analyze posts for sentiment
        try {
            Scanner input = new Scanner(new File("/Users/test/Downloads/unit2project/scraped/comments.txt"));
            while(input.hasNextLine()){
                double total = 0; 
                String[] temp = input.nextLine().replaceAll("\\p{Punct}", "").split(" ");
                // System.out.println(String.join(" ", temp)); 
                for (String w : temp) {
                    if (sentimentWords.containsKey(w)) {
                        total += sentimentWords.get(w); 
                        // System.out.println("new total: " + total);
                    }
                }
                System.out.println(total); 
                userSents.add(total); 
            }
            input.close();
        }
        catch(Exception e){
            System.out.println("Error reading or parsing comments.csv");
        }

        // for (Double d: userSents) {
        //     if (d > 2) {
        //         System.out.println(d); 
        //     }
        // }

            // int index = np.indexOf(" ");
            // String username = np.substring(0, index);
            // if (foundPositive) {
            //     positiveUsers.add(username);
            // }
            // if (foundNegative) {
            //     negativeUsers.add(username);
            // }


        // Prepare advertisements based on sentiment
        String positiveAdContent = "Thank you for your positive feedback! Check out our new products!";
        String negativeAdContent = "We're sorry to hear about your experience. Here's a discount code for your next purchase.";

        // Assuming you have a method in DataCollector to prepare ads (you'll need to modify it to fit this context)
        // dc.prepareAdvertisement("positiveAd.txt", positiveUsers, positiveAdContent);
        // dc.prepareAdvertisement("negativeAd.txt", negativeUsers, negativeAdContent);

        System.out.println("Done");
    }
}
