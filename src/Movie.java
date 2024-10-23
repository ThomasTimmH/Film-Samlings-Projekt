public class Movie {
    private String title;
    private String director;
    private int yearCreated;
    private boolean isInColor;
    private int lengthInMinutes;
    private String genre;



    public int getYearCreated(){
        return yearCreated;
    }

    public boolean isInColor(){
        return isInColor;
    }

    public int getLengthInMinutes(){
        return lengthInMinutes;
    }

    public String getGenre(){
        return genre;
    }
}
