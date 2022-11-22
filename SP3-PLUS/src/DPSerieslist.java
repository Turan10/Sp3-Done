import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DPSerieslist {

    String seriesFileName = "/Users/turan/Documents/GitHub/SP3PLUS-1/SP3-PLUS/Data/ListOfSeries.txt";
    FileIO fio = new FileIO();
    Scanner choice = new Scanner(System.in);


    public void seriesListOption() throws IOException {
        BufferedReader readSeries = new BufferedReader(new FileReader(seriesFileName));
        List<Series> series = fio.getSeriesFromFile(readSeries);

        for (Series s : series) {
            System.out.println(s.toString());
        }

    }
}
