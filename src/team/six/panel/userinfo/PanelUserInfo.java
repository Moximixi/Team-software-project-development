package team.six.panel.userinfo;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class PanelUserInfo extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelUserInfo() {
		setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.BOLD, 14));
		table.setRowHeight(20);//指定每一行的行高20

		table.setBounds(382, 128, 418, 160);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u7F51\u7AD9", "\u8D26\u53F7", "\u5BC6\u7801"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		add(table);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(32, 99, 54, 15);
		add(lblNewLabel);
		
		JLabel label = new JLabel("刘虎");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(134, 99, 54, 15);
		add(label);
		
		JLabel label_1 = new JLabel("学号");
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		label_1.setBounds(32, 199, 54, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("寝室号");
		label_2.setFont(new Font("宋体", Font.BOLD, 16));
		label_2.setBounds(32, 249, 54, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("出生日期");
		label_3.setFont(new Font("宋体", Font.BOLD, 16));
		label_3.setBounds(32, 299, 73, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("2016023545");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(134, 199, 73, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("3865");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(134, 249, 54, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("19981024");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		label_6.setBounds(134, 299, 73, 15);
		add(label_6);
		
		JLabel label_7 = new JLabel("性别");
		label_7.setFont(new Font("宋体", Font.BOLD, 16));
		label_7.setBounds(32, 149, 54, 15);
		add(label_7);
		
		JLabel label_8 = new JLabel("男");
		label_8.setFont(new Font("宋体", Font.PLAIN, 14));
		label_8.setBounds(134, 149, 54, 15);
		add(label_8);

	}
}
