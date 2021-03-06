package com.jnu.groupproject.view;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

//import team.six.panel.queryscores.PanelQueryScores;
//import team.six.panel.search.PanelSearch;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

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
		
		String[] recentDoc={"普通申请表.doc","补选课申请.doc","冲突选课申请表.doc"};
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
				String recentDoc = (String) comboBox_recentDoc.getSelectedItem();
				ArrayList<File> files = PanelSearch.searchFiles(new File("src\\com\\jnu\\groupproject\\data"), recentDoc);
				if(files.size()==0) {
					// 进行逻辑处理即可
					//System.out.println("触发了事件");
					// 1. create log  
					Logger log = Logger.getLogger(PanelDocument.class);  
					// 2. get log config file  
					PropertyConfigurator.configure("log4j.properties");  
					// 3. start log   
					log.error("相关文件丢失");  
				}
				//打开文件
				try {
					for (File file : files) {
			            Desktop.getDesktop().open(new File(file.getAbsolutePath()));
			        }
					
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		add(button_openRecentDoc);
		
		JLabel label_allDoc = new JLabel("全部文档");
		label_allDoc.setFont(new Font("宋体", Font.BOLD, 20));
		label_allDoc.setBounds(181, 252, 87, 40);
		add(label_allDoc);
		
		String[] allDoc={"普通申请表.doc","补选课申请.doc","冲突选课申请表.doc","暑假留校住宿申请表.doc","学生寒暑假留校家长同意书.doc","补选课申请.doc","实验报告专用格式.doc","转专业申请表（内招生）.pdf"};
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
				String allDoc = (String) comboBox_allDoc.getSelectedItem();
				ArrayList<File> files = PanelSearch.searchFiles(new File("src\\com\\jnu\\groupproject\\data"), allDoc);
				if(files.size()==0) {
					// 进行逻辑处理即可
					//System.out.println("触发了事件");
					// 1. create log  
					Logger log = Logger.getLogger(PanelDocument.class);  
					// 2. get log config file  
					PropertyConfigurator.configure("log4j.properties");  
					// 3. start log   
					log.error("相关文件丢失");  
				}
				//打开文件
				try {
					for (File file : files) {
			            Desktop.getDesktop().open(new File(file.getAbsolutePath()));
			        }
					
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} 
			}
		});
		add(button_openAllDoc);

	}
}
