import java.util.Scanner;

public class MovieController {

    public MovieController() {

        Scanner scan = new Scanner(System.in);

        Movie testMovie = new Movie("Poop", "Timm", 1992, "yes", 180, "Drama");
        Movie testMovie1 = new Movie("Penisp", "Timm", 1992, "yes", 180, "Drama");
        Movie testMovie2 = new Movie("poop", "Timm", 1992, "yes", 180, "Drama");
        Movie testMovie3 = new Movie("doop", "Timm", 1992, "yes", 180, "Drama");

        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie(testMovie);
        movieCollection.addMovie(testMovie1);
        movieCollection.addMovie(testMovie2);
        movieCollection.addMovie(testMovie3);

        System.out.println("Welcome to your movie collection!");

        boolean running = true;

        while (running) {
            System.out.println("1. Create movie entry");
            System.out.println("2. See movie list");
            System.out.println("3. Search movie, by title");
            System.out.println("4. Exit");
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
                case 3 -> {
                    System.out.println("Please write the title of the movies you are looking for");
                    scan.nextLine();
                    String titleSearch = scan.nextLine();
                    if (titleSearch.length()>0) {
                        movieCollection.searchMovie(titleSearch);
                    }else {
                        System.out.println("You have to write at least one letter to search");
                    }
                }
                case 4 -> running = false;
            }
        }
    }
}

