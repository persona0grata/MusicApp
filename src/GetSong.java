import java.sql.*;

public class GetSong {

  public void getSong(int id) {
    String SQL = "SELECT * FROM songs WHERE id = " + id;

    try (
      Connection conn = LaunchSQL.connect();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(SQL);
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

  public String song(int i, int id) {
    String SQL = "SELECT * FROM songs WHERE id = " + id;

    try (
      Connection conn = LaunchSQL.connect();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(SQL)
    ) {
      while (rs.next()){String song[] = {
        rs.getString("title"),
        rs.getString("artist"),
        rs.getString("album"),
        rs.getString("year"),
        rs.getString("link")
      };
      switch (i) {
        case 0:
          return song[0];
        case 1:
          return song[1];
        case 2:
          return song[2];
        case 3:
          return song[3];
        case 4:
          return song[4];
      }}
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return "";
  }
}
