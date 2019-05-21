package com.jnu.groupproject.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import org.apache.log4j.Logger;



import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

public class Menu {

	private Logger log = Logger.getLogger(PanelUserInfo.class); 
	private JFrame frame;
	public static JPanel panel= new JPanel();
	//private PanelCourseSelect panelCourseSelect=new PanelCourseSelect();
	
	public static void main(String[] args) {
//		UIUtils.setPreferredLookAndFeel();
//		NativeInterface.open();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		initialize();
	}

	private void initialize() {
		//设置初始界面
		panel.add(new PanelRegister());
		
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//校园生活
		/*JMenu menu_homePage = new JMenu("校园生活");
		PanelHomePage homePagePanel=new PanelHomePage();
		menu_homePage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(homePagePanel);
				panel.updateUI();
				log.info("点击菜单[校园生活]");	//1111111111111111111111111
			}
		});
		menuBar.add(menu_homePage);
		homePagePanel.EnterSchoolFroumButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
					try {    
						panel.removeAll();
						panel.add(new Web("http://bbs.jnlts.com/"));
						panel.updateUI();
					} catch (Exception e) {
						e.printStackTrace();
						}
					}
				});
			}
		});*/
		JMenu menu_homePage = new JMenu("校园生活");
		PanelHomePage homePagePanel=new PanelHomePage();
		menu_homePage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(homePagePanel);
				panel.updateUI();
				log.info("点击菜单[校园生活]");	//1111111111111111111111111
			}
		});
		menuBar.add(menu_homePage);
		homePagePanel.EnterSchoolFroumButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
					try {    
						panel.removeAll();
						panel.add(new Web("http://bbs.jnlts.com/"));
						panel.updateUI();
					} catch (Exception e) {
						e.printStackTrace();
						}
					}
				});
			}
		});
		homePagePanel.ElectricityChargeRecordButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
					try {    
						panel.removeAll();
						panel.add(new Web("http://202.116.25.12/Login.aspx"));
						panel.updateUI();
					} catch (Exception e) {
						e.printStackTrace();
						}
					}
				});
			}
		});
		homePagePanel.ElectricityQueryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				log.info("查询了电费"); 
				try {
					ElectricityCharges electricitycharge=new ElectricityCharges();
					homePagePanel.ElectricityFeesBalanceLabel.setText("剩余电量："+electricitycharge.restcharge);
					panel.updateUI();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}

		
			}
		});
		
		JMenu menu_queryScores = new JMenu("查询成绩");
		menu_queryScores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(new PanelQueryScores());
				panel.updateUI();
				log.info("点击菜单[查询成绩]");	//1111111111111111111111111
			}
		});
		menuBar.add(menu_queryScores);
		
		JMenu menu_courseSelect = new JMenu("选课系统");
		menu_courseSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(new PanelCourseSelect());
				panel.updateUI();
				log.info("点击菜单[选课系统]");	//1111111111111111111111111
			}
		});
		menuBar.add(menu_courseSelect);
		
		JMenu menu_trainPlan = new JMenu("培养方案");
		menu_trainPlan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(new PanelTrainPlan());
				panel.updateUI();
				log.info("点击菜单[培养方案]");	//1111111111111111111111111
			}
		});
		menuBar.add(menu_trainPlan);
		

		
		JMenu menu_document = new JMenu("文档应用");
		menu_document.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(new PanelDocument());
				panel.updateUI();
				log.info("点击菜单[文档应用]");	//1111111111111111111111111
			}
		});
		menuBar.add(menu_document);
		
		JMenu menu_search = new JMenu("搜索");
		menu_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(new PanelSearch());
				panel.updateUI();
				log.info("点击菜单[搜索]");	//1111111111111111111111111
			}
		});
		menuBar.add(menu_search);
		
		JMenu menu_userInfo = new JMenu("用户信息查看");
		menu_userInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(new PanelUserInfo());
				panel.updateUI();
				log.info("点击菜单[用户信息管理]");	//1111111111111111111111111
			}
		});
		menuBar.add(menu_userInfo);
		
		JMenu menu_userInfoRegister = new JMenu("用户信息管理");
		menu_userInfoRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(new PanelRegister());
				panel.updateUI();
				log.info("点击菜单[用户信息编辑]");	//1111111111111111111111111
			}
		});
		menuBar.add(menu_userInfoRegister);
		
		/*
		 * 取消登录界面
		 * */
//		JMenu menu_logOut = new JMenu("注销");
//		menu_logOut.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				panel.removeAll();
//				panel.add(new PanelLogin());
//				panel.updateUI();
//				log.info("点击菜单[注销]");	//1111111111111111111111111
//			}
//		});
//		menuBar.add(menu_logOut);
		
		//NativeInterface.runEventPump();
	}
}
