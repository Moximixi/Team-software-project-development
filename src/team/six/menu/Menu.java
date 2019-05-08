package team.six.menu;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import team.six.panel.courseselect.PanelCourseSelect;
import team.six.panel.homepage.PanelHomePage;
import team.six.panel.queryscores.PanelQueryScores;
import team.six.panel.trainPlan.PanelTrainPlan;
import team.six.panel.userinfo.PanelUserInfo;


public class Menu {

	private JFrame frame;
	private JPanel panel= new JPanel();
	//private PanelCourseSelect panelCourseSelect=new PanelCourseSelect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu_homePage = new JMenu("校园生活");
		menu_homePage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(new PanelHomePage());
				panel.updateUI();
			}
		});
		menuBar.add(menu_homePage);
		
		JMenu menu_queryScores = new JMenu("查询成绩");
		menu_queryScores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(new PanelQueryScores());
				panel.updateUI();
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
			}
		});
		menuBar.add(menu_trainPlan);
		

		
		JMenu menu_document = new JMenu("文档应用");
		menu_document.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				//panel.add(new PanelDocument());
				panel.updateUI();
			}
		});
		menuBar.add(menu_document);
		
		JMenu menu_search = new JMenu("搜索");
		menu_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				//panel.add(new PanelSearch());
				panel.updateUI();
			}
		});
		menuBar.add(menu_search);
		
		JMenu menu_userInfo = new JMenu("用户信息管理");
		menu_userInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(new PanelUserInfo());
				panel.updateUI();
			}
		});
		menuBar.add(menu_userInfo);
		
		
		JMenu menu_logOut = new JMenu("注销");
		menuBar.add(menu_logOut);
		
		
		
	}
}
