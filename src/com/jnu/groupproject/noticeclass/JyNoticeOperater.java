package com.jnu.groupproject.noticeclass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.jnu.groupproject.view.PanelUserInfo;

public class JyNoticeOperater {
	private Logger log = Logger.getLogger(PanelUserInfo.class); 
	//JyNoticeOperater(Elements element){
	public JyNoticeOperater() throws Exception,FileNotFoundException,IOException {
				String url="http://zhxgb.jnu.edu.cn/employment/info/";
				String pageurl="http://zhxgb.jnu.edu.cn/employment/info/index_";
				String dataurl="http://zhxgb.jnu.edu.cn";
				String Jynoticepath="./src/com/jnu/groupproject/data/Jynotice.dat";
				ArrayList<JyNotice> noticeList=new ArrayList<JyNotice>();
				NoticeSerializeOperater noticeoperater=new NoticeSerializeOperater<JyNotice>();
				Document document = Jsoup.connect(url).get();
				//System.out.println(document.text());
				//获取最大页数
				Elements PageCountElement=document.getElementsByAttributeValue("class", "list_g_1");
				//int PageCount=1;
				int PageCount=Integer.valueOf(PageCountElement.text().substring(5, 7)).intValue();
				//System.out.println(PageCount);
				//爬取数据并序列化与反序列化
				for(int i=1;i<=PageCount;i++){
					String noticeurl=null;
					if(i==1)
						noticeurl=url;
					else 
						noticeurl=pageurl+i+".html";
					//System.out.println(noticeurl);
					log.info(noticeurl);
					Document pageDocument = Jsoup.connect(noticeurl).get();
		            Elements elementslist=pageDocument.select("div");
		            Elements elements=elementslist.get(10).getElementsByTag("li");
		            for(int pageNoticesize=28;pageNoticesize<elements.size()-8;pageNoticesize++) {
		            	Elements element1=elements.get(pageNoticesize).getElementsByTag("a");//标题
						Elements element2=elements.get(pageNoticesize).getElementsByClass("list_date_1");//日期
						Elements element3=elements.get(pageNoticesize).getElementsByTag("a");//链接
						String title=null;
						String time=null;
						String collegeurl=null;
						String source="就业通知";
						JyNotice notice=new JyNotice();
						if(element3.text().length()!=0) {
							collegeurl=dataurl+element3.get(0).attr("href");
							notice=new JyNotice(collegeurl);
							notice.setUrl(collegeurl);
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
							noticeList.add(notice);
						}
					}
				}
				//测试序列化
				noticeoperater.save(noticeList, Jynoticepath);
				ArrayList<JwcNotice> Desnotices=noticeoperater.load(Jynoticepath);
				//System.out.println("成功爬取就业通知："+Desnotices.size());
				log.info("成功爬取就业通知："+Desnotices.size());
			
			}
	}

