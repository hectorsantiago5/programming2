import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class term_demo {
    public static void main(String[] args) throws Exception //throws Exception
    {
        FileReader file = new FileReader("ROBOT.txt"); // File with the students data
        BufferedReader br = new BufferedReader(file); // reads the file
        term_methods tm = new term_methods(); // Connect to working class

        int students = 20; // Number of students in competition

        String[] list = new String[students];
        String[] name = new String[students]; // Students names
        String[] cat = new String[students]; // Category each student is in
        double[] score1 = new double[students]; // 1st round score
        double[] score2 = new double[students]; // 2nd round score
        double[] score3 = new double[students]; // 3rd round score
        double[] avrg = new double [students];

        for (int i = 0; i < students; i += 1) {
            list[i] = br.readLine();

            StringTokenizer st = new StringTokenizer(list[i], ",");

            name[i] = st.nextToken();
            cat[i] = st.nextToken();
            score1[i] = Integer.parseInt(st.nextToken());
            score2[i] = Integer.parseInt(st.nextToken());
            score3[i] = Integer.parseInt(st.nextToken());
            avrg[i] = (score1[i] + score2[i] + score3[i]) / 3.0;
        }

        tm.student_info(list,name,cat,score1,score2,score3);
        tm.set_eligible(list, name, avrg, cat);
    }
}
