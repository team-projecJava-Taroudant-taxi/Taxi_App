package taxi;

import java.sql.*;
import java.sql.Connection;



public class ConnexionMysql {
    public Connection cnx;
    public static Connection connexionDB(){
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
       Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/taxiapp","root","");

          return cnx;

      } catch (ClassNotFoundException | SQLException e) {
          System.out.println("connexion echouee");
         e.printStackTrace();
      }
        return null;
    }
}
