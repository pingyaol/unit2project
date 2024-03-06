import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Scrapper {
  public static void main(String[] args) {
    Document doc;

    // getting the html text
    // original link: https://www.walmart.com/ip/Apple-iPhone-12-64GB-128GB-256GB-All-Colors-Factory-Unlocked-Cell-Phones-Good-Condition-Refurbished/549377034?athbdg=L1600&from=/search 
    File file = new File("Product/phone.html");

    try {

      Scanner sc = new Scanner(file);

      while (sc.hasNextLine()) {
        String s = sc.nextLine();
        doc = Jsoup.parse(s);
        // System.out.println(page);
      }
      sc.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println(doc.title());

    // getting the comments section
    try {
      Elements allElements = doc.getAllElements();
      for (Element element : allElements) {
        System.out.println(element.nodeName()
            + " " + element.ownText());
      }

      // Elements comments = document.select("li.dib");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
