import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by myronamparo on 6/22/15.
 */
public class PageRankProject {

    public static void main(String [] args) throws Exception
    {
        //new PageRankProject
        PageRankProject pRP = new PageRankProject();

        //creates a new Database
        Database d = new Database();
        //d.createDatabase();
        //int amountOfFiles = d.getNumOfDocuments();

        String[] keywords = pRP.getKeywordsFromUser();
        DecimalFormat df = new DecimalFormat("#.####");

        for (int i = 0; i < 1; i++)
        {
            //File file = pRP.getFile(i);
            File file = new File("src/files/doc1.txt");
            System.out.println(df.format(pRP.getPercentage(keywords, file)));
        }
    }

    public String[] getKeywordsFromUser()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("How many keywords are you searching for? (Input as a number)");
        while (!in.hasNextInt())
        {
            in.next();
            System.out.println("Please enter a number.");
        }
        int numKeywords = in.nextInt();

        String[] keywords = new String[numKeywords];
        for (int i = 0; i < numKeywords; i++)
        {
            if (i == 0)
                System.out.println("Enter a keyword.");
            else
                System.out.println("Enter another keyword.");
            while (!in.hasNextLine())
            {
                in.next();
                System.out.println("Please enter a valid word.");
            }
            keywords[i] = in.next();
        }

        return keywords;
    }

    public double getPercentage(String[] keywords, File file) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(file));

        int occurrences = 0;
        String line;
        int x = 0;
        while ((line = br.readLine()) != null)
        {
            x++;
            for (int i = 0; i < keywords.length; i++)
            {
                if (line.equals(keywords[i]))
                    occurrences++;
            }
        }
        System.out.println(x);
        System.out.println(occurrences);
        return (((double)occurrences/x)*100);
    }

    /**
     * Returns the file that has the path that ends in the parameter number.
     *
     * @param number
     * @return
     */
    public File getFile(int number)
    {
        String pathName = "src/files/doc" + String.valueOf(number+1) + ".txt";
        File file = new File(pathName);
        return file;
    }
}
