package com.jnu.groupproject.noticeclass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NewsOperater {
	//public NewsOperater() throws Exception,FileNotFoundException,IOException {
		public static void main(String[] args)throws Exception,FileNotFoundException,IOException {
				String url="https://news.sina.com.cn/roll/#pageid=153&lid=2509&k=&num=50&page=1";
				String pageurl="https://news.sina.com.cn/roll/#pageid=153&lid=2509&k=&num=50&page=";
				String dataurl="";
				String collegnoticepath="./XLNEWS.dat";
				ArrayList<CollegeNotice> noticeList=new ArrayList<CollegeNotice>();
				NoticeSerializeOperater noticeoperater=new NoticeSerializeOperater<CollegeNotice>();
				Document document = Jsoup.connect(url).get();
				/*
				//获取最大页数
				Elements PageCountElement=document.getElementsByAttributeValue("class","all_pages");
				int PageCount=Integer.valueOf(PageCountElement.text()).intValue();
				*/
				
				//爬取数据并序列化与反序列化
				for(int i=1;i<=2;i++) {
				//for(int i=1;i<=PageCount;i++) {
					String noticeurl=null;
					noticeurl=pageurl+i;
					//System.out.println(noticeurl);
					Document pageDocument = Jsoup.connect("http://news.sina.com.cn/hotnews/").get();
					
		            Elements elements=pageDocument.getElementsByAttributeValue("cellspacing", "0");
		            Elements element=elements.get(0).getElementsByTag("tbody");
		            Elements element1=element.get(0).getElementsByTag("td");
		            System.out.println(element);
		            /*
		            Elements element=elements.get(0).getElementsByTag("ul");
		            System.out.println(element);
		            for(int pageNoticesize=0;pageNoticesize<element.size();pageNoticesize++) {
		            	Elements element1=element.get(pageNoticesize).getElementsByTag("a");//标题
						Elements element2=element.get(pageNoticesize).getElementsByClass("news_meta");//日期
						Elements element3=element.get(pageNoticesize).getElementsByTag("a");//链接
						String title=null;
						String time=null;
						String collegeurl=null;
						String source="新浪通知";
						CollegeNotice notice=new CollegeNotice();
						if(element3.text().length()!=0) {
							if(element3.get(0).attr("href").charAt(0)=='/') {
								collegeurl=dataurl+element3.get(0).attr("href");
								System.out.println(collegeurl);
								notice.setUrl(collegeurl);
							}
						}
						if(element1.text().length()!=0) {
							title=element1.get(0).attr("title");//标题
							notice.setTitle(title);
						}
						if(element2.text().length()!=0) {
							time=element2.text();//时间
							notice.setTime(time);
						}
						notice.setSource(source);
		
						if(element1.text().length()!=0) {
							//System.out.println(notice.getContent());
							noticeList.add(notice);
						}
					}*/
				}
				//测试序列化
				noticeoperater.save(noticeList, collegnoticepath);
				ArrayList<CollegeNotice> Desnotices=noticeoperater.load(collegnoticepath);
				System.out.println("成功爬取学院通知："+Desnotices.size());
			}
}

