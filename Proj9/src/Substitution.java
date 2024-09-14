/**
 * Substitution.java
 * Class implements interface TranslationMatrix to encrypt text from a file using a Substitution cipher
 * @author Dominic Cronauer
 */
public class Substitution implements TranslationMatrix {
    //Substitution alphabet and actual alphabet
    private static final String CIPHER = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * implemented method from TranslationMatrix.java
     * @param words words to translate
     * @return translated string
     */
    @Override
    public String translate(String[] words) {
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    int index = ALPHABET.indexOf(Character.toUpperCase(c));//find index in actual alphabet
                    char substituted = CIPHER.charAt(index);//get character from cipher alphabet
                    //maintain the original case
                    result.append(Character.isUpperCase(c) ? substituted : Character.toLowerCase(substituted));
                } else {
                    result.append(c);
                }
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}