import java.util.Scanner;

/**
 * Vigenere.java
 * Class implements interface TranslationMatrix to encrypt text from a file using a Vigenere cipher.
 * A key must also be passed in from console
 * @author Dominic Cronauer
 */
public class Vigenere implements TranslationMatrix {
    private String key;

    /**
     * constructor to prompt user for a key
     */
    public Vigenere() {
        Scanner scanner = new Scanner(System.in);
        String inputKey;
        do {
            System.out.print("Enter the Vigenere key (letters only): ");
            //replace invalid characters with nothing
            inputKey = scanner.nextLine().replaceAll("[^A-Za-z]", "").toUpperCase();
        } while (inputKey.isEmpty());
        this.key = inputKey;
        System.out.println("Key accepted: " + this.key);
    }
    /**
     * implemented method from TranslationMatrix.java
     * @param words words to translate
     * @return translated string
     */
    @Override
    public String translate(String[] words) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    //determine if the character is uppercase or lowercase
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    //calculate the shift based on the current key character
                    int shift = key.charAt(keyIndex) - 'A';
                    //apply the Vigenere encryption
                    char encrypted = (char) (((c - base + shift) % 26) + base);
                    //move to the next key character, wrapping around if necessary
                    result.append(encrypted);
                    keyIndex = (keyIndex + 1) % key.length();
                } else {
                    //if not a letter, append the character as is
                    result.append(c);
                }
            }
            result.append(" ");
        }
        return result.toString().trim(); //remove trailing space
    }
}