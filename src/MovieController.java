import java.util.Scanner;

public class MovieController {

    public MovieController() {

        Scanner scan = new Scanner(System.in);

        MovieCollection movieCollection = new MovieCollection();

        System.out.println("Welcome to your movie collection!");

        boolean running = true;

        while (running) {
            System.out.println("1. Create movie entry");
            System.out.println("2. Exit");
            int userResponse = scan.nextInt();
            switch (userResponse) {
                case 1 -> {
                    System.out.println("Enter Title:");
                    String userTitle = scan.nextLine();
                    scan.nextLine();

                    System.out.println("Enter a director");
                    String userDirector = scan.nextLine();

                    System.out.println("Enter the year the movie was made: ");
                    int movieYear = scan.nextInt();

                    System.out.println("Is the movie colored? - answer true or false");
                    boolean userColor = scan.nextBoolean();

                    System.out.println("Enter how long the movies is");
                    int movieLength = scan.nextInt();


                    System.out.println("Enter the movie's genre: ");
                    String movieGenre = scan.nextLine();


                    Movie userMovie = new Movie(userTitle, userDirector, movieYear, userColor, movieLength, movieGenre);
                    System.out.println(userMovie);

                    movieCollection.addMovie(userMovie);

                    System.out.println(movieCollection);

                    j
                }
                case 2 -> running = false;
            }
        }
    }
}

