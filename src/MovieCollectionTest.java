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
    void addMovie1(){
        MovieCollection movieCollection = new MovieCollection();
        Movie movie1 = new Movie("Shawshank Redemption", "gg", 2003, "Yes", 22, "Drama");
        Movie movie2 = new Movie("The Prestige", "gg", 2003, "Yes", 22, "Drama");
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, "Yes", 22, "Drama");
        movieCollection.addMovie(movie1);
        movieCollection.addMovie(movie2);
        movieCollection.addMovie(movie3);

    }


    @Test
    void getMovieList() {
    }
}