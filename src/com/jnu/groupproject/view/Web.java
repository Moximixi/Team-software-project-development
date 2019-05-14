package com.jnu.groupproject.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class Web extends JPanel{

private static final long serialVersionUID = 1L;    
    
    private JPanel webBrowserPanel;    
    
    private JWebBrowser webBrowser;    
    
    private String url;    
    
    public Web(String url) {    
        super(new BorderLayout());    
        this.url = url;    
        webBrowserPanel = new JPanel(new BorderLayout());    
        webBrowser = new JWebBrowser();    
        webBrowser.navigate(url);    
        webBrowser.setButtonBarVisible(false);    
        webBrowser.setMenuBarVisible(false);    
        webBrowser.setBarsVisible(false);    
        webBrowser.setStatusBarVisible(false);    
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);    
        add(webBrowserPanel, BorderLayout.CENTER);    
        // webBrowser.executeJavascript("javascrpit:window.location.href='http://www.baidu.com'");        
    }    

}    

