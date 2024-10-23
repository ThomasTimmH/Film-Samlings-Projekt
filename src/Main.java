import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Movie move = new Movie("Shawshank Redemption", "Frank Darabont", 1994, true, 144, "Drama");
        Scanner scan = new Scanner(System.in);

        MovieCollection movieCollection = new MovieCollection();

        System.out.println(move);

        System.out.println("Enter Title:");
        String userTitle = scan.nextLine();

        System.out.println("Enter a director");
        String userDirector = scan.nextLine();


    }
}