package com.jnu.groupproject.view;

import javax.swing.JPanel;
import com.jnu.groupproject.data.*;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.sound.midi.MidiDevice.Info;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.omg.CORBA.PUBLIC_MEMBER;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.jnu.groupproject.noticeclass.RWCollegeNoticeOperater;
import com.jnu.groupproject.noticeclass.DianFeiQuery;
import com.jnu.groupproject.noticeclass.FYCollegeNoticeOperater;
import com.jnu.groupproject.noticeclass.GJSCollegeNoticeOperater;
import com.jnu.groupproject.noticeclass.JwcNoticeOperater;
import com.jnu.groupproject.noticeclass.JyNoticeOperater;
import com.jnu.groupproject.noticeclass.News;
import com.jnu.groupproject.noticeclass.NewsOperater;
import com.jnu.groupproject.noticeclass.Notice;
import com.jnu.groupproject.noticeclass.NoticeSerializeOperater;
import com.jnu.groupproject.noticeclass.SchoolCardQuery;
import com.jnu.groupproject.noticeclass.SchoolNoticeOperater;
import com.jnu.groupproject.noticeclass.Web;
import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import net.sourceforge.htmlunit.corejs.javascript.ast.ThrowStatement;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelHomePage extends JPanel {

	// 空间组
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JPanel HomePagePanel = new JPanel();
	private Logger log = Logger.getLogger(PanelUserInfo.class);

	// 全局变量
	int pageCount = 1;
	int maxpageCount = Integer.MAX_VALUE;
	static int NoticeFlag = 1;// 1校内、2院内、3教务处、4就业、5新浪新闻

	
	static int SchoolNoticeFlag=1;//0代表未选中，1代表选中
	static int CollegeNoticeFlag=1;//0代表未选中，1代表人文，2代表翻译，3代表国商
	static int JyNoticeFlag=0;//0代表未选中，1代表选中
	static int JwcNoticeFlag=0;//0代表未选中，1代表选中
	static int NoticeOrNewsFlag=0;//0代表通知，1代表新闻
	static int NewsFlag = 1;// 1全部、2热点、3国内、4国外、5军事、6文化
	static int XLFlag=0;//0代表未选中，1代表选中
	
	

	// 设置路径
	static String schoolnoticepath = "./src/com/jnu/groupproject/data/schoolnotice.dat";
	static String RWcollegenoticepath = "./src/com/jnu/groupproject/data/RWcollegenotice.dat";
	static String GJScollegenoticepath = "./src/com/jnu/groupproject/data/GJScollegenotice.dat";
	static String FYcollegenoticepath = "./src/com/jnu/groupproject/data/FYcollegenotice.dat";
	static String Jwcnoticepath = "./src/com/jnu/groupproject/data/Jwcnotice.dat";
	static String Jynoticepath = "./src/com/jnu/groupproject/data/Jynotice.dat";
	static String newspath = "./src/com/jnu/groupproject/data/news.dat";
	static String RDnewspath = "./src/com/jnu/groupproject/data/RDnews.dat";
	static String GNnewspath = "./src/com/jnu/groupproject/data/GNnews.dat";
	static String GWnewspath = "./src/com/jnu/groupproject/data/GWnews.dat";
	static String JSnewspath = "./src/com/jnu/groupproject/data/JSnews.dat";
	static String WHnewspath = "./src/com/jnu/groupproject/data/WHnews.dat";

	// 工具类,爬取通知
	static NoticeSerializeOperater<Notice> schoolnoticeoperater = new NoticeSerializeOperater<Notice>();
	static NoticeSerializeOperater<Notice> RWcollegenoticeoperater = new NoticeSerializeOperater<Notice>();
	static NoticeSerializeOperater<Notice> GJScollegenoticeoperater = new NoticeSerializeOperater<Notice>();
	static NoticeSerializeOperater<Notice> FYcollegenoticeoperater = new NoticeSerializeOperater<Notice>();
	static NoticeSerializeOperater<Notice> Jwcnoticeoperater = new NoticeSerializeOperater<Notice>();
	static NoticeSerializeOperater<Notice> Jynoticeoperater = new NoticeSerializeOperater<Notice>();
	static NoticeSerializeOperater<News> newsoperater = new NoticeSerializeOperater<News>();
	
	// 反序列化通知
	static ArrayList<Notice> schoolDesnotices;
	static ArrayList<Notice> RWcollegeDesnotices;
	static ArrayList<Notice> GJScollegeDesnotices;
	static ArrayList<Notice> FYcollegeDesnotices;
	static ArrayList<Notice> JwcDesnotices;
	static ArrayList<Notice> JyDesnotices;
	static ArrayList<News> Desnews;
	static ArrayList<News> RD_Desnews;// 热点
	static ArrayList<News> GN_Desnews;// 国内
	static ArrayList<News> GW_Desnews;// 国外
	static ArrayList<News> JS_Desnews;// 军事
	static ArrayList<News> WH_Desnews;// 文化
	
	//数据显示
	static ArrayList<Notice> showDesnotices=new ArrayList<Notice>();
	static ArrayList<News> showDesnews=new ArrayList<News>();
	
	
	
	public JButton ElectricityChargeRecordButton = new JButton();
	public JLabel ElectricityFeesBalanceLabel = new JLabel();
	public JButton ElectricityQueryButton = new JButton();
	public JTextField PageChangTextField = new JTextField();
	public JLabel label = new JLabel("全部通知");
	public JRadioButton SchoolNoticeButton = new JRadioButton("校内通知");
	public JRadioButton CollegeNoticeButton = new JRadioButton("学院通知");
	public JRadioButton AdministrationNoticeButton = new JRadioButton("教务处通知");
	public JRadioButton EmploymentNoticeButton = new JRadioButton("就业通知");
	public JLabel RelativeInformationLabel = new JLabel("个人相关信息");
	// public JLabel SchoolForumLabel=new JLabel("学校论坛");
	public JLabel SchoolForumLabel = new JLabel();
	public JLabel SchoolCardLabel = new JLabel("一卡通");
	public JLabel ElectricityFeesLabel = new JLabel("电  费");
	public JLabel SchhoForumLabel = new JLabel("学校论坛");
	public JLabel SchoolCardBalanceLabel = new JLabel("饭卡余额：未查询");
	public JLabel SchoolCardStatusLabel = new JLabel("账号状态：正常");
	public JLabel ElectricityStatusLabel = new JLabel("使用状态：正常");
	public JButton SchoolCardQueryButton = new JButton("查询");
	public JButton SchoolCardRecordButton = new JButton("查看记录");
	public JButton UpdataAllNoticeButton = new JButton("一键更新");
	public JButton UpdateSchoolNoticeButton = new JButton("更新校内通知");
	public JButton UpdateCollegeNoticeButton = new JButton("更新学院通知");
	public JButton UpdateJwcNoticeButton = new JButton("更新教务处通知");
	public JButton UpdateJyNoticeButton = new JButton("更新就业通知");
	public JLabel NoticeOneTitleLabel = new JLabel("New label");
	public JLabel NoticeTwoTitleLabel = new JLabel("New label");
	public JLabel NoticeThreeTitleLabel = new JLabel("New label");
	public JLabel NoticeFourTitleLabel = new JLabel("New label");
	public JLabel NoticeFiveTitleLabel = new JLabel("New label");
	public JLabel NoticeOneSourceLabel = new JLabel("New label");
	public JLabel NoticeOneTimeLabel = new JLabel("New label");
	public JLabel NoticeTwoSourceLabel = new JLabel("New label");
	public JLabel NoticeThreeSourceLabel = new JLabel("New label");
	public JLabel NoticeFourSourceLabel = new JLabel("New label");
	public JLabel NoticeFiveSourceLabel = new JLabel("New label");
	public JLabel NoticeTwoTimeLabel = new JLabel("New label");
	public JLabel NoticeThreeTimeLabel = new JLabel("New label");
	public JLabel NoticeFourTimeLabel = new JLabel("New label");
	public JLabel NoticeFiveTimeLabel = new JLabel("New label");
	public JButton UpPageButton = new JButton("上一页");
	public JLabel lblNewLabel = new JLabel("当前页码 ");
	public JLabel PageCountLabel = new JLabel("New label");
	public JLabel TotalPageCountOneLabel = new JLabel(" /共");
	public JLabel TotalPageCountLabel = new JLabel("New label");
	public JLabel TotalPageTwoLabel = new JLabel("页");
	public JButton DownPageButton = new JButton("下一页");
	public JButton PageChangeButton = new JButton("跳转");
	public JLabel lblNewLabel_1 = new JLabel("跳转页码");
	public JButton updateNewsButton = new JButton("更新新闻");
	public JComboBox CollegeBox = new JComboBox();
	public JRadioButton XLNewsButton = new JRadioButton("新浪新闻");
	private final JSeparator separator_1 = new JSeparator();
	private final JSeparator separator_3 = new JSeparator();
	private final JSeparator separator_4 = new JSeparator();
	private final JSeparator separator_5 = new JSeparator();
	private final JComboBox NewsBox = new JComboBox();

	// 爬取通知
	public void UpdateNotice() throws Exception, FileNotFoundException, IOException {
		schoolDesnotices = schoolnoticeoperater.load(schoolnoticepath);
		RWcollegeDesnotices = RWcollegenoticeoperater.load(RWcollegenoticepath);
		GJScollegeDesnotices = GJScollegenoticeoperater.load(GJScollegenoticepath);
		FYcollegeDesnotices = RWcollegenoticeoperater.load(FYcollegenoticepath);
		JwcDesnotices = Jwcnoticeoperater.load(Jwcnoticepath);
		JyDesnotices = Jynoticeoperater.load(Jynoticepath);
	}

	//
	
	//爬取新闻
	public void UpdateNews() throws Exception, FileNotFoundException, IOException {
		Desnews = newsoperater.load(newspath);
		RD_Desnews = newsoperater.load(RDnewspath);
		GN_Desnews = newsoperater.load(GNnewspath);
		GW_Desnews = newsoperater.load(GWnewspath);
		JS_Desnews = newsoperater.load(JSnewspath);
		WH_Desnews = newsoperater.load(WHnewspath);

		if (NewsFlag == 1)
			Desnews = newsoperater.load(newspath);
		else if (NewsFlag == 2)
			Desnews = RD_Desnews;
		else if (NewsFlag == 3)
			Desnews = GN_Desnews;
		else if (NewsFlag == 4)
			Desnews = GW_Desnews;
		else if (NewsFlag == 5)
			Desnews = JS_Desnews;
		else
			Desnews = WH_Desnews;
	}

	//构造函数
	public PanelHomePage() throws Exception, FileNotFoundException, IOException {
		PropertyConfigurator.configure("log4j.properties");
		setLayout(null);

		// 反序列化
		schoolDesnotices = schoolnoticeoperater.load(schoolnoticepath);
		RWcollegeDesnotices = RWcollegenoticeoperater.load(RWcollegenoticepath);
		GJScollegeDesnotices = GJScollegenoticeoperater.load(GJScollegenoticepath);
		FYcollegeDesnotices = RWcollegenoticeoperater.load(FYcollegenoticepath);
		JwcDesnotices = Jwcnoticeoperater.load(Jwcnoticepath);
		JyDesnotices = Jynoticeoperater.load(Jynoticepath);
		Desnews = newsoperater.load(newspath);
		
		//初始化数据
		setAllNotice();
		setAllNews();
		
		// 初始化
		setShowNotice();
		setShowNews();
		showNoticeOrNew(0);
		SchoolNoticeButton.setSelected(true);
		CollegeNoticeButton.setSelected(true);
		
		

		// 首先规定用户信息的路径（需要用到用户信息的界面都要引入该语句）
		FileHelper fh = new FileHelper("./userinfo.txt");
		// 读取个人信息代码
		Person person = fh.getObjFromFile();

		HomePagePanel.setBounds(0, 13, 880, 460);
		add(HomePagePanel);
		HomePagePanel.setLayout(null);
		
		CollegeBox.setModel(new DefaultComboBoxModel(new String[] { "人文学院", "翻译学院", "国际商学院" }));
		CollegeBox.setBounds(550, 158, 93, 21);
		HomePagePanel.add(CollegeBox);
		CollegeBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 如果选中了一个
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// 这里写你的任务 ，比如取到现在的值
					String text = (String) CollegeBox.getSelectedItem();
					// System.out.println(text);
					if (text == "翻译学院") {
						pageCount = 1;
						CollegeNoticeFlag = 2;
						setShowNotice();
						showNoticeOrNew((pageCount-1)*5);
					} else if (text == "国际商学院") {
						pageCount = 1;
						CollegeNoticeFlag = 3;
						setShowNotice();
						showNoticeOrNew((pageCount-1)*5);
					} else {
						pageCount = 1;
						CollegeNoticeFlag = 1;
						setShowNotice();
						showNoticeOrNew((pageCount-1)*5);
					}
				}
			}
		});

		label.setBounds(36, 111, 93, 40);
		label.setFont(new Font("宋体", Font.BOLD, 22));
		HomePagePanel.add(label);

		SchoolNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		SchoolNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pageCount = 1;
				NoticeOrNewsFlag=0;
				if(SchoolNoticeFlag==0) {
					SchoolNoticeFlag=1;
					SchoolNoticeButton.setSelected(true);
				}
				else {
					SchoolNoticeFlag=0;
					SchoolNoticeButton.setSelected(false);
				}
				if(AllFlase())
					log.error("没有选中的通知");
				else {
					setShowNotice();
					showNoticeOrNew((pageCount-1)*5);
				}
				XLNewsButton.setSelected(false);
				HomePagePanel.remove(NewsBox);
				HomePagePanel.remove(updateNewsButton);
				HomePagePanel.updateUI();
			}
		});
		SchoolNoticeButton.setBounds(46, 157, 93, 23);
		HomePagePanel.add(SchoolNoticeButton);

		CollegeNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		CollegeNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pageCount = 1;
				NoticeOrNewsFlag=0;
				CollegeBox.setModel(new DefaultComboBoxModel(new String[] { "人文学院", "翻译学院", "国际商学院" }));
				CollegeBox.setBounds(550, 158, 93, 21);
				CollegeBox.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						// 如果选中了一个
						if (e.getStateChange() == ItemEvent.SELECTED) {
							// 这里写你的任务 ，比如取到现在的值
							String text = (String) CollegeBox.getSelectedItem();
							// System.out.println(text);
							if (text == "翻译学院") {
								pageCount = 1;
								CollegeNoticeFlag = 2;
								setShowNotice();
								showNoticeOrNew((pageCount-1)*5);
							} else if (text == "国际商学院") {
								pageCount = 1;
								CollegeNoticeFlag = 3;
								setShowNotice();
								showNoticeOrNew((pageCount-1)*5);
							} else {
								pageCount = 1;
								CollegeNoticeFlag = 1;
								setShowNotice();
								showNoticeOrNew((pageCount-1)*5);
							}
						}
					}
				});
				if(CollegeNoticeFlag==0) {
					CollegeNoticeFlag=1;
					CollegeNoticeButton.setSelected(true);
					HomePagePanel.add(CollegeBox);
					HomePagePanel.updateUI();
				}
				else {
					CollegeNoticeFlag=0;
					CollegeNoticeButton.setSelected(false);
					HomePagePanel.remove(CollegeBox);
					HomePagePanel.updateUI();
				}
				if(AllFlase()) {
					log.error("没有所选通知");
				}
				else {
					setShowNotice();
					showNoticeOrNew((pageCount-1)*5);
				}
				XLNewsButton.setSelected(false);
				HomePagePanel.remove(NewsBox);
				HomePagePanel.remove(updateNewsButton);
				HomePagePanel.updateUI();

				
			}
		});
		CollegeNoticeButton.setBounds(149, 157, 93, 23);
		HomePagePanel.add(CollegeNoticeButton);

		AdministrationNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		AdministrationNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pageCount = 1;
				NoticeOrNewsFlag=0;
				if(JwcNoticeFlag==0)
					JwcNoticeFlag=1;
				else
					JwcNoticeFlag=0;
				if(AllFlase())
					log.error("没有选中的通知");
				else {
					setShowNotice();
					showNoticeOrNew((pageCount-1)*5);
				}
				XLNewsButton.setSelected(false);
				HomePagePanel.remove(NewsBox);
				HomePagePanel.remove(updateNewsButton);
				HomePagePanel.updateUI();


			}
		});
		AdministrationNoticeButton.setBounds(254, 157, 106, 23);
		HomePagePanel.add(AdministrationNoticeButton);

		EmploymentNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		EmploymentNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pageCount = 1;
				NoticeOrNewsFlag=0;
				if(JyNoticeFlag==0)
					JyNoticeFlag=1;
				else
					JyNoticeFlag=0;
				if(AllFlase())
					log.error("没有选中的通知");
				else {
					setShowNotice();
					showNoticeOrNew((pageCount-1)*5);
				}
				XLNewsButton.setSelected(false);
				HomePagePanel.remove(NewsBox);
				HomePagePanel.remove(updateNewsButton);
				HomePagePanel.updateUI();

			}
		});
		EmploymentNoticeButton.setBounds(362, 157, 93, 23);
		HomePagePanel.add(EmploymentNoticeButton);

		RelativeInformationLabel.setFont(new Font("宋体", Font.BOLD, 22));
		RelativeInformationLabel.setBounds(36, 0, 155, 40);
		HomePagePanel.add(RelativeInformationLabel);

		SchoolCardLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		SchoolCardLabel.setBounds(36, 41, 67, 40);
		HomePagePanel.add(SchoolCardLabel);

		ElectricityFeesLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		ElectricityFeesLabel.setBounds(360, 41, 67, 40);
		HomePagePanel.add(ElectricityFeesLabel);
		SchoolForumLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						setWebJump("学校论坛","http://bbs.jnlts.com/");
