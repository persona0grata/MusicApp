import java.sql.*;

public class UpdateSong { //Updating songs in library by it's ID;

  public void updateSong(
    int id,
    String title,
    String artist,
    String album,
    int year,
    String link
  ) {
    String SQL =
      "UPDATE songs SET title = ?, artist = ?, album = ?, year = ?, link = ? WHERE id = ?";

    try (
      Connection conn = LaunchSQL.connect();
      PreparedStatement pstmt = conn.prepareStatement(SQL)
    ) {
      pstmt.setString(1, title);
      pstmt.setString(2, artist);
      pstmt.setString(3, album);
      pstmt.setInt(4, year);
      pstmt.setString(5, link);
      pstmt.setInt(6, id);

      int affectedRows = pstmt.executeUpdate();
      if (affectedRows > 0) {
        System.out.println("Song updated successfully.");
      } else {
        System.out.println("Song with ID " + id + " not found.");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
