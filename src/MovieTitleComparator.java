import java.util.Comparator;

public class MovieTitleComparator implements Comparator<Movie> {
    public int compare (Movie m1, Movie m2){ //Sammenligning af 2 Movie objekter (m1 og m2)
        return m1.getTitle().compareTo(m2.getTitle()); //Sammeligning af de 2 Movie objekters titel
    }


}
