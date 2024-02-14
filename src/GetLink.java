import java.sql.*;

public class GetLink {
    public void getLink(int id) {
    String SQL = "SELECT * FROM songs WHERE id = " + id;

    try (
      Connection conn = LaunchSQL.connect();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(SQL);

    ) {

     
      while (rs.next()) {
        System.out.println("Link to " + "\"" + rs.getString("title") + "\" song:");
        System.out.println(
          rs.getString("link")
        );
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
