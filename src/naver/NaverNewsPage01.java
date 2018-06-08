package naver;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverNewsPage01 {
	public static void main(String[] args) throws IOException {
		
		// URL 주소
		String baseUrl = "http://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=105&sid2=230";
		
		// 해당 URL 페이지의 전체 HTML 소스코드를 가지고 옴
		Document doc = Jsoup.connect(baseUrl).get();
		
//		System.out.println(doc);
		
		// 데이터를 가지고 올 태그
		// Elements, s가 붙음으로 배열타입
		Elements news_url = doc.select(".photo > a");
		
//		System.out.println(news_url);
		
		// Elements에는 기사제목 URL 주소가 배열로 여러 건 저장
		// for문을 돌면서 1건씩 출력
		for (Element element : news_url) {
			String url = element.attr("href");
			System.out.println("a 태그 경로 : " + url);
			
			Document doc2 = Jsoup.connect(url).get();
			
			Elements title = doc2.select("div.article_info > h3");
			Elements body = doc2.select("div#articleBodyContents");
			
			String str = body.text();
			System.out.println("제목 : " + title.text());
			System.out.println("본문 : " + str);
			
		}
	}
}
