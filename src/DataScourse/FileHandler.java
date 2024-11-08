package DataScourse;
import Modles.Movie;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class FileHandler {

private File file = new File("movies.txt");

public ArrayList<Movie> loadFromFile() {
    ArrayList<Movie> listOfMovies = new ArrayList<>();

    if (!file.exists()||file.length()==0){
        return listOfMovies;
    }

    try (Scanner sc = new Scanner(file)) {
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!line.isBlank()) {
                String[] data = line.split(",");
                String title = data[0];
                String director = data[1];
                int yearCreated = Integer.parseInt(data[2]);
                boolean isInColor = Boolean.parseBoolean(data[3]);
                int lengthInMinutes = Integer.parseInt(data[4]);
                String genre = data[5];

                listOfMovies.add(new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre));
            }
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException("File not found: filmProjekt.txt", e);
    }
    return listOfMovies;
}

    public void saveToFile(ArrayList<Movie> movies) {
        try (FileWriter writer = new FileWriter(file, true)) {
            for (Movie movie : movies) {
                writer.write(movie.toCSVStyle());
            }
        } catch (IOException e) {
            System.err.println("Error saving movies to file: " + e.getMessage());
        }
    }


}
