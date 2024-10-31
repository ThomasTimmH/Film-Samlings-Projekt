import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    Scanner scan = new Scanner(System.in);
    MovieController controller = new MovieController();


    public void Start() {

        System.out.println("Welcome to your movie collection!");

        Movie testMovie = new Movie("Food", "Timm", 1993, "yes", 180, "Drama");
        Movie testMovie1 = new Movie("Penis", "Timm", 1992, "yes", 180, "Drama");
        Movie testMovie2 = new Movie("Poop", "Timm", 1921, "yes", 180, "Drama");
        Movie testMovie3 = new Movie("Doop", "Timm", 1991, "yes", 180, "Drama");

        controller.addMovie1(testMovie);
        controller.addMovie1(testMovie1);
        controller.addMovie1(testMovie2);
        controller.addMovie1(testMovie3);

        boolean running = true;
        while (running) {
            displayMenu();
            int userResponse = validateInt();
            switch (userResponse) {
                case 1 -> {
                    System.out.println("Enter Title:");
                    scan.nextLine();
                    String userTitle = scan.nextLine();

                    System.out.println("Enter a director");
                    String userDirector = scan.nextLine();

                    System.out.println("Enter the year the movie was made: ");
                    int movieYear = validateInt();

                    System.out.println("Is the movie colored?");
                    scan.nextLine();
                    String userColor = scan.nextLine();

                    System.out.println("Enter how long the movies is in minutes");
                    int movieLength = validateInt();


                    System.out.println("Enter the movie's genre: ");
                    scan.nextLine();
                    String movieGenre = scan.nextLine();

                    Movie userMovie = new Movie(userTitle, userDirector, movieYear, userColor, movieLength, movieGenre);

                    controller.addMovie1(userMovie);
                    System.out.println("Your movie " + userMovie.getTitle() + " has been added to the collection!");
                }
                case 2 -> controller.showAllMovies();
                case 3 -> {
                    System.out.println("Please write the title of the movies you are looking for");
                    scan.nextLine();
                    String titleSearch = scan.nextLine();
                    if (!titleSearch.isEmpty()) {
                        controller.searchMovie1(titleSearch);
                    } else {
                        System.out.println("You have to write at least one letter to search");
                    }
                }
                case 4 -> editMovie();
                case 5 -> deleteMovie();
                case 6 -> running = false;
            }
        }

    }

    private void deleteMovie() {
        System.out.println("Enter the title of the movie you want to delete:");
        scan.nextLine();
        String titleToDelete = scan.nextLine();

        boolean success = controller.deleteMovie(titleToDelete);
        if (success) {
            System.out.println("Movie '" + titleToDelete + "' has been deleted successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    private void editMovie() {
        System.out.println("Enter the title of the movie you want to edit");
        scan.nextLine();
        String searchTitle = scan.nextLine();

        System.out.println("Enter new title: ");
        String newTitle = scan.nextLine();

        System.out.println("Enter new director: ");
        String newDirector = scan.nextLine();

        System.out.println("Enter new length in minutes: ");
        int newLength = scan.nextInt();

        System.out.println("Is the movie in color? (yes/no): ");
        scan.nextLine();
        String newIsInColor = scan.nextLine();

        System.out.println("Enter new creation year: ");
        scan.nextLine(); // Håndter linjeskift
        int newYear = scan.nextInt();

        System.out.println("Enter new genre: ");
        String newGenre = scan.nextLine();

        // Redigerer filmen via controlleren
        boolean success = controller.editMovie(searchTitle, newTitle, newDirector, newYear, newLength, newIsInColor, newGenre);
        if (success) {
            System.out.println("Movie updated successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }


    private void displayMenu() {
        System.out.println();
        System.out.println("1. Create movie entry");
        System.out.println("2. See movie list");
        System.out.println("3. Search movie, by title");
        System.out.println("4. Edit movie by searching after title");
        System.out.println("5. Delete movie from list");
        System.out.println("6. Exit");
    }

    private int validateInt() {
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid value.");
                scan.nextLine(); // Consume the invalid input
            }
        }
    }
}








