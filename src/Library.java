import java.sql.*;

public class Library { //Method used to show whole library

  public void listSongs() {
    String SQL = "SELECT * FROM songs";

    try (
      Connection conn = LaunchSQL.connect();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(SQL)
    ) {
      System.out.println("# | Title  |  Artist  |  Album  |  Year");
      while (rs.next()) {
        System.out.println(
          rs.getInt("id") +
          " | " +
          rs.getString("title") +
          "  |  " +
          rs.getString("artist") +
          "  |  " +
          rs.getString("album") +
          "  |  " +
          rs.getInt("year")
        );
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
