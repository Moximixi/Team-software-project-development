package com.jnu.groupproject.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.jnu.groupproject.view.buttonActionListener.MyDailog;

public class PanelCourseSelect extends JPanel {
	private Logger log = Logger.getLogger(PanelUserInfo.class); 
	
	//创建选项卡面板对象
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	//创建面板
	JPanel panel_queryCourse=new JPanel();
	JPanel panel_listCourse=new JPanel();
	JPanel panel_selectedCourse=new JPanel();
	String YZM;
	
	public PanelCourseSelect() {
		
		super();
		setLayout(new CardLayout(0, 0));
		add(tabbedPane, "name_422260517140338");
		
		initPanelQueryCourse();		//初始化（添加控件）	
		initPanelListCourse();
		initPanelSelectedCourse();
			
		//将面板加入到选项卡面板对象上
		tabbedPane.addTab("查询选课",null,panel_queryCourse,"First panel");
		tabbedPane.addTab("开课列表",null,panel_listCourse,"Second panel");
		tabbedPane.addTab("已选课程",null,panel_selectedCourse,"Third panel");
		super.setSize(800, 470);
		
	}
	
	private void initPanelQueryCourse() {
		panel_queryCourse.setLayout(null);	//绝对布局
		
		JLabel label_courseName = new JLabel("课程名称：");
		label_courseName.setFont(new Font("宋体", Font.BOLD, 20));
		label_courseName.setBounds(116, 76, 116, 34);
		panel_queryCourse.add(label_courseName);
		
		JLabel label_course = new JLabel("所属学院：");
		label_course.setFont(new Font("宋体", Font.BOLD, 20));
		label_course.setBounds(116, 146, 116, 34);
		panel_queryCourse.add(label_course);
		
		JLabel label_courseNum = new JLabel("课程编号：");
		label_courseNum.setFont(new Font("宋体", Font.BOLD, 20));
		label_courseNum.setBounds(475, 76, 116, 34);
		panel_queryCourse.add(label_courseNum);
		
		JLabel label_courseMajor = new JLabel("所属专业：");
		label_courseMajor.setFont(new Font("宋体", Font.BOLD, 20));
		label_courseMajor.setBounds(475, 142, 116, 34);
		panel_queryCourse.add(label_courseMajor);
		
		JTextField textField_courseName = new JTextField();	//课程名称输入框
		textField_courseName.setBounds(220, 79, 112, 33);
		panel_queryCourse.add(textField_courseName);
		textField_courseName.setColumns(10);
		
		JTextField textField_courseNum = new JTextField();	//课程编号输入框
		textField_courseNum.setColumns(10);
		textField_courseNum.setBounds(580, 80, 112, 33);
		panel_queryCourse.add(textField_courseNum);
		
		JTextField textField_courseMajor = new JTextField();	//所属学院输入框
		textField_courseMajor.setColumns(10);
		textField_courseMajor.setBounds(580, 142, 112, 33);
		panel_queryCourse.add(textField_courseMajor);
		
		JTextField textField_courseCollege = new JTextField();	//所属专业输入框
		textField_courseCollege.setColumns(10);
		textField_courseCollege.setBounds(222, 147, 112, 33);
		panel_queryCourse.add(textField_courseCollege);
		
		JButton button_cancel = new JButton("清除条件");
		button_cancel.setFont(new Font("宋体", Font.BOLD, 20));
		button_cancel.setBounds(151, 278, 181, 48);
		panel_queryCourse.add(button_cancel);
		
		JButton button_query = new JButton("查询");
		button_query.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("resource")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				WebClient webClient = new WebClient(BrowserVersion.CHROME);
				webClient.getOptions().setThrowExceptionOnScriptError(false);
				//设置证书
				webClient.getOptions().setUseInsecureSSL(true);
				//是否启用js
				webClient.getOptions().setJavaScriptEnabled(true);
				//是否启用css
				webClient.getOptions().setCssEnabled(true);
				//设置Ajax控制器
				webClient.setAjaxController(new NicelyResynchronizingAjaxController());

				//获取页面  
				HtmlPage pageLogin;
				try {
					pageLogin = webClient.getPage("https://jwxt.jnu.edu.cn/Login.aspx");//登陆页面
					HtmlInput username = (HtmlInput) pageLogin.getElementById("txtYHBS");//账号输入框的id
					HtmlInput password = (HtmlInput) pageLogin.getElementById("txtYHMM");//密码输入框的id
					HtmlInput code=(HtmlInput) pageLogin.getElementById("txtFJM");		//验证码输入栏的id
					HtmlInput login=(HtmlInput) pageLogin.getElementById("btnLogin");	//登录按钮
					HtmlImage vaCode=(HtmlImage) pageLogin.getFirstByXPath("//*[@id=\"Table16\"]/tbody/tr[9]/td[3]/img");	//验证码图片
					
					//保存验证码图片到项目目录下
					File file=new File("./src/com/jnu/groupproject/data/yzm.png");
					if(vaCode!=null) {
						vaCode.saveAs(file);
					}
					
					//查看你项目下的yzm.png 手动输入
					System.out.println("请输入验证码:");
					new MyDailog("验证码信息", "请输入验证码").setVisible(true);
					//String YZM=new Scanner(System.in).next().trim();
					
					username.setAttribute("value","2016052357");
					password.setAttribute("value","199815");
					code.setAttribute("value", YZM);
					pageLogin=login.click();
					//System.out.println("--------------------------------------登录后的页面-----------------------------------------");
					//System.out.println(pageLogin.asXml());
					
					HtmlPage pageQueryCourse = webClient.getPage("https://jwxt.jnu.edu.cn/Secure/PaiKeXuanKe/wfrm_Pk_RlRscx.aspx");//排课选课信息查询页面
					
					HtmlInput courseName = (HtmlInput) pageQueryCourse.getElementById("txtKcmc");//课程名称的id
					HtmlInput courseNum = (HtmlInput) pageQueryCourse.getElementById("txtKcbh");//课程编号的id
					courseName.setAttribute("value",textField_courseName.getText());
					courseNum.setAttribute("value",textField_courseNum.getText());
					
					HtmlSelect select_year = (HtmlSelect) pageQueryCourse.getElementById("dlstXndZ"); //学年复选框
					HtmlOption yearOption = select_year.getOptionByValue("2019-2020");
					yearOption.setAttribute("selected","selected");
					HtmlSelect select_term = (HtmlSelect) pageQueryCourse.getElementById("dlstNdxq"); //学期复选框
					HtmlOption termOption = select_term.getOptionByValue("上");
					termOption.setAttribute("selected","selected");

					HtmlInput btn_search=(HtmlInput) pageQueryCourse.getElementById("lbtnSearch");
					pageQueryCourse=btn_search.click();
					System.out.println("--------------------------------------课程信息-----------------------------------------");
					System.out.println(pageQueryCourse.asXml());
					//保存爬取的网页数据
					File fileQueryCourse=new File("./src/com/jnu/groupproject/data/pageQueryCourse.html");
					if(pageQueryCourse!=null) {
						pageQueryCourse.save(fileQueryCourse);
					}

				} catch (FailingHttpStatusCodeException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}	
					
				
				tabbedPane.setSelectedIndex(1);	//跳转到开课列表界面
				log.info("点击了查询成绩按钮");
			}
		});
		
		button_query.setFont(new Font("宋体", Font.BOLD, 20));
		button_query.setBounds(460, 278, 181, 48);
		panel_queryCourse.add(button_query);
	}
	
	private void initPanelListCourse() {
		panel_listCourse.setLayout(null);
		
		JLabel label_listCourse = new JLabel("开 课 列 表");
		label_listCourse.setFont(new Font("宋体", Font.BOLD, 25));
		label_listCourse.setBounds(349, 97, 226, 31);
		panel_listCourse.add(label_listCourse);
		
		JButton button = new JButton("选课");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
				log.info("点击了选课按钮");
			}
		});
		button.setBounds(91, 186, 72, 27);
		panel_listCourse.add(button);
		
		JButton button_1 = new JButton("选课");
		button_1.setBounds(91, 226, 72, 27);
		panel_listCourse.add(button_1);
		
		JButton button_2 = new JButton("选课");
		button_2.setBounds(91, 266, 72, 27);
		panel_listCourse.add(button_2);
		
		JButton button_3 = new JButton("选课");
		button_3.setBounds(91, 306, 72, 27);
		panel_listCourse.add(button_3);
		
		JTable table_courseList = new JTable();
		table_courseList.setFont(new Font("宋体", Font.BOLD, 20));
		table_courseList.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_courseList.setRowHeight(40);//指定每一行的行高40
		
		table_courseList.setModel(new DefaultTableModel(
			new Object[][] {
				{"课程编号", " 课程名", "  学分", "  时间", "  地点", "  备注", "考试时间"},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
					"课程编号", "课程名", "学分", "时间", "地点", "备注", "考试时间"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_courseList.getColumnModel().getColumn(0).setResizable(false);
		table_courseList.getColumnModel().getColumn(1).setResizable(false);
		table_courseList.getColumnModel().getColumn(2).setResizable(false);
		table_courseList.setBounds(164, 141, 638, 200);
		panel_listCourse.add(table_courseList);
		
		JTable table_background = new JTable();
		table_background.setBounds(80, 86, 722, 255);
		panel_listCourse.add(table_background);
	}
	
	private void initPanelSelectedCourse() {
		panel_selectedCourse.setLayout(null);
		
		JLabel label_selectedCourse = new JLabel("已 选 课 程");
		label_selectedCourse.setFont(new Font("宋体", Font.BOLD, 25));
		label_selectedCourse.setBounds(349, 97, 226, 31);
		panel_selectedCourse.add(label_selectedCourse);
		
		JButton button = new JButton("退课");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
				log.info("点击了退课按钮");
			}
		});
		button.setBounds(91, 186, 72, 27);
		panel_selectedCourse.add(button);
		
		JButton button_1 = new JButton("退课");
		button_1.setBounds(91, 226, 72, 27);
		panel_selectedCourse.add(button_1);
		
		JButton button_2 = new JButton("退课");
		button_2.setBounds(91, 266, 72, 27);
		panel_selectedCourse.add(button_2);
		
		JButton button_3 = new JButton("退课");
		button_3.setBounds(91, 306, 72, 27);
		panel_selectedCourse.add(button_3);
		
		JTable table_courseSelected = new JTable();
		table_courseSelected.setFont(new Font("宋体", Font.BOLD, 20));
		table_courseSelected.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_courseSelected.setRowHeight(40);//指定每一行的行高40
		
		table_courseSelected.setModel(new DefaultTableModel(
			new Object[][] {
				{"课程编号", " 课程名", "  学分", "  时间", "  地点", "  备注", "考试时间"},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
					"课程编号", "课程名", "学分", "时间", "地点", "备注", "考试时间"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_courseSelected.getColumnModel().getColumn(0).setResizable(false);
		table_courseSelected.getColumnModel().getColumn(1).setResizable(false);
		table_courseSelected.getColumnModel().getColumn(2).setResizable(false);
		table_courseSelected.setBounds(164, 141, 638, 200);
		panel_selectedCourse.add(table_courseSelected);
		
		JTable table_background = new JTable();
		table_background.setBounds(80, 86, 722, 255);
		panel_selectedCourse.add(table_background);
	}
	
	class MyDailog extends JDialog implements ActionListener {
	    String title;
	    String content;
	    JTextField text=new JTextField("请输入验证码");
	    public MyDailog(String title, String content) throws Exception {
	        this.title = title;
	        this.content = content;
	        
	        ImageIcon icon = new ImageIcon("./src/com/jnu/groupproject/data/yzm.png");
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
	    		YZM=text.getText();
	    		this.setVisible(false);// 对话框不可见
	    		this.dispose();// 对话框销毁
	    	}
	    }
	    	        
	}
	
}
