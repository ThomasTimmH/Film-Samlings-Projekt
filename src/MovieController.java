import java.util.ArrayList;

public class MovieController {
    MovieCollection bob = new MovieCollection();

    public void showAllMovies(){
        bob.displayMovies();
    }

    public void addMovie1(Movie movie){
        bob.addMovie(movie);
    }

    public void searchMovie1(String search){
        bob.searchMovie(search);
    }




}

