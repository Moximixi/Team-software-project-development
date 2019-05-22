package com.jnu.groupproject.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

public class PanelLogin extends JPanel {
	private Logger log = Logger.getLogger(PanelUserInfo.class); 

	public PanelLogin() {
		setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(172, 91, 546, 317);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_JNU = new JLabel("JNU");
		label_JNU.setForeground(new Color(30, 144, 255));
		label_JNU.setFont(new Font("宋体", Font.BOLD, 25));
		label_JNU.setBounds(14, 13, 75, 30);
		panel_1.add(label_JNU);
		
		JLabel label_logIn = new JLabel("自助管理系统登录");
		label_logIn.setForeground(SystemColor.controlDkShadow);
		label_logIn.setFont(new Font("宋体", Font.BOLD, 20));
		label_logIn.setBounds(61, 21, 218, 18);
		panel_1.add(label_logIn);
		
		JTextField textField_name = new JTextField();
		textField_name.setBounds(193, 97, 205, 24);
		panel_1.add(textField_name);
		textField_name.setColumns(10);
		
		JTextField textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(193, 149, 205, 24);
		panel_1.add(textField_password);
		
		JButton btn_login = new JButton("登录");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Menu.panel.removeAll();
				try {
					Menu.panel.add(new PanelHomePage());
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				Menu.panel.updateUI();
				log.info("用户登录");	//日志
			}
		});
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_login.setBackground(Color.LIGHT_GRAY);
		btn_login.setFont(new Font("宋体", Font.BOLD, 20));
		btn_login.setForeground(Color.WHITE);
		btn_login.setBounds(118, 241, 141, 30);
		panel_1.add(btn_login);
		
		JLabel label_name = new JLabel("账号：");
		label_name.setForeground(Color.GRAY);
		label_name.setFont(new Font("宋体", Font.BOLD, 20));
		label_name.setBounds(128, 103, 63, 18);
		panel_1.add(label_name);
		
		JLabel label_password = new JLabel("密码：");
		label_password.setForeground(Color.GRAY);
		label_password.setFont(new Font("宋体", Font.BOLD, 20));
		label_password.setBounds(128, 152, 63, 18);
		panel_1.add(label_password);
		
		JButton btn_register = new JButton("注册");
		btn_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Menu.panel.removeAll();
				Menu.panel.add(new PanelRegister());
				Menu.panel.updateUI();
				log.info("用户注册");	//日志
			}
		});
		btn_register.setForeground(Color.WHITE);
		btn_register.setFont(new Font("宋体", Font.BOLD, 20));
		btn_register.setBackground(Color.LIGHT_GRAY);
		btn_register.setBounds(303, 241, 141, 30);
		panel_1.add(btn_register);

	}
}
