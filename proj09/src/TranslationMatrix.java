/**
 * TranslationMatrix.java
 * Interface for ciphers to use.
 * @author Dominic Cronauer
 */
public interface TranslationMatrix {
    /**
     * method takes an array of words and returns the translated string
     * @param words words to translate
     * @return translated string
     */
    public String translate(String[] words);

}
