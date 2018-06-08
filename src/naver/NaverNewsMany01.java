package naver;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverNewsMany01 {
	static String base_url = "http://news.naver.com/main/list.nhn?mode=LS2D&sid2=230&sid1=105&mid=shm&date=20180605&page=";
	static int page = 1;
	static String complete_url = base_url + page;

	public static void main(String[] args) throws IOException {
		while(page <= 6) {
			Document naver_news = Jsoup.connect(complete_url).get();
			Elements news_url = naver_news.select(".photo > a");
			for(Element element:news_url) {
				String url = element.attr("href");
				
				Document doc = Jsoup.connect(url).get();
				
				Elements title = doc.select("div.article_info > h3");
				Elements body = doc.select("div#articleBodyContents");
				
				String str = body.text();
				System.out.println("제목 : " + title.text());
				System.out.println("본문 : " + str);
			}
			page = page + 1;
			complete_url = base_url + page;
		}
	}
}
