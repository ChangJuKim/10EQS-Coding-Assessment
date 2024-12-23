import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class analysis {

    private static final String PRODUCTS_FILE = "data/products.csv";

    public static void main(String[] args) {
        String[][] data = null;
        String input;

        if (args.length > 0) {
            input = PRODUCTS_FILE;
            data = attemptDataFromFile(input);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "Enter the file you wish to analyze. Enter 'default' (without quotes) to analyze the sample file");

            while (data == null) {
                input = scanner.nextLine();
                if (input.equals("default")) {
                    input = PRODUCTS_FILE;
                }
                data = attemptDataFromFile(input);
            }
            scanner.close();
        }

        System.out.println(Arrays.deepToString(data));
    }

    private static String[][] attemptDataFromFile(String fileName) {
        String[][] data = null;
        try {
            data = utils.getData(fileName);
        } catch (FileNotFoundException ex) {
            System.out.println("Please try again");
        }
        return data;
    }
}