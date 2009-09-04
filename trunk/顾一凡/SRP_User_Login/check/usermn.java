
package check;

import java.sql.*;
import java.util.Vector;
import check.dbconn;
import check.strformat;
import javax.servlet.http.HttpServletRequest;
import check.voteuser;
import java.util.*;

public class usermn extends database {
    private voteuser user = new voteuser();	//�����µ��û�����
    private javax.servlet.http.HttpServletRequest request; //����ҳ������
    
    private String message = "";			//����������Ϣ��ʾ
    private String username = "";			//����ע��󷵻ص��û���
    private long userid = 0;				//ע��󷵻ص��û�ID
    
    
    public usermn() throws Exception{
        super();
    }
    
    
    
    public String getGbk(String str) {
        try {
            return new String(str.getBytes("ISO8859-1"));
        } catch (Exception e) {
            return str;
        }
    }
    
  
        public boolean getRequest(javax.servlet.http.HttpServletRequest newrequest) {
        boolean flag = false;
        try {
            request = newrequest;
            String ID = request.getParameter("userid");//��ȡuserid����
            if (ID!=null ) {
                userid = 0;
                try {
                    userid = Long.parseLong(ID);
                    user.setId(userid);
                } catch (Exception e) {
                    message = message + "���޸ĵ��û��Ŵ���";
                }
            }
            
            username = request.getParameter("username");//��ȡusername����
            if (username==null || username.equals("")) {
                username = "";
                message = message + "�û���Ϊ��";
            }
            user.setUserName(getGbk(username));
            String password = request.getParameter("passwd");//��ȡpasswd����
            if (password==null || password.equals("")) {
                password = "";
                message = message + "����Ϊ��";
            }
            String pwdconfirm = request.getParameter("passconfirm");//��ȡpassconfirm����
            if (!password.equals(pwdconfirm)) {
                message = message + "���벻��ͬ";
            }
            user.setPassWord(getGbk(password));
            String names = request.getParameter("names");;//��ȡnames����
            if (names==null) {
                names = "";
            }
            user.setNames(getGbk(names));//ת����ʽ
            String sex = request.getParameter("sex");
            user.setSex(getGbk(sex));
            String address = request.getParameter("address");//��ȡaddress����
            if (address == null) {
                address = "";
            }
            user.setAddress(getGbk(address));
            String post = request.getParameter("post");//��ȡpost����
            if (post == null) {
                post = "";
            }
            user.setPost(getGbk(post));
            String phone = request.getParameter("phone");//��ȡphone����
            if (phone== null) {
                phone = "";
            }
            user.setPhone(phone);
            String email = request.getParameter("email");//��ȡemail����
            if (email == null) {
                email = "";
            }
            user.setEmail(getGbk(email));//ת����ʽ
            String IP = request.getRemoteAddr();//����getRemoteAddr()����ȡ���û�IP
            user.setRegIpAddress(IP);
            if (message.equals("")) {
                flag = true;
            }
            return flag;
        } catch (Exception e) {
            return flag;
        }
    }
    
  
    
    
    
    public boolean insert(HttpServletRequest req) throws Exception {
        if (getRequest(req)) {
            sqlStr = "select * from My_users where username = '" + user.getUserName() +"'";//ȡ������username�ֶ�Ҫ��ļ�¼
            rs = stmt.executeQuery(sqlStr);//ִ��SQL���
            if (rs.next()) {
                message = message + "���û����Ѵ���!";
                rs.close();
                return false;
            }
            sqlStr = "insert into my_users (username,password,Names,sex,Address,Phone,Post,Email,RegTime,RegIpaddress) values ('";
            sqlStr = sqlStr + strformat.toSql(user.getUserName()) + "','";
            sqlStr = sqlStr + strformat.toSql(user.getPassWord()) + "','";
            sqlStr = sqlStr + strformat.toSql(user.getNames()) + "','";
            sqlStr = sqlStr + strformat.toSql(user.getSex()) + "','";
            sqlStr = sqlStr + strformat.toSql(user.getAddress()) + "','";
            sqlStr = sqlStr + strformat.toSql(user.getPhone()) + "','";
            sqlStr = sqlStr + strformat.toSql(user.getPost()) + "','";
            sqlStr = sqlStr + strformat.toSql(user.getEmail()) + "',getdate(),'";//ʹ��getdate()������ȡϵͳ��ǰʱ��
            sqlStr = sqlStr + user.getRegIpAddress() + "')";
            
            try {
                stmt.execute(sqlStr);
                sqlStr = "select max(id) from My_users where username = '" +user.getUserName()+ "'";
                rs = stmt.executeQuery(sqlStr);
                while (rs.next()) {
                    userid = rs.getLong(1);
                }
                rs.close();
                return true;
            } catch (SQLException sqle) {
                System.out.println(sqle.toString());
                return false;
            }
        } else	{
            return false;
        }
        
    }
    
    
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String msg) {
        message = msg;
    }
    
    public void setUserid(long uid) {
        userid = uid;
    }
    public long getUserid() {
        return userid;
    }
    
    public void setUserName(String uName) {
        username = uName;
    }
    
    public String getUserName() {
        return username;
    }
};
