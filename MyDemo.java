import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

public class MyDemo {

	private JFrame frame;
	private JPanel panel_courseSelect;
	private JPanel panel_trainPlan;
	private JPanel panel_document;
	private JPanel panel_userInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyDemo window = new MyDemo();
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
	public MyDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_homePage = new JPanel();
		panel.add(panel_homePage);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("我的首页");
		panel_homePage.add(textPane);
		
		JPanel panel_querySocres = new JPanel();
		panel.add(panel_querySocres);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("查询成绩");
		panel_querySocres.add(textPane_1);
		
		JPanel panel_courseSelect;
		panel_courseSelect = new JPanel();
		panel.add(panel_courseSelect);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("选课");
		panel_courseSelect.add(textPane_2);
		
		JPanel panel_trainPlan;
		panel_trainPlan = new JPanel();
		panel.add(panel_trainPlan);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("培养方案");
		panel_trainPlan.add(textPane_3);
		
		JPanel panel_document;
		panel_document = new JPanel();
		panel.add(panel_document);
		
		JPanel panel_userInfo;
		panel_userInfo = new JPanel();
		panel.add(panel_userInfo);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu_homePage = new JMenu("\u6211\u7684\u9996\u9875");
		menu_homePage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				panel.add(panel_homePage);
				panel.updateUI();
			}
		});
		menuBar.add(menu_homePage);
		
		JMenu menu_querySocres = new JMenu("\u67E5\u8BE2\u6210\u7EE9");
		menu_querySocres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(panel_querySocres);
				panel.updateUI();
			}
		});
		menuBar.add(menu_querySocres);
		
		JMenu menu_courseSelect = new JMenu("\u9009\u8BFE\u7CFB\u7EDF");
		menuBar.add(menu_courseSelect);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u67E5\u8BE2\u9009\u8BFE");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.removeAll();
				panel.add(panel_courseSelect);
				panel.updateUI();
			}
		});
		menu_courseSelect.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9009\u8BFE\u5217\u8868");
		menu_courseSelect.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem = new JMenuItem("\u6211\u7684\u9009\u8BFE");
		menu_courseSelect.add(menuItem);
		
		JMenu menu_trainPlan = new JMenu("\u57F9\u517B\u65B9\u6848");
		menu_trainPlan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(panel_trainPlan);
				panel.updateUI();
			}
		});
		menuBar.add(menu_trainPlan);
		
		JMenu menu_document = new JMenu("\u6587\u6863\u5E94\u7528");
		menuBar.add(menu_document);
		
		JMenu menu_userInfo = new JMenu("\u7528\u6237\u4FE1\u606F");
		menuBar.add(menu_userInfo);
		
		JMenu menu_logOut = new JMenu("\u6CE8\u9500");
		menuBar.add(menu_logOut);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
	}
}
