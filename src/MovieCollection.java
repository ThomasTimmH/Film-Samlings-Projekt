import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> MovieList = new ArrayList();


    public void addMovie(Movie movie) {
        MovieList.add(movie);
    }

    public String toString(){
        return MovieList.toString();
    }


}
