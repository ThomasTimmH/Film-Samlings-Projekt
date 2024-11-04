import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieCollection {
    private ArrayList<Movie> MovieList = new ArrayList();
    private static final String FILE_NAME = "movies.txt";
    private boolean isModified = false; // Track if changes were made

    public void addMovie(Movie movie) {
        MovieList.add(movie);
        isModified = true;
    }


    public String toString() {
        return MovieList.toString();
    }

    public Movie searchMovie(String search) {
        search = search.toLowerCase();
        for (Movie movie : MovieList) {
            if (movie.getTitle().toLowerCase().contains(search)) {
                return movie;
            }
        }
        return null;
    }

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


    public int getMovieNumber() {
        int numberOfMovies = 0;
        for (Movie movie : MovieList) {
            numberOfMovies++;
        }
        return numberOfMovies;
    }

    public void displayMovies() {
        for (Movie movie : MovieList) {
            System.out.println(movie.toString());
        }
    }

    public ArrayList<Movie> getMovieList() {
        return MovieList;
    }

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
                isModified = true;
                return true;
            }
        }
        return false;
    }

    public boolean deleteMovie(String titleToDelete) {
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getTitle().equalsIgnoreCase(titleToDelete)) {
                MovieList.remove(i);
                isModified = true;
                return true;
            }
        }
        return false;
    }


    public void saveMoviesFile() {
        if (!isModified){
            System.out.println("You have not made any changes to your movie list - file has not been saved");
            return;
        }
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
                for (Movie movie : MovieList) {
                    // Format each movie data as a single line and write to the file
                    writer.write(movie.getTitle() + "|" + movie.getDirector() + "|" + movie.getYearCreated() + "|" +
                            movie.isInColor() + "|" + movie.getLengthInMinutes() + "|" + movie.getGenre() + "\n");
            }
                System.out.println("Movies have been saved sucessfully");
                isModified = false;
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
        }
    }


    public void loadMoviesFile(){
        try(Scanner scan = new Scanner(new File("movies.txt"))){
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] data = line.split("\\|");
                if (data.length == 6) {
                    String title = data[0];
                    String director = data[1];
                    int yearCreated = Integer.parseInt(data[2]);
                    boolean isInColor = Boolean.parseBoolean(data[3]);
                    int lengthInMinutes = Integer.parseInt(data[4]);
                    String genre = data[5];
                    MovieList.add(new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre));

                }
            }
            System.out.println("Movies loaded sucessfully");
        } catch (IOException e){
            System.out.println("An error has occured: " + e.getMessage());
        }
    }

}



