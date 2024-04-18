import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class EcommerceScraper {

    public static void main(String[] args) {
        // URL of the e-commerce website to scrape
        String url = "https://www.amazon.in/";

        try {
            // Connect to the website and get the HTML document
            Document doc = Jsoup.connect(url).get();

            // Select the product elements
            Elements products = doc.select(".product");

            // Create a CSV file to store the data
            FileWriter csvWriter = new FileWriter("products.csv");
            csvWriter.append("Name,Price,Rating\n");

            // Iterate over each product and extract information
            for (Element product : products) {
                // Extract name
                String name = product.select(".product-name").text();
                
                // Extract price
                String price = product.select(".product-price").text();
                
                // Extract rating
                String rating = product.select(".product-rating").text();

                // Write the extracted data to the CSV file
                csvWriter.append(name).append(",").append(price).append(",").append(rating).append("\n");
            }

            // Close the CSV writer
            csvWriter.flush();
            csvWriter.close();

            System.out.println("Scraping completed. Data saved to products.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
