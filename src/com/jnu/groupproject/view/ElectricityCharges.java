package com.jnu.groupproject.view;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.HttpSSLClient;

public class ElectricityCharges {
	public String restcharge;
	public String Cookie;
	ElectricityCharges(){
		/*try {
		HttpSSLClient client = new HttpSSLClient();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			//创建一个工具类
			HttpSSLClient sslclient = new HttpSSLClient();
			//提交的地址
			String posturl = "http://202.116.25.12/default.aspx";
			//设置数据包头
			HashMap<String ,String> headers = new HashMap<String ,String>();
			headers.put("Accept", "*/*");
			headers.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
			headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 SE 2.X MetaSr 1.0");
			headers.put("Cookie", "LoginRMFindSystem2=3317|28485; .ASPXAUTH=C12099A112E688A83B69B338C5C6CB78E5DBE2DB42C8881D7CA5D0242F8F8DBE39E85D88AD36D0F20B2DA22D3AA179BBA31C523611291884637D54DA2A71171F535F377E8CCE5B3D99649BFFA15BE96E168733EB1984033A2E531935838D3B311BFAD43E43F8452BBEF2A21B216B41C256283447");
			//组织提交数据
			HashMap< String, String> keyvalue = new HashMap<String, String>();
			keyvalue.put("__EVENTTARGET", "RegionPanel1$Region2$GroupPanel1$ContentPanel1$DDL_监控项目");
			keyvalue.put("__VIEWSTATE", "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b25QYW5lbDEkUmVnaW9uMyRDb250ZW50UGFuZWwzJEJ1dHRvbjQFFFJlZ2lvblBhbmVsMSRSZWdpb24yBSBSZWdpb25QYW5lbDEkUmVnaW9uMiRHcm91cFBhbmVsMQUuUmVnaW9uUGFuZWwxJFJlZ2lvbjIkR3JvdXBQYW5lbDEkQ29udGVudFBhbmVsMQU/UmVnaW9uUGFuZWwxJFJlZ2lvbjIkR3JvdXBQYW5lbDEkQ29udGVudFBhbmVsMSRERExf55uR5o6n6aG555uuBS5SZWdpb25QYW5lbDEkUmVnaW9uMiRHcm91cFBhbmVsMSRDb250ZW50UGFuZWwyBS5SZWdpb25QYW5lbDEkUmVnaW9uMiRHcm91cFBhbmVsMSRDb250ZW50UGFuZWw0BRRSZWdpb25QYW5lbDEkUmVnaW9uMQUgUmVnaW9uUGFuZWwxJFJlZ2lvbjEkR3JvdXBQYW5lbDIFJlJlZ2lvblBhbmVsMSRSZWdpb24xJEdyb3VwUGFuZWwyJEdyaWQzBThSZWdpb25QYW5lbDEkUmVnaW9uMSRHcm91cFBhbmVsMiRHcmlkMyRUb29sYmFyMiRidG5uZXh0MwU4UmVnaW9uUGFuZWwxJFJlZ2lvbjEkR3JvdXBQYW5lbDIkR3JpZDMkVG9vbGJhcjIkYnRuZG93bjMFJlJlZ2lvblBhbmVsMSRSZWdpb24xJEdyb3VwUGFuZWwyJEdyaWQyBThSZWdpb25QYW5lbDEkUmVnaW9uMSRHcm91cFBhbmVsMiRHcmlkMiRUb29sYmFyMyRidG5uZXh0MgU4UmVnaW9uUGFuZWwxJFJlZ2lvbjEkR3JvdXBQYW5lbDIkR3JpZDIkVG9vbGJhcjMkYnRuZG93bjIFJlJlZ2lvblBhbmVsMSRSZWdpb24xJEdyb3VwUGFuZWwyJEdyaWQxBTdSZWdpb25QYW5lbDEkUmVnaW9uMSRHcm91cFBhbmVsMiRHcmlkMSRUb29sYmFyMSRCdXR0b24xBTdSZWdpb25QYW5lbDEkUmVnaW9uMSRHcm91cFBhbmVsMiRHcmlkMSRUb29sYmFyMSRCdXR0b24yMC+ca08UCNF7Vxh4gHyEItfNM70=");
			keyvalue.put("__VIEWSTATEGENERATOR", "CA0B0334");
			keyvalue.put("__EVENTVALIDATION", "/wEWBwLdotT5BQKSoqqWDwKZlNEkAv+RjcUKAozMk0wCgODHQQK0gNugBBckWrhXet+knzNNAD2e4QhhwY31");
			keyvalue.put("PandValue", "10");
			keyvalue.put("hidpageCurrentSize", "1");
			keyvalue.put("hidpageSum", "1");
			keyvalue.put("hidpageCurrentSize2", "1");
			keyvalue.put("hidpageSum2", "4");
			keyvalue.put("hidpageCurrentSize3", "1");
			keyvalue.put("hidpageSum3", "14");
			keyvalue.put("RegionPanel1$Region3$ContentPanel3$txtstarOld", "2019-4-15");
			keyvalue.put("RegionPanel1$Region3$ContentPanel3$txtstar", "2019-5-15");
			keyvalue.put("__12_value", "[电表]|000001214308");
			keyvalue.put("RegionPanel1$Region3$ContentPanel3$tb_ammeterNumb", "[电表]000001214308");
			keyvalue.put("__41_value", "00900200");
			keyvalue.put("RegionPanel1$Region1$GroupPanel2$Grid3$Toolbar2$pagesize3", "1");
			keyvalue.put("RegionPanel1$Region1$GroupPanel2$Grid2$Toolbar3$pagesize2", "1");
			keyvalue.put("RegionPanel1$Region1$GroupPanel2$Grid1$Toolbar1$pagesize", "1");
			keyvalue.put("__box_page_state_changed", "true");
			keyvalue.put("__12_last_value", "[电表]|000001214308");
			keyvalue.put("__41_last_value", "00000000");
			keyvalue.put("__box_ajax_mark", "true");

			//提交数据并返回结果
			String result = sslclient.doHttpsPost(posturl, keyvalue, "utf-8", headers);	
			String regEx = "[+-]?\\d+\\.\\d\\d";
			// 编译正则表达式
			Pattern pattern = Pattern.compile(regEx);
			// 忽略大小写的写法
			// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(result);
			// 查找字符串中是否有匹配正则表达式的字符/字符串
			//System.out.println(matcher.group(0));
			if(matcher.find()) {
				 for(int i=0; i<=matcher.groupCount(); i++){  
					 restcharge=matcher.group(i);  
				    }  
			}
			else {
				restcharge="no found!";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
