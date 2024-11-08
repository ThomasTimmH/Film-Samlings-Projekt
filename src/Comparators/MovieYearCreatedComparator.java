package Comparators;

import Modles.Movie;

import java.util.Comparator;

public class MovieYearCreatedComparator implements Comparator<Movie> {
    public int compare (Movie m1, Movie m2){  //Sammenligning af 2 Movie objekter (m1 og m2)
        return m1.getYearCreated() - m2.getYearCreated(); //Sammenligning af 2 Movie objekter, i int.
    }


}