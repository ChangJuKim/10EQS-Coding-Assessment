import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class utils {
    public static String[][] getData(String fileName) throws FileNotFoundException {
        List<String> list = new ArrayList<>();

        try {
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                list.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist");
            throw ex;
        }

        return parseToArray(list);
    }

    /**
     * Separates a list of comma separated values into a 2D array
     * 
     * @param list a list of comma separated values
     * @return the data separated into a 2D array
     */
    private static String[][] parseToArray(List<String> list) {
        String[][] array = new String[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            array[i] = parseLine(list.get(i));
        }

        return array;
    }

    /**
     * Separates a single line with comma separated data and returns an array of the
     * data
     * 
     * @param data a line with comma separated values
     * @return the values in an array
     */
    private static String[] parseLine(String line) {
        return line.split(",");
    }
}
