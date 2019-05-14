package com.jnu.groupproject.view;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

import com.jnu.craw.DownloadLoginfo;
import com.jnu.craw.LoginClass;

public class buttonActionListener implements MouseListener {
	static final String title = "验证码信息";
    static final String content = "请输入验证码"; 
    String YZM;
	@Override
	public void mouseClicked(MouseEvent arg0) {
        	String xuehao = new String("2016052378");
            String password = new String("19961210");
            // Console con = System.console();
            // String pswd = new String(con.readPassword());// 因为读取的是字符数组,所以需要用new

            try {    
                // 2.登录
            	DownloadLoginfo downloadLoginfo = new DownloadLoginfo();
            	LoginClass loginClass = new LoginClass();
          	    downloadLoginfo.getLogInfo();
          	    new MyDailog(title, content).setVisible(true);
          	  System.out.println("-----------请输入验证码---------");
              Scanner sc = new Scanner(System.in);
              YZM = sc.next();
              sc.close();
              sc.close();
                loginClass.login(downloadLoginfo, xuehao, password);
                for (Entry<String, String> entry : loginClass.getCookies().entrySet()) {
                    System.out.println("key:" + entry.getKey() + ";value" + entry.getValue());
                }
//                CrawGrade crawGrade = new CrawGrade();
                //3. 爬取成绩的上一个页面
//                crawGrade.crawGradeLastPage(downloadLoginfo.getCookies(), downloadLoginfo.getViewState(), xuehao);
//                List<String> condition = geneQueryCondition();
                //4.循环分学年爬取成绩
//                for (String xuenian : condition) {
//                    String html_content = crawGrade.crawGrade(xuenian, "2", downloadLoginfo.getCookies(),
//                            // 4.1爬取成绩页面
//                            downloadLoginfo.getViewState(), xuehao);
//                    gradeOutput.collectGrade(html_content);
//
//                }
                //5.输出爬到的数据到html文件中
//                gradeOutput.outputDatas2Html();
            } catch (IOException e1) {
                System.out.println("无法连接学校服务器");
            } catch (Exception e1) {
                e1.printStackTrace();
            	}
   }
		
	public class LoginClass {
	    /**
	     * 记录返回的cookie
	     */
	    private Map<String, String> cookies = null;

	    /**
	     * 模拟登录获取cookie和sessionid
	     * 
	     */
	    public void login(DownloadLoginfo downloadLoginfo, String xuehao, String mima) throws Exception {
	        String urlLogin = "https://jwxt.jnu.edu.cn/Login.aspx";
	        Connection connect = Jsoup.connect(urlLogin);
	        connect.timeout(5 * 100000);
	        // 伪造请求头
	        connect.header("Content-Length", "365").header("Content-Type", "application/x-www-form-urlencoded");
	        connect.header("Origin", "jwxt.jnu.edu.cn").header("Referer",
	                "https://jwxt.jnu.edu.cn/");
	        connect.header("User-Agent",
	                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

	        // 携带登陆信息
	        connect.data("txtYHBS", xuehao).data("txtYHMM",mima).data("__VIEWSTATE", downloadLoginfo.getViewState())
	        .data("__EVENTVALIDATION", downloadLoginfo.getViewValidation()).data("txtFJM",YZM).data("btnLogin","");
	        connect.cookies(downloadLoginfo.getCookies());
	        // 请求url获取响应信息
	        Response res = connect.ignoreContentType(true).method(Method.POST).execute();// 执行请求
	        // 获取返回的cookie
	        this.cookies = res.cookies();
	        for (Entry<String, String> entry : cookies.entrySet()) {
	            System.out.println(entry.getKey() + "-" + entry.getValue());
	        }
	        System.out.println("---------获取的登录之后的页面-----------");
	        String body = res.body();// 获取响应体
	        System.out.println(body);
	    }

	    public Map<String, String> getCookies() {
	        return cookies;
	    }

	    public void setCookies(Map<String, String> cookies) {
	        this.cookies = cookies;
	    }

	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}
	 private Map<String, String> cookies = null;

     /**
      * 模拟登录获取cookie和sessionid
      * 
      */

	class MyDailog extends JDialog implements ActionListener {
	    String title;
	    String content;
	    public MyDailog(String title, String content) throws Exception {
	        this.title = title;
	        this.content = content;
//            GradeOutput gradeOutput = new GradeOutput();
            // 1.访问主页，获取验证码与viewstate
	        ImageIcon icon = new ImageIcon("E:\\download\\Team-software-project-development-feature (1)\\Team-software-project-development-feature\\src\\com\\jnu\\craw\\verificationcode\\yzm.png");// 创建1个图标实例
	        JLabel jlImg = new JLabel(icon);// 1个图片标签,显示图片
	        JButton jb = new JButton("确定");// 创建1个按钮
	        JTextField text=new JTextField("");
	        YZM=text.getText();
	        jb.addActionListener(this);
	        add(text);
	        add(jlImg);// 向对话框加入图片标签
	        add(jb);// 向对话框添加按钮
	        setLayout(new FlowLayout());// 对话框流式布局
	        setTitle(title);// 设置标题
	        setModal(true);// 设置为模态窗口
	        setSize(300, 200);// 设置对话框大小
	        setLocationRelativeTo(null);// 对话框局域屏幕中央
	        setResizable(false);// 对话框不可缩放
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);// 当对话框窗口的关闭按钮[X]被点击时,销毁对话框
	    }
	    
	    // 当确定按钮被点击时会执行下面的方法
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getActionCommand().equals("确定")) {// 判断是不是确定按钮被点击
	        	  this.setVisible(false);// 对话框不可见
	              this.dispose();// 对话框销毁
	        	}
       	// 对话框销毁
	        }
	    	        
	}

}
