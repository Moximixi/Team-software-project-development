package com.jnu.groupproject.view;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel; 
public class PanelTrainPlan extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTable trainplan_table;
	private JPanel PanelTrainPlan;
	public PanelTrainPlan() {
		
		JPanel PanelTrainPlan=new JPanel();
		PanelTrainPlan.setForeground(Color.LIGHT_GRAY);
		PanelTrainPlan.setBounds(0, 0, 880, 470);
		add(PanelTrainPlan);
		trainplan_table = new JTable();
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		trainplan_table.setDefaultRenderer(Object.class, tcr);
		trainplan_table.setBorder(new LineBorder(new Color(0, 0, 0)));
		trainplan_table.setRowHeight(40);//指定每一行的行高40
		trainplan_table.setModel(new DefaultTableModel(
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
		){
			boolean[] columnEditables = new boolean[] {
					false, true, true, true, true, true
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		trainplan_table.getColumnModel().getColumn(0).setPreferredWidth(215);
		trainplan_table.getColumnModel().getColumn(0).setMinWidth(27);
		trainplan_table.getColumnModel().getColumn(0).setMaxWidth(220);
		trainplan_table.getColumnModel().getColumn(1).setPreferredWidth(50);
		trainplan_table.getColumnModel().getColumn(2).setPreferredWidth(190);
		trainplan_table.getColumnModel().getColumn(3).setPreferredWidth(50);
		trainplan_table.getColumnModel().getColumn(4).setPreferredWidth(164);
		trainplan_table.getColumnModel().getColumn(5).setPreferredWidth(50);
		trainplan_table.setBackground(SystemColor.textHighlightText);
		PanelTrainPlan.add(trainplan_table);
		
	}

}
