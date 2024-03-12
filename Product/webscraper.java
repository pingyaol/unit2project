package jsoup;

import java.io.*; 
import java.io.IOException; 
import java.util.*; 

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class webscraper {
    public static void main(String[] args) throws IOException {
        Document doc1 = Jsoup.connect("https://www.walmart.com/reviews/product/549377034").get();
        Elements names1 = doc1.getElementsByClass("f6 gray pr2 mb2");
        Elements reviews1 = doc1.getElementsByClass("tl-m mb3 db-m");

        Document doc2 = Jsoup.connect("https://www.walmart.com/reviews/product/549377034?page=2").get();
        Elements names2 = doc2.getElementsByClass("f6 gray pr2 mb2"); 
        Elements reviews2 = doc2.getElementsByClass("tl-m mb3 db-m");

        Document doc3 = Jsoup.connect("https://www.walmart.com/reviews/product/549377034page=3").get();
        Elements names3 = doc3.getElementsByClass("f6 gray pr2 mb2");
        Elements reviews3 = doc3.getElementsByClass ("tl-m mb3 db-m");

        Document doc4 = Jsoup.connect("https://www.walmart.com/reviews/product/549377034page=4*").get();
        Elements names4 = doc4.getElementsByClass("f6 gray pr2 mb2");
        Elements reviews4 = doc4.getElementsByclass("tl-m mb3 db-m");

        Document doc5 = Jsoup.connect("https://www.walmart.com/reviews/product/549377034page=5").get();
        Elements names5 = doc5.getElementsByClass("f6 gray pr2 mb2");
        Elements review5 = doc5.getElementsByClass("tl-m mb3 db-m");

        for (Element n1:names1) {
            System.out.println(n1.text());
        }
    }

}
