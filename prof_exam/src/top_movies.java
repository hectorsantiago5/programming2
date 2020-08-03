import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class top_movies {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("/Users/hectorsantiago/IdeaProjects/programming2/prof_exam/src/MovieData.txt"));// reads the file

        int fileLength = 0;
        while((br.readLine()) != null)
        {
            fileLength += 1;
        }

        top_movies_methods tm = new top_movies_methods(fileLength); // Connect to working class
        String[] movieLine = new String[fileLength];
        String[] movieName = new String[fileLength];
        String[] studio = new String[fileLength];
        String[] genre = new String[fileLength];
        double[] gross = new double[fileLength];
        int[] ticketSales = new int[fileLength];

        System.out.println("\nTask 1: Display contents of the File\n");
        br = new BufferedReader(new FileReader("MovieData.txt"));
        for(int i = 0; i < fileLength; i += 1)
        {
            movieLine[i] = br.readLine();
            System.out.println(movieLine[i]);
        }
        br.close();

        for(int i = 0; i < fileLength; i += 1)
        {
            StringTokenizer st = new StringTokenizer(movieLine[i], ",");

            movieName[i] = st.nextToken();
            studio[i] = st.nextToken();
            genre[i] = st.nextToken();
            gross[i] = Double.parseDouble(st.nextToken());
            ticketSales[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println("\n\nTask 2: Movies Ranked by Gross Sales\n");
        System.out.println("\n--------------------------------------------------------");
        System.out.println("             Movies Ranked by Gross Sales: ");
        System.out.println("--------------------------------------------------------");
        tm.sortByGross(movieName, studio, genre, gross, ticketSales);
        tm.displayByGross(movieName, gross);
        tm.actionMovies(movieName, studio, genre);
        tm.adventureMovies(movieName, studio, genre);
        tm.highestAndLowestEarnings(studio, gross);
        tm.grossSales(gross);
    }
}

