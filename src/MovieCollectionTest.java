import org.junit.jupiter.api.Assertions;
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
        String actualResult = inception.getTitle();
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


    @Test
    void searchMovieExists(){
        MovieCollection movieCollection = new MovieCollection();


        // Act - Brug PlayList's findTrack metode til at finde dit nylavede Track objekt. Kald metoden getTitle på det track du har fundet og gem resultatet i en String variabel med navnet actualResult.
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, "Yes", 22, "Drama");
        movieCollection.addMovie(movie3);
        movieCollection.searchMovie("Hunger Games");
        String actualResult = movie3.getTitle();
        String expectedResult = "Hunger Games";

        // Assert - Lav en String variabel som hedder expectedResult, og tildel den den String-værdi du leder efter.
        // Brug herefter assertEquals således: assertEquals(expectedResult, actualResult).
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void searchMovieDoesNotExist(){
    }




    @Test
    void searchMoviesExists(){
        MovieCollection movieCollection = new MovieCollection();


        // Act - Brug PlayList's findTrack metode til at finde dit nylavede Track objekt. Kald metoden getTitle på det track du har fundet og gem resultatet i en String variabel med navnet actualResult.
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, "Yes", 22, "Drama");
        Movie movie4 = new Movie("Harry Potter 3", "gg", 2003, "Yes", 22, "Drama");
        movieCollection.addMovie(movie3);
        movieCollection.addMovie(movie4);
        movieCollection.searchMovie("H");
        String actualResult = movieCollection.getMovieList().get(0).getTitle() + "" + movieCollection.getMovieList().get(1).getTitle();
        String expectedResult = "Hunger Games" + "Harry Potter 3";

        // Assert - Lav en String variabel som hedder expectedResult, og tildel den den String-værdi du leder efter.
        // Brug herefter assertEquals således: assertEquals(expectedResult, actualResult).
        assertEquals(expectedResult, actualResult);
    }




}

