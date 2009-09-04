package check;

import java.sql.*;
public class dbconn {
    private String driverName = "org.gjt.mm.mysql.Driver";//加载驱动程序
    private String url = "jdbc:mysql://localhost:3306/dbhouse";//设置数据库连接串
    private String user = "";//数据库登录用户名
    private String password = "";//数据库登录密码
    
    
    public void setDriverName(String newDriverName) {
        driverName = newDriverName;
    }
    public String getDriverName() {
        return driverName;
    }
    
    public void setUrl(String newUrl) {
        url = newUrl;
    }
    public String getUrl() {
        return url;
    }
    public void setUser(String newUser) {
        user = newUser;
    }
    public String getUser() {
        return user;
    }
    public void setPassword(String newPassword) {
        password = newPassword;
    }
    public String getPassword() {
        return password;
    }
    
    public Connection getConnection() {
        try {
            Class.forName(driverName);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        
        
        
        try{
            
            dbconn dc = new dbconn();
            Connection	conn = dc.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from my_Adminuser");
            
            
            
            
            while(rs.next()){
                System.out.print("名称: "+rs.getString(1));
                System.out.print("\tpassword: "+rs.getString(2));
                System.out.println();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
}
