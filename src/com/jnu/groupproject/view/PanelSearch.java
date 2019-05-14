package com.jnu.groupproject.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//import team.six.panel.queryscores.PanelQueryScores;
//import team.six.panel.userinfo.PanelUserInfo;

public class PanelSearch extends JPanel {
	private JTextField textField_keyWord;

	/**
	 * Create the panel.
	 */
	public PanelSearch() {
		setLayout(null);
		
		JLabel label_range = new JLabel("搜索范围");
		label_range.setFont(new Font("宋体", Font.BOLD, 20));
		label_range.setBounds(204, 138, 85, 33);
		add(label_range);
		
		String[] range= {"全局","文档","通知"};
		JComboBox comboBox_range = new JComboBox(range);
		comboBox_range.setFont(new Font("宋体", Font.BOLD, 18));
		comboBox_range.setBounds(318, 138, 267, 33);
		add(comboBox_range);
		
		JLabel label_keyWord = new JLabel("关键字");
		label_keyWord.setFont(new Font("宋体", Font.BOLD, 20));
		label_keyWord.setBounds(223, 228, 66, 33);
		add(label_keyWord);
		
		textField_keyWord = new JTextField();
		textField_keyWord.setFont(new Font("宋体", Font.BOLD, 18));
		textField_keyWord.setBounds(318, 228, 267, 32);
		add(textField_keyWord);
		textField_keyWord.setColumns(10);
		
		JButton button_search = new JButton("搜索");
		button_search.setFont(new Font("宋体", Font.BOLD, 18));
		button_search.setBounds(608, 229, 74, 31);
		button_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 进行逻辑处理即可
				//System.out.println("触发了事件");
			   // 1. create log  
		        Logger log = Logger.getLogger(PanelSearch.class);  
		        // 2. get log config file  
		        PropertyConfigurator.configure("log4j.properties");  
		        // 3. start log   
		        log.error("搜索功能不可用");  
		    
			}
		});
		add(button_search);

	}

}
