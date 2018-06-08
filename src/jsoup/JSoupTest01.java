package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupTest01 {
	public static void main(String[] args) {
		try {
			String baseUrl = "http://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=105&sid2=230";
			String url = "";
			
			Document html = Jsoup.connect(baseUrl).get();
			
			String pageTag = "div.paging>a";
			Integer pageSize = html.select(pageTag).size();
			
			for(int i = 0; i < pageSize + 1; i++) {
				url = baseUrl + "&page=" + (i + 1);
				
				Document doc = Jsoup.connect(url).get();
				String tag = "div#main_content>div.newsflash_body dt:not(.photo)>a";
				
				Elements elements = html.select(tag);
				
				for(Element el : elements) {
					String link = el.attr("href");
					
					Document docs = Jsoup.connect(link).get();
					
					String titleTag = "h3#articleTitle";
					String title = docs.select(titleTag).text();
					
					String contentsTag = "div#articleBodyContents";
					String contents = docs.select(contentsTag).text();
					
					System.out.println("제목 : " + title);
					System.out.println("내용 : " + contents);
					System.out.println("\n");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
