
public class mod_methods {
    private double MATpledges = 0; // Pledged amounts from Math members
    private int MAT = 0; // Math members
    private double ENGpledges = 0; // Pledged amounts from English members
    private int ENG = 0; // English members
    private double CSpledges = 0; // Pledged amounts from CS members
    private int CS = 0; // CS members
    private double pledges_total = 0; // Combing Pledges for a total

    public void set_members(String[] list, String[] name, String[] dep, int[] miles, double[] pledge, double[] pledge_total) {

        for(int i = 0; i < (list.length-1); i += 1)
        {
            if(pledge_total[i] > pledge_total[i + 1])
            {
                double num = pledge_total[i];
                pledge_total[i] = pledge_total[i + 1];
                pledge_total[i + 1] = num;

                String nombre = name[i];
                name[i] = name[i + 1];
                name[i + 1] = nombre;

                String depart = dep[i];
                dep[i] = dep[i + 1];
                dep[i + 1] = depart;

                int millas = miles[i];
                miles[i] = miles[i + 1];
                miles[i + 1] = millas;

                double tots = pledge[i];
                pledge[i] = pledge[i + 1];
                pledge[i + 1] = tots;

                i = -1;
            }
        }
    }

    public void set_pledges(String[] raceList, double[] totalPledge, String[] dept) {

        for(int i = 0; i < raceList.length; i += 1)
        {
            pledges_total += totalPledge[i];

            if(dept[i].equals("MAT"))
            {
                MATpledges += totalPledge[i];
                MAT += 1;
            }
            else
            if(dept[i].equals("ENG"))
            {
                ENGpledges += totalPledge[i];
                ENG += 1;
            }
            else
            {
                CSpledges += totalPledge[i];
                CS += 1;
            }
            //System.out.println(dept[i]);
        }
    }

    public void set_pledges(String[] raceList, String[] name, double[] totalPledge) {
        System.out.println("\n-------------------------------\nMembers & Their Pledged Amounts\n-------------------------------\n");
        for(int i = 0; i < raceList.length; i += 1)
        {
            System.out.println(name[i] + ": $" + totalPledge[i]);
        }
    }

    public void set_miles(String[] list, String[] name, int[] miles) {
        System.out.println("\n--------------------------\nMembers who walked 15 miles\n--------------------------\n");
        for(int i = 0; i < list.length; i += 1)
        {
            if(miles[i] >= 15)
            {
                System.out.println(name[i]);
            }
        }
    }

    public void totalandAvgPledges(String[] list)
    {
        System.out.println("\n-------\nPledges\n-------\n");
        System.out.println("Average pledge: $" + (pledges_total/list.length));
        System.out.println("Total pledges: $" + pledges_total);
    }

    public void dep_info()
    {
        System.out.println("\n-----------\nDepartments\n-----------\n");
        System.out.println("Math Department:\n Total Members: " + MAT + "\nTotal Pledges: $" + MATpledges);
        System.out.println("\nEnglish Department:\n Total Members: " + ENG + "\nTotal Pledges: $" + ENGpledges);
        System.out.println("\nComputer Science Department:\n Total Members: " + CS + "\nTotal Pledges: $" + CSpledges);

        System.out.println("\n---Winner---\n");
        if(MATpledges > CSpledges || MATpledges > ENGpledges)
        {
            System.out.print("The winner is the Math Department! Congratulations.\n");
        }
        else if(CSpledges > MATpledges || CSpledges > ENGpledges)
        {
            System.out.print("The winner is the Computer Science Department! Congratulations.\n");
        }
        else
        {
            System.out.print("The winner is the English Department! Congratulations.\n");
        }
    }
}
