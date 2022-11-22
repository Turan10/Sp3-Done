import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SavedMovie {

    public Movie MovieSavedList() throws IOException {

        Scanner scan = new Scanner(System.in);
        ArrayList<Movie> savedMovieList = new ArrayList<>();
        List<Movie> movieList = new ArrayList<>();

        String listOfMovies = "/Users/turan/Documents/GitHub/SP3PLUS-1/SP3-PLUS/Data/ListOfMovies.txt";
        FileIO fileIO = new FileIO();
        BufferedReader reader = new BufferedReader(new FileReader(listOfMovies));
        movieList = fileIO.getMoviesFromFile(reader);
        Movie movie = new Movie("Godfather", "1972", "Crime; Drama", "9.2");
        BufferedWriter userWriter = new BufferedWriter(new FileWriter("/Users/turan/Documents/GitHub/SP3PLUS-1/SP3-PLUS/Data/SavedMoviesList.txt", true));


        for (Movie m : movieList) {
            System.out.println(m.toString());
        }

        try {
            System.out.println("Please enter the movie that you would like to save");
            //gemmer users input som 'saveMovie'
            String saveMovie = scan.nextLine();
            //erstatter det gamle navn af filmen til vores nye input som brugeren angiver
            movie.setName(saveMovie);

            //tilføjer vores movie til vores arraylist og printer det ud
            savedMovieList.add(movie);

            //Fortæller hvad der skal skrives til vores fil
            userWriter.write(movie.getName() + "\n");

            //Gemmer det i filen
            userWriter.close();
            System.out.println("You've chosen to save " + movie.getName());
        } catch (Exception e) {
            e.printStackTrace();

        }
        return movie;
    }

    public void displaySavedMovies() throws IOException {
        File file = new File("/Users/turan/Documents/GitHub/SP3PLUS-1/SP3-PLUS/Data/SavedMoviesList.txt");
        //FileInputStream - allows us to read bytes from a file - one byte at a time
        FileInputStream readFile = new FileInputStream(file);

        int oneByte;
        //We can write to System.out 'onebyte' at a time using its write() method.
        //FileInputStream returns -1 when it reaches the end of the file.
        while ((oneByte = readFile.read()) != -1) {
            System.out.print((char) oneByte);
        }
        System.out.flush();

    }
}
