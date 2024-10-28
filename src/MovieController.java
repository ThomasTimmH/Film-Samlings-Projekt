import java.util.ArrayList;

public class MovieController {
    MovieCollection movieCollection = new MovieCollection();

    public void showAllMovies() {
        movieCollection.displayMovies();
    }

    public void addMovie1(Movie movie) {
        movieCollection.addMovie(movie);
    }

    public void searchMovie1(String search) {
        movieCollection.searchMovies(search);
    }

    public boolean editMovie(String search, String newTitle, String newDirector, int newYear, int newLength, String newIsInColor, String newGenre){
return movieCollection.editMovie(search, newTitle, newDirector, newYear, newLength, newIsInColor, newGenre);
    }



}

