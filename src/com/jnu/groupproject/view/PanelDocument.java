package com.jnu.groupproject.view;

import javax.swing.JPanel;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//import team.six.panel.queryscores.PanelQueryScores;
//import team.six.panel.search.PanelSearch;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDocument extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelDocument() {
		setLayout(null);
		
		JLabel label_recentDoc = new JLabel("最近使用");
		label_recentDoc.setFont(new Font("宋体", Font.BOLD, 20));
		label_recentDoc.setBounds(179, 128, 89, 40);
		add(label_recentDoc);
		
		String[] recentDoc={"请假条.doc","课程替换申请.doc","补选课申请.doc"};
		JComboBox comboBox_recentDoc = new JComboBox(recentDoc);
		comboBox_recentDoc.setFont(new Font("宋体", Font.BOLD, 18));
		comboBox_recentDoc.setBounds(281, 128, 252, 40);
		add(comboBox_recentDoc);
		
		JButton button_openRecentDoc = new JButton("打开");
		button_openRecentDoc.setFont(new Font("宋体", Font.BOLD, 18));
		button_openRecentDoc.setBounds(543, 128, 75, 40);
		button_openRecentDoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 进行逻辑处理即可
				//System.out.println("触发了事件");
			   // 1. create log  
		        Logger log = Logger.getLogger(PanelDocument.class);  
		        // 2. get log config file  
		        PropertyConfigurator.configure("log4j.properties");  
		        // 3. start log   
		        log.error("文件未找到");  
			}
		});
		add(button_openRecentDoc);
		
		JLabel label_allDoc = new JLabel("全部文档");
		label_allDoc.setFont(new Font("宋体", Font.BOLD, 20));
		label_allDoc.setBounds(181, 252, 87, 40);
		add(label_allDoc);
		
		String[] allDoc={"请假条.doc","奖学金申请.doc","课程替换申请.doc","补选课申请.doc","创新学分申请.doc","转专业申请.doc"};
		JComboBox comboBox_allDoc = new JComboBox(allDoc);
		comboBox_allDoc.setFont(new Font("宋体", Font.BOLD, 18));
		comboBox_allDoc.setBounds(281, 253, 252, 39);
		add(comboBox_allDoc);
		
		JButton button_openAllDoc = new JButton("打开");
		button_openAllDoc.setFont(new Font("宋体", Font.BOLD, 18));
		button_openAllDoc.setBounds(543, 253, 75, 40);
		button_openAllDoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 进行逻辑处理即可
				//System.out.println("触发了事件");
			   // 1. create log  
		        Logger log = Logger.getLogger(PanelDocument.class);  
		        // 2. get log config file  
		        PropertyConfigurator.configure("log4j.properties");  
		        // 3. start log   
		        log.error("文件未找到");  
			}
		});
		add(button_openAllDoc);

	}
}
