package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dao.MovieDAO;
import dto.MovieDTO;

public class JSoupTest02 {
	public static void main(String[] args) {
		try {
			int page = 1;
			
			MovieDAO movieDAO = new MovieDAO();
			String title = "";
			
			while(true) {
				String url = "http://movie.daum.net/moviedb/grade?movieId=108633&type=netizen&page=" + page;
				Document document = Jsoup.connect(url).get();
				
				if(page == 1) {
					String titleTag = "h2.tit_rel";
					title = document.select(titleTag).text();
				}
				
				String listTag = "ul.list_review>li";
				
				MovieDTO movieDTO = null;
				
				if(document.select("p.txt_nonerating").size() == 0) {
					Elements commentElements = document.select(listTag);
					
					for(Element element : commentElements) {
						String nick = element.select("div.review_info>a>em").text();
						String comments = element.select("div.review_info>p.desc_review").text();
						
						if(comments == null || comments.equals("") || comments.length() == 0) {
							comments = "의견 없음";
						}
						
						String gradeString = element.select("div.review_info>div.raking_grade>em").text();
						Float grade = null;
						
						if(gradeString == null || gradeString.equals("") || gradeString.length() == 0) {
							grade = (float) 0;
						} else {
							grade = Float.parseFloat(gradeString);
						}
						
						movieDTO = new MovieDTO();
						movieDTO.setMtitle(title);
						movieDTO.setMwriter(nick);
						movieDTO.setMscore(grade);
						movieDTO.setMreviews(comments);
						
						System.out.println(movieDTO);
						
						movieDAO.insertMovie(movieDTO);
					}
				} else {
					break;
				}
				
				page++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}