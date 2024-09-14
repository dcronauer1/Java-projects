/**
 * A class that uses a TranslationMatrix to translate text.
 * @author Dominic Cronauer
 */
public class Translator {
    private TranslationMatrix matrix;

    /**
     * constructor that takes a translation matrix object
     * @param m the TranslationMatrix used
     */
    public Translator(TranslationMatrix m) {
        this.matrix = m;
    }

    /**
     * Translates the given text using the TranslationMatrix.
     *
     * @param text The text to be translated.
     * @return The translated text.
     */
    public String translateText(String text) {
        String[] words = text.split("\\s+");// "\\s+ splits based on whitespace characters, and doesn't care how many there are in a row
        return matrix.translate(words);
    }
}