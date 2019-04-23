package teamproject;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.Rectangle;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MyDemo {

	private JFrame frame;
	private JPanel panel_courseSelect;
	private JPanel panel_trainPlan;
	private JPanel panel_document;
	private JPanel panel_userInfo;
	private JTable table;
	private JTable trainpan_table;

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
		panel_homePage.setForeground(new Color(0, 0, 255));
		panel.add(panel_homePage);
		
		table = new JTable();
		JPanel panel_trainPlan;
		panel_trainPlan = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_trainPlan.getLayout();
		flowLayout.setVgap(150);
		panel.add(panel_trainPlan);
		panel_trainPlan.add(table);
		
		trainpan_table = new JTable();
		trainpan_table.setBorder(new LineBorder(Color.GRAY, 3));
		trainpan_table.setFont(new Font("\u5B8B\u4F53", trainpan_table.getFont().getStyle(), trainpan_table.getFont().getSize() + 4));
		trainpan_table.setColumnSelectionAllowed(true);
		trainpan_table.setCellSelectionEnabled(true);
		trainpan_table.setBounds(new Rectangle(20, 100, 0, 0));
		trainpan_table.setModel(new DefaultTableModel(
			new Object[][] {
				{"       \u9AD8\u82F1\u8BFE\u7A0B\u7FA4", "4.0", " \u8F6F\u4EF6\u5DE5\u7A0B\u4E13\u4E1A\u57FA\u7840\u77E5\u8BC6\u7FA4", "", "\u8F6F\u4EF6\u5DE5\u7A0B\u77E5\u8BC6\u7FA4", null},
				{" \u4F53\u80B2\u7ADE\u6280\u4E0E\u4F11\u95F2\u8FD0\u52A8\u8BFE\u7A0B\u7FA4", "2.0", "    \u8F6F\u4EF6\u5DE5\u7A0B\u77E5\u8BC6\u7FA4", "5.0", "\u8F6F\u4EF6\u5DE5\u7A0B\u77E5\u8BC6\u7FA4\uFF08\u4E00\uFF09", null},
				{"  \u521B\u65B0\u521B\u4E1A\u5FC3\u7406\u7C7B\u8BFE\u7A0B\u7FA4", "6.0", "   \u8F6F\u4EF6\u7CFB\u7EDF\u5E94\u7528\u77E5\u8BC6\u7FA4", "5.0", "\u8F6F\u4EF6\u5DE5\u7A0B\u77E5\u8BC6\u7FA4\uFF08\u4E8C\uFF09", null},
				{"       \u827A\u672F\u7D20\u517B\u7C7B", "2.0", "    \u5B9E\u9A8C\u6280\u80FD\u57F9\u517B\u73AF\u8282", null, "\u8F6F\u4EF6\u5DE5\u7A0B\u77E5\u8BC6\u7FA4\uFF08\u4E09\uFF09", null},
				{"      \u7ECF\u7BA1\u6CD5\u7C7B", "2.0", "     \u521B\u65B0\u521B\u4E1A\u77E5\u8BC6\u7FA4", null, "\u8F6F\u4EF6\u7CFB\u7EDF\u5E94\u7528\u77E5\u8BC6\u7FA4", "5.0"},
				{null, null, null, null, "\u6269\u5C55\u77E5\u8BC6\u7FA4", "5.0"},
				{null, null, null, null, "\u8F6F\u4EF6\u7CFB\u7EDF\u5E94\u7528\u77E5\u8BC6\u7FA4", null},
				{null, null, null, null, "\u521B\u65B0\u521B\u4E1A\u77E5\u8BC6\u7FA4", null},
			},
			new String[] {
				"\u901A\u8BC6\u9009\u4FEE\u8BFE\u7A0B\u7FA4", "\u5B66\u5206", "\u57FA\u7840\u6559\u80B2\u5FC5\u4FEE\u8BFE\u7A0B\u7FA4", "\u5B66\u5206", "\u57FA\u7840\u6559\u80B2\u9009\u4FEE\u8BFE\u7A0B\u7FA4", "\u5B66\u5206"
			}
		));
		trainpan_table.getColumnModel().getColumn(0).setPreferredWidth(215);
		trainpan_table.getColumnModel().getColumn(0).setMinWidth(27);
		trainpan_table.getColumnModel().getColumn(0).setMaxWidth(220);
		trainpan_table.getColumnModel().getColumn(1).setPreferredWidth(50);
		trainpan_table.getColumnModel().getColumn(2).setPreferredWidth(190);
		trainpan_table.getColumnModel().getColumn(3).setPreferredWidth(50);
		trainpan_table.getColumnModel().getColumn(4).setPreferredWidth(164);
		trainpan_table.getColumnModel().getColumn(5).setPreferredWidth(50);
		trainpan_table.setBackground(SystemColor.textHighlightText);
		panel_trainPlan.add(trainpan_table);
		
		
		
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
