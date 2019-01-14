package pl.put.poznan.transformer.logic.Decorators;

import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.ArrayList;
import java.util.Arrays;

public class InverseTransformer extends Decorator {
    public InverseTransformer(TextTransformer decorator){
        super(decorator);
    }
    /**
     * This function is used for inversing text on chosen position.
     * @param text - Input string that will be changed
     */
    @Override
    public String transform(String text){
        logger.debug("InverseTransformer input: "+text);
        text = super.transform(text);
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(text.split(" ")));
        int number_of_words = words.size();
        int i = 0;
        while (i  < number_of_words) {
            String word1 = words.get(i);
            words.set(i, this.inverse(word1));
            i++;

        }

        text = String.join(" ", words);
        logger.debug("InverseTransformer output: "+text);
        return text;

    }

    /**
     *  This function inverse word.
     * @param text Input String
     * @return reversed string
     */
    private String inverse(String text){
        char lit[] = text.toCharArray();
        char tmp;
        int i = 0;
        int j = text.length() - 1;
        while(i < j) {
            tmp = lit[i];
            lit[i] = lit[j];
            lit[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(lit);
    }

}
