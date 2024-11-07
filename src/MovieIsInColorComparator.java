import java.util.Comparator;

public class MovieIsInColorComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return Boolean.compare(m2.isInColor(), m1.isInColor());
    }
}
