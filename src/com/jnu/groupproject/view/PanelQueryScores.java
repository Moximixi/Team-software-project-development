package com.jnu.groupproject.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import com.jnu.groupproject.data.FileHelper;
import com.jnu.groupproject.data.Person;

import javax.swing.JComboBox;


public class PanelQueryScores extends JPanel {

	ArrayList<Score> scores = new ArrayList<>();
	JPanel panelQueryScores = new JPanel();
	JScrollPane scrollPane = new JScrollPane();
	JButton btnNewButton = new JButton("查询");
	
	public PanelQueryScores() {
		super();
		setLayout(new CardLayout(0, 0));
		add(panelQueryScores);
		panelQueryScores.setLayout(null);
			
		JLabel label_listCourse = new JLabel("我 的 成 绩");
		label_listCourse.setFont(new Font("宋体", Font.BOLD, 25));
		label_listCourse.setBounds(360, 5, 146, 30);
		panelQueryScores.add(label_listCourse);
		
		initJScrollPane();
        
	}
	
	private void initJScrollPane() {
		// 表头（列名）
        Object[] columnNames = {"课程编号", "课程名", "类型", "成绩", "学分", "绩点"};

        // 表格所有行数据
        int rowCount=scores.size();
        Object[][] rowData = new Object[rowCount][7];
        for(int i=0; i<rowCount; i++) {
        	rowData[i][0]=scores.get(i).getNum();
        	rowData[i][1]=scores.get(i).getName();
        	rowData[i][2]=scores.get(i).getType();
        	rowData[i][3]=scores.get(i).getScore();
        	rowData[i][4]=scores.get(i).getCredit();
        	rowData[i][5]=scores.get(i).getGPA();
        	System.out.println("   xxxxx xxxx: " + scores.get(i).getName());
        }


        // 创建一个表格，指定 表头 和 所有行数据
        JTable table = new JTable(rowData, columnNames);

        // 设置表格内容颜色
        table.setForeground(Color.BLACK);                   // 字体颜色
        table.setFont(new Font("宋体", Font.PLAIN, 15));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.GRAY);                     // 网格颜色

        // 设置表头
        table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 20));  // 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.BLACK);                // 设置表头名称字体颜色
        table.getTableHeader().setResizingAllowed(true);               // 设置不允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

        // 设置行高
        table.setRowHeight(40);

        // 设置列宽
        table.getColumnModel().getColumn(0).setPreferredWidth(45);
        table.getColumnModel().getColumn(2).setPreferredWidth(15);
        //table.getColumnModel().getColumn(6).setPreferredWidth(45);

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(800, 300));

        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(32, 40, 802, 333);

        // 添加 滚动面板 到 内容面板
        panelQueryScores.add(scrollPane);
        
        
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(360, 386, 181, 41);
		//btnNewButton.setBounds(190, 362, 181, 48);
		//btnNewButton.setBounds(565, 375, 93, 23);
		panelQueryScores.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("点击查询");
				Runtime r=Runtime.getRuntime();
		        Process p = null;
				try {
					File directory = new File("");
					String ss=directory.getAbsolutePath();
					FileHelper fh=new FileHelper("./userinfo.txt");
				    Person person=fh.getObjFromFile();
				    String xuehao=(String) person.webInfo.get(4);
				    String password=(String) person.webInfo.get(5);
				    String name=(String) person.getName();
					p = r.exec("cmd /k c: & cd ss & cd src & cd com & cd jnu & cd groupproject & cd jwc & jwc.exe "+ xuehao +" "+password+" "+name+" 电气信息学院 软件工程 -> 3.txt & exit");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					// 使用ArrayList来存储每行读取到的字符串
					//ArrayList<Score> arrayList = new ArrayList<>();
					String pattern = "\\d\\d\\d\\d\\d\\d\\d\\d.*";	//以八个数字开头的字符串
					
					//FileReader fr = new FileReader("./src/com/jnu/groupproject/jwc/1.txt","UTF-8");
					//BufferedReader bf = new BufferedReader(fr);
					BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("./src/com/jnu/groupproject/jwc/3.txt"),"GBK"));
					String str;
					// 按行读取字符串
					while ((str= bf.readLine()) != null) {
						if(Pattern.matches(pattern, str)) {
							String [] spString = str.split("\\s+");	//以空格分割
							if(spString.length==6) {
								Score score = new Score();
								score.setNum(spString[0]);
								score.setName(spString[1]);
								score.setType(spString[2]);
								score.setScore(spString[3]);
								score.setCredit(spString[4]);
								score.setGPA(spString[5]);
								scores.add(score);
								System.out.println("符合条件"+score.getName());
							}
						}
					}
					bf.close();
					//fr.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//执行多条语句，用&&连接
				//验证containerPanel容器及其组件
				panelQueryScores.remove(scrollPane);
				panelQueryScores.remove(btnNewButton);
				
				initJScrollPane();
				//panelQueryScores.add(scrollPane);
				//验证containerPanel容器及其组件
				panelQueryScores.validate();
				//重绘组件
				panelQueryScores.repaint();
			}
		});  	
	}
	
	
}