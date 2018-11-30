import java.sql.*;

public class DockerConnectMySQL {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://db:3306/baza";

   static final String USER = "user";
   static final String PASS = "karol";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String sql;
String wpisanie;
String wpisywanie;

	wpisanie ="CREATE TABLE Persons (PersonID int, LastName varchar(255), FirstName varchar(255), Address varchar(255), City varchar(255) );";

wpisywanie="INSERT INTO Persons (PersonID, LastName, FirstName, Address, City) VALUES (1, 'Sureshkumar', 'Deepak', 'Jackal Creek','Johannesburg');";

      sql = "SELECT PersonID, FirstName, LastName, Address, City FROM Persons";
      ResultSet rs = stmt.executeQuery(sql);
stmt.executeQuery(wpisanie);
stmt.executeQuery(wpisywanie);

      while(rs.next()){
         int id  = rs.getInt("PersonID");
         String first = rs.getString("FirstName");
         String last = rs.getString("LastName");
		 String address = rs.getString("Address");
		 String city = rs.getString("City");

         System.out.println("ID: " + id);
         System.out.println(", First: " + first);
         System.out.println(", Last: " + last);
		 System.out.println(", Address: " + address);
		 System.out.println(", City: " + city);
      }
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
 }
}
