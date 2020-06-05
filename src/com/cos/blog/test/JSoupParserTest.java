package com.cos.blog.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JSoupParserTest {
	
	@Test
	public void html파서() {
		String content = "<p>fdsafsda</p><p>fdsa</p>";
		Document doc = Jsoup.parse(content);
		//System.out.println(doc.toString());
		
		Elements els = doc.select("p");
		
		Element el = els.get(1); // p태그 첫번째
		System.out.println(el.toString());
		System.out.println(el.text());
	}
}
