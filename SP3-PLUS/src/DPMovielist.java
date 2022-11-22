import java.io.*;
import java.util.List;
import java.util.Scanner;

public class DPMovielist {
    private String fileName = "/Users/turan/Documents/GitHub/SP3PLUS-1/SP3-PLUS/Data/ListOfMovies.txt";
    private FileIO fio = new FileIO();


    // These properties are to write the watched movie to our watched movielist
    private File file1 = new File("/Users/turan/Documents/GitHub/SP3PLUS-1/SP3-PLUS/Data/WatchedMovieList.txt");
    private Scanner choice = new Scanner(System.in);


    public void movieListOption() throws IOException {
        //These properties are to iterate through our file with movies
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<Movie> movies = fio.getMoviesFromFile(reader);


        for (Movie m : movies) {
            System.out.println(m.toString());
        }

        System.out.println("Would you like to watch one of the above movies? Yes / No");
        switch (choice.nextLine()) {
            case "Yes":
                System.out.println("Which movie would you like to see?");
                String chosenMovie = choice.nextLine();
                boolean found1 = false;
                for (Movie m : movies) {
                    //checks if the movie the user writes, is in our movieList
                    if (m.getName().equalsIgnoreCase(chosenMovie)) {
                        found1 = true;
                    }
                }

                System.out.println("You've chosen: " + chosenMovie);
                System.out.println("Movie playing");

                // These properties are to write the watched movie to our watched movielist

                BufferedWriter writeToWatchedMovieFileList = new BufferedWriter(new FileWriter(file1, true));
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));

                writeToWatchedMovieFileList.write(chosenMovie + "\n");
                writeToWatchedMovieFileList.close();


                if (!found1) {
                    System.out.println("The movie doesn't exist in our library");
                }


        }
    }
}
