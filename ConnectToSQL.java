import java.sql.*;

public class ConnectToSQL {
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://10.0.10.3:3306/baza";

   static final String USER = "KMoniuszko";
   static final String PASS = "karol";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
	   
   try{
      Class.forName(JDBC_DRIVER);

      System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();

      stmt.executeUpdate("CREATE TABLE DANE (ID int, Nazwisko varchar(255), Imie varchar(50));");
      stmt.executeUpdate("INSERT INTO DANE (ID, Nazwisko, Imie) VALUES (1, 'Moniuszko', 'Karol');");
      stmt.executeUpdate("INSERT INTO DANE (ID, Nazwisko, Imie) VALUES (2, 'Nowak', 'Michal');");
      stmt.executeUpdate("INSERT INTO DANE (ID, Nazwisko, Imie) VALUES (3, 'Kowalski', 'Jan');");
      ResultSet wypisz = stmt.executeQuery("SELECT * FROM DANE");

      while(wypisz.next()){
         int id  = wypisz.getInt("ID");
         String first = wypisz.getString("Imie");
         String last = wypisz.getString("Nazwisko");
		
         System.out.println("ID: " + id);
         System.out.println(", Imie: " + first);
         System.out.println(", Nazwisko: " + last);
      }

      wypisz.close();
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
