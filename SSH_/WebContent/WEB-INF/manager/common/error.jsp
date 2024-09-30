<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'error.jsp' starting page</title>
  </head>
  
  <body>
	<center>
		<h1>
			<font color="red">出错啦！【${msg}】
				<a href="javascript:void(0)" onclick="window.history.go(-1)">单击此出返回上一操作页</a>
			</font>
		</h1>
	</center>
  </body>
</html>
