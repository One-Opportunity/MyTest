package jsoup;

import java.awt.Image;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupTest00 {
	private static final String frontBaseUrl = "http://wasabisyrup.com";
	
	public static void main(String[] args) {
		try {
			String url = "https://marumaru.in/b/manga/125661";
			String tag = "div#vContent a[target=_blank]";
			
			Document document = Jsoup.connect(url).get();
			Elements elements = document.select(tag);
			
			Image image = null;
			
			for(Element element : elements) {
				String link = element.absUrl("href");
				String imgTags = "div.gallery-template>img";
				
				Document doc = Jsoup.connect(link).get();
				
				Elements eles = doc.select(imgTags);
				
				for(Element el : eles) {
					String imgUrl = "https://wasabisyrup.com" + el.attr("data-src");
				}
				break;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
