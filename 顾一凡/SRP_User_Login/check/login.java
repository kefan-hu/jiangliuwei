

package check;

import java.sql.*;
import check.dbconn;
import check.strformat;

public class login extends database {
	private String username;	//��¼�û���
	private String passwd;		//��¼����
	private boolean isadmin;	//�Ƿ����Ա��¼
	private long userid=0;		//�û�ID��
	
	
	public login() throws Exception{
		super();
		username = "";
		passwd = "";
		isadmin = false;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String newusername) {
		username = newusername;
	}

	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String newpasswd) {
		passwd = newpasswd;
	}

	public boolean getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(boolean newIsadmin) {
		isadmin = newIsadmin;
	}
	
	public long getUserid() {
		return userid;
	}

	public void setUserid (long uid) {
		userid = uid;
	}

	public String getSql() {
		if (isadmin) {
			sqlStr = "select * from my_Adminuser where adminuser = '" + strformat.toSql(username) + "' and adminpass = '" + strformat.toSql(passwd) + "'";
		}else {
			sqlStr = "select * from my_users where username = '" + strformat.toSql(username) + "' and password = '" + strformat.toSql(passwd) + "'";
		}
		return sqlStr;
	}

	public boolean excute() throws Exception {
		boolean flag = false;
		rs = stmt.executeQuery(getSql());
		if (rs.next()){
			if (!isadmin)
			{
				userid = rs.getLong("Id");
			}			
			flag = true;
		}
		rs.close();
		close();
		return flag;		
	}
};


