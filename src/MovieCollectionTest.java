import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    void getMovieNumber(){
        MovieCollection movieCollection = new MovieCollection();
        Movie movie1 = new Movie("Shawshank Redemption", "gg", 2003, "Yes", 22, "Drama");
        Movie movie2 = new Movie("The Prestige", "gg", 2003, "Yes", 22, "Drama");
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, "Yes", 22, "Drama");
        movieCollection.addMovie(movie1);
        movieCollection.addMovie(movie2);
        movieCollection.addMovie(movie3);
        int expectedResult = 3;
        int actualResult = movieCollection.getMovieNumber();
        assertEquals(expectedResult,actualResult);

    }


    @Test
    void getMovieList() {
        MovieCollection movieCollection = new MovieCollection();
        Movie movie1 = new Movie("Shawshank Redemption", "gg", 2003, "Yes", 22, "Drama");
        Movie movie2 = new Movie("The Prestige", "gg", 2003, "Yes", 22, "Drama");
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, "Yes", 22, "Drama");
        movieCollection.addMovie(movie1);
        movieCollection.addMovie(movie2);
        movieCollection.addMovie(movie3);
        ArrayList actualResult = movieCollection.getMovieList();
        assertEquals(actualResult.size(),3);
    }
}

