package com.jnu.groupproject.noticeclass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.jnu.groupproject.view.PanelUserInfo;


//日记执行者
public class SchoolNoticeOperater {
	//private Logger log = Logger.getLogger(PanelUserInfo.class);  
	//NoticeOperater(Elements element){
	public static void main(String []args)throws Exception,FileNotFoundException,IOException {
	//public SchoolNoticeOperater() throws Exception,FileNotFoundException,IOException {
		//配置日记文件
		//PropertyConfigurator.configure("log4j.properties");
		
		String noticeurl1="https://www.jnu.edu.cn/tz";
		String noticeurl2="https://xsc.jnu.edu.cn";
		String url="https://www.jnu.edu.cn/tz/list.psp";
		String shoolnoticepath="./src/com/jnu/groupproject/data/schoolnotice.dat";
		ArrayList<Notice> noticeList=new ArrayList<Notice>();
		NoticeSerializeOperater noticeoperater=new NoticeSerializeOperater<Notice>();
		Document document = Jsoup.connect(url).get();
		
		//获取最大页数
		Elements PageCountElement=document.getElementsByClass("all_pages");
		int PageCount=Integer.valueOf(PageCountElement.text()).intValue();
		
		
		//爬取数据并序列化与反序列化
		//for(int i=1;i<=1;i++) {
		for(int i=1;i<=PageCount;i++) {
			String noticeurl=noticeurl1+"/list"+i+".psp";
			//log.info(noticeurl);
			System.out.println(noticeurl);
			Document pageDocument = Jsoup.connect(noticeurl).get();
            Elements elements=pageDocument.select("tr");
            for(int pageNoticesize=1;pageNoticesize<elements.size();pageNoticesize++) {
            	Elements element1=elements.get(pageNoticesize).getElementsByTag("a");
				Elements element2=elements.get(pageNoticesize).getElementsByClass("time");
				String title=element1.get(0).text();//标题
				String source=element1.get(1).text();//来源
				String urlnotice=null;//超链接
				String time=element2.get(0).text();//时间
				if(element1.get(0).attr("href").charAt(1)=='_') {
					urlnotice=noticeurl2+element1.get(0).attr("href");
					//System.out.println(1+urlnotice);
				}
				else if(element1.get(0).attr("href").charAt(0)=='h') {
					urlnotice=element1.get(0).attr("href");
					//System.out.println(2+urlnotice);
				}
				else {
					urlnotice=noticeurl1+element1.get(0).attr("href");
					//System.out.println(3+urlnotice);
				}
				Notice notice=new Notice();
				if(notice.getContent()!="") {
					notice.setTitle(title);
					notice.setTime(time);
					notice.setUrl(urlnotice);
					notice.setSource(source);
					noticeList.add(notice);
				}
			}	
			} 
		//测试序列化
		noticeoperater.save(noticeList, shoolnoticepath);
		ArrayList<Notice> Desnotices=noticeoperater.load(shoolnoticepath);
		System.out.println("成功爬取校内通知："+Desnotices.size());
		//log.info("成功爬取校内通知："+Desnotices.size());
		
		
		
		
		//爬取新闻
//		String noticeurl1="https://www.jnu.edu.cn/tz";
//		String noticeurl2="https://xsc.jnu.edu.cn";
//		String url="https://www.jnu.edu.cn/tz/list.psp";
//		String shoolnoticepath="./src/com/jnu/groupproject/data/schoolnotice.dat";
//		ArrayList<News> newsList=new ArrayList<News>();
//		NoticeSerializeOperater newsoperater=new NoticeSerializeOperater<News>();
//		document = Jsoup.connect(url).get();
//		
//		//获取最大页数
//		Elements PageCountElement=document.getElementsByClass("all_pages");
//		int PageCount=Integer.valueOf(PageCountElement.text()).intValue();
//		
//		
//		//爬取数据并序列化与反序列化
//		//for(int i=1;i<=1;i++) {
//		for(int i=1;i<=PageCount;i++) {
//			String noticeurl=noticeurl1+"/list"+i+".psp";
//			log.info(noticeurl);
//			//System.out.println(noticeurl);
//			Document pageDocument = Jsoup.connect(noticeurl).get();
//            Elements elements=pageDocument.select("tr");
//            for(int pageNoticesize=1;pageNoticesize<elements.size();pageNoticesize++) {
//            	Elements element1=elements.get(pageNoticesize).getElementsByTag("a");
//				Elements element2=elements.get(pageNoticesize).getElementsByClass("time");
//				String title=element1.get(0).text();//标题
//				String source=element1.get(1).text();//来源
//				String urlnotice=null;//超链接
//				String time=element2.get(0).text();//时间
//				if(element1.get(0).attr("href").charAt(1)=='_') {
//					urlnotice=noticeurl2+element1.get(0).attr("href");
//					//System.out.println(1+urlnotice);
//				}
//				else if(element1.get(0).attr("href").charAt(0)=='h') {
//					urlnotice=element1.get(0).attr("href");
//					//System.out.println(2+urlnotice);
//				}
//				else {
//					urlnotice=noticeurl1+element1.get(0).attr("href");
//					//System.out.println(3+urlnotice);
//				}
//				//SchoolNotice notice=new SchoolNotice(urlnotice);
//				SchoolNotice notice=new SchoolNotice();
//				if(notice.getContent()!="") {
//					notice.setTitle(title);
//					notice.setTime(time);
//					notice.setUrl(urlnotice);
//					notice.setSource(source);
//					noticeList.add(notice);
//				}
//			}	
//			} 
//		//测试序列化
//		noticeoperater.save(noticeList, shoolnoticepath);
//		ArrayList<SchoolNotice> Desnotices=noticeoperater.load(shoolnoticepath);
//		//System.out.println("成功爬取校内通知："+Desnotices.size());
//		log.info("成功爬取校内通知："+Desnotices.size());
		}
}
	
