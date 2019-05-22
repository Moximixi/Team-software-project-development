package com.jnu.groupproject.noticeclass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.InternationalFormatter;



import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.jnu.groupproject.view.PanelUserInfo;

//最终版(DianfeiTest+DianFeiObject)
public class DianFeiQuery {
	public static String QueryResult=null;

	public static String getQueryResult() {
		return QueryResult;
	}
	public static void setQueryResult(String queryResult) {
		QueryResult = queryResult;
	}
	public DianFeiQuery(String Account)throws Exception{
		
			//获取Cookie
			String surl = "http://202.116.25.12/login.aspx";  
			WebClient client = new WebClient(BrowserVersion.FIREFOX_52);
			client.getOptions().setJavaScriptEnabled(true);	//默认执行j s，如果不执行j s，则可能会登录失败，因为用户名密码框需要js来绘制。
			client.getOptions().setCssEnabled(false);
			client.setAjaxController(new NicelyResynchronizingAjaxController());
			client.getOptions().setThrowExceptionOnScriptError(false);
			Set<com.gargoylesoftware.htmlunit.util.Cookie> cookie=null; //注意 ，cookie类使用htmlunit里面的cookie
			HtmlPage page = client.getPage("http://202.116.25.12/login.aspx");
			HtmlInput ln = page.getHtmlElementById("txtname");		//账号
			HtmlInput pwd = page.getHtmlElementById("txtpwd");		//密码
			HtmlInput btn = page.getFirstByXPath("//*[@id=\"ctl00\"]/div[6]/div[1]/input");
			ln.setAttribute("value", Account);
			pwd.setAttribute("value", "");
			HtmlPage htmlPage = btn.click(); //点击
			
			//创建一个数据对象
			DianFeiObject dianfeiobject=new DianFeiObject(htmlPage.asXml());

			//System.out.println(htmlPage.asXml());
			cookie = client.getCookieManager().getCookies();
			StringBuffer tmpcookies = new StringBuffer();
		        for (com.gargoylesoftware.htmlunit.util.Cookie c : cookie) {
		               tmpcookies.append(c.toString() + ";");
		        }
		    String regEx3 = "LoginRMFindSystem2=.*?;";
		    String regEx4 = ".ASPXAUTH=.*?;";
		    Pattern pattern3 = Pattern.compile(regEx3);
		    Pattern pattern4 = Pattern.compile(regEx4);
		    Matcher matcher3 = pattern3.matcher(tmpcookies);
		    Matcher matcher4 = pattern4.matcher(tmpcookies);
		    // 查找字符串中是否有匹配正则表达式的字符/字符串
		    String cookiestr=null;
		    if(matcher3.find()) {
		        for(int i=0; i<=matcher3.groupCount(); i++){  
		        	cookiestr=matcher3.group(i);
		        }  
		     }
		    if(matcher4.find()) {
			    for(int i=0; i<=matcher4.groupCount(); i++){  
			        cookiestr=cookiestr+" "+matcher4.group(i).substring(0, matcher4.group(i).length()-1);
			    } 
		    }

		    //获取Cookie后爬取数据
		    //创建一个工具类
		    HttpSSLClient sslclient = new HttpSSLClient();
				//提交的地址
		    String posturl = "http://202.116.25.12/default.aspx";
			//设置数据包头
		     HashMap<String ,String> headers = new HashMap<String ,String>();
			headers.put("Accept", "*/*");
			headers.put("Cookie", cookiestr);
			headers.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
			headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 SE 2.X MetaSr 1.0");
			//组织提交数据
			HashMap< String, String> keyvalue = new HashMap<String, String>();
			keyvalue.put("__VIEWSTATE",dianfeiobject.__VIEWSTATE);
			keyvalue.put("__EVENTVALIDATION",dianfeiobject.__EVENTVALIDATION );
			keyvalue.put("__12_value", dianfeiobject.__12_value);
			keyvalue.put("RegionPanel1$Region3$ContentPanel3$tb_ammeterNumb", dianfeiobject.RegionPanel1$Region3$ContentPanel3$tb_ammeterNumb);
			keyvalue.put("__41_value", "00900200");
			keyvalue.put("__12_last_value", dianfeiobject.__12_last_value);
			keyvalue.put("__41_last_value", "00000000");
			keyvalue.put("__box_ajax_mark", "true");

			//提交数据并返回结果
			String result = sslclient.doHttpsPost(posturl, keyvalue, "utf-8", headers);	
			String regEx = "[+-]?\\d+\\.\\d\\d";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(result);
			if(matcher.find()) {
				for(int i=0; i<=matcher.groupCount(); i++){  
					 System.out.println(matcher.group(i));
					 QueryResult=matcher.group(i);
				 }  
			}else {
			 System.out.println("No found!");
			}
		} 
}
