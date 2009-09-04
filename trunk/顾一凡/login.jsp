<%@ page contentType="text/html; charset=gb2312" %>
<%@ page session="true" %>
<jsp:useBean id="alogin" scope="page" class="check.login" />
<%
String mesg = "";

if( request.getParameter("username")!=null && !request.getParameter("username").equals("")){
	String username =request.getParameter("username");
	String passwd = request.getParameter("passwd");
	username = new String(username.getBytes("ISO8859-1"));
	passwd = new String(passwd.getBytes("ISO8859-1"));
	alogin.setUsername(username);
	alogin.setPasswd(passwd);
	if (alogin.excute()){
		session.setAttribute("username",username);
		String userid = Long.toString(alogin.getUserid());
		session.setAttribute("userid",userid);
		response.sendRedirect("user.jsp");
		%>
<%	
	}else {
	mesg = "登录出错！"	;
	}
}
%>

<html>
<head>
<title>电子投票系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script language="javascript">

 function checkform() {
	if (document.form1.username.value=="" || document.form1.passwd.value==""){
		alert("用户名或密码为不能为空！");
		return false;
	}
	return true;

  }

</script>
<link rel="stylesheet" href="books.css" type="text/css">
<style type="text/css">
<!--

.style2 {
	color: #669900;
	font-size: 16px;
}
.style4 {color: #CC6666}
.style5 {color: #669900}
-->
</style>
</head>

<body text="#000000">
<div align="center">
  <p class="style2">用户登录</p>
  <% if (!mesg.equals("")){
						out.println("<p>" + mesg + "</p>");}%>
  <form name="form1" method="post" action="login.jsp">
    <table width="400" border="0" cellspacing="1" cellpadding="1">
    <tr> 
      <td width="147" align="right"><span class="style5">用户名：</span><br>      </td>
      <td width="246" valign="top">
          <input type="text" name="username" size="16" maxlength="25">
        </td>
    </tr>
    <tr> 
      <td width="147" align="right"><span class="style5">密 &nbsp;码：</span></td>
      <td width="246" valign="top">
          <input type="password" name="passwd" maxlength="20" size="16">
        </td>
    </tr>
    <tr> 
      <td width="147" align="right">&nbsp;</td>
      <td width="246" valign="top">
          <input type="submit" name="Submit" value="登录" onclick="javascript:return(checkform());">
          <input type="reset" name="Submit2" value="取消">
        </td>
    </tr>
    <tr> 
      <td colspan="2" align="center">
        <p>&nbsp;</p>
        <p><span class="style4">如果你还没有注册，请</span><a href="reg.jsp">注册</a></p>
      </td>
    </tr>
  </table>
  </form>
  <p>&nbsp;</p>
</div>
</body>
</html>