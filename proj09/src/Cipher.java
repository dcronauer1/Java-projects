import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Cipher.java
 * A class to handle program execution
 * @author Dominic Cronauer
 */
public class Cipher {
    /**
     * function main begins with program execution
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        TranslationMatrix matrix = null;
        //prompt user to select cipher
        System.out.println("Select a cipher (1: Caesar, 2: Substitution, 3: Vigenere):");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        //create appropriate TranslationMatrix
        switch (choice) {
            case 1:
                matrix = new Caesar();
                break;
            case 2:
                matrix = new Substitution();
                break;
            case 3:
                matrix = new Vigenere();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(1);
        }
        //create a Translator with the chosen cipher
        Translator translator = new Translator(matrix);
        //loop for file translation
        while (true) {
            System.out.println("Enter the file path (or 'quit' to exit):");
            String filePath = scanner.nextLine();
            //stop program execution
            if (filePath.equalsIgnoreCase("quit")) {
                break;
            }

            String content = readFile(filePath);
            if (content != null) {
                String translated = translator.translateText(content);
                System.out.println("Translated text:");
                System.out.println(translated);
            } else {
                System.out.println("Error reading file."); //should never see this
            }
        }

        scanner.close();
    }

    /**
     * Reads the content of a file.
     *
     * @param filePath The path to the file to be read.
     * @return The content of the file as a String, or null if an error occurred.
     */
    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }
}