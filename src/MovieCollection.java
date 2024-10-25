import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> MovieList = new ArrayList();

    public void addMovie(Movie movie) {
        MovieList.add(movie);
    }


    public String toString() {
        return MovieList.toString();
    }

    public void searchMovie(String Search) {
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

    public void displayMovies() {
        for (Movie movie : MovieList) {
            System.out.println(movie.toString());
        }
    }

    public ArrayList<Movie> getMovieList(){
        return MovieList;
    }

    public boolean editMovie(String search, String newTitle, String newDirector, int newYear, int newLength, String newIsInColor, String newGenre) {
        search = search.toUpperCase();
        for (Movie movie : MovieList) {
            if (movie.getTitle().equalsIgnoreCase(search)) {
                movie.setTitle(newTitle);
                movie.setDirector(newDirector);
                movie.setYearCreated(newYear);
                movie.setIsInColor(newIsInColor);
                movie.setLengthInMinutes(newLength);
                movie.setGenre(newGenre);
                return true;
            }
        } return false;
    }



}
