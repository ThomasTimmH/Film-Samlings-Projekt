import java.util.ArrayList;

public class MovieController {
    MovieCollection movieCollection = new MovieCollection(); // Instans af MovieCollection til at administrere filmene

    // Viser alle film i samlingen
    public void showAllMovies() {
        movieCollection.displayMovies();
    }

    // Tilføjer en ny film til samlingen
    public void addMovie1(Movie movie) {
        movieCollection.addMovie(movie);
    }

    // Søger efter en film baseret på søgeterm (titel)
    public void searchMovie1(String search) {
        movieCollection.searchMovies(search);
    }

    // Redigerer en film baseret på titel og opdaterer med nye værdier
    public boolean editMovie(String search, String newTitle, String newDirector, int newYear, int newLength, boolean newIsInColor, String newGenre) {
        return movieCollection.editMovie(search, newTitle, newDirector, newYear, newLength, newIsInColor, newGenre);
    }

    // Sletter en film baseret på titel
    public boolean deleteMovie(String titleToDelete) {
        return movieCollection.deleteMovie(titleToDelete);
    }

    // Gemmer filmlisten til en fil
    public void saveMovies() {
        movieCollection.saveMoviesFile();
    }

    // Indlæser filmlisten fra en fil
    public void loadMovies() {
        movieCollection.loadMoviesFile();
    }

    // Sorterer film baseret på et enkelt kriterium valgt af brugeren
    public void sortMovies(String userAtr) {
        movieCollection.sortMovies(userAtr);
    }

    // Sorterer film baseret på to kriterier, en primær og en sekundær attribut
    public void sortMoviesByTwoAttributes(String primaryAttribute, String secondaryAttribute) {
        movieCollection.sortMoviesByTwoAttributes(primaryAttribute, secondaryAttribute);
    }
}
