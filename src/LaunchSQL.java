import java.sql.*;

public class LaunchSQL {

  private static final String URL = "jdbc:postgresql://localhost/music_app_DB";
  private static final String USER = "postgres";
  private static final String PASSWORD = "cdk8sebb";

  public static Connection connect() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }
}
