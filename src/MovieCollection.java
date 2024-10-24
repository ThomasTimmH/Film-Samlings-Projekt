import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> MovieList = new ArrayList();


    public void addMovie(Movie movie) {
        MovieList.add(movie);
    }

    public String toString() {
        return MovieList.toString();
    }

    public void searchMovie(String titleSearch) {
        titleSearch.toUpperCase();
        boolean found = false;
        for (Movie movie : MovieList) {
            if (movie.getTitle().equals(titleSearch)) {
                System.out.println("The movie(s) found:" + movie.getTitle());
                found = true;
            }
        }
        if (!found){
            System.out.println("Could not find the movie you are looking for");
        }
    }

    public void searchMovieByLetter(String letterSearch) {
        letterSearch.toUpperCase();
        boolean found = false;
        for (Movie movie : MovieList) {
            if (movie.getTitle().contains(letterSearch)) {
                System.out.println("Movies found: \n" + movie);
                found = true;
            }
        }
        if (!found){
            System.out.println("Could not find any movies that include '" + letterSearch + "'");
        }
    }
}
