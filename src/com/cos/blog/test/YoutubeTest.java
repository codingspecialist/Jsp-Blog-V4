package com.cos.blog.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class YoutubeTest {
	
	@Test
	public void targetTest() {
		String content = "<p><a href=\"https://www.youtube.com/watch?v=LHWYSE85a6U\" target=\"_blank\">https://www.youtube.com/watch?v=LHWYSE85a6U</a><a href=\"https://www.youtube.com/watch?v=LHWYSE85a6U\"></a></p><p><a href=\\\"https://www.youtube.com/watch?v=LHWYSE85a6U\\\" target=\\\"_blank\\\">https://www.youtube.com/watch?v=LHWYSE85a6U</a><a href=\\\"https://www.youtube.com/watch?v=LHWYSE85a6U\\\"></a></p>";
		Document doc = Jsoup.parse(content);
		
		Elements els = doc.select("a");
		// System.out.println(els.get(0));
		for (Element el : els) {
			String target = el.attr("target");
			System.out.println(target);
		}
		
		
	}

	public void preview() {
		String content = "<a href=\"https://youtu.be/TgOu00Mf3kI\">\r\n" + 
				"https://youtu.be/TgOu00Mf3kI\r\n" + 
				"</a>";
		//System.out.println(content);
		
		Document doc = Jsoup.parse(content);
		//System.out.println(doc.toString());
		Elements els = doc.select("a");
		Element el = els.get(0);
		//System.out.println(el.toString());
		String value = el.attr("href");
		System.out.println(value);
		
		String arr[] = value.split("/");
		for (String s : arr) {
		System.out.println(s);	
		}
		System.out.println(doc);
	}
}	
