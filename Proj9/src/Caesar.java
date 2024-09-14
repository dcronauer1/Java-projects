/**
 * Caesar.java
 * Class implements interface TranslationMatrix to encrypt text from a file using a Caesar cipher
 * @author Dominic Cronauer
 */
public class Caesar implements TranslationMatrix {
    //shift constant
    private static final int SHIFT = 3;
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
                    //determine if character is upper or lowercase
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    //apply caesar shift, formula ensures proper wrapping around alphabet
                    char shifted = (char) (((c - base - SHIFT + 26) % 26) + base);
                    result.append(shifted);
                } else {
                    //not a letter, return as-is
                    result.append(c);
                }
            }
            result.append(" "); //add a space after each word
        }
        //remove trailing space & return
        return result.toString().trim();
    }
}