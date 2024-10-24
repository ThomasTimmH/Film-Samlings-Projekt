public class MovieController {
    MovieCollection movieCollection = new MovieCollection();

    public void showAllMovies() {
        movieCollection.displayMovies();
    }

    public void addMovie1(Movie movie) {
        movieCollection.addMovie(movie);
    }

    public void searchMovie1(String search) {
        movieCollection.searchMovie(search);
    }


}

