package team.six.panel.queryscores;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
		btnNewButton.setBounds(265, 214, 93, 23);
		add(btnNewButton);
		
		table = new JTable();
		table.setBounds(52, 10, 330, 171);
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
		comboBox.setBounds(52, 215, 167, 21);
		add(comboBox);

	  
		  
	}
}