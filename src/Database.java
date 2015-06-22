import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by parthpendurkar on 6/20/15.
 */
public class Database
{
    private String[] words;

    /**
     * Constructor for objects of class Database. Initializes the words
     * instance variable to every word in the "englishwords.txt" file,
     * which contain the 1000 most used words in the English language.
     *
     * @throws Exception    if the file is not found
     */
    public Database() throws Exception
    {
        words = new String[1000];
        File file = new File("src/englishwords.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        int i = 0;
        String line;
        while ((line = br.readLine()) != null)
        {
            words[i] = line;
            i++;
        }
    }

    /**
     * Generates one text file
     *
     * @param docNumber the number that will be assigned to the doc
     */
    public void generateTextFile(int docNumber, int count) throws Exception
    {
        String fileName = "src/files/doc" + String.valueOf(docNumber+1) + ".txt";
        PrintWriter writer = new PrintWriter(new File(fileName));

        for (int i = 0; i < count; i++)
        {
            writer.println(chooseRandomWord());
        }
        writer.close();
    }

    /**
     * Gets a random index and returns the String at that index in the array words.
     *
     * @return  randomly chosen String from words.
     */
    public String chooseRandomWord()
    {
        return words[(int) (Math.random() * (words.length))];
    }

    /**
     * Main method. Asks user input for number of files desired in database, and amount of words per file.
     */
    public void createDatabase() throws Exception
    {
        Scanner in = new Scanner(System.in);
        System.out.println("How many files do you want in the database?");
        while (!in.hasNextInt())
        {
            in.next();
            System.out.println("Please enter a number.");
        }
        int files = Math.abs(in.nextInt());

        System.out.println("How many words do you want per file?");
        while (!in.hasNextInt())
        {
            in.next();
            System.out.println("Please enter a number.");
        }
        int count = Math.abs(in.nextInt());

        for (int i = 0; i < files; i++)
        {
            generateTextFile(i, count);
        }
    }
}
