import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Movie move = new Movie("Shawshank Redemption", "Frank Darabont", 1994, true, 144, "Drama");
        Scanner scan = new Scanner(System.in);

        MovieCollection movieCollection = new MovieCollection();

        System.out.println(move);

        String userTitle;

        System.out.println("Enter Title: ");
        userTitle = scan.nextLine();
        System.out.println(userTitle);

        int movieYear;

        System.out.println("Enter the year the movie was made: ");
        movieYear = scan.nextInt();
        System.out.println(movieYear);

        String movieGenre;

        System.out.println("Enter the movie's genre: ");
        movieGenre = scan.nextLine();
        System.out.println(movieGenre);
    }
}