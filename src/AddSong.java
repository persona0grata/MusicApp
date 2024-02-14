import java.sql.*;

public class AddSong { // Adding song to library

  public void addSong(
    String title,
    String artist,
    String album,
    int year,
    String link
  ) {
    String SQL =
      "INSERT INTO songs (title, artist, album, year, link) VALUES (?, ?, ?, ?, ?)";

    try (
      Connection conn = LaunchSQL.connect();
      PreparedStatement pstmt = conn.prepareStatement(SQL)
    ) {
      pstmt.setString(1, title);
      pstmt.setString(2, artist);
      pstmt.setString(3, album);
      pstmt.setInt(4, year);
      pstmt.setString(5, link);

      pstmt.executeUpdate();
      System.out.println("Song " + "\"" + title + "\"" + " successfully added!");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
