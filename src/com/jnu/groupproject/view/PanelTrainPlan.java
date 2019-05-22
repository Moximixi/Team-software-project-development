package com.jnu.groupproject.view;

import java.awt.Color;



import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.jnu.groupproject.data.*;

public class PanelTrainPlan extends JPanel {
	/**
	 * Create the panel.
	 */
	JTable table_trainplan;
	private String YZM;
	JPanel PanelTrainPlan=new JPanel();
	JButton button_view = new JButton("查看");
	boolean loginflag=false;//是否已经登录的标志
	public PanelTrainPlan() throws Exception {
		
		add(PanelTrainPlan);
		PanelTrainPlan.add(button_view);
		PanelTrainPlan.setForeground(Color.LIGHT_GRAY);
		PanelTrainPlan.setBounds(0, 0, 880, 470);
		button_view.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				FileHelper fh=new FileHelper("./userinfo.txt");
				Person person=fh.getObjFromFile();
				String xuehao=(String) person.webInfo.get(1);
				String password=(String) person.webInfo.get(2);
	            if(!loginflag) {
	            try {  
	                // 2.登录
	            	DownloadLoginfo downloadLoginfo = new DownloadLoginfo();
	            	LoginClass loginClass = new LoginClass();
	          	    downloadLoginfo.getLogInfo();
	          	    new MyDailog("验证码信息", "请输入验证码").setVisible(true);
	                loginClass.login(downloadLoginfo, xuehao, password);
	                for (Entry<String, String> entry : loginClass.getCookies().entrySet()) {
	                    System.out.println("key:" + entry.getKey() + ";value" + entry.getValue());
	                }
	                loginflag=true;
	               CrawTrainplanData crawGrade = new CrawTrainplanData();
	               String html_content=crawGrade.crawtrainplanpage(downloadLoginfo.getCookies(), downloadLoginfo.getViewState());
	               TrainplanOutput gradeOutput=new TrainplanOutput();
	                gradeOutput.gettrainplandata(html_content);
	                gradeOutput.outputDatas2Html();
	                PanelTrainPlan.add(table_trainplan);
	            } catch (IOException e1) {
	                System.out.println("无法连接学校服务器");
	            } catch (Exception e1) {
	                e1.printStackTrace();
	            	}
				setVisible(false);
	            }
	            if(loginflag) {
	            	JTable table=table_trainplan;
	            	PanelTrainPlan.add(table_trainplan);
	            }
	            PanelTrainPlan.removeAll();
	            PanelTrainPlan.add(table_trainplan);
				}
		});
		
	}
	
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
	
	public static class JsoupDoloadPicture {

	    /**
	     * 带着cookie下载验证码图片
	     * 
	     * @param url
	     * @param cookies
	     * @throws IOException
	     */
	    public static void downloadImg(String url, Map<String, String> cookies) throws IOException {
	        // TODO Auto-generated method stub
	        Connection connect = Jsoup.connect(url);
	        connect.cookies(cookies);// 携带cookies爬取图片
	        connect.timeout(5 * 10000);
	        Connection.Response response = connect.ignoreContentType(true).execute();
	        byte[] img = response.bodyAsBytes();
	        System.out.println(img.length);
	        // 读取文件存储位置
	        String directory =".\\src\\com\\jnu\\groupproject\\data\\yzm";
	        savaImage(img, directory, "YZM.png");
	    }

	    /**
	     * 保存图片到本地
	     * @param img
	     * @param filePath
	     * @param fileName
	     */
	    public static void savaImage(byte[] img, String filePath, String fileName) {
	        BufferedOutputStream bos = null;
	        FileOutputStream fos = null;
	        File file = null;
	        File dir = new File(filePath);
	        try {
	            //判断文件目录是否存在
	            if(dir.exists() && !dir.isDirectory()){
	                FileUtils.deleteQuietly(dir);
	            }
	            dir.mkdir();
	            file = new File(filePath + "\\" + fileName);
	            fos = new FileOutputStream(file);
	            bos = new BufferedOutputStream(fos);
	            bos.write(img);
	            System.out.println("验证码已经下载到:"+filePath);
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            if (bos != null) {
	                try {
	                    bos.close();
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	            if (fos != null) {
	                try {
	                    fos.close();
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	        }

	    }
	}
	
	@SuppressWarnings("all")
	class TrainplanOutput {
	    /**
	     * 保存成绩的集合
	     */
		public DefaultTableModel model=new DefaultTableModel(	
				new Object[][] {
			{"学习模块", "要求", "已修", "还差"},
			{"总学分", null, null, null},
			{"必修", null, null, null},
			{"艺术素养", null, null, null},
			{"文史哲类", null, null, null},
			{"经管法类", null, null, null},
			{"数理工类", null, null, null},
			{"生命类", null, null, null},
			{"其他类", null, null, null},
			{"通识小计", null, null, null},
			{"基础教育", null, null, null},
			{"专业教育", null, null, null},
			{"跨专业课程", null, null, null},
			{"选修合计", null, null, null},
		},
		new String[] {
			"New column", "New column", "New column", "New column"
		});
		
	    private List<Map<String, Object>> datas;

	    public TrainplanOutput() {
	        this.datas = new ArrayList<Map<String, Object>>();
	    }

	    /**
	     * 收集成绩
	     * 
	     * @param html
	     * @return
	     */
	    public void gettrainplandata(String html) {
	    	
	        // 解析html
	        Document document = Jsoup.parse(html);
	        // 获取成绩表格
	        Element table = document.select("table[class=form_table]").first();
	        // 选择除表格表头之外的元素
	        Elements trs = table.select("tr:gt(0)");
	        for (Element ele : trs) {
	            Map result = new LinkedHashMap();
	            Elements ele0 = ele.select("td[class=needs]");// 找到学年
	            result.put("要求学分", ele0.text());
	            Elements ele1 = ele.select("td[class=study]");// 找到学期
	            result.put("已修学分", ele1.text());
	            Elements ele2 = ele.select("td[class=lefts]");// 找到课程名称
	            result.put("还差", ele2.text());
	            this.datas.add(result);
	        }
	        
	       
	    }
	   
	    
	    /**
	     * 最后处理所有的数据，写出到html或者保存数据库
	     * 
	     * @throws IOException
	     */
	    public void outputDatas2Html() throws IOException {
	        if (datas != null && datas.size() > 0) {
	            int i=1;
	            for (Map<String, Object> data : datas) {
	            
	                String request = (String) data.get("要求学分");
	                String study = (String) data.get("已修学分");
	                String need = (String) data.get("还差");
	                model.setValueAt(request, i,1);
	                model.setValueAt(study, i,2);
		            model.setValueAt(need, i,3);
		            i++;
	            }
	      
		        table_trainplan = new JTable(model);
		        table_trainplan.getColumnModel().getColumn(0).setPreferredWidth(250);
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
				tcr.setHorizontalAlignment(SwingConstants.CENTER);
				table_trainplan.setDefaultRenderer(Object.class, tcr);
				table_trainplan.setBorder(new LineBorder(new Color(0, 0, 0)));
				table_trainplan.setRowHeight(30);//指定每一行的行高40
	        }
	    }

	    public List<Map<String, Object>> getDatas() {
	        return datas;
	    }

	    public void setDatas(List<Map<String, Object>> datas) {
	        this.datas = datas;
	    }

	}
	
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
	    public String crawtrainplanpage(Map<String,String> cookies,String viewStata	) throws IOException{
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
	        String html = document.toString();
	        // 重新获取到viewState
	        this.getViewState(html);
	        return html;

	        
	    }
	    
		
	    public void setViewState(String viewState) {
	        this.viewState = viewState;
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
	    }

	    public Map<String, String> getCookies() {
	        return cookies;
	    }

	    public void setCookies(Map<String, String> cookies) {
	        this.cookies = cookies;
	    }

	}
	class MyDailog extends JDialog implements ActionListener {
	    String title;
	    String content;
	    JTextField text=new JTextField("请输入验证码");
	    public MyDailog(String title, String content) throws Exception {
	        this.title = title;
	        this.content = content;
//            GradeOutput gradeOutput = new GradeOutput();
            // 1.访问主页，获取验证码与viewstate
	        File file=new File(".\\src\\com\\jnu\\groupproject\\data\\yzm\\YZM.png");
	        byte[] fileByte=Files.readAllBytes(file.toPath());
	        ImageIcon icon = new ImageIcon(fileByte);// 创建1个图标实例
	        JLabel jlImg = new JLabel(icon);// 1个图片标签,显示图片
	        JButton jb = new JButton("确定");// 创建1个按钮
	        jb.addActionListener(this);
	        add(text);
	        add(jlImg);// 向对话框加入图片标签
	        add(jb);// 向对话框添加按钮
	        setLayout(new FlowLayout());// 对话框流式布局
	        setTitle(title);// 设置标题
	        setModal(true);// 设置为模态窗口
	        setSize(250, 150);// 设置对话框大小
	        setLocationRelativeTo(null);// 对话框局域屏幕中央
	        setResizable(false);// 对话框不可缩放
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);// 当对话框窗口的关闭按钮[X]被点击时,销毁对话框
	    }
	    
	    // 当确定按钮被点击时会执行下面的方法
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getActionCommand().equals("确定")) {// 判断是不是确定按钮被点击
	        	 YZM=text.getText();
	        	  this.setVisible(false);// 对话框不可见
	              this.dispose();// 对话框销毁
	              
	        	}
       	// 对话框销毁
	        }
	    	        
	}


}