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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.jnu.groupproject.noticeclass.CollegeNotice;
import com.jnu.groupproject.noticeclass.CollegeNoticeOperater;
import com.jnu.groupproject.noticeclass.DianFeiQuery;
import com.jnu.groupproject.noticeclass.JwcNotice;
import com.jnu.groupproject.noticeclass.JwcNoticeOperater;
import com.jnu.groupproject.noticeclass.JyNotice;
import com.jnu.groupproject.noticeclass.JyNoticeOperater;
import com.jnu.groupproject.noticeclass.NoticeSerializeOperater;
import com.jnu.groupproject.noticeclass.SchoolCardQuery;
import com.jnu.groupproject.noticeclass.SchoolNotice;
import com.jnu.groupproject.noticeclass.SchoolNoticeOperater;
import com.jnu.groupproject.noticeclass.Web;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class PanelHomePage extends JPanel {
	
	//空间组
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JPanel HomePagePanel = new JPanel();
    //private Logger log = Logger.getLogger(PanelUserInfo.class);  
    
   //全局变量
  	int pageCount=1;
  	static int NoticeFlag=1;
  	
  	//设置路径
  	static String schoolnoticepath="./src/com/jnu/groupproject/data/schoolnotice.dat";
  	static String collegenoticepath="./src/com/jnu/groupproject/data/collegenotice.dat";
  	static String Jwcnoticepath="./src/com/jnu/groupproject/data/Jwcnotice.dat";
  	static String Jynoticepath="./src/com/jnu/groupproject/data/Jynotice.dat";
  	
  	//通知序列化
  	ArrayList<SchoolNotice> schoolnoticeList=new ArrayList<SchoolNotice>();
  	ArrayList<SchoolNotice> SchoolNoticeDesnotices=new ArrayList<SchoolNotice>();
  	ArrayList<CollegeNotice> collegenoticeList=new ArrayList<CollegeNotice>();
  	ArrayList<CollegeNotice> CollegeNoticeDesnotices=new ArrayList<CollegeNotice>();
  	ArrayList<JwcNotice> JwcnoticeList=new ArrayList<JwcNotice>();
  	ArrayList<JwcNotice> JwcNoticeDesnotices=new ArrayList<JwcNotice>();
  	ArrayList<JyNotice> noticeList=new ArrayList<JyNotice>();
  	ArrayList<JyNotice> JyNoticeDesnotices=new ArrayList<JyNotice>();//反序列化
  	//工具类
  	static NoticeSerializeOperater<SchoolNotice> schoolnoticeoperater=new NoticeSerializeOperater<SchoolNotice>();
  	static NoticeSerializeOperater<CollegeNotice> collegenoticeoperater=new NoticeSerializeOperater<CollegeNotice>();
  	static NoticeSerializeOperater<JwcNotice> Jwcnoticeoperater=new NoticeSerializeOperater<JwcNotice>();
  	static NoticeSerializeOperater<JyNotice> Jynoticeoperater=new NoticeSerializeOperater<JyNotice>();
  	static ArrayList<SchoolNotice> schoolDesnotices;
  	static ArrayList<CollegeNotice> collegeDesnotices;
  	static ArrayList<JwcNotice> JwcDesnotices;
  	static ArrayList<JyNotice> JyDesnotices;
    public JButton ElectricityChargeRecordButton=new JButton();
    public JLabel ElectricityFeesBalanceLabel=new JLabel();
    public JButton ElectricityQueryButton=new JButton() ;
    public JTextField PageChangTextField=new JTextField();
    public JLabel label = new JLabel("全部通知");
    public JRadioButton SchoolNoticeButton = new JRadioButton("校内通知");
    public JRadioButton CollegeNoticeButton = new JRadioButton("学院通知");
    public JRadioButton AdministrationNoticeButton = new JRadioButton("教务处通知");
    public JRadioButton EmploymentNoticeButton = new JRadioButton("就业通知");
    public JLabel RelativeInformationLabel = new JLabel("个人相关信息");
    //public JLabel SchoolForumLabel=new JLabel("学校论坛");
    public JLabel SchoolForumLabel=new JLabel();
    public JLabel SchoolCardLabel = new JLabel("一卡通");
    public JLabel ElectricityFeesLabel = new JLabel("电  费");
    public JLabel SchhoForumLabel=new JLabel("学校论坛");
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
    private final JSeparator separator_1 = new JSeparator();
    private final JSeparator separator_3 = new JSeparator();
    private final JSeparator separator_4 = new JSeparator();
    private final JSeparator separator_5 = new JSeparator();
    

	public PanelHomePage()throws Exception,FileNotFoundException,IOException {
		//PropertyConfigurator.configure("log4j.properties");
		setLayout(null);
		
		
		//首先规定用户信息的路径（需要用到用户信息的界面都要引入该语句）
		FileHelper fh=new FileHelper("./userinfo.txt");
		//读取个人信息代码
		Person person=fh.getObjFromFile();
		
		
		HomePagePanel.setBounds(0, 13, 880, 460);
		add(HomePagePanel);
		HomePagePanel.setLayout(null);
		
		
		
		label.setBounds(36, 111, 93, 40);
		label.setFont(new Font("宋体", Font.BOLD, 22));
		HomePagePanel.add(label);
		
		
		SchoolNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		SchoolNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pageCount=1;
				NoticeFlag=1;
				PageCountLabel.setText(""+pageCount);
				setSchoolNotice((pageCount-1)*5);
				TotalPageCountLabel.setText(""+schoolDesnotices.size()/5);
				HomePagePanel.updateUI();
			}
		});
		SchoolNoticeButton.setBounds(46, 157, 93, 23);
		buttonGroup.add(SchoolNoticeButton);
		HomePagePanel.add(SchoolNoticeButton);
		
		
		CollegeNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		CollegeNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pageCount=1;
				NoticeFlag=2;
				PageCountLabel.setText(""+pageCount);
				setCollegeNotice((pageCount-1)*5);
				TotalPageCountLabel.setText(""+collegeDesnotices.size()/5);
				HomePagePanel.updateUI();
			}
		});
		CollegeNoticeButton.setBounds(149, 157, 93, 23);
		buttonGroup.add(CollegeNoticeButton);
		HomePagePanel.add(CollegeNoticeButton);
		

		AdministrationNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		AdministrationNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pageCount=1;
				NoticeFlag=3;
				PageCountLabel.setText(""+pageCount);
				setJwcNotice((pageCount-1)*5);
				TotalPageCountLabel.setText(""+JwcDesnotices.size()/5);
				HomePagePanel.updateUI();
			}
		});
		AdministrationNoticeButton.setBounds(254, 157, 106, 23);
		buttonGroup.add(AdministrationNoticeButton);
		HomePagePanel.add(AdministrationNoticeButton);
		

		EmploymentNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		EmploymentNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pageCount=1;
				NoticeFlag=4;
				PageCountLabel.setText(""+pageCount);
				setJyNotice((pageCount-1)*5);
				TotalPageCountLabel.setText(""+JyDesnotices.size()/5);
				HomePagePanel.updateUI();
			}
		});
		EmploymentNoticeButton.setBounds(362, 157, 93, 23);
		buttonGroup.add(EmploymentNoticeButton);
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
					public void run(){
					try {    
						JFrame frame = new JFrame("学校论坛");
		                //设置窗体关闭的时候不关闭应用程序
		                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                frame.getContentPane().add(new Web("http://bbs.jnlts.com/"), BorderLayout.CENTER);
		                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		                frame.setLocationByPlatform(true);
		                //让窗体可见
		                frame.setVisible(true);
		                //重置窗体大小
		                frame.setResizable(true);
		                // 设置窗体的宽度、高度
		                frame.setSize(700,500);
		                // 设置窗体居中显示
		                frame.setLocationRelativeTo(frame.getOwner());
					} catch (Exception e) {
						e.printStackTrace();
						}
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
		SchoolCardQueryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		

		SchoolCardQueryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//这里要关联用户信息
				String account,password;
				account=""+person.getNum();
				password=""+person.getCard();
				SchoolCardQuery schoolcard=new SchoolCardQuery(account,password);
				SchoolCardBalanceLabel.setText("饭卡余额："+schoolcard.getQueryResult());
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
		                //设置窗体关闭的时候不关闭应用程序
		                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                frame.getContentPane().add(new Web("https://card.jnu.edu.cn/pages/common/homeLogin.action"), BorderLayout.CENTER);
		                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		                frame.setLocationByPlatform(true);
		                //让窗体可见
		                frame.setVisible(true);
		                //重置窗体大小
		                frame.setResizable(true);
		                // 设置窗体的宽度、高度
		                frame.setSize(700,500);
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
					//这里需要关联用户信息
					String roomaccount;
					roomaccount=""+person.getRoom();
					DianFeiQuery dianFei=new DianFeiQuery(roomaccount);
					ElectricityFeesBalanceLabel.setText("剩余电量："+dianFei.getQueryResult());
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
		                //设置窗体关闭的时候不关闭应用程序
		                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                frame.getContentPane().add(new Web("http://202.116.25.12/Login.aspx"), BorderLayout.CENTER);
		                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		                frame.setLocationByPlatform(true);
		                //让窗体可见
		                frame.setVisible(true);
		                //重置窗体大小
		                frame.setResizable(true);
		                // 设置窗体的宽度、高度
		                frame.setSize(700,500);
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
		UpdataAllNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					SchoolNoticeOperater schoolnoticeoperater=new SchoolNoticeOperater();
					CollegeNoticeOperater collegenoticeoperater=new CollegeNoticeOperater();
					JwcNoticeOperater Jwcnoticeoperater=new JwcNoticeOperater();
					JyNoticeOperater Jynoticeoperater=new JyNoticeOperater();
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
					SchoolNoticeOperater schoolnoticeoperater=new SchoolNoticeOperater();
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
					CollegeNoticeOperater collegenoticeoperater=new CollegeNoticeOperater();
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
		UpdateJwcNoticeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		UpdateJwcNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					JwcNoticeOperater Jwcnoticeoperater=new JwcNoticeOperater();
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
					JyNoticeOperater Jynoticeoperater=new JyNoticeOperater();
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
					public void run(){
					try {    
						JFrame frame = new JFrame("通知");
		                //设置窗体关闭的时候不关闭应用程序
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						 if(NoticeFlag==1) 
								frame.getContentPane().add(new Web(schoolDesnotices.get(pageCount*5-5).getUrl()), BorderLayout.CENTER);
							else if(NoticeFlag==2) 
								frame.getContentPane().add(new Web(collegeDesnotices.get(pageCount*5-5).getUrl()), BorderLayout.CENTER);
							else if(NoticeFlag==3) 
								frame.getContentPane().add(new Web(JwcDesnotices.get(pageCount*5-5).getUrl()), BorderLayout.CENTER);
							else 
								frame.getContentPane().add(new Web(JyDesnotices.get(pageCount*5-5).getUrl()), BorderLayout.CENTER);
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frame.setLocationByPlatform(true);
		                //让窗体可见
						frame.setVisible(true);
		                //重置窗体大小
						frame.setResizable(true);
		                // 设置窗体的宽度、高度
						frame.setSize(700,500);
		                // 设置窗体居中显示
						frame.setLocationRelativeTo(frame.getOwner());
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
					public void run(){
					try {    
						JFrame frame = new JFrame("通知");
		                //设置窗体关闭的时候不关闭应用程序
		                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                if(NoticeFlag==1) 
							frame.getContentPane().add(new Web(schoolDesnotices.get(pageCount*5-4).getUrl()), BorderLayout.CENTER);
						else if(NoticeFlag==2) 
							frame.getContentPane().add(new Web(collegeDesnotices.get(pageCount*5-4).getUrl()), BorderLayout.CENTER);
						else if(NoticeFlag==3) 
							frame.getContentPane().add(new Web(JwcDesnotices.get(pageCount*5-4).getUrl()), BorderLayout.CENTER);
						else 
							frame.getContentPane().add(new Web(JyDesnotices.get(pageCount*5-4).getUrl()), BorderLayout.CENTER);
		                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		                frame.setLocationByPlatform(true);
		                //让窗体可见
		                frame.setVisible(true);
		                //重置窗体大小
		                frame.setResizable(true);
		                // 设置窗体的宽度、高度
		                frame.setSize(700,500);
		                // 设置窗体居中显示
		                frame.setLocationRelativeTo(frame.getOwner());
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
					public void run(){
					try {    
						JFrame frame = new JFrame("通知");
		                //设置窗体关闭的时候不关闭应用程序
		                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                if(NoticeFlag==1) 
							frame.getContentPane().add(new Web(schoolDesnotices.get(pageCount*5-3).getUrl()), BorderLayout.CENTER);
						else if(NoticeFlag==2) 
							frame.getContentPane().add(new Web(collegeDesnotices.get(pageCount*5-3).getUrl()), BorderLayout.CENTER);
						else if(NoticeFlag==3) 
							frame.getContentPane().add(new Web(JwcDesnotices.get(pageCount*5-3).getUrl()), BorderLayout.CENTER);
						else 
							frame.getContentPane().add(new Web(JyDesnotices.get(pageCount*5-3).getUrl()), BorderLayout.CENTER);
		                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		                frame.setLocationByPlatform(true);
		                //让窗体可见
		                frame.setVisible(true);
		                //重置窗体大小
		                frame.setResizable(true);
		                // 设置窗体的宽度、高度
		                frame.setSize(700,500);
		                // 设置窗体居中显示
		                frame.setLocationRelativeTo(frame.getOwner());
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
					public void run(){
					try {    
						JFrame frame = new JFrame("通知");
		                //设置窗体关闭的时候不关闭应用程序
		                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                if(NoticeFlag==1) 
							frame.getContentPane().add(new Web(schoolDesnotices.get(pageCount*5-2).getUrl()), BorderLayout.CENTER);
						else if(NoticeFlag==2) 
							frame.getContentPane().add(new Web(collegeDesnotices.get(pageCount*5-2).getUrl()), BorderLayout.CENTER);
						else if(NoticeFlag==3) 
							frame.getContentPane().add(new Web(JwcDesnotices.get(pageCount*5-2).getUrl()), BorderLayout.CENTER);
						else 
							frame.getContentPane().add(new Web(JyDesnotices.get(pageCount*5-2).getUrl()), BorderLayout.CENTER);
		                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		                frame.setLocationByPlatform(true);
		                //让窗体可见
		                frame.setVisible(true);
		                //重置窗体大小
		                frame.setResizable(true);
		                // 设置窗体的宽度、高度
		                frame.setSize(700,500);
		                // 设置窗体居中显示
		                frame.setLocationRelativeTo(frame.getOwner());
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
					public void run(){
					try {    
						JFrame frame = new JFrame("通知");
		                //设置窗体关闭的时候不关闭应用程序
		                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                if(NoticeFlag==1) 
							frame.getContentPane().add(new Web(schoolDesnotices.get(pageCount*5-1).getUrl()), BorderLayout.CENTER);
						else if(NoticeFlag==2) 
							frame.getContentPane().add(new Web(collegeDesnotices.get(pageCount*5-1).getUrl()), BorderLayout.CENTER);
						else if(NoticeFlag==3) 
							frame.getContentPane().add(new Web(JwcDesnotices.get(pageCount*5-1).getUrl()), BorderLayout.CENTER);
						else 
							frame.getContentPane().add(new Web(JyDesnotices.get(pageCount*5-1).getUrl()), BorderLayout.CENTER);
		                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		                frame.setLocationByPlatform(true);
		                //让窗体可见
		                frame.setVisible(true);
		                //重置窗体大小
		                frame.setResizable(true);
		                // 设置窗体的宽度、高度
		                frame.setSize(700,500);
		                // 设置窗体居中显示
		                frame.setLocationRelativeTo(frame.getOwner());
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
				pageCount--;
				showNotice((pageCount-1)*5);
				PageCountLabel.setText(""+pageCount);
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
				pageCount++;
				showNotice((pageCount-1)*5);
				PageCountLabel.setText(""+pageCount);
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
				String pagechangestring=PageChangTextField.getText();
				pageCount=Integer.valueOf(pagechangestring).intValue();
				showNotice((pageCount-1)*5);
				PageCountLabel.setText(""+pageCount);
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
		
		
		
		schoolDesnotices=schoolnoticeoperater.load(schoolnoticepath);
		collegeDesnotices=collegenoticeoperater.load(collegenoticepath);
		JwcDesnotices=Jwcnoticeoperater.load(Jwcnoticepath);
		JyDesnotices=Jynoticeoperater.load(Jynoticepath);
		
		//初始化
		showNotice(0);
		

	}
	
	public void showNotice(int begin) {
		//1为校内通知
		if(NoticeFlag==1) {
			setSchoolNotice(begin);
			PageCountLabel.setText(""+pageCount);
			TotalPageCountLabel.setText(""+schoolDesnotices.size()/5);
		}else if(NoticeFlag==2) {
			setCollegeNotice(begin);
			PageCountLabel.setText(""+pageCount);
			TotalPageCountLabel.setText(""+collegeDesnotices.size()/5);
		}else if(NoticeFlag==3) {
			setJwcNotice(begin);
			PageCountLabel.setText(""+pageCount);
			TotalPageCountLabel.setText(""+JwcDesnotices.size()/5);
		}else if(NoticeFlag==4) {
			setJyNotice(begin);
			PageCountLabel.setText(""+pageCount);
			TotalPageCountLabel.setText(""+JyDesnotices.size()/5);
		}
	}
	
	public  void setSchoolNotice(int begin) {
		NoticeOneTitleLabel.setText(schoolDesnotices.get(begin).getTitle());
		NoticeOneTimeLabel.setText(schoolDesnotices.get(begin).getTime());
		NoticeOneSourceLabel.setText(schoolDesnotices.get(begin).getSource());
		NoticeTwoTitleLabel.setText(schoolDesnotices.get(begin+1).getTitle());
		NoticeTwoTimeLabel.setText(schoolDesnotices.get(begin+1).getTime());
		NoticeTwoSourceLabel.setText(schoolDesnotices.get(begin+1).getSource());
		NoticeThreeTitleLabel.setText(schoolDesnotices.get(begin+2).getTitle());
		NoticeThreeTimeLabel.setText(schoolDesnotices.get(begin+2).getTime());
		NoticeThreeSourceLabel.setText(schoolDesnotices.get(begin+2).getSource());
		NoticeFourTitleLabel.setText(schoolDesnotices.get(begin+3).getTitle());
		NoticeFourTimeLabel.setText(schoolDesnotices.get(begin+3).getTime());
		NoticeFourSourceLabel.setText(schoolDesnotices.get(begin+3).getSource());
		NoticeFiveTitleLabel.setText(schoolDesnotices.get(begin+4).getTitle());
		NoticeFiveTimeLabel.setText(schoolDesnotices.get(begin+4).getTime());
		NoticeFiveSourceLabel.setText(schoolDesnotices.get(begin+4).getSource());
		HomePagePanel.updateUI();
	}
	
	public  void setCollegeNotice(int begin) {
		NoticeOneTitleLabel.setText(collegeDesnotices.get(begin).getTitle());
		NoticeOneTimeLabel.setText(collegeDesnotices.get(begin).getTime());
		NoticeOneSourceLabel.setText(collegeDesnotices.get(begin).getSource());
		NoticeTwoTitleLabel.setText(collegeDesnotices.get(begin+1).getTitle());
		NoticeTwoTimeLabel.setText(collegeDesnotices.get(begin+1).getTime());
		NoticeTwoSourceLabel.setText(collegeDesnotices.get(begin+1).getSource());
		NoticeThreeTitleLabel.setText(collegeDesnotices.get(begin+2).getTitle());
		NoticeThreeTimeLabel.setText(collegeDesnotices.get(begin+2).getTime());
		NoticeThreeSourceLabel.setText(collegeDesnotices.get(begin+2).getSource());
		NoticeFourTitleLabel.setText(collegeDesnotices.get(begin+3).getTitle());
		NoticeFourTimeLabel.setText(collegeDesnotices.get(begin+3).getTime());
		NoticeFourSourceLabel.setText(collegeDesnotices.get(begin+3).getSource());
		NoticeFiveTitleLabel.setText(collegeDesnotices.get(begin+4).getTitle());
		NoticeFiveTimeLabel.setText(collegeDesnotices.get(begin+4).getTime());
		NoticeFiveSourceLabel.setText(collegeDesnotices.get(begin+4).getSource());
		HomePagePanel.updateUI();
	}
	
	
	public  void setJwcNotice(int begin) {
		NoticeOneTitleLabel.setText(JwcDesnotices.get(begin).getTitle());
		NoticeOneTimeLabel.setText(JwcDesnotices.get(begin).getTime());
		NoticeOneSourceLabel.setText(JwcDesnotices.get(begin).getSource());
		NoticeTwoTitleLabel.setText(JwcDesnotices.get(begin+1).getTitle());
		NoticeTwoTimeLabel.setText(JwcDesnotices.get(begin+1).getTime());
		NoticeTwoSourceLabel.setText(JwcDesnotices.get(begin+1).getSource());
		NoticeThreeTitleLabel.setText(JwcDesnotices.get(begin+2).getTitle());
		NoticeThreeTimeLabel.setText(JwcDesnotices.get(begin+2).getTime());
		NoticeThreeSourceLabel.setText(JwcDesnotices.get(begin+2).getSource());
		NoticeFourTitleLabel.setText(JwcDesnotices.get(begin+3).getTitle());
		NoticeFourTimeLabel.setText(JwcDesnotices.get(begin+3).getTime());
		NoticeFourSourceLabel.setText(JwcDesnotices.get(begin+3).getSource());
		NoticeFiveTitleLabel.setText(JwcDesnotices.get(begin+4).getTitle());
		NoticeFiveTimeLabel.setText(JwcDesnotices.get(begin+4).getTime());
		NoticeFiveSourceLabel.setText(JwcDesnotices.get(begin+4).getSource());
		HomePagePanel.updateUI();
	}
	
	public  void setJyNotice(int begin) {
		NoticeOneTitleLabel.setText(JyDesnotices.get(begin).getTitle());
		NoticeOneTimeLabel.setText(JyDesnotices.get(begin).getTime());
		NoticeOneSourceLabel.setText(JyDesnotices.get(begin).getSource());
		NoticeTwoTitleLabel.setText(JyDesnotices.get(begin+1).getTitle());
		NoticeTwoTimeLabel.setText(JyDesnotices.get(begin+1).getTime());
		NoticeTwoSourceLabel.setText(JyDesnotices.get(begin+1).getSource());
		NoticeThreeTitleLabel.setText(JyDesnotices.get(begin+2).getTitle());
		NoticeThreeTimeLabel.setText(JyDesnotices.get(begin+2).getTime());
		NoticeThreeSourceLabel.setText(JyDesnotices.get(begin+2).getSource());
		NoticeFourTitleLabel.setText(JyDesnotices.get(begin+3).getTitle());
		NoticeFourTimeLabel.setText(JyDesnotices.get(begin+3).getTime());
		NoticeFourSourceLabel.setText(JyDesnotices.get(begin+3).getSource());
		NoticeFiveTitleLabel.setText(JyDesnotices.get(begin+4).getTitle());
		NoticeFiveTimeLabel.setText(JyDesnotices.get(begin+4).getTime());
		NoticeFiveSourceLabel.setText(JyDesnotices.get(begin+4).getSource());
		HomePagePanel.updateUI();
	}
}
