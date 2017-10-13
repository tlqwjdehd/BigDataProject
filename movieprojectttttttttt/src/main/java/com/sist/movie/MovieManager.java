package com.sist.movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;



// \BF\AA\B4\EB \B9ڽ\BA\BF\C0\C7ǽ\BA (\C1\A6\B8\F1,\B0\FC\B0\B4\BC\F6,\C6\F7\BD\BA\C5\CD) + \C7\F6\C0\E7 \B9ڽ\BA\BF\C0\C7ǽ\BA(\C1\A6\B8\F1,\C6\F7\BD\BA\C5\CD)

public class MovieManager {
	public static void main(String[] args) {
		MovieManager mm=new MovieManager();
		mm.cine21Boxoffice_history();
		//mm.cine21Boxoffice();
		//mm.cine21Calum();
		//mm.cine21Boxoffice_history_info();
		//mm.actor();
	}
	// 역대 박스오피스 100위
	public List<String> cine21Boxoffice_history() {
		
		List<String> list=new ArrayList<String>();
		try {
			Document doc=Jsoup.connect("http://www.cine21.com/rank/boxoffice/history").get();
			Elements title=doc.select("li.boxoffice_li div.mov_name");
			Elements people=doc.select("li.boxoffice_li div.people_num");
			Elements image=doc.select("li.boxoffice_li img");
			Elements rank=doc.select("li.boxoffice_li span.grade");
			Elements code=doc.select("li.boxoffice_li a");
			for(int i=0;i<title.size();i++) {
				Element telem=title.get(i);
				Element pelem=people.get(i);
				Element ielem=image.get(i);
				Element relem=rank.get(i);
				Element celem=code.get(i);
				String aaa=pelem.text().substring(4,pelem.text().length());
				String poster=ielem.attr("src");
				String code1=celem.attr("href");
				String code2=code1.substring(22,code1.length());
				list.add(code2);
				
				//num[i]=Integer.parseInt(code2);
				
				System.out.println(relem.text()+" "+telem.text()+"  관객 :"+aaa+"명  "+poster);
				/*System.out.println(code2);*/
				
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
	public void cine21Boxoffice_history_info() {
		try {
			List<String> cine21code=cine21Boxoffice_history();
			for(int a=1;a<cine21code.size();a++) {
			String cine21=cine21code.get(a);
			Document doc=Jsoup.connect("http://www.cine21.com/movie/info/?movie_id="+cine21).get();
			Elements story=doc.select("div.story_area");
			String selem=story.text();
			//System.out.println(a+" "+selem);
			
			
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void cine21Boxoffice() {
		try {
			Document doc=Jsoup.connect("http://movie.naver.com/movie/running/current.nhn#").get();
			Elements title=doc.select("dl.lst_dsc dt.tit a");
			Elements image=doc.select("div.thumb img");
			for(int i=0;i<10;i++) {
				Element telem=title.get(i);
				Element ielem=image.get(i);
				String poster=ielem.attr("src");
				/*String aaa=pelem.text().substring(4,pelem.text().length());*/
							
				/*System.out.println(telem.text()+" , \C1ָ\BB\B0\FC\B0\B4 : "+ielem);*/
				/*System.out.println(poster);*/
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	/*public void cine21Calum() {
		try {
			Document doc=Jsoup.connect("http://www.cine21.com/news/list/?idx=6").get();
			Elements title=doc.select("div.news_area ul.news span.tit");
			Elements content=doc.select("div.news_area span.thumb span.nothumb");
			for(int i=0;i<title.size();i++) {
				Element telem=title.get(i);
				Element celem=content.get(i);
				System.out.println(telem.text());
				System.out.println(celem.text());
				
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}*/
	//409726  \B3\D7\C0̹\F6 \BF\B5ȭ\C0\CE \C0̸\A7 \B9\D7 \C0̹\CC\C1\F6
	public void actor(){
		  
			try {
				for(int k=263; k<300; k++) {
				Document doc=Jsoup.connect("http://movie.naver.com/movie/bi/pi/basic.nhn?code="+k).get();
				Elements name=doc.select("div#content h3.h_movie a");
				Elements image=doc.select("div.poster img");
				String nelem=name.get(1).text();
				String ielem=image.attr("src");
					if(nelem==null) {
						continue;
					}else {
						/*System.out.println(k+" "+nelem+" "+ielem);*/
					}
				}
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
			
	  }
}