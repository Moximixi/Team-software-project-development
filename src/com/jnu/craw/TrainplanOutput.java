package com.jnu.craw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 收集成绩与输出成绩
 * 
 * @author liqiang
 *
 */
@SuppressWarnings("all")
public class TrainplanOutput {
    /**
     * 保存成绩的集合
     */
	public DefaultTableModel model=new DefaultTableModel(	
			new Object[][] {
		{"学习模块", "要求", "已修", "还差"},
		{"总学分", null, null, null},
		{"必修", null, null, null},
		{"艺术素养", null, null, null},
		{"文史哲类", null, null, null},
		{"经管法类", null, null, null},
		{"数理工类", null, null, null},
		{"生命类", null, null, null},
		{"其他类", null, null, null},
		{"通识小计", null, null, null},
		{"基础教育", null, null, null},
		{"专业教育", null, null, null},
		{"跨专业课程", null, null, null},
		{"选修合计", null, null, null},
	},
	new String[] {
		"New column", "New column", "New column", "New column"
	});
    private List<Map<String, Object>> datas;

    public TrainplanOutput() {
        this.datas = new ArrayList<Map<String, Object>>();
    }

    /**
     * 收集成绩
     * 
     * @param html
     * @return
     */
    public JTable collectGrade(String html) {
    	
        // 解析html
        Document document = Jsoup.parse(html);
        // 获取成绩表格
        Element table = document.select("table[class=form_table]").first();
        // 选择除表格表头之外的元素
        Elements trs = table.select("tr:gt(0)");
        for (Element ele : trs) {
            Map result = new LinkedHashMap();
            Elements ele0 = ele.select("td[class=needs]");// 找到学年
            result.put("要求学分", ele0.text());
            Elements ele1 = ele.select("td[class=study]");// 找到学期
            result.put("已修学分", ele1.text());
            Elements ele2 = ele.select("td[class=lefts]");// 找到课程名称
            result.put("还差", ele2.text());
            this.datas.add(result);
        }
        
        for(Map<String, Object> data:datas) {
        	int i=1;
        	String request = (String) data.get("要求学分");
        	model.setValueAt(request, i,1);
            String study = (String) data.get("已修学分");
            model.setValueAt(study, i,2);
            String need = (String) data.get("还差");
            model.setValueAt(study, i,3);
            i++;
        }
        
        JTable table_result = new JTable();
        table_result.setModel(model);
        
        return table_result;
    }
   
    
    /**
     * 最后处理所有的数据，写出到html或者保存数据库
     * 
     * @throws IOException
     */
    public void outputDatas2Html() throws IOException {
        if (datas != null && datas.size() > 0) {
            // 读取文件存储位置
            String directory ="C:\\Users\\starry_mei\\Desktop\\Team-software-project-development\\src\\com\\jnu\\craw\\html";
            
            File file = new File(directory+"\\gradeOut.html");
            // 如果文件不存在就创建文件
            if (!file.exists()) {
                file.createNewFile();
            }
            // 构造FileWriter用于向文件中输出信息(此构造方法可以接收file参数，也可以接收fileName参数)
            FileWriter fileWriter = new FileWriter(file);
            // 开始写入数据
            fileWriter.write("<html>");
            fileWriter.write("<head>");
            fileWriter.write("<title>xxx成绩单</title>");
            fileWriter
                    .write("<style>table{width:100%;table-layout: fixed;word-break: break-all; word-wrap: break-word;}"
                            + "table td{border:1px solid black;width:300px}</style>");
            fileWriter.write("</head>");
            fileWriter.write("<body>");
            fileWriter.write("<table cellpadding='0' cellspacing='0' style='text-align:center;'>");
            fileWriter.write(
                    "<tr style='background-color:#95caca;font-size:20px'><td>要求学分</td><td>已修学分</td><td>还差</td>");

            for (Map<String, Object> data : datas) {
                String request = (String) data.get("要求学分");
                String study = (String) data.get("已修学分");
                String need = (String) data.get("还差");
                fileWriter.write("<tr>");
                fileWriter.write("<td>" + request + "</td>");
                fileWriter.write("<td>" + study + "</td>");
                fileWriter.write("<td>" + need + "</td>");
                fileWriter.write("</tr>");
            }
            fileWriter.write("</table>");
            fileWriter.write("</body>");
            fileWriter.write("</html>");
            // 关闭文件流
            fileWriter.close();
        }
    }

    public List<Map<String, Object>> getDatas() {
        return datas;
    }

    public void setDatas(List<Map<String, Object>> datas) {
        this.datas = datas;
    }

}