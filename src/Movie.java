public class Movie {
    private String title;
    private String director;
    private int yearCreated;
    private String isInColor;
    private int lengthInMinutes;
    private String genre;

    public Movie(String title, String director, int yearCreated, String isInColor, int lengthInMinutes, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }

    public String getTitle(){
        return title;
    }

    public String getDirector(){
        return director;
    }

    public int getYearCreated(){
        return yearCreated;
    }

    public String isInColor(){
        return isInColor;
    }

    public int getLengthInMinutes(){
        return lengthInMinutes;
    }

    public String getGenre(){
        return genre;
    }

    public String toString(){
        return "Movie title: " + title + " \nDirector: " + director + " \nyear created: " + yearCreated + " \nis in color: "
                + isInColor + " \nlength in minutes: " + lengthInMinutes + " \ngenre: " + genre + "\n\n";
    }
}
