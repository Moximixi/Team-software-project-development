package com.jnu.groupproject.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.jnu.groupproject.data.*;

public class PanelRegister extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	FileHelper fh=new FileHelper("./userinfo.txt");//存到当前文件夹下

	//读取个人信息代码
	Person person=fh.getObjFromFile();                 //取出person对象

	/**
	 * Create the panel.
	 */
	public PanelRegister() {
		setLayout(null);

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
				//存入person对象
				fh.saveObjToFile(p);    
				//提示信息弹出框
				JOptionPane.showMessageDialog(null, "保存成功");

			}

		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(409, 396, 106, 44);
		add(btnNewButton);

		JLabel lblNewLabel = new JLabel("姓名：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(63, 119, 51, 29);
		add(lblNewLabel);

		JLabel label = new JLabel("性别：");
		label.setFont(new Font("宋体", Font.BOLD, 16));
		label.setBounds(63, 158, 51, 29);
		add(label);

		JLabel label_1 = new JLabel("学号：");
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		label_1.setBounds(63, 197, 51, 29);
		add(label_1);

		JLabel label_2 = new JLabel("宿舍号：");
		label_2.setFont(new Font("宋体", Font.BOLD, 16));
		label_2.setBounds(63, 236, 80, 29);
		add(label_2);

		JLabel label_3 = new JLabel("生日：");
		label_3.setFont(new Font("宋体", Font.BOLD, 16));
		label_3.setBounds(63, 275, 80, 29);
		add(label_3);

		textField = new JTextField();
		textField.setText(person.getName());
		textField.setBounds(124, 124, 146, 21);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText(person.getSex());
		textField_1.setColumns(10);
		textField_1.setBounds(124, 163, 146, 21);
		add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText(String.valueOf(person.getNum()));
		textField_2.setColumns(10);
		textField_2.setBounds(124, 202, 146, 21);
		add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText(String.valueOf(person.getRoom()));
		textField_3.setColumns(10);
		textField_3.setBounds(124, 241, 146, 21);
		add(textField_3);

		textField_4 = new JTextField();
		textField_4.setText(String.valueOf(person.getBirth()));
		textField_4.setColumns(10);
		textField_4.setBounds(124, 280, 146, 21);
		add(textField_4);

	}
}
