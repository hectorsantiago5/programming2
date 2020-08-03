import java.util.Scanner;

public class CaldwellTheatersDemo
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        CaldwellTheaters ct = new CaldwellTheaters();

        String movieTitle;// Holds the title of the playing movie.
        int seatsLeft = 64;// Keeps track of the number of seats still available.
        long start;// Start time.
        long end;// Time the movie ends.
        long time;// Current time.
        long untilMovie = 0;// Time before the movie starts.
        long movieLength = 0;// Length of the movie in minutes.
        boolean untilMovieValidation = false;// Boolean used to make sure input for untilMovie is only accepted if it is a Long.
        boolean movieLengthValidation = false;// Boolean used to make sure input for movieLength is only accepted if it is a Long.

        System.out.println("What is the title of the movie?");
        movieTitle = scan.nextLine();

        System.out.println("How many minutes until the movie starts?");

        while(untilMovieValidation == false)
        {
            try
            {
                untilMovie = Long.parseLong(new Scanner(System.in).next());
                untilMovieValidation = true;
            }
            catch(NumberFormatException ne)
            {
                System.out.println("Invalid input. Please enter a whole number.\nHow many minutes until the movie start?");
                untilMovieValidation = false;
            }
        }

        System.out.println("How long is the movie in minutes?");

        while(movieLengthValidation == false)
        {
            try
            {
                movieLength = Long.parseLong(new Scanner(System.in).next());
                movieLengthValidation = true;
            }
            catch(NumberFormatException ne)
            {
                System.out.println("Invalid input. Please enter a whole number.\nHow long is the movie in minutes?");
                movieLengthValidation = false;
            }
        }

        start = System.currentTimeMillis();// Current time in ms, counts from midnight.
        end = start + (60*1000)*untilMovie + (60*1000)*movieLength;// Calculated time of day when timer is up.

        while(start <= end)
        {
            ct.timer(end);

            int i = 0;// The number of tickets someone wants to purchase.
            boolean iValidation = false;// Boolean used to make sure input for i is only accepted if it is an int.
            boolean exit = true;// Boolean used to end a purchase early.
            int j = 0;// Control variable for the do-while loop.
            int total = 0;// Total price of all tickets purchased.
            int row;// the row of a 2D array, like array[row][].
            int col;// the column of a 2D array, like array[][column].
            String hi; // String input for seat choice

            System.out.println("\n\nHi there! Welcome to The Caldwell Grand Theater!\n");
            ct.timer(end);
            System.out.println("Row A is the front row and row H is the back row.\n");

            System.out.println("************************************************\n                 Caldwell Theater       \n************************************************");
            ct.seatChart();
            ct.movieTimes(untilMovie, movieLength, movieTitle, end);

            ct.timer(end);
            System.out.println("\nHow many seats do you want to purchase?");

            while(iValidation == false)
            {
                try
                {
                    i = Integer.parseInt(new Scanner(System.in).next());
                    if(i < 1 || i > 64 || i > seatsLeft)
                    {
                        i = Integer.parseInt("notAnInt");
                    }
                    iValidation = true;
                }
                catch(NumberFormatException ne)
                {
                    if(seatsLeft > 1 && i > 0)
                    {
                        System.out.println("Sorry, but there are only " + seatsLeft + " seats available.\nHow many seats do you want to purchase?");
                    }
                    else if(seatsLeft == 1)
                    {
                        System.out.println("Sorry, but there is only " + seatsLeft + " seat available.");
                    }
                    else if(seatsLeft == 0)
                    {
                        System.out.println("Sorry, but there are no more seats available. Please\nask an attendee for information on future showings.");
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("Invalid input. Please enter a whole number between 1 and 64.\nHow many seats do you want to purchase? (maximum of 5 tickets per customer)");
                    }

                    iValidation = false;
                }
            }


            do
            {
                ct.sleep(250);
                ct.timer(end);
                System.out.println("\nWhat seat would you like? (Enter \"Exit\" to end transaction now)");
                hi = scan.next().toUpperCase();
                System.out.print("\n");

                System.out.println("- - - - - - - - - - - - - - - - - -");
                ct.sleep(250);
                ct.timer(end);

                if(hi.equals("EXIT"))
                {
                    i = j;
                    exit = false;
                }
                else
                {
                    ct.seatChoice(hi, j);
                }

                if(exit)
                {
                    total += ct.getPrice();
                }
                else
                {
                }

                ct.sleep(250);
                j += ct.seatAvailable(exit);
                seatsLeft -= ct.seatAvailable(exit);

                if(j == i && j != 0)
                {
                    System.out.print("\nHere is your receipt:");
                }

                if(j == i && j != 0)
                {
                    System.out.print("\n\n************************************************\n                 Caldwell Theater       \n************************************************\n");
                    ct.getReceipt(j, total, i, movieTitle);
                }
                else if(j != i && exit)
                {
                    System.out.print("\n\n************************************************\n                 Caldwell Theater       \n************************************************\n");
                    ct.seatChart();
                }

            }
            while(j < i);

            ct.timer(end);
        }
    }
}