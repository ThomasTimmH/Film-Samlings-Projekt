import java.util.Comparator;

public class MovieDirectorComparator implements Comparator<Movie> {
    public int compare (Movie m1, Movie m2){ //Sammenligning af 2 Movie objekter (m1 og m2)
        return m1.getDirector().compareTo(m2.getDirector()); //Sammenligning af de 2 Movie objekters Director, aflabetisk.
    }


}