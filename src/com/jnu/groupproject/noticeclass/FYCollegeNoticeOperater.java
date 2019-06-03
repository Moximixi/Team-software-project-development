
package com.jnu.groupproject.noticeclass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.jnu.groupproject.view.PanelUserInfo;

public class FYCollegeNoticeOperater {
	private Logger log = Logger.getLogger(PanelUserInfo.class); 
		public FYCollegeNoticeOperater() throws Exception,FileNotFoundException,IOException {
		//public static void main(String[] args)throws Exception,FileNotFoundException,IOException {
				//人文学院
				String url="https://translation.jnu.edu.cn/7832/list1.htm";
				String pageurl="https://translation.jnu.edu.cn/7832/list";
				String dataurl="https://translation.jnu.edu.cn";
				String collegnoticepath="./src/com/jnu/groupproject/data/FYcollegenotice.dat";
				ArrayList<CollegeNotice> noticeList=new ArrayList<CollegeNotice>();
				NoticeSerializeOperater noticeoperater=new NoticeSerializeOperater<CollegeNotice>();
				Document document = Jsoup.connect(url).get();
				//获取翻译学院最大页数
				Elements PageCountElement=document.getElementsByAttributeValue("class","all_pages");
				int PageCount=Integer.valueOf(PageCountElement.text()).intValue();
				//System.out.println(PageCount);
				
				//爬取数据并序列化与反序列化
				//for(int i=1;i<=2;i++) {
				for(int i=1;i<=PageCount;i++) {
					String noticeurl=null;
					noticeurl=pageurl+i+".htm";
					log.info(noticeurl);
					Document pageDocument = Jsoup.connect(noticeurl).get();
					
		            Elements elements=pageDocument.getElementsByAttributeValue("class", "xwlb");
		            Elements element=elements.get(0).getElementsByTag("li");
		            for(int pageNoticesize=0;pageNoticesize<element.size();pageNoticesize++) {
		            	Elements element1=element.get(pageNoticesize).getElementsByTag("a");//标题
						Elements element2=element.get(pageNoticesize).getElementsByTag("span");//日期
						Elements element3=element.get(pageNoticesize).getElementsByTag("a");//链接
						String title=null;
						String time=null;
						String collegeurl=null;
						String source="学院通知";
						CollegeNotice notice=new CollegeNotice();
						if(element3.text().length()!=0) {
							if(element3.get(0).attr("href").charAt(0)=='/') {
								collegeurl=dataurl+element3.get(0).attr("href");
								//System.out.println(collegeurl);
								notice.setUrl(collegeurl);
							}
						}
						if(element1.text().length()!=0) {
							title=element1.get(0).text();//标题
							//System.out.println(title);
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
				noticeoperater.save(noticeList, collegnoticepath);
				ArrayList<CollegeNotice> Desnotices=noticeoperater.load(collegnoticepath);
				log.info("成功爬取翻译学院通知："+Desnotices.size());
			}
}
