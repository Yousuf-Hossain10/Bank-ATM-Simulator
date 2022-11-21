import java.sql.*;  

public class Connectivity{
    Connection c;
    Statement s;
    public Connectivity(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","18101586");    
            s =c.createStatement(); 
        }catch(Exception e){ 
        	 e.printStackTrace();
             System.out.println("error: "+e);
        }  
    }  
}  