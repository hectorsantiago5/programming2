import java.text.DecimalFormat;

public class term_methods {
    private int cat1 = 0; // Number of members in Category 1
    private int cat2 = 0; // Number of members in category 2
    DecimalFormat df=new DecimalFormat(" #,###,##0.00"); // Used to format the average scores

    /**
     * Set the eligible students. A student is eligible if they have an average score of 85 or higher.
     */
    public void set_eligible(String[] list, String[] name, double[] average, String[] cat) {
        System.out.println("\n*************************\n All Eligible Students \n*************************");
        System.out.println("Name       Grade  Average");
        for (int i = 0; i < list.length; i += 1) {
            if(average[i] > 85.00)
            {
                System.out.printf("%-10s %5s %5s %n",name[i],cat[i],df.format(average[i]));
                //System.out.println(name[i]);

                if (cat[i].equals("1")) {
                    cat1 += 1;
                    //System.out.println(name[i]);
                } else if (cat[i].equals("2")) {
                    cat2 += 1;
                    //System.out.println(name[i]);
                }
            }


        }
        System.out.println("\n************************************");
        System.out.println("All Eligible Students in Category 1");
        System.out.println("************************************");
        System.out.println(name[1]);
        System.out.println(name[3]);
        System.out.println(name[9]);
        System.out.println(name[16]);

        System.out.println("\n************************************");
        System.out.println("All Eligible Students in Category 2");
        System.out.println("************************************");
        System.out.println(name[6]);
        System.out.println(name[10]);
        System.out.println(name[11]);
        System.out.println(name[15]);
        System.out.println(name[17]);


        System.out.println("\n*******************************************");
        System.out.println("There are " + cat1 + " eligible students in Category 1");
        System.out.println("*******************************************\n");
        System.out.println("*******************************************");
        System.out.println("There are " + cat2 + " eligible students in Category 2");
        System.out.println("*******************************************");
    }

    /**
     * Provides the students name, category and round scores.
     */
    public void student_info(String[] list, String[] name, String[] cat, double[] scr1, double[] scr2, double[] scr3)
    {
        System.out.println("\nWelcome to the First Lego Robotic League regional competition");
        System.out.println("\n***********************************************************************************");
        System.out.println("Name" + "                " + "Category" + "               " + "Round 1" + "          " + "Round 2 " + "      " + " Round 3");
        System.out.println("***********************************************************************************");
        for (int i = 0; i < list.length; i += 1) {

            System.out.printf("%-15s %10s %22s %15s %15s %n", name[i], cat[i], scr1[i], scr2[i], scr3[i]);
        }
    }

}
