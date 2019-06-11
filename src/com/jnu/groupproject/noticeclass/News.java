package com.jnu.groupproject.noticeclass;

import java.io.Serializable;
import java.util.Comparator;

public class News implements Serializable {
	public String title;
	public String time;
	public String source;
	public String url;
	public String content;
	
	
	public News() {
		// TODO 自动生成的构造函数存根
	}

	//排序
	 public static class titleComparator implements Comparator<News> {
	        @Override
	        public int compare(News news1, News news2) {
	            return news2.getTitle().compareTo(news1.getTitle());
	        }
	    }



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
