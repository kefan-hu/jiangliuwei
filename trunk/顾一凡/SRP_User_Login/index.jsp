<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>电子投票系统</title>
<style type="text/css">
<!--
body {
	background-image: url(image/bg06.jpg);
}


.style2 {
	font-size: 24px;
	color: #FF00FF;
}
.style8 {color: #669900}
.style9 {font-size: 14px}
.style10 {color: #669900; font-size: 14px; }
.style11 {color: #0000FF}


-->
</style></head>
<body>
<div align="center" class="style1">
  <p class="style2">电子投票系统
</p>
  <p class="style8 style9">用户登录</p>
  <form name="form1" method="post" action="login.jsp">
    <p><span class="style10">用户名：</span>      
      <input type="text" name="username">
</p>
    <p><span class="style10">密&nbsp;&nbsp;码：</span>      
      <input type="text" name="passwd"> 
    </p>
    <p>
      <input type="submit" name="Submit" value="登录">
      &nbsp;&nbsp;
      <input type="reset" name="Submit2" value="取消">  
      </p>
  </form>
  <p class="style4">&nbsp;</p>
  <p><span class="style8">如果你还没有注册，请</span><span class="style11"><a href="reg.jsp">注册</a></span>&nbsp;&nbsp;&nbsp;<span class="style11"><a href="ad_login.jsp">管理员登录</a></span></p>
  <p>&nbsp;</p>
  <p>&nbsp;  </p>
</div>
</body>
</html>
