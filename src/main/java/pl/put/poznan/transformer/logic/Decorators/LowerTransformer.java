package pl.put.poznan.transformer.logic.Decorators;

import pl.put.poznan.transformer.logic.TextTransformer;

public class LowerTransformer extends Decorator {

    public LowerTransformer(TextTransformer decorator){
        super(decorator);
    }

    /**
     * This function is used for transformation all letters to lower case.
     * @param text - Input string that will be changed
     * @return string where all letters in lower case
     */
    @Override
    public String transform(String text){
        logger.debug("LowerTransformer input: "+text);
        text = super.transform(text);
        text = text.toLowerCase();
        logger.debug("LowerTransformer output: "+text);
        return text;

    }

}