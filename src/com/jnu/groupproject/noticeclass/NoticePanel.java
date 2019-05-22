package com.jnu.groupproject.noticeclass;

import java.awt.BorderLayout;
import java.awt.FontMetrics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class NoticePanel extends JPanel {
	public JLabel contentLabel = new JLabel("New label");
	/**
	 * Create the panel.
	 */
	public NoticePanel( String content)throws InterruptedException {
		super(new BorderLayout());
		//noticeContent.setText(content); 
		contentLabel.setSize(400, 200);
		JlabelSetText(contentLabel, content);
	    add(contentLabel);
	    contentLabel.setBounds(0, 0, 450, 300);
		updateUI();
	}
	
	void JlabelSetText(JLabel jLabel, String longString) 
            throws InterruptedException {
        StringBuilder builder = new StringBuilder("<html>");
        char[] chars = longString.toCharArray();
        FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
        int start = 0;
        int len = 0;
        while (start + len < longString.length()) {
            while (chars[len]!=' ') {
               len++;
               if (start + len > longString.length())break;
               if (fontMetrics.charsWidth(chars, start, len) 
                       > jLabel.getWidth()) {
                   break;
               }
            }
            builder.append(chars, start, len-1).append("<br/>");
            start = start + len - 1;
            len = 0;
        }
        builder.append(chars, start, longString.length()-start);
        builder.append("</html>");
        jLabel.setText(builder.toString());
	}
	
	/*void JlabelSetText(JLabel jLabel, String longString) 
            throws InterruptedException {
        StringBuilder builder = new StringBuilder("<html>");
        char[] chars = longString.toCharArray();
        FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
        int start = 0;
        int len = 0;
        while (start + len < longString.length()) {
            while (true) {
                len++;
                if (start + len > longString.length())break;
                if (fontMetrics.charsWidth(chars, start, len) 
                        > jLabel.getWidth()) {
                    break;
                }
            }
            builder.append(chars, start, len-1).append("<br/>");
            start = start + len - 1;
            len = 0;
        }
        builder.append(chars, start, longString.length()-start);
        builder.append("</html>");
        jLabel.setText(builder.toString());
    }*/

}
