
package check;

import java.sql.*;
import java.util.Vector;
import check.dbconn;
import check.strformat;
import javax.servlet.http.HttpServletRequest;
import check.voteuser;
import java.util.*;

public class usermn extends database {
    private voteuser user = new voteuser();	//创建新的用户对象
    private javax.servlet.http.HttpServletRequest request; //建立页面请求
    
    private String message = "";			//声明出错信息提示
    private String username = "";			//声明注册后返回的用户名
    private long userid = 0;				//注册后返回的用户ID
    
    
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
            String ID = request.getParameter("userid");//获取userid参数
            if (ID!=null ) {
                userid = 0;
                try {
                    userid = Long.parseLong(ID);
                    user.setId(userid);
                } catch (Exception e) {
                    message = message + "所修改的用户号错误";
                }
            }
            
            username = request.getParameter("username");//获取username参数
            if (username==null || username.equals("")) {
                username = "";
                message = message + "用户名为空";
            }
            user.setUserName(getGbk(username));
            String password = request.getParameter("passwd");//获取passwd参数
            if (password==null || password.equals("")) {
                password = "";
                message = message + "密码为空";
            }
            String pwdconfirm = request.getParameter("passconfirm");//获取passconfirm参数
            if (!password.equals(pwdconfirm)) {
                message = message + "密码不相同";
            }
            user.setPassWord(getGbk(password));
            String names = request.getParameter("names");;//获取names参数
            if (names==null) {
                names = "";
            }
            user.setNames(getGbk(names));//转化格式
            String sex = request.getParameter("sex");
            user.setSex(getGbk(sex));
            String address = request.getParameter("address");//获取address参数
            if (address == null) {
                address = "";
            }
            user.setAddress(getGbk(address));
            String post = request.getParameter("post");//获取post参数
            if (post == null) {
                post = "";
            }
            user.setPost(getGbk(post));
            String phone = request.getParameter("phone");//获取phone参数
            if (phone== null) {
                phone = "";
            }
            user.setPhone(phone);
            String email = request.getParameter("email");//获取email参数
            if (email == null) {
                email = "";
            }
            user.setEmail(getGbk(email));//转化格式
            String IP = request.getRemoteAddr();//利用getRemoteAddr()函数取得用户IP
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
            sqlStr = "select * from My_users where username = '" + user.getUserName() +"'";//取出符合username字段要求的记录
            rs = stmt.executeQuery(sqlStr);//执行SQL语句
            if (rs.next()) {
                message = message + "该用户名已存在!";
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
            sqlStr = sqlStr + strformat.toSql(user.getEmail()) + "',getdate(),'";//使用getdate()函数获取系统当前时间
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
