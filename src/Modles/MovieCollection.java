package Modles;
import Comparators.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Klasse til at håndtere en samling af filmobjekter og udføre forskellige operationer som tilføjelse, søgning, redigering og sortering
public class MovieCollection {
    private ArrayList<Movie> MovieList = new ArrayList<>();  // Liste over film i samlingen
    private static final String FILE_NAME = "movies.txt";    // Filnavn til lagring af filmdata
    private boolean isModified = false; // Holder styr på, om ændringer er foretaget

    // Tilføjer en ny film til samlingen og markerer, at listen er ændret
    public void addMovie(Movie movie) {
        MovieList.add(movie);
        isModified = true;
    }

    // Returnerer en strengrepræsentation af hele filmsamlingen
    public String toString() {
        return MovieList.toString();
    }

    // Søger efter en film ved navn (case-insensitive) og returnerer det første match eller null, hvis ingen findes
    public Movie searchMovie(String search) {
        search = search.toLowerCase();
        for (Movie movie : MovieList) {
            if (movie.getTitle().toLowerCase().contains(search)) {
                return movie;
            }
        }
        return null;
    }

    public void clearMovieList(){
        MovieList.clear();
    }

    // Søger efter alle film, der matcher en given titel og udskriver dem
    public void searchMovies(String Search) {
        Search = Search.toLowerCase();
        boolean found = false;
        for (Movie movie : MovieList) {
            if (movie.getTitle().toLowerCase().contains(Search)) {
                System.out.println("Movies found: \n" + movie);
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nThe movie you are looking for doesn't exist\n");
        }
    }

    // Returnerer det totale antal film i samlingen
    public int getMovieNumber() {
        int numberOfMovies = 0;
        for (Movie movie : MovieList) {
            numberOfMovies++;
        }
        return numberOfMovies;
    }

    // Udskriver alle film i samlingen til konsollen
    public void displayMovies() {
        for (Movie movie : MovieList) {
            System.out.println(movie.toString());
        }
    }

    // Returnerer listen over alle film i samlingen
    public ArrayList<Movie> getMovieList() {
        return MovieList;
    }

    // Redigerer en film baseret på en given titel og opdaterer dens detaljer, hvis et match findes
    public boolean editMovie(String search, String newTitle, String newDirector, int newYear, int newLength, boolean newIsInColor, String newGenre) {
        search = search.toUpperCase();
        for (Movie movie : MovieList) {
            if (movie.getTitle().equalsIgnoreCase(search)) {
                movie.setTitle(newTitle);
                movie.setDirector(newDirector);
                movie.setYearCreated(newYear);
                movie.setIsInColor(newIsInColor);
                movie.setLengthInMinutes(newLength);
                movie.setGenre(newGenre);
                isModified = true; // Marker, at listen er ændret
                return true;
            }
        }
        return false;
    }

    // Sletter en film fra samlingen baseret på titel og returnerer true, hvis den blev fundet og fjernet
    public boolean deleteMovie(String titleToDelete) {
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getTitle().equalsIgnoreCase(titleToDelete)) {
                MovieList.remove(i);
                isModified = true; // Marker, at listen er ændret
                return true;
            }
        }
        return false;
    }

    // Gemmer alle film til en fil, hvis der er foretaget ændringer
    public void saveMoviesFile() {
        if (!isModified) {
            System.out.println("You have not made any changes to your movie list - file has not been saved");
            return;
        }
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Movie movie : MovieList) {
                // Formaterer hver films data som en enkelt linje og skriver til filen
                writer.write(movie.getTitle() + "|" + movie.getDirector() + "|" + movie.getYearCreated() + "|" +
                        movie.isInColor() + "|" + movie.getLengthInMinutes() + "|" + movie.getGenre() + "\n");
            }
            System.out.println("Movies have been saved successfully");
            isModified = false; // Nulstil ændringsflaget
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
        }
    }

    // Indlæser filmdata fra en fil og tilføjer dem til samlingen
    public void loadMoviesFile() {
        try (Scanner scan = new Scanner(new File("movies.txt"))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] data = line.split("\\|");
                if (data.length == 6) { // Tjekker, at der er 6 dataelementer per linje
                    String title = data[0];
                    String director = data[1];
                    int yearCreated = Integer.parseInt(data[2]);
                    boolean isInColor = Boolean.parseBoolean(data[3]);
                    int lengthInMinutes = Integer.parseInt(data[4]);
                    String genre = data[5];
                    MovieList.add(new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre));
                }
            }
            System.out.println("Movies loaded successfully");
        } catch (IOException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    // Sorterer filmene i samlingen baseret på det angivne attribut
    public ArrayList<Movie> sortMovies(String attribute) {
        boolean running = true;
        String Choice = attribute.toLowerCase();
        while (running) {
            switch (Choice) {
                case "title", "Title" -> {
                    MovieList.sort(new MovieTitleComparator());
                    running = false;
                }
                case "director", "Director" -> {
                    MovieList.sort(new MovieDirectorComparator());
                    running = false;
                }
                case "year", "Year" -> {
                    MovieList.sort(new MovieYearCreatedComparator().reversed());
                    running = false;
                }
                case "color", "Color" -> {
                    MovieList.sort(new MovieIsInColorComparator());
                    running = false;
                }
                case "length", "Length" -> {
                    MovieList.sort(new MovieLengthInMinutesComparator());
                    running = false;
                }
                case "genre", "Genre" -> {
                    MovieList.sort(new MovieGenreComparator());
                    running = false;
                }

                default -> {
                    System.out.println("Enter a valid sorting criteria");
                    Scanner scan = new Scanner(System.in);
                    Choice = scan.nextLine();
                }
            }
        }
        return MovieList;
    }

    // Sorterer filmene baseret på to attributter, primær og sekundær
    public void sortMoviesByTwoAttributes(String primaryAttribute, String secondaryAttribute) {
        Comparator<Movie> primaryComparator = getMovieComparator(primaryAttribute);
        Comparator<Movie> secondaryComparator = getMovieComparator(secondaryAttribute);

       
        MovieList.sort(primaryComparator.thenComparing(secondaryComparator));
    }

    // Returnerer en comparator baseret på den angivne attribut
    private Comparator<Movie> getMovieComparator(String attribute) {
        boolean running = true;
        String Choice = attribute.toLowerCase();
        while (running) {
            switch (Choice) {
                case "title":
                    return Comparator.comparing(Movie::getTitle);
                case "director":
                    return Comparator.comparing(Movie::getDirector);
                case "year":
                    return Comparator.comparing(Movie::getYearCreated);
                case "color":
                    return Comparator.comparing(Movie::isInColor);
                case "length":
                    return Comparator.comparing(Movie::getLengthInMinutes);
                case "genre":
                    return Comparator.comparing(Movie::getGenre);
                default:
                    System.out.println("Enter a valid sorting criteria");
                    Scanner scan = new Scanner(System.in);
                    Choice = scan.nextLine();
            }
        }
        return null;
    }
}
