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
	alogin.setIsadmin(true);
	if (alogin.excute()){
		session.setAttribute("admin","admin"); %>
		<jsp:forward page="admin.jsp" />			
<%	
	}else {
	mesg = "��¼����"	;
	}
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����ͶƱϵͳ</title>
<script language="javascript">
  function checkform() {
	if (document.form1.username.value=="" || document.form1.passwd.value==""){
		alert("�û���������Ϊ�գ�");
		return false;
	}
	return true;

  }
</script>
</head>
<body  background="image/bg06.jpg" text="#000000">
<div align="center">
  <table width="100%" border="0" height="100%" cellspacing="0" cellpadding="0">
    <tr> 
      <td align="center"> 
        <form name="form1" method="post" action="ad_log.jsp">
       
          <table width="360" border="1" cellspacing="2" cellpadding="2" bgcolor="#FFCC99" bordercolor="#993399" style="font-size:9pt">
            <tr align="center"> 
              <td colspan="2"> 
                <h3><br>
                  <font color="#FF0000">����Ա��½</font></h3>
                <p>&nbsp;<% if (!mesg.equals("")){
						out.println(mesg);}%></p>
              </td>
            </tr>
            <tr> 
              <td align="right" width="150"><font color="#009900">����Ա��</font></td>
              <td> 
                <input type="text" name="username" size="12" maxlength="20">
              </td>
            </tr>
            <tr> 
              <td align="right" width="150"><font color="#009900">����Ա���룺</font></td>
              <td> 
                <input type="password" name="passwd" size="12" maxlength="20">
              </td>
            </tr>
            <tr align="center"> 
              <td colspan="2"> 
                <input type="submit" name="Submit" value="��¼" onClick="javascript:return(checkform());">
                <input type="reset" name="Submit2" value="ȡ��">
              </td>
            </tr>
            <tr align="center">
              <td colspan="2"><A HREF="index.jsp">������ҳ</A></td>
            </tr>
          </table>
	    </form>
        <p>&nbsp;</p>
        <p><br>
        </p>
      </td>
    </tr>
  </table>
</div>
</body>
</html>
