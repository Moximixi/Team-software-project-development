package com.jnu.groupproject.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import javax.swing.JList;
import javax.swing.JTable;



public class PanelSearch extends JPanel {
	private JTextField textField_keyWord;

	/**
	 * Create the panel.
	 */
	public PanelSearch() {
		super(new BorderLayout());
		setLayout(null);
		
		
		JLabel label_range = new JLabel("搜索范围");
		label_range.setFont(new Font("宋体", Font.BOLD, 20));
		label_range.setBounds(44, 94, 85, 33);
		add(label_range);
		
		String[] range= {"全局","文档","通知"};
		JComboBox comboBox_range = new JComboBox(range);
		comboBox_range.setFont(new Font("宋体", Font.BOLD, 18));
		comboBox_range.setBounds(142, 94, 147, 33);
		add(comboBox_range);
		
		JLabel label_keyWord = new JLabel("关键字");
		label_keyWord.setFont(new Font("宋体", Font.BOLD, 20));
		label_keyWord.setBounds(44, 142, 66, 33);
		add(label_keyWord);
		
		textField_keyWord = new JTextField();
		textField_keyWord.setFont(new Font("宋体", Font.BOLD, 18));
		textField_keyWord.setBounds(44, 192, 246, 33);
		add(textField_keyWord);
		textField_keyWord.setColumns(10);
			
		JLabel label_searchResults = new JLabel("搜索结果");
		label_searchResults.setFont(new Font("宋体", Font.BOLD, 20));
		label_searchResults.setBounds(342, 62, 126, 31);
		add(label_searchResults);
		
		DefaultListModel list_searchResultsModel = new DefaultListModel();
		JList list_searchResults = new JList(list_searchResultsModel);
		JScrollPane listScrollPane_searchResults = new JScrollPane(list_searchResults);
		listScrollPane_searchResults.setBounds(342, 96, 480, 280);
		list_searchResults.setFont(new Font("宋体", Font.PLAIN, 16));
		//list_searchResults.addListSelectionListener();
		add(listScrollPane_searchResults);
		
		JButton button_search = new JButton("搜索");
		button_search.setFont(new Font("宋体", Font.BOLD, 18));
		button_search.setBounds(215, 142, 74, 33);
		button_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String keyword = textField_keyWord.getText();
				ArrayList<File> files = searchFiles(new File("C:\\Users\\chris ben\\git\\Team-software-project-development\\src\\com\\jnu\\groupproject\\data"), keyword);
		        int searchResultsNumber = files.size();
		        label_searchResults.setText("搜索结果("+searchResultsNumber+")");
		        list_searchResultsModel.removeAllElements();
		        if(searchResultsNumber==0) {
					// 进行逻辑处理即可
					//System.out.println("触发了事件");
					// 1. create log  
					Logger log = Logger.getLogger(PanelSearch.class);  
					// 2. get log config file  
					PropertyConfigurator.configure("log4j.properties");  
					// 3. start log   
					log.info("未找到相关文件");  
				}else {
					//System.out.println("共找到:" + files.size() + "个文件");
					for (File file : files) {
						//System.out.println(file.getAbsolutePath());
						list_searchResultsModel.addElement(file.getName());
					}
				}
		        updateUI();
			}
		});
		add(button_search);
		
		JButton button_openSelectedResult = new JButton("打开");
		button_openSelectedResult.setFont(new Font("宋体", Font.BOLD, 18));
		button_openSelectedResult.setBounds(746, 385, 74, 33);
		button_openSelectedResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String seletedFileName = (String) list_searchResults.getSelectedValue();
				ArrayList<File> seletedFile = searchFiles(new File("C:\\Users\\chris ben\\git\\Team-software-project-development\\src\\com\\jnu\\groupproject\\data"),seletedFileName);
				try {
					for (File file : seletedFile) {
			            Desktop.getDesktop().open(new File(file.getAbsolutePath()));
			        }
					
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			
			}
		});
		add(button_openSelectedResult);
	
	}
	
	 public static ArrayList<File> searchFiles(File folder, final String keyword) {
	        ArrayList<File> result = new ArrayList<File>();
	        if (folder.isFile())
	            result.add(folder);
	 
	        File[] subFolders = folder.listFiles(new FileFilter() {
	            @Override
	            public boolean accept(File file) {
	                if (file.isDirectory()) {
	                    return true;
	                }
	                if (file.getName().toLowerCase().contains(keyword)) {
	                    return true;
	                }
	                return false;
	            }
	        });
	 
	        if (subFolders != null) {
	            for (File file : subFolders) {
	                if (file.isFile()) {
	                    // 如果是文件则将文件添加到结果列表中
	                    result.add(file);
	                } else {
	                    // 如果是文件夹，则递归调用本方法，然后把所有的文件加到结果列表中
	                    result.addAll(searchFiles(file, keyword));
	                }
	            }
	        }
	 
	        return result;
	    }
	 
}
