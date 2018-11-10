package pl.put.poznan.transformer.logic;


import javax.validation.constraints.Null;
import java.util.*;

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

    private String replaceWithMap(String str, Map<String,String> map) {
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            String temp = str.toLowerCase();
            str = str.replaceAll(""+entry.getKey(),entry.getValue());
        }
        return str;
    }

    /**
     * Map used to replace special LaText characters.
     */
    private static final Map<String,String> LATEXT_MAP= Collections.unmodifiableMap(
            new HashMap<String,String>() {{
                put("%","\\%");
                put("$","\\$");
                put("{","\\{");
                put("}","\\}");
                put("_","\\_");
                put("|","\\textbar");
                put(">","\\textgreater");
                put("<","\\textbackslash");
                put("&","\\&");
            }});

    /**
     * Returns text that can be safely used in LaText environment.
     * @param str  a text to will be transformed
     * @return     transformed text
     */
    private String transformLatext(String str){
        return replaceWithMap(str,LATEXT_MAP);
    }
    /**
     * Map used to replace abbreviation to long forms.
     */
    private static final Map<String,String> ABBREVIATION_TO_WORDS_MAP = Collections.unmodifiableMap(
      new HashMap<String,String>(){{
          put("prof.", "profesor");
          put("Prof.", "Profesor");
          put("dr", "doktor");
          put("Dr", "Doktor");
          put("np.", "na przykład");
          put("Np.", "Na przykład");
          put("itd.", "i tym podobne");
          put("Itd.", "I tym podobne");
          put("m.in", "między innymi");
          put("M.in", "Między innymi");
      }}
    );
    private String transformAbbreviationToWords(String str)
    {
        return replaceWithMap(str, ABBREVIATION_TO_WORDS_MAP);
    }


}
