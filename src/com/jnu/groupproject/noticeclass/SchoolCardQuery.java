package com.jnu.groupproject.noticeclass;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
import com.jnu.groupproject.view.PanelUserInfo;

public class SchoolCardQuery {
	public String QueryResult=null;
	public String SchoolCardYZM=null;  
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
			String imgpath="./src/com/jnu/groupproject/data/SchoolCardYzm.jpg";
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
			new MyDailog("验证码信息", "请输入验证码").setVisible(true);
			/*System.out.println("请输入验证码:");
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			String str = stdin.readLine();*/
			ln.setAttribute("value", Account);
			pwd.setAttribute("value", Password);
			yzm.setAttribute("value", SchoolCardYZM);
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
				    }  
			}else {
				 System.out.println("No found!");
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}
	
	
	class MyDailog extends JDialog implements ActionListener {
	    String title;
	    String content;
	    JTextField text=new JTextField("请输入验证码");
	    public MyDailog(String title, String content) throws Exception {
	        this.title = title;
	        this.content = content;
	        
	        File file = new File("./src/com/jnu/groupproject/data/SchoolCardYZM.jpg");
            byte[] fileByte = Files.readAllBytes(file.toPath());
	        ImageIcon icon = new ImageIcon(fileByte);
	        JLabel jlImg = new JLabel(icon);
	        JButton btn_OK = new JButton("确定");
	        //JButton btn_refres = new JButton("换一张");
	        
	        btn_OK.addActionListener(this);
	        add(text);
	        add(jlImg);	// 向对话框加入图片标签
	        add(btn_OK);	// 向对话框添加按钮
	        setLayout(new FlowLayout());// 对话框流式布局
	        setTitle(title);	// 设置标题
	        setModal(true);		// 设置为模态窗口
	        setSize(300, 200);	// 设置对话框大小
	        setLocationRelativeTo(null);	// 对话框局域屏幕中央
	        setResizable(false);			// 对话框不可缩放
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);// 当对话框窗口的关闭按钮[X]被点击时,销毁对话框
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	if (e.getActionCommand().equals("确定")) {// 判断是不是确定按钮被点击
	    		SchoolCardYZM=text.getText();
	    		this.setVisible(false);// 对话框不可见
	    		this.dispose();// 对话框销毁
	    	}
	    }
	    	        
	}
}