//						try {
//							JFrame frame = new JFrame("学校论坛");
//							// 设置窗体关闭的时候不关闭应用程序
//							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//							frame.getContentPane().add(new Web("http://bbs.jnlts.com/"), BorderLayout.CENTER);
//							frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//							frame.setLocationByPlatform(true);
//							// 让窗体可见
//							frame.setVisible(true);
//							// 重置窗体大小
//							frame.setResizable(true);
//							// 设置窗体的宽度、高度
//							frame.setSize(700, 500);
//							// 设置窗体居中显示
//							frame.setLocationRelativeTo(frame.getOwner());
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
					}
				});

			}
		});

		SchoolForumLabel.setFont(new Font("宋体", Font.BOLD, 22));
		SchoolForumLabel.setIcon(new ImageIcon("./src/com/jnu/groupproject/data/schoolBBS.png"));
		SchoolForumLabel.setBounds(656, 0, 214, 99);
		HomePagePanel.add(SchoolForumLabel);

		SchoolCardBalanceLabel.setBounds(100, 41, 132, 15);
		HomePagePanel.add(SchoolCardBalanceLabel);

		SchoolCardStatusLabel.setBounds(100, 66, 142, 15);
		HomePagePanel.add(SchoolCardStatusLabel);
		ElectricityFeesBalanceLabel.setText("剩余电量：未查询");

		ElectricityFeesBalanceLabel.setBounds(420, 41, 127, 15);
		HomePagePanel.add(ElectricityFeesBalanceLabel);

		ElectricityStatusLabel.setBounds(420, 66, 130, 15);
		HomePagePanel.add(ElectricityStatusLabel);

		SchoolCardQueryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// 这里要关联用户信息
				String account, password;
				account = "" + person.getNum();
				password = "" + person.getCard();
				SchoolCardQuery schoolcard = new SchoolCardQuery(account, password);
				SchoolCardBalanceLabel.setText("饭卡余额：" + schoolcard.getQueryResult());
				HomePagePanel.updateUI();
			}
		});
		SchoolCardQueryButton.setBounds(227, 33, 93, 23);
		HomePagePanel.add(SchoolCardQueryButton);
		SchoolCardRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		SchoolCardRecordButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrame frame = new JFrame("饭卡记录");
							// 设置窗体关闭的时候不关闭应用程序
							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							frame.getContentPane().add(new Web("https://card.jnu.edu.cn/pages/common/homeLogin.action"),
									BorderLayout.CENTER);
							frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
							frame.setLocationByPlatform(true);
							// 让窗体可见
							frame.setVisible(true);
							// 重置窗体大小
							frame.setResizable(true);
							// 设置窗体的宽度、高度
							frame.setSize(700, 500);
							// 设置窗体居中显示
							frame.setLocationRelativeTo(frame.getOwner());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		SchoolCardRecordButton.setBounds(227, 58, 93, 23);
		HomePagePanel.add(SchoolCardRecordButton);
		ElectricityQueryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// 这里需要关联用户信息
					String roomaccount;
					roomaccount = "" + person.getRoom();
					DianFeiQuery dianFei = new DianFeiQuery(roomaccount);
					ElectricityFeesBalanceLabel.setText("剩余电量：" + dianFei.getQueryResult());
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		ElectricityQueryButton.setText("查询");

		ElectricityQueryButton.setBounds(548, 33, 93, 23);
		HomePagePanel.add(ElectricityQueryButton);
		ElectricityChargeRecordButton.setText("查看记录");

		ElectricityChargeRecordButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrame frame = new JFrame("电费记录");
							// 设置窗体关闭的时候不关闭应用程序
							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							frame.getContentPane().add(new Web("http://202.116.25.12/Login.aspx"), BorderLayout.CENTER);
							frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
							frame.setLocationByPlatform(true);
							// 让窗体可见
							frame.setVisible(true);
							// 重置窗体大小
							frame.setResizable(true);
							// 设置窗体的宽度、高度
							frame.setSize(700, 500);
							// 设置窗体居中显示
							frame.setLocationRelativeTo(frame.getOwner());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		ElectricityChargeRecordButton.setBounds(548, 58, 93, 23);
		HomePagePanel.add(ElectricityChargeRecordButton);

		// 一键更新
		UpdataAllNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					SchoolNoticeOperater schoolnoticeoperater = new SchoolNoticeOperater();
					RWCollegeNoticeOperater RWcollegenoticeoperater = new RWCollegeNoticeOperater();
					GJSCollegeNoticeOperater GJScollegenoticeoperater = new GJSCollegeNoticeOperater();
					FYCollegeNoticeOperater FYcollegenoticeoperater = new FYCollegeNoticeOperater();
					JwcNoticeOperater Jwcnoticeoperater = new JwcNoticeOperater();
					JyNoticeOperater Jynoticeoperater = new JyNoticeOperater();
					NewsOperater Newsoperater = new NewsOperater();
					UpdateNotice();
					UpdateNews();
					setShowNotice();
					setShowNews();
					showNoticeOrNew((pageCount - 1) * 5);
					HomePagePanel.updateUI();
				} catch (FileNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});

		UpdataAllNoticeButton.setBounds(139, 123, 93, 23);
		HomePagePanel.add(UpdataAllNoticeButton);
		UpdateSchoolNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					SchoolNoticeOperater schoolnoticeoperater = new SchoolNoticeOperater();
					UpdateNotice();
					setShowNotice();
					showNoticeOrNew((pageCount - 1) * 5);
					HomePagePanel.updateUI();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});

		UpdateSchoolNoticeButton.setBounds(280, 123, 133, 23);
		HomePagePanel.add(UpdateSchoolNoticeButton);
		UpdateCollegeNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					if (CollegeNoticeFlag == 1) {
						RWCollegeNoticeOperater RWcollegenoticeoperater = new RWCollegeNoticeOperater();
					} else if (CollegeNoticeFlag == 3) {
						GJSCollegeNoticeOperater GJScollegenoticeoperater = new GJSCollegeNoticeOperater();
					} else {
						FYCollegeNoticeOperater FYcollegenoticeoperater = new FYCollegeNoticeOperater();
					}
					UpdateNotice();
					setShowNotice();
					showNoticeOrNew((pageCount - 1) * 5);
					HomePagePanel.updateUI();
				} catch (FileNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});

		UpdateCollegeNoticeButton.setBounds(427, 123, 134, 23);
		HomePagePanel.add(UpdateCollegeNoticeButton);
		UpdateJwcNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					JwcNoticeOperater Jwcnoticeoperater = new JwcNoticeOperater();
					UpdateNotice();
					setShowNotice();
					showNoticeOrNew((pageCount - 1) * 5);
					HomePagePanel.updateUI();
				} catch (FileNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});

		UpdateJwcNoticeButton.setBounds(575, 123, 149, 23);
		HomePagePanel.add(UpdateJwcNoticeButton);
		UpdateJyNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					JyNoticeOperater Jynoticeoperater = new JyNoticeOperater();
					UpdateNotice();
					setShowNotice();
					showNoticeOrNew((pageCount - 1) * 5);
					HomePagePanel.updateUI();
				} catch (FileNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});

		UpdateJyNoticeButton.setBounds(738, 123, 132, 23);
		HomePagePanel.add(UpdateJyNoticeButton);
		NoticeOneTitleLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if(NoticeOrNewsFlag==0)
								setWebJump("通知", showDesnotices.get(pageCount * 5 - 5).getUrl());
							else
								setWebJump("新闻", showDesnews.get(pageCount * 5 - 5).getUrl());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		NoticeOneTitleLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		NoticeOneTitleLabel.setBounds(56, 190, 550, 15);
		HomePagePanel.add(NoticeOneTitleLabel);
		NoticeTwoTitleLabel.setBackground(Color.BLACK);
		NoticeTwoTitleLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if(NoticeOrNewsFlag==0)
								setWebJump("通知", showDesnotices.get(pageCount * 5 - 4).getUrl());
							else
								setWebJump("新闻", showDesnews.get(pageCount * 5 - 4).getUrl());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		NoticeTwoTitleLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		NoticeTwoTitleLabel.setBounds(56, 229, 550, 15);
		HomePagePanel.add(NoticeTwoTitleLabel);
		NoticeThreeTitleLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if(NoticeOrNewsFlag==0)
								setWebJump("通知", showDesnotices.get(pageCount * 5 - 3).getUrl());
							else
								setWebJump("新闻", showDesnews.get(pageCount * 5 - 3).getUrl());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		NoticeThreeTitleLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		NoticeThreeTitleLabel.setBounds(56, 272, 550, 15);
		HomePagePanel.add(NoticeThreeTitleLabel);
		NoticeFourTitleLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if(NoticeOrNewsFlag==0)
								setWebJump("通知", showDesnotices.get(pageCount * 5 - 2).getUrl());
							else
								setWebJump("新闻", showDesnews.get(pageCount * 5 - 2).getUrl());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		NoticeFourTitleLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		NoticeFourTitleLabel.setBounds(56, 320, 550, 15);
		HomePagePanel.add(NoticeFourTitleLabel);
		NoticeFiveTitleLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if(NoticeOrNewsFlag==0)
								setWebJump("通知", showDesnotices.get(pageCount * 5 - 1).getUrl());
							else
								setWebJump("新闻", showDesnews.get(pageCount * 5 - 1).getUrl());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		NoticeFiveTitleLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		NoticeFiveTitleLabel.setBounds(56, 366, 550, 15);
		HomePagePanel.add(NoticeFiveTitleLabel);

		NoticeOneSourceLabel.setBounds(620, 191, 140, 15);
		HomePagePanel.add(NoticeOneSourceLabel);

		NoticeOneTimeLabel.setBounds(760, 191, 90, 15);
		HomePagePanel.add(NoticeOneTimeLabel);

		NoticeTwoSourceLabel.setBounds(620, 230, 140, 15);
		HomePagePanel.add(NoticeTwoSourceLabel);

		NoticeThreeSourceLabel.setBounds(620, 273, 140, 15);
		HomePagePanel.add(NoticeThreeSourceLabel);

		NoticeFourSourceLabel.setBounds(620, 321, 140, 15);
		HomePagePanel.add(NoticeFourSourceLabel);

		NoticeFiveSourceLabel.setBounds(620, 367, 140, 15);
		HomePagePanel.add(NoticeFiveSourceLabel);

		NoticeTwoTimeLabel.setBounds(760, 230, 90, 15);
		HomePagePanel.add(NoticeTwoTimeLabel);

		NoticeThreeTimeLabel.setBounds(760, 273, 90, 15);
		HomePagePanel.add(NoticeThreeTimeLabel);

		NoticeFourTimeLabel.setBounds(760, 321, 90, 15);
		HomePagePanel.add(NoticeFourTimeLabel);

		NoticeFiveTimeLabel.setBounds(760, 367, 90, 15);
		HomePagePanel.add(NoticeFiveTimeLabel);
		UpPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (pageCount == 1)
					log.info("这已经是第一页了");
				else {
					pageCount--;
					showNoticeOrNew((pageCount - 1) * 5);
					PageCountLabel.setText("" + pageCount);
				}
			}
		});

		UpPageButton.setBounds(46, 414, 93, 23);
		HomePagePanel.add(UpPageButton);

		lblNewLabel.setBounds(149, 418, 93, 15);
		HomePagePanel.add(lblNewLabel);

		PageCountLabel.setBounds(250, 418, 40, 15);
		HomePagePanel.add(PageCountLabel);

		TotalPageCountOneLabel.setBounds(280, 418, 40, 15);
		HomePagePanel.add(TotalPageCountOneLabel);

		TotalPageCountLabel.setBounds(320, 418, 54, 15);
		HomePagePanel.add(TotalPageCountLabel);

		TotalPageTwoLabel.setBounds(380, 418, 25, 15);
		HomePagePanel.add(TotalPageTwoLabel);
		DownPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// 最大页码
				if (pageCount == maxpageCount)
					log.info("这已经是最后一页了");
				else {
					pageCount++;
					showNoticeOrNew((pageCount - 1) * 5);
					PageCountLabel.setText("" + pageCount);
				}
			}
		});

		DownPageButton.setBounds(400, 414, 93, 23);
		HomePagePanel.add(DownPageButton);

		PageChangTextField.setBounds(597, 415, 66, 21);
		HomePagePanel.add(PageChangTextField);
		PageChangTextField.setColumns(10);
		PageChangeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String pagechangestring = PageChangTextField.getText();
				pageCount = Integer.valueOf(pagechangestring).intValue();
				showNoticeOrNew((pageCount - 1) * 5);
				PageCountLabel.setText("" + pageCount);
				PageChangTextField.setText("");
			}
		});

		PageChangeButton.setBounds(673, 414, 93, 23);
		HomePagePanel.add(PageChangeButton);

		lblNewLabel_1.setBounds(529, 418, 67, 15);
		HomePagePanel.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(14, 97, 856, 2);
		HomePagePanel.add(separator);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(14, 150, 852, 295);

		HomePagePanel.add(separator_1);
		separator_3.setBounds(14, 150, 852, 2);

		HomePagePanel.add(separator_3);
		separator_4.setBounds(14, 445, 852, 2);

		HomePagePanel.add(separator_4);
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(870, 150, 1, 297);

		HomePagePanel.add(separator_5);
		XLNewsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				// 显示
				pageCount = 1;
				NoticeOrNewsFlag = 2;
				if(XLFlag==0) {
					XLFlag=1;
					XLNewsButton.setSelected(true);
				}
				else {
					XLFlag=0;
					XLNewsButton.setSelected(false);
				}
				try {
					if(XLFalse())
						log.error("没有所选项");
					else
						showNoticeOrNew((pageCount - 1) * 5);
				} catch (Exception e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
				HomePagePanel.remove(CollegeBox);
				HomePagePanel.updateUI();

				// 新加上下文
				NewsBox.setModel(new DefaultComboBoxModel(new String[] { "全部", "热点", "国内", "国际", "军事", "文化" }));
				NewsBox.setBounds(670, 158, 84, 21);
				HomePagePanel.add(NewsBox);

				// 新加更新按钮
				updateNewsButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							NewsOperater Newsoperater = new NewsOperater();
							UpdateNews();
							setShowNews();
							showNoticeOrNew((pageCount - 1) * 5);
							HomePagePanel.updateUI();
						} catch (FileNotFoundException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						} catch (IOException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						} catch (Exception e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
				});
				// 添加按钮
				updateNewsButton.setBounds(770, 157, 93, 23);
				HomePagePanel.add(updateNewsButton);

				// 点击事件
				NewsBox.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						// 如果选中了一个
						if (e.getStateChange() == ItemEvent.SELECTED) {
							// 这里写你的任务 ，比如取到现在的值
							String text = (String) NewsBox.getSelectedItem();
							// System.out.println(text);
							if (text == "全部") {
								NewsFlag = 1;
								pageCount = 1;
								PageCountLabel.setText("" + pageCount);
								try {
									setShowNews();
									showNoticeOrNew((pageCount-1)*5);
								} catch (Exception e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								}
								maxpageCount = showDesnews.size() / 5;
								TotalPageCountLabel.setText("" + showDesnews.size() / 5);
							} else if (text == "热点") {
								NewsFlag = 2;
								pageCount = 1;
								PageCountLabel.setText("" + pageCount);
								try {
									setShowNews();
									showNoticeOrNew((pageCount-1)*5);
								} catch (Exception e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								}
								maxpageCount = showDesnews.size() / 5;
								TotalPageCountLabel.setText("" + showDesnews.size() / 5);
							} else if (text == "国内") {
								NewsFlag = 3;
								pageCount = 1;
								PageCountLabel.setText("" + pageCount);
								try {
									setShowNews();
									showNoticeOrNew((pageCount-1)*5);
								} catch (Exception e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								}
							} else if (text == "国际") {
								NewsFlag = 4;
								pageCount = 1;
								PageCountLabel.setText("" + pageCount);
								try {
									setShowNews();
									showNoticeOrNew((pageCount-1)*5);
								} catch (Exception e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								}
							} else if (text == "军事") {
								NewsFlag = 5;
								pageCount = 1;
								try {
									setShowNews();
									showNoticeOrNew((pageCount-1)*5);
								} catch (Exception e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								}
							} else {// 文化
								NewsFlag = 6;
								pageCount = 1;
								try {
									setShowNews();
									showNoticeOrNew((pageCount-1)*5);
								} catch (Exception e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								}
							}
						}
					}
				});
				
				SchoolNoticeButton.setSelected(false);
				CollegeNoticeButton.setSelected(false);
				AdministrationNoticeButton.setSelected(false);
				EmploymentNoticeButton.setSelected(false);
				SchoolNoticeFlag=0;
				CollegeNoticeFlag=0;
				JyNoticeFlag=0;
				JwcNoticeFlag=0;
				HomePagePanel.updateUI();
			}
		});


		XLNewsButton.setFont(new Font("宋体", Font.PLAIN, 14));
		XLNewsButton.setBounds(454, 157, 93, 23);
		HomePagePanel.add(XLNewsButton);

		


	}
	


	//以下是新的
	//判断需要显示的是通知还是新闻
	public void showNoticeOrNew(int begin) {
		if(NoticeOrNewsFlag==0) {
			
			setNotice(begin);
			PageCountLabel.setText("" + pageCount);
			maxpageCount = showDesnotices.size() / 5;
			TotalPageCountLabel.setText("" + showDesnotices.size() / 5);
		}
		else {
			setNews(begin);
			PageCountLabel.setText("" + pageCount);
			maxpageCount = showDesnews.size() / 5;
			TotalPageCountLabel.setText("" + showDesnews.size() / 5);
		}
	}
	
	//页面跳转
	
	public void setWebJump(String title,String url) {
		try {
			JFrame frame = new JFrame(title);
			// 设置窗体关闭的时候不关闭应用程序
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().add(new Web(url), BorderLayout.CENTER);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setLocationByPlatform(true);
			// 让窗体可见
			frame.setVisible(true);
			// 重置窗体大小
			frame.setResizable(true);
			// 设置窗体的宽度、高度
			frame.setSize(700, 500);
			// 设置窗体居中显示
			frame.setLocationRelativeTo(frame.getOwner());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//初始化全部通知
	
	public void setAllNotice() {
		for(int index=0;index<schoolDesnotices.size();index++)
			showDesnotices.add(schoolDesnotices.get(index));
		for(int index=0;index<RWcollegeDesnotices.size();index++)
			showDesnotices.add(RWcollegeDesnotices.get(index));
		for(int index=0;index<GJScollegeDesnotices.size();index++)
			showDesnotices.add(GJScollegeDesnotices.get(index));
		for(int index=0;index<FYcollegeDesnotices.size();index++)
			showDesnotices.add(FYcollegeDesnotices.get(index));
		for(int index=0;index<JwcDesnotices.size();index++)
			showDesnotices.add(JwcDesnotices.get(index));
		for(int index=0;index<JyDesnotices.size();index++)
			showDesnotices.add(JyDesnotices.get(index));
	}
	
	
	//初试化全部新闻
	public void setAllNews() {
		showDesnews=Desnews;
	}
	
	//通知的显示
	public void setNotice(int begin) {
		Collections.sort(showDesnotices,new Notice.publishtimeComparator());
		NoticeOneTitleLabel.setText(showDesnotices.get(begin).getTitle());
		NoticeOneTimeLabel.setText(showDesnotices.get(begin).getTime());
		NoticeOneSourceLabel.setText(showDesnotices.get(begin).getSource());
		NoticeTwoTitleLabel.setText(showDesnotices.get(begin + 1).getTitle());
		NoticeTwoTimeLabel.setText(showDesnotices.get(begin + 1).getTime());
		NoticeTwoSourceLabel.setText(showDesnotices.get(begin + 1).getSource());
		NoticeThreeTitleLabel.setText(showDesnotices.get(begin + 2).getTitle());
		NoticeThreeTimeLabel.setText(showDesnotices.get(begin + 2).getTime());
		NoticeThreeSourceLabel.setText(showDesnotices.get(begin + 2).getSource());
		NoticeFourTitleLabel.setText(showDesnotices.get(begin + 3).getTitle());
		NoticeFourTimeLabel.setText(showDesnotices.get(begin + 3).getTime());
		NoticeFourSourceLabel.setText(showDesnotices.get(begin + 3).getSource());
		NoticeFiveTitleLabel.setText(showDesnotices.get(begin + 4).getTitle());
		NoticeFiveTimeLabel.setText(showDesnotices.get(begin + 4).getTime());
		NoticeFiveSourceLabel.setText(showDesnotices.get(begin + 4).getSource());
		HomePagePanel.updateUI();
	}

	//新闻的显示
	
	public void setNews(int begin) {
		Collections.sort(showDesnews,new News.titleComparator());
		NoticeOneTitleLabel.setText(showDesnews.get(begin).getTitle());
		NoticeOneTimeLabel.setText(showDesnews.get(begin).getTime());
		NoticeOneSourceLabel.setText(showDesnews.get(begin).getSource());
		NoticeTwoTitleLabel.setText(showDesnews.get(begin + 1).getTitle());
		NoticeTwoTimeLabel.setText(showDesnews.get(begin + 1).getTime());
		NoticeTwoSourceLabel.setText(showDesnews.get(begin + 1).getSource());
		NoticeThreeTitleLabel.setText(showDesnews.get(begin + 2).getTitle());
		NoticeThreeTimeLabel.setText(showDesnews.get(begin + 2).getTime());
		NoticeThreeSourceLabel.setText(showDesnews.get(begin + 2).getSource());
		NoticeFourTitleLabel.setText(showDesnews.get(begin + 3).getTitle());
		NoticeFourTimeLabel.setText(showDesnews.get(begin + 3).getTime());
		NoticeFourSourceLabel.setText(showDesnews.get(begin + 3).getSource());
		NoticeFiveTitleLabel.setText(showDesnews.get(begin + 4).getTitle());
		NoticeFiveTimeLabel.setText(showDesnews.get(begin + 4).getTime());
		NoticeFiveSourceLabel.setText(showDesnews.get(begin + 4).getSource());
		HomePagePanel.updateUI();
	}
	
	//设置需要显示的通知
	
	public void setShowNotice() {
		showDesnotices=new ArrayList<Notice>();
		if(SchoolNoticeFlag==1) {
			for(int index=0;index<schoolDesnotices.size();index++)
				showDesnotices.add(schoolDesnotices.get(index));
		}
		if(CollegeNoticeFlag==1) {
			for(int index=0;index<RWcollegeDesnotices.size();index++)
				showDesnotices.add(RWcollegeDesnotices.get(index));
		}
		if(CollegeNoticeFlag==2) {
			for(int index=0;index<FYcollegeDesnotices.size();index++)
				showDesnotices.add(FYcollegeDesnotices.get(index));
		}
		if(CollegeNoticeFlag==3) {
			for(int index=0;index<GJScollegeDesnotices.size();index++)
				showDesnotices.add(GJScollegeDesnotices.get(index));
		}
		if(JwcNoticeFlag==1) {
			for(int index=0;index<JwcDesnotices.size();index++)
				showDesnotices.add(JwcDesnotices.get(index));
		}
		if(JyNoticeFlag==1) {
			for(int index=0;index<JyDesnotices.size();index++)
				showDesnotices.add(JyDesnotices.get(index));
		}
			
	}
	
	//设置要显示的新闻
	
	public void setShowNews()throws Exception, FileNotFoundException, IOException {
		showDesnews=new ArrayList<News>();
		Desnews = newsoperater.load(newspath);
		RD_Desnews = newsoperater.load(RDnewspath);
		GN_Desnews = newsoperater.load(GNnewspath);
		GW_Desnews = newsoperater.load(GWnewspath);
		JS_Desnews = newsoperater.load(JSnewspath);
		WH_Desnews = newsoperater.load(WHnewspath);

		if (NewsFlag == 1)
			showDesnews = newsoperater.load(newspath);
		else if (NewsFlag == 2)
			showDesnews = RD_Desnews;
		else if (NewsFlag == 3)
			showDesnews = GN_Desnews;
		else if (NewsFlag == 4)
			showDesnews = GW_Desnews;
		else if (NewsFlag == 5)
			showDesnews = JS_Desnews;
		else
			showDesnews = WH_Desnews;

	}


	//如果没有选中通知的按钮，则显示全部通知
	
	public boolean AllFlase() {
		if(SchoolNoticeFlag==0&&CollegeNoticeFlag==0&&JyNoticeFlag==0&&JwcNoticeFlag==0) {
			return true;
		}
		else
			return false;
	}

	//如果没有选中新浪新闻，则显示所有新闻
	
	public boolean XLFalse() {
		if(XLFlag==0)
			return true;
		else
			return false;
	}
}


