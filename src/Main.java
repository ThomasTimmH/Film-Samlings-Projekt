import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Movie move = new Movie("Shawshank Redemption", "Frank Darabont", 1994, true, 144, "Drama");
        Scanner scan = new Scanner(System.in);

        System.out.println(move);

    }
}