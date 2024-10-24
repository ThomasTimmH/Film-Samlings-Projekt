import java.util.Scanner;

public class MovieController {

    public MovieController() {

        Scanner scan = new Scanner(System.in);

        Movie testMovie = new Movie("Poop", "Timm", 1992, "yes", 180, "Drama");
        MovieCollection movieCollection = new MovieCollection();

        System.out.println("Welcome to your movie collection!");

        boolean running = true;

        while (running) {
            System.out.println("1. Create movie entry");
            System.out.println("2. See movie list");
            System.out.println("3. Exit");
            int userResponse = scan.nextInt();
            switch (userResponse) {
                case 1 -> {
                    System.out.println("Enter Title:");
                    scan.nextLine();
                    String userTitle = scan.nextLine();

                    System.out.println("Enter a director");
                    String userDirector = scan.nextLine();

                    System.out.println("Enter the year the movie was made: ");
                    int movieYear = scan.nextInt();

                    System.out.println("Is the movie colored?");
                    scan.nextLine();
                    String userColor = scan.nextLine();

                    System.out.println("Enter how long the movies is");
                    int movieLength = scan.nextInt();


                    System.out.println("Enter the movie's genre: ");
                    scan.nextLine();
                    String movieGenre = scan.nextLine();


                    Movie userMovie = new Movie(userTitle, userDirector, movieYear, userColor, movieLength, movieGenre);

                    movieCollection.addMovie(userMovie);
                }
                case 2 -> System.out.println(movieCollection);
                case 3 -> running = false;
            }
        }
    }
}

