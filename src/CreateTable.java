import java.sql.*;

public class CreateTable {

  public static void createTable(){
    try (
      Connection conn = LaunchSQL.connect();
      Statement stmt = conn.createStatement();
    ) {
      String query =
        "CREATE TABLE IF NOT EXISTS Songs " +
        "(id SERIAL PRIMARY KEY, " +
        "title VARCHAR(255) NOT NULL, " +
        "artist VARCHAR(255) NOT NULL, " +
        "album VARCHAR(255) NOT NULL, " +
        "year INT, " +
        "link VARCHAR(255) NOT NULL)";

      stmt.executeUpdate(query);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
