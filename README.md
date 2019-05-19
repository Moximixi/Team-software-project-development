## 代码开发要求

1. 先在`feature`分支上开发
2. 在`release`分支上合并
3. 最后在`master`分支上发布

### 快捷键提示
1. 一键导包：`ctrl`+`shift`+`o`
2. 一键排版：`ctrl`+`A`->`ctrl`+`i`

### 关于使用userinfo.txt里面的数据
使用前先导入以下语句
```java
		//首先规定用户信息的路径（需要用到用户信息的界面都要引入该语句）
		FileHelper fh=new FileHelper("./userinfo.txt");
		//读取个人信息代码
		Person person=fh.getObjFromFile();                 //取出person对象
```
同时需要导入data下面的类
```java
	import com.jnu.groupproject.data.*;
```

然后就可以愉快的使用里面的数据了，比如说，使用用户的姓名
```
	person.getName();
```
其余字段参考data包下面的的Person类