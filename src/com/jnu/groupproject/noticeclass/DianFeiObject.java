package com.jnu.groupproject.noticeclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DianFeiObject {
	public String __VIEWSTATE;
	public String __EVENTVALIDATION;
	public String __12_value;
	public String __12_last_value;
	public String RegionPanel1$Region3$ContentPanel3$tb_ammeterNumb;
	DianFeiObject(String result) {
        String regEx = "id=\"__VIEWSTATE\" value=\".*?\"";
        String regEx2 = "id=\"__EVENTVALIDATION\" value=\".*?\"";
        String regEx3 = "id=\"__12_value\" value=\".*?\"";
        String regEx4 = "value=\".*?\" id=\"__12_last_value\"";
        String regEx5 = "id=\"RegionPanel1$Region3$ContentPanel3$tb_ammeterNumb\" value=\".*?\"";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        Pattern pattern2 = Pattern.compile(regEx2);
        Pattern pattern3 = Pattern.compile(regEx3);
        // 忽略大小写的写法
        Matcher matcher = pattern.matcher(result);
        Matcher matcher2 = pattern2.matcher(result);
        Matcher matcher3 = pattern3.matcher(result);
        if(matcher.find()) {
        	for(int i=0; i<=matcher.groupCount(); i++){  
        		__VIEWSTATE=matcher.group(i).substring(24, matcher.group(i).length()-1);
        	}  
        }
        if(matcher2.find()) {
       		for(int i=0; i<=matcher2.groupCount(); i++){  
       			__EVENTVALIDATION=matcher2.group(i).substring(30, matcher2.group(i).length()-1);
       		}  
       	}
        if(matcher3.find()) {
          	for(int i=0; i<=matcher3.groupCount(); i++){  
          		__12_value=matcher3.group(i).substring(23, matcher3.group(i).length()-1);
          		__12_last_value=matcher3.group(i).substring(23, matcher3.group(i).length()-1);
          		RegionPanel1$Region3$ContentPanel3$tb_ammeterNumb=__12_value.substring(0, 4)+__12_value.substring(5);
          	}  
        }
   }
	public String get__VIEWSTATE() {
		return __VIEWSTATE;
	}
	public void set__VIEWSTATE(String __VIEWSTATE) {
		this.__VIEWSTATE = __VIEWSTATE;
	}
	public String get__EVENTVALIDATION() {
		return __EVENTVALIDATION;
	}
	public void set__EVENTVALIDATION(String __EVENTVALIDATION) {
		this.__EVENTVALIDATION = __EVENTVALIDATION;
	}
	public String get__12_value() {
		return __12_value;
	}
	public void set__12_value(String __12_value) {
		this.__12_value = __12_value;
	}
	public String get__12_last_value() {
		return __12_last_value;
	}
	public void set__12_last_value(String __12_last_value) {
		this.__12_last_value = __12_last_value;
	}
	public String getRegionPanel1$Region3$ContentPanel3$tb_ammeterNumb() {
		return RegionPanel1$Region3$ContentPanel3$tb_ammeterNumb;
	}
	public void setRegionPanel1$Region3$ContentPanel3$tb_ammeterNumb(
			String regionPanel1$Region3$ContentPanel3$tb_ammeterNumb) {
		RegionPanel1$Region3$ContentPanel3$tb_ammeterNumb = regionPanel1$Region3$ContentPanel3$tb_ammeterNumb;
	}
}


