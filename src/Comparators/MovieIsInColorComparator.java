package Comparators;

import Modles.Movie;

import java.util.Comparator;

public class MovieIsInColorComparator implements Comparator<Movie> {
    public int compare (Movie m1, Movie m2){  //Sammenligning af 2 Movie objekter (m1 og m2)
        return Boolean.compare(m1.isInColor(), m2.isInColor()); //Sammenligning af 2 Movie objekter i Boolean.

    }
}
