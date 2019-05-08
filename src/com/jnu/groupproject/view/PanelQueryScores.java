package com.jnu.groupproject.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class PanelQueryScores extends JPanel {
	private JTable table;



	/**
	 * Create the panel.
	 */
	public PanelQueryScores() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(490, 360, 181, 48);
		//btnNewButton.setBounds(565, 375, 93, 23);
		add(btnNewButton);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.BOLD, 20));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(40);//指定每一行的行高40
		table.setBounds(120, 45, 625, 280);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u8BFE\u7A0B", "\u6210\u7EE9"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u8BFE\u7A0B", "\u6210\u7EE9"
			}
		));
		add(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"  ", "大一上学期", "大一下学期", "大二上学期", "大二下学期", "大三上学期", "大三下学期", "大四上学期", "大四下学期", ""}));
		comboBox.setBounds(133, 370, 242, 38);
		add(comboBox);

	  
		  
	}
}