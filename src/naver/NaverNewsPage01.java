package naver;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverNewsPage01 {
	public static void main(String[] args) throws IOException {
		
		// URL �ּ�
		String baseUrl = "http://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=105&sid2=230";
		
		// �ش� URL �������� ��ü HTML �ҽ��ڵ带 ������ ��
		Document doc = Jsoup.connect(baseUrl).get();
		
//		System.out.println(doc);
		
		// �����͸� ������ �� �±�
		// Elements, s�� �������� �迭Ÿ��
		Elements news_url = doc.select(".photo > a");
		
//		System.out.println(news_url);
		
		// Elements���� ������� URL �ּҰ� �迭�� ���� �� ����
		// for���� ���鼭 1�Ǿ� ���
		for (Element element : news_url) {
			String url = element.attr("href");
			System.out.println("a �±� ��� : " + url);
			
			Document doc2 = Jsoup.connect(url).get();
			
			Elements title = doc2.select("div.article_info > h3");
			Elements body = doc2.select("div#articleBodyContents");
			
			String str = body.text();
			System.out.println("���� : " + title.text());
			System.out.println("���� : " + str);
			
		}
	}
}
