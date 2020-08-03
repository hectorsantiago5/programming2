import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class mod_demo
{
    public static void main(String[] args) throws Exception //throws Exception
    {
        FileReader file = new FileReader("march4babies.txt"); // File with the pledges data
        BufferedReader br = new BufferedReader(file); // reads the file
        mod_methods mm = new mod_methods(); // Connect to working class

        int members = 18; // Number of members / pledges that signed up

        String[] list = new String[members];
        String[] name = new String[members]; // Pledges names
        String[] dep = new String[members]; // Pledges departments
        int[] miles = new int[members]; // Miles walked by pledges
        double[] pledge = new double[members]; // Pledges made by members
        double[] pledge_total = new double[members]; // Total pledge amounts

        for(int i = 0; i < members; i += 1)
        {
            list[i] = br.readLine();

            StringTokenizer st = new StringTokenizer(list[i], ",");

            name[i] = st.nextToken();
            dep[i] = st.nextToken();
            miles[i] = Integer.parseInt(st.nextToken());
            pledge[i] = Double.parseDouble(st.nextToken());
            pledge_total[i] = (miles[i])*(pledge[i]);
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" Welcome to The College of Arts and Sciences at Caldwell State University.\n Today is our annual March of Dimes March for Babies!");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("\nHere are today's members: ");
        mm.set_members(list, name, dep, miles,  pledge, pledge_total);
        mm.set_pledges(list, name, pledge_total);
        mm.set_miles(list, name, miles);
        mm.set_pledges(list, pledge_total, dep);
        mm.totalandAvgPledges(list);
        mm.dep_info();

    }
}
