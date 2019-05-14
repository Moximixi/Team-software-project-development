package com.jnu.groupproject.view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelHomePage extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable AllNoticeTable;
	private JTable AdministrationNoticeTable;
	private JTable SchoolNoticeTable;
	private JTable CollegeNoticeTable;
	private JTable EmploymentNoticeTable;
	private JPanel AllNoticePanel; 
	private JPanel SchoolNoticePanel; 
	private JPanel CollegeNoticePanel; 
	private JPanel AdministrationNoticePanel; 
	private JPanel EmploymentNoticePanel; 
    private Logger log = Logger.getLogger(PanelUserInfo.class);  
    
    public JButton EnterSchoolFroumButton;
    

	public PanelHomePage() {
		PropertyConfigurator.configure("log4j.properties");
		setLayout(null);
		
		JPanel HomePagePanel = new JPanel();
		HomePagePanel.setBounds(0, 0, 880, 460);
		add(HomePagePanel);
		HomePagePanel.setLayout(null);
		
		AllNoticePanel = new JPanel();
		AllNoticePanel.setBounds(40, 70, 570, 358);
		HomePagePanel.add(AllNoticePanel);
		AllNoticePanel.setLayout(null);
		
		JScrollBar AllNoticeScrollBar = new JScrollBar();
		AllNoticeScrollBar.setBounds(550, 0, 17, 358);
		AllNoticePanel.add(AllNoticeScrollBar);
		
		DefaultTableCellRenderer tabletcr = new DefaultTableCellRenderer();// 设置table内容居中
		tabletcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		AllNoticeTable = new JTable();
		AllNoticeTable.setDefaultRenderer(Object.class, tabletcr);
		AllNoticeTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		AllNoticeTable.setRowHeight(30);//指定每一行的行高30
		AllNoticeTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u901A\u77E5", "\u53D1\u5E03\u6765\u6E90", "\u53D1\u5E03\u65F6\u95F4"},
				{"1", "1", "1"},
				{"1", "1", "1"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		AllNoticeTable.setBounds(0, 0, 550, 358);
		AllNoticePanel.add(AllNoticeTable);
		AllNoticeTable.setFont(new Font("宋体", Font.PLAIN, 14));// 设置表格字体
		AllNoticeTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		AllNoticeTable.getColumnModel().getColumn(0).setPreferredWidth(350);
		AllNoticeTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		AllNoticeTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		SchoolNoticePanel = new JPanel();
		SchoolNoticePanel.setLayout(null);
		SchoolNoticePanel.setBounds(40, 70, 570, 358);
		HomePagePanel.add(SchoolNoticePanel);
		JScrollBar SchoolNoticeScrollBar = new JScrollBar();
		SchoolNoticeScrollBar.setBounds(550, 0, 17, 358);
		SchoolNoticePanel.add(SchoolNoticeScrollBar);
		
		SchoolNoticeTable = new JTable();
		SchoolNoticeTable.setDefaultRenderer(Object.class, tabletcr);
		SchoolNoticeTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		SchoolNoticeTable.setRowHeight(30);//指定每一行的行高30
		SchoolNoticeTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u901A\u77E5", "\u53D1\u5E03\u6765\u6E90", "\u53D1\u5E03\u65F6\u95F4"},
				{"2", "2", "2"},
				{"2", "2", "2"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		SchoolNoticeTable.setBounds(0, 0, 550, 358);
		SchoolNoticePanel.add(SchoolNoticeTable);
		SchoolNoticeTable.setFont(new Font("宋体", Font.PLAIN, 14));// 设置表格字体
		SchoolNoticeTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		SchoolNoticeTable.getColumnModel().getColumn(0).setPreferredWidth(350);
		SchoolNoticeTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		SchoolNoticeTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		CollegeNoticePanel = new JPanel();
		CollegeNoticePanel.setLayout(null);
		CollegeNoticePanel.setBounds(40, 70, 570, 358);
		HomePagePanel.add(CollegeNoticePanel);
		JScrollBar CollegeNoticeScrollBar = new JScrollBar();
		CollegeNoticeScrollBar.setBounds(550, 0, 17, 358);
		CollegeNoticePanel.add(CollegeNoticeScrollBar);
		CollegeNoticeTable = new JTable();
		CollegeNoticeTable.setDefaultRenderer(Object.class, tabletcr);
		CollegeNoticeTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		CollegeNoticeTable.setRowHeight(30);//指定每一行的行高30
		CollegeNoticeTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u901A\u77E5", "\u53D1\u5E03\u6765\u6E90", "\u53D1\u5E03\u65F6\u95F4"},
				{"3", "3", "3"},
				{"3", "3", "3"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		CollegeNoticeTable.setBounds(0, 0, 550, 358);
		CollegeNoticePanel.add(CollegeNoticeTable);
		CollegeNoticeTable.setFont(new Font("宋体", Font.PLAIN, 14));// 设置表格字体
		CollegeNoticeTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		CollegeNoticeTable.getColumnModel().getColumn(0).setPreferredWidth(350);
		CollegeNoticeTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		CollegeNoticeTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		AdministrationNoticePanel = new JPanel();
		AdministrationNoticePanel.setBounds(40, 70, 570, 358);
		HomePagePanel.add(AdministrationNoticePanel);
		AdministrationNoticePanel.setLayout(null);
		JScrollBar AdministrationNoticeScrollBar = new JScrollBar();
		AdministrationNoticeScrollBar.setBounds(550, 0, 17, 358);
		AdministrationNoticePanel.add(AdministrationNoticeScrollBar);
		AdministrationNoticeTable = new JTable();
		AdministrationNoticeTable.setDefaultRenderer(Object.class, tabletcr);
		AdministrationNoticeTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		AdministrationNoticeTable.setRowHeight(30);//指定每一行的行高30
		AdministrationNoticeTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u901A\u77E5", "\u53D1\u5E03\u6765\u6E90", "\u53D1\u5E03\u65F6\u95F4"},
				{"4", "4", "4"},
				{"4", "4", "4"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		AdministrationNoticeTable.setBounds(0, 0, 550, 358);
		AdministrationNoticePanel.add(AdministrationNoticeTable);
		AdministrationNoticeTable.setFont(new Font("宋体", Font.PLAIN, 14));// 设置表格字体
		AdministrationNoticeTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		AdministrationNoticeTable.getColumnModel().getColumn(0).setPreferredWidth(350);
		AdministrationNoticeTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		AdministrationNoticeTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		EmploymentNoticePanel = new JPanel();
		EmploymentNoticePanel.setBounds(40, 70, 570, 358);
		HomePagePanel.add(EmploymentNoticePanel);
		EmploymentNoticePanel.setLayout(null);
		
		JScrollBar EmploymentNoticeScrollBar = new JScrollBar();
		EmploymentNoticeScrollBar.setBounds(550, 0, 17, 358);
		EmploymentNoticePanel.add(EmploymentNoticeScrollBar);
		EmploymentNoticeTable = new JTable();
		EmploymentNoticeTable.setDefaultRenderer(Object.class, tabletcr);
		EmploymentNoticeTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		EmploymentNoticeTable.setRowHeight(30);//指定每一行的行高30
		EmploymentNoticeTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u901A\u77E5", "\u53D1\u5E03\u6765\u6E90", "\u53D1\u5E03\u65F6\u95F4"},
				{"5", "5", "5"},
				{"5", "5", "5"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		EmploymentNoticeTable.setBounds(0, 0, 550, 358);
		EmploymentNoticePanel.add(EmploymentNoticeTable);
		EmploymentNoticeTable.setFont(new Font("宋体", Font.PLAIN, 14));// 设置表格字体
		EmploymentNoticeTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		EmploymentNoticeTable.getColumnModel().getColumn(0).setPreferredWidth(350);
		EmploymentNoticeTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		EmploymentNoticeTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		
		JLabel label = new JLabel("全部通知");
		label.setBounds(33, 29, 93, 40);
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		HomePagePanel.add(label);
		
		JRadioButton AllNoticeButton = new JRadioButton("全部通知");
		AllNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		AllNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AllNoticePanel.setVisible(true);
				SchoolNoticePanel.setVisible(false);
				CollegeNoticePanel.setVisible(false);
				AdministrationNoticePanel.setVisible(false);
				EmploymentNoticePanel.setVisible(false);
				HomePagePanel.updateUI();
				
			}
		});
		AllNoticeButton.setBounds(132, 41, 83, 23);
		buttonGroup.add(AllNoticeButton);
		HomePagePanel.add(AllNoticeButton);
		
		JRadioButton SchoolNoticeButton = new JRadioButton("校内通知");
		SchoolNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		SchoolNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AllNoticePanel.setVisible(false);
				SchoolNoticePanel.setVisible(true);
				CollegeNoticePanel.setVisible(false);
				AdministrationNoticePanel.setVisible(false);
				EmploymentNoticePanel.setVisible(false);
				HomePagePanel.updateUI();
			}
		});
		SchoolNoticeButton.setBounds(217, 41, 93, 23);
		buttonGroup.add(SchoolNoticeButton);
		HomePagePanel.add(SchoolNoticeButton);
		
		JRadioButton CollegeNoticeButton = new JRadioButton("学院通知");
		CollegeNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		CollegeNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AllNoticePanel.setVisible(false);
				SchoolNoticePanel.setVisible(false);
				CollegeNoticePanel.setVisible(true);
				AdministrationNoticePanel.setVisible(false);
				EmploymentNoticePanel.setVisible(false);
				HomePagePanel.updateUI();
			}
		});
		CollegeNoticeButton.setBounds(312, 41, 93, 23);
		buttonGroup.add(CollegeNoticeButton);
		HomePagePanel.add(CollegeNoticeButton);
		
		JRadioButton AdministrationNoticeButton = new JRadioButton("教务处通知");
		AdministrationNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		AdministrationNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AllNoticePanel.setVisible(false);
				SchoolNoticePanel.setVisible(false);
				CollegeNoticePanel.setVisible(false);
				AdministrationNoticePanel.setVisible(true);
				EmploymentNoticePanel.setVisible(false);
				HomePagePanel.updateUI();
			}
		});
		AdministrationNoticeButton.setBounds(407, 41, 110, 23);
		buttonGroup.add(AdministrationNoticeButton);
		HomePagePanel.add(AdministrationNoticeButton);
		
		JRadioButton EmploymentNoticeButton = new JRadioButton("就业通知");
		EmploymentNoticeButton.setFont(new Font("宋体", Font.PLAIN, 14));
		EmploymentNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AllNoticePanel.setVisible(false);
				SchoolNoticePanel.setVisible(false);
				CollegeNoticePanel.setVisible(false);
				AdministrationNoticePanel.setVisible(false);
				EmploymentNoticePanel.setVisible(true);
				HomePagePanel.updateUI();
			}
		});
		EmploymentNoticeButton.setBounds(519, 41, 93, 23);
		buttonGroup.add(EmploymentNoticeButton);
		HomePagePanel.add(EmploymentNoticeButton);
		
		JLabel RelativeInformationLabel = new JLabel("个人相关信息");
		RelativeInformationLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		RelativeInformationLabel.setBounds(618, 27, 115, 40);
		HomePagePanel.add(RelativeInformationLabel);
		
		JLabel SchoolCardLabel = new JLabel("一卡通");
		SchoolCardLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		SchoolCardLabel.setBounds(618, 89, 67, 40);
		HomePagePanel.add(SchoolCardLabel);
		
		JLabel ElectricityFeesLabel = new JLabel("电  费");
		ElectricityFeesLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		ElectricityFeesLabel.setBounds(618, 156, 67, 40);
		HomePagePanel.add(ElectricityFeesLabel);
		
		JLabel SchoolForumLabel = new JLabel("学校论坛");
		SchoolForumLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		SchoolForumLabel.setBounds(619, 266, 80, 40);
		HomePagePanel.add(SchoolForumLabel);
		
		EnterSchoolFroumButton = new JButton("进入论坛");
		EnterSchoolFroumButton.setBounds(785, 405, 93, 23);
		HomePagePanel.add(EnterSchoolFroumButton);
		
		JLabel SchoolCardBalanceLabel = new JLabel("余额：80元");
		SchoolCardBalanceLabel.setBounds(679, 86, 73, 15);
		HomePagePanel.add(SchoolCardBalanceLabel);
		
		JLabel SchoolCardStatusLabel = new JLabel("账号状态：正常");
		SchoolCardStatusLabel.setBounds(679, 114, 93, 15);
		HomePagePanel.add(SchoolCardStatusLabel);
		
		JLabel ElectricityFeesBalanceLabel = new JLabel("剩余电量：170度");
		ElectricityFeesBalanceLabel.setBounds(679, 154, 110, 15);
		HomePagePanel.add(ElectricityFeesBalanceLabel);
		
		JLabel ElectricityStatusLabel = new JLabel("使用状态：正常");
		ElectricityStatusLabel.setBounds(679, 181, 93, 15);
		HomePagePanel.add(ElectricityStatusLabel);
		
		JButton SchoolCardRechargeButton = new JButton("充值");
		SchoolCardRechargeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(SchoolCardStatusLabel.getText().equals("账号状态：正常"))
					log.info("土豪充值了饭卡");
				else
					log.error("脑子有洞，饭卡都挂失了充什么饭卡？");
			}
		});
		SchoolCardRechargeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		SchoolCardRechargeButton.setBounds(785, 83, 93, 23);
		HomePagePanel.add(SchoolCardRechargeButton);
		
		JButton SchoolCardLossButton = new JButton("挂失");
		SchoolCardLossButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SchoolCardStatusLabel.getText().equals("账号状态：正常")) {
					log.info("饭卡丢了，赶紧挂失饭卡");
					SchoolCardStatusLabel.setText("账号状态：挂失");
				}
				else
					log.warn("本来就是挂失的，还挂失什么");
				HomePagePanel.updateUI();
			}
		});
		SchoolCardLossButton.setBounds(785, 113, 93, 23);
		HomePagePanel.add(SchoolCardLossButton);
		
		JButton ElectricityRechargeButton = new JButton("充值");
		ElectricityRechargeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				log.info("土豪充值了电费"); 
			}
		});
		ElectricityRechargeButton.setBounds(785, 153, 93, 23);
		HomePagePanel.add(ElectricityRechargeButton);
		
		JButton ElectricityChargeRecordButton = new JButton("查看记录");
		ElectricityChargeRecordButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				log.info("有人偷偷查了电费记录");
			}
		});
		ElectricityChargeRecordButton.setBounds(785, 183, 93, 23);
		HomePagePanel.add(ElectricityChargeRecordButton);

	}
}
