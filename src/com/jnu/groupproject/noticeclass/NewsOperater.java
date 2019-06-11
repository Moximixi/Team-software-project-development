package com.jnu.groupproject.noticeclass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.jnu.groupproject.view.PanelUserInfo;

//Document pageDocument = Jsoup.connect("https://news.sina.com.cn/china/").get();
//Elements elements=pageDocument.getElementsByAttributeValue("class", "news-2");
//Elements element=elements.get(0).getElementsByTag("a");
//System.out.println();

public class NewsOperater {
	private Logger log = Logger.getLogger(PanelUserInfo.class); 
	public NewsOperater() throws Exception,FileNotFoundException,IOException {
		PropertyConfigurator.configure("log4j.properties");
	//public static void main(String[] args)throws Exception,FileNotFoundException,IOException {
		//序列化
		ArrayList<News> newsList=new ArrayList<News>();
		ArrayList<News> RDnewsList=new ArrayList<News>();
		ArrayList<News> GNnewsList=new ArrayList<News>();
		ArrayList<News> GWnewsList=new ArrayList<News>();
		ArrayList<News> JSnewsList=new ArrayList<News>();
		ArrayList<News> WHnewsList=new ArrayList<News>();
		NoticeSerializeOperater newsoperater=new NoticeSerializeOperater<News>();
				
		String GuoNeiNews="https://news.sina.com.cn/china/";
		String newspath="./src/com/jnu/groupproject/data/news.dat";
		String RDnewspath="./src/com/jnu/groupproject/data/RDnews.dat";
		String GNnewspath="./src/com/jnu/groupproject/data/GNnews.dat";
		String GWnewspath="./src/com/jnu/groupproject/data/GWnews.dat";
		String JSnewspath="./src/com/jnu/groupproject/data/JSnews.dat";
		String WHnewspath="./src/com/jnu/groupproject/data/WHnews.dat";
		
		//要闻
		Document pageDocument = Jsoup.connect("https://news.sina.com.cn/").get();
		Elements elements=pageDocument.getElementsByAttributeValue("id", "ad_entry_b2");
		Elements element=elements.get(0).getElementsByTag("a");
		for(int i=0;i<element.size();i++) {
			News news=new News();
			String title=element.get(i).text();
			String href=element.get(i).attr("href");
			news.setTitle(title);
			news.setUrl(href);
			news.setSource("热点新闻");
			RDnewsList.add(news);
			newsList.add(news);
				}
		
		//国内新闻
		pageDocument = Jsoup.connect("https://news.sina.com.cn/china/").get();
		elements=pageDocument.getElementsByAttributeValue("class", "news-2");
		element=elements.get(0).getElementsByTag("a");
		for(int i=0;i<element.size();i++) {
			News news=new News();
			String title=element.get(i).text();
			String href=element.get(i).attr("href");
			news.setTitle(title);
			news.setUrl(href);
			news.setSource("国内新闻");
			GNnewsList.add(news);
			newsList.add(news);
		}
		
		//国际新闻
		pageDocument = Jsoup.connect("https://news.sina.com.cn/world/").get();
		elements=pageDocument.getElementsByAttributeValue("class", "blk122");
		element=elements.get(0).getElementsByTag("a");
		for(int i=0;i<element.size();i++) {
			News news=new News();
			String title=element.get(i).text();
			String href=element.get(i).attr("href");
			news.setTitle(title);
			news.setUrl(href);
			news.setSource("国际新闻");
			GWnewsList.add(news);
			newsList.add(news);
		}
		
		//军事新闻
		pageDocument = Jsoup.connect("https://mil.news.sina.com.cn/").get();
		elements=pageDocument.getElementsByAttributeValue("class", "fs_right");
		element=elements.get(0).getElementsByTag("a");
		for(int i=0;i<element.size();i++) {
			News news=new News();
			String title=element.get(i).text();
			String href=element.get(i).attr("href");
			news.setTitle(title);
			news.setUrl(href);
			news.setSource("军事新闻");
			if(title.equals(""));
			else {
				JSnewsList.add(news);
				newsList.add(news);
			}
		}
		
		//文化新闻
		pageDocument = Jsoup.connect("http://cul.news.sina.com.cn/").get();
		elements=pageDocument.getElementsByAttributeValue("class", "blk12");
		element=elements.get(0).getElementsByTag("a");
		for(int i=0;i<element.size();i++) {
			News news=new News();
			String title=element.get(i).text();
			String href=element.get(i).attr("href");
			news.setTitle(title);
			news.setUrl(href);
			news.setSource("文化新闻");
			WHnewsList.add(news);
			newsList.add(news);
		}
		
		newsoperater.save(newsList, newspath);
		newsoperater.save(RDnewsList, RDnewspath);
		newsoperater.save(GNnewsList, GNnewspath);
		newsoperater.save(GWnewsList, GWnewspath);
		newsoperater.save(JSnewsList, JSnewspath);
		newsoperater.save(WHnewsList, WHnewspath);
		ArrayList<News> Desnews=newsoperater.load(newspath);
		log.info("成功爬取新浪新闻："+Desnews.size());
	}
}

