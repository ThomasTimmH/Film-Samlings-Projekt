import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addMovie() {
        MovieCollection gg = new MovieCollection();
        Movie inception = new Movie("Inception", "gg", 2003, "Yes", 22, "Drama");
        gg.addMovie(inception);
        String expectedResult = "Inception";
        String actualResult = "Inception";
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void getMovieList() {
    }
}