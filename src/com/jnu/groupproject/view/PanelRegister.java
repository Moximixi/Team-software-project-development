package com.jnu.groupproject.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.jnu.groupproject.data.*;
import javax.swing.JTable;

public class PanelRegister extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	FileHelper fh=new FileHelper("./userinfo.txt");//存到当前文件夹下

	//读取个人信息代码
	Person person=fh.getObjFromFile();                 //取出person对象
	private JTable table;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public PanelRegister() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("姓名：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(63, 120, 51, 29);
		add(lblNewLabel);

		JLabel label = new JLabel("性别：");
		label.setFont(new Font("宋体", Font.BOLD, 16));
		label.setBounds(63, 160, 51, 29);
		add(label);

		JLabel label_1 = new JLabel("学号：");
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		label_1.setBounds(63, 200, 51, 29);
		add(label_1);

		JLabel label_2 = new JLabel("宿舍号：");
		label_2.setFont(new Font("宋体", Font.BOLD, 16));
		label_2.setBounds(63, 240, 80, 29);
		add(label_2);

		JLabel label_3 = new JLabel("生日：");
		label_3.setFont(new Font("宋体", Font.BOLD, 16));
		label_3.setBounds(63, 280, 80, 29);
		add(label_3);
		
		JLabel label_4 = new JLabel("校园卡密码：");
		label_4.setFont(new Font("宋体", Font.BOLD, 16));
		label_4.setBounds(63, 320, 106, 29);
		add(label_4);

		textField = new JTextField();
		textField.setText(person.getName());
		textField.setBounds(124, 125, 146, 21);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText(person.getSex());
		textField_1.setColumns(10);
		textField_1.setBounds(124, 165, 146, 21);
		add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText(String.valueOf(person.getNum()));
		textField_2.setColumns(10);
		textField_2.setBounds(124, 205, 146, 21);
		add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText(String.valueOf(person.getRoom()));
		textField_3.setColumns(10);
		textField_3.setBounds(124, 245, 146, 21);
		add(textField_3);

		textField_4 = new JTextField();
		textField_4.setText(String.valueOf(person.getBirth()));
		textField_4.setColumns(10);
		textField_4.setBounds(124, 285, 146, 21);
		add(textField_4);

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
		table.getColumnModel().getColumn(0).setMinWidth(50);
		
		textField_5 = new JTextField();
		textField_5.setText(String.valueOf(person.getCard()));
		textField_5.setColumns(10);
		textField_5.setBounds(162, 325, 146, 21);
		add(textField_5);
		add(table);
		
				JButton btnNewButton = new JButton("保存");
				btnNewButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						/*
						 * 存储个人信息
						 * */
						Person p=new Person();
						p.setName(textField.getText());
						p.setSex(textField_1.getText());
						p.setNum(Integer.parseInt(textField_2.getText()));
						p.setRoom(Integer.parseInt(textField_3.getText()));
						p.setBirth(Integer.parseInt(textField_4.getText()));
						p.setCard(Integer.parseInt(textField_5.getText()));
						/*
						 * 存储账号和密码
						 * */
						int m=0;
						//p.webInfo.clear();
						for(int i=1;i<4;i++) {//行
							for(int j=0;j<3;j++) {//列
								if(table.getValueAt(i,j)!=null) {
									String getname= table.getValueAt(i,j).toString();//读取你获取行号的某一列的值（也就是字段）
									p.webInfo.add(m,getname);
									//System.out.println("m为:"+m);
									m++;
								}
							}
						}
						System.out.println("---------------这是分割线--------------");
						System.out.println("本次点击p的个数:"+p.webInfo.size());
						for(int i=0;i<p.webInfo.size();i++) {		
							System.out.println(p.webInfo.get(i));
						}
						//将person对象存入文件
						fh.saveObjToFile(p);    
						//提示信息弹出框
						JOptionPane.showMessageDialog(null, "保存成功");
					}
				}
						);
				btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton.setBounds(335, 399, 106, 44);
				add(btnNewButton);
		/*
		 * 导入网站数据	
		 * */
		for(int i=0;i<person.webInfo.size();i++) {	
			int row=(i/3)+1;
			int column=i%3;
			table.setValueAt(person.webInfo.get(i),row,column);
			//System.out.println(p.webInfo.get(i));
		}

	}
}
