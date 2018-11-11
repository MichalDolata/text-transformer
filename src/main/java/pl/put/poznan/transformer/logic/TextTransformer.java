package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        // of course normally it would to something based on transforms
        return text.toUpperCase();
    }
    
    /**
     * This function is used for transformation all letters to upper case.
     * @param text - Input string that will be changed
     * @return string where all letters in upper case
     */
    static String Upper(String text)
    {
	 return text.toUpperCase();
    }

    private String removeRepetitions(String sentence){
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(sentence.split(" ")));
        int number_of_words = words.size();
        int i = 0;
        while(i + 1 < number_of_words){
            char[] word1 = words.get(i).replaceAll("[^a-zA-Z ]", "").toLowerCase().toCharArray();
            char[] word2 = words.get(i+1).replaceAll("[^a-zA-Z ]", "").toLowerCase().toCharArray();
            if(Arrays.equals(word1, word2)){
                if(words.get(i).length() < words.get(i+1).length()){
                    words.remove(i);
                } else {
                    words.remove(i+1);
                }
                number_of_words--;
            }else {
                i++;
            }
        }
        return String.join(" ", words);
    }
}
