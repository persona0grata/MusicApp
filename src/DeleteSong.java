import java.sql.*;

public class DeleteSong {

  public void deleteSong(String title) {
    String SQL = "DELETE FROM songs WHERE title = ?";

    try (
      Connection conn = LaunchSQL.connect();
      PreparedStatement pstmt = conn.prepareStatement(SQL)
    ) {
      pstmt.setString(1, title);

      int affectedRows = pstmt.executeUpdate();
      if (affectedRows > 0) {
        System.out.println("Song deleted successfully.");
      } else {
        System.out.println("Error, no song named \"" + title + "\"!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
