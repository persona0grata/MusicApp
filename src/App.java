import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    

    MainMenu menu = new MainMenu();
    Library library = new Library();
    AddSong add = new AddSong();
    UpdateSong update = new UpdateSong();
    DeleteSong delete = new DeleteSong();
    GetSong get = new GetSong();
    GetLink getLink = new GetLink();

    System.out.println("Welcome to Music App!");
    while (true) {
      menu.mainMenu(); //Calling menu function in MainMenu class
      int choice = scanner.nextInt(); // Reading user input (1 - 5)
      scanner.nextLine();

      switch (choice) { // choosing option
        case 1:
          System.out.println(
            "Enter title, artist, album, year, link to song (spotify, youtube):"
          );
          add.addSong(
            scanner.nextLine(),
            scanner.nextLine(),
            scanner.nextLine(),
            Integer.parseInt(scanner.nextLine()),
            scanner.nextLine()
          );

          break;
        case 2:
          library.listSongs();
          break;
        case 3:
          System.out.println("Enter song ID: ");
          get.getSong(Integer.parseInt(scanner.nextLine()));
          break;
        case 4:
          System.out.println(
            "Enter ID, new title, new artist, new album, new year, new link:"
          );
          int id = scanner.nextInt();
          scanner.nextLine();
          String options[] = { "title", "artist", "album", "year", "link" };

          for (int i = 0; i < 5; i++) {
            System.out.println(
              "Do you want to change " + options[i] + "? (1, 0)"
            );
            int flag = Integer.parseInt(scanner.nextLine());
            if (flag == 1) {
              System.out.println("Input new " + options[i] + ": ");
              options[i] = scanner.nextLine();
            } else if (flag == 0){
              options[i] = get.song(i, id);
            }
          }
          update.updateSong(
              id,
              options[0],
              options[1],
              options[2],
              Integer.parseInt(options[3]),
              options[4]
            );
          break;
        case 5:
          System.out.println("Enter title of the song to delete:");
          delete.deleteSong(scanner.nextLine());
          break;

        case 6:
        System.out.println("Enter song ID: ");
        getLink.getLink(Integer.parseInt(scanner.nextLine()));

        break;
        case 0:
          System.out.println("BB");
          System.exit(0);
          break;
        default:
          System.out.println("Error, please enter a number between 1 and 5!");
      }
    }
  }
}
