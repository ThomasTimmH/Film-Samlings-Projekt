package UserInterface;

import Modles.Movie;
import Modles.MovieCollection;
import Modles.MovieController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    Scanner scan = new Scanner(System.in); // Scanner til brugerinput
    MovieController controller = new MovieController(); // Controller til at håndtere filmoperationer

    // Startmetode, der kører brugergrænsefladen i en løkke
    public void Start() {

        System.out.println("Welcome to your movie collection!");

        boolean running = true; // Flag til at styre programmet
        while (running) {
            displayMenu(); // Viser menuen for brugeren
            int userResponse = validateInt(); // Validerer brugerens valg som heltal
            switch (userResponse) {
                case 1 -> {
                    String userResponse1 = scan.nextLine();
                    createMovie(userResponse1); // Opretter en ny film
                }
                case 2 -> {
                     // Viser alle film, hvis listen ikke er tom
                    if (!controller.getMovieList().isEmpty()) {
                        controller.showAllMovies();
                    } else {
                        System.out.println("Modles.Movie list is empty");
                    }
                }
                case 3 -> {
                    System.out.println("Please write the title of the movies you are looking for");
                    scan.nextLine();
                    String titleSearch = scan.nextLine();
                    if (!titleSearch.isEmpty()) {
                        controller.searchMovie1(titleSearch); // Søger efter en film baseret på titel
                    } else {
                        System.out.println("You have to write at least one letter to search");
                    }
                }
                case 4 -> editMovie(); // Redigerer en film
                case 5 -> deleteMovie(); // Sletter en film
                case 6 -> controller.saveMovies1(); // Gemmer filmene til en fil
                case 7 -> controller.loadFromFile1(); // Indlæser filmene fra en fil
                case 8 -> {
                    System.out.println("How would you like to sort your movie list?");
                    System.out.println("\nTitle|Director|Year|Color|Length|Genre|");
                    scan.nextLine();
                    String userSearch = scan.nextLine();
                    controller.sortMovies(userSearch); // Sorterer film efter et enkelt kriterium
                    controller.showAllMovies();
                }
                case 9 -> {
                    System.out.println("How would you like to sort your movie list?");
                    System.out.println("\nAvailable attributes: Title, Director, Year, Color, Length, Genre");
                    System.out.println("Enter the first sorting attribute:");
                    String primaryAttribute = validateAttribute(scan.nextLine()); // Validerer første attribut
                    System.out.println("Enter the second sorting attribute:");
                    String secondaryAttribute = validateAttribute(scan.nextLine()); // Validerer anden attribut
                    controller.sortMoviesByTwoAttributes(primaryAttribute, secondaryAttribute); // Sorterer efter to attributter
                    controller.showAllMovies();
                }
                case 10 -> running = false; // Stopper programmet
            }
        }
    }

    // Validerer, at en attribut ikke er tom
    private String validateAttribute(String attribute) {
        while (attribute.trim().isEmpty()) {
            attribute = scan.nextLine();
        }
        return attribute.trim();
    }

    // Metode til sletning af en film baseret på titel
    private void deleteMovie() {
        System.out.println("Enter the title of the movie you want to delete:");
        scan.nextLine();
        String titleToDelete = scan.nextLine();

        boolean success = controller.deleteMovie(titleToDelete); // Sletter filmen gennem controlleren
        if (success) {
            System.out.println("Modles.Movie '" + titleToDelete + "' has been deleted successfully.");
        } else {
            System.out.println("Modles.Movie not found.");
        }
    }

    // Metode til redigering af en film baseret på titel
    private void editMovie() {
        System.out.println("Enter the title of the movie you want to edit");
        scan.nextLine();
        String searchTitle = scan.nextLine();

        System.out.println("Enter new title: ");
        String newTitle = scan.nextLine();

        System.out.println("Enter new director: ");
        String newDirector = scan.nextLine();

        System.out.println("Enter new creation year: ");
        int newYear = validateInt(); // Validerer, at årstallet er et gyldigt heltal

        System.out.println("Is the movie in color? (yes/no): ");
        scan.nextLine();
        boolean newIsInColor = validateBoolean(); // Validerer, at brugeren har svaret med ja/nej

        System.out.println("Enter new length in minutes: ");
        int newLength = validateInt(); // Validerer længde i minutter

        System.out.println("Enter new genre: ");
        scan.nextLine();
        String newGenre = scan.nextLine();

        // Redigerer filmen via controlleren
        boolean success = controller.editMovie(searchTitle, newTitle, newDirector, newYear, newLength, newIsInColor, newGenre);
        if (success) {
            System.out.println("Modles.Movie updated successfully.");
        } else {
            System.out.println("Modles.Movie not found.");
        }
    }

    // Viser menuen med valgmuligheder
    private void displayMenu() {
        System.out.println();
        System.out.println(newLine());
        System.out.println("1. Create movie entry");
        System.out.println("2. See movie list");
        System.out.println("3. Search movie, by title");
        System.out.println("4. Edit movie by searching after title");
        System.out.println("5. Delete movie from list");
        System.out.println("6. Save movies");
        System.out.println("7. Load movies");
        System.out.println("8. Sort Movies");
        System.out.println("9. Sort Movies By Primary And Secondary Search Criteria");
        System.out.println("10. Exit");
        System.out.println(newLine());
    }

    // Validerer, at input er et heltal
    private int validateInt() {
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid value.");
                scan.nextLine(); // Fjerner den ugyldige linje
            }
        }
    }

    // Validerer, at input er ja/nej, og returnerer et boolean-resultat
    private boolean validateBoolean() {
        while (true) {
            try {
                String userResponse = scan.nextLine();
                if (userResponse.equalsIgnoreCase("yes")) {
                    return true;
                } else if (userResponse.equalsIgnoreCase("no")) {
                    return false;
                } else {
                    System.out.println("Please enter yes/no");
                }
            } catch (Exception e) {
                System.out.println("An error has occurred: " + e.getMessage());
                scan.nextLine();
            }
        }
    }

    // Metode til at oprette en ny film
    public String createMovie(String user) {
        System.out.println("Enter Title:");
        String userTitle = scan.nextLine();

        System.out.println("Enter a director");
        String userDirector = scan.nextLine();

        System.out.println("Enter the year the movie was made: ");
        int movieYear = validateInt();

        System.out.println("Is the movie colored?");
        scan.nextLine();
        boolean userColor = validateBoolean();

        System.out.println("Enter how long the movie is in minutes");
        int movieLength = validateInt();

        System.out.println("Enter the movie's genre: ");
        scan.nextLine();
        String movieGenre = scan.nextLine();

        Movie userMovie = new Movie(userTitle, userDirector, movieYear, userColor, movieLength, movieGenre); // Opretter nyt Movie-objekt

        controller.addMovie1(userMovie); // Tilføjer filmen til samlingen
        System.out.println("Your movie " + userMovie.getTitle() + " has been added to the collection!");
        return null;
    }

    // Returnerer en adskillelseslinje til konsollen
    public String newLine() {
        return "------------------------------------------------------------";
    }
}








