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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelCourseSelect extends JPanel {

	JPanel p = new JPanel();
	
	public PanelCourseSelect() {
		
		super();
		setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);//创建选项卡面板对象
		add(tabbedPane, "name_422260517140338");
	
		//创建面板
		JPanel panel_queryCourse=new JPanel();
		JPanel panel_listCourse=new JPanel();
		JPanel panel_selectedCourse=new JPanel();
 
 	
		panel_queryCourse.setLayout(null);
		
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
		button_query.setFont(new Font("宋体", Font.BOLD, 20));
		button_query.setBounds(460, 278, 181, 48);
		panel_queryCourse.add(button_query);
		
		//将面板加入到选项卡面板对象上
		tabbedPane.addTab("查询选课",null,panel_queryCourse,"First panel");
		tabbedPane.addTab("开课列表",null,panel_listCourse,"Second panel");
		tabbedPane.addTab("已选课程",null,panel_selectedCourse,"Third panel");
		super.setSize(800, 470);
		
	}
}
