package com.jnu.groupproject.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlTable;

public class PanelCourseSelect extends JPanel {
	
	private Logger log = Logger.getLogger(PanelUserInfo.class);
	
	boolean hadLoggedIn=false;	//是否登录过的标志
	int courseType=0;			//课程类别下拉框中的第i项
	int courseCollege=0;		//所属校区下拉框中的第i项
	WebClient webClient = new WebClient(BrowserVersion.CHROME);
	
	//创建选项卡面板对象
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	//创建面板
	JPanel panel_queryCourse=new JPanel();
	JPanel panel_listCourse=new JPanel();
	JPanel panel_selectedCourse=new JPanel();
	
	String YZM;	//验证码
	List<Course> courses=new ArrayList<>();//课程信息
	
	public PanelCourseSelect() {
		
		
		
		super();
		setLayout(new CardLayout(0, 0));
		add(tabbedPane, "name_422260517140338");
		
		PropertyConfigurator.configure("log4j.properties");
		
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
		
		JLabel label_courseType = new JLabel("课程类别：");
		label_courseType.setFont(new Font("宋体", Font.BOLD, 20));
		label_courseType.setBounds(116, 146, 116, 34);
		panel_queryCourse.add(label_courseType);
		
		JLabel label_courseNum = new JLabel("课程编号：");
		label_courseNum.setFont(new Font("宋体", Font.BOLD, 20));
		label_courseNum.setBounds(475, 76, 116, 34);
		panel_queryCourse.add(label_courseNum);
		
		JLabel label_courseCollege = new JLabel("所属校区：");
		label_courseCollege.setFont(new Font("宋体", Font.BOLD, 20));
		label_courseCollege.setBounds(475, 146, 116, 34);
		panel_queryCourse.add(label_courseCollege);
		
		JTextField textField_courseName = new JTextField();	//课程名称输入框
		textField_courseName.setBounds(220, 79, 159, 33);
		panel_queryCourse.add(textField_courseName);
		textField_courseName.setColumns(10);
		
		JTextField textField_courseNum = new JTextField();	//课程编号输入框
		textField_courseNum.setColumns(10);
		textField_courseNum.setBounds(580, 80, 159, 33);
		panel_queryCourse.add(textField_courseNum);
		

		String[] type={"","全校公选课","学科基础课","专业基础课","专业课","专业选修课","公共选修课"};
		//JComboBox<String> comboBox_courseType = new JComboBox<>(courseType);
		JComboBox comboBox_courseType = new JComboBox(type);
		comboBox_courseType.setFont(new Font("宋体", Font.BOLD, 18));
		comboBox_courseType.setBounds(222, 147, 157, 33);
		comboBox_courseType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (ItemEvent.SELECTED == e.getStateChange()) {
					log.info("课程类别"+type[comboBox_courseType.getSelectedIndex()]);
					courseType=comboBox_courseType.getSelectedIndex();
				}
			}
		});
		panel_queryCourse.add(comboBox_courseType);
		
		String[] college={"","本部校区","珠海校区","南校区","专业课","深圳校区"};
		JComboBox comboBox_courseCollege = new JComboBox(college);
		comboBox_courseCollege.setFont(new Font("宋体", Font.BOLD, 18));
		comboBox_courseCollege.setBounds(580, 149, 159, 33);
		comboBox_courseCollege.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (ItemEvent.SELECTED == e.getStateChange()) {
					log.info("课程类别"+college[comboBox_courseCollege.getSelectedIndex()]);
					courseCollege=comboBox_courseCollege.getSelectedIndex();
				}
			}
		});
		panel_queryCourse.add(comboBox_courseCollege);
		
		JButton button_cancel = new JButton("清除条件");
		button_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_courseName.setText("");
				textField_courseNum.setText("");
				courseType=0;
				courseCollege=0;
			}
		});
		button_cancel.setFont(new Font("宋体", Font.BOLD, 20));
		button_cancel.setBounds(151, 278, 181, 48);
		panel_queryCourse.add(button_cancel);
		
		JButton button_query = new JButton("查询");
		button_query.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("resource")
			@Override
			public void mouseClicked(MouseEvent e) {
				log.info("点击了[查询选课]的[查询]按钮");
				//WebClient webClient = new WebClient(BrowserVersion.CHROME);
				if(!hadLoggedIn) {
					webClient.getOptions().setThrowExceptionOnScriptError(false);
					//设置证书
					webClient.getOptions().setUseInsecureSSL(true);
					//是否启用js
					webClient.getOptions().setJavaScriptEnabled(false);
					//是否启用css
					webClient.getOptions().setCssEnabled(false);
					//设置Ajax控制器
					webClient.setAjaxController(new NicelyResynchronizingAjaxController());
				}
				try {
					LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");//屏蔽日志
					java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);

					if(!hadLoggedIn) {	//之前没有登录过，即首次登录，需要模拟登陆
						hadLoggedIn=true;
						HtmlPage pageLogin = webClient.getPage("https://jwxt.jnu.edu.cn/Login.aspx");//登陆页面
						HtmlInput username = (HtmlInput) pageLogin.getElementById("txtYHBS");//账号输入框的id
						HtmlInput password = (HtmlInput) pageLogin.getElementById("txtYHMM");//密码输入框的id
						HtmlInput code=(HtmlInput) pageLogin.getElementById("txtFJM");		//验证码输入栏的id
						HtmlInput login=(HtmlInput) pageLogin.getElementById("btnLogin");	//登录按钮
						HtmlImage vaCode=(HtmlImage) pageLogin.getFirstByXPath("//*[@id=\"Table16\"]/tbody/tr[9]/td[3]/img");	//验证码图片
						
						//保存验证码图片到项目目录下
						File file=new File("./src/com/jnu/groupproject/data/yzm.png");
						if(vaCode!=null)	vaCode.saveAs(file);
						
						log.info("输入验证码");
						new MyDailog("验证码信息", "请输入验证码").setVisible(true);
						//System.out.println("请输入验证码:");
						//String YZM=new Scanner(System.in).next().trim();
						
						username.setAttribute("value","2016052357");
						password.setAttribute("value","199815");
						code.setAttribute("value", YZM);
						pageLogin=login.click();
						//System.out.println("--------------------------------------登录后的页面-----------------------------------------");
						//System.out.println(pageLogin.asXml());
					}
					
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
					HtmlSelect select_type = (HtmlSelect) pageQueryCourse.getElementById("dlstKclb"); //课程类别复选框
					HtmlOption typeOption = select_type.getOption(courseType);
					typeOption.click();
					HtmlSelect select_college = (HtmlSelect) pageQueryCourse.getElementById("dlstXqu"); //校区复选框
					HtmlOption collegeOption = select_college.getOption(courseCollege);
					collegeOption.click();

					HtmlInput btn_search=(HtmlInput) pageQueryCourse.getElementById("lbtnSearch");
					pageQueryCourse=btn_search.click();
					//System.out.println("--------------------------------------课程信息-----------------------------------------");
					//System.out.println(pageQueryCourse.asXml());
					
					HtmlTable table=pageQueryCourse.getHtmlElementById("dgrdJXJH");	//排课表
					
					courses.clear();   //清空原来的
					for(int i=1; i<table.getRowCount(); i++) {
						Course course=new Course();
						course.setName(table.getRow(i).getCell(1).asText());
						course.setNum(table.getRow(i).getCell(0).asText());
						course.setCredit(table.getRow(i).getCell(6).asText());
						course.setClassTime(table.getRow(i).getCell(8).asText());
						course.setClassroom(table.getRow(i).getCell(7).asText());
						course.setNotes(table.getRow(i).getCell(12).asText());
						course.setExamDate(table.getRow(i).getCell(11).asText());
						//System.out.println("   Found cell: " + table.getRow(i).getCell(1).asText());
						courses.add(course);
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
				}	finally {
					//webClient.close(); //关闭客户端，释放内存
				}
					
				//initPanelListCourse();
				panel_listCourse.removeAll();
				initPanelListCourse();
				tabbedPane.setComponentAt(1, panel_listCourse);
				tabbedPane.setSelectedIndex(1);	//跳转到开课列表界面
				log.info("从[查询选课]跳转到[开课列表]");
			}
		});
		
		button_query.setFont(new Font("宋体", Font.BOLD, 20));
		button_query.setBounds(460, 278, 181, 48);
		panel_queryCourse.add(button_query);
	}
	
	private void initPanelListCourse() {
		JLabel label_listCourse = new JLabel("开 课 列 表");
		label_listCourse.setFont(new Font("宋体", Font.BOLD, 25));
		label_listCourse.setBounds(349, 97, 226, 31);
		panel_listCourse.add(label_listCourse);
		// 表头（列名）
        Object[] columnNames = {"课程编号", "课程名", "学分", "时间", "地点", "备注", "考试时间"};

        // 表格所有行数据
        int rowCount=courses.size();
        Object[][] rowData = new Object[rowCount][7];
        for(int i=0; i<rowCount; i++) {
        	rowData[i][0]=courses.get(i).getNum();
        	rowData[i][1]=courses.get(i).getName();
        	rowData[i][2]=courses.get(i).getCredit();
        	rowData[i][3]=courses.get(i).getClassTime();
        	rowData[i][4]=courses.get(i).getClassroom();
        	rowData[i][5]=courses.get(i).getNotes();
        	rowData[i][6]=courses.get(i).getExamDate();
        	System.out.println("   xxxxx xxxx: " + courses.get(i).getName());
        }

        // 创建一个表格，指定 表头 和 所有行数据
        JTable table = new JTable(rowData, columnNames);

        // 设置表格内容颜色
        table.setForeground(Color.BLACK);                   // 字体颜色
        table.setFont(new Font("宋体", Font.PLAIN, 15));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.GRAY);                     // 网格颜色

        // 设置表头
        table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 20));  // 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.BLACK);                // 设置表头名称字体颜色
        table.getTableHeader().setResizingAllowed(true);               // 设置不允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

        // 设置行高
        table.setRowHeight(40);

        // 设置列宽
        table.getColumnModel().getColumn(0).setPreferredWidth(45);
        table.getColumnModel().getColumn(2).setPreferredWidth(15);
        table.getColumnModel().getColumn(6).setPreferredWidth(45);

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(800, 350));

        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        JScrollPane scrollPane = new JScrollPane(table);

        // 添加 滚动面板 到 内容面板
        panel_listCourse.add(scrollPane);
	}
	
	private void initPanelSelectedCourse() {
		JLabel label_selectCourse = new JLabel("已 选 课 程");
		label_selectCourse.setFont(new Font("宋体", Font.BOLD, 25));
		label_selectCourse.setBounds(349, 97, 226, 31);
		panel_selectedCourse.add(label_selectCourse);
		
		// 表头（列名）
        Object[] columnNames = {"课程编号", "课程名", "学分", "时间", "地点", "备注", "考试时间"};
        // 表格所有行数据
        int rowCount=courses.size();
        Object[][] rowData = new Object[rowCount][7];
        for(int i=0; i<rowCount; i++) {
        	rowData[i][0]=courses.get(i).getNum();
        	rowData[i][1]=courses.get(i).getName();
        	rowData[i][2]=courses.get(i).getCredit();
        	rowData[i][3]=courses.get(i).getClassTime();
        	rowData[i][4]=courses.get(i).getClassroom();
        	rowData[i][5]=courses.get(i).getNotes();
        	rowData[i][6]=courses.get(i).getExamDate();
        	//System.out.println("   xxxxx xxxx: " + courses.get(i).getName());
        }

        // 创建一个表格，指定 表头 和 所有行数据
        JTable table = new JTable(rowData, columnNames);

        // 设置表格内容颜色
        table.setForeground(Color.BLACK);                   // 字体颜色
        table.setFont(new Font("宋体", Font.PLAIN, 15));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.GRAY);                     // 网格颜色

        // 设置表头
        table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 20));  // 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.BLACK);                // 设置表头名称字体颜色
        table.getTableHeader().setResizingAllowed(true);               // 设置不允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

        // 设置行高
        table.setRowHeight(40);

        // 设置列宽
        table.getColumnModel().getColumn(0).setPreferredWidth(45);
        table.getColumnModel().getColumn(2).setPreferredWidth(15);
        table.getColumnModel().getColumn(6).setPreferredWidth(45);

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(800, 350));

        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        JScrollPane scrollPane = new JScrollPane(table);

        // 添加 滚动面板 到 内容面板
        panel_selectedCourse.add(scrollPane);
	}
	
	class MyDailog extends JDialog implements ActionListener {
	    String title;
	    String content;
	    JTextField text=new JTextField("请输入验证码");
	    public MyDailog(String title, String content) throws Exception {
	        this.title = title;
	        this.content = content;
	        
	        File file = new File("./src/com/jnu/groupproject/data/yzm.png");
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
	    		YZM=text.getText();
	    		this.setVisible(false);// 对话框不可见
	    		this.dispose();// 对话框销毁
	    	}
	    }
	    	        
	}
}
