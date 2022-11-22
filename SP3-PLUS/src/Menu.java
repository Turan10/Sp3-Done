import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public Menu() throws IOException {
    }

    public void login() throws IOException {
        System.out.println("1.Create account: \n2.Login: ");
        Scanner loginscan = new Scanner(System.in);
        User user = new User();


        switch (loginscan.nextLine()) {
            case "1":
                User.UserCreation();
                System.out.println("Use your newly created account");
                break;


            case "2":
                User.userlogin();

                break;
            default:
                System.out.println("invalid choice");
                break;

        }

    }


    public void runProgram() throws IOException {

        while (true) {

            System.out.println("What would you like?\n 1. View a list of all movies.\n 2. View a list of all series.\n 3. View your saved movies.\n 4.Search" +
                    "\n 5. Save a movie. \n 6. View your watched movies");
            Scanner choice = new Scanner(System.in);

            switch (choice.nextLine()) {
                case "1":

                    DPMovielist dpMovielist = new DPMovielist();
                    dpMovielist.movieListOption();

                    break;

                case "2":

                    DPSerieslist dpSerieslist = new DPSerieslist();
                    dpSerieslist.seriesListOption();

                    break;

                case "3":
                    SavedMovie savedMovie1 = new SavedMovie();
                    savedMovie1.displaySavedMovies();

                    break;

                case "4":
                    System.out.println("Are you searching for movies or series?");

                    switch (choice.nextLine()) {
                        case "movie":
                            SearchMovies searchMovies = new SearchMovies();
                            searchMovies.searchForMovie();

                            break;

                        case "series":
                            SearchSeries searchSeries = new SearchSeries();
                            searchSeries.searchASeries();

                            break;
                    }
                    break;

                case "5":
                    SavedMovie savedMovies = new SavedMovie();
                    savedMovies.MovieSavedList();

                    break;

                case "6":
                    DisplayWatchedMovies displayWatchedMovies = new DisplayWatchedMovies();
                    displayWatchedMovies.watchedMoviePreview();
            }
        }
    }
}

