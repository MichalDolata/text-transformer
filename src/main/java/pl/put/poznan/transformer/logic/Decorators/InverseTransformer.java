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
     * @param text Input String
     * @return reversed string
     */
    @Override
    public String transform(String text){
        logger.debug("InverseTransformer input: "+text);
        text = super.transform(text);
        char lit[] = text.toCharArray();
        char tmp;
        int i = 0;

        int j = text.length()-1;
        while(i < j) {
            tmp = lit[i];
            lit[i] = lit[j];
            lit[j] = tmp;
            i++;
            j--;
        }
	logger.debug("InverseTransformer output: "+String.valueOf(lit));
        return String.valueOf(lit);
    }

}
