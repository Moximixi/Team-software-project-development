package com.jnu.groupproject.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import org.apache.log4j.Logger;  
import org.apache.log4j.PropertyConfigurator;  

import com.jnu.groupproject.data.*;

public class PanelUserInfo extends JPanel {
	private JTable table;
	public PanelUserInfo() {
		//首先规定用户信息的路径（需要用到用户信息的界面都要引入该语句）
		FileHelper fh=new FileHelper("./userinfo.txt");
		//读取个人信息代码
		Person person=fh.getObjFromFile();                 //取出person对象

//		for(int i=1;i<4;i++) {
//			for(int j=0;j<3;j++) {
//
//			}
//		}
		//样式部分
		setLayout(null);

		table = new JTable();
		table.setFont(new Font("宋体", Font.BOLD, 20));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(40);//指定每一行的行高40

		table.setBounds(382, 128, 418, 160);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u7F51\u7AD9", "\u8D26\u53F7", "\u5BC6\u7801"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		add(table);
		/*
		 * 导入网站数据	
		 * */
		for(int i=0;i<person.webInfo.size();i++) {	
			int row=(i/3)+1;
			int column=i%3;
			table.setValueAt(person.webInfo.get(i),row,column);
			//System.out.println(p.webInfo.get(i));
		}
		
		JLabel lblNewLabel = new JLabel("姓名:");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(32, 99, 54, 37);
		add(lblNewLabel);

		JLabel label = new JLabel();
		label.setText(person.getName());
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(134, 99, 160, 37);
		add(label);

		JLabel label_1 = new JLabel("学号:");
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(32, 199, 54, 37);
		add(label_1);

		JLabel label_2 = new JLabel("寝室号:");
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(32, 249, 88, 39);
		add(label_2);

		JLabel label_3 = new JLabel("出生日期");
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setBounds(32, 299, 88, 37);
		add(label_3);

		JLabel label_4 = new JLabel();
		label_4.setText(String.valueOf(person.getNum()));
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(134, 199, 160, 37);
		add(label_4);

		JLabel label_5 = new JLabel();
		label_5.setText(String.valueOf(person.getRoom()));
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(134, 249, 160, 37);
		add(label_5);

		JLabel label_6 = new JLabel();
		label_6.setText(String.valueOf(person.getBirth()));
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		label_6.setBounds(134, 299, 160, 37);
		add(label_6);

		JLabel label_7 = new JLabel("性别:");
		label_7.setFont(new Font("宋体", Font.BOLD, 20));
		label_7.setBounds(32, 149, 54, 37);
		add(label_7);

		JLabel label_8 = new JLabel();
		label_8.setText(person.getSex());
		label_8.setFont(new Font("宋体", Font.PLAIN, 20));
		label_8.setBounds(134, 149, 160, 37);
		add(label_8);

//		JButton btnNewButton = new JButton("保存");
//		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
//		btnNewButton.setBounds(522, 327, 181, 48);
//		add(btnNewButton);
//
//		//button按钮的点击事件
//		btnNewButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				//警告对话框
//				//JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE); 
//				//提示信息弹出框
//				JOptionPane.showMessageDialog(null, "保存成功");
//				//JOptionPane.showMessageDialog(null, "保存成功！", "系统消息",JOptionPane.PLAIN_MESSAGE);   
//				/*
//				 * 日志部分
//				 * */
//				// 1. create log  
//				//		        Logger log = Logger.getLogger(PanelUserInfo.class);  
//				// 2. get log config file  
//				//		        PropertyConfigurator.configure("log4j.properties");  
//				// 3. start log  
//				//		        log.debug("这是来自用户信息界面的DEBUG");  
//				//		        log.info("这是来自用户查看信息界面的INFO");  
//				//		        log.warn("这是来自用户信息界面的 WARN");  
//				//		        log.error("这是来自用户信息界面的ERROR");  
//				//		        log.fatal("这是来自用户信息界面的FATAL"); 
//			}
//		});


	}
}
