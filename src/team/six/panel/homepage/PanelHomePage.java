package team.six.panel.homepage;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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

	public PanelHomePage() {
		setLayout(null);
		
		JPanel HomePagePanel = new JPanel();
		HomePagePanel.setBounds(0, 0, 797, 441);
		add(HomePagePanel);
		HomePagePanel.setLayout(null);
		
		AllNoticePanel = new JPanel();
		AllNoticePanel.setBounds(40, 70, 471, 358);
		HomePagePanel.add(AllNoticePanel);
		AllNoticePanel.setLayout(null);
		
		JScrollBar AllNoticeScrollBar = new JScrollBar();
		AllNoticeScrollBar.setBounds(454, 0, 17, 358);
		AllNoticePanel.add(AllNoticeScrollBar);
		
		AllNoticeTable = new JTable();
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
		AllNoticeTable.setBounds(0, 0, 448, 358);
		AllNoticePanel.add(AllNoticeTable);
		
		SchoolNoticePanel = new JPanel();
		SchoolNoticePanel.setLayout(null);
		SchoolNoticePanel.setBounds(40, 70, 471, 358);
		HomePagePanel.add(SchoolNoticePanel);
		
		JScrollBar SchoolNoticeScrollBar = new JScrollBar();
		SchoolNoticeScrollBar.setBounds(454, 0, 17, 358);
		SchoolNoticePanel.add(SchoolNoticeScrollBar);
		
		SchoolNoticeTable = new JTable();
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
		SchoolNoticeTable.setBounds(0, 0, 448, 358);
		SchoolNoticePanel.add(SchoolNoticeTable);
		
		CollegeNoticePanel = new JPanel();
		CollegeNoticePanel.setLayout(null);
		CollegeNoticePanel.setBounds(40, 70, 471, 358);
		HomePagePanel.add(CollegeNoticePanel);
		
		JScrollBar CollegeNoticeScrollBar = new JScrollBar();
		CollegeNoticeScrollBar.setBounds(454, 0, 17, 358);
		CollegeNoticePanel.add(CollegeNoticeScrollBar);
		
		CollegeNoticeTable = new JTable();
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
		CollegeNoticeTable.setBounds(0, 0, 448, 358);
		CollegeNoticePanel.add(CollegeNoticeTable);
		
		AdministrationNoticePanel = new JPanel();
		AdministrationNoticePanel.setBounds(40, 70, 471, 358);
		HomePagePanel.add(AdministrationNoticePanel);
		AdministrationNoticePanel.setLayout(null);
		
		JScrollBar AdministrationNoticeScrollBar = new JScrollBar();
		AdministrationNoticeScrollBar.setBounds(454, 0, 17, 358);
		AdministrationNoticePanel.add(AdministrationNoticeScrollBar);
		
		AdministrationNoticeTable = new JTable();
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
		AdministrationNoticeTable.setBounds(0, 0, 448, 358);
		AdministrationNoticePanel.add(AdministrationNoticeTable);
		
		EmploymentNoticePanel = new JPanel();
		EmploymentNoticePanel.setBounds(40, 70, 471, 358);
		HomePagePanel.add(EmploymentNoticePanel);
		EmploymentNoticePanel.setLayout(null);
		
		JScrollBar EmploymentNoticeScrollBar = new JScrollBar();
		EmploymentNoticeScrollBar.setBounds(454, 0, 17, 358);
		EmploymentNoticePanel.add(EmploymentNoticeScrollBar);
		
		EmploymentNoticeTable = new JTable();
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
		EmploymentNoticeTable.setBounds(0, 0, 448, 358);
		EmploymentNoticePanel.add(EmploymentNoticeTable);
		
		JLabel label = new JLabel("全部通知");
		label.setBounds(40, 30, 80, 40);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		HomePagePanel.add(label);
		
		JRadioButton AllNoticeButton = new JRadioButton("全部通知");
		AllNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				HomePagePanel.add(AllNoticePanel);
				HomePagePanel.updateUI();
				
			}
		});
		AllNoticeButton.setBounds(126, 41, 73, 23);
		buttonGroup.add(AllNoticeButton);
		HomePagePanel.add(AllNoticeButton);
		
		JRadioButton SchoolNoticeButton = new JRadioButton("校内通知");
		SchoolNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//HomePagePanel.removeAll();
				HomePagePanel.add(SchoolNoticePanel);
				HomePagePanel.updateUI();
			}
		});
		SchoolNoticeButton.setBounds(201, 41, 73, 23);
		buttonGroup.add(SchoolNoticeButton);
		HomePagePanel.add(SchoolNoticeButton);
		
		JRadioButton CollegeNoticeButton = new JRadioButton("学院通知");
		CollegeNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePagePanel.add(CollegeNoticePanel);
				HomePagePanel.updateUI();
			}
		});
		CollegeNoticeButton.setBounds(276, 41, 73, 23);
		buttonGroup.add(CollegeNoticeButton);
		HomePagePanel.add(CollegeNoticeButton);
		
		JRadioButton AdministrationNoticeButton = new JRadioButton("教务处通知");
		AdministrationNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePagePanel.add(AdministrationNoticePanel);
				HomePagePanel.updateUI();
			}
		});
		AdministrationNoticeButton.setBounds(351, 41, 95, 23);
		buttonGroup.add(AdministrationNoticeButton);
		HomePagePanel.add(AdministrationNoticeButton);
		
		JRadioButton EmploymentNoticeButton = new JRadioButton("就业通知");
		EmploymentNoticeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePagePanel.add(EmploymentNoticePanel);
				HomePagePanel.updateUI();
			}
		});
		EmploymentNoticeButton.setBounds(448, 41, 73, 23);
		buttonGroup.add(EmploymentNoticeButton);
		HomePagePanel.add(EmploymentNoticeButton);
		
		JLabel RelativeInformationLabel = new JLabel("个人相关信息");
		RelativeInformationLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		RelativeInformationLabel.setBounds(535, 30, 115, 40);
		HomePagePanel.add(RelativeInformationLabel);
		
		JLabel SchoolCardLabel = new JLabel("一卡通");
		SchoolCardLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		SchoolCardLabel.setBounds(535, 92, 67, 40);
		HomePagePanel.add(SchoolCardLabel);
		
		JLabel ElectricityFeesLabel = new JLabel("电  费");
		ElectricityFeesLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		ElectricityFeesLabel.setBounds(535, 159, 67, 40);
		HomePagePanel.add(ElectricityFeesLabel);
		
		JLabel SchoolForumLabel = new JLabel("学校论坛");
		SchoolForumLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		SchoolForumLabel.setBounds(536, 269, 80, 40);
		HomePagePanel.add(SchoolForumLabel);
		
		JButton EnterSchoolFroumButton = new JButton("进入论坛");
		EnterSchoolFroumButton.setBounds(694, 408, 93, 23);
		HomePagePanel.add(EnterSchoolFroumButton);
		
		JLabel SchoolCardBalanceLabel = new JLabel("余额：80元");
		SchoolCardBalanceLabel.setBounds(596, 89, 73, 15);
		HomePagePanel.add(SchoolCardBalanceLabel);
		
		JLabel SchoolCardStatusLabel = new JLabel("账号状态：正常");
		SchoolCardStatusLabel.setBounds(596, 117, 93, 15);
		HomePagePanel.add(SchoolCardStatusLabel);
		
		JLabel ElectricityFeesBalanceLabel = new JLabel("剩余电量：170度");
		ElectricityFeesBalanceLabel.setBounds(596, 157, 93, 15);
		HomePagePanel.add(ElectricityFeesBalanceLabel);
		
		JLabel ElectricityStatusLabel = new JLabel("使用状态：正常");
		ElectricityStatusLabel.setBounds(596, 184, 93, 15);
		HomePagePanel.add(ElectricityStatusLabel);
		
		JButton SchoolCardRechargeButton = new JButton("充值");
		SchoolCardRechargeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		SchoolCardRechargeButton.setBounds(694, 85, 93, 23);
		HomePagePanel.add(SchoolCardRechargeButton);
		
		JButton SchoolCardLossButton = new JButton("挂失");
		SchoolCardLossButton.setBounds(694, 113, 93, 23);
		HomePagePanel.add(SchoolCardLossButton);
		
		JButton ElectricityRechargeButton = new JButton("充值");
		ElectricityRechargeButton.setBounds(694, 153, 93, 23);
		HomePagePanel.add(ElectricityRechargeButton);
		
		JButton ElectricityChargeRecordButton = new JButton("查看记录");
		ElectricityChargeRecordButton.setBounds(694, 182, 93, 23);
		HomePagePanel.add(ElectricityChargeRecordButton);

	}
}
