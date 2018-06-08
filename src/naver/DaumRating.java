package naver;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DaumRating {
	public static void main(String[] args) throws IOException {
		
		String base_url = "http://movie.daum.net/moviedb/grade?movieId=114023";
		Document doc = Jsoup.connect(base_url).get();
		Elements review_info = doc.select("div.review_info");
		for(Element movie_info : review_info) {
			String mwriter = movie_info.select("em.link_profile").text();
			String mreview = movie_info.select("p.desc_review").text();
			String mscore = movie_info.select("em.emph_grade").text();
			String date = movie_info.select("span.info_append").text();
			String mdate = date.substring(0, 10);
			System.out.println(mwriter + ", " + mreview + ", " + ", " +  mscore + ", " + date + "\n" );
		}
		
		}


}
