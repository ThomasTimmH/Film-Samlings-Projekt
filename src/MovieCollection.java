import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> MovieList = new ArrayList();

    public void addMovie(Movie movie) {
        MovieList.add(movie);
    }

    public String toString(){
        return MovieList.toString();
    }

    public void searchMovie(String Search) {
        Search=Search.toLowerCase();
        for (Movie movie : MovieList) {
            if (movie.getTitle().toLowerCase().contains(Search)) {
                System.out.println("Movies found: \n" + movie);

            }
        }
    }

    public void displayMovies(){
        for(Movie movie : MovieList){
            System.out.println(movie.toString());
        }
    }


}
