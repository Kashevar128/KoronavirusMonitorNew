import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;


public class Parser {
    HashMap<String, String> map;

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
        map.put("Пермский край", "https://coronavirus-monitor.ru/coronavirus-v-permskom-krae/");
        map.put("Ульяновская область", "https://coronavirus-monitor.ru/coronavirus-v-ulyanovskoj-oblasti/");
        map.put("Ставропольский край", "https://coronavirus-monitor.ru/coronavirus-v-stavropolskom-krae/");
        map.put("Хабаровский край", "https://coronavirus-monitor.ru/coronavirus-v-khabarovskom-krae/");
        map.put("Мурманская область", "https://coronavirus-monitor.ru/coronavirus-v-murmanskoj-oblasti/");
        map.put("Алтайский край", "https://coronavirus-monitor.ru/coronavirus-v-altajskom-krae/");
        map.put("Республика Карелия", "https://coronavirus-monitor.ru/coronavirus-v-respublike-kareliya/");
        map.put("Омская область", "https://coronavirus-monitor.ru/coronavirus-v-omskoj-oblasti/");
        map.put("Краснодарский край", "https://coronavirus-monitor.ru/coronavirus-v-krasnodarskom-krae/");
        map.put("Вологодская область", "https://coronavirus-monitor.ru/coronavirus-v-vologodskoj-oblasti/");
        map.put("Пензенская область", "https://coronavirus-monitor.ru/coronavirus-v-penzenskoj-oblasti/");
        map.put("Приморский край", "https://coronavirus-monitor.ru/coronavirus-v-primorskom-krae/");
        map.put("Республика Коми", "https://coronavirus-monitor.ru/coronavirus-v-respublike-komi/");
        map.put("Забайкальский край", "https://coronavirus-monitor.ru/coronavirus-v-zabajkalskom-krae/");
        map.put("Ленинградская область", "https://coronavirus-monitor.ru/coronavirus-v-leningradskoj-oblasti/");
        map.put("Оренбургская область", "https://coronavirus-monitor.ru/coronavirus-v-orenburgskoj-oblasti/");
        map.put("Кировская область", "https://coronavirus-monitor.ru/coronavirus-v-kirovskoj-oblasti/");
        map.put("Новосибирская область", "https://coronavirus-monitor.ru/coronavirus-v-novosibirskoj-oblasti/");
        map.put("Республика Крым", "https://coronavirus-monitor.ru/coronavirus-v-respublike-komi/");
        map.put("Тверская область", "https://coronavirus-monitor.ru/coronavirus-v-tverskoj-oblasti/");
        map.put("Ямало-Немецкий автономный округ", "https://coronavirus-monitor.ru/coronavirus-v-yamalo-neneckom-avtonomnom-okruge/");
        map.put("Тульская область", "https://coronavirus-monitor.ru/coronavirus-v-tulskoj-oblasti/");
        map.put("Ярославская область", "https://coronavirus-monitor.ru/coronavirus-v-yaroslavskoj-oblasti/");
        map.put("Брянская область", "https://coronavirus-monitor.ru/coronavirus-v-bryanskoj-oblasti/");
        map.put("Республика Бурятия", "https://coronavirus-monitor.ru/coronavirus-v-respublike-buryatiya/");
        map.put("Белгородская область", "https://coronavirus-monitor.ru/coronavirus-v-belgorodskoj-oblasti/");
        map.put("Курская область", "https://coronavirus-monitor.ru/coronavirus-v-kurskoj-oblasti/");
        map.put("Псковская область", "https://coronavirus-monitor.ru/coronavirus-v-pskovskoj-oblasti/");
        map.put("Тюменская область", "https://coronavirus-monitor.ru/coronavirus-v-tyumenskoj-oblasti/");
        map.put("Кемеровская область", "https://coronavirus-monitor.ru/coronavirus-v-kemerovskoj-oblasti/");
        map.put("Республика Башкортостан", "https://coronavirus-monitor.ru/coronavirus-v-bashkortostane/");
        map.put("Республика Саха Якутия", "https://coronavirus-monitor.ru/coronavirus-v-yakutii/");
        map.put("Ивановская область", "https://coronavirus-monitor.ru/coronavirus-v-ivanovskoj-oblasti/");
        map.put("Орловская область", "https://coronavirus-monitor.ru/coronavirus-v-orlovskoj-oblasti/");
        map.put("Калужская область", "https://coronavirus-monitor.ru/coronavirus-v-kaluzhskoj-oblasti/");
        map.put("Астраханская область", "https://coronavirus-monitor.ru/coronavirus-v-astrakhanskoj-oblasti/");
        map.put("Удмуртская Республика", "https://coronavirus-monitor.ru/coronavirus-v-udmurtskoj-respublike/");
        map.put("Республика Дагестан", "https://coronavirus-monitor.ru/coronavirus-v-respublike-dagestan/");
        map.put("Томская область", "https://coronavirus-monitor.ru/coronavirus-v-tomskoj-oblasti/");
        map.put("Владимирская область", "https://coronavirus-monitor.ru/coronavirus-v-vladimirskoj-oblasti/");
        map.put("Калининградская область", "https://coronavirus-monitor.ru/coronavirus-v-kaliningradskoj-oblasti/");
        map.put("Тамбовская область", "https://coronavirus-monitor.ru/coronavirus-v-tambovskoj-oblasti/");
        map.put("Новгородская область", "https://coronavirus-monitor.ru/coronavirus-v-novgorodskoj-oblasti/");
        map.put("Липецкая область", "https://coronavirus-monitor.ru/coronavirus-v-lipeckoj-oblasti/");
        map.put("Смоленская область", "https://coronavirus-monitor.ru/coronavirus-v-smolenskoj-oblasti/");
        map.put("Рязанская область", "https://coronavirus-monitor.ru/coronavirus-v-ryazanskoj-oblasti/");
        map.put("Республика Чувашия", "https://coronavirus-monitor.ru/coronavirus-v-chuvashskoj-respublike/");
        map.put("Кабардино-Балкарская Республика", "https://coronavirus-monitor.ru/coronavirus-v-kabardino-balkarskoj-respublike/");
        map.put("Сахалинская область", "https://coronavirus-monitor.ru/coronavirus-v-sakhalinskoj-oblasti/");
        map.put("Амурская область", "https://coronavirus-monitor.ru/coronavirus-v-amurskoj-oblasti/");
        map.put("Республика Хакасия", "https://coronavirus-monitor.ru/coronavirus-v-respublike-khakasiya/");
        map.put("Костромская область", "https://coronavirus-monitor.ru/coronavirus-v-kostromskoj-oblasti/");
        map.put("Республика Калмыкия", "https://coronavirus-monitor.ru/coronavirus-v-respublike-kalmykiya/");
        map.put("Республика Татарстан", "https://coronavirus-monitor.ru/coronavirus-v-tatarstane/");
        map.put("Курганская область", "https://coronavirus-monitor.ru/coronavirus-v-kurganskoj-oblasti/");
        map.put("Карачаево-Черкесская республика", "https://coronavirus-monitor.ru/coronavirus-v-karacheevo-cherkesskoj-respublike/");
        map.put("Республика Мордовия", "https://coronavirus-monitor.ru/coronavirus-v-respublike-mordoviya/");
        map.put("Республика Алтай", "https://coronavirus-monitor.ru/coronavirus-v-respublike-altaj/");
        map.put("Республика Северная Осетия-Алания", "https://coronavirus-monitor.ru/coronavirus-v-severnoy-osetii/");
        map.put("Республика Тыва", "https://coronavirus-monitor.ru/coronavirus-v-respublike-tyva/");
        map.put("Республика Ингушетия", "https://coronavirus-monitor.ru/coronavirus-v-respublike-ingushetiya/");
        map.put("Камчатский край", "https://coronavirus-monitor.ru/coronavirus-v-kamchatskom-krae/");
        map.put("Республика Адыгея", "https://coronavirus-monitor.ru/coronavirus-v-respublike-adygeya/");
        map.put("Севастополь", "https://coronavirus-monitor.ru/coronavirus-v-sevastopole/");
        map.put("Республика Марий Эл", "https://coronavirus-monitor.ru/coronavirus-v-respublike-mehrij-ehl/");
        map.put("Чеченская Республика", "https://coronavirus-monitor.ru/coronavirus-v-chechenskoj-respublike/");
        map.put("Магаданская область", "https://coronavirus-monitor.ru/coronavirus-v-magadanskoj-oblasti/");
        map.put("Еврейская автономная область", "https://coronavirus-monitor.ru/coronavirus-v-evrejskoj-avtonomnoj-oblasti/");
        map.put("Немецкий автономный округ", "https://coronavirus-monitor.ru/coronavirus-v-neneckom-avtonomnom-okruge/");
        map.put("Чукотский автономный округ", "https://coronavirus-monitor.ru/coronavirus-v-chukotskom-avtonomnom-okruge/");
    }


    private Document getPage(String district) throws IOException {
        String url = this.map.get(district);
        return Jsoup.parse(new URL(url), 5000);
    }

    public String info(String district) {
        Document page = null;
        try {
            page = getPage(district);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element nameCity = page.select("h1[class='title center']").first();
        Element infectionValue = page.select("div[class='info-block disease']").first();
        Element healthValue = page.select("div[class='info-block healed']").first();
        Element deathValue = page.select("div[class='info-block deaths']").first();
        Element inf = page.select("p").first();

        StringBuilder message = new StringBuilder();
        String s = inf.text();
        message.append(nameCity.text() + ":" + "\n" + "\n" + infectionValue.text() + "\n" + healthValue.text() +
                "\n" + deathValue.text() + "\n" + "\n" + "Краткая сводка:" + "\n" + s );
        System.out.println(message);
        return message.toString();
    }

    public String[] splitter(String str) {
        System.out.println(str);
        String[] list = str.split(", ");
        for (String s : list) {
            System.out.println(s);
        }
        return list;
    }

    @Override
    public String toString() {
        Set<String> s = this.map.keySet();
        StringBuilder sbr = new StringBuilder(s.toString());
        sbr.delete(0, 1);
        sbr.setLength(sbr.length() - 1);
        return sbr.toString();
    }

}
