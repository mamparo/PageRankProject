import java.io.File;

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
        d.createDatabase();

        System.out.println(pRP.getFile(1).getAbsolutePath());
    }

    /**
     * Returns the file that has the path that ends in the parameter number.
     *
     * @param number
     * @return
     */
    public File getFile(int number)
    {
        String pathName = "src/files/doc" + String.valueOf(number) + ".txt";
        File file = new File(pathName);
        return file;
    }
}
