import java.util.Comparator;

public class MovieLengthInMinutesComparator implements Comparator<Movie> {
    public int compare (Movie m1, Movie m2){  //Sammenligning af 2 Movie objekter (m1 og m2)
        return m1.getLengthInMinutes() - m2.getLengthInMinutes(); //Sammeligning af 2 Movie objekter, denne gang i int
    }


}