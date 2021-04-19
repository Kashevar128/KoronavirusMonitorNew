import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;


public class Parser {
    HashMap <String, String> map;

    public Parser() {
        map = new HashMap<>();

        map.put("Москва", "https://coronavirus-monitor.ru/coronavirus-v-moskve/");
        map.put("Санкт-Петербург", "https://coronavirus-monitor.ru/coronavirus-v-sankt-peterburge/");
        map.put("Московская область", "https://coronavirus-monitor.ru/coronavirus-v-moskovskoj-oblasti/");
        map.put("Нижегородская область", "https://coronavirus-monitor.ru/coronavirus-v-nizhegorodskoj-oblasti/");
        map.put("Ростовская область", "https://coronavirus-monitor.ru/coronavirus-v-rostovskoj-oblasti/");
        map.put("Свердловская область", "https://coronavirus-monitor.ru/coronavirus-v-sverdlovskoj-oblasti/");
        map.put("Воронежская область", "https://coronavirus-monitor.ru/coronavirus-v-voronezhskoj-oblasti/");
        map.put("Красноярский край", "https://coronavirus-monitor.ru/coronavirus-v-krasnoyarskom-krae/");
        map.put("Иркутская область", "https://coronavirus-monitor.ru/coronavirus-v-irkutskoj-oblasti/");
        map.put("Архангельская область", "https://coronavirus-monitor.ru/coronavirus-v-arkhangelskoj-oblasti/");
        map.put("Самарская область", "https://coronavirus-monitor.ru/coronavirus-v-samarskoj-oblasti/");
        map.put("Челябинская область", "https://coronavirus-monitor.ru/coronavirus-v-chelyabinskoj-oblasti/");
        map.put("Саратовcкая область", "https://coronavirus-monitor.ru/coronavirus-v-saratovskoj-oblasti/");
        map.put("Волгоградская область", "https://coronavirus-monitor.ru/coronavirus-v-volgogradskoj-oblasti/");
        map.put("Ханты-Мансийский АО", "https://coronavirus-monitor.ru/coronavirus-v-khanty-mansijskom-ao/");
        map.put("Пермский край", "");
        map.put("Ульяновская область","");
        map.put("Ставропольский край", "");
        map.put("Хабаровский край", "");
        map.put("Мурманская область", "");
        map.put("Алтайский край", "");
        map.put("Республика Карелия", "");
        map.put("Омская область", "");
        map.put("Краснодарский край", "");
        map.put("Вологодская область", "");
        map.put("Пензенская область", "");
        map.put("Приморский край", "");
        map.put("Республика Коми", "");
        map.put("Забайкальский край", "");
        map.put("Ленинградская область", "");
        map.put("Оренбургская область", "");
        map.put("Кировская область", "");
        map.put("Новосибирская область", "");
        map.put("Республика Крым", "");
        map.put("Тверская область", "");
        map.put("Ямало-Немецкий автономный округ", "");
        map.put("Тульская область", "");
        map.put("Ярославская область", "");
        map.put("Брянская область", "");
        map.put("Республика Бурятия", "");
        map.put("Белгородская область", "");
        map.put("Курская область", "");
        map.put("Псковская область", "");
        map.put("Тюменская область", "");
        map.put("Кемеровская область", "");
        map.put("Республика Башкортостан", "");
        map.put("Республика Саха", "");
        map.put("Ивановская область", "");
        map.put("Орловская область", "");
        map.put("Калужская область", "");
        map.put("Астраханская область", "");
        map.put("Удмуртская Республика", "");
        map.put("Республика Дагестан", "");
        map.put("Томская область", "");
        map.put("Владимирская область", "");
        map.put("Калининградская область", "");
        map.put("Тамбовская область" , "");
        map.put("Новгородская область", "");
        map.put("Липецкая область", "");
        map.put("Смоленская область", "");
        map.put("Рязанская область", "");
        map.put("Республикаб Чувашия","");
    }

    private static Document getPage() throws IOException {
        String url = "https://coronavirus-monitor.ru/coronavirus-v-sankt-peterburge/";
        Document page = Jsoup.parse(new URL(url), 5000);
        return page;
    }



    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Element nameCity = page.select("h1[class='title center']").first();
        Element infectionValue = page.select("div[class='info-block disease']").first();
        Element healthValue = page.select("div[class='info-block healed']").first();
        Element deathValue = page.select("div[class='info-block deaths']").first();

        String message = nameCity.text() + "\n" + infectionValue.text() + "\n" + healthValue.text() +
                "\n" + deathValue.text();
        System.out.println(message);

    }
}
