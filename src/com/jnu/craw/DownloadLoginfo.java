package com.jnu.craw;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * url获取图片并且保存到本地
 * 
 * @author liqiang
 *
 */
public class DownloadLoginfo {
    /**
     * 第一次访问获取的cookie(查看发现就返回一个cookie:ASP.NET_SessionId)
     */
    private  Map<String, String> cookies = null;
    /**
     * __viewstate    教务系统用于验证的信息
     */
    private  String viewState = null;
    private String validate=null;
    
    public DownloadLoginfo() {
        this.cookies = new HashMap<String,String>();;
        this.viewState = "";
    }

    /**
     * 获取登录信息
     * 主要就是访问一下主页面，获取一个__viewstate与cookie
     * @throws Exception 
     */

	public void getLogInfo() throws Exception {
		// TODO 自动生成的方法存根
		String urlLogin = "https://jwxt.jnu.edu.cn/";
        Connection connect = Jsoup.connect(urlLogin);
        // 伪造请求头
        connect.header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Encoding",
                "gzip, deflate");
        connect.header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive");
        connect.header("Content-Length", "213").header("Content-Type",
                "application/x-www-form-urlencoded; charset=UTF-8");
        connect.header("Host", "jwxt.jnu.edu.cn").header("Referer", "https://jwxt.jnu.edu.cn/");
        connect.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3724.8 Safari/537.36")
                .header("X-Requested-With", "XMLHttpRequest");

        // 请求url获取响应信息
        Response res = connect.ignoreContentType(true).method(Method.POST).execute();// 执行请求
        // 获取返回的cookie
        this.cookies = res.cookies();
        for (Entry<String, String> entry : cookies.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        // 获取响应体
        String body = res.body();

        // 调用下面方法获取__viewstate
        this.getViewState(body);// 获取viewState
        this.getViewValidation(body);
        //调用下载验证码的工具类下载验证码
        JsoupDoloadPicture.downloadImg("https://jwxt.jnu.edu.cn/ValidateCode.aspx", cookies);;
	}

    /**
     * 获取viewstate
     * 
     * @return
     */
    public  String getViewState(String htmlContent) {
        Document document = Jsoup.parse(htmlContent);
        Element ele = document.select("input[name='__VIEWSTATE']").first();
        String value = ele.attr("value");
        // 获取到viewState
        this.viewState = value;
        return value;
    }
    public  String getViewValidation(String htmlContent) {
        Document document = Jsoup.parse(htmlContent);
        Element ele = document.select("input[name='__EVENTVALIDATION']").first();
        String value = ele.attr("value");
        // 获取到viewState
        this.validate = value;
        return value;
    }
    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public String getViewState() {
        return viewState;
    }

    public void setViewState(String viewState) {
        this.viewState = viewState;
    }

    public String getViewValidation() {
        return validate;
    }

    public void setViewValidation(String validate) {
        this.validate = validate;
    }

    
}