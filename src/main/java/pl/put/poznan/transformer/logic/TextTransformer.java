package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.constraints.Null;
import java.util.*;


public class TextTransformer {
    private static final Logger logger = LoggerFactory.getLogger(TextTransformer.class);

    private final String[] transforms;

    public TextTransformer(String[] transforms) {
        this.transforms = transforms;
    }

    /**
     * This function prefroms transformations given in constructor on given text
     * @param text - input string
     * @return input string after transformations
     */
    public String transform(String text) {
        for (String transform: this.transforms) {
            logger.debug("Current: " + transform.toLowerCase() + ": " + text);
            switch (transform.toLowerCase()) {
                case "upper":
                    text = this.upper(text);
                    break;
                case "lower":
                    text = this.lower(text);
                    break;
                case "capital":
                    text = this.capital(text);
                    break;
                case "removerepetitions":
                    text = this.removeRepetitions(text);
                    break;
                case "latex":
                    text = this.transformLatext(text);
                    break;
                case "expand":
                    text = this.transformAbbreviationToWords(text);
                    break;
                case "abbreviate":
                    text = this.transformWordsToAbbreviation(text);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            logger.debug("Result: " + text);
        }

        return text;
    }
    
    /**
     * This function is used for transformation all letters to upper case.
     * @param text - Input string that will be changed
     * @return string where all letters in upper case
     */
    private String upper(String text){
	 return text.toUpperCase();
    }

    /**
     * This function is used for transformation all letters to lower case.
     * @param text - Input string that will be changed
     * @return string where all letters in lower case
     */
    private String lower(String text){	
         return text.toLowerCase();
    }
	
    /**
     * This function is used for transformation onle the first letter in each sentence to upper case.
     * @param text - Input string that will be changed
     * @return string where onle the first letter in each sentence in upper case
     */
    private String capital(String text){
    	char lit[] = text.toCharArray();

        boolean cap = true;
        for (int i = 0; i < text.length(); i++){
            if((lit[i] == '.')||(lit[i] == '?')||(lit[i] == '!')){
                cap = true;
            }else if ((cap)&&(lit[i] != ' ')){
                if((lit[i] >= 97) && (lit[i] <= 122))
                    lit[i]-=32;
                cap = false;
            }
        }

        return String.valueOf(lit);
    }

    /**
     * This function is used to remove repeating words.
     *
     * @param text - Input string that will be changed
     * @return string where all neighboring repetitions are removed
     */
    private String removeRepetitions(String sentence) {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(sentence.split(" ")));
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
        return String.join(" ", words);
    }

    private String replaceWithMap(String str, Map<String,String> map) {
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            String temp = str.toLowerCase();
            str = str.replaceAll("\\b"+entry.getKey()+"\\b",entry.getValue());
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

    /**
     * Transform all abbreviations inside ABBREVIATION_TO_WORDS_MAPS to their longer form
     * @param str  a text to will be transformed
     * @return     transformed text
     */
    private String transformAbbreviationToWords(String str)
    {
        return replaceWithMap(str, ABBREVIATION_TO_WORDS_MAP);
    }

    /**
     * Map used to replace sequence of words to corresponding abbreviation
     */
    private static final Map<String,String> WORDS_TO_ABBREVIATION_MAP = Collections.unmodifiableMap(
            new HashMap<String,String>(){{
                put("profesor","prof.");
                put("Profesor","Prof.");
                put("doktor", "dr");
                put("Doktor", "Dr");
                put("na przykład", "np.");
                put("Na przykład", "Np.");
                put("i tym podobne", "itd.");
                put("I tym podobne", "Itd.");
                put("między innymi", "m.in");
                put("Między innymi", "M.in");
            }}
    );

    /**
     * Transform some sequence of words that corresponds to element of WORDS_TO_ABBREVIATION_MAPS to abbreviation
     * @param str  a text to will be transformed
     * @return     transformed text
     */
    private String transformWordsToAbbreviation(String str)
    {
        return replaceWithMap(str, WORDS_TO_ABBREVIATION_MAP);
    }

}
