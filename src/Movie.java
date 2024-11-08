public class Movie {
    // Felter, der indeholder information om filmen
    private String title;
    private String director;
    private int yearCreated;
    private boolean isInColor;
    private int lengthInMinutes;
    private String genre;

    // Constructor til at initialisere alle felterne ved oprettelse af et Movie-objekt
    public Movie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }

    // Getter-metoder til at hente værdierne af felterne
    public String getTitle(){
        return title;  // Returnerer filmens titel
    }

    public String getDirector(){
        return director;  // Returnerer instruktørens navn
    }

    public int getYearCreated(){
        return yearCreated;  // Returnerer udgivelsesåret for filmen
    }

    public boolean isInColor(){
        return isInColor;  // Returnerer om filmen er i farve eller ej
    }

    // Konverterer isInColor-booleanen til en tekststreng ("Yes" eller "No")
    public String editColor(boolean isInColor){
        String isInColorString = null;
        if (isInColor){
            isInColorString = "Yes";
        } else {
            isInColorString = "No";
        }
        return isInColorString;
    }

    public int getLengthInMinutes(){
        return lengthInMinutes;  // Returnerer filmens længde i minutter
    }

    public String getGenre(){
        return genre;  // Returnerer filmens genre
    }

    // Setter-metoder til at ændre værdierne af felterne
    public void setTitle(String title) {
        this.title = title;  // Ændrer filmens titel
    }

    public void setDirector(String director){
        this.director = director;  // Ændrer instruktørens navn
    }

    public void setYearCreated(int yearCreated){
        this.yearCreated = yearCreated;  // Ændrer udgivelsesåret for filmen
    }

    public void setGenre(String genre){
        this.genre = genre;  // Ændrer filmens genre
    }

    public void setIsInColor(boolean isInColor){
        this.isInColor = isInColor;  // Ændrer om filmen er i farve eller ej
    }

    public void setLengthInMinutes(int lengthInMinutes){
        this.lengthInMinutes = lengthInMinutes;  // Ændrer filmens længde i minutter
    }

    // Returnerer en tekstbeskrivelse af filmen, som kan bruges til at vise filmens detaljer
    public String toString(){
        return "Movie title: " + title +
                " \nDirector: " + director +
                " \nYear created: " + yearCreated +
                " \nIs in color: " + editColor(isInColor) +
                "\nLength in minutes: " + lengthInMinutes +
                "\nGenre: " + genre + "\n\n";
    }
}
