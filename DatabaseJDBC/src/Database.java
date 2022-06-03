import java.sql.*;

public class Database {
 public static void main(String[] args) throws SQLException{
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oceanjava","root","root");
System.out.println(con); 
Statement stmt=con.createStatement();
//String query="insert into python(id,name,age) values(1001,'thamizh',22),(1002,'ramki',90),(1003,'manisha',25),(1004,'gomathi',26)";

//a=stmt.executeUpdate(query);
ResultSet rs=stmt.executeQuery("select * from python");
while(rs.next()){
	System.out.println(rs.getString(1));
}

stmt.close();
con.close();
 
 }
 
 
 
}
