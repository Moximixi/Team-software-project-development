package com.jnu.groupproject.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.jnu.groupproject.noticeclass.CollegeNotice;
import com.jnu.groupproject.noticeclass.JwcNotice;
import com.jnu.groupproject.noticeclass.JyNotice;
import com.jnu.groupproject.noticeclass.NoticeSerializeOperater;
import com.jnu.groupproject.noticeclass.SchoolNotice;
import com.jnu.groupproject.noticeclass.Web;

//import team.six.panel.queryscores.PanelQueryScores;
//import team.six.panel.userinfo.PanelUserInfo;

public class PanelSearch extends JPanel {
	private JTextField textField_keyWord;
	ArrayList<Integer> selectedNoticeNumber=new ArrayList<>();
	ArrayList<String> selectedNoticeTitle=new ArrayList<>();
	ArrayList<SchoolNotice> schoolnoticeList= new ArrayList<SchoolNotice>();
	ArrayList<CollegeNotice> collegeNoticeList= new ArrayList<CollegeNotice>();
	ArrayList<JwcNotice> JwcNoticeList= new ArrayList<JwcNotice>();
	ArrayList<JyNotice> JyNoticeList= new ArrayList<JyNotice>();
	String selectedRange;
	/**
	 * Create the panel.
	 */
	public PanelSearch() {
		setLayout(null);
		setLayout(null);
		
		JLabel label_range = new JLabel("搜索范围");
		label_range.setFont(new Font("宋体", Font.BOLD, 20));
		label_range.setBounds(35, 94, 85, 33);
		add(label_range);
		
		String[] range= {"文档","校内通知","学院通知","教务处通知","就业通知"};
		JComboBox comboBox_range = new JComboBox(range);
		comboBox_range.setFont(new Font("宋体", Font.BOLD, 18));
		comboBox_range.setBounds(133, 94, 147, 33);
		add(comboBox_range);
		
		JLabel label_keyWord = new JLabel("关 键 字");
		label_keyWord.setFont(new Font("宋体", Font.BOLD, 20));
		label_keyWord.setBounds(35, 142, 85, 33);
		add(label_keyWord);
		
		textField_keyWord = new JTextField();
		textField_keyWord.setFont(new Font("宋体", Font.BOLD, 18));
		textField_keyWord.setBounds(133, 142, 147, 33);
		add(textField_keyWord);
		textField_keyWord.setColumns(10);
		
		JLabel label_searchResults = new JLabel("搜索结果");
		label_searchResults.setFont(new Font("宋体", Font.BOLD, 20));
		label_searchResults.setBounds(325, 60, 200, 31);
		add(label_searchResults);


 		DefaultListModel list_searchResultsModel = new DefaultListModel();
		JList list_searchResults = new JList(list_searchResultsModel);
		JScrollPane listScrollPane_searchResults = new JScrollPane(list_searchResults);
		listScrollPane_searchResults.setBounds(325, 94, 495, 280);
		list_searchResults.setFont(new Font("宋体", Font.PLAIN, 18));
		//list_searchResults.addListSelectionListener();
		add(listScrollPane_searchResults);
		
		JButton button_search = new JButton("开始搜索");
		button_search.setFont(new Font("宋体", Font.BOLD, 18));
		button_search.setBounds(35, 202, 245, 33);
		button_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRange = (String) comboBox_range.getSelectedItem();
				String keyword = textField_keyWord.getText();
				switch (selectedRange) {
				case "文档":
					ArrayList<File> files = searchFiles(new File("./src/com/jnu/groupproject/data"), keyword);
					int documentSearchResultsNumber = files.size();
			        label_searchResults.setText("搜索结果("+documentSearchResultsNumber+")");
			        list_searchResultsModel.removeAllElements();
			        if(documentSearchResultsNumber==0) {
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
			        break;
				case "校内通知": 
					NoticeSerializeOperater schoolnoticeoperater=new NoticeSerializeOperater<SchoolNotice>();
					try {
						selectedNoticeNumber.clear();
						selectedNoticeTitle.clear();
						schoolnoticeList = schoolnoticeoperater.load("./src/com/jnu/groupproject/data/schoolnotice.dat");
						for(int i=0;i<schoolnoticeList.size();i++) {
							SchoolNotice schoolnotice = schoolnoticeList.get(i);
							if (schoolnotice.getTitle().contains(keyword)) {
								selectedNoticeNumber.add(i);
								selectedNoticeTitle.add(schoolnotice.getTitle());
							}	
						}	
				        label_searchResults.setText("搜索结果("+selectedNoticeTitle.size()+")");
				        list_searchResultsModel.removeAllElements();
				        for (int i = 0;i<selectedNoticeTitle.size();i++) {
							list_searchResultsModel.addElement((i+1)+"、"+selectedNoticeTitle.get(i));
						}	
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					updateUI();
			        break;
				
				case "学院通知": 
					selectedNoticeNumber.clear();
					selectedNoticeTitle.clear();
					NoticeSerializeOperater collegeNoticeOperater=new NoticeSerializeOperater<CollegeNotice>();
					try {
						collegeNoticeList = collegeNoticeOperater.load("./src/com/jnu/groupproject/data/collegenotice.dat");
						for(int i=0;i<collegeNoticeList.size();i++) {
							CollegeNotice collegenotice = collegeNoticeList.get(i);
							if (collegenotice.getTitle().contains(keyword)) {
								selectedNoticeNumber.add(i);
								selectedNoticeTitle.add(collegenotice.getTitle());
							}	
						}	
				        label_searchResults.setText("搜索结果("+selectedNoticeTitle.size()+")");
				        list_searchResultsModel.removeAllElements();
				        for (int i = 0;i<selectedNoticeTitle.size();i++) {
							list_searchResultsModel.addElement((i+1)+"、"+selectedNoticeTitle.get(i));
						}	
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					updateUI();
			        break;
			        
				case "教务处通知": 
					selectedNoticeNumber.clear();
					selectedNoticeTitle.clear();
					NoticeSerializeOperater JwcNoticeOperater=new NoticeSerializeOperater<JwcNotice>();
					try {
						JwcNoticeList = JwcNoticeOperater.load("./src/com/jnu/groupproject/data/Jwcnotice.dat");
						for(int i=0;i<JwcNoticeList.size();i++) {
							JwcNotice Jwcnotice = JwcNoticeList.get(i);
							if (Jwcnotice.getTitle().contains(keyword)) {
								selectedNoticeNumber.add(i);
								selectedNoticeTitle.add(Jwcnotice.getTitle());
							}	
						}	
				        label_searchResults.setText("搜索结果("+selectedNoticeTitle.size()+")");
				        list_searchResultsModel.removeAllElements();
				        for (int i = 0;i<selectedNoticeTitle.size();i++) {
							list_searchResultsModel.addElement((i+1)+"、"+selectedNoticeTitle.get(i));
						}	
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					updateUI();
			        break;
			        
				case "就业通知": 
					selectedNoticeNumber.clear();
					selectedNoticeTitle.clear();
					NoticeSerializeOperater JyNoticeOperater=new NoticeSerializeOperater<JyNotice>();
					try {
						JyNoticeList = JyNoticeOperater.load("./src/com/jnu/groupproject/data/Jynotice.dat");
						for(int i=0;i<JyNoticeList.size();i++) {
							JyNotice Jynotice = JyNoticeList.get(i);
							if (Jynotice.getTitle().contains(keyword)) {
								selectedNoticeNumber.add(i);
								selectedNoticeTitle.add(Jynotice.getTitle());
							}	
						}	
				        label_searchResults.setText("搜索结果("+selectedNoticeTitle.size()+")");
				        list_searchResultsModel.removeAllElements();
				        for (int i = 0;i<selectedNoticeTitle.size();i++) {
							list_searchResultsModel.addElement((i+1)+"、"+selectedNoticeTitle.get(i));
						}	
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					updateUI();
			        break;
				}
			}
		});
		add(button_search);
		JButton button_openSelectedResult = new JButton("打开");
		button_openSelectedResult.setFont(new Font("宋体", Font.BOLD, 18));
		button_openSelectedResult.setBounds(746, 385, 74, 33);
		button_openSelectedResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch (selectedRange) {
				case "文档":
					String seletedFileName = (String) list_searchResults.getSelectedValue();
					//ArrayList<File> seletedFile = searchFiles(new File("./src/com/jnu/groupproject/data"),seletedFileName);
					//try {
						//for (File file : seletedFile) {
							//System.out.println(file.getAbsolutePath());
					try {
						Desktop.getDesktop().open(new File("./src/com/jnu/groupproject/data/"+seletedFileName));
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					//	}
					//} catch (IOException e1) {
						//e1.printStackTrace();
					//}
					updateUI();
			        break;
			        
				case "校内通知": 
					int visiualSeletedSchoolNotice =  list_searchResults.getSelectedIndex();
					int realSeletedSchoolNotice = selectedNoticeNumber.get(visiualSeletedSchoolNotice);
					SchoolNotice seletedSchoolNotice = schoolnoticeList.get(realSeletedSchoolNotice);
					//这一部分打开网页
					JFrame frame_schoolNotice = new JFrame("校内通知");
					//设置窗体关闭的时候不关闭应用程序
					frame_schoolNotice.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame_schoolNotice.getContentPane().add(new Web(seletedSchoolNotice.getUrl()), BorderLayout.CENTER);
					frame_schoolNotice.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame_schoolNotice.setLocationByPlatform(true);
					//让窗体可见
					frame_schoolNotice.setVisible(true);
					//重置窗体大小
					frame_schoolNotice.setResizable(true);
					// 设置窗体的宽度、高度
					frame_schoolNotice.setSize(700,500);
					// 设置窗体居中显示
					frame_schoolNotice.setLocationRelativeTo(frame_schoolNotice.getOwner());
					
			        break;
					//add(new Web(schoolnotice.getUrl()));
				case "学院通知": 
					int visiualSeletedCollegeNotice =  list_searchResults.getSelectedIndex();
					int realSeletedCollegeNotice = selectedNoticeNumber.get(visiualSeletedCollegeNotice);
					CollegeNotice seletedCollegeNotice = collegeNoticeList.get(realSeletedCollegeNotice);
					//这一部分打开网页
					JFrame frame_collegeNotice = new JFrame("校内通知");
					//设置窗体关闭的时候不关闭应用程序
					frame_collegeNotice.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame_collegeNotice.getContentPane().add(new Web(seletedCollegeNotice.getUrl()), BorderLayout.CENTER);
					frame_collegeNotice.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame_collegeNotice.setLocationByPlatform(true);
					//让窗体可见
					frame_collegeNotice.setVisible(true);
					//重置窗体大小
					frame_collegeNotice.setResizable(true);
					// 设置窗体的宽度、高度
					frame_collegeNotice.setSize(700,500);
					// 设置窗体居中显示
					frame_collegeNotice.setLocationRelativeTo(frame_collegeNotice.getOwner());
					
			        break;
					//add(new Web(schoolnotice.getUrl()));
    
				case "教务处通知": 
					int visiualSeletedJwcNotice =  list_searchResults.getSelectedIndex();
					int realSeletedJwcNotice = selectedNoticeNumber.get(visiualSeletedJwcNotice);
					JwcNotice seletedJwcNotice = JwcNoticeList.get(realSeletedJwcNotice);
					//这一部分打开网页
					JFrame frame_JwcNotice = new JFrame("校内通知");
					//设置窗体关闭的时候不关闭应用程序
					frame_JwcNotice.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame_JwcNotice.getContentPane().add(new Web(seletedJwcNotice.getUrl()), BorderLayout.CENTER);
					frame_JwcNotice.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame_JwcNotice.setLocationByPlatform(true);
					//让窗体可见
					frame_JwcNotice.setVisible(true);
					//重置窗体大小
					frame_JwcNotice.setResizable(true);
					// 设置窗体的宽度、高度
					frame_JwcNotice.setSize(700,500);
					// 设置窗体居中显示
					frame_JwcNotice.setLocationRelativeTo(frame_JwcNotice.getOwner());
					updateUI();
			        break;
					//add(new Web(schoolnotice.getUrl()));
    
				case "就业通知": 
					int visiualSeletedJyNotice =  list_searchResults.getSelectedIndex();
					int realSeletedJyNotice = selectedNoticeNumber.get(visiualSeletedJyNotice);
					JyNotice seletedJyNotice = JyNoticeList.get(realSeletedJyNotice);
					//这一部分打开网页
					JFrame frame_JyNotice = new JFrame("校内通知");
					//设置窗体关闭的时候不关闭应用程序
					frame_JyNotice.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame_JyNotice.getContentPane().add(new Web(seletedJyNotice.getUrl()), BorderLayout.CENTER);
					frame_JyNotice.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame_JyNotice.setLocationByPlatform(true);
					//让窗体可见
					frame_JyNotice.setVisible(true);
					//重置窗体大小
					frame_JyNotice.setResizable(true);
					// 设置窗体的宽度、高度
					frame_JyNotice.setSize(700,500);
					// 设置窗体居中显示
					frame_JyNotice.setLocationRelativeTo(frame_JyNotice.getOwner());
					updateUI();
			        break;
					//add(new Web(schoolnotice.getUrl()));
    
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


/*
System.out.println(i+" "+schoolnotice.getTitle());
//这一部分打开网页
JFrame frame = new JFrame("通知");
//设置窗体关闭的时候不关闭应用程序
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.getContentPane().add(new Web(schoolnotice.getUrl()), BorderLayout.CENTER);
frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
frame.setLocationByPlatform(true);
//让窗体可见
frame.setVisible(true);
//重置窗体大小
frame.setResizable(true);
// 设置窗体的宽度、高度
frame.setSize(700,500);
// 设置窗体居中显示
frame.setLocationRelativeTo(frame.getOwner());

//add(new Web(schoolnotice.getUrl()));

 */

			    

