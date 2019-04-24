import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class MyDemo {
	
	
	private JFrame frame;
	private JPanel panel_search;
	private JPanel panel_userInfo;
	private JPanel panel_logOut;
	private JTextField textField_courseName;
	private JTable table;
	private JTable trainpan_table;
	private JTextField textField_courseNum;
	private JTextField textField_courseMajor;
	private JTextField textField_courseCollege;
	private JTable table_courseList;
	private JTable table_courseSelected;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JTable table_7;
	private JTable table_8;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_1;
	private JTable table_2;
	
	public JLabel label_logIn = new JLabel("自助管理系统登录");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyDemo window = new MyDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_logIn = new JPanel();
		panel.add(panel_logIn);
		panel_logIn.setLayout(null);
		
		JPanel panel_homePage = new JPanel();
		panel.add(panel_homePage);
		panel_homePage.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(172, 91, 546, 317);
		panel_logIn.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblJnu = new JLabel("JNU");
		lblJnu.setForeground(new Color(30, 144, 255));
		lblJnu.setFont(new Font("宋体", Font.BOLD, 25));
		lblJnu.setBounds(14, 13, 75, 30);
		panel_1.add(lblJnu);
		
		//JLabel label_4 = new JLabel("自助管理系统登录");
		label_logIn.setForeground(SystemColor.controlDkShadow);
		label_logIn.setFont(new Font("宋体", Font.BOLD, 20));
		label_logIn.setBounds(61, 21, 218, 18);
		panel_1.add(label_logIn);
		
		textField = new JTextField();
		textField.setBounds(193, 97, 205, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(193, 149, 205, 24);
		panel_1.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("登录");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_homePage);//刷新
				panel.updateUI();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(122, 221, 276, 30);
		panel_1.add(btnNewButton_1);
		
		JLabel label_5 = new JLabel("账号：");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("宋体", Font.BOLD, 20));
		label_5.setBounds(128, 103, 63, 18);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("密码：");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("宋体", Font.BOLD, 20));
		label_6.setBounds(128, 152, 63, 18);
		panel_1.add(label_6);
		
		
		JPanel panel_AllNotice = new JPanel();
		panel_AllNotice.setBounds(40, 86, 510, 370);
		panel_homePage.add(panel_AllNotice);
		panel_AllNotice.setLayout(null);
		
		JPanel panel_CollegeNotice = new JPanel();
		panel_CollegeNotice.setLayout(null);
		panel_CollegeNotice.setBounds(40, 86, 510, 370);
		panel_homePage.add(panel_CollegeNotice);
		
		JPanel panel_AdministrationNotice = new JPanel();
		panel_AdministrationNotice.setLayout(null);
		panel_AdministrationNotice.setBounds(40, 86, 510, 370);
		panel_homePage.add(panel_AdministrationNotice);
		
		JPanel panel_EmploymentNotice = new JPanel();
		panel_EmploymentNotice.setLayout(null);
		panel_EmploymentNotice.setBounds(40, 86, 510, 370);
		panel_homePage.add(panel_EmploymentNotice);
		
		JPanel panel_SchoolNotice = new JPanel();
		panel_SchoolNotice.setLayout(null);
		panel_SchoolNotice.setBounds(40, 86, 510, 370);
		panel_homePage.add(panel_SchoolNotice);
		
		JLabel label = new JLabel("全部通知");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(40, 40, 80, 30);
		panel_homePage.add(label);
		
		JRadioButton SchoolNotice = new JRadioButton("校内通知");
		SchoolNotice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_homePage);
				panel_SchoolNotice.setVisible(true);
				panel_AllNotice.setVisible(false);
				panel_CollegeNotice.setVisible(false);
				panel_EmploymentNotice.setVisible(false);
				panel_AdministrationNotice.setVisible(false);
				panel.updateUI();
			}
		});
		buttonGroup.add(SchoolNotice);
		SchoolNotice.setBounds(130, 40, 80, 35);
		panel_homePage.add(SchoolNotice);
		
		
		JRadioButton CollegeNotice = new JRadioButton("学院通知");
		CollegeNotice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(panel_homePage);
				panel_SchoolNotice.setVisible(false);
				panel_AllNotice.setVisible(false);
				panel_CollegeNotice.setVisible(true);
				panel_EmploymentNotice.setVisible(false);
				panel_AdministrationNotice.setVisible(false);
				panel.updateUI();
			}
		});
		buttonGroup.add(CollegeNotice);
		CollegeNotice.setBounds(210, 40, 80, 35);
		panel_homePage.add(CollegeNotice);
		
		JRadioButton EmploymentNotice = new JRadioButton("就业通知");
		EmploymentNotice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(panel_homePage);
				panel_SchoolNotice.setVisible(false);
				panel_AllNotice.setVisible(false);
				panel_CollegeNotice.setVisible(false);
				panel_EmploymentNotice.setVisible(true);
				panel_AdministrationNotice.setVisible(false);
				panel.updateUI();
			}
		});
		buttonGroup.add(EmploymentNotice);
		EmploymentNotice.setBounds(389, 40, 80, 35);
		panel_homePage.add(EmploymentNotice);
		
		
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(490, 0, 20, 370);
		panel_AllNotice.add(scrollBar);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u901A\u77E5", "\u53D1\u5E03\u6765\u6E90", "\u53D1\u5E03\u65F6\u95F4"},
				{"\u8FD9\u662F\u5168\u90E8\u901A\u77E5", "1", "1"},
				{"\u8FD9\u662F\u5168\u90E8\u901A\u77E5", "1", null},
			},
			new String[] {
				"\u901A\u77E5", "\u53D1\u5E03\u6765\u6E90", "\u53D1\u5E03\u65F6\u95F4"
			}
		));
		table_3.setBounds(10, 20, 470, 350);
		panel_AllNotice.add(table_3);
		
		JPanel panel_RelativeInformation = new JPanel();
		panel_RelativeInformation.setBounds(580, 40, 290, 231);
		panel_homePage.add(panel_RelativeInformation);
		panel_RelativeInformation.setLayout(null);
		
		JButton btnNewButton = new JButton("充值");
		btnNewButton.setBounds(197, 55, 93, 23);
		panel_RelativeInformation.add(btnNewButton);
		
		JButton button_8 = new JButton("挂失");
		button_8.setBounds(197, 86, 93, 23);
		panel_RelativeInformation.add(button_8);
		
		JButton button_9 = new JButton("充值");
		button_9.setBounds(197, 141, 93, 23);
		panel_RelativeInformation.add(button_9);
		
		JButton button_10 = new JButton("查看记录");
		button_10.setBounds(197, 166, 93, 23);
		panel_RelativeInformation.add(button_10);
		
		JLabel lblNewLabel = new JLabel("个人相关信息");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(0, 0, 114, 27);
		panel_RelativeInformation.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("一卡通");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(0, 74, 60, 27);
		panel_RelativeInformation.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("余额：80元");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(70, 55, 96, 27);
		panel_RelativeInformation.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("账号状态:正常");
		lblNewLabel_3.setBounds(70, 84, 86, 27);
		panel_RelativeInformation.add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("电  费");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(0, 149, 60, 27);
		panel_RelativeInformation.add(label_1);
		
		JLabel label_2 = new JLabel("余额：190元");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		label_2.setBounds(70, 137, 96, 27);
		panel_RelativeInformation.add(label_2);
		
		JLabel label_3 = new JLabel("使用情况:正常");
		label_3.setBounds(70, 166, 86, 27);
		panel_RelativeInformation.add(label_3);
		
		JPanel panel_SchoolForum = new JPanel();
		panel_SchoolForum.setBounds(580, 282, 290, 174);
		panel_homePage.add(panel_SchoolForum);
		panel_SchoolForum.setLayout(null);
		
		JButton button_11 = new JButton("进入论坛");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_11.setBounds(197, 141, 93, 23);
		panel_SchoolForum.add(button_11);
		
		JLabel lblNewLabel_4 = new JLabel("学校论坛");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(0, 0, 114, 27);
		panel_SchoolForum.add(lblNewLabel_4);
		

		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(490, 0, 20, 370);
		panel_SchoolNotice.add(scrollBar_1);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u901A\u77E5", "\u53D1\u5E03\u6765\u6E90", "\u53D1\u5E03\u65F6\u95F4"},
				{"2", "2", "2"},
				{null, "2", null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_4.setBounds(10, 20, 470, 350);
		panel_SchoolNotice.add(table_4);
		
		/*JPanel panel_CollegeNotice = new JPanel();
		panel_CollegeNotice.setLayout(null);
		panel_CollegeNotice.setBounds(40, 86, 510, 370);
		panel_homePage.add(panel_CollegeNotice);*/
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(490, 0, 20, 370);
		panel_CollegeNotice.add(scrollBar_2);
		
		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u901A\u77E5", "\u53D1\u5E03\u6765\u6E90", "\u53D1\u5E03\u65F6\u95F4"},
				{"\u5B66\u9662\u901A\u77E5", "3333", "3"},
				{"\u5B66\u9662\u901A\u77E5", null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_5.setBounds(10, 20, 470, 350);
		panel_CollegeNotice.add(table_5);
		
		/*JPanel panel_AdministrationNotice = new JPanel();
		panel_AdministrationNotice.setLayout(null);
		panel_AdministrationNotice.setBounds(40, 86, 510, 370);
		panel_homePage.add(panel_AdministrationNotice);*/
		
		JScrollBar scrollBar_3 = new JScrollBar();
		scrollBar_3.setBounds(490, 0, 20, 370);
		panel_AdministrationNotice.add(scrollBar_3);
		
		table_6 = new JTable();
		table_6.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u901A\u77E5", "\u53D1\u5E03\u65F6\u95F4", "\u53D1\u5E03\u65F6\u95F4"},
				{"\u6559\u52A1\u5904\u901A\u77E5", "4", null},
				{"4", null, "4"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_6.setBounds(10, 20, 470, 350);
		panel_AdministrationNotice.add(table_6);
		
		/*JPanel panel_Employmentnotice = new JPanel();
		panel_Employmentnotice.setLayout(null);
		panel_Employmentnotice.setBounds(40, 86, 510, 370);
		panel_homePage.add(panel_Employmentnotice);*/
		
		JScrollBar scrollBar_4 = new JScrollBar();
		scrollBar_4.setBounds(490, 0, 20, 370);
		panel_EmploymentNotice.add(scrollBar_4);
		
		table_7 = new JTable();
		table_7.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u901A\u77E5", "\u53D1\u5E03\u6765\u6E90", "\u53D1\u5E03\u65F6\u95F4"},
				{"55", "555", null},
				{null, null, ""},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_7.setBounds(10, 20, 470, 350);
		panel_EmploymentNotice.add(table_7);
		
		JRadioButton AdministrationNotice = new JRadioButton("教务处通知");
		AdministrationNotice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_homePage);
				panel_SchoolNotice.setVisible(false);
				panel_AllNotice.setVisible(false);
				panel_CollegeNotice.setVisible(false);
				panel_EmploymentNotice.setVisible(false);
				panel_AdministrationNotice.setVisible(true);
				panel.updateUI();
			}
		});
		AdministrationNotice.setBounds(292, 40, 90, 35);
		panel_homePage.add(AdministrationNotice);
		buttonGroup.add(AdministrationNotice);
		
		JRadioButton AllNotice = new JRadioButton("全部通知");
		buttonGroup.add(AllNotice);
		AllNotice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(panel_homePage);
				panel_SchoolNotice.setVisible(false);
				panel_AllNotice.setVisible(true);
				panel_CollegeNotice.setVisible(false);
				panel_EmploymentNotice.setVisible(false);
				panel_AdministrationNotice.setVisible(false);
				panel.updateUI();
			}
		});
		AllNotice.setBounds(471, 40, 80, 35);
		panel_homePage.add(AllNotice);
		
		JPanel panel_querySocres = new JPanel();
		panel.add(panel_querySocres);
		panel_querySocres.setLayout(null);
		
		table_8 = new JTable();
		table_8.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u8BFE\u7A0B", "\u6210\u7EE9"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u8BFE\u7A0B", "\u6210\u7EE9"
			}
		));
		table_8.setBounds(62, 34, 595, 208);
		panel_querySocres.add(table_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"选择成绩", "大一上学期", "大一下学期", "大二上学期", "大二下学期", "大三上学期", "大三下学期", "大四上学期", "大四下学期"}));
		comboBox.setBounds(122, 322, 184, 21);
		panel_querySocres.add(comboBox);
		
		JButton button_12 = new JButton("查询");
		button_12.setBounds(389, 321, 112, 23);
		panel_querySocres.add(button_12);
		
		//选课
		JPanel panel_courseSelect_queryCourse = new JPanel();
		panel.add(panel_courseSelect_queryCourse);
		panel_courseSelect_queryCourse.setLayout(null);
		
		textField_courseName = new JTextField();
		textField_courseName.setBounds(220, 79, 112, 33);
		panel_courseSelect_queryCourse.add(textField_courseName);
		textField_courseName.setColumns(10);
		
		textField_courseNum = new JTextField();
		textField_courseNum.setColumns(10);
		textField_courseNum.setBounds(580, 80, 112, 33);
		panel_courseSelect_queryCourse.add(textField_courseNum);
		
		textField_courseMajor = new JTextField();
		textField_courseMajor.setColumns(10);
		textField_courseMajor.setBounds(580, 142, 112, 33);
		panel_courseSelect_queryCourse.add(textField_courseMajor);
		
		textField_courseCollege = new JTextField();
		textField_courseCollege.setColumns(10);
		textField_courseCollege.setBounds(222, 147, 112, 33);
		panel_courseSelect_queryCourse.add(textField_courseCollege);
		
		JButton button_cancel = new JButton("清除条件");
		button_cancel.setFont(new Font("宋体", Font.BOLD, 20));
		button_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_cancel.setBounds(151, 278, 181, 48);
		panel_courseSelect_queryCourse.add(button_cancel);
		
		JButton button_query = new JButton("查询");
		button_query.setFont(new Font("宋体", Font.BOLD, 20));
		button_query.setBounds(460, 278, 181, 48);
		panel_courseSelect_queryCourse.add(button_query);
		
		JLabel label_courseName = new JLabel("课程名称：");
		label_courseName.setFont(new Font("宋体", Font.BOLD, 20));
		label_courseName.setBounds(116, 76, 116, 34);
		panel_courseSelect_queryCourse.add(label_courseName);
		
		JLabel label_course = new JLabel("所属学院：");
		label_course.setFont(new Font("宋体", Font.BOLD, 20));
		label_course.setBounds(116, 146, 116, 34);
		panel_courseSelect_queryCourse.add(label_course);
		
		JLabel label_courseNum = new JLabel("课程编号：");
		label_courseNum.setFont(new Font("宋体", Font.BOLD, 20));
		label_courseNum.setBounds(475, 76, 116, 34);
		panel_courseSelect_queryCourse.add(label_courseNum);
		
		JLabel label_courseMajor = new JLabel("所属专业：");
		label_courseMajor.setFont(new Font("宋体", Font.BOLD, 20));
		label_courseMajor.setBounds(475, 142, 116, 34);
		panel_courseSelect_queryCourse.add(label_courseMajor);
		
		JPanel panel_courseSelect_courseList = new JPanel();
		panel.add(panel_courseSelect_courseList);
		panel_courseSelect_courseList.setLayout(null);
		
		JButton button = new JButton("选课");
		button.setBounds(91, 186, 72, 27);
		panel_courseSelect_courseList.add(button);
		
		JButton button_1 = new JButton("选课");
		button_1.setBounds(91, 226, 72, 27);
		panel_courseSelect_courseList.add(button_1);
		
		JButton button_2 = new JButton("选课");
		button_2.setBounds(91, 266, 72, 27);
		panel_courseSelect_courseList.add(button_2);
		
		JButton button_3 = new JButton("选课");
		button_3.setBounds(91, 306, 72, 27);
		panel_courseSelect_courseList.add(button_3);
		
		table_courseList = new JTable();
		table_courseList.setFont(new Font("宋体", Font.BOLD, 20));
		table_courseList.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_courseList.setRowHeight(40);//指定每一行的行高40
		
		table_courseList.setModel(new DefaultTableModel(
			new Object[][] {
				{"  \u72B6\u6001", "\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D", "\u5B66\u5206", "\u65F6\u95F4", "\u5730\u70B9", "\u5907\u6CE8", "\u8003\u8BD5\u65F6\u95F4"},
				{"", null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u72B6\u6001", "\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D", "\u5B66\u5206", "\u65F6\u95F4", "\u5730\u70B9", "\u5907\u6CE8", "\u8003\u8BD5\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_courseList.getColumnModel().getColumn(1).setResizable(false);
		table_courseList.getColumnModel().getColumn(2).setResizable(false);
		table_courseList.setBounds(80, 141, 722, 200);
		panel_courseSelect_courseList.add(table_courseList);
		
		JLabel lblNewLabel_5 = new JLabel("开 课 列 表");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel_5.setBounds(349, 97, 226, 31);
		panel_courseSelect_courseList.add(lblNewLabel_5);
		
		table_2 = new JTable();
		table_2.setBounds(80, 86, 722, 55);
		panel_courseSelect_courseList.add(table_2);
		
		JPanel panel_courseSelect_courseSelected = new JPanel();
		panel.add(panel_courseSelect_courseSelected);
		panel_courseSelect_courseSelected.setLayout(null);
		
		JButton button_4 = new JButton("退课");
		button_4.setBounds(90, 188, 72, 27);
		panel_courseSelect_courseSelected.add(button_4);
		
		JButton button_5 = new JButton("退课");
		button_5.setBounds(90, 228, 72, 27);
		panel_courseSelect_courseSelected.add(button_5);
		
		JButton button_6 = new JButton("退课");
		button_6.setBounds(90, 268, 72, 27);
		panel_courseSelect_courseSelected.add(button_6);
		
		JButton button_7 = new JButton("退课");
		button_7.setBounds(90, 308, 72, 27);
		panel_courseSelect_courseSelected.add(button_7);
		
		table_courseSelected = new JTable();
		table_courseSelected.setFont(new Font("宋体", Font.BOLD, 20));
		table_courseSelected.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_courseSelected.setRowHeight(40);//指定每一行的行高40
		table_courseSelected.setModel(new DefaultTableModel(
			new Object[][] {
				{"  \u72B6\u6001", "\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D", "\u5B66\u5206", "\u65F6\u95F4", "\u5730\u70B9", "\u5907\u6CE8", "\u8003\u8BD5\u65F6\u95F4"},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u72B6\u6001", "\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D", "\u5B66\u5206", "\u65F6\u95F4", "\u5730\u70B9", "\u5907\u6CE8", "\u8003\u8BD5\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_courseSelected.setFont(new Font("宋体", Font.BOLD, 20));
		table_courseSelected.setBounds(80, 141, 722, 200);
		panel_courseSelect_courseSelected.add(table_courseSelected);
		
		JLabel label_7 = new JLabel("已 选 课 程");
		label_7.setFont(new Font("宋体", Font.BOLD, 25));
		label_7.setBounds(349, 97, 226, 31);
		panel_courseSelect_courseSelected.add(label_7);
		
		table_1 = new JTable();
		table_1.setBorder(new CompoundBorder());
		table_1.setBounds(80, 86, 722, 55);
		panel_courseSelect_courseSelected.add(table_1);
		
		// 查询选课界面的“查询”按钮
		button_query.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_courseSelect_courseList);
				panel.updateUI();
				//TODO:点击查询之后的数据变化
			}
		});
		// 开课列表界面的“选课”按钮
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(panel_courseSelect_courseSelected);
				panel.updateUI();
				//TODO:点击查询之后的数据变化
			}
		});
		// 我的选课界面的“退课”按钮
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO:点击查询之后的数据变化
				
				panel.removeAll();
				panel.add(panel_courseSelect_courseSelected);//刷新
				panel.updateUI();
			}
		});
		
		
		
		table = new JTable();
		JPanel panel_trainPlan = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_trainPlan.getLayout();
		flowLayout.setVgap(150);
		panel.add(panel_trainPlan);
		panel_trainPlan.add(table);
		
		trainpan_table = new JTable();
		trainpan_table.setBorder(new LineBorder(Color.GRAY, 3));
		trainpan_table.setFont(new Font("\u5B8B\u4F53", trainpan_table.getFont().getStyle(), trainpan_table.getFont().getSize() + 4));
		trainpan_table.setColumnSelectionAllowed(true);
		trainpan_table.setCellSelectionEnabled(true);
		trainpan_table.setBounds(new Rectangle(20, 100, 0, 0));
		trainpan_table.setModel(new DefaultTableModel(
			new Object[][] {
				{"       \u9AD8\u82F1\u8BFE\u7A0B\u7FA4", "4.0", " \u8F6F\u4EF6\u5DE5\u7A0B\u4E13\u4E1A\u57FA\u7840\u77E5\u8BC6\u7FA4", "", "\u8F6F\u4EF6\u5DE5\u7A0B\u77E5\u8BC6\u7FA4", null},
				{" \u4F53\u80B2\u7ADE\u6280\u4E0E\u4F11\u95F2\u8FD0\u52A8\u8BFE\u7A0B\u7FA4", "2.0", "    \u8F6F\u4EF6\u5DE5\u7A0B\u77E5\u8BC6\u7FA4", "5.0", "\u8F6F\u4EF6\u5DE5\u7A0B\u77E5\u8BC6\u7FA4\uFF08\u4E00\uFF09", null},
				{"  \u521B\u65B0\u521B\u4E1A\u5FC3\u7406\u7C7B\u8BFE\u7A0B\u7FA4", "6.0", "   \u8F6F\u4EF6\u7CFB\u7EDF\u5E94\u7528\u77E5\u8BC6\u7FA4", "5.0", "\u8F6F\u4EF6\u5DE5\u7A0B\u77E5\u8BC6\u7FA4\uFF08\u4E8C\uFF09", null},
				{"       \u827A\u672F\u7D20\u517B\u7C7B", "2.0", "    \u5B9E\u9A8C\u6280\u80FD\u57F9\u517B\u73AF\u8282", null, "\u8F6F\u4EF6\u5DE5\u7A0B\u77E5\u8BC6\u7FA4\uFF08\u4E09\uFF09", null},
				{"      \u7ECF\u7BA1\u6CD5\u7C7B", "2.0", "     \u521B\u65B0\u521B\u4E1A\u77E5\u8BC6\u7FA4", null, "\u8F6F\u4EF6\u7CFB\u7EDF\u5E94\u7528\u77E5\u8BC6\u7FA4", "5.0"},
				{null, null, null, null, "\u6269\u5C55\u77E5\u8BC6\u7FA4", "5.0"},
				{null, null, null, null, "\u8F6F\u4EF6\u7CFB\u7EDF\u5E94\u7528\u77E5\u8BC6\u7FA4", null},
				{null, null, null, null, "\u521B\u65B0\u521B\u4E1A\u77E5\u8BC6\u7FA4", null},
			},
			new String[] {
				"\u901A\u8BC6\u9009\u4FEE\u8BFE\u7A0B\u7FA4", "\u5B66\u5206", "\u57FA\u7840\u6559\u80B2\u5FC5\u4FEE\u8BFE\u7A0B\u7FA4", "\u5B66\u5206", "\u57FA\u7840\u6559\u80B2\u9009\u4FEE\u8BFE\u7A0B\u7FA4", "\u5B66\u5206"
			}
		));
		trainpan_table.getColumnModel().getColumn(0).setPreferredWidth(215);
		trainpan_table.getColumnModel().getColumn(0).setMinWidth(27);
		trainpan_table.getColumnModel().getColumn(0).setMaxWidth(220);
		trainpan_table.getColumnModel().getColumn(1).setPreferredWidth(50);
		trainpan_table.getColumnModel().getColumn(2).setPreferredWidth(190);
		trainpan_table.getColumnModel().getColumn(3).setPreferredWidth(50);
		trainpan_table.getColumnModel().getColumn(4).setPreferredWidth(164);
		trainpan_table.getColumnModel().getColumn(5).setPreferredWidth(50);
		trainpan_table.setBackground(SystemColor.textHighlightText);
		panel_trainPlan.add(trainpan_table);
		
		JPanel panel_document = new JPanel();
		panel.add(panel_document);
		
		JPanel panel_search;
		panel_search = new JPanel();
		panel.add(panel_search);
		
		JPanel panel_userInfo;
		panel_userInfo = new JPanel();
		panel.add(panel_userInfo);
		
		JPanel panel_logOut;
		panel_logOut = new JPanel();
		panel.add(panel_logOut);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu_homePage = new JMenu("校园生活");
		menu_homePage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_homePage);
				panel.updateUI();
			}
		});
		menuBar.add(menu_homePage);
		
		JMenu menu_querySocres = new JMenu("查询成绩");
		menu_querySocres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_querySocres);
				panel.updateUI();
			}
		});
		menuBar.add(menu_querySocres);
		
		JMenu menu_courseSelect = new JMenu("选课系统");
		menuBar.add(menu_courseSelect);
		
		JMenuItem menuItem = new JMenuItem("查询选课");
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.removeAll();
				panel.add(panel_courseSelect_queryCourse);
				panel.updateUI();
			}
		});
		menu_courseSelect.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("开课列表");
		menuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.removeAll();
				panel.add(panel_courseSelect_courseList);
				panel.updateUI();
			}
		});
		menu_courseSelect.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("已选课程");
		menuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.removeAll();
				panel.add(panel_courseSelect_courseSelected);
				panel.updateUI();
			}
		});
		menu_courseSelect.add(menuItem_2);
		
		JMenu menu_trainPlan = new JMenu("培养方案");
		menu_trainPlan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_trainPlan);
				panel.updateUI();
			}
		});
		menuBar.add(menu_trainPlan);
		
		JMenu menu_document = new JMenu("文档应用");
		menu_document.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_document);
				panel.updateUI();
			}
		});
		menuBar.add(menu_document);
		
		JMenu menu_search = new JMenu("搜索");
		menu_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_search);
				panel.updateUI();
			}
		});
		menuBar.add(menu_search);
		
		JMenu menu_userInfo = new JMenu("用户信息管理");
		menu_userInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_userInfo);
				panel.updateUI();
			}
		});
		menuBar.add(menu_userInfo);
		
		JMenu menu_logOut = new JMenu("注销");
		menu_logOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_logIn);
				panel.updateUI();
			}
		});
		menuBar.add(menu_logOut);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
	}
}
