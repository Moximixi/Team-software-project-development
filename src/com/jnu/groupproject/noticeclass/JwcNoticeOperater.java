package com.jnu.groupproject.noticeclass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.jnu.groupproject.view.PanelUserInfo;


public class JwcNoticeOperater {
	private Logger log = Logger.getLogger(PanelUserInfo.class); 
	//NoticeOperater(Elements element){
	public JwcNoticeOperater() throws Exception,FileNotFoundException,IOException {
		//配置日记文件
		PropertyConfigurator.configure("log4j.properties");
		
		String url="https://zhjw.jnu.edu.cn/7099/list.htm";
		String pageurl="https://zhjw.jnu.edu.cn/7099/list";
		String dataurl="https://zhjw.jnu.edu.cn";
		String Jwcnoticepath="./src/com/jnu/groupproject/data/Jwcnotice.dat";
		ArrayList<JwcNotice> noticeList=new ArrayList<JwcNotice>();
		NoticeSerializeOperater noticeoperater=new NoticeSerializeOperater<JwcNotice>();
		Document document = Jsoup.connect(url).get();
				
		//获取最大页数
		Elements PageCountElement=document.getElementsByClass("all_pages");
		int PageCount=Integer.valueOf(PageCountElement.text()).intValue();
		//System.out.println(PageCount);
		//第9页   转发关于组织学习新闻学、广告学专业认证经验的通知
		//爬取数据并序列化与反序列化
		//for(int i=1;i<=1;i++) {
		for(int i=1;i<=PageCount;i++) {
			String noticeurl=pageurl+i+".htm";
			//System.out.println(noticeurl);
			log.info(noticeurl);
			Document pageDocument = Jsoup.connect(noticeurl).get();
		    Elements elements=pageDocument.select("li");
		    for(int pageNoticesize=0;pageNoticesize<elements.size();pageNoticesize++) {
		        Elements element1=elements.get(pageNoticesize).getElementsByClass("inf list-inf");//标题
				Elements element2=elements.get(pageNoticesize).getElementsByClass("s_time");//日期
				Elements element3=elements.get(pageNoticesize).getElementsByClass("inf list-inf");//链接
				String title=null;
				String time=null;
				String Jwcurl=null;
				String source="教务处通知";
				JwcNotice notice=new JwcNotice();
				if(element3.text().length()!=0) {
					if(element3.get(0).attr("href").charAt(0)=='/')
						Jwcurl=dataurl+element3.get(0).attr("href");
					else
						Jwcurl=element3.get(0).attr("href");
					//System.out.println(Jwcurl);
					if(Jwcurl.equals("https://zhjw.jnu.edu.cn/80/ed/c7162a164077/page.htm"))
						continue;
					//notice=new JwcNotice(Jwcurl);
					notice.setUrl(Jwcurl);
				}
				if(element1.text().length()!=0) {
					title=element1.text();//标题
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
				}
		}
				//测试序列化
		noticeoperater.save(noticeList, Jwcnoticepath);
		ArrayList<JwcNotice> Desnotices=noticeoperater.load(Jwcnoticepath);
		//System.out.println("成功爬取教务处通知："+Desnotices.size());
		log.info("成功爬取教务处通知："+Desnotices.size());
	}
}
