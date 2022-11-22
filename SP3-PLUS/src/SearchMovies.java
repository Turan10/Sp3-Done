import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SearchMovies {
    private Scanner choice = new Scanner(System.in);
    private String fileName = "/Users/turan/Documents/GitHub/SP3PLUS-1/SP3-PLUS/Data/ListOfMovies.txt";
    private FileIO fio = new FileIO();


    public void searchForMovie() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<Movie> movies = fio.getMoviesFromFile(reader);


        System.out.println("Which movie are you looking for?");
        String movieSearch = choice.nextLine();

        boolean found = false;

        for (Movie m : movies) {
            if (m.getName().toLowerCase().contains(movieSearch.toLowerCase())) {
                System.out.println(m.toString());
                found = true;
            }

        }
        if (!found) {
            System.out.println("This movie doesn't exist in our library");

        }
    }
}
