import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SearchSeries {

    String seriesFileName = "/Users/turan/Documents/GitHub/SP3PLUS-1/SP3-PLUS/Data/ListOfSeries.txt";
    FileIO fio = new FileIO();
    Scanner choice = new Scanner(System.in);


    public void searchASeries() throws IOException {
        BufferedReader readSeries = new BufferedReader(new FileReader(seriesFileName));
        List<Series> series = fio.getSeriesFromFile(readSeries);


        System.out.println("Which series are you looking for?");
        String seriesSearch = choice.nextLine();
        boolean found = false;

        for (Series s : series) {
            if (s.getName().toLowerCase().contains(seriesSearch.toLowerCase())) {
                System.out.println(s.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("This series doesn't exist in our library");

        }


    }
}
