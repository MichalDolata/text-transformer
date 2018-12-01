package pl.put.poznan.transformer.logic.Decorators;

import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.ArrayList;
import java.util.Arrays;

public class RepetitionTransformer extends Decorator {
    public RepetitionTransformer(TextTransformer decorator){
        super(decorator);
    }

    /**
     * This function is used to remove repeating words.
     *
     * @param text - Input string that will be changed
     * @return string where all neighboring repetitions are removed
     */
    @Override
    public String transform(String text) {
    logger.debug("RepetitionTransformer input: "+text);
    text = super.transform(text);

    ArrayList<String> words = new ArrayList<String>(Arrays.asList(text.split(" ")));
    int number_of_words = words.size();
    int i = 0;
    while (i + 1 < number_of_words) {
        char[] word1 = words.get(i).replaceAll("[^a-zA-Z ]", "").toLowerCase().toCharArray();
        char[] word2 = words.get(i + 1).replaceAll("[^a-zA-Z ]", "").toLowerCase().toCharArray();
        if (Arrays.equals(word1, word2)) {
            if (words.get(i).length() < words.get(i + 1).length()) {
                words.remove(i);
            } else {
                words.remove(i + 1);
            }
            number_of_words--;
        } else {
            i++;
        }
    }

    text = String.join(" ", words);
    logger.debug("RepetitionTransformer output: "+text);
    return String.join(" ", words);
    }
}
