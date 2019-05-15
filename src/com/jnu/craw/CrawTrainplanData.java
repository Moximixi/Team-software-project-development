package com.jnu.craw;
import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 爬取成绩的类
 * 
 * @author liqiang
 *
 */
public class CrawTrainplanData {
    
    private String viewState;
    private String validate;
    
    /**
     * 全局获取viewstate的函数
     * @param html
     * @return
     */
    public  String getViewState(String html){
        Document document = Jsoup.parse(html);
        Element ele = document.select("input[name='__VIEWSTATE']").first();
        String value = ele.attr("value");
        this.viewState = value;
        // 获取到viewState
        return value;
    }

    /**
     * 爬取获取成绩的上一个页面(也就是刚登陆之后的页面)
     * @param cookies
     * @param viewStata
     * @param xuehao
     * @return
     * @throws IOException
     */
    public String crawGradeLastPage(Map<String,String> cookies,String viewStata	) throws IOException{
        String urlLogin = "http://jwxt.jnu.edu.cn/default.aspx";
        Connection connect = Jsoup.connect(urlLogin);
        connect.timeout(5 * 100000);
        // 伪造请求头
        connect.header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
        .header("accept-encoding", "gzip,deflate,br");
        connect.header("upgrade-insecure-requests", "1").header("Referer",
                "https://jwxt.jnu.edu.cn/areaMain.aspx").header("Accept-Language", "zh-CN,zh;q=0.9");
        connect.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3724.8 Safari/537.36");

        // 携带登陆信息
      
        //设置cookie
        connect.cookies(cookies);
        
        Document document = connect.post();
        System.out.println("-----------爬到的成绩的上一个页面--------------");
        String html = document.toString();
        System.out.println(html);
        // 重新获取到viewState
        this.getViewState(html);
        return html;

        
    }
    
    /**
     * 爬取成绩页面
     */
    public String crawGrade(Map<String,String> cookies) throws IOException{
        String urlLogin = "http://jwxt.jnu.edu.cn/Secure/PaiKeXuanKe/wfrm_Xk_PyfaCx.aspx";
        Connection connect = Jsoup.connect(urlLogin);
        connect.timeout(5 * 100000);
        // 伪造请求头
        connect.header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
        .header("Accept-Encoding", "gzip, deflate,br");
        connect.header("Accept-Language", "zh-CN,zh;q=0.9").header("cache-control", "max-age=0");
        connect.header("Content-Type", "application/x-www-form-urlencoded").header("content-length","7678");
        connect.header("origin", "jwxt.jnu.edu.cn").header("Referer", "http://jwxt.jnu.edu.cn/Secure/PaiKeXuanKe/wfrm_Xk_PyfaCv.aspx")
        .header("upgrade-insecure-requests", "1");
        connect.header("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3724.8 Safari/537.36");
        
        // 携带登陆信息
        connect
        .data("__EVENTTARGET","")
        .data("__EVENTARGUMENT", "")
        .data("__VIEWSTATE", this.viewState);
        
        connect.cookies(cookies);
        
        Document document = connect.post();
        System.out.println("-----------爬到的成绩的页面--------------");
        String html = document.toString();
        //更新viewstate
        this.getViewState(html);
        System.out.println(html);
        return html;
    }

    public void setViewState(String viewState) {
        this.viewState = viewState;
    }
    
    
    
}