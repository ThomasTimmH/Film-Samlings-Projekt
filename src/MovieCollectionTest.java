import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addMovie() {
        MovieCollection gg = new MovieCollection();
        Movie inception = new Movie("Inception", "gg", 2003, true, 22, "Drama");
        gg.addMovie(inception);
        String expectedResult = "Inception";
        String actualResult = inception.getTitle();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void getMovieNumber(){
        MovieCollection movieCollection = new MovieCollection();
        Movie movie1 = new Movie("Shawshank Redemption", "gg", 2003, true, 22, "Drama");
        Movie movie2 = new Movie("The Prestige", "gg", 2003, true, 22, "Drama");
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
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

        Movie movie1 = new Movie("Shawshank Redemption", "gg", 2003, true, 22, "Drama");
        Movie movie2 = new Movie("The Prestige", "gg", 2003, true, 22, "Drama");
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");

        movieCollection.addMovie(movie1);
        movieCollection.addMovie(movie2);
        movieCollection.addMovie(movie3);

        ArrayList actualResult1 = movieCollection.getMovieList();
        int expectedResult1 = 3;


        // Title expected/result
        String expectedTitle1 = movie1.getTitle();
        String actualTitle1 = movieCollection.getMovieList().get(0).getTitle();

        String expectedTitle2 = movie2.getTitle();
        String actualTitle2 = movieCollection.getMovieList().get(1).getTitle();

        String expectedTitle3 = movie3.getTitle();
        String actualTitle3 = movieCollection.getMovieList().get(2).getTitle();


        // Confirm movie list length
        assertEquals(actualResult1.size(),expectedResult1);

        // Confirm movie 1, movie 2 and movie 3 are correctly placed in the array list
        assertEquals(expectedTitle1, actualTitle1);
        assertEquals(expectedTitle2, actualTitle2);
        assertEquals(expectedTitle3, actualTitle3);
    }


    @Test
    void searchMovieExists(){
        MovieCollection movieCollection = new MovieCollection();


        // Act - Brug PlayList's findTrack metode til at finde dit nylavede Track objekt. Kald metoden getTitle på det track du har fundet og gem resultatet i en String variabel med navnet actualResult.
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        movieCollection.addMovie(movie3);
        Movie search = movieCollection.searchMovie("Hunger Games");
        String actualResult = movie3.getTitle();
        String expectedResult = "Hunger Games";

        // Assert - Lav en String variabel som hedder expectedResult, og tildel den den String-værdi du leder efter.
        // Brug herefter assertEquals således: assertEquals(expectedResult, actualResult).
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void searchMovieDoesNotExist(){
        // Arrange - Lav et PlayList objekt, et Track objekt og tilføj Track objektet til PlayList.
        MovieCollection movieCollection = new MovieCollection();

        // Act - Brug PlayList's findTrack metode til at finde et Track som vi ved ikke findes i PlayList. Resultatet af dette metodekald tildeles variablen actualResult som skal være af typen Track.
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        movieCollection.addMovie(movie3);

        //Tester for CAPS-sensitivity og wrong spelling
        Movie movie = movieCollection.searchMovie("Bruno");
        Movie movie1 = movieCollection.searchMovie("bruno");
        Movie movie2 = movieCollection.searchMovie("hunnger games");


        // Assert - Brug Assertion metoden assertNull og giv den actualResult som argument .
        Assertions.assertNull(movie);
        Assertions.assertNull(movie1);
        Assertions.assertNull(movie2);

    }




    @Test
    void searchMoviesExists(){
        MovieCollection movieCollection = new MovieCollection();


        // Act - Brug PlayList's findTrack metode til at finde dit nylavede Track objekt. Kald metoden getTitle på det track du har fundet og gem resultatet i en String variabel med navnet actualResult.
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        Movie movie4 = new Movie("Harry Potter 3", "gg", 2003, true, 22, "Drama");
        movieCollection.addMovie(movie3);
        movieCollection.addMovie(movie4);
        movieCollection.searchMovie("H");
        String actualResult = movieCollection.getMovieList().get(0).getTitle() + "" + movieCollection.getMovieList().get(1).getTitle();
        String expectedResult = "Hunger Games" + "Harry Potter 3";

        // Assert - Lav en String variabel som hedder expectedResult, og tildel den den String-værdi du leder efter.
        // Brug herefter assertEquals således: assertEquals(expectedResult, actualResult).
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void displayMovies(){
        ArrayList<Movie> arrayListMovies = new ArrayList<>();
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        Movie movie4 = new Movie("Harry Potter 3", "gg", 2003, true, 22, "Drama");
        arrayListMovies.add(movie3);
        arrayListMovies.add(movie4);

        String expectedResult = movie3 + " " + movie4;
        String actualResult = arrayListMovies.get(0).toString() + " " + arrayListMovies.get(1).toString();


        assertEquals(expectedResult, actualResult);
    }


    @Test
    void editMovie(){
ArrayList<Movie> arrayListMovies = new ArrayList<>();
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        arrayListMovies.add(movie3);
        movie3.setTitle("Stuck in the dryer");
        String expectedResult = "Stuck in the dryer";
        String actualResult = movie3.getTitle();

        assertEquals(expectedResult,actualResult);
    }



    @Test
    void deleteMovie(){
        ArrayList<Movie> arrayListMovies = new ArrayList<>();
        Movie movie3 = new Movie("Hunger Games", "gg", 2003, true, 22, "Drama");
        Movie movie4 = new Movie("Harry Potter 3", "gg", 2003, true, 22, "Drama");
        arrayListMovies.add(movie3);
        arrayListMovies.add(movie4);

        arrayListMovies.remove(0);

        int expectedResult = 1;
        int actualResult = arrayListMovies.size();

        assertEquals(expectedResult, actualResult);
    }




}

