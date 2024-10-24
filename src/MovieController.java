import java.util.Scanner;

public class MovieController {

    public MovieController() {

        Scanner scan = new Scanner(System.in);

        Movie testMovie = new Movie("Food", "Timm", 1993, "yes", 180, "Drama");
        Movie testMovie1 = new Movie("Penis", "Timm", 1992, "yes", 180, "Drama");
        Movie testMovie2 = new Movie("Poop", "Timm", 1921, "yes", 180, "Drama");
        Movie testMovie3 = new Movie("Doop", "Timm", 1991, "yes", 180, "Drama");

        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie(testMovie);
        movieCollection.addMovie(testMovie1);
        movieCollection.addMovie(testMovie2);
        movieCollection.addMovie(testMovie3);

        UI ui = new UI();

        ui.welcomeMsg();

        boolean running = true;

        while (running) {
            ui.introduktion();
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
                    if (!titleSearch.isEmpty()) {
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

