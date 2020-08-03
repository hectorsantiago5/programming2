import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class CaldwellTheaters
{
    Scanner scan = new Scanner(System.in);
    private int SeatsAvailable[][] = {{1,1,1,1,1,1,1,1},//Array of sentinel values. Used to check if a seat is taken or not.
            {1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1}};
    private String Seats[][] = {{"H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8"},//Array of seat positions. Used to show users what seats are available.
            {"G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8"},
            {"F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8"},
            {"E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8"},
            {"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8"},
            {"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8"},
            {"B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8"},
            {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8"}};
    private int[] rows = new int[64];// Stores row value for price computation in receipt.
    private String[] seatName = new String[64];// Stores seat name for receipt.
    private String seatChoice;//The user's indivdual seat choices.

    private DateTimeFormatter dtf;
    private LocalDateTime now;

    private int price;//price of one seat chosen.
    private int i;//control variable for rows in the for loop, and case parameter for switch statement.
    private int k;// control variable for getReceipt method loop.
    private int m;// Used to calculated the price per seat.
    private int row;// Represents the row of a seat.
    private int col;// Represents the column of a seat.
    private int jIncrement;// Used to add incriments to the loop in Demo class if user inputs invalid values.

    private boolean seatAvailable;//Indicates whether a seat is or isn't available.

    public CaldwellTheaters()
    {
        price = 0;

        jIncrement = 0;
        seatAvailable = true;

        dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        now = LocalDateTime.now();
    }

    public static void sleep(long miliseconds)
    {
        try
        {
            Thread.sleep(miliseconds);
        }
        catch(Exception e)
        {
        }
    }

    public static void timer(long end)
    {
        long start = System.currentTimeMillis();
        long time = end - System.currentTimeMillis();

        if(time > 300000)
        {

        }
        else if(time < 300000 | time > 30000)
        {
            System.out.print("\nSorry, but the movie is ending in " + (time/60000) + " minutes. Please wait for the next movie.");
            System.exit(0);
        }
        else
        {
            System.out.print("\nThe movie is over, please come back another time or ask about other showings today. Thank you.");
            System.exit(0);
        }
    }

    public void movieTimes(long untilMovie, long movieLength, String movieTitle, long end)
    {
        long timeLeftUntilStart = end - System.currentTimeMillis() - (60000*movieLength);
        long timeLeftUntilMovieEnds = end - System.currentTimeMillis() - (60000*untilMovie);

        if(timeLeftUntilStart > 0)
        {
            System.out.println("================================================");
            System.out.println("The movie \"" + movieTitle + "\" will begin in " + (timeLeftUntilStart/60000) + " min.\n\"" + movieTitle + "\" is " + movieLength + " min long.");
            System.out.println("================================================");
        }
        else
        {
            System.out.println("================================================");
            System.out.println("The movie \"" + movieTitle + "\" began playing " + (movieLength-(timeLeftUntilMovieEnds/60000)) + " min ago.\n\"" + movieTitle + "\" will end in " + (timeLeftUntilMovieEnds/60000) + " min.");
            System.out.println("================================================");
        }
    }

    public void setPrice(int rows)
    {
        switch(rows)
        {
            case(0):
            {
                price = 10;
                break;
            }
            case(1):
            {
                price = 20;
                break;
            }
            case(2):
            {
                price = 30;
                break;
            }
            case(3):
            {
                price = 40;
                break;
            }
            case(4):
            {
                price = 50;
                break;
            }
            case(5):
            {
                price = 60;
                break;
            }
            case(6):
            {
                price = 70;
                break;
            }
            case(7):
            {
                price = 80;
                break;
            }
        }
    }

    public void seatChoice(String hi, int j)
    {
        if(hi.length() == 2)
        {
            row = -1*(hi.charAt(0) - 72);
            col = (hi.charAt(1) - 49);
        }

        if(row < 8 && row > -1 && col < 8 && col > -1 && hi.length() == 2)
        {
            if(SeatsAvailable[row][col] != 0)
            {
                now = LocalDateTime.now();
                m = row;
                setPrice(m);

                System.out.println("Seat " + Seats[row][col] + " is available and costs $" + price);
                System.out.println("\nPlease confirm you want to purchase seat " + Seats[row][col] + " (Enter 'yes' or 'no').");
                char ticketConfirmation = scan.nextLine().charAt(0);

                if(ticketConfirmation == 'Y'||ticketConfirmation == 'y')
                {
                    rows[j] = row;
                    seatName[j] = hi;

                    System.out.println("- - - - - - - - - - - - - - - - - -\n");
                    System.out.println("Here is your ticket: ");
                    System.out.println(" _______________________________________________");
                    System.out.println("| * |        THE CALDWELL GRAND THEATER         |");
                    System.out.println("| C |-------------------------------------------|");
                    System.out.println("| G |          " + dtf.format(now) + "              |");
                    System.out.println("| T |-------------------------------------------|");
                    System.out.println("| * |  Room: 1 | Seat: " + hi + " |    www.cgt.com      |");
                    System.out.println("|___|___________________________________________|");

                    SeatsAvailable[row][col] = 0;
                    seatAvailable = true;
                }
                else if(ticketConfirmation == 'N' || ticketConfirmation == 'n')
                {
                    System.out.println("Ok, lets try again");
                    seatAvailable = false;
                    price = 0;
                }
                else
                {
                    System.out.println("Invalid input. Please choose another seat.");
                    seatAvailable = false;
                    price = 0;
                }
            }
            else if(SeatsAvailable[row][col] == 0)
            {
                System.out.println("Sorry! That seat is not available.");
                seatAvailable = false;
                price = 0;
            }
        }
        else
        {
            System.out.println("The selected seat does not exist.");
            seatAvailable = false;
            price = 0;
        }
    }

    public int seatAvailable(boolean exit)
    {

        if(seatAvailable && exit)
        {
            jIncrement = 1;
        }
        else
        {
            jIncrement = 0;
        }
        return jIncrement;
    }

    public int getPrice()
    {
        return price;
    }

    public void seatChart()
    {
        System.out.print("Price:\n");
        for(int k = 0; k < Seats.length; k += 1)
        {
            System.out.print("$" + (k+1) + "0.00 |");
            for(int l = 0; l < Seats[k].length; l += 1)
            {
                if(SeatsAvailable[k][l] == 1)
                {
                    System.out.print(" " + Seats[k][l] + " |");
                }
                else
                {
                    System.out.print(" XX |");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void getReceipt(int j, int total, int i, String movieTitle)
    {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println(" Item              Amount   Cost");
        System.out.println("-----------------------------------------------");

        for(k = 0; k < i; k += 1)
        {
            setPrice(rows[k]);
            if(seatName[k].length() == 2)
            {
                System.out.println(" Seat: " + seatName[k] + "            1      $" + getPrice());
            }

        }

        System.out.println(" Movie.................... \"" + movieTitle + "\"");
        System.out.println(" ");
        System.out.println(" Total..................... $" + total);
        System.out.println(" ");
        System.out.println("Thank you for visiting Caldwell Grand Theater.");
        System.out.println("                 Come Again!                  ");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
    }

}