package check;

import java.sql.*;
public class dbconn {
    private String driverName = "org.gjt.mm.mysql.Driver";//������������
    private String url = "jdbc:mysql://localhost:3306/dbhouse";//�������ݿ����Ӵ�
    private String user = "";//���ݿ��¼�û���
    private String password = "";//���ݿ��¼����
    
    
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
                System.out.print("����: "+rs.getString(1));
                System.out.print("\tpassword: "+rs.getString(2));
                System.out.println();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
}
