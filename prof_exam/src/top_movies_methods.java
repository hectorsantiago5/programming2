import java.util.Objects;
import java.util.Arrays;
import java.text.DecimalFormat;

public class top_movies_methods {

    DecimalFormat df = new DecimalFormat("#,###,##0.00");
    private int fileLength;

    private double[] studioEarnings;
    private String[] studioNames;

    private String highestEarner;
    private double highestEarnings;

    private String lowestEarner;
    private double lowestEarnings;

    private double totalEarnings;

    public top_movies_methods(int fl)
    {
        fileLength = fl;

        studioEarnings = new double[fl];
        studioNames = new String[fl];

        highestEarner = "";
        highestEarnings = 0;

        lowestEarner = "";
        lowestEarnings = 0;

        totalEarnings = 0;
    }

    public void sortByGross(String[] movieName, String[] studio, String[] genre, double[] gross, int[] ticketSales)
    {
        for(int i = 0; i < (fileLength - 1); i += 1)
        {
            if(gross[i] < gross[i + 1])
            {
                double temp = gross[i];
                gross[i] = gross[i + 1];
                gross[i + 1] = temp;

                String temp2 = movieName[i];
                movieName[i] = movieName[i + 1];
                movieName[i + 1] = temp2;

                String temp3 = studio[i];
                studio[i] = studio[i + 1];
                studio[i + 1] = temp3;

                String temp4 = genre[i];
                genre[i] = genre[i + 1];
                genre[i + 1] = temp4;

                int temp5 = ticketSales[i];
                ticketSales[i] = ticketSales[i + 1];
                ticketSales[i + 1] = temp5;

                i = -1;
            }
        }
    }

    public void displayByGross(String[] movieName, double[] gross)
    {
        for(int i = 0; i < fileLength; i += 1)
        {
            System.out.printf("%-40s %15s %n", movieName[i], "$" + df.format((gross[i]/1000000)) + "M");
        }
    }

    public void actionMovies(String[] movieName, String[] studio, String[] genre)
    {
        System.out.println("\n\nTask 3: Display the Action and Adventure Movies\n");
        System.out.println("Action");
        for(int i = 0; i < fileLength; i += 1)
        {
            if(genre[i].equals("Action"))
            {
                System.out.printf("%-40s %30s %n", movieName[i], studio[i]);
            }
        }
    }

    public void adventureMovies(String[] movieName, String[] studio, String[] genre)
    {
        System.out.println("\n\nAdventure");
        for(int i = 0; i < fileLength; i += 1)
        {
            if(genre[i].equals("Adventure"))
            {
                System.out.printf("%-40s %30s %n", movieName[i], studio[i]);
            }
        }
    }

    public void highestAndLowestEarnings(String[] studio, double[] gross)
    {
        System.out.println("\n\nTask 4: Display the studios with the Highest Gross Earnings and the Lowest Gross Earnings\n");
        for(int i = 0; i < fileLength; i += 1)
        {
            studioNames[i] = studio[i];
            for(int j = 0; j < fileLength; j += 1)
            {
                if(studioNames[i].equals(studio[j]))
                {
                    studioEarnings[i] += gross[j];
                }
            }
        }

        highestEarner = studioNames[0];
        highestEarnings = studioEarnings[0];
        lowestEarner = studioNames[0];
        lowestEarnings = studioEarnings[0];

        for(int k = 0; k < fileLength-1; k += 1)
        {
            if(highestEarnings <= studioEarnings[k])
            {
                highestEarner = studioNames[k];
                highestEarnings = studioEarnings[k];
            }
            if(lowestEarnings >= studioEarnings[k])
            {
                lowestEarner = studioNames[k];
                lowestEarnings = studioEarnings[k];
            }
        }
        System.out.println("Highest Earnings - " + highestEarner + "        $" + df.format((highestEarnings/1000000)) + "M");
        System.out.println("Lowest Earnings - " + lowestEarner + "        $" + df.format((lowestEarnings/1000000)) + "M");
    }

    public void grossSales(double[] gross)
    {
        System.out.println("\n\nTask 5: Compute and Display the Total Gross Earnings for the Movie Industry for 2019\n");
        for(int i = 0; i < fileLength; i += 1)
        {
            totalEarnings += gross[i];
        }
        System.out.print("The total gross earnings for the movie industry in 2019 was $" + df.format((totalEarnings/1000000000)) + " Billion.");
    }
}
