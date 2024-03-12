// import java.util.ArrayList;
// import java.io.*;
// import java.util.Scanner;

// /*
//  * Problem 2 Sell My Pet Food
//  */
// public class TargetedAd {

//   public static void main(String[] args) {
//     /*
//      * PREPARATION WORK
//      * (1) Create a file called targetWords.txt. Populate this file with words on
//      * each line that
//      * you think would determine if a user is a dog or cat owner.
//      * 
//      * PROGRAMMING
//      * (2) Create a new DataCollector object and set the data to
//      * "socialMediaPostsSmall.txt" and "targetWords.txt"
//      * Important: Use the socialMedialPostsSmall to create your algorithm. Using a
//      * small file will help you
//      * generate your solution quicker and give you the ability to double check your
//      * work.
//      * (3) Create a String variable to hold the names of all the user. (The first
//      * word of every post is
//      * a person's username)
//      * (4) Compare each user's post to each target word. If a user mentions a target
//      * word, add their username to
//      * the String of users. Separate usernames with a space.
//      * Hint: You can use loops to look through each word.
//      * Hint2: You can use indexOf to check if a word is in a user post.
//      * (5) Once you have all the users, use your DataCollector's
//      * prepareAdvertisement method to prepare a file
//      * with all users and the advertisement you will send them.
//      * Additional Info: The prepareAdvertisement creates a new file on your
//      * computer. Check the posts of
//      * some of the usernames to make sure your algorithm worked.
//      * 
//      * THE FINAL SOLUTION
//      * (6) Your solution should work with the socialMedialPostsSmall.txt. Modify
//      * your DataCollector initialization
//      * so you use the socialMediaPosts.txt. You should now have a larger file of
//      * users to target.
//      */

//     /* your code here */
//     System.out.println("start");
//     DataCollector dc = new DataCollector();
//     dc.setData("SellMyPetFood/socialMediaPosts.txt", "SellMyPetFood/targetWords.txt");
//     ArrayList<String> users = new ArrayList<String>();
//     ArrayList<String> tws = new ArrayList<String>();
//     String userName;
//     String np = dc.getNextPost();
//     String tw = "";

//     File file = new File("SellMyPetFood/targetWords.txt");
//     // System.out.println("length: " + file.length());

//     try {

//       Scanner sc = new Scanner(file);

//       while (sc.hasNextLine()) {
//         String s = sc.nextLine();
//         System.out.println(s);
//         tws.add(dc.getNextTargetWord());
//       }
//       sc.close();
//     } catch (FileNotFoundException e) {
//       e.printStackTrace();
//     }

//     // System.out.println(tws.size());

//     while (!np.equals("end")) {
//       // System.out.println(np);
//       np = dc.getNextPost();
//       for (int i = 0; i < tws.size(); i++) {
//         // System.out.println("target: " + tws.get(i));
//         // System.out.println(np.indexOf(tws.get(i))); 
//         if (np.indexOf(tws.get(i)) != -1) {
//           // System.out.println("exists"); 
//           int index = np.indexOf(" "); 
//           String u = np.substring(0, index); 
//           users.add(u.concat(" ")); 
//           break; 
//         }
//       }
//     }
//     System.out.println("done");

//     for(String u : users) {
//       System.out.println(u); 
//     }
//     String usersString = String.join("", users); 
//     System.out.println(usersString); 
    
//     dc.prepareAdvertisement("SellMyPetFood/ad.txt", usersString, "hi"); 

//   }

// }
