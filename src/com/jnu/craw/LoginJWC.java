package com.jnu.craw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 爬虫主的程序调度器(爬虫教务系统的入口)
 * 
 * @author liqiang
 *
 */
public class LoginJWC {

    public static void main(String[] args) {
        String xuehao = new String("2016052378");
        String password = new String("19961210");
        // Console con = System.console();
        // String pswd = new String(con.readPassword());// 因为读取的是字符数组,所以需要用new

        try {
            DownloadLoginfo downloadLoginfo = new DownloadLoginfo();
            LoginClass loginClass = new LoginClass();
            TrainplanOutput gradeOutput = new TrainplanOutput();
            // 1.访问主页，获取验证码与viewstate
            downloadLoginfo.getLogInfo();
            // 2.登录
            loginClass.login(downloadLoginfo, xuehao, password);
            for (Entry<String, String> entry : loginClass.getCookies().entrySet()) {
                System.out.println("key:" + entry.getKey() + ";value" + entry.getValue());
            }
            CrawTrainplanData crawGrade = new CrawTrainplanData();
            //3. 爬取成绩的上一个页面
         //   crawGrade.crawGradeLastPage(downloadLoginfo.getCookies(), downloadLoginfo.getViewState(), xuehao);
            List<String> condition = geneQueryCondition();
            //4.循环分学年爬取成绩
//            for (String xuenian : condition) {
//                String html_content = crawGrade.crawGrade(xuenian, "2", downloadLoginfo.getCookies(),
//                        // 4.1爬取成绩页面
//                        downloadLoginfo.getViewState(), xuehao);
//                gradeOutput.collectGrade(html_content);
//
//            }
            //5.输出爬到的数据到html文件中
            gradeOutput.outputDatas2Html();
        } catch (IOException e) {
            System.out.println("无法连接学校服务器");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 构造需要查询的年份和学期
     * 
     * @return
     */
    public static List<String> geneQueryCondition() {
        List<String> condition = new ArrayList<String>();
        condition.add("2014-2015");
        condition.add("2015-2016");
        condition.add("2016-2017");
        condition.add("2017-2018");
        return condition;
    }

}