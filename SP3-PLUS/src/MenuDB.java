import java.io.IOException;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Scanner;



public class MenuDB {
        public static void login() throws IOException{
            System.out.println("Velkommen til Chill!");
            System.out.println("Hvad kunne du tænke dig?\n 1. Opret bruger:\n 2. Login");
            Scanner loginScan = new Scanner(System.in);

            switch (loginScan.nextLine()){
                case "1":
                UserDB userDB = new UserDB();
                userDB.createUsersToDB();
                MenuDB.runProgramDB();
                break;

                case "2":
                UserDB userDB1 = new UserDB();
                userDB1.userLogin();
                MenuDB.runProgramDB();
            }
        }


        public static void runProgramDB() throws IOException {

            DatabaseFileIO database = new DatabaseFileIO();
            SavedMoviesDB savedMoviesDB = new SavedMoviesDB();
            WatchedMoviesDB watchedMoviesDB = new WatchedMoviesDB();


            while (true) {
                System.out.println("Hvad kunne du tænke dig?\n 1. Se en liste over alle film.\n 2. Se en liste over alle serier.\n 3. Se din liste over gemte film." +
                        "\n 4. Gem en film. \n 5. Se din liste af sete film. \n 6.Søg");
                Scanner choice = new Scanner(System.in);


                switch (choice.nextLine()) {
                    case "1":

                        watchedMoviesDB.addMovieToWatchedMoviesList();
                        break;

                    case "2":

                        database.seriesListDB();
                        break;

                    case "3":

                        savedMoviesDB.getSavedMoviesFromDatabase();
                        break;

                    case "4":

                        savedMoviesDB.addMovieToSavedMoviesList();
                        break;

                    case "5":

                        watchedMoviesDB.getWatchedMoviesFromDatabase();
                        break;

                    //Denne case er ligesom vores menu switch hvor vi her kommer til at switche på omend bruger skriver film eller serie.
                    // Så switch case 4 "søg" vil først spørger om hvorvidt man vil søge en film eller serie, for derefter at komme ned til denne case
                    case "6":
                        SearchDB searchDB = new SearchDB();
                        System.out.println("Søger du efter film eller serie?");
                        switch (choice.nextLine()) {
                            case "film":
                                searchDB.searchMovies();
                                break;
                            case "serie":
                                searchDB.searchSeries();
                        }
                        break;

                }
            }
        }
    }


