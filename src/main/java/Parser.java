import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


public class Parser {

    private static Document getPage() throws IOException {
        String url = "https://coronavirus-monitor.ru/coronavirus-v-sankt-peterburge/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Element nameCity = page.select("h1[class='title center']").first();
        Element infectionValue = page.select("div[class='info-block disease']").first();
        Element healthValue = page.select("div[class='info-block healed']").first();
        Element deathValue = page.select("div[class='info-block deaths']").first();
        System.out.println(nameCity);
        System.out.println(infectionValue);
        System.out.println(healthValue);
        System.out.println(deathValue);

        String city = nameCity.text();
        String inf = infectionValue.text();
        System.out.println(city);
        System.out.println(inf);

    }
}
