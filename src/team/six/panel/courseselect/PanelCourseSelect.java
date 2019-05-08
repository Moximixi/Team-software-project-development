package team.six.panel.courseselect;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import team.six.panel.userinfo.PanelUserInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelCourseSelect extends JPanel {
	private Logger log = Logger.getLogger(PanelUserInfo.class); 
	
	//创建选项卡面板对象
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	//创建面板
	JPanel panel_queryCourse=new JPanel();
	JPanel panel_listCourse=new JPanel();
	JPanel panel_selectedCourse=new JPanel();
	
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
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
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
	
}
