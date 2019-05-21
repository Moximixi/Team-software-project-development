package com.jnu.groupproject.noticeclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class SchoolCardQuery {
	public  String QueryResult=null;
	public String getQureyResult() {
		return QueryResult;
	}
	public void setQureyResult(String queryResult) {
		QueryResult = queryResult;
	}
	public SchoolCardQuery(String Account,String Password){
		try {
			String surl = "https://card.jnu.edu.cn/pages/common/homeLogin.action";
			String imgsurl = "https://card.jnu.edu.cn/pages/common/getCheckpic.action?rand=6384.806794740727";
			String imgpath="./SchoolCardYzm.jpg";
			WebClient client = new WebClient(BrowserVersion.FIREFOX_52);
			client.getOptions().setJavaScriptEnabled(true);	//默认执行j s，如果不执行j s，则可能会登录失败，因为用户名密码框需要js来绘制。
			client.getOptions().setCssEnabled(false);
			client.setAjaxController(new NicelyResynchronizingAjaxController());
			client.getOptions().setThrowExceptionOnScriptError(false);
			Set<com.gargoylesoftware.htmlunit.util.Cookie> cookie=null; //注意 ，cookie类使用htmlunit里面的cookie
			HtmlPage page = client.getPage(surl);
			DownloadPicFromURL SchoolCardYzm=new DownloadPicFromURL(imgsurl,imgpath);
			HtmlInput ln = page.getElementByName("name");		//账号
			HtmlInput pwd = page.getElementByName("passwd");		//密码
			HtmlInput yzm = page.getElementByName("rand");		//验证码
			HtmlInput btn = page.getElementByName("imageField");
			System.out.println("请输入验证码:");
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			String str = stdin.readLine();
			ln.setAttribute("value", Account);
			pwd.setAttribute("value", Password);
			yzm.setAttribute("value", str);
			HtmlPage htmlPage = btn.click(); //点击
			//System.out.println(htmlPage.asXml());
			cookie = client.getCookieManager().getCookies();
			StringBuffer tmpcookies = new StringBuffer();
	            for (com.gargoylesoftware.htmlunit.util.Cookie c : cookie) {
	                tmpcookies.append(c.toString() + ";");
	            }
	        //System.out.println(tmpcookies);
	        String regEx3 = "JSESSIONID=.*?;";
	        // 编译正则表达式
	        Pattern pattern3 = Pattern.compile(regEx3);
	        // 忽略大小写的写法
	        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	        Matcher matcher3 = pattern3.matcher(tmpcookies);
	        // 查找字符串中是否有匹配正则表达式的字符/字符串
	        String cookiestr=null;
	        if(matcher3.find()) {
	        	for(int i=0; i<=matcher3.groupCount(); i++){  
	        		cookiestr=matcher3.group(i).substring(0, matcher3.group(i).length()-1);
	        	 }  
	        }
	        //System.out.println(cookiestr);
		
	        //创建一个工具类
			HttpSSLClient sslclient = new HttpSSLClient();
			//提交的地址
			String geturl = "https://card.jnu.edu.cn/accountcardUser.action";
			//设置数据包头
			HashMap<String ,String> headers = new HashMap<String ,String>();
			headers.put(":authority", "card.jnu.edu.cn");
			headers.put(":method", "GET");
			headers.put(":path","/accountcardUser.action");
			headers.put(":scheme","https");
			headers.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			headers.put("cookie", cookiestr);
			headers.put("referer", "https://card.jnu.edu.cn/pages/common/accleftframe.action");
			headers.put("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 SE 2.X MetaSr 1.0");
			//headers.put("Cookie", "JSESSIONID=495B587DD5066B62DC19E04F65675B2F");

			//提交数据并返回结果
			String result = sslclient.doHttpsGet(geturl, "utf-8", headers);	
			//System.out.println(result);
			
			String regEx = "[+-]?\\d+\\.\\d\\d元";
			// 编译正则表达式
			Pattern pattern = Pattern.compile(regEx);
			// 忽略大小写的写法
			// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(result);
			if(matcher.find()) {
				 for(int i=0; i<=matcher.groupCount(); i++){  
					 //System.out.println(matcher.group(i));
					 QueryResult=matcher.group(i);
					 //setQureyResult(matcher.group(i));
				    }  
			}else {
				 System.out.println("No found!");
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}
}
